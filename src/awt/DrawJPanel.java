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
package awt;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import javax.swing.*;

import ocr.*;

public class DrawJPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8821992335366836731L;
	private Dimension dimension;
	private BufferedImage image;
	private BufferedImage backgroundImage = null;
	private Graphics2D graphics;
	private Color borderColor = Color.black;
	private float borderRadius = 2;
	private boolean bordered = false;
	public boolean antialias = true;
	public boolean usingBackgroundImage = true;
	public static int lineSeparation = 15;
	JPanel jPanel1 = new JPanel();

	public DrawJPanel(int width, int height) {
		this(width, height, false);
	}

	public DrawJPanel(int width, int height, boolean ubi) {
		dimension = new Dimension(width, height);
		this.usingBackgroundImage = ubi;
	}

	public void drawPoint(DPoint p, float r, Color c) {
		graphics.setStroke(new BasicStroke(r, BasicStroke.CAP_ROUND,
				BasicStroke.JOIN_ROUND));
		graphics.setColor(c);
		graphics.draw(new Line2D.Double((float) p.x, (float) p.y, (float) p.x,
				(float) p.y));
	}

	public void drawRect(DPoint p, DPoint q, float r, Color c) {
		graphics.setStroke(new BasicStroke(r, BasicStroke.CAP_ROUND,
				BasicStroke.JOIN_MITER));
		graphics.setColor(c);
		graphics.draw(new Rectangle2D.Double((float) p.x, (float) p.y,
				(float) (q.x - p.x), (float) (q.y - p.y)));
	}

	public void drawSegment(DPoint p, DPoint q, float r, Color c) {
		graphics.setStroke(new BasicStroke(r, BasicStroke.CAP_SQUARE,
				BasicStroke.JOIN_BEVEL));
		graphics.setColor(c);
		graphics.draw(new Line2D.Double((float) p.x, (float) p.y, (float) q.x,
				(float) q.y));
	}

	public void drawString(String s, DPoint p, Font f, Color c) {
		graphics.setColor(c);
		graphics.setFont(f);
		graphics.drawString(s, (float) p.x, (float) p.y);
	}

	public void drawImage(Image img, DPoint p) {
		try {
			this.graphics.drawImage(img, (int) p.x, (int) p.y, this);
		} catch (NullPointerException ex) {
		}
	}

	public void drawImage(Image img, int x, int y) {
		try {
			this.graphics.drawImage(img, x, y, this);
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void paint(Graphics g) {
		try {
			if (isBordered()) {
				graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_OFF);
				this.drawRect(new DPoint(borderRadius / 2, borderRadius / 2),
						new DPoint(dimension.width - borderRadius + 1,
								dimension.height - borderRadius + 1),
						borderRadius, borderColor);
				if (antialias)
					graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
							RenderingHints.VALUE_ANTIALIAS_ON);
			}
			g.drawImage(image, 0, 0, this);
		} catch (NullPointerException ex) {
		}
	}

	public void setAntialias(boolean b) {
		antialias = b;
		if (antialias) {
			graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
		} else {
			graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_OFF);
		}
	}

	public boolean isAntialised() {
		return antialias;
	}

	public Color getBorderColor() {
		return this.borderColor;
	}

	public void setBorderColor(Color color) {
		this.borderColor = color;
	}

	public float getBorderRadius() {
		return this.borderRadius;
	}

	public void setBorderRadius(float radius) {
		this.borderRadius = radius;
	}

	public void setBackgroundImge(Image img) {
		Graphics g = backgroundImage.getGraphics();
		g.drawImage(img, 0, 0, this);
	}

	public void setBordered(boolean b) {
		this.bordered = b;
	}

	public boolean isBordered() {
		return this.bordered;
	}

	public Graphics2D getGraphics2D() {
		return graphics;
	}

	public void initializeBackgroundImage(int separation) {
		Graphics2D g;
		int x, y;

		backgroundImage = (BufferedImage) createImage(dimension.width,
				this.dimension.height);
		g = (Graphics2D) backgroundImage.getGraphics();

		g.setColor(Color.white);
		g.fillRect(0, 0, this.dimension.width, this.dimension.height);

		g.setColor(new Color(215, 219, 222));
		for (x = 0; x < backgroundImage.getWidth(); x += separation) {
			g.drawLine(x, 0, x, backgroundImage.getHeight());
		}

		for (y = 0; y < backgroundImage.getHeight(); y += separation) {
			g.drawLine(0, y, backgroundImage.getWidth(), y);
		}

		this.graphics.drawImage(backgroundImage, 0, 0, this);
	}

	public void initializeBackgroundImage() {
		this.initializeBackgroundImage(lineSeparation);
	}

	public void initializeGraphics() {
		image = (BufferedImage) createImage(dimension.width,
				this.dimension.height);
		graphics = (Graphics2D) image.getGraphics();

		if (antialias) {
			graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
		} else {
			graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_OFF);
		}
		this.initializeBackgroundImage();
		erase();
	}

	public void erase() {
		if (this.usingBackgroundImage) {
			this.graphics.drawImage(backgroundImage, 0, 0, this);
		} else {
			try {
				this.graphics.setColor(this.getBackground());
				this.graphics.fillRect(0, 0, this.dimension.width,
						this.dimension.height);
			} catch (NullPointerException e) {
			}
		}
		this.repaint();
	}

	public Image getImage() {
		return image;
	}

	public Image getBackgroundImage() {
		return this.backgroundImage;
	}

	public static void delay(float seconds) {
		try {
			Thread.sleep((long) (1000 * seconds));
		} catch (Exception ex) {
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return getMinimumSize();
	}

	@Override
	public synchronized Dimension getMinimumSize() {
		return dimension;
	}

	@Override
	public boolean isFocusTraversable() {
		return true;
	}

	public DrawJPanel() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		this.add(jPanel1, null);
	}

	/*
	 * public static void main(String[] argv) { JFrame frame = new
	 * JFrame("Test DrawJPanel"); DrawJPanel p = new DrawJPanel(100,100);
	 * frame.getContentPane().add(p); frame.pack(); frame.setVisible(true);
	 * p.initializeGraphics(); p.drawPoint(new DPoint(50,50),10,Color.red);
	 * p.drawRect(new DPoint(10,10),new DPoint(50,50),2,Color.magenta);
	 * p.drawString("Hola!",new DPoint(0,100),new Font("Arial", Font.BOLD,
	 * 30),Color.black); }
	 */
}
