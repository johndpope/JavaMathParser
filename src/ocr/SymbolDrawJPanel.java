/*******************************************************************************
 * Copyright 2013 Robert Ying, based on code by Ernesto Tapias
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
/**
 * \uFFFDberschrift: <p>
 * Beschreibung: <p>
 * Copyright: Copyright (c) <p>
 * Organisation: <p>
 * @author
 * @version 1.0
 */

package ocr;

import java.util.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import javax.swing.*;

import awt.*;

public class SymbolDrawJPanel extends DrawJPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8195394183497405746L;
	public ArrayList<Symbol> strokeMemory = new ArrayList<Symbol>();
	public Symbol symbolStrokeMemory = new Symbol();
	public DStroke dstroke;
	public Color drawColor = Color.white;
	public Point prev;
	public Point first;
	public float drawRadius = 4.0f;
	public float pointRadius = 4.0f;
	public float initialPointRadius = 6.0f;
	public boolean drawable = false;
	public boolean showpreprocessed = true;
	public boolean debug = false;

	public boolean noname = false;

	public boolean drawInitialPoint = false;

	public boolean editMode = false;
	public boolean editStrokeMode = false;
	public Color editColor = Color.red; // new Color(71,71,71);
	public DStroke editStroke = null;
	public Color pointColor = Color.black;
	public Color strokeColor = Color.black;
	public Color initialPointColor = Color.blue;
	public float strokeRadius = 2.0f;

	public float eps;

	public static boolean drawBackgroundImage = false;

	public static boolean netviewerMode = false;

	public final int NO_MODE = -1;
	public final int DRAW_MODE = 0;
	public final int SELECT_MODE = 1;
	public final int CLOSED_STROKE_SELECT_MODE = 2;
	public final int OPEN_CLOSED_STROKE_SELECT_MODE = 3;
	public final int MOVE_MODE = 4;
	private int drawMode = -1;
	// private int lastDrawMode;

	private Cursor drawingCursor;
	private Cursor selectingCursor;
	private Cursor closedStrokeSelectingCursor;
	private Cursor openStrokeSelectingCursor;
	private Cursor openedHandCursor;
	private Cursor closedHandCursor;
	// private Cursor lastCursor;

	public boolean[][] strokeSelectedIndexes;
	public boolean[] symbolSelectedIndexes;
	// public BoundingBox[][] strokeSelectedBoundingBox;
	// public BoundingBox[] symbolSelectedBoundingBox;

	private BufferedImage drawImage;
	private BufferedImage moveImage;
	private Graphics2D drawGraphics;

	private DStroke inputStroke;
	private boolean symbolSelected;
	private boolean strokeSelected;

	private int deltaX;
	private int deltaY;

	Symbol s = null;

	public SymbolDrawJPanel(int width, int height, boolean ubi) {
		super(width, height, ubi);
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public SymbolDrawJPanel(int width, int height) {
		super(width, height);
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void jbInit() throws Exception {
		eps = 1.75f * this.drawRadius;

		// icons/ArrowCursor16.bmp icons/SelectCursor16.gif
		// icons/ArrowCursor.bmp icons/SelectOpenStrokeCursor16.gif
		// icons/DrawCursor16.gif icons/SelectStrokeCursor16.gif

		drawingCursor = Toolkit.getDefaultToolkit()
				.createCustomCursor(
						Toolkit.getDefaultToolkit().createImage(
								"icons/DrawCursor.gif"), new Point(1, 14),
						"DrawingCursor");
		selectingCursor = Toolkit.getDefaultToolkit().createCustomCursor(
				Toolkit.getDefaultToolkit().createImage(
						"icons/SelectCursor16.gif"), new Point(1, 1),
				"SelectCursor");
		closedStrokeSelectingCursor = Toolkit.getDefaultToolkit()
				.createCustomCursor(
						Toolkit.getDefaultToolkit().createImage(
								"icons/SelectOpenStrokeCursor16.gif"),
						new Point(1, 1), "SelectOpenStrokeCursor");
		openStrokeSelectingCursor = Toolkit.getDefaultToolkit()
				.createCustomCursor(
						Toolkit.getDefaultToolkit().createImage(
								"icons/SelectOpenStrokeCursor16.gif"),
						new Point(1, 1), "SelectOpenStrokeCursor");
		/*
		 * openedHandCursor = Toolkit.getDefaultToolkit().createCustomCursor(
		 * Toolkit.getDefaultToolkit().createImage(
		 * "icons/OpenedHandCursor.gif"), new Point(16, 17), "MoveCursor");
		 * closedHandCursor = Toolkit.getDefaultToolkit().createCustomCursor(
		 * Toolkit.getDefaultToolkit().createImage(
		 * "icons/ClosedHandCursor.gif"), new Point(16, 17), "MoveCursor");
		 */
		openedHandCursor = new Cursor(Cursor.HAND_CURSOR);
		closedHandCursor = new Cursor(Cursor.MOVE_CURSOR);

		this.updateCursor();

		this.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				this_mouseReleased(e);
			}
		});
		this.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				this_mouseDragged(e);
			}
		});
		this.addMouseListener(new java.awt.event.MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				this_mousePressed(e);
			}
		});
		this.addMouseMotionListener(new SymbolDrawJPanel_this_mouseMotionAdapter(
				this));
	}

	private void updateCursor() {
		if (this.isDrawing()) {
			this.setCursor(this.drawingCursor);
		} else if (this.isSymbolSelecting()) {
			this.setCursor(this.selectingCursor);
		} else if (this.isClosedStrokeSelecting()) {
			this.setCursor(this.closedStrokeSelectingCursor);
		} else if (this.isOpenStrokeSelecting()) {
			this.setCursor(this.openStrokeSelectingCursor);
		} else if (this.isMoving()) {
			this.setCursor(this.openedHandCursor);
		}
		/*
		 * else { this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); }
		 */
	}

	public void draw() {
		// try {
		this.drawStrokeMemory();
		// convertToData(this.strokeMemory);
		// }
		// catch(IOException ex) {}
	}

	public DStroke getLastDStroke() {
		return dstroke;
	}

	public DStroke getInputStroke() {
		return inputStroke;
	}

	public void setInputStroke(DStroke ds) {
		inputStroke = ds;
	}

	public void setStrokeMemory(ArrayList<Symbol> s) {
		strokeMemory = s;
		this.drawStrokeMemory();
	}

	public void setStrokeMemory(ArrayList<Symbol> s, Image img) {
		strokeMemory = s;
		this.drawStrokeMemory(img);
	}

	public ArrayList<Symbol> getStrokeMemory() {
		return this.strokeMemory;
	}

	public void setEditMode(boolean e) {
		editMode = e;
		this.updateCursor();
	}

	public boolean isEditMode() {
		return editMode;
	}

	public void setDrawing() {
		this.drawMode = this.DRAW_MODE;
		this.updateCursor();
	}

	public boolean isDrawing() {
		return this.drawMode == this.DRAW_MODE;
	}

	public void setSymbolSelecting() {
		this.drawMode = this.SELECT_MODE;
		this.updateCursor();
	}

	public boolean isSymbolSelecting() {
		return this.drawMode == this.SELECT_MODE;
	}

	public boolean isSelecting() {
		return isSymbolSelecting() || isClosedStrokeSelecting()
				|| isOpenStrokeSelecting();
	}

	public boolean isSomethingSelected() {
		return this.symbolSelected || this.strokeSelected;
	}

	public void setClosedStrokeSelecting() {
		this.drawMode = this.CLOSED_STROKE_SELECT_MODE;
		this.updateCursor();
	}

	public boolean isClosedStrokeSelecting() {
		return this.drawMode == this.CLOSED_STROKE_SELECT_MODE;
	}

	public void setOpenStrokeSelecting() {
		this.drawMode = this.OPEN_CLOSED_STROKE_SELECT_MODE;
		this.updateCursor();
	}

	public boolean isOpenStrokeSelecting() {
		return this.drawMode == this.OPEN_CLOSED_STROKE_SELECT_MODE;
	}

	public void setMoving() {
		this.drawMode = this.MOVE_MODE;
		this.updateCursor();
	}

	public boolean isMoving() {
		return this.drawMode == this.MOVE_MODE;
	}

	public int getDrawMode() {
		return this.drawMode;
	}

	public void setDrawMode(int dm) {
		this.drawMode = dm;
		this.updateCursor();
	}

	public void setEditColor(Color c) {
		editColor = c;
	}

	public Color getEditColor() {
		return editColor;
	}

	public DStroke getEditStroke() {
		return editStroke;
	}

	public void setDrawable(boolean d) {
		drawable = d;
	}

	public void setDrawRadius(float r) {
		drawRadius = r;
	}

	public float getDrawRadius() {
		return drawRadius;
	}

	public float getPointRadius() {
		return pointRadius;
	}

	public void setPointRadius(float r) {
		pointRadius = r;
	}

	public float getInitialPointRadius() {
		return initialPointRadius;
	}

	public void setInitialPointRadius(float r) {
		initialPointRadius = r;
	}

	public void setDrawColor(Color c) {
		drawColor = c;
	}

	public boolean showPreprocessed() {
		return showpreprocessed;
	}

	public void setShowPreprocessed(boolean b) {
		showpreprocessed = b;
	}

	public Color getDrawColor() {
		return drawColor;
	}

	public boolean isDrawable() {
		return drawable || this.getDrawMode() != this.NO_MODE;
	}

	public void setDrawInitialPoint(boolean b) {
		drawInitialPoint = b;
	}

	public boolean drawInitialPoint() {
		return drawInitialPoint;
	}

	public int getDeltaX() {
		return this.deltaX;
	}

	public int getDeltaY() {
		return this.deltaY;
	}

	/*
	 * public void paint(Graphics g) { super.paint(g); if(this.strokeSelected) {
	 * for(int i = 0; i < strokeSelectedIndexes.length; i++) { for(int j = 0; j
	 * < strokeSelectedIndexes[i].length; j++) { if(strokeSelectedIndexes[i][j])
	 * { ((Symbol)this.strokeMemory.get(i)).strokeAt(j).
	 * drawBoundingBox(this.getGraphics2D(), this.editColor); } } } }
	 * if(this.symbolSelected) { this.drawStrokeMemory(); for(int i = 0; i <
	 * symbolSelectedIndexes.length; i++) { if(symbolSelectedIndexes[i]) {
	 * ((Symbol)this.strokeMemory.get(i)).drawBoundingBox(this. getGraphics2D(),
	 * this.editColor); } } } }
	 */

	public void delete() {
		strokeMemory.clear();
		this.symbolStrokeMemory.clear();
		this.erase();
	}

	public void undo() {
		if (!strokeMemory.isEmpty()) {
			strokeMemory.remove(strokeMemory.size() - 1);
		}
		this.drawStrokeMemory();
	}

	public boolean isUsingOpenedHandCursor() {
		return this.getCursor().equals(this.openedHandCursor);
	}

	public void drawStrokeMemory() {
		this.erase();

		for (int i = 0; i < this.strokeMemory.size(); i++) {
			strokeMemory.get(i).draw(this.getGraphics2D());
		}
		// this.drawStrokeMemorySelectedStrokes();
		// this.drawStrokeMemorySelectedSymbols();
		repaint();
		/*
		 * if(this.strokeSelected) { for(int i = 0; i <
		 * strokeSelectedIndexes.length; i++) { for(int j = 0; j <
		 * strokeSelectedIndexes[i].length; j++) {
		 * if(strokeSelectedIndexes[i][j]) {
		 * ((Symbol)this.strokeMemory.get(i)).strokeAt(j).
		 * drawBoundingBox(this.getGraphics2D(), this.editColor); } } } }
		 * if(this.symbolSelected) { this.drawStrokeMemory(); for(int i = 0; i <
		 * symbolSelectedIndexes.length; i++) { if(symbolSelectedIndexes[i]) {
		 * ((Symbol)this.strokeMemory.get(i)).drawBoundingBox(this.
		 * getGraphics2D(), this.editColor); } } } repaint();
		 */
	}

	public void drawStrokeMemory(Image img) {
		if (SymbolDrawJPanel.drawBackgroundImage) {
			this.drawImage(img, 0, 0);
		} else {
			this.erase();
		}

		for (int i = 0; i < this.strokeMemory.size(); i++) {
			strokeMemory.get(i).draw(this.getGraphics2D());
		}
		// this.drawStrokeMemorySelectedStrokes();
		// this.drawStrokeMemorySelectedSymbols();
		/*
		 * if(this.strokeSelected) { for(int i = 0; i <
		 * strokeSelectedIndexes.length; i++) { for(int j = 0; j <
		 * strokeSelectedIndexes[i].length; j++) {
		 * if(strokeSelectedIndexes[i][j]) {
		 * ((Symbol)this.strokeMemory.get(i)).strokeAt(j).
		 * drawBoundingBox(this.getGraphics2D(), this.editColor); } } } }
		 * if(this.symbolSelected) { this.drawStrokeMemory(); for(int i = 0; i <
		 * symbolSelectedIndexes.length; i++) { if(symbolSelectedIndexes[i]) {
		 * ((Symbol)this.strokeMemory.get(i)).drawBoundingBox(this.
		 * getGraphics2D(), this.editColor); } } } repaint();
		 */
	}

	public void drawStroke(DStroke s, float r, Color c, float rp, Color cp) {
		DPoint prev;
		int i;

		if (s.isEmpty()) {
			return;
		}

		prev = s.first();
		for (i = 1; i < s.size(); i++) {
			this.drawSegment(prev, s.pointAt(i), r, c);
			prev = s.pointAt(i);
		}

		if (rp > 0.0f) {
			for (i = 0; i < s.size(); i++) {
				this.drawPoint(s.pointAt(i), rp, cp);
			}
			if (drawInitialPoint) {
				this.drawPoint(s.pointAt(0), this.initialPointRadius,
						initialPointColor);
			}

		}
	}

	public boolean selectStrokeIndex() {
		boolean selected = false;
		Symbol s;
		DStroke ds;
		int i, j;

		if (this.strokeMemory.isEmpty()) {
			this.symbolSelected = false;
			return this.strokeSelected = false;
		}

		strokeSelectedIndexes = new boolean[this.strokeMemory.size()][];
		// strokeSelectedBoundingBox = new
		// BoundingBox[this.strokeMemory.size()][];
		for (i = 0; i < this.strokeMemory.size(); i++) {
			s = this.strokeMemory.get(i);
			strokeSelectedIndexes[i] = new boolean[s.size()];
			// strokeSelectedBoundingBox[i] = new BoundingBox[s.size()];
			for (j = 0; j < s.size(); j++) {
				ds = (s.size() < 16) ? s.strokeAt(j) : s.strokeAt(j)
						.proyectionPolygonal(16);
				s.strokeAt(j);
				strokeSelectedIndexes[i][j] = inputStroke.intersects(ds,
						Math.max(DStroke.r, DStroke.r));

				selected = selected || strokeSelectedIndexes[i][j];
				/*
				 * strokeSelectedBoundingBox[i][j] = new BoundingBox(
				 * (int)ds.minX, (int)ds.minY, (int)ds.getWidth(),
				 * (int)ds.getHeight(), 1.75f);
				 */
			}
		}

		this.strokeSelected = selected;
		this.symbolSelected = false;

		return selected;
	}

	public void deselectStrokesAndSymbols() {
		this.setStrokeSelectedIndexes(null, false);
		this.setSymbolSelectedIndexes(null, false);
	}

	public boolean selectSymbolIndex() {
		boolean selected = false;
		Symbol s;
		// DStroke ds;
		int i, j;

		if (this.strokeMemory.isEmpty()) {
			this.strokeSelected = false;
			return this.symbolSelected = false;
		}

		symbolSelectedIndexes = new boolean[this.strokeMemory.size()];
		// symbolSelectedBoundingBox = new
		// BoundingBox[this.strokeMemory.size()];
		for (i = 0; i < this.strokeMemory.size(); i++) {
			s = this.strokeMemory.get(i);
			for (j = 0; j < s.size(); j++) {
				s.strokeAt(j);
				if (inputStroke.boundigBoxIntersection(s.strokeAt(j),
						Math.max(DStroke.r, DStroke.r))) {
					s.strokeAt(j);
					symbolSelectedIndexes[i] = symbolSelectedIndexes[i]
							|| inputStroke.intersects(
									(s.size() < 16) ? s.strokeAt(j) : s
											.strokeAt(j)
											.proyectionPolygonal(16), Math.max(
											DStroke.r, DStroke.r));
					// if(symbolSelectedIndexes[i]) break;
				}
			}
			symbolSelectedIndexes[i] = symbolSelectedIndexes[i]
					|| (inputStroke.minX <= s.minX
							&& s.maxX <= inputStroke.maxX
							&& inputStroke.minY <= s.minY && s.maxY <= inputStroke.maxY);

			selected = selected || symbolSelectedIndexes[i];
			/*
			 * symbolSelectedBoundingBox[i] = new BoundingBox( (int)s.minX,
			 * (int)s.minY, (int)s.getWidth(), (int)s.getHeight(), 1.75f);
			 */
		}

		this.symbolSelected = selected;
		this.strokeSelected = false;

		return selected;
	}

	public boolean[][] getStrokeSelectedIndexes() {
		return strokeSelectedIndexes;
	}

	public void setStrokeSelectedIndexes(boolean[][] strokeSelectedIndexes_,
			boolean strokeSelected_) {
		strokeSelectedIndexes = strokeSelectedIndexes_;
		strokeSelected = strokeSelected_;
		symbolSelected = false;
	}

	public boolean[] getSymbolSelectedIndexes() {
		return symbolSelectedIndexes;
	}

	public void setSymbolSelectedIndexes(boolean[] symbolSelectedIndexes_,
			boolean symbolSelected_) {
		symbolSelectedIndexes = symbolSelectedIndexes_;
		strokeSelected = false;
		symbolSelected = symbolSelected_;
	}

	public boolean isSymbolSelected() {
		return symbolSelected;
	}

	public boolean isStrokeSelected() {
		return this.strokeSelected;
	}

	void this_mousePressed(MouseEvent e) {
		if (!this.isDrawable()) {
			return;
		}

		if ((e.getModifiers() & InputEvent.BUTTON1_MASK) != InputEvent.BUTTON1_MASK) {
			return;
		}

		prev = new Point(e.getPoint());
		first = new Point(prev);
		// this.drawStrokeMemory();
		if (this.isDrawing()) {
			inputStroke = new DStroke();
			inputStroke.add(e.getX(), e.getY());
			this.drawPoint(new DPoint(prev.x, prev.y), this.drawRadius,
					this.drawColor);
		} else if (this.isMoving() || (this.isSelecting())
				&& this.getCursor().equals(this.openedHandCursor)) {
			this.setCursor(this.closedHandCursor);
			this.initializeMove();
		} else if (this.isSymbolSelecting()) {
			this.setSymbolSelectedIndexes(null, false);
			inputStroke = new DStroke();
			inputStroke.add(e.getX(), e.getY());
			selectSymbolIndex();
			this.initializeDraw();
			drawSelectedSymbols();
		} else if (this.isClosedStrokeSelecting()) {
			this.setStrokeSelectedIndexes(null, false);
			inputStroke = new DStroke();
			inputStroke.add(e.getX(), e.getY());
			selectStrokeIndex();
			this.initializeDraw();
			inputStroke.add(e.getX() + 1, e.getY() + 1);
			drawSelectedStrokes();
		} else if (this.isOpenStrokeSelecting()) {
			this.setStrokeSelectedIndexes(null, false);
			inputStroke = new DStroke();
			inputStroke.add(e.getX(), e.getY());
			selectStrokeIndex();
			this.initializeDraw();
			this.drawPoint(new DPoint(prev.x, prev.y), this.drawRadius,
					this.editColor);
			drawSelectedStrokes();
		}
		repaint();
	}

	@Override
	public void initializeGraphics() {
		super.initializeGraphics();
		this.drawImage = new BufferedImage(this.getWidth(), this.getHeight(),
				BufferedImage.TYPE_INT_ARGB);
		this.drawGraphics = (Graphics2D) this.drawImage.getGraphics();
	}

	private void initializeDraw() {
		this.erase();

		for (int i = 0; i < this.strokeMemory.size(); i++) {
			strokeMemory.get(i).draw(this.getGraphics2D());
		}

		/*
		 * this.drawImage = new BufferedImage(this.getWidth(), this.getHeight(),
		 * BufferedImage.TYPE_INT_ARGB); this.drawGraphics =
		 * (Graphics2D)this.drawImage.getGraphics();
		 */
		if (antialias) {
			drawGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
		}
		this.drawGraphics.drawImage(this.getImage(), 0, 0, this);
		/*
		 * if(this.isSomethingSelected()) { this.drawStrokeMemory();
		 * this.repaint(); }
		 */
	}

	private void initializeMove() {
		/*
		 * this.erase(); for(int i = 0; i < this.strokeMemory.size(); i++) {
		 * ((Symbol) strokeMemory.get(i)).draw(this.getGraphics2D()); }
		 */

		/*
		 * this.drawImage = new BufferedImage(this.getWidth(), this.getHeight(),
		 * BufferedImage.TYPE_INT_ARGB); this.drawGraphics =
		 * (Graphics2D)this.drawImage.getGraphics();
		 */
		if (antialias) {
			drawGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);

		}
		if (this.symbolSelected) {
			this.drawGraphics.drawImage(this.getBackgroundImage(), 0, 0, this);
			for (int i = 0; i < this.symbolSelectedIndexes.length; i++) {
				if (!this.symbolSelectedIndexes[i]) {
					this.strokeMemory.get(i).draw(this.drawGraphics);
				} else {
					this.strokeMemory.get(i).drawBoundingBox(
							this.getGraphics2D(), this.editColor);
				}
			}
		} else if (this.strokeSelected) {
			Symbol s;
			this.drawGraphics.drawImage(this.getImage(), 0, 0, this);
			for (int i = 0; i < this.strokeSelectedIndexes.length; i++) {
				s = this.strokeMemory.get(i);
				for (int j = 0; j < this.strokeSelectedIndexes[i].length; j++) {
					if (this.strokeSelectedIndexes[i][j]) {
						s.strokeAt(j).drawBoundingBox(this.drawGraphics,
								this.editColor);
					}
				}
			}
		} else {
			this.drawGraphics.drawImage(this.getImage(), 0, 0, this);
		}
		// this.drawGraphics.drawImage(this.getImage(), 0, 0, this);
	}

	void this_mouseReleased(MouseEvent e) {
		if (!this.isDrawable()) {
			return;
		}

		if ((e.getModifiers() & InputEvent.BUTTON1_MASK) != InputEvent.BUTTON1_MASK) {
			return;
		}

		this.deltaX = e.getX() - first.x;
		this.deltaY = e.getY() - first.y;

		if (this.isDrawing()) {

		} else if (this.isMoving() || (this.isSelecting())
				&& this.getCursor().equals(this.closedHandCursor)) {
			/*
			 * if(this.strokeSelected) { Symbol s;
			 * this.drawImage(this.drawImage, 0, 0); for(int i = 0; i <
			 * this.strokeSelectedIndexes.length; i++) { s =
			 * (Symbol)this.strokeMemory.get(i); for(int j = 0; j <
			 * this.strokeSelectedIndexes[i].length; j++) {
			 * if(this.strokeSelectedIndexes[i][j]) {
			 * s.strokeAt(j).translate(this.deltaX, this.deltaY);
			 * s.strokeAt(j).draw(this.getGraphics2D());
			 * s.strokeAt(j).drawBoundingBox(this. getGraphics2D(),
			 * this.editColor); } } s.actualizeMaxMin(); } } else
			 * if(this.symbolSelected) { this.drawImage(this.drawImage, 0, 0);
			 * for(int i = 0; i < this.symbolSelectedIndexes.length; i++) {
			 * if(symbolSelectedIndexes[i]) {
			 * ((Symbol)this.strokeMemory.get(i)).translate(this.deltaX,
			 * this.deltaY);
			 * ((Symbol)this.strokeMemory.get(i)).draw(this.getGraphics2D ());
			 * ((Symbol)this.strokeMemory.get(i)).drawBoundingBox(this.
			 * getGraphics2D(), this.editColor); } } } else { }
			 */

			this.setCursor(this.openedHandCursor);

			drawStrokeMemorySelectedStrokes();
			drawStrokeMemorySelectedSymbols();
		} else if (this.isSymbolSelecting()) {
			drawSelectedSymbols();
			drawStrokeMemorySelectedSymbols();
			// drawSelectedStrokes();
			// editStroke = new DStroke(inputStroke);
		} else if (this.isClosedStrokeSelecting()
				|| this.isOpenStrokeSelecting()) {
			drawSelectedStrokes();
			drawStrokeMemorySelectedStrokes();
			/*
			 * for(int i = 0; i < this.strokeSelectedIndexes.length; i++) { s =
			 * (Symbol)this.strokeMemory.get(i); for(int j = 0; j <
			 * this.strokeSelectedIndexes[i].length; j++) {
			 * if(this.strokeSelectedIndexes[i][j]) {
			 * s.strokeAt(j).drawBoundingBox(this. getGraphics2D(),
			 * this.editColor); } } }
			 */
			// editStroke = new DStroke(inputStroke);
		}

		repaint();

		// this.strokeSelected = this.symbolSelected = false;
	}

	public void drawSelectedStrokes() {
		this.drawImage(this.drawImage, 0, 0);
		if (this.strokeSelected) {
			for (int i = 0; i < strokeSelectedIndexes.length; i++) {
				for (int j = 0; j < strokeSelectedIndexes[i].length; j++) {
					if (strokeSelectedIndexes[i][j]) {
						this.strokeMemory
								.get(i)
								.strokeAt(j)
								.drawBoundingBox(this.getGraphics2D(),
										this.editColor);
					}
				}
			}
		}
	}

	public void drawSelectedSymbols() {
		this.drawImage(this.drawImage, 0, 0);
		if (this.symbolSelected) {
			for (int i = 0; i < symbolSelectedIndexes.length; i++) {
				if (symbolSelectedIndexes[i]) {
					this.strokeMemory.get(i).drawBoundingBox(
							this.getGraphics2D(), this.editColor);
				}
			}
		}
	}

	public void drawStrokeMemorySelectedStrokes() {
		this.drawStrokeMemory();
		if (this.strokeSelected) {
			for (int i = 0; i < strokeSelectedIndexes.length; i++) {
				for (int j = 0; j < strokeSelectedIndexes[i].length; j++) {
					if (strokeSelectedIndexes[i][j]) {
						this.strokeMemory
								.get(i)
								.strokeAt(j)
								.drawBoundingBox(this.getGraphics2D(),
										this.editColor);
					}
				}
			}
			repaint();
		}
	}

	public boolean hitsSelectedStrokes(Point p) {
		try {
			if (this.strokeSelected) {
				DStroke ds;
				for (int i = 0; i < strokeSelectedIndexes.length; i++) {
					for (int j = 0; j < strokeSelectedIndexes[i].length; j++) {
						ds = this.strokeMemory.get(i).strokeAt(j);
						if (strokeSelectedIndexes[i][j]) {
							if (ds.minX <= p.x && p.x <= ds.maxX
									&& ds.minY <= p.y && p.y <= ds.maxY) {
								if (!this.getCursor().equals(
										this.openedHandCursor)) {
									this.setCursor(this.openedHandCursor);
								}
								return true;
							}
						}
					}
				}

				if (this.getCursor().equals(this.openedHandCursor)) {
					this.updateCursor();
				}

			} else {

			}

			return false;
		} catch (Exception e) {
			if (this.getCursor().equals(this.openedHandCursor)) {
				this.updateCursor();
			}
			return false;
		}
	}

	boolean hitsFirstTime = true;

	public boolean hitsSelectedSymbols(Point p) {
		try {
			if (this.symbolSelected) {
				Symbol ds;
				for (int i = 0; i < symbolSelectedIndexes.length; i++) {
					ds = (this.strokeMemory.get(i));
					if (symbolSelectedIndexes[i]) {
						if (ds.minX <= p.x && p.x <= ds.maxX && ds.minY <= p.y
								&& p.y <= ds.maxY) {
							if (!this.getCursor().equals(this.openedHandCursor)) {
								this.setCursor(this.openedHandCursor);
							}

							return true;
						}
					}
				}
				if (this.getCursor().equals(this.openedHandCursor)) {
					this.updateCursor();
				}
			}

			return false;
		} catch (Exception e) {
			if (this.getCursor().equals(this.openedHandCursor)) {
				this.updateCursor();
			}

			return false;
		}
	}

	public void drawStrokeMemorySelectedSymbols() {
		if (this.symbolSelected) {
			this.drawStrokeMemory();
			for (int i = 0; i < symbolSelectedIndexes.length; i++) {
				if (symbolSelectedIndexes[i]) {
					this.strokeMemory.get(i).drawBoundingBox(
							this.getGraphics2D(), this.editColor);
				}
			}
			repaint();
		}
	}

	void this_mouseMoved(MouseEvent e) {
		if (!this.isDrawable()) {
			return;
		}

		/*
		 * if((e.getModifiers() & MouseEvent.BUTTON1_MASK) !=
		 * MouseEvent.BUTTON1_MASK) { return; }
		 */

		if (this.isSelecting() && this.isSomethingSelected()) {
			// System.out.println(e.getPoint());
			this.hitsSelectedStrokes(e.getPoint());
			this.hitsSelectedSymbols(e.getPoint());
		}

		/*
		 * if(this.isMoving()) { if(!this.symbolSelected &&
		 * !this.strokeSelected) { this.drawStrokeMemory(); for(int i = 0; i <
		 * this.strokeMemory.size(); i++) { s =
		 * (Symbol)this.strokeMemory.get(i); if(s.minX <= e.getX() && e.getX()
		 * <= s.maxX && s.minY <= e.getY() && e.getY() <= s.maxY) {
		 * s.drawBoundingBox(this.getGraphics2D(), this.editColor);
		 * System.out.println(e.getPoint() + " " + s.name); } } } } repaint();
		 */
	}

	void this_mouseDragged(MouseEvent e) {
		if (!this.isDrawable()) {
			return;
		}

		if ((e.getModifiers() & InputEvent.BUTTON1_MASK) != InputEvent.BUTTON1_MASK) {
			return;
		}

		if (this.isDrawing()) {
			drawSegment(new DPoint(prev.x, prev.y),
					new DPoint(e.getX(), e.getY()), this.drawRadius,
					this.drawColor);
			inputStroke.add(e.getX(), e.getY());
			prev = new Point(e.getX(), e.getY());
		} else if (this.isMoving() || (this.isSelecting())
				&& this.getCursor().equals(this.closedHandCursor)) {
			// this.setCursor(this.closedHandCursor);
			// this.drawImage(this.drawImage, 0, 0);
			if (this.strokeSelected) {
				Symbol s;
				this.drawImage(this.drawImage, 0, 0);
				for (int i = 0; i < this.strokeSelectedIndexes.length; i++) {
					s = this.strokeMemory.get(i);
					for (int j = 0; j < this.strokeSelectedIndexes[i].length; j++) {
						if (this.strokeSelectedIndexes[i][j]) {
							s.strokeAt(j).translate(e.getX() - prev.x,
									e.getY() - prev.y);
							s.strokeAt(j).draw(this.getGraphics2D());
							s.strokeAt(j).drawBoundingBox(this.getGraphics2D(),
									this.editColor);
							/*
							 * this.strokeSelectedBoundingBox[i][j].translate(e.getX
							 * () - prev.x, e.getY() - prev.y);
							 * this.strokeSelectedBoundingBox
							 * [i][j].draw(this.getGraphics2D(),
							 * this.editColor);
							 */

						}
					}

					s.actualizeMaxMin();
				}
				this.drawStrokeMemory();
				for (int i = 0; i < this.strokeSelectedIndexes.length; i++) {
					s = this.strokeMemory.get(i);
					for (int j = 0; j < this.strokeSelectedIndexes[i].length; j++) {
						if (this.strokeSelectedIndexes[i][j]) {
							s.strokeAt(j).drawBoundingBox(this.getGraphics2D(),
									this.editColor);
						}
					}
				}

			} else if (this.symbolSelected) {
				this.drawImage(this.drawImage, 0, 0);
				for (int i = 0; i < this.symbolSelectedIndexes.length; i++) {
					if (symbolSelectedIndexes[i]) {
						this.strokeMemory.get(i).translate(e.getX() - prev.x,
								e.getY() - prev.y);
						this.strokeMemory.get(i).draw(this.getGraphics2D());
						this.strokeMemory.get(i).drawBoundingBox(
								this.getGraphics2D(), this.editColor);
						/*
						 * this.symbolSelectedBoundingBox[i].translate(e.getX()
						 * - prev.x, e.getY() - prev.y);
						 * this.symbolSelectedBoundingBox
						 * [i].draw(this.getGraphics2D(), this.editColor);
						 */

					}
				}
			} else {
			}

			prev = new Point(e.getX(), e.getY());
		} else if (this.isSymbolSelecting()) {
			inputStroke.clear();
			inputStroke.add(Math.min(e.getX(), prev.x),
					Math.min(e.getY(), prev.y));
			inputStroke.add(Math.min(e.getX(), prev.x),
					Math.max(e.getY(), prev.y));
			inputStroke.add(Math.max(e.getX(), prev.x),
					Math.max(e.getY(), prev.y));
			inputStroke.add(Math.max(e.getX(), prev.x),
					Math.min(e.getY(), prev.y));
			inputStroke.add(Math.min(e.getX(), prev.x),
					Math.min(e.getY(), prev.y));

			selectSymbolIndex();
			drawSelectedSymbols();
			// drawSelectedStrokes();

			inputStroke.draw(this.getGraphics2D(), this.editColor);
		} else if (this.isClosedStrokeSelecting()) {
			inputStroke.add(inputStroke.size() - 1,
					new DPoint(e.getX(), e.getY()));

			selectStrokeIndex();
			drawSelectedStrokes();

			inputStroke.draw(this.getGraphics2D(), this.editColor);
		} else if (this.isOpenStrokeSelecting()) {
			inputStroke.add(e.getX(), e.getY());

			selectStrokeIndex();
			drawSelectedStrokes();

			inputStroke.draw(this.getGraphics2D(), this.editColor);
		}

		repaint();
	}

	public void addToStrokeMemory(DStroke ds) {
		Symbol s;

		if (this.strokeMemory.isEmpty()) {
			s = new Symbol();
			s.add(ds);
			// s.classify();
			this.strokeMemory.add(s);
			return;
		}
		/*
		 * else { boolean nofound = true; for(int i = this.strokeMemory.size() -
		 * 1; i > -1 && i < this.strokeMemory.size(); i++) { s = (Symbol)
		 * this.strokeMemory.get(i); if(nofound = s.distance(ds,eps)) {
		 * s.add(ds); nofound = false; break; } }
		 */

		int i = this.strokeMemory.size() - 1;

		s = (this.strokeMemory.get(i));

		if (s.distance(ds, eps)) {
			s.add(ds);
			// s.classify();
		} else {
			s = new Symbol();
			s.add(ds);
			// s.classify();
			this.strokeMemory.add(s);
		}
		// }
	}

	@SuppressWarnings("unused")
	private void createMoveImage() {
		this.drawImage = new BufferedImage(this.getWidth(), this.getHeight(),
				BufferedImage.TYPE_INT_ARGB);
		this.drawGraphics = (Graphics2D) this.drawImage.getGraphics();
		if (antialias) {
			drawGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
		}
		this.selectSymbolIndex();

		if (this.symbolSelected) {
			this.drawGraphics.drawImage(this.getBackgroundImage(), 0, 0, this);
			for (int i = 0; i < this.symbolSelectedIndexes.length; i++) {
				if (!this.symbolSelectedIndexes[i]) {
					this.strokeMemory.get(i).draw(this.drawGraphics);
				} else {
					s = this.strokeMemory.get(i);
				}
			}
		} else {
			this.drawGraphics.drawImage(this.getImage(), 0, 0, this);
		}

		// Create image with RGB and alpha channel
		moveImage = new BufferedImage((int) s.getWidth(), (int) s.getHeight(),
				BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2D = moveImage.createGraphics(); // Context for buffered
														// image

		// Set best alpha interpolation quality
		g2D.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
				RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);

		// Clear image with transparent alpha by drawing a rectangle
		g2D.setComposite(AlphaComposite.getInstance(AlphaComposite.CLEAR, 0.0f));
		Rectangle2D.Double rect = new Rectangle2D.Double(0, 0,
				(int) s.getWidth(), (int) s.getHeight());
		g2D.fill(rect);
		g2D.setComposite(AlphaComposite.SrcOver);

		// plus the rest of the method...
		g2D.setColor(Color.black);
		g2D.drawLine(0, 0, (int) s.getWidth(), (int) s.getHeight());
		s.draw(g2D);
		s.drawBoundingBox(g2D, this.editColor);
	}

	public static void main(String argv[]) {
		JFrame frame = new JFrame("Test DrawJPanel");
		SymbolDrawJPanel p = new SymbolDrawJPanel(800, 600);
		frame.getContentPane().add(p);
		frame.pack();
		frame.setVisible(true);
		p.initializeGraphics();
		p.drawPoint(new DPoint(50, 50), 10, Color.red);
		p.drawRect(new DPoint(10, 10), new DPoint(50, 50), 2, Color.magenta);
		p.drawString("Hola!", new DPoint(0, 100), new Font("Arial", Font.BOLD,
				30), Color.black);
	}
}

class BoundingBox {
	int x;
	int y;
	int width;
	int height;
	float r;

	public BoundingBox(int x_, int y_, int width_, int height_, float r_) {
		x = x_;
		y = y_;
		width = width_;
		height = height_;
		r = r_;
	}

	public void translate(int dx, int dy) {
		x += dx;
		y += dy;
	}

	public void draw(Graphics2D g2, Color c) {
		g2.setColor(c);
		g2.setStroke(new BasicStroke(r, BasicStroke.CAP_SQUARE,
				BasicStroke.JOIN_ROUND));
		g2.drawRect(x, y, width, height);
	}
}

class SymbolDrawJPanel_this_mouseMotionAdapter extends
		java.awt.event.MouseMotionAdapter {
	SymbolDrawJPanel adaptee;

	SymbolDrawJPanel_this_mouseMotionAdapter(SymbolDrawJPanel adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		adaptee.this_mouseMoved(e);
	}
}
