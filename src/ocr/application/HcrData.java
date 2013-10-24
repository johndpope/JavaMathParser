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
package ocr.application;

import java.net.*;
import hfr.*;
import tinybasic.*;
import svm.*;
import hfr.graph.*;
import awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.io.*;
import ocr.*;

import java.awt.*;
import java.util.*;

import javax.swing.undo.*;
import javax.swing.event.*;

public class HcrData extends JFrame implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2474965606488399940L;
	ImageIcon BImageIcon;
	ImageIcon BackImageIcon16;
	ImageIcon BackImageIcon24;
	JButton BackJButton;
	ImageIcon CalculusImageIcon16;
	ImageIcon CloseImageIcon16;
	ImageIcon CloseImageIcon24;
	JButton CloseJButton;
	ImageIcon CopyImageIcon16;
	ImageIcon CopyImageIcon24;
	JButton CopyJButton;
	JMenuItem CopyJMenuItem;
	ImageIcon CutImageIcon16;
	ImageIcon CutImageIcon24;
	JButton CutJButton;
	JMenuItem CutJMenuItem;
	ImageIcon DeleteImageIcon16;
	ImageIcon DeleteImageIcon24;
	ImageIcon DrawImageIcon16;
	ImageIcon DrawImageIcon24;
	JSplitPane DrawJSplitPane;
	JToggleButton DrawJToggleButton;
	ButtonGroup DrawSelectButtonGroup;
	JMenu EditJMenu;
	JToolBar EditJToolBar;
	ImageIcon ForwardImageIcon16;
	ImageIcon ForwardImageIcon24;
	JButton ForwardJButton;
	ImageIcon GroupImageIcon16;
	ImageIcon GroupImageIcon24;
	JToggleButton GroupJToggleButton;
	JComboBox<?> GroupNameJComboBox;
	ImageIcon GroupOpenStrokeImageIcon16;
	ImageIcon GroupOpenStrokeImageIcon24;
	JToggleButton GroupOpenStrokeToggleButton;
	JButton GroupSelectionjButton;
	JMenu HelpMenu;
	JToggleButton MoveJToggleButton;
	ImageIcon MoveSymbolImageIcon16;
	ImageIcon MoveSymbolImageIcon24;
	JToolBar NavigationAndToolsJToolBar;
	ImageIcon NewDrawImageIcon16;
	ImageIcon NewDrawImageIcon24;
	JButton NewDrawJButton;
	ImageIcon NewImageIcon16;
	ImageIcon NewImageIcon24;
	JButton NewJButton;
	ImageIcon NextPageImageIcon16;
	ImageIcon NextPageImageIcon24;
	JButton NextPageJButton;
	ImageIcon NullImageIcon16;
	ImageIcon OpenImageIcon16;
	ImageIcon OpenImageIcon24;
	JButton OpenJButton;
	ImageIcon PasteImageIcon16;
	ImageIcon PasteImageIcon24;
	JButton PasteJButton;
	JMenuItem PasteJMenuItem;
	ImageIcon Plot2DImageIcon16;
	ImageIcon Plot2DImageIcon24;
	JButton Plot2DJButton;
	JButton Plot3DJButton;
	ImageIcon Plot3DmaticaImageIcon16;
	ImageIcon Plot3DmaticaImageIcon24;
	ImageIcon PlotParam2DImageIcon16;
	JButton PlotParam2DjButton;
	ImageIcon PlotParam3DImageIcon16;
	JButton PlotParam3DjButton;
	ImageIcon PreviousPageImageIcon16;
	ImageIcon PreviousPageImageIcon24;
	JButton PreviousPageJButton;
	ImageIcon RedoImageIcon16;
	ImageIcon RedoImageIcon24;
	JButton RedoJButton;
	JMenuItem RedoJMenuItem;
	JButton RefreshDrawAreaButton;
	ImageIcon RefreshDrawAreaImageIcon16;
	ImageIcon RefreshDrawAreaImageIcon24;
	JButton RefreshDrawAreaJButton;
	JButton RemoveAllJButton;
	ImageIcon SaveAsImageIcon16;
	ImageIcon SaveAsImageIcon24;
	ImageIcon SaveImageIcon16;
	ImageIcon SaveImageIcon24;
	JButton SaveJButton;
	JMenuItem SelectAllJMenuItem;
	JToggleButton SelectClosedStrokeJToggleButton;
	ImageIcon SelectImageIcon16;
	ImageIcon SelectImageIcon24;
	JToggleButton SelectJToggleButton;
	ImageIcon SelectOpenStrokeImageIcon16;
	ImageIcon SelectOpenStrokeImageIcon24;
	JToggleButton SelectOpenStrokeJToggleButton;
	JToggleButton SelectOpenStrokeToggleButton;
	ImageIcon SelectStrokeImageIcon16;
	ImageIcon SelectStrokeImageIcon24;
	JButton TinyBasicjButton;
	ImageIcon ToMathematicaImageIcon16;
	ImageIcon ToMathematicaImageIcon24;
	JButton ToMathematicaJButton;
	ImageIcon ToTeXImageIcon16;
	ImageIcon ToTeXImageIcon24;
	JButton ToTeXJButton;
	JMenu TreeJMenu;
	ImageIcon UndoImageIcon16;
	ImageIcon UndoImageIcon24;
	JButton UndoJButton;
	JMenuItem UndoJMenuItem;
	JMenuItem UndoJMenuItem2;
	JMenuItem UndojMenuItem;
	JSplitPane ViewJSplitPane;
	JMenuItem aboutjMenuItem;
	JRadioButtonMenuItem allgroupsjRadioButtonMenuItem;
	JCheckBoxMenuItem allpropertiesjCheckBoxMenuItem5;
	JCheckBoxMenuItem antialiasjCheckBoxMenuItem;
	JRadioButtonMenuItem aspolygonaljRadioButtonMenuItem;
	JRadioButtonMenuItem asstrokejRadioButtonMenuItem;
	private JCheckBoxMenuItem attractorsjCheckBoxMenuItem2;
	ImageIcon backIcon;
	boolean backgorundConstructed;
	JCheckBoxMenuItem backgroundCheckBoxMenuItem1;
	Image[] backgroundImage;
	JCheckBoxMenuItem backgroundImagejCheckBoxMenuItem;
	private JRadioButtonMenuItem basicjRadioButtonMenuItem;
	Border border1;
	Border border2;
	Border border3;
	BorderLayout borderLayout1;
	BorderLayout borderLayout3;
	public boolean boundingboxOld;
	JCheckBoxMenuItem boundingboxjCheckBoxMenuItem4;
	ImageIcon calculusIcon;
	boolean calculusSelected;
	private JRadioButtonMenuItem capitaljRadioButtonMenuItem;
	JMenuItem changelabeljMenuItem;
	JMenuItem checkHorizontalBarjMenuItem;
	JCheckBoxMenuItem checkMSTMatrixMemoryjCheckBoxMenuItem;
	JMenu classfiersjMenu;
	int classifierType;
	String[] classifierTypeName;
	JRadioButtonMenuItem[] classifierTypeRadioButtonMenuItem;
	JMenuItem closejMenuItem;
	JMenuItem clusterpointsjMenuItem;
	private JCheckBoxMenuItem commandinterpreterjCheckBoxMenuItem;
	ArrayList<Symbol> copyPasteMemory;
	ArrayList<?> curentIndexUndoRedo;
	private JMenu defaultclassifierjMenu2;
	JMenuItem dehookjMenuItem;
	ImageIcon deleteIcon;
	ImageIcon deleteallIcon;
	ImageIcon deleteallgIcon;
	ImageIcon deletegroupIcon;
	ImageIcon deletelastIcon;
	ImageIcon deletelastgIcon;
	ImageIcon deletgeIcon;
	public boolean directionOld;
	JCheckBoxMenuItem directionjCheckBoxMenuItem2;
	private JCheckBoxMenuItem distancefactorjCheckBoxMenuItem;
	JCheckBoxMenuItem dominancehorizontalfactorjCheckBoxMenuItem;
	private JCheckBoxMenuItem dominancejCheckBoxMenuItem;
	private JMenuItem dominancemstUndoJMenuItem;
	JCheckBoxMenuItem doublesidedjCheckBoxMenuItem;
	DownloadModelThread downloadModelThread;
	ImageIcon drawIcon;
	SymbolDrawJPanel drawJPanel;
	ImageIcon drawgIcon;
	JPanel drawingjPanel;
	JScrollPane drawjScrollPane;
	JMenuItem equidistantjMenuItem;
	private JMenuItem evaluatejMenuItem;
	SymbolDrawJPanel exampleJPanel;
	JScrollPane examplejScrollPane;
	JMenuItem exitjMenuItem;
	private JTextField expressionjTextField;
	JMenu filejMenu;
	String filename;
	public boolean filteringProcessing;
	JMenuItem filteringjMenuItem;
	ImageIcon formulaIcon;
	Thread formulaThread;
	ImageIcon forwardIcon;
	private JCheckBoxMenuItem graphicoutputjCheckBoxMenuItem;
	ImageIcon graphicsIcon;
	private JRadioButtonMenuItem greekjRadioButtonMenuItem1;
	GridBagLayout gridBagLayout1;
	GridBagLayout gridBagLayout2;
	GridBagLayout gridBagLayout4;
	JMenu gropupingjMenu;
	ImageIcon groupIcon;
	ImageIcon groupgIcon;
	private JPopupMenu groupjPopupMenu;
	public boolean highOld;
	JCheckBoxMenuItem highcurvaturejCheckBoxMenuItem;
	JMenuItem horizontalhistogramjMenuItem;
	ArrayList<?> images;
	Image img;
	int index;
	public boolean indexOld;
	JCheckBoxMenuItem indexjCheckBoxMenuItem3;
	boolean isChanged;
	JApplet jApplet;
	JButton jButton2;
	JButton jButton3;
	private JMenu jMenu1;
	private JMenu jMenu2;
	JMenu jMenu3;
	JMenuBar jMenuBar1;
	JMenuItem jMenuItem2;
	JMenuItem jMenuItem3;
	private JMenuItem jMenuItem4;
	JRadioButtonMenuItem jRadioButtonMenuItem1;
	JRadioButtonMenuItem jRadioButtonMenuItem10;
	JRadioButtonMenuItem jRadioButtonMenuItem11;
	JRadioButtonMenuItem jRadioButtonMenuItem12;
	JRadioButtonMenuItem jRadioButtonMenuItem13;
	JRadioButtonMenuItem jRadioButtonMenuItem14;
	JRadioButtonMenuItem jRadioButtonMenuItem15;
	JRadioButtonMenuItem jRadioButtonMenuItem16;
	JRadioButtonMenuItem jRadioButtonMenuItem2;
	JRadioButtonMenuItem jRadioButtonMenuItem3;
	private JRadioButtonMenuItem jRadioButtonMenuItem4;
	JRadioButtonMenuItem jRadioButtonMenuItem5;
	JRadioButtonMenuItem jRadioButtonMenuItem6;
	JRadioButtonMenuItem jRadioButtonMenuItem7;
	JRadioButtonMenuItem jRadioButtonMenuItem8;
	JRadioButtonMenuItem jRadioButtonMenuItem9;
	LogoJDialog l;
	JTextField labelJTextField;
	public boolean labelOld;
	JCheckBoxMenuItem labeljCheckBoxMenuItem6;
	JMenuItem labeljMenuItem;
	ButtonGroup language;
	JMenu languageinterpreterjMenu;
	JRadioButtonMenuItem languagelatexjRadioButtonMenuItem;
	String latexExp;
	String latexexpr;
	boolean loadingModel;
	public boolean lowOld;
	JCheckBoxMenuItem lowvelocityjCheckBoxMenuItem;
	String mathExp;
	int[] maxNumStrokes;
	JScrollPane messagesjScrollPane;
	JTextArea messagesjTextArea;
	private JMenuItem minimumspanningtreejMenuItem4;
	String modelname;
	JTextField nameSymboljTextField;
	private JRadioButtonMenuItem nearestneighborsjRadioButtonMenuItem18;
	boolean newGenerated;
	private JMenuItem newGroupjMenuItem;
	ImageIcon newIcon;
	JMenuItem newjMenuItem;
	private JMenuItem nextjMenuItem;
	int ngroups;
	public float normalizeDirectionProcessing;
	JMenuItem normalizejMenuItem;
	int np;
	int numClassifiers;
	public boolean numberofpointsOld;
	JCheckBoxMenuItem numberofpointsjCheckBoxMenuItem7;
	Point oldPoint;
	ImageIcon openIcon;
	JMenuItem openjMenuItem;
	public boolean orderStrokesProcessing;
	JMenuItem orderjMenuItem;
	int outputHeight;
	JMenuItem parametersviewUndoJMenuItem;
	JMenuItem parametric2djMenuItem;
	JMenuItem parametric3djMenuItem;
	String path;
	String plot3DExp;
	boolean plot3DSelected;
	JMenuItem plot3djMenuItem;
	String plotExp;
	boolean plotParam3DSelected;
	boolean plotParamSelected;
	private String plotParametric2DExp;
	private boolean plotParametric2DSelected;
	private String plotParametric3DExp;
	private boolean plotParametric3DSelected;
	boolean plotSelected;
	public int pointsEquidistantSamplingProcessing;
	public boolean pointsOld;
	public int pointsPolygonalApproximationProcessing;
	JCheckBoxMenuItem pointsjCheckBoxMenuItem1;
	JMenuItem poligonaljMenuItem;
	private JMenuItem previousjMenuItem;
	ProcessPropertiesJDialog processPropertiesJDialog;
	public String processingSequenceProcessing;
	JMenu processingjMenu;
	JMenuItem processingparametersjMenuItem;
	private JRadioButtonMenuItem punctuationjRadioButtonMenuItem;
	public float radiusEquidistantSamplingProcessing;
	private JCheckBoxMenuItem readformulajCheckBoxMenuItem;
	JMenuItem refreshjMenuItem;
	private JMenuItem removejMenuItem;
	ImageIcon saveIcon;
	JMenuItem saveasjMenuItem;
	JMenuItem saveastrainingjMenuItem;
	boolean saved;
	JMenuItem savejMenuItem;
	ImageIcon selecgtIcon;
	ImageIcon selectIcon;
	boolean[][] selectIndex;
	int selectStep;
	ArrayList<?> selectedStrokes;
	private JMenuItem showjMenuItem;
	public float sigmaSmoothingPreprocessing;
	SymbolList sl;
	private JRadioButtonMenuItem smalljRadioButtonMenuItem;
	JMenuItem smoothingjMenuItem;
	String solveExp;
	boolean solveSelected;
	private JMenuItem spatialareasUndoJMenuItem;
	private JMenuItem spatialrelationjMenuItem;
	private JRadioButtonMenuItem supportArrayListjRadioButtonMenuItem17;
	SvmModel[] svm1;
	SvmModel[] svm2;
	SvmModel[][] svmModel;
	ArrayList<Symbol> symbol;
	ArrayList<ArrayList<Symbol>> symbolData;
	ArrayList<?> symbolMemoryUndoRedoData;
	Symbol symbolSelected;
	String[] symboldata;
	JComboBox<StringBuffer> symboljComboBox;
	JPopupMenu symboljPopupMenu;
	JMenuItem symbolmstjMenuItem;
	ButtonGroup symbolrecognizergroup;
	Tangent tan;
	public float tangentTransformationProcessing;
	JMenuItem tangenttransformationjMenuItem;
	boolean texSelected;
	private JMenuItem texjMenuItem;
	JRadioButtonMenuItem tinybasicjRadioButtonMenuItem;
	TitledBorder titledBorder1;
	TitledBorder titledBorder2;
	TitledBorder titledBorder3;
	TitledBorder titledBorder4;
	TitledBorder titledBorder5;
	String tmp;
	TangentThread tt;
	UndoManager undoManager_;
	UndoableEditSupport undoSupport_;
	ImageIcon ungrogupIcon;
	ImageIcon ungroupIcon;
	JToggleButton ungroupjToggleButton;
	URL url;
	private JCheckBoxMenuItem usedominancejCheckBoxMenuItem2;
	JCheckBoxMenuItem usehorizontalfactorjCheckBoxMenuItem;
	JCheckBoxMenuItem usethislabeljCheckBoxMenuItem;
	JMenuItem verticalhistogramjMenuItem;
	JPanel viewingjPanel;
	JMenu viewjMenu;
	JPanel viewjPanel;
	static ArrayList<HcrData> window;
	int windowIndex;
	public int windowSmoothingProcessing;

	static {
		HcrData.window = new ArrayList<HcrData>();
	}

	public HcrData(final URL url, final int c) {
		super();
		symbolData = new ArrayList<ArrayList<Symbol>>();
		images = new ArrayList<Object>();
		symbol = new ArrayList<Symbol>();
		selectedStrokes = new ArrayList<Object>();
		symbolMemoryUndoRedoData = new ArrayList<Object>();
		curentIndexUndoRedo = new ArrayList<Object>();
		index = -1;
		path = "";
		tmp = "";
		this.url = null;
		formulaThread = null;
		classifierType = 0;
		np = 16;
		saved = false;
		filename = "";
		classifierTypeName = new String[] { "Basic symbol", "Small letter",
				"Capital letter", "Greek letter", "Punctuation mark" };
		loadingModel = true;
		boundingboxOld = true;
		labelOld = true;
		orderStrokesProcessing = true;
		filteringProcessing = true;
		normalizeDirectionProcessing = 0.3f;
		tangentTransformationProcessing = 0.15f;
		sigmaSmoothingPreprocessing = 5.0f;
		windowSmoothingProcessing = 12;
		radiusEquidistantSamplingProcessing = 2.0f;
		pointsEquidistantSamplingProcessing = 32;
		pointsPolygonalApproximationProcessing = 32;
		processingSequenceProcessing = "1 1 10";
		newGenerated = false;
		isChanged = false;
		windowIndex = -1;
		oldPoint = null;
		selectStep = 0;
		jApplet = null;
		latexExp = "";
		mathExp = "";
		plotExp = "";
		solveExp = "";
		plot3DExp = "";
		downloadModelThread = null;
		texSelected = false;
		calculusSelected = false;
		plotSelected = false;
		plot3DSelected = false;
		plotParamSelected = false;
		plotParam3DSelected = false;
		solveSelected = false;
		backgroundImage = new Image[1];
		tan = null;
		symboldata = new String[] { "data/kbuchstaben0.col", "data/math0.col",
				"data/ggreek0.col", "data/kgreek0.col", "data/zahlen0.col" };
		symbolrecognizergroup = new ButtonGroup();
		DrawSelectButtonGroup = new ButtonGroup();
		modelname = "formula_";
		outputHeight = 300;
		NewImageIcon16 = new ImageIcon("icons/New16.gif");
		OpenImageIcon16 = new ImageIcon("icons/Open16.gif");
		CloseImageIcon16 = new ImageIcon("icons/Close16.gif");
		SaveImageIcon16 = new ImageIcon("icons/Save16.gif");
		SaveAsImageIcon16 = new ImageIcon("icons/SaveAs16.gif");
		BackImageIcon16 = new ImageIcon("icons/Back16.gif");
		PreviousPageImageIcon16 = new ImageIcon("icons/Back16.gif");
		NewDrawImageIcon16 = new ImageIcon("icons/NewDraw16.gif");
		NextPageImageIcon16 = new ImageIcon("icons/Forward16.gif");
		ForwardImageIcon16 = new ImageIcon("icons/Forward16.gif");
		RefreshDrawAreaImageIcon16 = new ImageIcon("icons/Refresh16.gif");
		UndoImageIcon16 = new ImageIcon("icons/Undo16.gif");
		RedoImageIcon16 = new ImageIcon("icons/Redo16.gif");
		CopyImageIcon16 = new ImageIcon("icons/Copy16.gif");
		PasteImageIcon16 = new ImageIcon("icons/Paste16.gif");
		CutImageIcon16 = new ImageIcon("icons/Cut16.gif");
		DeleteImageIcon16 = new ImageIcon("icons/Delete16.gif");
		DrawImageIcon16 = new ImageIcon("icons/Draw16.gif");
		SelectImageIcon16 = new ImageIcon("icons/Select16.gif");
		SelectStrokeImageIcon16 = new ImageIcon("icons/SelectStroke16.gif");
		SelectOpenStrokeImageIcon16 = new ImageIcon(
				"icons/SelectOpenStroke16.gif");
		MoveSymbolImageIcon16 = new ImageIcon("icons/OpenedHand.gif");
		GroupImageIcon16 = new ImageIcon("icons/Group16.gif");
		GroupOpenStrokeImageIcon16 = new ImageIcon(
				"icons/GroupOpenStroke16.gif");
		ToTeXImageIcon16 = new ImageIcon("icons/TeXNew.gif");
		ToMathematicaImageIcon16 = new ImageIcon("icons/Mathematica16.gif");
		CalculusImageIcon16 = new ImageIcon("icons/Calculus.png");
		Plot2DImageIcon16 = new ImageIcon("icons/Plot2D16.gif");
		Plot3DmaticaImageIcon16 = new ImageIcon("icons/Plot3D16.gif");
		NullImageIcon16 = new ImageIcon("icons/Null16.gif");
		NewImageIcon24 = new ImageIcon("icons/New24.gif");
		OpenImageIcon24 = new ImageIcon("icons/Open24.gif");
		CloseImageIcon24 = new ImageIcon("icons/Close24.gif");
		SaveImageIcon24 = new ImageIcon("icons/Save24.gif");
		SaveAsImageIcon24 = new ImageIcon("icons/SaveAs24.gif");
		BackImageIcon24 = new ImageIcon("icons/Back24.gif");
		PreviousPageImageIcon24 = new ImageIcon("icons/Back24.gif");
		NewDrawImageIcon24 = new ImageIcon("icons/NewDraw24.gif");
		NextPageImageIcon24 = new ImageIcon("icons/Forward24.gif");
		ForwardImageIcon24 = new ImageIcon("icons/Forward24.gif");
		RefreshDrawAreaImageIcon24 = new ImageIcon("icons/Refresh24.gif");
		UndoImageIcon24 = new ImageIcon("icons/Undo24.gif");
		RedoImageIcon24 = new ImageIcon("icons/Redo24.gif");
		CopyImageIcon24 = new ImageIcon("icons/Copy24.gif");
		PasteImageIcon24 = new ImageIcon("icons/Paste24.gif");
		CutImageIcon24 = new ImageIcon("icons/Cut24.gif");
		DeleteImageIcon24 = new ImageIcon("icons/Delete24.gif");
		DrawImageIcon24 = new ImageIcon("icons/Draw24.gif");
		SelectImageIcon24 = new ImageIcon("icons/Select24.gif");
		SelectStrokeImageIcon24 = new ImageIcon("icons/SelectStroke24.gif");
		SelectOpenStrokeImageIcon24 = new ImageIcon(
				"icons/SelectOpenStroke24.gif");
		MoveSymbolImageIcon24 = new ImageIcon("icons/OpenedHand.gif");
		GroupImageIcon24 = new ImageIcon("icons/Group24.gif");
		GroupOpenStrokeImageIcon24 = new ImageIcon(
				"icons/GroupOpenStroke24.gif");
		ToTeXImageIcon24 = new ImageIcon("icons/TeXNew.gif");
		ToMathematicaImageIcon24 = new ImageIcon("icons/Mathematica24.gif");
		Plot2DImageIcon24 = new ImageIcon("icons/Plot2D24.gif");
		Plot3DmaticaImageIcon24 = new ImageIcon("icons/Plot3D24.gif");
		PlotParam2DImageIcon16 = new ImageIcon("icons/PlotParam2D16.gif");
		PlotParam3DImageIcon16 = new ImageIcon("icons/PlotParam3D16.gif");
		BImageIcon = new ImageIcon("icons/B.png");
		viewingjPanel = new JPanel();
		viewjPanel = new JPanel();
		exampleJPanel = new SymbolDrawJPanel(350, 200);
		gridBagLayout4 = new GridBagLayout();
		symboljComboBox = new JComboBox<StringBuffer>();
		nameSymboljTextField = new JTextField();
		messagesjScrollPane = new JScrollPane();
		messagesjTextArea = new JTextArea();
		borderLayout1 = new BorderLayout();
		jMenuBar1 = new JMenuBar();
		filejMenu = new JMenu();
		exitjMenuItem = new JMenuItem();
		newjMenuItem = new JMenuItem();
		savejMenuItem = new JMenuItem();
		saveasjMenuItem = new JMenuItem();
		closejMenuItem = new JMenuItem();
		openjMenuItem = new JMenuItem();
		viewjMenu = new JMenu();
		ungroupjToggleButton = new JToggleButton();
		pointsjCheckBoxMenuItem1 = new JCheckBoxMenuItem();
		directionjCheckBoxMenuItem2 = new JCheckBoxMenuItem();
		asstrokejRadioButtonMenuItem = new JRadioButtonMenuItem();
		aspolygonaljRadioButtonMenuItem = new JRadioButtonMenuItem();
		indexjCheckBoxMenuItem3 = new JCheckBoxMenuItem();
		boundingboxjCheckBoxMenuItem4 = new JCheckBoxMenuItem();
		allpropertiesjCheckBoxMenuItem5 = new JCheckBoxMenuItem();
		processingjMenu = new JMenu();
		jRadioButtonMenuItem2 = new JRadioButtonMenuItem();
		allgroupsjRadioButtonMenuItem = new JRadioButtonMenuItem();
		jRadioButtonMenuItem5 = new JRadioButtonMenuItem();
		filteringjMenuItem = new JMenuItem();
		smoothingjMenuItem = new JMenuItem();
		equidistantjMenuItem = new JMenuItem();
		normalizejMenuItem = new JMenuItem();
		orderjMenuItem = new JMenuItem();
		UndoJMenuItem2 = new JMenuItem();
		processingparametersjMenuItem = new JMenuItem();
		gropupingjMenu = new JMenu();
		jRadioButtonMenuItem6 = new JRadioButtonMenuItem();
		jRadioButtonMenuItem7 = new JRadioButtonMenuItem();
		jRadioButtonMenuItem8 = new JRadioButtonMenuItem();
		jRadioButtonMenuItem9 = new JRadioButtonMenuItem();
		jRadioButtonMenuItem10 = new JRadioButtonMenuItem();
		jRadioButtonMenuItem11 = new JRadioButtonMenuItem();
		jRadioButtonMenuItem12 = new JRadioButtonMenuItem();
		jRadioButtonMenuItem13 = new JRadioButtonMenuItem();
		jRadioButtonMenuItem14 = new JRadioButtonMenuItem();
		jRadioButtonMenuItem15 = new JRadioButtonMenuItem();
		jRadioButtonMenuItem16 = new JRadioButtonMenuItem();
		labeljCheckBoxMenuItem6 = new JCheckBoxMenuItem();
		classfiersjMenu = new JMenu();
		UndojMenuItem = new JMenuItem();
		saveastrainingjMenuItem = new JMenuItem();
		numberofpointsjCheckBoxMenuItem7 = new JCheckBoxMenuItem();
		tangenttransformationjMenuItem = new JMenuItem();
		parametersviewUndoJMenuItem = new JMenuItem();
		antialiasjCheckBoxMenuItem = new JCheckBoxMenuItem();
		symboljPopupMenu = new JPopupMenu();
		labelJTextField = new JTextField(15);
		HelpMenu = new JMenu();
		aboutjMenuItem = new JMenuItem();
		changelabeljMenuItem = new JMenuItem();
		labeljMenuItem = new JMenuItem();
		poligonaljMenuItem = new JMenuItem();
		jMenuItem2 = new JMenuItem();
		jMenuItem3 = new JMenuItem();
		jMenu1 = new JMenu();
		graphicoutputjCheckBoxMenuItem = new JCheckBoxMenuItem();
		groupjPopupMenu = new JPopupMenu();
		previousjMenuItem = new JMenuItem();
		nextjMenuItem = new JMenuItem();
		newGroupjMenuItem = new JMenuItem();
		texjMenuItem = new JMenuItem();
		evaluatejMenuItem = new JMenuItem();
		showjMenuItem = new JMenuItem();
		removejMenuItem = new JMenuItem();
		defaultclassifierjMenu2 = new JMenu();
		basicjRadioButtonMenuItem = new JRadioButtonMenuItem();
		smalljRadioButtonMenuItem = new JRadioButtonMenuItem();
		capitaljRadioButtonMenuItem = new JRadioButtonMenuItem();
		greekjRadioButtonMenuItem1 = new JRadioButtonMenuItem();
		punctuationjRadioButtonMenuItem = new JRadioButtonMenuItem();
		commandinterpreterjCheckBoxMenuItem = new JCheckBoxMenuItem();
		expressionjTextField = new JTextField();
		jMenu3 = new JMenu();
		jRadioButtonMenuItem1 = new JRadioButtonMenuItem();
		jRadioButtonMenuItem3 = new JRadioButtonMenuItem();
		dominancejCheckBoxMenuItem = new JCheckBoxMenuItem();
		jRadioButtonMenuItem4 = new JRadioButtonMenuItem();
		readformulajCheckBoxMenuItem = new JCheckBoxMenuItem();
		language = new ButtonGroup();
		tt = null;
		ngroups = 1;
		backgroundImagejCheckBoxMenuItem = new JCheckBoxMenuItem();
		backgroundCheckBoxMenuItem1 = new JCheckBoxMenuItem();
		dominancemstUndoJMenuItem = new JMenuItem();
		minimumspanningtreejMenuItem4 = new JMenuItem();
		spatialrelationjMenuItem = new JMenuItem();
		usedominancejCheckBoxMenuItem2 = new JCheckBoxMenuItem();
		attractorsjCheckBoxMenuItem2 = new JCheckBoxMenuItem();
		distancefactorjCheckBoxMenuItem = new JCheckBoxMenuItem();
		spatialareasUndoJMenuItem = new JMenuItem();
		img = null;
		backgorundConstructed = false;
		jMenu2 = new JMenu();
		jMenuItem4 = new JMenuItem();
		supportArrayListjRadioButtonMenuItem17 = new JRadioButtonMenuItem();
		nearestneighborsjRadioButtonMenuItem18 = new JRadioButtonMenuItem();
		usehorizontalfactorjCheckBoxMenuItem = new JCheckBoxMenuItem();
		verticalhistogramjMenuItem = new JMenuItem();
		horizontalhistogramjMenuItem = new JMenuItem();
		checkMSTMatrixMemoryjCheckBoxMenuItem = new JCheckBoxMenuItem();
		EditJToolBar = new JToolBar();
		NewJButton = new JButton();
		OpenJButton = new JButton();
		CloseJButton = new JButton();
		SaveJButton = new JButton();
		UndoJButton = new JButton();
		RedoJButton = new JButton();
		CopyJButton = new JButton();
		PasteJButton = new JButton();
		CutJButton = new JButton();
		RemoveAllJButton = new JButton();
		DrawJToggleButton = new JToggleButton();
		SelectJToggleButton = new JToggleButton();
		SelectClosedStrokeJToggleButton = new JToggleButton();
		NavigationAndToolsJToolBar = new JToolBar();
		jButton3 = new JButton();
		BackJButton = new JButton();
		NewDrawJButton = new JButton();
		ForwardJButton = new JButton();
		GroupNameJComboBox = new JComboBox<Object>();
		ToTeXJButton = new JButton();
		ToMathematicaJButton = new JButton();
		Plot2DJButton = new JButton();
		Plot3DJButton = new JButton();
		SelectOpenStrokeToggleButton = new JToggleButton();
		SelectOpenStrokeJToggleButton = new JToggleButton();
		jButton2 = new JButton();
		PreviousPageJButton = new JButton();
		NextPageJButton = new JButton();
		RefreshDrawAreaButton = new JButton();
		RefreshDrawAreaJButton = new JButton();
		DrawJSplitPane = new JSplitPane();
		drawJPanel = new SymbolDrawJPanel(1024, 768, true);
		drawingjPanel = new JPanel();
		borderLayout3 = new BorderLayout();
		gridBagLayout2 = new GridBagLayout();
		ViewJSplitPane = new JSplitPane();
		drawjScrollPane = new JScrollPane();
		gridBagLayout1 = new GridBagLayout();
		examplejScrollPane = new JScrollPane();
		EditJMenu = new JMenu();
		UndoJMenuItem = new JMenuItem();
		RedoJMenuItem = new JMenuItem();
		CutJMenuItem = new JMenuItem();
		CopyJMenuItem = new JMenuItem();
		SelectAllJMenuItem = new JMenuItem();
		PasteJMenuItem = new JMenuItem();
		MoveJToggleButton = new JToggleButton();
		copyPasteMemory = new ArrayList<Symbol>();
		GroupJToggleButton = new JToggleButton();
		GroupOpenStrokeToggleButton = new JToggleButton();
		symbolmstjMenuItem = new JMenuItem();
		dominancehorizontalfactorjCheckBoxMenuItem = new JCheckBoxMenuItem();
		GroupSelectionjButton = new JButton();
		doublesidedjCheckBoxMenuItem = new JCheckBoxMenuItem();
		lowvelocityjCheckBoxMenuItem = new JCheckBoxMenuItem();
		highcurvaturejCheckBoxMenuItem = new JCheckBoxMenuItem();
		checkHorizontalBarjMenuItem = new JMenuItem();
		TreeJMenu = new JMenu();
		PlotParam2DjButton = new JButton();
		PlotParam3DjButton = new JButton();
		usethislabeljCheckBoxMenuItem = new JCheckBoxMenuItem();
		refreshjMenuItem = new JMenuItem();
		plot3djMenuItem = new JMenuItem();
		parametric3djMenuItem = new JMenuItem();
		parametric2djMenuItem = new JMenuItem();
		languageinterpreterjMenu = new JMenu();
		tinybasicjRadioButtonMenuItem = new JRadioButtonMenuItem();
		languagelatexjRadioButtonMenuItem = new JRadioButtonMenuItem();
		TinyBasicjButton = new JButton();
		dehookjMenuItem = new JMenuItem();
		clusterpointsjMenuItem = new JMenuItem();
		plotParametric3DExp = "";
		plotParametric2DExp = "";
		plotParametric2DSelected = false;
		plotParametric3DSelected = false;
		try {
			numClassifiers = c;
			this.url = url;
			jbInit();
			DStroke.drawAsStroke = false;
			Symbol.drawBoundingBox = boundingboxjCheckBoxMenuItem4.getState();
			Symbol.drawLabel = labeljCheckBoxMenuItem6.getState();
			final ButtonGroup classifierTypeGroup = new ButtonGroup();
			classifierTypeRadioButtonMenuItem = new JRadioButtonMenuItem[classifierTypeName.length];
			for (int i = 0; i < numClassifiers; ++i) {
				(classifierTypeRadioButtonMenuItem[i] = new JRadioButtonMenuItem(
						classifierTypeName[i]))
						.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(final ActionEvent e) {
								HcrData.this
										.classifierTypeRadioButtonMenuI_actionPerformed(e);
							}
						});
				classifierTypeGroup.add(classifierTypeRadioButtonMenuItem[i]);
				symboljPopupMenu.add(classifierTypeRadioButtonMenuItem[i]);
			}
			l = new LogoJDialog(this, true, false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HcrData(final URL url) {
		this(url, 4);
	}

	public HcrData() {
		super();
		symbolData = new ArrayList<ArrayList<Symbol>>();
		images = new ArrayList<Object>();
		symbol = new ArrayList<Symbol>();
		selectedStrokes = new ArrayList<Object>();
		symbolMemoryUndoRedoData = new ArrayList<Object>();
		curentIndexUndoRedo = new ArrayList<Object>();
		index = -1;
		path = "";
		tmp = "";
		url = null;
		formulaThread = null;
		classifierType = 0;
		np = 16;
		saved = false;
		filename = "";
		classifierTypeName = new String[] { "Basic symbol", "Small letter",
				"Capital letter", "Greek letter", "Punctuation mark" };
		loadingModel = true;
		boundingboxOld = true;
		labelOld = true;
		orderStrokesProcessing = true;
		filteringProcessing = true;
		normalizeDirectionProcessing = 0.3f;
		tangentTransformationProcessing = 0.15f;
		sigmaSmoothingPreprocessing = 5.0f;
		windowSmoothingProcessing = 12;
		radiusEquidistantSamplingProcessing = 2.0f;
		pointsEquidistantSamplingProcessing = 32;
		pointsPolygonalApproximationProcessing = 32;
		processingSequenceProcessing = "1 1 10";
		newGenerated = false;
		isChanged = false;
		windowIndex = -1;
		oldPoint = null;
		selectStep = 0;
		jApplet = null;
		latexExp = "";
		mathExp = "";
		plotExp = "";
		solveExp = "";
		plot3DExp = "";
		downloadModelThread = null;
		texSelected = false;
		calculusSelected = false;
		plotSelected = false;
		plot3DSelected = false;
		plotParamSelected = false;
		plotParam3DSelected = false;
		solveSelected = false;
		backgroundImage = new Image[1];
		tan = null;
		symboldata = new String[] { "data/kbuchstaben0.col", "data/math0.col",
				"data/ggreek0.col", "data/kgreek0.col", "data/zahlen0.col" };
		symbolrecognizergroup = new ButtonGroup();
		DrawSelectButtonGroup = new ButtonGroup();
		modelname = "formula_";
		outputHeight = 300;
		NewImageIcon16 = new ImageIcon("icons/New16.gif");
		OpenImageIcon16 = new ImageIcon("icons/Open16.gif");
		CloseImageIcon16 = new ImageIcon("icons/Close16.gif");
		SaveImageIcon16 = new ImageIcon("icons/Save16.gif");
		SaveAsImageIcon16 = new ImageIcon("icons/SaveAs16.gif");
		BackImageIcon16 = new ImageIcon("icons/Back16.gif");
		PreviousPageImageIcon16 = new ImageIcon("icons/Back16.gif");
		NewDrawImageIcon16 = new ImageIcon("icons/NewDraw16.gif");
		NextPageImageIcon16 = new ImageIcon("icons/Forward16.gif");
		ForwardImageIcon16 = new ImageIcon("icons/Forward16.gif");
		RefreshDrawAreaImageIcon16 = new ImageIcon("icons/Refresh16.gif");
		UndoImageIcon16 = new ImageIcon("icons/Undo16.gif");
		RedoImageIcon16 = new ImageIcon("icons/Redo16.gif");
		CopyImageIcon16 = new ImageIcon("icons/Copy16.gif");
		PasteImageIcon16 = new ImageIcon("icons/Paste16.gif");
		CutImageIcon16 = new ImageIcon("icons/Cut16.gif");
		DeleteImageIcon16 = new ImageIcon("icons/Delete16.gif");
		DrawImageIcon16 = new ImageIcon("icons/Draw16.gif");
		SelectImageIcon16 = new ImageIcon("icons/Select16.gif");
		SelectStrokeImageIcon16 = new ImageIcon("icons/SelectStroke16.gif");
		SelectOpenStrokeImageIcon16 = new ImageIcon(
				"icons/SelectOpenStroke16.gif");
		MoveSymbolImageIcon16 = new ImageIcon("icons/OpenedHand.gif");
		GroupImageIcon16 = new ImageIcon("icons/Group16.gif");
		GroupOpenStrokeImageIcon16 = new ImageIcon(
				"icons/GroupOpenStroke16.gif");
		ToTeXImageIcon16 = new ImageIcon("icons/TeXNew.gif");
		ToMathematicaImageIcon16 = new ImageIcon("icons/Mathematica16.gif");
		CalculusImageIcon16 = new ImageIcon("icons/Calculus.png");
		Plot2DImageIcon16 = new ImageIcon("icons/Plot2D16.gif");
		Plot3DmaticaImageIcon16 = new ImageIcon("icons/Plot3D16.gif");
		NullImageIcon16 = new ImageIcon("icons/Null16.gif");
		NewImageIcon24 = new ImageIcon("icons/New24.gif");
		OpenImageIcon24 = new ImageIcon("icons/Open24.gif");
		CloseImageIcon24 = new ImageIcon("icons/Close24.gif");
		SaveImageIcon24 = new ImageIcon("icons/Save24.gif");
		SaveAsImageIcon24 = new ImageIcon("icons/SaveAs24.gif");
		BackImageIcon24 = new ImageIcon("icons/Back24.gif");
		PreviousPageImageIcon24 = new ImageIcon("icons/Back24.gif");
		NewDrawImageIcon24 = new ImageIcon("icons/NewDraw24.gif");
		NextPageImageIcon24 = new ImageIcon("icons/Forward24.gif");
		ForwardImageIcon24 = new ImageIcon("icons/Forward24.gif");
		RefreshDrawAreaImageIcon24 = new ImageIcon("icons/Refresh24.gif");
		UndoImageIcon24 = new ImageIcon("icons/Undo24.gif");
		RedoImageIcon24 = new ImageIcon("icons/Redo24.gif");
		CopyImageIcon24 = new ImageIcon("icons/Copy24.gif");
		PasteImageIcon24 = new ImageIcon("icons/Paste24.gif");
		CutImageIcon24 = new ImageIcon("icons/Cut24.gif");
		DeleteImageIcon24 = new ImageIcon("icons/Delete24.gif");
		DrawImageIcon24 = new ImageIcon("icons/Draw24.gif");
		SelectImageIcon24 = new ImageIcon("icons/Select24.gif");
		SelectStrokeImageIcon24 = new ImageIcon("icons/SelectStroke24.gif");
		SelectOpenStrokeImageIcon24 = new ImageIcon(
				"icons/SelectOpenStroke24.gif");
		MoveSymbolImageIcon24 = new ImageIcon("icons/OpenedHand.gif");
		GroupImageIcon24 = new ImageIcon("icons/Group24.gif");
		GroupOpenStrokeImageIcon24 = new ImageIcon(
				"icons/GroupOpenStroke24.gif");
		ToTeXImageIcon24 = new ImageIcon("icons/TeXNew.gif");
		ToMathematicaImageIcon24 = new ImageIcon("icons/Mathematica24.gif");
		Plot2DImageIcon24 = new ImageIcon("icons/Plot2D24.gif");
		Plot3DmaticaImageIcon24 = new ImageIcon("icons/Plot3D24.gif");
		PlotParam2DImageIcon16 = new ImageIcon("icons/PlotParam2D16.gif");
		PlotParam3DImageIcon16 = new ImageIcon("icons/PlotParam3D16.gif");
		BImageIcon = new ImageIcon("icons/B.png");
		viewingjPanel = new JPanel();
		viewjPanel = new JPanel();
		exampleJPanel = new SymbolDrawJPanel(350, 200);
		gridBagLayout4 = new GridBagLayout();
		symboljComboBox = new JComboBox<StringBuffer>();
		nameSymboljTextField = new JTextField();
		messagesjScrollPane = new JScrollPane();
		messagesjTextArea = new JTextArea();
		borderLayout1 = new BorderLayout();
		jMenuBar1 = new JMenuBar();
		filejMenu = new JMenu();
		exitjMenuItem = new JMenuItem();
		newjMenuItem = new JMenuItem();
		savejMenuItem = new JMenuItem();
		saveasjMenuItem = new JMenuItem();
		closejMenuItem = new JMenuItem();
		openjMenuItem = new JMenuItem();
		viewjMenu = new JMenu();
		ungroupjToggleButton = new JToggleButton();
		pointsjCheckBoxMenuItem1 = new JCheckBoxMenuItem();
		directionjCheckBoxMenuItem2 = new JCheckBoxMenuItem();
		asstrokejRadioButtonMenuItem = new JRadioButtonMenuItem();
		aspolygonaljRadioButtonMenuItem = new JRadioButtonMenuItem();
		indexjCheckBoxMenuItem3 = new JCheckBoxMenuItem();
		boundingboxjCheckBoxMenuItem4 = new JCheckBoxMenuItem();
		allpropertiesjCheckBoxMenuItem5 = new JCheckBoxMenuItem();
		processingjMenu = new JMenu();
		jRadioButtonMenuItem2 = new JRadioButtonMenuItem();
		allgroupsjRadioButtonMenuItem = new JRadioButtonMenuItem();
		jRadioButtonMenuItem5 = new JRadioButtonMenuItem();
		filteringjMenuItem = new JMenuItem();
		smoothingjMenuItem = new JMenuItem();
		equidistantjMenuItem = new JMenuItem();
		normalizejMenuItem = new JMenuItem();
		orderjMenuItem = new JMenuItem();
		UndoJMenuItem2 = new JMenuItem();
		processingparametersjMenuItem = new JMenuItem();
		gropupingjMenu = new JMenu();
		jRadioButtonMenuItem6 = new JRadioButtonMenuItem();
		jRadioButtonMenuItem7 = new JRadioButtonMenuItem();
		jRadioButtonMenuItem8 = new JRadioButtonMenuItem();
		jRadioButtonMenuItem9 = new JRadioButtonMenuItem();
		jRadioButtonMenuItem10 = new JRadioButtonMenuItem();
		jRadioButtonMenuItem11 = new JRadioButtonMenuItem();
		jRadioButtonMenuItem12 = new JRadioButtonMenuItem();
		jRadioButtonMenuItem13 = new JRadioButtonMenuItem();
		jRadioButtonMenuItem14 = new JRadioButtonMenuItem();
		jRadioButtonMenuItem15 = new JRadioButtonMenuItem();
		jRadioButtonMenuItem16 = new JRadioButtonMenuItem();
		labeljCheckBoxMenuItem6 = new JCheckBoxMenuItem();
		classfiersjMenu = new JMenu();
		UndojMenuItem = new JMenuItem();
		saveastrainingjMenuItem = new JMenuItem();
		numberofpointsjCheckBoxMenuItem7 = new JCheckBoxMenuItem();
		tangenttransformationjMenuItem = new JMenuItem();
		parametersviewUndoJMenuItem = new JMenuItem();
		antialiasjCheckBoxMenuItem = new JCheckBoxMenuItem();
		symboljPopupMenu = new JPopupMenu();
		labelJTextField = new JTextField(15);
		HelpMenu = new JMenu();
		aboutjMenuItem = new JMenuItem();
		changelabeljMenuItem = new JMenuItem();
		labeljMenuItem = new JMenuItem();
		poligonaljMenuItem = new JMenuItem();
		jMenuItem2 = new JMenuItem();
		jMenuItem3 = new JMenuItem();
		jMenu1 = new JMenu();
		graphicoutputjCheckBoxMenuItem = new JCheckBoxMenuItem();
		groupjPopupMenu = new JPopupMenu();
		previousjMenuItem = new JMenuItem();
		nextjMenuItem = new JMenuItem();
		newGroupjMenuItem = new JMenuItem();
		texjMenuItem = new JMenuItem();
		evaluatejMenuItem = new JMenuItem();
		showjMenuItem = new JMenuItem();
		removejMenuItem = new JMenuItem();
		defaultclassifierjMenu2 = new JMenu();
		basicjRadioButtonMenuItem = new JRadioButtonMenuItem();
		smalljRadioButtonMenuItem = new JRadioButtonMenuItem();
		capitaljRadioButtonMenuItem = new JRadioButtonMenuItem();
		greekjRadioButtonMenuItem1 = new JRadioButtonMenuItem();
		punctuationjRadioButtonMenuItem = new JRadioButtonMenuItem();
		commandinterpreterjCheckBoxMenuItem = new JCheckBoxMenuItem();
		expressionjTextField = new JTextField();
		jMenu3 = new JMenu();
		jRadioButtonMenuItem1 = new JRadioButtonMenuItem();
		jRadioButtonMenuItem3 = new JRadioButtonMenuItem();
		dominancejCheckBoxMenuItem = new JCheckBoxMenuItem();
		jRadioButtonMenuItem4 = new JRadioButtonMenuItem();
		readformulajCheckBoxMenuItem = new JCheckBoxMenuItem();
		language = new ButtonGroup();
		tt = null;
		ngroups = 1;
		backgroundImagejCheckBoxMenuItem = new JCheckBoxMenuItem();
		backgroundCheckBoxMenuItem1 = new JCheckBoxMenuItem();
		dominancemstUndoJMenuItem = new JMenuItem();
		minimumspanningtreejMenuItem4 = new JMenuItem();
		spatialrelationjMenuItem = new JMenuItem();
		usedominancejCheckBoxMenuItem2 = new JCheckBoxMenuItem();
		attractorsjCheckBoxMenuItem2 = new JCheckBoxMenuItem();
		distancefactorjCheckBoxMenuItem = new JCheckBoxMenuItem();
		spatialareasUndoJMenuItem = new JMenuItem();
		img = null;
		backgorundConstructed = false;
		jMenu2 = new JMenu();
		jMenuItem4 = new JMenuItem();
		supportArrayListjRadioButtonMenuItem17 = new JRadioButtonMenuItem();
		nearestneighborsjRadioButtonMenuItem18 = new JRadioButtonMenuItem();
		usehorizontalfactorjCheckBoxMenuItem = new JCheckBoxMenuItem();
		verticalhistogramjMenuItem = new JMenuItem();
		horizontalhistogramjMenuItem = new JMenuItem();
		checkMSTMatrixMemoryjCheckBoxMenuItem = new JCheckBoxMenuItem();
		EditJToolBar = new JToolBar();
		NewJButton = new JButton();
		OpenJButton = new JButton();
		CloseJButton = new JButton();
		SaveJButton = new JButton();
		UndoJButton = new JButton();
		RedoJButton = new JButton();
		CopyJButton = new JButton();
		PasteJButton = new JButton();
		CutJButton = new JButton();
		RemoveAllJButton = new JButton();
		DrawJToggleButton = new JToggleButton();
		SelectJToggleButton = new JToggleButton();
		SelectClosedStrokeJToggleButton = new JToggleButton();
		NavigationAndToolsJToolBar = new JToolBar();
		jButton3 = new JButton();
		BackJButton = new JButton();
		NewDrawJButton = new JButton();
		ForwardJButton = new JButton();
		GroupNameJComboBox = new JComboBox<Object>();
		ToTeXJButton = new JButton();
		ToMathematicaJButton = new JButton();
		Plot2DJButton = new JButton();
		Plot3DJButton = new JButton();
		SelectOpenStrokeToggleButton = new JToggleButton();
		SelectOpenStrokeJToggleButton = new JToggleButton();
		jButton2 = new JButton();
		PreviousPageJButton = new JButton();
		NextPageJButton = new JButton();
		RefreshDrawAreaButton = new JButton();
		RefreshDrawAreaJButton = new JButton();
		DrawJSplitPane = new JSplitPane();
		drawJPanel = new SymbolDrawJPanel(1024, 768, true);
		drawingjPanel = new JPanel();
		borderLayout3 = new BorderLayout();
		gridBagLayout2 = new GridBagLayout();
		ViewJSplitPane = new JSplitPane();
		drawjScrollPane = new JScrollPane();
		gridBagLayout1 = new GridBagLayout();
		examplejScrollPane = new JScrollPane();
		EditJMenu = new JMenu();
		UndoJMenuItem = new JMenuItem();
		RedoJMenuItem = new JMenuItem();
		CutJMenuItem = new JMenuItem();
		CopyJMenuItem = new JMenuItem();
		SelectAllJMenuItem = new JMenuItem();
		PasteJMenuItem = new JMenuItem();
		MoveJToggleButton = new JToggleButton();
		copyPasteMemory = new ArrayList<Symbol>();
		GroupJToggleButton = new JToggleButton();
		GroupOpenStrokeToggleButton = new JToggleButton();
		symbolmstjMenuItem = new JMenuItem();
		dominancehorizontalfactorjCheckBoxMenuItem = new JCheckBoxMenuItem();
		GroupSelectionjButton = new JButton();
		doublesidedjCheckBoxMenuItem = new JCheckBoxMenuItem();
		lowvelocityjCheckBoxMenuItem = new JCheckBoxMenuItem();
		highcurvaturejCheckBoxMenuItem = new JCheckBoxMenuItem();
		checkHorizontalBarjMenuItem = new JMenuItem();
		TreeJMenu = new JMenu();
		PlotParam2DjButton = new JButton();
		PlotParam3DjButton = new JButton();
		usethislabeljCheckBoxMenuItem = new JCheckBoxMenuItem();
		refreshjMenuItem = new JMenuItem();
		plot3djMenuItem = new JMenuItem();
		parametric3djMenuItem = new JMenuItem();
		parametric2djMenuItem = new JMenuItem();
		languageinterpreterjMenu = new JMenu();
		tinybasicjRadioButtonMenuItem = new JRadioButtonMenuItem();
		languagelatexjRadioButtonMenuItem = new JRadioButtonMenuItem();
		TinyBasicjButton = new JButton();
		dehookjMenuItem = new JMenuItem();
		clusterpointsjMenuItem = new JMenuItem();
		plotParametric3DExp = "";
		plotParametric2DExp = "";
		plotParametric2DSelected = false;
		plotParametric3DSelected = false;
		try {
			numClassifiers = classifierTypeName.length;
			readImageIcon();
			jbInit();
			path = System.getProperty("user.dir")
					+ System.getProperty("file.separator");
			System.out.println("path: " + path);
			if (System.getProperty("os.name").equals("Linux")) {
				tmp = "/tmp/";
			} else {
				tmp = "C:/WINDOWS/TEMP/";
			}
			System.out.println("tmp: " + tmp);
			DStroke.drawAsStroke = false;
			Symbol.drawBoundingBox = boundingboxjCheckBoxMenuItem4.getState();
			Symbol.drawLabel = labeljCheckBoxMenuItem6.getState();
			final ButtonGroup classifierTypeGroup = new ButtonGroup();
			classifierTypeRadioButtonMenuItem = new JRadioButtonMenuItem[classifierTypeName.length];
			for (int i = 0; i < classifierTypeName.length; ++i) {
				(classifierTypeRadioButtonMenuItem[i] = new JRadioButtonMenuItem(
						classifierTypeName[i]))
						.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(final ActionEvent e) {
								HcrData.this
										.classifierTypeRadioButtonMenuI_actionPerformed(e);
							}
						});
				classifierTypeGroup.add(classifierTypeRadioButtonMenuItem[i]);
				symboljPopupMenu.add(classifierTypeRadioButtonMenuItem[i]);
			}
			l = new LogoJDialog(this, true, false);
			final Dimension dimension = Toolkit.getDefaultToolkit()
					.getScreenSize();
			setTitle("JMathNotes");
			setSize((int) (0.8 * dimension.getWidth()),
					(int) (0.8 * dimension.getHeight()));
			DrawJSplitPane.setDividerLocation(getHeight() - outputHeight);
			ViewJSplitPane.setDividerLocation((int) (0.5 * getWidth()));
			drawingjPanel.setMinimumSize(new Dimension((int) dimension
					.getWidth(), getHeight() - outputHeight));
			setVisible(true);
			drawJPanel.initializeGraphics();
			drawJPanel.setDrawRadius(3.0f);
			drawJPanel.setDrawable(true);
			drawJPanel.setAntialias(true);
			drawJPanel.setDrawColor(Color.black);
			drawJPanel.setBackground(Color.white);
			drawJPanel.setDrawing();
			drawJPanel.erase();
			exampleJPanel.initializeGraphics();
			exampleJPanel.setDrawRadius(3.0f);
			exampleJPanel.setBackground(Color.white);
			exampleJPanel.setDrawColor(Color.black);
			exampleJPanel.erase();
			newGenerated = true;
			symboljComboBox.addItem(new StringBuffer("Page 1 of 1"));
			index = symbolData.size();
			symbol = new ArrayList<Symbol>();
			symbolData.add(symbol);
			drawJPanel.setStrokeMemory(symbol);
			symboljComboBox.setSelectedIndex(index);
			newGenerated = false;
			undoManager_ = new UndoManager();
			(undoSupport_ = new UndoableEditSupport())
					.addUndoableEditListener(new UndoAdapter());
			refreshUndoRedo();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void BackJButton_actionPerformed(final ActionEvent e) {
		if (symbolData.size() > 1) {
			index = 1;
			PreviousPageJButton_actionPerformed(e);
		}
	}

	void CopyJButton_actionPerformed(final ActionEvent e) {
		if (drawJPanel.isStrokeSelected()) {
			final Symbol s = new Symbol();
			final boolean[][] indexes = drawJPanel.getStrokeSelectedIndexes();
			copyPasteMemory.clear();
			for (int i = 0; i < indexes.length; ++i) {
				for (int j = 0; j < indexes[i].length; ++j) {
					if (indexes[i][j]) {
						s.add(new DStroke(symbol.get(i).strokeAt(j)));
					}
				}
				if (!s.isEmpty()) {
					classify(s);
					copyPasteMemory.add(new Symbol(s));
				}
				s.clear();
			}
		} else if (drawJPanel.isSymbolSelected()) {
			final boolean[] indexes2 = drawJPanel.getSymbolSelectedIndexes();
			copyPasteMemory.clear();
			for (int i = 0; i < indexes2.length; ++i) {
				final Symbol s = symbol.get(i);
				if (indexes2[i]) {
					classify(s);
					copyPasteMemory.add(new Symbol(s));
				}
			}
		}
		PasteJButton.setEnabled(!copyPasteMemory.isEmpty());
		PasteJMenuItem.setEnabled(!copyPasteMemory.isEmpty());
	}

	void CopyJMenuItem_actionPerformed(final ActionEvent e) {
		CopyJButton_actionPerformed(e);
	}

	void CutJButton_actionPerformed(final ActionEvent e) {
		CopyJButton_actionPerformed(e);
		if (drawJPanel.isSymbolSelected()) {
			final Edit edit = new CutSymbolEdit(this, index);
			edit.execute();
			undoSupport_.postEdit(edit);
		} else if (drawJPanel.isStrokeSelected()) {
			final Edit edit = new CutStrokeEdit(this, index);
			edit.execute();
			undoSupport_.postEdit(edit);
		}
		isChanged = true;
	}

	void CutJMenuItem_actionPerformed(final ActionEvent e) {
		CutJButton_actionPerformed(e);
	}

	void DrawJToggleButton_actionPerformed(final ActionEvent e) {
		drawJPanel.setDrawing();
		drawJPanel.setStrokeSelectedIndexes(null, false);
		drawJPanel.setSymbolSelectedIndexes(null, false);
		CopyJButton.setEnabled(false);
		CopyJMenuItem.setEnabled(false);
		CutJButton.setEnabled(false);
		CutJMenuItem.setEnabled(false);
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
	}

	void ForwardJButton_actionPerformed(final ActionEvent e) {
		if (symbolData.size() > 1) {
			index = symbolData.size() - 2;
			NextPageJButton_actionPerformed(e);
		}
	}

	void GroupSelectionjButton_actionPerformed(final ActionEvent e) {
		if (drawJPanel.isSymbolSelected()) {
			final Edit edit = new GroupUngroupSymbolEdit(this, index);
			edit.execute();
			undoSupport_.postEdit(edit);
		} else if (drawJPanel.isStrokeSelected()) {
			final Edit edit = new GroupUngroupStrokeEdit(this, index);
			edit.execute();
			undoSupport_.postEdit(edit);
		}
	}

	void MoveJButton_actionPerformed(final ActionEvent e) {
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
	}

	void MoveJToggleButton_actionPerformed(final ActionEvent e) {
		drawJPanel.setMoving();
	}

	void NewDrawJButton_actionPerformed(final ActionEvent e) {
		newSymboljButton_actionPerformed(e);
	}

	void NewJButton_actionPerformed(final ActionEvent e) {
	}

	void NextPageJButton_actionPerformed(final ActionEvent e) {
		forwardjButton_actionPerformed(e);
	}

	void OpenJButton_actionPerformed(final ActionEvent e) {
		openjMenuItem_actionPerformed(e);
	}

	void PasteJButton_actionPerformed(final ActionEvent e) {
		if (drawJPanel.isSymbolSelected()) {
			final Edit edit = new PasteSymbolEdit(this, index);
			edit.execute();
			undoSupport_.postEdit(edit);
		} else if (drawJPanel.isStrokeSelected()) {
			final Edit edit = new PasteStrokeEdit(this, index);
			edit.execute();
			undoSupport_.postEdit(edit);
		} else if (!copyPasteMemory.isEmpty()) {
			final Edit edit = new CutPasteSymbolEdit(this, index);
			edit.execute();
			undoSupport_.postEdit(edit);
		}
	}

	void PasteJMenuItem_actionPerformed(final ActionEvent e) {
		PasteJButton_actionPerformed(e);
	}

	void Plot2DJButton_actionPerformed(final ActionEvent e) {
		graphicsjButton_actionPerformed(e);
	}

	void Plot3DJButton_actionPerformed(final ActionEvent e) {
		if (symbol.isEmpty()) {
			return;
		}
		final SymbolList sl = new SymbolList();
		for (int i = 0; i < symbol.size(); ++i) {
			final Symbol s = symbol.get(i);
			sl.add(new SymbolNode((int) s.getMinX(), (int) s.getMinY(), (int) s
					.getMaxX(), (int) s.getMaxY(), s.name));
		}
		sl.sort();
		final BaselineStructureTree bst = new BaselineStructureTree(sl);
		bst.buildTree();
		plot3DExp = "\\!\\(" + bst.interpretMathematica() + "\\)";
		messagesjTextArea.append("Plot3D: " + plotExp + "\n");
		expressionjTextField.setText(plot3DExp);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
		plot3DSelected = true;
		if (graphicoutputjCheckBoxMenuItem.getState()) {
			new Plot3DThread().start();
		}
	}

	void PlotParam2DjButton_actionPerformed(final ActionEvent e) {
		if (symbol.isEmpty()) {
			return;
		}
		final SymbolList sl = new SymbolList();
		for (int i = 0; i < symbol.size(); ++i) {
			final Symbol s = symbol.get(i);
			sl.add(new SymbolNode((int) s.getMinX(), (int) s.getMinY(), (int) s
					.getMaxX(), (int) s.getMaxY(), s.name));
		}
		sl.sort();
		final BaselineStructureTree bst = new BaselineStructureTree(sl);
		bst.buildTree();
		plotParametric2DExp = bst.interpretMathematica();
		final StringTokenizer st = new StringTokenizer(plotParametric2DExp,
				"{}");
		if (st.countTokens() == 3) {
			final String token = oldReplace(st.nextToken(), ",", "\\),\\!\\(");
			plotParametric2DExp = "{\\!\\(" + token + "\\)}" + st.nextToken()
					+ "{" + st.nextToken() + "}";
		}
		messagesjTextArea.append("PlotParametric2D: " + plotParametric2DExp
				+ "\n");
		expressionjTextField.setText(plotParametric2DExp);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
		plotParametric2DSelected = true;
		if (graphicoutputjCheckBoxMenuItem.getState()) {
			new PlotParametric2DThread().start();
		}
	}

	void PlotParam3DjButton_actionPerformed(final ActionEvent e) {
		if (symbol.isEmpty()) {
			return;
		}
		final SymbolList sl = new SymbolList();
		for (int i = 0; i < symbol.size(); ++i) {
			final Symbol s = symbol.get(i);
			sl.add(new SymbolNode((int) s.getMinX(), (int) s.getMinY(), (int) s
					.getMaxX(), (int) s.getMaxY(), s.name));
		}
		sl.sort();
		final BaselineStructureTree bst = new BaselineStructureTree(sl);
		bst.buildTree();
		plotParametric3DExp = bst.interpretMathematica();
		final StringTokenizer st = new StringTokenizer(plotParametric3DExp,
				"{}");
		if (st.countTokens() == 5) {
			final String token = oldReplace(st.nextToken(), ",", "\\),\\!\\(");
			plotParametric3DExp = "{\\!\\(" + token + "\\)}" + st.nextToken()
					+ "{" + st.nextToken() + "}" + st.nextToken() + "{"
					+ st.nextToken() + "}";
		} else if (st.countTokens() == 3) {
			final String token = oldReplace(st.nextToken(), ",", "\\),\\!\\(");
			plotParametric3DExp = "{\\!\\(" + token + "\\)}" + st.nextToken()
					+ "{" + st.nextToken() + "}";
		}
		messagesjTextArea.append("PlotParametric3D: " + plotParametric3DExp
				+ "\n");
		expressionjTextField.setText(plotParametric3DExp);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
		plotParametric3DSelected = true;
		if (graphicoutputjCheckBoxMenuItem.getState()) {
			new PlotParametric3DThread().start();
		}
	}

	void PreviousPageJButton_actionPerformed(final ActionEvent e) {
		backwardjButton_actionPerformed(e);
	}

	void RedoJButton_actionPerformed(final ActionEvent e) {
		undoManager_.redo();
		refreshUndoRedo();
		isChanged = true;
	}

	void RedoJMenuItem_actionPerformed(final ActionEvent e) {
		undoManager_.redo();
		refreshUndoRedo();
		isChanged = true;
	}

	void RefreshDrawAreaJButton_actionPerformed(final ActionEvent e) {
		drawJPanel.initializeBackgroundImage();
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
	}

	void RemoveAllJButton_actionPerformed(final ActionEvent e) {
		deletegroupjButton_actionPerformed(e);
	}

	void SaveJButton_actionPerformed(final ActionEvent e) {
		savejMenuItem_actionPerformed(e);
	}

	void SelectAllJMenuItem_actionPerformed(final ActionEvent e) {
		if (!symbol.isEmpty()) {
			final boolean[] idx = new boolean[symbol.size()];
			for (int i = 0; i < idx.length; ++i) {
				idx[i] = true;
			}
			drawJPanel.setSymbolSelectedIndexes(idx, true);
			drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
			drawJPanel.drawStrokeMemorySelectedSymbols();
			SelectJToggleButton.setSelected(true);
			drawJPanel.setSymbolSelecting();
			CutJButton.setEnabled(true);
			CutJMenuItem.setEnabled(true);
			CopyJButton.setEnabled(true);
			CopyJMenuItem.setEnabled(true);
		}
	}

	void SelectClosedStrokeJToggleButton_actionPerformed(final ActionEvent e) {
		drawJPanel.setClosedStrokeSelecting();
	}

	void SelectJToggleButton_actionPerformed(final ActionEvent e) {
		drawJPanel.setSymbolSelecting();
	}

	void SelectOpenStrokeJToggleButton_actionPerformed(final ActionEvent e) {
		drawJPanel.setOpenStrokeSelecting();
	}

	void TinyBasicjButton_actionPerformed(final ActionEvent e) {
		if (symbol.isEmpty()) {
			return;
		}
		final SymbolList sl = new SymbolList();
		for (int i = 0; i < symbol.size(); ++i) {
			final Symbol s = symbol.get(i);
			sl.add(new SymbolNode((int) s.getMinX(), (int) s.getMinY(), (int) s
					.getMaxX(), (int) s.getMaxY(), s.name));
		}
		final SymbolNode dummy = new SymbolNode(sl.getMinX() - 30,
				sl.getMinY(), sl.getMinX(), sl.getMaxY(), "[");
		sl.add(dummy);
		sl.sort();
		final BaselineStructureTree bst = new BaselineStructureTree(sl);
		bst.buildTree();
		final String code = bst.interpretBasic();
		messagesjTextArea.append(code + "\n\n");
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
		calculusSelected = true;
		ProgramMemory.ta = messagesjTextArea;
		ProgramMemory.interpret(code);
	}

	void ToMathematicaJButton_actionPerformed(final ActionEvent e) {
		calculusExecute(e);
	}

	void ToTeXJButton_actionPerformed(final ActionEvent e) {
		texjMenuItem_actionPerformed(e);
	}

	void UndoJButton_actionPerformed(final ActionEvent e) {
		undoManager_.undo();
		refreshUndoRedo();
		isChanged = true;
	}

	void UndoJMenuItem_actionPerformed(final ActionEvent e) {
		undoManager_.undo();
		refreshUndoRedo();
		isChanged = true;
	}

	void aboutjMenuItem_actionPerformed(final ActionEvent e) {
		new LogoJDialog(this, true, true);
	}

	public void actualizeExample() {
		try {
			exampleJPanel.erase();
			if (examplejScrollPane.getWidth() > img.getWidth(this)) {
				if (examplejScrollPane.getHeight() > img.getHeight(this)) {
					exampleJPanel.getGraphics2D().drawImage(
							img,
							examplejScrollPane.getWidth() / 2
									- img.getWidth(this) / 2,
							examplejScrollPane.getHeight() / 2
									- img.getHeight(this) / 2, this);
				} else {
					examplejScrollPane.setVerticalScrollBarPolicy(20);
					exampleJPanel.getGraphics2D().drawImage(
							img,
							examplejScrollPane.getWidth() / 2
									- img.getWidth(this) / 2, 0, this);
				}
			} else {
				examplejScrollPane.setHorizontalScrollBarPolicy(30);
				if (examplejScrollPane.getHeight() > img.getHeight(this)) {
					exampleJPanel.getGraphics2D().drawImage(
							img,
							0,
							examplejScrollPane.getHeight() / 2
									- img.getHeight(this) / 2, this);
				} else {
					examplejScrollPane.setVerticalScrollBarPolicy(20);
					exampleJPanel.getGraphics2D().drawImage(img, 0, 0, this);
				}
			}
			exampleJPanel.repaint();
		} catch (NullPointerException e) {
		}
	}

	void actualizeSymboljComboBox(final boolean add) {
		if (add) {
			newGenerated = true;
			symboljComboBox.addItem(new StringBuffer("Page "
					+ symbolData.size() + " of " + symbolData.size()));
		} else {
			newGenerated = false;
		}
		for (int i = 0; i < symboljComboBox.getItemCount(); ++i) {
			final StringBuffer sb = symboljComboBox.getItemAt(i);
			sb.delete(0, sb.length());
			sb.append("Page " + (i + 1) + " of "
					+ symboljComboBox.getItemCount());
		}
		if (add) {
			index = symbolData.size();
			symboljComboBox.setSelectedIndex(index);
		}
	}

	public static void addHcrWindow(final HcrData hcr) {
		HcrData.window.add(hcr);
	}

	public void addToStrokeMemory(final boolean ispunctuation) {
		boolean intersected = false;
		final Symbol s = new Symbol();
		if (!ispunctuation) {
			final boolean[][] indexes = selectedIndexes();
			for (int i = indexes.length - 1; i > -1; --i) {
				intersected = false;
				for (int j = indexes[i].length - 1; j > -1
						&& !(intersected = indexes[i][j]); --j) {
				}
				if (intersected) {
					final Symbol t = symbol.get(i);
					for (int k = 0; k < t.size(); ++k) {
						s.add(t.strokeAt(k));
					}
					symbol.remove(i);
				}
			}
		}
		s.add(drawJPanel.getInputStroke());
		symbol.add(s);
		isChanged = true;
		purgeSymbol();
	}

	public void addToStrokeMemory() {
		addToStrokeMemory(false);
	}

	void allpropertiesjCheckBoxMenuItem5_actionPerformed(final ActionEvent e) {
		if (allpropertiesjCheckBoxMenuItem5.getState()) {
			pointsOld = pointsjCheckBoxMenuItem1.getState();
			directionOld = directionjCheckBoxMenuItem2.getState();
			indexOld = indexjCheckBoxMenuItem3.getState();
			boundingboxOld = boundingboxjCheckBoxMenuItem4.getState();
			numberofpointsOld = numberofpointsjCheckBoxMenuItem7.getState();
			labelOld = labeljCheckBoxMenuItem6.getState();
			pointsjCheckBoxMenuItem1.setState(true);
			indexjCheckBoxMenuItem3.setState(true);
			directionjCheckBoxMenuItem2.setState(true);
			boundingboxjCheckBoxMenuItem4.setState(true);
			numberofpointsjCheckBoxMenuItem7.setState(true);
			labeljCheckBoxMenuItem6.setState(true);
		} else {
			pointsjCheckBoxMenuItem1.setState(pointsOld);
			indexjCheckBoxMenuItem3.setState(indexOld);
			directionjCheckBoxMenuItem2.setState(directionOld);
			boundingboxjCheckBoxMenuItem4.setState(boundingboxOld);
			numberofpointsjCheckBoxMenuItem7.setState(numberofpointsOld);
			labeljCheckBoxMenuItem6.setState(labelOld);
		}
		DStroke.drawPoints = pointsjCheckBoxMenuItem1.getState();
		DStroke.drawDirection = directionjCheckBoxMenuItem2.getState();
		Symbol.drawIndex = indexjCheckBoxMenuItem3.getState();
		Symbol.drawBoundingBox = boundingboxjCheckBoxMenuItem4.getState();
		Symbol.drawNumberOfPoints = numberofpointsjCheckBoxMenuItem7.getState();
		Symbol.drawLabel = labeljCheckBoxMenuItem6.getState();
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
	}

	void antialiasjCheckBoxMenuItem_actionPerformed(final ActionEvent e) {
		drawJPanel.setAntialias(antialiasjCheckBoxMenuItem.getState());
		DStroke.antialias = antialiasjCheckBoxMenuItem.getState();
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
	}

	void aspolygonaljRadioButtonMenuItem_actionPerformed(final ActionEvent e) {
		drawJPanel.setDrawRadius(1.0f);
		DStroke.drawAsStroke = false;
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
	}

	void asstrokejRadioButtonMenuItem_actionPerformed(final ActionEvent e) {
		drawJPanel.setDrawRadius(3.0f);
		DStroke.drawAsStroke = true;
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
	}

	void attractorsdistancefactorjCheckBoxMenuItem_actionPerformed(
			final ActionEvent e) {
		SymbolNode.drawAttractors = attractorsjCheckBoxMenuItem2.getState();
	}

	void backgroundCheckBoxMenuItem1_actionPerformed(final ActionEvent e) {
		System.out.println("backgorundConstructed: " + backgorundConstructed);
		if (!backgorundConstructed) {
			System.out.println("backgorundConstructed: "
					+ backgorundConstructed);
			backgorundConstructed = true;
		}
		System.out.println(backgroundCheckBoxMenuItem1.getState());
		SymbolDrawJPanel.drawBackgroundImage = backgroundCheckBoxMenuItem1
				.getState();
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
	}

	void backgroundImagejCheckBoxMenuItem_actionPerformed(final ActionEvent e) {
		System.out.println("backgorundConstructed: " + backgorundConstructed);
		if (backgorundConstructed) {
			System.out.println("backgorundConstructed: "
					+ backgorundConstructed);
			constructBackgroundImages();
			backgorundConstructed = true;
		}
		System.out.println(backgroundImagejCheckBoxMenuItem.getState());
		SymbolDrawJPanel.drawBackgroundImage = backgroundImagejCheckBoxMenuItem
				.getState();
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
	}

	void backwardjButton_actionPerformed(final ActionEvent e) {
		if (index > 0) {
			drawJPanel.setStrokeSelectedIndexes(null, false);
			drawJPanel.setSymbolSelectedIndexes(null, false);
			--index;
			symbol = symbolData.get(index);
			drawJPanel
					.setStrokeMemory(symbol, backgroundImage[index % ngroups]);
			symboljComboBox.setSelectedIndex(index);
		}
	}

	void basicjRadioButtonMenuItem_actionPerformed(final ActionEvent e) {
		classifierType = 0;
	}

	void boundingboxjCheckBoxMenuItem4_actionPerformed(final ActionEvent e) {
		final boolean state = boundingboxjCheckBoxMenuItem4.getState();
		boundingboxOld = state;
		Symbol.drawBoundingBox = state;
		if (!boundingboxOld) {
			allpropertiesjCheckBoxMenuItem5.setState(false);
		}
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
	}

	void calculusExecute(final ActionEvent e) {
		calculusSelected = true;
		calculusjButton_actionPerformed(e);
		calculusSelected = false;
	}

	void calculusjButton_actionPerformed(final ActionEvent e) {
		if (symbol.isEmpty()) {
			return;
		}
		final SymbolList sl = new SymbolList();
		for (int i = 0; i < symbol.size(); ++i) {
			final Symbol s = symbol.get(i);
			sl.add(new SymbolNode((int) s.getMinX(), (int) s.getMinY(), (int) s
					.getMaxX(), (int) s.getMaxY(), s.name));
		}
		sl.sort();
		final BaselineStructureTree bst = new BaselineStructureTree(sl);
		bst.buildTree();
		mathExp = bst.interpretMathematica();
		if (calculusSelected) {
			mathExp = "\\!\\(" + mathExp + "\\)";
		} else if (solveSelected) {
			mathExp = "Solve[\\!\\(" + mathExp + "\\),x]";
		}
		messagesjTextArea.append(mathExp + "\n\n");
		expressionjTextField.setText(mathExp);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
		calculusSelected = true;
		if (graphicoutputjCheckBoxMenuItem.getState()) {
			new CalculusThread().start();
		}
	}

	void capitaljRadioButtonMenuItem_actionPerformed(final ActionEvent e) {
		classifierType = 2;
	}

	void checkHorizontalBarjMenuItem_actionPerformed(final ActionEvent e) {
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
		final SymbolList sl = new SymbolList();
		for (int i = 0; i < symbol.size(); ++i) {
			final Symbol s = symbol.get(i);
			sl.add(new SymbolNode((int) s.getMinX(), (int) s.getMinY(), (int) s
					.getMaxX(), (int) s.getMaxY(), s.name));
		}
		sl.sort();
		final SymbolList tree = BaselineStructureTree.checkHorizontalBar(sl);
		tree.drawDad(drawJPanel.getGraphics2D());
		tree.drawSomeUpDown(drawJPanel.getGraphics2D());
	}

	void checkMSTMatrixMemoryjCheckBoxMenuItem_actionPerformed(
			final ActionEvent e) {
		MSTMatrix.checkMatrixMemory = checkMSTMatrixMemoryjCheckBoxMenuItem
				.getState();
	}

	void classifierTypeRadioButtonMenuI_actionPerformed(final ActionEvent e) {
		JRadioButtonMenuItem rb;
		int i;
		for (rb = (JRadioButtonMenuItem) e.getSource(), i = 0; i < classifierTypeName.length
				&& !classifierTypeName[i].equals(rb.getText()); ++i) {
		}
		if (i == classifierTypeName.length - 1) {
			symbolSelected.classifierType = -1;
			symbolSelected.name = "dot";
		} else {
			symbolSelected.classifierType = i;
			classify(symbolSelected, i);
		}
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
	}

	public void classify(final Symbol s, final int type) {
		if (downloadModelThread != null) {
			return;
		}
		SparseVector v = null;
		if (s.isEmpty()) {
			s.name = "empty_symbol";
			s.classifierType = -1;
			return;
		}
		if (s.classifierType < 0) {
			return;
		}
		if (s.getWidth() <= 4.0 && s.getHeight() <= 4.0) {
			s.name = "dot";
		} else if (supportArrayListjRadioButtonMenuItem17.isSelected()) {
			try {
				if (modelname.equals("formula_")) {
					v = s.getAsSparseVectorSingle(np);
				} else if (modelname.equals("global_")) {
					v = s.globalFeaturesToSparseVector();
				} else if (modelname.equals("string_")) {
					v = SparseVector.contructFrom(s.getSparseVectorStringCode(
							8, 0.0, 32));
				}
				if (maxNumStrokes[type] >= s.size()) {
					s.name = svmModel[type][s.size() - 1].classify(v);
					s.classifierType = type;
				} else {
					s.name = svmModel[type][maxNumStrokes[s.classifierType] - 1]
							.classify(v);
					s.classifierType = type;
				}
			} catch (NullPointerException npe) {
			}
		} else if (nearestneighborsjRadioButtonMenuItem18.isSelected()) {
			s.name = tan.classify(s, 5);
		}
		if (s.getWidth() <= 16.0 && s.getHeight() <= 16.0
				&& !s.name.equals("dot") && s.name.equals("\\end")) {
			s.name = "comma";
		}
	}

	public void classify(final Symbol s) {
		if (downloadModelThread != null) {
			return;
		}
		SparseVector v = null;
		if (s.isEmpty()) {
			s.name = "empty_symbol";
			s.classifierType = -1;
			return;
		}
		if (usethislabeljCheckBoxMenuItem.isSelected()) {
			s.name = labelJTextField.getText();
		}
		if (s.classifierType >= -1) {
			return;
		}
		if (s.classifierType < -1) {
			s.classifierType = classifierType;
		}
		if (s.getWidth() <= 4.0 && s.getHeight() <= 4.0) {
			s.name = "dot";
		} else if (supportArrayListjRadioButtonMenuItem17.isSelected()) {
			try {
				if (modelname.equals("formula_")) {
					v = s.getAsSparseVectorSingle(np);
				} else if (modelname.equals("global_")) {
					v = s.globalFeaturesToSparseVector();
				} else if (modelname.equals("string_")) {
					v = SparseVector.contructFrom(s.getSparseVectorStringCode(
							8, 0.0, 32));
				}
				if (maxNumStrokes[s.classifierType] >= s.size()) {
					s.name = svmModel[s.classifierType][s.size() - 1]
							.classify(v);
				} else {
					s.name = svmModel[s.classifierType][maxNumStrokes[s.classifierType] - 1]
							.classify(v);
				}
			} catch (NullPointerException npe) {
			}
		} else if (nearestneighborsjRadioButtonMenuItem18.isSelected()) {
			s.name = tan.classify(s, 5);
		}
		if (s.getWidth() <= 16.0 && s.getHeight() <= 16.0
				&& !s.name.equals("dot") && s.name.equals("\\end")) {
			s.name = "comma";
		}
	}

	void closejMenuItem_actionPerformed(final ActionEvent e) {
	}

	void clusterpointsjMenuItem_actionPerformed(final ActionEvent e) {
		Symbol s = null;
		int c = 0;
		for (int i = 0; i < symbol.size(); ++i) {
			s = symbol.get(i);
			c = s.classifierType;
			s = new Symbol(s.clusterPoints(pointsEquidistantSamplingProcessing));
			classify(s, c);
			symbol.set(i, s);
		}
		isChanged = true;
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
	}

	void construcformulajButton_actionPerformed(final ActionEvent e) {
		if (symbol.isEmpty()) {
			return;
		}
		final SymbolList sl = new SymbolList();
		for (int i = 0; i < symbol.size(); ++i) {
			final Symbol s = symbol.get(i);
			sl.add(new SymbolNode((int) s.getMinX(), (int) s.getMinY(), (int) s
					.getMaxX(), (int) s.getMaxY(), s.name));
		}
		sl.sort();
		final BaselineStructureTree bst = new BaselineStructureTree(sl);
		bst.buildTree();
		latexExp = bst.interpretLaTeX();
		messagesjTextArea.append(latexExp + "\n\n");
		expressionjTextField.setText(latexExp);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
		texSelected = true;
		if (graphicoutputjCheckBoxMenuItem.getState()) {
			new ConvertToLaTeXThread().start();
		}
	}

	public void constructBackgroundImages() {
		final MediaTracker tracker = new MediaTracker(this);
		System.out.println(System.getProperty("os.name"));
		try {
			final BufferedReader filein = new BufferedReader(new FileReader(
					path + "data/background.txt"));
			System.out.println(path + "data/background.txt");
			StringTokenizer st = new StringTokenizer(filein.readLine(), " ");
			ngroups = Integer.parseInt(st.nextToken());
			backgroundImage = new Image[ngroups];
			for (int g = 0; g < ngroups; ++g) {
				st = new StringTokenizer(filein.readLine(), " ");
				final int nlines = Integer.parseInt(st.nextToken());
				final int ncolumns = Integer.parseInt(st.nextToken());
				final String filename = st.nextToken();
				if (!filename.equals("nofile")) {
					tracker.addImage(
							backgroundImage[g] = Toolkit.getDefaultToolkit()
									.getImage(path + "data/" + filename), 0);
					try {
						tracker.waitForAll();
					} catch (InterruptedException ie) {
					}
				} else {
					backgroundImage[g] = createImage(drawJPanel.getWidth(),
							drawJPanel.getHeight());
					final Graphics2D gr = (Graphics2D) backgroundImage[g]
							.getGraphics();
					final int w = drawJPanel.getWidth() / ncolumns;
					final int h = drawJPanel.getHeight() / nlines;
					gr.setColor(Color.white);
					gr.fillRect(0, 0, backgroundImage[g].getWidth(this),
							backgroundImage[g].getHeight(this));
					for (int l = 0; l < nlines; ++l) {
						st = new StringTokenizer(filein.readLine(), " ");
						final int ntokens = st.countTokens();
						int hm = Integer.MIN_VALUE;
						for (int t = 0; t < ntokens; ++t) {
							final String symbol = st.nextToken();
							final Image img = latex2Image(symbol);
							System.out.print(symbol + " ");
							hm = Math.max(hm, img.getHeight(this));
							gr.drawImage(img,
									t * w + w / 2 - img.getWidth(this) / 2,
									l * h + 7 * h / 8 - img.getHeight(this),
									this);
						}
						gr.setColor(Color.gray);
						System.out.println();
						gr.drawLine(0, l * h + 7 * h / 8 + 3,
								drawJPanel.getWidth(), l * h + 7 * h / 8 + 3);
						gr.drawLine(0, l * h + 7 * h / 8 - hm - 3,
								drawJPanel.getWidth(), l * h + 7 * h / 8 - hm
										- 3);
					}
				}
			}
			filein.close();
		} catch (Exception fnfe) {
			fnfe.printStackTrace();
			return;
		}
		System.out.println("index=" + index + " ngroups=" + ngroups);
	}

	void deactivateButtons(final boolean b) {
		ToTeXJButton.setEnabled(b);
		ToMathematicaJButton.setEnabled(b);
		Plot2DJButton.setEnabled(b);
		Plot3DJButton.setEnabled(b);
	}

	void dehookjMenuItem_actionPerformed(final ActionEvent e) {
		Symbol s = null;
		int c = 0;
		for (int i = 0; i < symbol.size(); ++i) {
			s = symbol.get(i);
			c = s.classifierType;
			s = new Symbol(s.dehook());
			classify(s, c);
			symbol.set(i, s);
		}
		isChanged = true;
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
	}

	void deleteOnExit(final String filename) {
		new File(filename + ".math").deleteOnExit();
		new File(filename + ".tex").deleteOnExit();
		new File(filename + ".aux").deleteOnExit();
		new File(filename + ".log").deleteOnExit();
		new File(filename + ".dvi").deleteOnExit();
		new File(filename + ".ps").deleteOnExit();
		new File(filename + ".eps").deleteOnExit();
		new File(filename + ".png").deleteOnExit();
	}

	public void deleteStrokes() {
		final boolean[][] indexes = selectedIndexes();
		for (int i = 0; i < indexes.length; ++i) {
			final Symbol s = symbol.get(i);
			for (int j = indexes[i].length - 1; j > -1; --j) {
				if (indexes[i][j]) {
					s.remove(j);
				}
			}
		}
		purgeSymbol();
	}

	void deletealljButton_actionPerformed(final ActionEvent e) {
		int n = 0;
		final Object[] options = { "Yes", "No" };
		n = JOptionPane.showOptionDialog(this,
				"Do you want to remove ALL the strokes?", "Warning", 1, 2,
				null, options, options[1]);
		if (n == 0) {
			symbol.clear();
			drawJPanel
					.setStrokeMemory(symbol, backgroundImage[index % ngroups]);
			isChanged = true;
		}
	}

	void deletegroupjButton_actionPerformed(final ActionEvent e) {
		if (index > -1) {
			final Object[] options = { "Yes", "No" };
			final int n = JOptionPane.showOptionDialog(this,
					"Do you want to remove this group?", "Question", 1, 2,
					null, options, options[1]);
			if (n == 0) {
				newGenerated = false;
				drawJPanel.erase();
				symbolData.remove(index);
				symboljComboBox.removeItemAt(index);
				actualizeSymboljComboBox(false);
				if (symbolData.size() > 0) {
					symbol = symbolData.get(index);
					drawJPanel.setStrokeMemory(symbol, backgroundImage[index
							% ngroups]);
				}
				symboljComboBox.setSelectedIndex(index);
				isChanged = true;
			}
		}
	}

	void deletejToggleButton_actionPerformed(final ActionEvent e) {
		final JToggleButton button = (JToggleButton) e.getSource();
		if (button.isSelected()) {
			drawJPanel.setEditColor(Color.red);
			drawJPanel.setEditMode(true);
		} else {
			drawJPanel.setEditMode(false);
		}
	}

	void deletelastjButton_actionPerformed(final ActionEvent e) {
		if (!symbol.isEmpty()) {
			final Symbol sym = symbol.get(symbol.size() - 1);
			if (!sym.isEmpty()) {
				sym.remove(sym.size() - 1);
				isChanged = true;
			}
			if (sym.isEmpty()) {
				symbol.remove(symbol.size() - 1);
			} else {
				classify(sym, sym.classifierType);
			}
			drawJPanel
					.setStrokeMemory(symbol, backgroundImage[index % ngroups]);
		}
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
	}

	void directiondominancemstusedominanceattractorsdistancefactorjCheckBoxMenuItem_actionPerformed(
			final ActionEvent e) {
		final boolean state = directionjCheckBoxMenuItem2.getState();
		directionOld = state;
		DStroke.drawDirection = state;
		if (!directionOld) {
			allpropertiesjCheckBoxMenuItem5.setState(false);
		}
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
	}

	void distancefactorjCheckBoxMenuItem_actionPerformed(final ActionEvent e) {
		SymbolEdge.setDistanceFactors(distancefactorjCheckBoxMenuItem
				.getState());
	}

	void dominancehorizontalfactorjCheckBoxMenuItem_actionPerformed(
			final ActionEvent e) {
		SymbolEdge
				.setDominaceHorizontalFactors(dominancehorizontalfactorjCheckBoxMenuItem
						.getState());
	}

	void dominancemstjMenuItem_actionPerformed(final ActionEvent e) {
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
		final SymbolList sl = new SymbolList();
		for (int i = 0; i < symbol.size(); ++i) {
			final Symbol s = symbol.get(i);
			sl.add(new SymbolNode((int) s.getMinX(), (int) s.getMinY(), (int) s
					.getMaxX(), (int) s.getMaxY(), s.name));
		}
		sl.sort();
		final BaselineStructureTree bst = new BaselineStructureTree(sl);
		final SymbolList aux = BaselineStructureTree.checkHorizontalBar(sl);
		sl.clear();
		for (int i = 0; i < aux.size(); ++i) {
			sl.add(new SymbolNode(aux.symbolNodeAt(i)));
		}
		sl.sort();
		final SymbolList hor = bst.horizontal(sl);
		for (int i = 0; i < hor.size(); ++i) {
			final SymbolNode sn = hor.symbolNodeAt(i);
			if (sn.isVariableRange() && i < hor.size() - 1) {
				sn.rightWall = hor.symbolNodeAt(i + 1).minX;
			}
			sn.inMainBaseline = true;
		}
		hor.draw(drawJPanel.getGraphics2D(), Color.red, "");
		final SymbolList tree = MSTPrim.construct(sl, hor);
		tree.drawDad(drawJPanel.getGraphics2D());
	}

	void dominancemstusedominanceattractorsdistancefactorjCheckBoxMenuItem_actionPerformed(
			final ActionEvent e) {
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
		final SymbolList sl = new SymbolList();
		for (int i = 0; i < symbol.size(); ++i) {
			final Symbol s = symbol.get(i);
			sl.add(new SymbolNode((int) s.getMinX(), (int) s.getMinY(), (int) s
					.getMaxX(), (int) s.getMaxY(), s.name));
		}
		sl.sort();
		final BaselineStructureTree bst = new BaselineStructureTree(sl);
		final SymbolList hor = bst.horizontal(sl);
		hor.setWalls();
		hor.draw(drawJPanel.getGraphics2D(), Color.red, "");
		// final SymbolList tree =
		MSTPrim.construct(sl, hor);
	}

	void doublesidedjCheckBoxMenuItem_actionPerformed(final ActionEvent e) {
		MSTPrim.checkHorizontalBar = doublesidedjCheckBoxMenuItem.getState();
	}

	void drawJPanel_keyPressed(final KeyEvent e) {
		try {
			classifierType = Integer.parseInt("" + e.getKeyChar());
			if (classifierType > 3 || classifierType < 0) {
				classifierType = 0;
			}
		} catch (NumberFormatException ex) {
			classifierType = 0;
		}
	}

	void drawJPanel_keyReleased(final KeyEvent e) {
		classifierType = 0;
	}

	void drawJPanel_mouseClicked(final MouseEvent e) {
		drawJPanel.requestFocus();
	}

	void drawJPanel_mouseDragged(final MouseEvent e) {
	}

	void drawJPanel_mouseEntered(final MouseEvent e) {
		drawJPanel.requestFocus();
	}

	void drawJPanel_mouseReleased(final MouseEvent e) {
		if ((e.getModifiers() & 0x4) == 0x4) {
			showPopup(e);
			return;
		}
		if (symboljPopupMenu.isVisible() || groupjPopupMenu.isVisible()) {
			return;
		}
		if ((e.getModifiers() & 0x8) == 0x8) {
			return;
		}
		if (drawJPanel.isDrawing()) {
			try {
				final Symbol s = new Symbol();
				s.add(drawJPanel.getInputStroke());
				Symbol.normalizeDirection = false;
				classify(s);
				Symbol.normalizeDirection = true;
				System.out.println(s.name);
				if (commandinterpreterjCheckBoxMenuItem.isSelected()
						&& s.name.equals("\\DELETE")) {
					drawJPanel.selectSymbolIndex();
					if (drawJPanel.isSymbolSelected()) {
						final Edit edit = new CutSymbolEdit(this, index);
						edit.execute();
						undoSupport_.postEdit(edit);
					}
					drawJPanel.setSymbolSelectedIndexes(null, false);
					drawJPanel
							.drawStrokeMemory(backgroundImage[index % ngroups]);
				} else if (commandinterpreterjCheckBoxMenuItem.isSelected()
						&& s.name.equals("\\UNDO")) {
					if (undoManager_.canUndo()) {
						undoManager_.undo();
						refreshUndoRedo();
						isChanged = true;
					}
					drawJPanel
							.drawStrokeMemory(backgroundImage[index % ngroups]);
				} else if (commandinterpreterjCheckBoxMenuItem.isSelected()
						&& s.name.equals("\\REDO")) {
					if (undoManager_.canRedo()) {
						undoManager_.redo();
						refreshUndoRedo();
						isChanged = true;
					}
					drawJPanel
							.drawStrokeMemory(backgroundImage[index % ngroups]);
				} else if (commandinterpreterjCheckBoxMenuItem.isSelected()
						&& s.name.equals("\\SELECT")) {
					drawJPanel.selectSymbolIndex();
					drawJPanel
							.drawStrokeMemory(backgroundImage[index % ngroups]);
					if (drawJPanel.isSymbolSelected()) {
						// final boolean[] indexes =
						drawJPanel.getSymbolSelectedIndexes();
						SelectJToggleButton.setSelected(true);
						drawJPanel.setSymbolSelecting();
						drawJPanel.drawStrokeMemorySelectedSymbols();
						drawJPanel.repaint();
					}
				} else if (commandinterpreterjCheckBoxMenuItem.isSelected()
						&& s.name.equals("\\end")) {
					verifyCommand(s);
					drawJPanel
							.drawStrokeMemory(backgroundImage[index % ngroups]);
				} else {
					final UndoableEdit edit2 = new AddEdit(this, index);
					addToStrokeMemory(s.name.equals("dot")
							|| s.name.equals("comma"));
					undoSupport_.postEdit(edit2);
					drawJPanel
							.drawStrokeMemory(backgroundImage[index % ngroups]);
				}
				drawJPanel.repaint();
				isChanged = true;
			} catch (NullPointerException npe) {
				System.err.println("UPS!");
			}
		} else if (drawJPanel.isMoving()
				|| (drawJPanel.isSelecting() && drawJPanel
						.isUsingOpenedHandCursor())) {
			if (drawJPanel.getDeltaX() != 0.0 || drawJPanel.getDeltaY() != 0.0) {
				if (drawJPanel.isSymbolSelected()) {
					final UndoableEdit edit3 = new MoveSymbolEdit(this, index);
					undoSupport_.postEdit(edit3);
					isChanged = true;
				} else if (drawJPanel.isStrokeSelected()) {
					final UndoableEdit edit3 = new MoveStrokeEdit(this, index);
					undoSupport_.postEdit(edit3);
					isChanged = true;
				}
			}
			drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
			drawJPanel.drawStrokeMemorySelectedStrokes();
			drawJPanel.drawStrokeMemorySelectedSymbols();
			drawJPanel.repaint();
		}
		CopyJButton.setEnabled(drawJPanel.isSomethingSelected());
		CopyJMenuItem.setEnabled(drawJPanel.isSomethingSelected());
		CutJButton.setEnabled(drawJPanel.isSomethingSelected());
		CutJMenuItem.setEnabled(drawJPanel.isSomethingSelected());
	}

	public void drawRows(final SymbolList sl, final double factor) {
		final int min = sl.getMinY();
		final int[] column = new int[sl.getMaxY() - min + 1];
		for (int i = 0; i < sl.size(); ++i) {
			final SymbolNode sn = sl.symbolNodeAt(i);
			for (int j = sn.minY; j <= sn.maxY; ++j) {
				column[j - min] = 1;
			}
		}
		final ArrayList<Point> interval = new ArrayList<Point>();
		int j = -1;
		for (int i = 1; i < column.length; ++i) {
			if (column[i] - column[i - 1] < 0) {
				interval.add(new Point(i, -1));
				++j;
			} else if (column[i] - column[i - 1] > 0) {
				interval.get(j).y = i;
			}
		}
		if (interval.isEmpty()) {
			return;
		}
		double space = 0.0;
		for (int i = 0; i < interval.size(); ++i) {
			final Point p = interval.get(i);
			space += p.y - p.y;
		}
		space /= interval.size();
		final ArrayList<Point> newInterval = new ArrayList<Point>();
		space *= factor;
		for (int i = 0; i < interval.size(); ++i) {
			final Point p = interval.get(i);
			if (p.y - p.y > space) {
				newInterval.add(new Point(0, (p.x + p.y) / 2));
			}
		}
		drawJPanel.getGraphics2D().setColor(new Color(255, 0, 0));
		for (int i = 0; i < newInterval.size(); ++i) {
			final Point p = newInterval.get(i);
			drawJPanel.getGraphics2D().drawLine(sl.getMinX(), p.y,
					sl.getMaxX(), p.y);
		}
	}

	public void drawRows(final double factor) {
		final SymbolList sl = new SymbolList();
		for (int i = 0; i < symbol.size(); ++i) {
			final Symbol s = symbol.get(i);
			sl.add(new SymbolNode((int) s.getMinX(), (int) s.getMinY(), (int) s
					.getMaxX(), (int) s.getMaxY(), s.name));
		}
		final int min = sl.getMinY();
		final int[] column = new int[sl.getMaxY() - sl.getMinY() + 1];
		for (int i = 0; i < sl.size(); ++i) {
			final SymbolNode sn = sl.symbolNodeAt(i);
			for (int j = sn.minY; j <= sn.maxY; ++j) {
				column[j - min] = 1;
			}
		}
		final ArrayList<Point> interval = new ArrayList<Point>();
		int j = -1;
		for (int i = 1; i < column.length; ++i) {
			if (column[i] - column[i - 1] < 0) {
				interval.add(new Point(i, -1));
				++j;
			} else if (column[i] - column[i - 1] > 0) {
				final Point p = interval.get(j);
				p.y = i;
				interval.set(j, p);
			}
		}
		if (interval.isEmpty()) {
			return;
		}
		double space = 0.0;
		for (int i = 0; i < interval.size(); ++i) {
			final Point p = interval.get(i);
			space += p.y - p.x;
		}
		space /= interval.size();
		final ArrayList<Point> newInterval = new ArrayList<Point>();
		space *= factor;
		for (int i = 0; i < interval.size(); ++i) {
			final Point p = interval.get(i);
			if (p.y - p.x > space) {
				newInterval.add(new Point(0, (p.x + p.y) / 2));
			}
		}
		drawJPanel.getGraphics2D().setColor(new Color(0, 0, 255));
		for (int i = 0; i < newInterval.size(); ++i) {
			final Point p = newInterval.get(i);
			drawJPanel.getGraphics2D().drawLine(sl.getMinX(), min + p.y,
					sl.getMaxX(), min + p.y);
		}
	}

	public void drawSpatialRelation() {
	}

	void drawjToggleButton_actionPerformed(final ActionEvent e) {
		final JToggleButton button = (JToggleButton) e.getSource();
		if (button.isSelected()) {
			drawJPanel.setEditMode(false);
		}
	}

	void equidistantjMenuItem_actionPerformed(final ActionEvent e) {
		Symbol s = null;
		int c = 0;
		for (int i = 0; i < symbol.size(); ++i) {
			s = symbol.get(i);
			c = s.classifierType;
			s = new Symbol(
					s.equidistantLength(pointsEquidistantSamplingProcessing));
			classify(s, c);
			symbol.set(i, s);
		}
		isChanged = true;
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
	}

	void evaluatejMenuItem_actionPerformed(final ActionEvent e) {
		calculusExecute(e);
	}

	void examplejScrollPane_componentResized(final ComponentEvent e) {
		actualizeExample();
	}

	void exitjMenuItem_actionPerformed(final ActionEvent e) {
		int val = 0;
		if (url != null) {
			return;
		}
		if (isChanged) {
			final Object[] options = { "Save", "Exit", "Cancel" };
			val = this
					.showWindowYesNoCancel(
							"The file was modified. Do you want to save it before leave the program?",
							"Question", options);
			if (val == 0) {
				saveasjMenuItem_actionPerformed(e);
				if (!isChanged) {
					setVisible(false);
					dispose();
					removeTmpFiles();
					System.exit(0);
				}
			} else {
				if (val != 1) {
					return;
				}
				setVisible(false);
				dispose();
				removeTmpFiles();
				System.exit(0);
			}
		} else {
			final Object[] options = { "Exit", "Cancel" };
			val = showWindowYesNo("Do you wanto to leave the application?",
					"Question", options);
			if (val == 0) {
				setVisible(false);
				if (url == null) {
					dispose();
					removeTmpFiles();
					System.exit(0);
				}
			}
		}
	}

	void filteringjMenuItem_actionPerformed(final ActionEvent e) {
		for (int i = 0; i < symbol.size(); ++i) {
			symbol.get(i).filter();
		}
		isChanged = true;
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
	}

	void forwardjButton_actionPerformed(final ActionEvent e) {
		if (index < symbolData.size() - 1) {
			drawJPanel.setStrokeSelectedIndexes(null, false);
			drawJPanel.setSymbolSelectedIndexes(null, false);
			++index;
			symbol = symbolData.get(index);
			drawJPanel
					.setStrokeMemory(symbol, backgroundImage[index % ngroups]);
			symboljComboBox.setSelectedIndex(index);
		}
	}

	public static HcrData getHcrDataFrame(final URL url) throws Exception {
		final HcrData hcrData = new HcrData();
		hcrData.url = url;
		if (url != null) {
			hcrData.filejMenu.setEnabled(false);
		}
		hcrData.readClassificationModel();
		hcrData.setTitle("JMathNotes");
		hcrData.pack();
		hcrData.setVisible(true);
		hcrData.drawJPanel.initializeGraphics();
		hcrData.drawJPanel.setDrawRadius(3.0f);
		hcrData.drawJPanel.setDrawable(true);
		hcrData.drawJPanel.setAntialias(false);
		hcrData.drawJPanel.setDrawColor(Color.black);
		hcrData.drawJPanel.setBackground(Color.white);
		hcrData.drawJPanel.erase();
		hcrData.exampleJPanel.initializeGraphics();
		hcrData.exampleJPanel.setDrawRadius(3.0f);
		hcrData.exampleJPanel.setBackground(Color.white);
		hcrData.exampleJPanel.setDrawColor(Color.black);
		hcrData.exampleJPanel.setDrawable(true);
		hcrData.exampleJPanel.erase();
		return hcrData;
	}

	void graphicsjButton_actionPerformed(final ActionEvent e) {
		if (symbol.isEmpty()) {
			return;
		}
		final SymbolList sl = new SymbolList();
		for (int i = 0; i < symbol.size(); ++i) {
			final Symbol s = symbol.get(i);
			sl.add(new SymbolNode((int) s.getMinX(), (int) s.getMinY(), (int) s
					.getMaxX(), (int) s.getMaxY(), s.name));
		}
		sl.sort();
		final BaselineStructureTree bst = new BaselineStructureTree(sl);
		bst.buildTree();
		plotExp = "\\!\\(" + bst.interpretMathematica() + "\\)";
		messagesjTextArea.append("Plot: " + plotExp + "\n");
		expressionjTextField.setText(plotExp);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
		plotSelected = true;
		if (graphicoutputjCheckBoxMenuItem.getState()) {
			new Plot2DThread().start();
		}
	}

	void greekjRadioButtonMenuItem1_actionPerformed(final ActionEvent e) {
		classifierType = 3;
	}

	public void groupUngroupStrokes() {
		final boolean[][] indexes = selectedIndexes();
		final Symbol s = new Symbol();
		int firstIndex = Integer.MAX_VALUE;
		final int[] numSelected = new int[indexes.length];
		for (int i = 0; i < indexes.length; ++i) {
			numSelected[i] = 0;
			final Symbol saux = symbol.get(i);
			for (int j = indexes[i].length - 1; j > -1; --j) {
				if (indexes[i][j]) {
					s.add(new DStroke(saux.strokeAt(j)));
					firstIndex = Math.min(firstIndex, i);
					saux.remove(j);
					final int[] array = numSelected;
					final int n = i;
					++array[n];
				}
			}
		}
		int oneSelected = 0;
		for (int k = 0; k < numSelected.length; ++k) {
			oneSelected += ((numSelected[k] > 0) ? 1 : 0);
		}
		if (!s.isEmpty() && oneSelected == 1
				&& numSelected[firstIndex] == indexes[firstIndex].length) {
			for (int l = 0; l < indexes[firstIndex].length; ++l) {
				final Symbol sym = new Symbol();
				sym.add(s.strokeAt(l));
				symbol.add(firstIndex + l, sym);
			}
		} else if (!s.isEmpty()) {
			symbol.add(firstIndex, s);
		}
		purgeSymbol();
	}

	void groupjToggleButton_actionPerformed(final ActionEvent e) {
		final JToggleButton button = (JToggleButton) e.getSource();
		if (button.isSelected()) {
			drawJPanel.setEditColor(new Color(220, 220, 80));
			drawJPanel.setEditMode(true);
		} else {
			drawJPanel.setEditMode(false);
		}
	}

	void highcurvaturejCheckBoxMenuItem_actionPerformed(final ActionEvent e) {
		final boolean state = highcurvaturejCheckBoxMenuItem.getState();
		highOld = state;
		DStroke.drawCurvaturePoints = state;
		if (!highOld) {
			allpropertiesjCheckBoxMenuItem5.setState(false);
		}
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
	}

	public void horizontalSymbolNode(final SymbolList sl) {
		if (sl.size() == 1) {
			sl.symbolNodeAt(0).drawBoundingBox(drawJPanel.getGraphics2D(),
					Color.blue);
			return;
		}
		final SymbolList remaining = new SymbolList();
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
		// final SymbolDrawJPanel drawJPanel = drawJPanel;
		DrawJPanel.delay(0.45f);
		horizontalSymbolNode(remaining);
	}

	void horizontalhistogramjMenuItem_actionPerformed(final ActionEvent e) {
	}

	void indexminimumspanningtreejCheckBoxMenuItem3_actionPerformed(
			final ActionEvent e) {
		final boolean state = indexjCheckBoxMenuItem3.getState();
		indexOld = state;
		Symbol.drawIndex = state;
		if (!indexOld) {
			allpropertiesjCheckBoxMenuItem5.setState(false);
		}
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
	}

	void initializePanels() {
		setTitle("JMathNotes");
		pack();
		setVisible(true);
		drawJPanel.initializeGraphics();
		drawJPanel.setDrawRadius(3.0f);
		drawJPanel.setDrawable(true);
		drawJPanel.setAntialias(true);
		drawJPanel.setDrawColor(Color.black);
		drawJPanel.setBackground(Color.white);
		drawJPanel.setDrawing();
		drawJPanel.erase();
		exampleJPanel.initializeGraphics();
		exampleJPanel.setDrawRadius(3.0f);
		exampleJPanel.setBackground(Color.white);
		exampleJPanel.setDrawColor(Color.black);
		exampleJPanel.setDrawable(false);
		exampleJPanel.setBordered(false);
		exampleJPanel.erase();
		newGenerated = true;
		symboljComboBox.addItem(new StringBuffer("Page " + symbolData.size()
				+ " of " + symbolData.size()));
		index = symbolData.size();
		symbol = new ArrayList<Symbol>();
		symbolData.add(symbol);
		drawJPanel.setStrokeMemory(symbol);
		symboljComboBox.setSelectedIndex(index);
		newGenerated = false;
	}

	void jSlider1_caretPositionChanged(final InputMethodEvent e) {
		System.out.println(e.toString());
	}

	@SuppressWarnings("unused")
	private void jbInit() throws Exception {
		final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		drawJPanel = new SymbolDrawJPanel((int) dimension.getWidth(),
				(int) dimension.getHeight(), true);
		exampleJPanel = new SymbolDrawJPanel(
				(int) (0.8 * dimension.getWidth()), outputHeight);
		TinyBasicjButton.setToolTipText("Tiny Basic");
		TinyBasicjButton.setIcon(BImageIcon);
		TinyBasicjButton.setMargin(new Insets(2, 2, 2, 2));
		TinyBasicjButton.setText("");
		TinyBasicjButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				TinyBasicjButton_actionPerformed(e);
			}
		});
		dehookjMenuItem.setText("Dehook");
		dehookjMenuItem.setAccelerator(KeyStroke.getKeyStroke(72, 8, false));
		dehookjMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				dehookjMenuItem_actionPerformed(e);
			}
		});
		clusterpointsjMenuItem.setText("Cluster Points");
		clusterpointsjMenuItem.setAccelerator(KeyStroke.getKeyStroke(67, 8,
				false));
		clusterpointsjMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				clusterpointsjMenuItem_actionPerformed(e);
			}
		});
		PlotParam2DjButton.setEnabled(true);
		PlotParam2DjButton.setFocusPainted(true);
		parametric2djMenuItem.setEnabled(true);
		parametric2djMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				parametric2djMenuItem_actionPerformed(e);
			}
		});
		parametric3djMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				parametric3djMenuItem_actionPerformed(e);
			}
		});
		language.add(tinybasicjRadioButtonMenuItem);
		language.add(languagelatexjRadioButtonMenuItem);
		final ButtonGroup group = new ButtonGroup();
		final ButtonGroup groupView = new ButtonGroup();
		titledBorder4 = new TitledBorder("");
		titledBorder5 = new TitledBorder("");
		border2 = BorderFactory.createBevelBorder(0, Color.white, Color.white,
				new Color(99, 99, 99), new Color(142, 142, 142));
		border3 = BorderFactory.createLineBorder(Color.black, 1);
		asstrokejRadioButtonMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				HcrData.this.asstrokejRadioButtonMenuItem_actionPerformed(e);
			}
		});
		aspolygonaljRadioButtonMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				HcrData.this.aspolygonaljRadioButtonMenuItem_actionPerformed(e);
			}
		});
		antialiasjCheckBoxMenuItem.setSelected(true);
		antialiasjCheckBoxMenuItem.setText("Antialias");
		antialiasjCheckBoxMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				antialiasjCheckBoxMenuItem_actionPerformed(e);
			}
		});
		tangenttransformationjMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				HcrData.this.tangenttransformationjMenuItem_actionPerformed(e);
			}
		});
		pointsjCheckBoxMenuItem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				HcrData.this
						.pointsgraphicoutputjCheckBoxMenuItem_actionPerformed(e);
			}
		});
		directionjCheckBoxMenuItem2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				HcrData.this
						.directiondominancemstusedominanceattractorsdistancefactorjCheckBoxMenuItem_actionPerformed(e);
			}
		});
		indexjCheckBoxMenuItem3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				HcrData.this
						.indexminimumspanningtreejCheckBoxMenuItem3_actionPerformed(e);
			}
		});
		boundingboxjCheckBoxMenuItem4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				HcrData.this.boundingboxjCheckBoxMenuItem4_actionPerformed(e);
			}
		});
		numberofpointsjCheckBoxMenuItem7
				.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(final ActionEvent e) {
						HcrData.this
								.numberofpointsjCheckBoxMenuItem7_actionPerformed(e);
					}
				});
		labeljCheckBoxMenuItem6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				labeljCheckBoxMenuItem6_actionPerformed(e);
			}
		});
		allpropertiesjCheckBoxMenuItem5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				HcrData.this.allpropertiesjCheckBoxMenuItem5_actionPerformed(e);
			}
		});
		aspolygonaljRadioButtonMenuItem.setSelected(true);
		boundingboxjCheckBoxMenuItem4.setSelected(true);
		labeljCheckBoxMenuItem6.setSelected(true);
		HelpMenu.setText("Help");
		aboutjMenuItem.setText("About...");
		aboutjMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				aboutjMenuItem_actionPerformed(e);
			}
		});
		changelabeljMenuItem.setText("Change Label...");
		labeljMenuItem.setText("Label: ");
		filteringjMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				filteringjMenuItem_actionPerformed(e);
			}
		});
		smoothingjMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				smoothingjMenuItem_actionPerformed(e);
			}
		});
		equidistantjMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				equidistantjMenuItem_actionPerformed(e);
			}
		});
		normalizejMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				normalizejMenuItem_actionPerformed(e);
			}
		});
		orderjMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				orderjMenuItem_actionPerformed(e);
			}
		});
		poligonaljMenuItem.setText("Polygonal Aproximation");
		poligonaljMenuItem.setAccelerator(KeyStroke.getKeyStroke(80, 8, false));
		poligonaljMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				polygonaljMenuItem_actionPerformed(e);
			}
		});
		gropupingjMenu.setEnabled(false);
		jMenuItem2.setText("Label");
		jMenuItem3.setText("Change Label...");
		processingparametersjMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				HcrData.this.processingparametersjMenuItem_actionPerformed(e);
			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent e) {
				this_windowClosing(e);
			}
		});
		UndojMenuItem.setEnabled(false);
		parametersviewUndoJMenuItem.setEnabled(false);
		symboljComboBox.setMaximumSize(new Dimension(125, 26));
		symboljComboBox.setMinimumSize(new Dimension(122, 26));
		symboljComboBox.setPreferredSize(new Dimension(122, 26));
		symboljComboBox.setToolTipText("Select Page");
		symboljComboBox.setEditable(true);
		symboljComboBox.setMaximumRowCount(15);
		symboljComboBox.setPopupVisible(false);
		symboljComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				symboljComboBox_actionPerformed(e);
			}
		});
		symboljComboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(final ItemEvent e) {
				symboljComboBox_itemStateChanged(e);
			}
		});
		openjMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				openjMenuItem_actionPerformed(e);
			}
		});
		saveasjMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				saveasjMenuItem_actionPerformed(e);
			}
		});
		savejMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				savejMenuItem_actionPerformed(e);
			}
		});
		jMenu1.setEnabled(false);
		jMenu1.setText("Window");
		jRadioButtonMenuItem2.setEnabled(false);
		jRadioButtonMenuItem2.setSelected(true);
		closejMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				closejMenuItem_actionPerformed(e);
			}
		});
		closejMenuItem.setEnabled(false);
		closejMenuItem.setIcon(NullImageIcon16);
		graphicoutputjCheckBoxMenuItem.setSelected(true);
		graphicoutputjCheckBoxMenuItem.setText("Graphic Output");
		previousjMenuItem.setIcon(PreviousPageImageIcon16);
		previousjMenuItem.setText("Previous Page");
		previousjMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				previousjMenuItem_actionPerformed(e);
			}
		});
		nextjMenuItem.setIcon(NextPageImageIcon16);
		nextjMenuItem.setText("Next Page");
		nextjMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				nextjMenuItem_actionPerformed(e);
			}
		});
		newGroupjMenuItem.setIcon(NewDrawImageIcon16);
		newGroupjMenuItem.setText("New Page");
		newGroupjMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				newGroupjMenuItem_actionPerformed(e);
			}
		});
		texjMenuItem.setIcon(ToTeXImageIcon16);
		texjMenuItem.setText("Create TeX Expression");
		texjMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				texjMenuItem_actionPerformed(e);
			}
		});
		evaluatejMenuItem.setIcon(CalculusImageIcon16);
		evaluatejMenuItem.setText("Evaluate Expresion");
		evaluatejMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				evaluatejMenuItem_actionPerformed(e);
			}
		});
		showjMenuItem.setIcon(Plot2DImageIcon16);
		showjMenuItem.setText("Plot 2D");
		showjMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				showjMenuItem_actionPerformed(e);
			}
		});
		removejMenuItem.setIcon(DeleteImageIcon16);
		removejMenuItem.setText("Delete Page");
		removejMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				removejMenuItem_actionPerformed(e);
			}
		});
		defaultclassifierjMenu2.setText("Default Classifier");
		basicjRadioButtonMenuItem.setText("Basic Symbol");
		basicjRadioButtonMenuItem.setSelected(true);
		basicjRadioButtonMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				basicjRadioButtonMenuItem_actionPerformed(e);
			}
		});
		smalljRadioButtonMenuItem.setText("Small Letter");
		smalljRadioButtonMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				smalljRadioButtonMenuItem_actionPerformed(e);
			}
		});
		capitaljRadioButtonMenuItem.setText("Capital Letter");
		capitaljRadioButtonMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				HcrData.this.capitaljRadioButtonMenuItem_actionPerformed(e);
			}
		});
		greekjRadioButtonMenuItem1.setText("Greek Letter");
		greekjRadioButtonMenuItem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				greekjRadioButtonMenuItem1_actionPerformed(e);
			}
		});
		punctuationjRadioButtonMenuItem.setEnabled(false);
		punctuationjRadioButtonMenuItem.setText("Punctiation Symbol");
		punctuationjRadioButtonMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				HcrData.this.punctuationjRadioButtonMenuItem_actionPerformed(e);
			}
		});
		messagesjTextArea.setEditable(false);
		messagesjTextArea.setColumns(18);
		commandinterpreterjCheckBoxMenuItem.setSelected(true);
		commandinterpreterjCheckBoxMenuItem
				.setText("Activate Gesture Recognition");
		jMenu3.setText("Math Interpreter");
		jRadioButtonMenuItem1.setEnabled(false);
		jRadioButtonMenuItem1.setText("Mathematica");
		jRadioButtonMenuItem1.setSelected(true);
		jRadioButtonMenuItem3.setEnabled(false);
		jRadioButtonMenuItem3.setText("Maple");
		dominancejCheckBoxMenuItem.setText("Dominance");
		jRadioButtonMenuItem4.setEnabled(false);
		jRadioButtonMenuItem4.setText("Maxima");
		readformulajCheckBoxMenuItem.setEnabled(false);
		readformulajCheckBoxMenuItem.setText("Read Formula (Spanish)");
		backgroundCheckBoxMenuItem1.setText("Background Image");
		backgroundImagejCheckBoxMenuItem
				.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(final ActionEvent e) {
						HcrData.this
								.backgroundImagejCheckBoxMenuItem_actionPerformed(e);
					}
				});
		backgroundCheckBoxMenuItem1.setText("Background Image");
		backgroundCheckBoxMenuItem1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				HcrData.this.backgroundCheckBoxMenuItem1_actionPerformed(e);
			}
		});
		dominancemstUndoJMenuItem.setText("Dominance MST");
		dominancemstUndoJMenuItem.setAccelerator(KeyStroke.getKeyStroke(68, 2,
				false));
		dominancemstUndoJMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				dominancemstjMenuItem_actionPerformed(e);
			}
		});
		minimumspanningtreejMenuItem4.setText("Stroke MST");
		minimumspanningtreejMenuItem4.setAccelerator(KeyStroke.getKeyStroke(83,
				10, false));
		minimumspanningtreejMenuItem4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				HcrData.this.minimumspanningtreejMenuItem4_actionPerformed(e);
			}
		});
		spatialrelationjMenuItem.setText("Spatial Relation");
		spatialrelationjMenuItem.setAccelerator(KeyStroke.getKeyStroke(82, 2,
				false));
		spatialrelationjMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				spatialrelationjMenuItem_actionPerformed(e);
			}
		});
		usedominancejCheckBoxMenuItem2.setText("Use Dominance");
		usedominancejCheckBoxMenuItem2.setState(true);
		usedominancejCheckBoxMenuItem2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				HcrData.this
						.usedominanceattractorsdistancefactorjCheckBoxMenuItem_actionPerformed(e);
			}
		});
		attractorsjCheckBoxMenuItem2.setText("Attractors");
		attractorsjCheckBoxMenuItem2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				HcrData.this
						.attractorsdistancefactorjCheckBoxMenuItem_actionPerformed(e);
			}
		});
		distancefactorjCheckBoxMenuItem.setSelected(true);
		distancefactorjCheckBoxMenuItem.setText("Use Distance Factor");
		distancefactorjCheckBoxMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				HcrData.this.distancefactorjCheckBoxMenuItem_actionPerformed(e);
			}
		});
		spatialareasUndoJMenuItem.setText("Draw Spatial Regions");
		spatialareasUndoJMenuItem.setAccelerator(KeyStroke.getKeyStroke(82, 3,
				false));
		spatialareasUndoJMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				spatialareasjMenuItem_actionPerformed(e);
			}
		});
		jMenu2.setText("Symbol Recognizer");
		jMenuItem4.setEnabled(false);
		jMenuItem4.setText("Parameters...");
		supportArrayListjRadioButtonMenuItem17
				.setText("Support ArrayList Machine");
		supportArrayListjRadioButtonMenuItem17.setEnabled(false);
		supportArrayListjRadioButtonMenuItem17.setSelected(true);
		nearestneighborsjRadioButtonMenuItem18.setEnabled(false);
		nearestneighborsjRadioButtonMenuItem18
				.setFont(new Font("Dialog", 0, 11));
		nearestneighborsjRadioButtonMenuItem18.setText("Nearest Neightbors");
		nearestneighborsjRadioButtonMenuItem18
				.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(final ActionEvent e) {
						HcrData.this
								.nearestneighborsjRadioButtonMenuItem18_actionPerformed(e);
					}
				});
		usehorizontalfactorjCheckBoxMenuItem.setText("Use Horizontal Factor");
		usehorizontalfactorjCheckBoxMenuItem
				.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(final ActionEvent e) {
						HcrData.this
								.usehorizontalfactorjCheckBoxMenuItem_actionPerformed(e);
					}
				});
		verticalhistogramjMenuItem.setText("Draw Vertical Histogram");
		verticalhistogramjMenuItem.setAccelerator(KeyStroke.getKeyStroke(86, 3,
				false));
		verticalhistogramjMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				verticalhistogramjMenuItem_actionPerformed(e);
			}
		});
		horizontalhistogramjMenuItem.setText("Draw Horizontal Histogram");
		horizontalhistogramjMenuItem.setAccelerator(KeyStroke.getKeyStroke(72,
				3, false));
		messagesjScrollPane.setHorizontalScrollBarPolicy(32);
		messagesjScrollPane.setVerticalScrollBarPolicy(22);
		messagesjScrollPane.setMinimumSize(new Dimension(350, 0));
		messagesjScrollPane.setPreferredSize(new Dimension(350, 220));
		checkMSTMatrixMemoryjCheckBoxMenuItem.setText("Check MSTMatrixMemory");
		checkMSTMatrixMemoryjCheckBoxMenuItem.setState(true);
		checkMSTMatrixMemoryjCheckBoxMenuItem
				.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(final ActionEvent e) {
						HcrData.this
								.checkMSTMatrixMemoryjCheckBoxMenuItem_actionPerformed(e);
					}
				});
		NewJButton.setEnabled(true);
		NewJButton.setToolTipText("New");
		NewJButton.setFocusPainted(true);
		NewJButton.setIcon(NewImageIcon16);
		NewJButton.setMargin(new Insets(2, 2, 2, 2));
		NewJButton.setText("");
		NewJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				NewJButton_actionPerformed(e);
			}
		});
		OpenJButton.setToolTipText("Open File");
		OpenJButton.setBorderPainted(true);
		OpenJButton.setIcon(OpenImageIcon16);
		OpenJButton.setMargin(new Insets(2, 2, 2, 2));
		OpenJButton.setText("");
		OpenJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				OpenJButton_actionPerformed(e);
			}
		});
		CloseJButton.setEnabled(false);
		CloseJButton.setToolTipText("Close");
		CloseJButton.setBorderPainted(true);
		CloseJButton.setIcon(CloseImageIcon16);
		CloseJButton.setMargin(new Insets(2, 2, 2, 2));
		CloseJButton.setText("");
		SaveJButton.setToolTipText("Save");
		SaveJButton.setBorderPainted(true);
		SaveJButton.setIcon(SaveImageIcon16);
		SaveJButton.setMargin(new Insets(2, 2, 2, 2));
		SaveJButton.setText("");
		SaveJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				SaveJButton_actionPerformed(e);
			}
		});
		UndoJButton.setEnabled(false);
		UndoJButton.setToolTipText("Undo");
		UndoJButton.setBorderPainted(true);
		UndoJButton.setIcon(UndoImageIcon16);
		UndoJButton.setMargin(new Insets(2, 2, 2, 2));
		UndoJButton.setText("");
		UndoJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				UndoJButton_actionPerformed(e);
			}
		});
		RedoJButton.setEnabled(false);
		RedoJButton.setToolTipText("Redo");
		RedoJButton.setBorderPainted(true);
		RedoJButton.setIcon(RedoImageIcon16);
		RedoJButton.setMargin(new Insets(2, 2, 2, 2));
		RedoJButton.setText("");
		RedoJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				RedoJButton_actionPerformed(e);
			}
		});
		CopyJButton.setEnabled(false);
		CopyJButton.setToolTipText("Copy");
		CopyJButton.setBorderPainted(true);
		CopyJButton.setIcon(CopyImageIcon16);
		CopyJButton.setMargin(new Insets(2, 2, 2, 2));
		CopyJButton.setText("");
		CopyJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				CopyJButton_actionPerformed(e);
			}
		});
		PasteJButton.setEnabled(false);
		PasteJButton.setToolTipText("Paste");
		PasteJButton.setBorderPainted(true);
		PasteJButton.setIcon(PasteImageIcon16);
		PasteJButton.setMargin(new Insets(2, 2, 2, 2));
		PasteJButton.setText("");
		PasteJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				PasteJButton_actionPerformed(e);
			}
		});
		CutJButton.setEnabled(false);
		CutJButton.setToolTipText("Cut");
		CutJButton.setBorderPainted(true);
		CutJButton.setIcon(CutImageIcon16);
		CutJButton.setMargin(new Insets(2, 2, 2, 2));
		CutJButton.setText("");
		CutJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				CutJButton_actionPerformed(e);
			}
		});
		EditJToolBar.setFloatable(true);
		RemoveAllJButton.setToolTipText("Remove Page");
		RemoveAllJButton.setBorderPainted(true);
		RemoveAllJButton.setIcon(DeleteImageIcon16);
		RemoveAllJButton.setMargin(new Insets(2, 2, 2, 2));
		RemoveAllJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				RemoveAllJButton_actionPerformed(e);
			}
		});
		DrawJToggleButton.setToolTipText("Draw");
		DrawJToggleButton.setBorderPainted(true);
		DrawJToggleButton.setIcon(DrawImageIcon16);
		DrawJToggleButton.setMargin(new Insets(2, 2, 2, 2));
		DrawJToggleButton.setSelected(true);
		DrawJToggleButton.setText("");
		DrawJToggleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				DrawJToggleButton_actionPerformed(e);
			}
		});
		SelectJToggleButton.setToolTipText("Select Symbols");
		SelectJToggleButton.setBorderPainted(true);
		SelectJToggleButton.setIcon(SelectImageIcon16);
		SelectJToggleButton.setMargin(new Insets(2, 2, 2, 2));
		SelectJToggleButton.setText("");
		SelectJToggleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				SelectJToggleButton_actionPerformed(e);
			}
		});
		SelectClosedStrokeJToggleButton
				.setToolTipText("Select by Using Stroke");
		SelectClosedStrokeJToggleButton.setBorderPainted(true);
		SelectClosedStrokeJToggleButton.setIcon(SelectStrokeImageIcon16);
		SelectClosedStrokeJToggleButton.setMargin(new Insets(0, 0, 0, 0));
		SelectClosedStrokeJToggleButton.setText("");
		SelectClosedStrokeJToggleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				HcrData.this.SelectClosedStrokeJToggleButton_actionPerformed(e);
			}
		});
		jButton3.setText("jButton3");
		BackJButton.setToolTipText("Previous");
		BackJButton.setIcon(BackImageIcon16);
		BackJButton.setMargin(new Insets(0, 0, 0, 0));
		BackJButton.setText("");
		BackJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				BackJButton_actionPerformed(e);
			}
		});
		NewDrawJButton.setToolTipText("New Page");
		NewDrawJButton.setIcon(NewDrawImageIcon16);
		NewDrawJButton.setMargin(new Insets(2, 2, 2, 2));
		NewDrawJButton.setText("");
		NewDrawJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				NewDrawJButton_actionPerformed(e);
			}
		});
		ForwardJButton.setToolTipText("Next");
		ForwardJButton.setIcon(ForwardImageIcon16);
		ForwardJButton.setMargin(new Insets(0, 0, 0, 0));
		ForwardJButton.setText("");
		ForwardJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				ForwardJButton_actionPerformed(e);
			}
		});
		GroupNameJComboBox.setEnabled(true);
		GroupNameJComboBox.setEditable(true);
		ToTeXJButton.setMaximumSize(new Dimension(26, 26));
		ToTeXJButton.setToolTipText("LaTeX Formula");
		ToTeXJButton.setInputVerifier(null);
		ToTeXJButton.setBorderPainted(true);
		ToTeXJButton.setIcon(ToTeXImageIcon16);
		ToTeXJButton.setMargin(new Insets(0, 0, 0, 0));
		ToMathematicaJButton.setMaximumSize(new Dimension(26, 26));
		ToMathematicaJButton.setToolTipText("Compute");
		ToMathematicaJButton.setBorderPainted(true);
		ToMathematicaJButton.setIcon(CalculusImageIcon16);
		ToMathematicaJButton.setMargin(new Insets(2, 2, 2, 2));
		ToTeXJButton.setMargin(new Insets(2, 2, 2, 2));
		ToTeXJButton.setText("");
		ToTeXJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				ToTeXJButton_actionPerformed(e);
			}
		});
		ToMathematicaJButton.setText("");
		ToMathematicaJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				ToMathematicaJButton_actionPerformed(e);
			}
		});
		Plot2DJButton.setToolTipText("Plot 2D");
		Plot2DJButton.setIcon(Plot2DImageIcon16);
		Plot2DJButton.setMargin(new Insets(2, 2, 2, 2));
		Plot2DJButton.setText("");
		Plot2DJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				Plot2DJButton_actionPerformed(e);
			}
		});
		Plot3DJButton.setToolTipText("Plot 3D");
		Plot3DJButton.setIcon(Plot3DmaticaImageIcon16);
		Plot3DJButton.setMargin(new Insets(2, 2, 2, 2));
		Plot3DJButton.setText("");
		Plot3DJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				Plot3DJButton_actionPerformed(e);
			}
		});
		SelectOpenStrokeToggleButton
				.setToolTipText("Select by Using Open Stroke");
		SelectOpenStrokeToggleButton.setVerifyInputWhenFocusTarget(true);
		SelectOpenStrokeToggleButton.setIcon(SelectOpenStrokeImageIcon16);
		SelectOpenStrokeToggleButton.setMargin(new Insets(0, 0, 0, 0));
		SelectOpenStrokeToggleButton.setText("");
		SelectOpenStrokeJToggleButton.setToolTipText("Select Strokes");
		SelectOpenStrokeJToggleButton.setIcon(SelectOpenStrokeImageIcon16);
		SelectOpenStrokeJToggleButton.setMargin(new Insets(2, 2, 2, 2));
		SelectOpenStrokeJToggleButton.setText("");
		SelectOpenStrokeJToggleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				HcrData.this.SelectOpenStrokeJToggleButton_actionPerformed(e);
			}
		});
		PreviousPageJButton.setToolTipText("Previous Page");
		PreviousPageJButton.setIcon(PreviousPageImageIcon16);
		PreviousPageJButton.setMargin(new Insets(2, 2, 2, 2));
		PreviousPageJButton.setText("");
		PreviousPageJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				PreviousPageJButton_actionPerformed(e);
			}
		});
		NextPageJButton.setToolTipText("Next Page");
		NextPageJButton.setIcon(NextPageImageIcon16);
		NextPageJButton.setMargin(new Insets(2, 2, 2, 2));
		NextPageJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				NextPageJButton_actionPerformed(e);
			}
		});
		NavigationAndToolsJToolBar.setFloatable(true);
		RefreshDrawAreaButton.setToolTipText("Refresh Draw Area");
		RefreshDrawAreaButton.setMargin(new Insets(0, 0, 0, 0));
		RefreshDrawAreaButton.setText("");
		RefreshDrawAreaJButton.setToolTipText("Refresh Page");
		RefreshDrawAreaJButton.setIcon(RefreshDrawAreaImageIcon16);
		RefreshDrawAreaJButton.setMargin(new Insets(2, 2, 2, 2));
		RefreshDrawAreaJButton.setText("");
		RefreshDrawAreaJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				RefreshDrawAreaJButton_actionPerformed(e);
			}
		});
		addHierarchyBoundsListener(new HierarchyBoundsAdapter() {
			@Override
			public void ancestorMoved(final HierarchyEvent e) {
				this_ancestorMoved(e);
			}
		});
		DrawJSplitPane.setOrientation(0);
		DrawJSplitPane.setDoubleBuffered(true);
		DrawJSplitPane.setPreferredSize(new Dimension(710, 580));
		DrawJSplitPane.setBottomComponent(viewingjPanel);
		DrawJSplitPane.setContinuousLayout(false);
		DrawJSplitPane.setLastDividerLocation(0);
		DrawJSplitPane.setOneTouchExpandable(false);
		DrawJSplitPane.setRightComponent(null);
		drawJPanel.setLayout(borderLayout3);
		drawingjPanel.setBorder(titledBorder1);
		drawingjPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE,
				Integer.MAX_VALUE));
		drawingjPanel.setMinimumSize(new Dimension(700, 0));
		drawingjPanel.setPreferredSize(new Dimension(1024, 768));
		drawingjPanel.setLayout(gridBagLayout2);
		viewingjPanel.setMinimumSize(new Dimension(710, 0));
		viewingjPanel.setPreferredSize(new Dimension(710, 220));
		viewingjPanel.setLayout(gridBagLayout1);
		viewjPanel.setBackground(Color.white);
		viewjPanel.setMinimumSize(new Dimension(350, 0));
		viewjPanel.setPreferredSize(new Dimension(350, 220));
		drawjScrollPane.setVerticalScrollBarPolicy(20);
		drawjScrollPane.setMaximumSize(new Dimension(32767, 32767));
		drawjScrollPane.setMinimumSize(new Dimension(700, 335));
		drawjScrollPane.setPreferredSize(new Dimension(32767, 32767));
		ViewJSplitPane.setLastDividerLocation(0);
		examplejScrollPane.setHorizontalScrollBarPolicy(30);
		examplejScrollPane.getViewport().setBackground(Color.white);
		examplejScrollPane.setMinimumSize(new Dimension(350, 220));
		examplejScrollPane.setPreferredSize(new Dimension(700, 300));
		examplejScrollPane.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(final ComponentEvent e) {
				examplejScrollPane_componentResized(e);
			}
		});
		EditJMenu.setText("Edit");
		UndoJMenuItem.setEnabled(false);
		UndoJMenuItem.setIcon(UndoImageIcon16);
		UndoJMenuItem.setText("Undo");
		UndoJMenuItem.setAccelerator(KeyStroke.getKeyStroke(90, 2, false));
		UndoJMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				UndoJMenuItem_actionPerformed(e);
			}
		});
		RedoJMenuItem.setEnabled(false);
		RedoJMenuItem.setIcon(RedoImageIcon16);
		RedoJMenuItem.setText("Redo");
		RedoJMenuItem.setAccelerator(KeyStroke.getKeyStroke(90, 3, false));
		RedoJMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				RedoJMenuItem_actionPerformed(e);
			}
		});
		CutJMenuItem.setEnabled(false);
		CutJMenuItem.setFocusPainted(false);
		CutJMenuItem.setIcon(CutImageIcon16);
		CutJMenuItem.setText("Cut");
		CutJMenuItem.setAccelerator(KeyStroke.getKeyStroke(88, 2, false));
		CutJMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				CutJMenuItem_actionPerformed(e);
			}
		});
		CopyJMenuItem.setEnabled(false);
		CopyJMenuItem.setDoubleBuffered(false);
		CopyJMenuItem.setIcon(CopyImageIcon16);
		CopyJMenuItem.setText("Copy");
		CopyJMenuItem.setAccelerator(KeyStroke.getKeyStroke(67, 2, false));
		CopyJMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				CopyJMenuItem_actionPerformed(e);
			}
		});
		SelectAllJMenuItem.setIcon(NullImageIcon16);
		SelectAllJMenuItem.setText("Select All");
		SelectAllJMenuItem.setAccelerator(KeyStroke.getKeyStroke(65, 2, false));
		SelectAllJMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				SelectAllJMenuItem_actionPerformed(e);
			}
		});
		PasteJMenuItem.setEnabled(false);
		PasteJMenuItem.setIcon(PasteImageIcon16);
		PasteJMenuItem.setMnemonic('0');
		PasteJMenuItem.setText("Paste");
		PasteJMenuItem.setAccelerator(KeyStroke.getKeyStroke(86, 2, false));
		PasteJMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				PasteJMenuItem_actionPerformed(e);
			}
		});
		MoveJToggleButton.setMaximumSize(new Dimension(26, 26));
		MoveJToggleButton.setMinimumSize(new Dimension(22, 22));
		MoveJToggleButton.setToolTipText("Move");
		MoveJToggleButton.setIcon(MoveSymbolImageIcon16);
		MoveJToggleButton.setMargin(new Insets(2, 2, 2, 2));
		MoveJToggleButton.setText("");
		MoveJToggleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				MoveJToggleButton_actionPerformed(e);
			}
		});
		GroupJToggleButton.setToolTipText("Group/Ungroup Symbols");
		GroupJToggleButton.setVerifyInputWhenFocusTarget(true);
		GroupJToggleButton.setIcon(GroupImageIcon16);
		GroupJToggleButton.setMargin(new Insets(0, 0, 0, 0));
		GroupJToggleButton.setText("");
		GroupOpenStrokeToggleButton.setToolTipText("Group/Ungroup Strokes");
		GroupOpenStrokeToggleButton.setIcon(GroupOpenStrokeImageIcon16);
		GroupOpenStrokeToggleButton.setMargin(new Insets(0, 0, 0, 0));
		GroupOpenStrokeToggleButton.setText("");
		symbolmstjMenuItem.setText("Symbol MST");
		symbolmstjMenuItem.setAccelerator(KeyStroke.getKeyStroke(83, 3, false));
		symbolmstjMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				symbolmstjMenuItem_actionPerformed(e);
			}
		});
		dominancehorizontalfactorjCheckBoxMenuItem
				.setText("Use Dominance Horizontal Factor");
		dominancehorizontalfactorjCheckBoxMenuItem
				.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(final ActionEvent e) {
						HcrData.this
								.dominancehorizontalfactorjCheckBoxMenuItem_actionPerformed(e);
					}
				});
		GroupSelectionjButton.setToolTipText("Group/Ungroup Selection");
		GroupSelectionjButton.setIcon(GroupImageIcon16);
		GroupSelectionjButton.setMargin(new Insets(2, 2, 2, 2));
		GroupSelectionjButton.setText("");
		GroupSelectionjButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				GroupSelectionjButton_actionPerformed(e);
			}
		});
		doublesidedjCheckBoxMenuItem.setText("Use Double Sided Dominace");
		doublesidedjCheckBoxMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				HcrData.this.doublesidedjCheckBoxMenuItem_actionPerformed(e);
			}
		});
		newjMenuItem.setActionCommand("New...");
		newjMenuItem.setIcon(NewImageIcon16);
		newjMenuItem.setMnemonic('0');
		newjMenuItem.setAccelerator(KeyStroke.getKeyStroke(78, 2, false));
		newjMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				newjMenuItem_actionPerformed(e);
			}
		});
		lowvelocityjCheckBoxMenuItem.setText("Low Velocity Points");
		lowvelocityjCheckBoxMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				HcrData.this.lowvelocityjCheckBoxMenuItem_actionPerformed(e);
			}
		});
		highcurvaturejCheckBoxMenuItem.setText("High Curvature Points");
		highcurvaturejCheckBoxMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				HcrData.this.highcurvaturejCheckBoxMenuItem_actionPerformed(e);
			}
		});
		getContentPane().setBackground(new Color(211, 209, 196));
		checkHorizontalBarjMenuItem.setText("Check Horizontal Bar");
		checkHorizontalBarjMenuItem.setAccelerator(KeyStroke.getKeyStroke(72,
				2, false));
		checkHorizontalBarjMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				HcrData.this.checkHorizontalBarjMenuItem_actionPerformed(e);
			}
		});
		openjMenuItem.setIcon(OpenImageIcon16);
		openjMenuItem.setAccelerator(KeyStroke.getKeyStroke(79, 2, false));
		savejMenuItem.setIcon(SaveImageIcon16);
		savejMenuItem.setAccelerator(KeyStroke.getKeyStroke(83, 2, false));
		saveasjMenuItem.setIcon(SaveAsImageIcon16);
		saveastrainingjMenuItem.setIcon(NullImageIcon16);
		exitjMenuItem.setIcon(NullImageIcon16);
		allpropertiesjCheckBoxMenuItem5.setAccelerator(KeyStroke.getKeyStroke(
				65, 3, false));
		smoothingjMenuItem.setAccelerator(KeyStroke.getKeyStroke(83, 8, false));
		equidistantjMenuItem.setAccelerator(KeyStroke
				.getKeyStroke(69, 8, false));
		tangenttransformationjMenuItem.setAccelerator(KeyStroke.getKeyStroke(
				84, 8, false));
		UndoJMenuItem2.setAccelerator(KeyStroke.getKeyStroke(85, 8, false));
		TreeJMenu.setText("Tree");
		PlotParam2DjButton.setToolTipText("Plot Parametric 2D");
		PlotParam2DjButton.setIcon(PlotParam2DImageIcon16);
		PlotParam2DjButton.setMargin(new Insets(2, 2, 2, 2));
		PlotParam2DjButton.setText("");
		PlotParam2DjButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				PlotParam2DjButton_actionPerformed(e);
			}
		});
		PlotParam3DjButton.setToolTipText("Plot Parametric 3D");
		PlotParam3DjButton.setIcon(PlotParam3DImageIcon16);
		PlotParam3DjButton.setMargin(new Insets(2, 2, 2, 2));
		PlotParam3DjButton.setText("");
		PlotParam3DjButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				PlotParam3DjButton_actionPerformed(e);
			}
		});
		usethislabeljCheckBoxMenuItem.setText("Fix This Label");
		allgroupsjRadioButtonMenuItem.setEnabled(false);
		jRadioButtonMenuItem5.setEnabled(false);
		refreshjMenuItem.setIcon(RefreshDrawAreaImageIcon16);
		refreshjMenuItem.setText("Refresh Page");
		refreshjMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				refreshjMenuItem_actionPerformed(e);
			}
		});
		plot3djMenuItem.setIcon(Plot3DmaticaImageIcon16);
		plot3djMenuItem.setText("Plot 3D");
		plot3djMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				plot3djMenuItem_actionPerformed(e);
			}
		});
		parametric2djMenuItem.setIcon(PlotParam2DImageIcon16);
		parametric2djMenuItem.setText("Plot Parametric 2D");
		parametric3djMenuItem.setIcon(PlotParam3DImageIcon16);
		parametric3djMenuItem.setText("Plot Parametric 3D");
		languageinterpreterjMenu.setText("Language Interpreter");
		tinybasicjRadioButtonMenuItem.setText("Tiny Basic");
		languagelatexjRadioButtonMenuItem.setText("LaTeX");
		groupView.add(asstrokejRadioButtonMenuItem);
		groupView.add(aspolygonaljRadioButtonMenuItem);
		nameSymboljTextField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				newSymboljButton_actionPerformed(e);
			}
		});
		ungroupjToggleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				groupjToggleButton_actionPerformed(e);
			}
		});
		pointsjCheckBoxMenuItem1.setText("Points");
		directionjCheckBoxMenuItem2.setText("Direction");
		asstrokejRadioButtonMenuItem.setText("As Stroke");
		aspolygonaljRadioButtonMenuItem.setText("As Polygonal");
		indexjCheckBoxMenuItem3.setText("Index");
		boundingboxjCheckBoxMenuItem4.setText("Bounding Box");
		allpropertiesjCheckBoxMenuItem5.setText("All Proprierties");
		processingjMenu.setText("Processing");
		jRadioButtonMenuItem2.setText("This Page");
		allgroupsjRadioButtonMenuItem.setText("All Pages");
		jRadioButtonMenuItem5.setText("All Pages in New Window");
		filteringjMenuItem.setText("Remove Repeated Points");
		smoothingjMenuItem.setText("Smooth");
		equidistantjMenuItem.setText("Equidistant Sampling");
		normalizejMenuItem.setText("Normalize Stroke Direction");
		orderjMenuItem.setText("Reorder Strokes");
		UndoJMenuItem2.setText("User Defined");
		processingparametersjMenuItem.setText("Parameters...");
		gropupingjMenu.setText("Grouping");
		jRadioButtonMenuItem6.setText("Right");
		jRadioButtonMenuItem7.setText("Left");
		jRadioButtonMenuItem8.setText("Above");
		jRadioButtonMenuItem9.setText("Below");
		jRadioButtonMenuItem10.setText("Top right");
		jRadioButtonMenuItem11.setText("Bottom right");
		jRadioButtonMenuItem12.setText("Top left");
		jRadioButtonMenuItem13.setText("Bottom left");
		jRadioButtonMenuItem14.setText("In");
		jRadioButtonMenuItem15.setText("Belonging");
		jRadioButtonMenuItem16.setText("Group");
		labeljCheckBoxMenuItem6.setText("Label");
		classfiersjMenu.setText("Recognition");
		UndojMenuItem.setText("Spatial relation...");
		saveastrainingjMenuItem.setText("Save As Trainig File...");
		numberofpointsjCheckBoxMenuItem7.setText("Number of Points");
		tangenttransformationjMenuItem.setText("Tangent Transformation");
		parametersviewUndoJMenuItem.setText("Parameters...");
		titledBorder1 = new TitledBorder(BorderFactory.createLineBorder(
				Color.black, 1), "Draw Panel");
		titledBorder2 = new TitledBorder(BorderFactory.createLineBorder(
				Color.black, 1), "Output");
		titledBorder3 = new TitledBorder(BorderFactory.createLineBorder(
				Color.black, 1), "Messages");
		border1 = new EtchedBorder(0, Color.white, new Color(178, 178, 178));
		getContentPane().setLayout(borderLayout1);
		viewjPanel.setBorder(titledBorder2);
		viewjPanel.setLayout(gridBagLayout4);
		setDefaultCloseOperation(0);
		setJMenuBar(jMenuBar1);
		nameSymboljTextField.setColumns(8);
		messagesjTextArea.setBorder(border3);
		messagesjScrollPane.setBorder(titledBorder3);
		filejMenu.setMnemonic('0');
		filejMenu.setText("File");
		exitjMenuItem.setText("Exit");
		exitjMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				exitjMenuItem_actionPerformed(e);
			}
		});
		newjMenuItem.setText("New");
		savejMenuItem.setText("Save...");
		saveasjMenuItem.setText("Save As...");
		closejMenuItem.setText("Close");
		openjMenuItem.setText("Open...");
		viewjMenu.setText("View");
		ungroupjToggleButton.setMargin(new Insets(0, 0, 0, 0));
		ungroupjToggleButton.setIcon(ungrogupIcon);
		ungroupjToggleButton.setSelectedIcon(ungroupIcon);
		ungroupjToggleButton.setToolTipText("Ungroup");
		viewingjPanel.add(ViewJSplitPane, new GridBagConstraints(0, 0, 1, 1,
				1.0, 1.0, 10, 1, new Insets(0, 0, 0, 0), 0, 0));
		ViewJSplitPane.add(messagesjScrollPane, "left");
		ViewJSplitPane.add(viewjPanel, "right");
		viewjPanel.add(examplejScrollPane, new GridBagConstraints(0, 0, 1, 1,
				1.0, 1.0, 10, 1, new Insets(0, 0, 0, 0), 0, 0));
		examplejScrollPane.getViewport().add(exampleJPanel, null);
		DrawJSplitPane.add(drawjScrollPane, "top");
		drawjScrollPane.getViewport().add(drawingjPanel, null);
		drawingjPanel.add(drawJPanel, new GridBagConstraints(0, 0, 1, 1, 1.0,
				1.0, 10, 1, new Insets(0, 0, 0, 0), 0, 0));
		messagesjScrollPane.getViewport().add(messagesjTextArea, null);
		DrawJSplitPane.add(viewingjPanel, "bottom");
		getContentPane().add(DrawJSplitPane, "Center");
		getContentPane().add(EditJToolBar, "North");
		EditJToolBar.add(OpenJButton, null);
		EditJToolBar.add(SaveJButton, null);
		EditJToolBar.addSeparator();
		EditJToolBar.add(PreviousPageJButton, null);
		EditJToolBar.add(NextPageJButton, null);
		EditJToolBar.add(RefreshDrawAreaJButton, null);
		EditJToolBar.add(NewDrawJButton, null);
		EditJToolBar.add(symboljComboBox, null);
		EditJToolBar.addSeparator();
		EditJToolBar.add(UndoJButton, null);
		EditJToolBar.add(RedoJButton, null);
		EditJToolBar.add(CopyJButton, null);
		EditJToolBar.add(PasteJButton, null);
		EditJToolBar.add(CutJButton, null);
		EditJToolBar.addSeparator();
		EditJToolBar.add(DrawJToggleButton, null);
		EditJToolBar.add(SelectJToggleButton, null);
		EditJToolBar.add(SelectOpenStrokeJToggleButton, null);
		EditJToolBar.add(GroupSelectionjButton, null);
		EditJToolBar.addSeparator();
		EditJToolBar.add(ToTeXJButton, null);
		EditJToolBar.add(ToMathematicaJButton, null);
		EditJToolBar.add(Plot2DJButton, null);
		EditJToolBar.add(Plot3DJButton, null);
		EditJToolBar.add(PlotParam2DjButton, null);
		EditJToolBar.add(PlotParam3DjButton, null);
		EditJToolBar.add(TinyBasicjButton, null);
		EditJToolBar.addSeparator();
		EditJToolBar.add(RemoveAllJButton, null);
		jMenuBar1.add(filejMenu);
		jMenuBar1.add(EditJMenu);
		jMenuBar1.add(viewjMenu);
		jMenuBar1.add(TreeJMenu);
		jMenuBar1.add(processingjMenu);
		jMenuBar1.add(gropupingjMenu);
		jMenuBar1.add(classfiersjMenu);
		jMenuBar1.add(jMenu1);
		jMenuBar1.add(HelpMenu);
		filejMenu.add(newjMenuItem);
		filejMenu.add(openjMenuItem);
		filejMenu.addSeparator();
		filejMenu.add(savejMenuItem);
		filejMenu.add(saveasjMenuItem);
		filejMenu.add(saveastrainingjMenuItem);
		filejMenu.addSeparator();
		filejMenu.add(closejMenuItem);
		filejMenu.addSeparator();
		filejMenu.add(exitjMenuItem);
		viewjMenu.add(asstrokejRadioButtonMenuItem);
		viewjMenu.add(aspolygonaljRadioButtonMenuItem);
		viewjMenu.addSeparator();
		viewjMenu.add(allpropertiesjCheckBoxMenuItem5);
		viewjMenu.addSeparator();
		viewjMenu.add(pointsjCheckBoxMenuItem1);
		viewjMenu.add(highcurvaturejCheckBoxMenuItem);
		viewjMenu.add(lowvelocityjCheckBoxMenuItem);
		viewjMenu.add(directionjCheckBoxMenuItem2);
		viewjMenu.add(indexjCheckBoxMenuItem3);
		viewjMenu.add(boundingboxjCheckBoxMenuItem4);
		viewjMenu.add(numberofpointsjCheckBoxMenuItem7);
		viewjMenu.add(labeljCheckBoxMenuItem6);
		viewjMenu.add(attractorsjCheckBoxMenuItem2);
		viewjMenu.addSeparator();
		viewjMenu.add(antialiasjCheckBoxMenuItem);
		viewjMenu.addSeparator();
		viewjMenu.add(graphicoutputjCheckBoxMenuItem);
		viewjMenu.addSeparator();
		viewjMenu.add(dominancejCheckBoxMenuItem);
		viewjMenu.addSeparator();
		viewjMenu.add(backgroundCheckBoxMenuItem1);
		viewjMenu.addSeparator();
		viewjMenu.add(parametersviewUndoJMenuItem);
		viewjMenu.add(checkMSTMatrixMemoryjCheckBoxMenuItem);
		TreeJMenu.add(spatialrelationjMenuItem);
		TreeJMenu.add(spatialareasUndoJMenuItem);
		TreeJMenu.add(dominancemstUndoJMenuItem);
		TreeJMenu.add(minimumspanningtreejMenuItem4);
		TreeJMenu.add(symbolmstjMenuItem);
		TreeJMenu.add(horizontalhistogramjMenuItem);
		TreeJMenu.add(verticalhistogramjMenuItem);
		TreeJMenu.add(checkHorizontalBarjMenuItem);
		TreeJMenu.addSeparator();
		TreeJMenu.add(distancefactorjCheckBoxMenuItem);
		TreeJMenu.add(usedominancejCheckBoxMenuItem2);
		TreeJMenu.add(usehorizontalfactorjCheckBoxMenuItem);
		TreeJMenu.add(dominancehorizontalfactorjCheckBoxMenuItem);
		TreeJMenu.add(doublesidedjCheckBoxMenuItem);
		processingjMenu.add(jRadioButtonMenuItem2);
		processingjMenu.add(allgroupsjRadioButtonMenuItem);
		processingjMenu.add(jRadioButtonMenuItem5);
		processingjMenu.addSeparator();
		processingjMenu.add(filteringjMenuItem);
		processingjMenu.add(normalizejMenuItem);
		processingjMenu.add(orderjMenuItem);
		processingjMenu.addSeparator();
		processingjMenu.add(smoothingjMenuItem);
		processingjMenu.add(clusterpointsjMenuItem);
		processingjMenu.add(equidistantjMenuItem);
		processingjMenu.add(poligonaljMenuItem);
		processingjMenu.add(dehookjMenuItem);
		processingjMenu.addSeparator();
		processingjMenu.add(tangenttransformationjMenuItem);
		processingjMenu.addSeparator();
		processingjMenu.add(UndoJMenuItem2);
		processingjMenu.addSeparator();
		processingjMenu.add(processingparametersjMenuItem);
		gropupingjMenu.add(jRadioButtonMenuItem16);
		gropupingjMenu.addSeparator();
		gropupingjMenu.add(jRadioButtonMenuItem6);
		gropupingjMenu.add(jRadioButtonMenuItem7);
		gropupingjMenu.add(jRadioButtonMenuItem8);
		gropupingjMenu.add(jRadioButtonMenuItem9);
		gropupingjMenu.add(jRadioButtonMenuItem10);
		gropupingjMenu.add(jRadioButtonMenuItem11);
		gropupingjMenu.add(jRadioButtonMenuItem12);
		gropupingjMenu.add(jRadioButtonMenuItem13);
		gropupingjMenu.add(jRadioButtonMenuItem14);
		gropupingjMenu.add(jRadioButtonMenuItem15);
		classfiersjMenu.add(defaultclassifierjMenu2);
		classfiersjMenu.addSeparator();
		classfiersjMenu.add(jMenu2);
		classfiersjMenu.add(UndojMenuItem);
		classfiersjMenu.addSeparator();
		classfiersjMenu.add(commandinterpreterjCheckBoxMenuItem);
		classfiersjMenu.add(jMenu3);
		classfiersjMenu.add(languageinterpreterjMenu);
		classfiersjMenu.addSeparator();
		classfiersjMenu.add(readformulajCheckBoxMenuItem);
		classfiersjMenu.addSeparator();
		classfiersjMenu.add(jMenuItem4);
		HelpMenu.add(aboutjMenuItem);
		symboljPopupMenu.add(labelJTextField, 0);
		groupjPopupMenu.add(previousjMenuItem);
		groupjPopupMenu.add(nextjMenuItem);
		groupjPopupMenu.add(refreshjMenuItem);
		groupjPopupMenu.addSeparator();
		groupjPopupMenu.add(newGroupjMenuItem);
		groupjPopupMenu.addSeparator();
		groupjPopupMenu.add(texjMenuItem);
		groupjPopupMenu.add(evaluatejMenuItem);
		groupjPopupMenu.add(showjMenuItem);
		groupjPopupMenu.add(plot3djMenuItem);
		groupjPopupMenu.add(parametric2djMenuItem);
		groupjPopupMenu.add(parametric3djMenuItem);
		groupjPopupMenu.addSeparator();
		groupjPopupMenu.add(removejMenuItem);
		defaultclassifierjMenu2.add(basicjRadioButtonMenuItem);
		defaultclassifierjMenu2.add(smalljRadioButtonMenuItem);
		defaultclassifierjMenu2.add(capitaljRadioButtonMenuItem);
		defaultclassifierjMenu2.add(greekjRadioButtonMenuItem1);
		defaultclassifierjMenu2.add(punctuationjRadioButtonMenuItem);
		final ButtonGroup menuBarDefaultClassifierGroup = new ButtonGroup();
		menuBarDefaultClassifierGroup.add(basicjRadioButtonMenuItem);
		menuBarDefaultClassifierGroup.add(smalljRadioButtonMenuItem);
		menuBarDefaultClassifierGroup.add(capitaljRadioButtonMenuItem);
		menuBarDefaultClassifierGroup.add(greekjRadioButtonMenuItem1);
		menuBarDefaultClassifierGroup.add(punctuationjRadioButtonMenuItem);
		jMenu3.add(jRadioButtonMenuItem1);
		jMenu3.add(jRadioButtonMenuItem3);
		jMenu3.add(jRadioButtonMenuItem4);
		jMenu2.add(supportArrayListjRadioButtonMenuItem17);
		jMenu2.add(nearestneighborsjRadioButtonMenuItem18);
		symbolrecognizergroup.add(supportArrayListjRadioButtonMenuItem17);
		symbolrecognizergroup.add(nearestneighborsjRadioButtonMenuItem18);
		NavigationAndToolsJToolBar.add(jButton3, null);
		symboljPopupMenu.add(usethislabeljCheckBoxMenuItem);
		symboljPopupMenu.addSeparator();
		labelJTextField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				labelJTextField_actionPerformed(e);
			}
		});
		DrawSelectButtonGroup.add(DrawJToggleButton);
		DrawSelectButtonGroup.add(SelectJToggleButton);
		DrawSelectButtonGroup.add(SelectClosedStrokeJToggleButton);
		DrawSelectButtonGroup.add(SelectOpenStrokeToggleButton);
		DrawSelectButtonGroup.add(SelectOpenStrokeJToggleButton);
		EditJMenu.add(UndoJMenuItem);
		EditJMenu.add(RedoJMenuItem);
		EditJMenu.addSeparator();
		EditJMenu.add(CutJMenuItem);
		EditJMenu.add(CopyJMenuItem);
		EditJMenu.add(PasteJMenuItem);
		EditJMenu.addSeparator();
		EditJMenu.add(SelectAllJMenuItem);
		DrawJSplitPane.setDividerLocation(200);
		drawJPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent e) {
				drawJPanel_mouseClicked(e);
			}

			@Override
			public void mouseEntered(final MouseEvent e) {
				drawJPanel_mouseEntered(e);
			}

			@Override
			public void mouseReleased(final MouseEvent e) {
				drawJPanel_mouseReleased(e);
			}
		});
		drawJPanel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(final KeyEvent e) {
				drawJPanel_keyPressed(e);
			}

			@Override
			public void keyReleased(final KeyEvent e) {
				drawJPanel_keyReleased(e);
			}
		});
		drawJPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(final MouseEvent e) {
				drawJPanel_mouseDragged(e);
			}
		});
		ViewJSplitPane.setDividerLocation(200);
		DrawSelectButtonGroup.add(MoveJToggleButton);
		DrawSelectButtonGroup.add(GroupJToggleButton);
		DrawSelectButtonGroup.add(GroupOpenStrokeToggleButton);
		languageinterpreterjMenu.add(languagelatexjRadioButtonMenuItem);
		languageinterpreterjMenu.add(tinybasicjRadioButtonMenuItem);
	}

	void labelJTextField_actionPerformed(final ActionEvent e) {
		if (!symbolSelected.name.equals(labelJTextField.getText())
				&& !labelJTextField.getText().equals("")) {
			symbolSelected.name = new String(labelJTextField.getText());
			symbolSelected.classifierType = -1;
		}
		symboljPopupMenu.setVisible(false);
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		drawJPanel.setStrokeMemory(symbol, backgroundImage[index % ngroups]);
	}

	void labeljCheckBoxMenuItem6_actionPerformed(final ActionEvent e) {
		final boolean state = labeljCheckBoxMenuItem6.getState();
		labelOld = state;
		Symbol.drawLabel = state;
		if (!labelOld) {
			allpropertiesjCheckBoxMenuItem5.setState(false);
		}
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
	}

	public Image latex2Image(final String latexExp, final boolean inline)
			throws Exception {
		final MediaTracker tracker = new MediaTracker(this);
		final Runtime r = Runtime.getRuntime();
		Image img = null;
		final String latexContent = "\\batchmode\n\\documentclass[12pt]{article}\n\\usepackage{amsmath}\n\\usepackage{amssymb}\n\\pagestyle{empty}\n\\begin{document}\n\\Large\n"
				+ (inline ? "$" : "$$")
				+ "\n"
				+ latexExp
				+ "\n"
				+ (inline ? "$" : "$$") + "\n" + "\\end{document}\n";
		final String filename = tmp + "JMathNotes"
				+ Long.toString(new Date().getTime());
		final DataOutputStream fileout = new DataOutputStream(
				new FileOutputStream(filename + ".tex"));
		fileout.writeBytes(latexContent);
		fileout.close();
		Process p = r.exec("latex " + filename + ".tex", null, new File(tmp));
		if (p.waitFor() != 0) {
			System.err.print("Error in latex\n");
		}
		p = r.exec("dvips " + filename + ".dvi -o " + filename + ".ps", null,
				new File(tmp));
		if (p.waitFor() != 0) {
			System.err.print("Error in dvips\n");
		}
		if (System.getProperty("os.name").equals("Linux")) {
			p = r.exec("convert -antialias -crop 0x0 " + filename + ".ps "
					+ filename + ".png", null, new File(tmp));
		} else {
			p = r.exec("C:/ImageMagick-5.5.7-Q16/convert -antialias -crop 0x0 "
					+ filename + ".ps " + filename + ".png", null,
					new File(tmp));
		}
		if (p.waitFor() != 0) {
			System.err.print("Error convert\n");
		}
		img = Toolkit.getDefaultToolkit().getImage(filename + ".png");
		tracker.addImage(img, 0);
		try {
			tracker.waitForAll();
		} catch (InterruptedException ie) {
		}
		deleteOnExit(filename);
		return img;
	}

	public Image latex2Image(final String latexExp) throws Exception {
		return latex2Image(latexExp, true);
	}

	public Image latex2Image() throws Exception {
		final MediaTracker tracker = new MediaTracker(this);
		final Runtime r = Runtime.getRuntime();
		Image img = null;
		final String latexContent = "\\batchmode\n\\documentclass[12pt]{article}\n\\usepackage{amsmath}\n\\usepackage{amssymb}\n\\pagestyle{empty}\n\\begin{document}\n\\Large\n$$\n"
				+ latexExp + "\n" + "$$\n" + "\\end{document}\n";
		final String filename = tmp + "JMathNotes"
				+ Long.toString(new Date().getTime());
		final DataOutputStream fileout = new DataOutputStream(
				new FileOutputStream(filename + ".tex"));
		fileout.writeBytes(latexContent);
		fileout.close();
		Process p = r.exec("latex " + filename + ".tex", null, new File(tmp));
		if (p.waitFor() != 0) {
			System.err.print("Error in latex\n");
		}
		p = r.exec("dvips " + filename + ".dvi -o " + filename + ".ps", null,
				new File(tmp));
		if (p.waitFor() != 0) {
			System.err.print("Error in dvips\n");
		}
		if (System.getProperty("os.name").equals("Linux")) {
			p = r.exec("convert -antialias -crop 0x0 " + filename + ".ps "
					+ filename + ".png", null, new File(tmp));
		} else {
			p = r.exec("C:/ImageMagick-5.5.7-Q16/convert -antialias -crop 0x0 "
					+ filename + ".ps " + filename + ".png", null,
					new File(tmp));
		}
		if (p.waitFor() != 0) {
			System.err.print("Error convert\n");
		}
		img = Toolkit.getDefaultToolkit().getImage(filename + ".png");
		tracker.addImage(img, 0);
		try {
			tracker.waitForAll();
		} catch (InterruptedException ie) {
		}
		deleteOnExit(filename);
		return img;
	}

	@SuppressWarnings("deprecation")
	public Image latex2ImageRemote(String latexExp) {
		Image img = null;
		MediaTracker tracker = new MediaTracker(this);
		String label = Long.toString((new Date()).getTime());

		try {
			// URL url = new
			// URL("http://michel.inf.fu-berlin.de:8080/~tapia/cgi-bin/latextoimage.pl");
			URL url = new URL(
					"http://michel.inf.fu-berlin.de:8080/~tapia/cgi-bin/latextoimage.pl");
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			PrintWriter out = new PrintWriter(connection.getOutputStream());
			out.print("latex=" + URLEncoder.encode(latexExp) + "&label="
					+ URLEncoder.encode(label));
			// System.err.println("latex="+URLEncoder.encode(latexExp)+"&label="+URLEncoder.encode(label));
			out.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
			}
			in.close();

			try {
				img = Toolkit.getDefaultToolkit().getImage(
						new URL(
								"http://michel.inf.fu-berlin.de:8080/~tapia/cgi-bin/tmp_latextoimage"
										+ label + ".png"));
				tracker.addImage(img, 0);
				tracker.waitForAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			try {
				img = Toolkit.getDefaultToolkit().getImage(
						new URL(
								"http://michel.inf.fu-berlin.de:8080/~tapia/cgi-bin/tmp_latextoimage"
										+ label + ".png"));
				tracker.addImage(img, 0);
				tracker.waitForAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return img;
	}

	@SuppressWarnings("deprecation")
	public Image latex2ImageRemote() {
		Image img = null;
		MediaTracker tracker = new MediaTracker(this);
		String label = Long.toString((new Date()).getTime());

		try {
			// URL url = new
			// URL("http://michel.inf.fu-berlin.de:8080/~tapia/cgi-bin/latextoimage.pl");
			URL url = new URL(
					"http://michel.inf.fu-berlin.de:8080/~tapia/cgi-bin/latextoimage.pl");
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			PrintWriter out = new PrintWriter(connection.getOutputStream());
			out.print("latex=" + URLEncoder.encode(latexExp) + "&label="
					+ URLEncoder.encode(label));
			// System.err.println("latex="+URLEncoder.encode(latexExp)+"&label="+URLEncoder.encode(label));
			out.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
			}
			in.close();

			try {
				img = Toolkit.getDefaultToolkit().getImage(
						new URL(
								"http://michel.inf.fu-berlin.de:8080/~tapia/cgi-bin/tmp_latextoimage"
										+ label + ".png"));
				tracker.addImage(img, 0);
				tracker.waitForAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			try {
				img = Toolkit.getDefaultToolkit().getImage(
						new URL(
								"http://michel.inf.fu-berlin.de:8080/~tapia/cgi-bin/tmp_latextoimage"
										+ label + ".png"));
				tracker.addImage(img, 0);
				tracker.waitForAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return img;
	}

	void lowvelocityjCheckBoxMenuItem_actionPerformed(final ActionEvent e) {
		final boolean state = lowvelocityjCheckBoxMenuItem.getState();
		lowOld = state;
		DStroke.drawVelocityPoints = state;
		if (!lowOld) {
			allpropertiesjCheckBoxMenuItem5.setState(false);
		}
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
	}

	public static void main(final String[] argv) throws Exception {
		final HcrData hcrData = new HcrData();
		hcrData.readClassificationModel();
		hcrData.initializePanels();
	}

	public Image math2Image() throws Exception {
		MediaTracker tracker = new MediaTracker(this);
		DataOutputStream fileout;
		Runtime r = Runtime.getRuntime();
		Process p;
		Image img = null;
		String filename;
		String label;
		String latexContent;

		label = Long.toString((new Date()).getTime());
		filename = tmp + "JMathNotes" + label;
		fileout = new DataOutputStream(new FileOutputStream(filename + ".math"));
		latexContent = "TextForm[\"\\batchmode\"] >>> "
				+ filename
				+ ".tex\n"
				+ "TextForm[\"\\documentclass[12pt]{article}\"] >>> "
				+ filename
				+ ".tex\n"
				+
				// "TextForm[\"\\usepackage{amsmath}\"] >>> "+filename+".tex\n"
				// +
				"TextForm[\"\\usepackage{amssymb}\"] >>> " + filename
				+ ".tex\n" + "TextForm[\"\\pagestyle{empty}\"] >>> " + filename
				+ ".tex\n" + "TextForm[\"\\begin{document}\"] >>> " + filename
				+ ".tex\n" + "TextForm[\"\\Large\"] >>> " + filename + ".tex\n"
				+ "TextForm[\"$$\"] >>> " + filename
				+ ".tex\n"
				+
				// "TeXForm[MatrixForm["+mathExp+"]] >>> "+filename+".tex\n" +
				"TeXForm[" + mathExp + "] >>> " + filename + ".tex\n"
				+ "TextForm[\"$$\"] >>> " + filename + ".tex\n"
				+ "TextForm[\"\\end{document}\"] >>> " + filename + ".tex\n";

		fileout.writeBytes(latexContent);
		fileout.close();

		p = r.exec(path + "scripts/exemath " + filename + ".math", null,
				new File(tmp));

		try {
			p.waitFor();
		} catch (InterruptedException e) {
			System.out
					.println("InterruptedException raised: " + e.getMessage());
		}

		BufferedReader in = new BufferedReader(new InputStreamReader(
				p.getInputStream()));
		String inputLine;

		System.out.println(p + "InputStream:");
		while ((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);
		}
		in.close();

		in = new BufferedReader(new InputStreamReader(p.getErrorStream()));
		System.out.println(p + "ErrorStream:");
		while ((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);
		}
		in.close();

		p = r.exec("latex " + filename + ".tex", null, new File(tmp));
		if (p.waitFor() != 0) {
			System.err.print("Error in latex\n");
		}

		p = r.exec("dvips " + filename + ".dvi -o " + filename + ".ps", null,
				new File(tmp));
		if (p.waitFor() != 0) {
			System.err.print("Error in dvips\n");
		}

		if (System.getProperty("os.name").equals("Linux")) {
			p = r.exec("convert -antialias -crop 0x0 " + filename + ".ps "
					+ filename + ".png", null, new File(tmp));
		} else {
			p = r.exec("C:/ImageMagick-5.5.7-Q16/convert -antialias -crop 0x0 "
					+ filename + ".ps " + filename + ".png", null,
					new File(tmp));
		}

		if (p.waitFor() != 0) {
			System.err.print("Error convert\n");
		}

		img = Toolkit.getDefaultToolkit().getImage(filename + ".png");

		tracker.addImage(img, 0);
		try {
			tracker.waitForAll();
		} catch (InterruptedException ie) {
		}

		deleteOnExit(filename);

		return img;
	}

	@SuppressWarnings("deprecation")
	public Image math2ImageRemote() {
		Image img = null;
		MediaTracker tracker = new MediaTracker(this);
		String label = Long.toString((new Date()).getTime());

		try {
			URL url = new URL(
					"http://michel.inf.fu-berlin.de:8080/~tapia/cgi-bin/mathtoimage.pl");
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");
			PrintWriter out = new PrintWriter(connection.getOutputStream());
			out.print("latex=" + URLEncoder.encode(mathExp) + "&label="
					+ URLEncoder.encode(label));
			System.err.println("latex=" + URLEncoder.encode(latexExp)
					+ "&label=" + URLEncoder.encode(label));
			out.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				System.out.println(inputLine);
			}
			in.close();

			try {
				img = Toolkit.getDefaultToolkit().getImage(
						new URL(
								"http://michel.inf.fu-berlin.de:8080/~tapia/cgi-bin/tmp_latextoimage"
										+ label + ".png"));
				tracker.addImage(img, 0);
				tracker.waitForAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			try {
				img = Toolkit.getDefaultToolkit().getImage(
						new URL(
								"http://michel.inf.fu-berlin.de:8080/~tapia/cgi-bin/tmp_latextoimage"
										+ label + ".png"));
				tracker.addImage(img, 0);
				tracker.waitForAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return img;
	}

	void minimumspanningtreejMenuItem4_actionPerformed(final ActionEvent e) {
		final SymbolList simpleList = new SymbolList();
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
		int count = 0;
		for (int i = 0; i < symbol.size(); ++i) {
			final Symbol s = symbol.get(i);
			for (int j = 0; j < s.size(); ++j) {
				final DStroke ds = s.strokeAt(j);
				simpleList.add(new SymbolNode((int) ds.getMinX(), (int) ds
						.getMinY(), (int) ds.getMaxX(), (int) ds.getMaxY(), "s"
						+ ++count));
			}
		}
		final SymbolList tree = MSTPrim.construct(simpleList, new SymbolList());
		tree.drawDad(drawJPanel.getGraphics2D());
	}

	void nearestneighborsjRadioButtonMenuItem18_actionPerformed(
			final ActionEvent e) {
		if (tan == null) {
			(tan = new Tangent()).readSymbols(symboldata);
		}
	}

	void newGroupjMenuItem_actionPerformed(final ActionEvent e) {
		newSymboljButton_actionPerformed(e);
	}

	void newSymboljButton_actionPerformed(final ActionEvent e) {
		drawJPanel.setStrokeSelectedIndexes(null, false);
		drawJPanel.setSymbolSelectedIndexes(null, false);
		actualizeSymboljComboBox(true);
		drawJPanel.setDrawable(true);
		nameSymboljTextField.setText("");
		drawJPanel.erase();
		symbol = new ArrayList<Symbol>();
		symbolData.add(symbol);
		drawJPanel.setStrokeMemory(symbol, backgroundImage[index % ngroups]);
		symboljComboBox.setSelectedIndex(index);
		newGenerated = false;
		isChanged = true;
	}

	void newjMenuItem_actionPerformed(final ActionEvent e) {
	}

	void nextjMenuItem_actionPerformed(final ActionEvent e) {
		forwardjButton_actionPerformed(e);
	}

	void normalizejMenuItem_actionPerformed(final ActionEvent e) {
		Symbol s = null;
		for (int i = 0; i < symbol.size(); ++i) {
			s = symbol.get(i);
			s.normalizeDirection();
		}
		isChanged = true;
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
	}

	void numberofpointsjCheckBoxMenuItem7_actionPerformed(final ActionEvent e) {
		final boolean state = numberofpointsjCheckBoxMenuItem7.getState();
		numberofpointsOld = state;
		Symbol.drawNumberOfPoints = state;
		if (!numberofpointsOld) {
			allpropertiesjCheckBoxMenuItem5.setState(false);
		}
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
	}

	public static String oldReplace(final String aInput,
			final String aOldPattern, final String aNewPattern) {
		final StringBuffer result = new StringBuffer();
		int startIdx = 0;
		for (int idxOld = 0; (idxOld = aInput.indexOf(aOldPattern, startIdx)) >= 0; startIdx = idxOld
				+ aOldPattern.length()) {
			result.append(aInput.substring(startIdx, idxOld));
			result.append(aNewPattern);
		}
		result.append(aInput.substring(startIdx));
		return result.toString();
	}

	void openjMenuItem_actionPerformed(final ActionEvent e) {
	}

	void orderjMenuItem_actionPerformed(final ActionEvent e) {
		Symbol s = null;
		for (int i = 0; i < symbol.size(); ++i) {
			s = symbol.get(i);
			s.orderStrokes();
		}
		isChanged = true;
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
	}

	void parametric2djMenuItem_actionPerformed(final ActionEvent e) {
		PlotParam2DjButton_actionPerformed(e);
	}

	void parametric3djMenuItem_actionPerformed(final ActionEvent e) {
		PlotParam3DjButton_actionPerformed(e);
	}

	public Image plot2DImage() throws Exception {
		MediaTracker tracker = new MediaTracker(this);

		Runtime r = Runtime.getRuntime();

		Image img = null;

		int size = Math.min(viewjPanel.getHeight(), viewjPanel.getWidth());

		String label = Long.toString(new Date().getTime());
		String filename = tmp + "JMathNotes" + label;
		DataOutputStream fileout = new DataOutputStream(new FileOutputStream(
				filename + ".math"));
		String latexContent = "Export[\"" + filename + ".eps\",Plot[" + plotExp
				+ ",{x,-1,1},ImageSize->{" + size + "," + size
				+ "},AxesLabel->{\"x\",\"y\"}],\"EPS\"]\n";

		fileout.writeBytes(latexContent);
		fileout.close();

		Process p = r.exec(path + "scripts/exemath " + filename + ".math",
				null, new File(tmp));
		try {
			p.waitFor();
		} catch (InterruptedException e) {
			System.out
					.println("InterruptedException raised: " + e.getMessage());
		}

		BufferedReader in = new BufferedReader(new InputStreamReader(
				p.getInputStream()));

		System.out.println(p + "InputStream:");
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			String str1 = "wtf";
			System.out.println(str1);
		}
		in.close();

		in = new BufferedReader(new InputStreamReader(p.getErrorStream()));
		System.out.println(p + "ErrorStream:");
		while ((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);
		}
		in.close();

		if (System.getProperty("os.name").equals("Linux")) {
			p = r.exec("convert -antialias -crop 0x0 " + filename + ".eps "
					+ filename + ".png", null, new File(tmp));
		} else {
			p = r.exec("C:/ImageMagick-5.5.7-Q16/convert -antialias -crop 0x0 "
					+ filename + ".ps " + filename + ".png", null,
					new File(tmp));
		}

		if (p.waitFor() != 0) {
			System.err.print("Error convert\n");
		}

		img = Toolkit.getDefaultToolkit().getImage(filename + ".png");

		tracker.addImage(img, 0);
		try {
			tracker.waitForAll();
		} catch (InterruptedException ie) {
		}
		deleteOnExit(filename);

		return img;
	}

	@SuppressWarnings("deprecation")
	public Image plot2DImageRemote() {
		Image img = null;
		MediaTracker tracker = new MediaTracker(this);
		String label = Long.toString(new Date().getTime());
		String args = "";
		try {
			URL url = new URL(
					"http://michel.inf.fu-berlin.de:8080/~tapia/cgi-bin/plottoimage.pl");

			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");

			PrintWriter out = new PrintWriter(connection.getOutputStream());
			args = args + "latex=" + URLEncoder.encode(plotExp) + "&"
					+ "label=" + URLEncoder.encode(label) + "&" + "a=-1&b=1";

			out.print(args);
			System.err.println(args);
			out.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));

			while (in.readLine() != null)
				;

			in.close();
			try {
				img = Toolkit.getDefaultToolkit().getImage(
						new URL(
								"http://michel.inf.fu-berlin.de:8080/~tapia/cgi-bin/tmp_plottoimage"
										+ label + ".png"));

				tracker.addImage(img, 0);
				tracker.waitForAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			try {
				img = Toolkit.getDefaultToolkit().getImage(
						new URL(
								"http://michel.inf.fu-berlin.de:8080/~tapia/cgi-bin/tmp_latextoimage"
										+ label + ".png"));

				tracker.addImage(img, 0);
				tracker.waitForAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return img;
	}

	public Image plot3D2Image() throws Exception {
		MediaTracker tracker = new MediaTracker(this);

		Runtime r = Runtime.getRuntime();

		Image img = null;

		int size = Math.min(viewjPanel.getHeight(), viewjPanel.getWidth());

		String label = Long.toString(new Date().getTime());
		String filename = tmp + "JMathNotes" + label;
		DataOutputStream fileout = new DataOutputStream(new FileOutputStream(
				filename + ".math"));
		String latexContent = "Export[\"" + filename + ".eps\",Plot3D["
				+ plot3DExp + ",{x,-1,1},{y,-1,1},ImageSize->{" + size + ","
				+ size + "}, AxesLabel -> {\"x\",\"y\",\"\"}],\"EPS\"]\n";

		fileout.writeBytes(latexContent);
		fileout.close();

		Process p = r.exec(path + "scripts/exemath " + filename + ".math",
				null, new File(tmp));
		try {
			p.waitFor();
		} catch (InterruptedException e) {
			System.out
					.println("InterruptedException raised: " + e.getMessage());
		}

		BufferedReader in = new BufferedReader(new InputStreamReader(
				p.getInputStream()));

		System.out.println(p + "InputStream:");
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			String str1 = "wtf";
			System.out.println(str1);
		}
		in.close();

		in = new BufferedReader(new InputStreamReader(p.getErrorStream()));
		System.out.println(p + "ErrorStream:");
		while ((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);
		}
		in.close();

		if (System.getProperty("os.name").equals("Linux")) {
			p = r.exec("convert -antialias -crop 0x0 " + filename + ".eps "
					+ filename + ".png", null, new File(tmp));
		} else {
			p = r.exec("C:/ImageMagick-5.5.7-Q16/convert -antialias -crop 0x0 "
					+ filename + ".ps " + filename + ".png", null,
					new File(tmp));
		}

		if (p.waitFor() != 0) {
			System.err.print("Error convert\n");
		}

		img = Toolkit.getDefaultToolkit().getImage(filename + ".png");

		tracker.addImage(img, 0);
		try {
			tracker.waitForAll();
		} catch (InterruptedException ie) {
		}
		deleteOnExit(filename);

		return img;
	}

	@SuppressWarnings("deprecation")
	public Image plot3D2ImageRemote() {
		Image img = null;
		MediaTracker tracker = new MediaTracker(this);
		String label = Long.toString(new Date().getTime());
		String args = "";
		try {
			URL url = new URL(
					"http://michel.inf.fu-berlin.de:8080/~tapia/cgi-bin/plot3Dtoimage.pl");

			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestProperty("Content-Type",
					"application/x-www-form-urlencoded");

			PrintWriter out = new PrintWriter(connection.getOutputStream());
			args = args + "latex=" + URLEncoder.encode(plot3DExp) + "&"
					+ "label=" + URLEncoder.encode(label) + "&"
					+ "a=-1&b=1&c=-1&d=1";

			out.print(args);
			System.err.println(args);
			out.close();

			BufferedReader in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			while (in.readLine() != null)
				;
			in.close();
			try {
				img = Toolkit.getDefaultToolkit().getImage(
						new URL(
								"http://michel.inf.fu-berlin.de:8080/~tapia/cgi-bin/tmp_plot3Dtoimage"
										+ label + ".png"));

				tracker.addImage(img, 0);
				tracker.waitForAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (MalformedURLException mue) {
			mue.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			try {
				img = Toolkit.getDefaultToolkit().getImage(
						new URL(
								"http://michel.inf.fu-berlin.de:8080/~tapia/cgi-bin/tmp_latextoimage"
										+ label + ".png"));

				tracker.addImage(img, 0);
				tracker.waitForAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return img;
	}

	void plot3DjButton_actionPerformed(final ActionEvent e) {
		if (symbol.isEmpty()) {
			return;
		}
		final SymbolList sl = new SymbolList();
		for (int i = 0; i < symbol.size(); ++i) {
			final Symbol s = symbol.get(i);
			sl.add(new SymbolNode((int) s.getMinX(), (int) s.getMinY(), (int) s
					.getMaxX(), (int) s.getMaxY(), s.name));
		}
		sl.sort();
		final BaselineStructureTree bst = new BaselineStructureTree(sl);
		bst.buildTree();
		plot3DExp = "\\!\\(" + bst.interpretMathematica() + "\\)";
		messagesjTextArea.append("Plot3D: " + plot3DExp + "\n");
		expressionjTextField.setText(plot3DExp);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
		plot3DSelected = true;
		if (graphicoutputjCheckBoxMenuItem.getState()) {
			new Plot3DThread().start();
		}
	}

	void plot3djMenuItem_actionPerformed(final ActionEvent e) {
		Plot3DJButton_actionPerformed(e);
	}

	public Image plotParametric2DImage() throws Exception {
		MediaTracker tracker = new MediaTracker(this);

		Runtime r = Runtime.getRuntime();

		Image img = null;

		int size = Math.min(viewjPanel.getHeight(), viewjPanel.getWidth());

		String label = Long.toString(new Date().getTime());
		String filename = tmp + "JMathNotes" + label;
		DataOutputStream fileout = new DataOutputStream(new FileOutputStream(
				filename + ".math"));

		String latexContent = "Export[\"" + filename + ".eps\",ParametricPlot["
				+ plotParametric2DExp + ",ImageSize->{" + size + "," + size
				+ "},AxesLabel->{\"x\",\"y\"}],\"EPS\"]\n";

		fileout.writeBytes(latexContent);
		fileout.close();

		Process p = r.exec(path + "scripts/exemath " + filename + ".math",
				null, new File(tmp));
		try {
			p.waitFor();
		} catch (InterruptedException e) {
			System.out
					.println("InterruptedException raised: " + e.getMessage());
		}

		BufferedReader in = new BufferedReader(new InputStreamReader(
				p.getInputStream()));

		System.out.println(p + "InputStream:");
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			String str1 = "wtf";
			System.out.println(str1);
		}
		in.close();

		in = new BufferedReader(new InputStreamReader(p.getErrorStream()));
		System.out.println(p + "ErrorStream:");
		while ((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);
		}
		in.close();

		if (System.getProperty("os.name").equals("Linux")) {
			p = r.exec("convert -antialias -crop 0x0 " + filename + ".eps "
					+ filename + ".png", null, new File(tmp));
		} else {
			p = r.exec("C:/ImageMagick-5.5.7-Q16/convert -antialias -crop 0x0 "
					+ filename + ".ps " + filename + ".png", null,
					new File(tmp));
		}

		if (p.waitFor() != 0) {
			System.err.print("Error convert\n");
		}

		img = Toolkit.getDefaultToolkit().getImage(filename + ".png");

		tracker.addImage(img, 0);
		try {
			tracker.waitForAll();
		} catch (InterruptedException ie) {
		}
		deleteOnExit(filename);

		return img;
	}

	public Image plotParametric3D2Image() throws Exception {
		MediaTracker tracker = new MediaTracker(this);

		Runtime r = Runtime.getRuntime();

		Image img = null;

		int size = Math.min(viewjPanel.getHeight(), viewjPanel.getWidth());

		String label = Long.toString(new Date().getTime());
		String filename = tmp + "JMathNotes" + label;
		DataOutputStream fileout = new DataOutputStream(new FileOutputStream(
				filename + ".math"));
		String latexContent = "Export[\"" + filename
				+ ".eps\",ParametricPlot3D[" + plotParametric3DExp
				+ ",ImageSize->{" + size + "," + size
				+ "}, AxesLabel -> {\"x\",\"y\",\"\"}],\"EPS\"]\n";

		fileout.writeBytes(latexContent);
		fileout.close();

		Process p = r.exec(path + "scripts/exemath " + filename + ".math",
				null, new File(tmp));
		try {
			p.waitFor();
		} catch (InterruptedException e) {
			System.out
					.println("InterruptedException raised: " + e.getMessage());
		}

		BufferedReader in = new BufferedReader(new InputStreamReader(
				p.getInputStream()));

		System.out.println(p + "InputStream:");
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			String str1 = "wtf";
			System.out.println(str1);
		}
		in.close();

		in = new BufferedReader(new InputStreamReader(p.getErrorStream()));
		System.out.println(p + "ErrorStream:");
		while ((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);
		}
		in.close();

		if (System.getProperty("os.name").equals("Linux")) {
			p = r.exec("convert -antialias -crop 0x0 " + filename + ".eps "
					+ filename + ".png", null, new File(tmp));
		} else {
			p = r.exec("C:/ImageMagick-5.5.7-Q16/convert -antialias -crop 0x0 "
					+ filename + ".ps " + filename + ".png", null,
					new File(tmp));
		}

		if (p.waitFor() != 0) {
			System.err.print("Error convert\n");
		}

		img = Toolkit.getDefaultToolkit().getImage(filename + ".png");

		tracker.addImage(img, 0);
		try {
			tracker.waitForAll();
		} catch (InterruptedException ie) {
		}
		deleteOnExit(filename);

		return img;
	}

	void pointsgraphicoutputjCheckBoxMenuItem_actionPerformed(
			final ActionEvent e) {
		final boolean state = pointsjCheckBoxMenuItem1.getState();
		pointsOld = state;
		DStroke.drawPoints = state;
		if (!pointsOld) {
			allpropertiesjCheckBoxMenuItem5.setState(false);
		}
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
	}

	void polygonaljMenuItem_actionPerformed(final ActionEvent e) {
		Symbol s = null;
		int c = 0;
		for (int i = 0; i < symbol.size(); ++i) {
			s = symbol.get(i);
			c = s.classifierType;
			s = new Symbol(
					s.proyeccionPolygonal(pointsPolygonalApproximationProcessing));
			classify(s, c);
			symbol.set(i, s);
		}
		isChanged = true;
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
	}

	void previousjMenuItem_actionPerformed(final ActionEvent e) {
		backwardjButton_actionPerformed(e);
	}

	void processingparametersjMenuItem_actionPerformed(final ActionEvent e) {
		final ProcessPropertiesJDialog processPropertiesJDialog = new ProcessPropertiesJDialog(
				this, "Processing Parameters - JMathNotes");
		processPropertiesJDialog.setLocation();
		processPropertiesJDialog.setVisible(true);
	}

	void punctuationjRadioButtonMenuItem_actionPerformed(final ActionEvent e) {
	}

	public void purgeSymbol() {
		for (int i = symbol.size() - 1; i > -1; --i) {
			final Symbol s = symbol.get(i);
			classify(s);
			if (s.isEmpty()) {
				symbol.remove(i);
			}
		}
	}

	@SuppressWarnings("unused")
	public void read(String filenamein) {
		BufferedReader filein = null;
		StringTokenizer st;
		String line;
		Symbol sym;
		ArrayList<Symbol> group;
		int nsim, i, count;

		newGenerated = true;
		try {
			filein = new BufferedReader(new FileReader(filenamein));
			symbolData.clear();
			symboljComboBox.removeAllItems();
			index = -1;
			while ((line = filein.readLine()) != null) {
				st = new StringTokenizer(line, " \n\t\r\f");
				count = st.countTokens();

				line = "";
				for (i = 0; i < count - 1; i++) {
					line += st.nextToken() + " ";
				}
				symboljComboBox.addItem(new StringBuffer(line));
				// symboljComboBox.addItem(new
				// StringBuffer(st.nextToken()));
				// nameSymboljTextField.setText("");
				// drawJPanel.erase();

				nsim = Integer.parseInt(st.nextToken());
				group = new ArrayList<Symbol>();
				for (i = 0; i < nsim; i++) {
					group.add(Symbol.readSymbol(filein));
				}
				symbolData.add(group);
			}
			actualizeSymboljComboBox(false);

			if (!symbolData.isEmpty()) {
				index = 0;
				drawJPanel.setStrokeMemory(symbolData.get(0));
				symboljComboBox.setSelectedIndex(0);
				symbol = symbolData.get(0);
			}
		} catch (FileNotFoundException fnfe) {
			showWindowMessage("File " + filenamein + " not found.", "Error");
			newGenerated = false;
		} catch (IOException ioe) {
			showWindowMessage("Error reading " + filenamein + ".", "Error");
			newGenerated = false;
		}

		newGenerated = false;

	}

	public void readClassificationModel() {
		maxNumStrokes = new int[numClassifiers];
		svmModel = new SvmModel[numClassifiers][];
		if (url == null) {
			for (int i = 0; i < numClassifiers; ++i) {
				svmModel[i] = new SvmModel[4];
				maxNumStrokes[i] = 0;
				for (int j = 0; j < 4; ++j) {
					try {
						svmModel[i][j] = new SvmModel();
						System.out.println("Loading SvmModel: " + i + ""
								+ modelname + "" + j + ".svm");
						svmModel[i][j].read("/models/" + i + "" + modelname
								+ "" + j + ".svm");
						maxNumStrokes[i] = j + 1;
					} catch (FileNotFoundException fnfe) {
						svmModel[i][j] = null;
						break;
					} catch (IOException ioe) {
					}
				}
				if (i == 0) {
					l.setVisible(false);
				}
			}
		} else {
			for (int i = 0; i < numClassifiers; ++i) {
				svmModel[i] = new SvmModel[4];
				maxNumStrokes[i] = 0;
				for (int j = 0; j < 4; ++j) {
					try {
						(svmModel[i][j] = new SvmModel()).read(new URL(url
								.toString()
								+ "models/"
								+ i
								+ ""
								+ modelname
								+ "" + j + ".svm"));
						maxNumStrokes[i] = j + 1;
					} catch (FileNotFoundException fnfe) {
						svmModel[i][j] = null;
						break;
					} catch (IOException ioe) {
					}
				}
			}
		}
		downloadModelThread = null;
	}

	public void readImageIcon() throws Exception {
		if (url == null) {
			groupIcon = new ImageIcon(path + "icons/group.jpg", "group icon");
			ungroupIcon = new ImageIcon(path + "icons/ungroup.jpg",
					"ungroup icon");
			deleteIcon = new ImageIcon(path + "icons/delete.jpg", "delete icon");
			selectIcon = new ImageIcon(path + "icons/select.jpg", "select icon");
			drawIcon = new ImageIcon(path + "icons/draw.jpg", "draw icon");
			groupgIcon = new ImageIcon(path + "icons/groupg.jpg", "group icon");
			ungrogupIcon = new ImageIcon(path + "icons/ungroupg.jpg",
					"ungroup icon");
			deletgeIcon = new ImageIcon(path + "icons/deleteg.jpg",
					"delete icon");
			selecgtIcon = new ImageIcon(path + "icons/selectg.jpg",
					"select icon");
			drawgIcon = new ImageIcon(path + "icons/drawg.jpg", "draw icon");
			deletelastIcon = new ImageIcon(path + "icons/deletelast.jpg",
					"delete last icon");
			deletelastgIcon = new ImageIcon(path + "icons/deletelastg.jpg",
					"delete last icon");
			deleteallIcon = new ImageIcon(path + "icons/deleteall.jpg",
					"delete icon");
			deleteallgIcon = new ImageIcon(path + "icons/deleteallg.jpg",
					"delete icon");
			openIcon = new ImageIcon(path + "icons/open.jpg", "group icon");
			saveIcon = new ImageIcon(path + "icons/save.jpg", "group icon");
			backIcon = new ImageIcon(path + "icons/Back24.gif", "group icon");
			forwardIcon = new ImageIcon(path + "icons/Forward24.gif",
					"group icon");
			newIcon = new ImageIcon(path + "icons/new.jpg", "group icon");
			formulaIcon = new ImageIcon(path + "icons/tex.jpg", "group icon");
			deletegroupIcon = new ImageIcon(path + "icons/Delete24.gif",
					"group icon");
			graphicsIcon = new ImageIcon(path + "icons/graphics.jpg",
					"group icon");
			calculusIcon = new ImageIcon(path + "icons/calculus.jpg",
					"group icon");
			repaint();
		} else {
			groupIcon = new ImageIcon(new URL(url.toString()
					+ "icons/group.jpg"));
			ungroupIcon = new ImageIcon(new URL(url.toString()
					+ "icons/ungroup.jpg"));
			deleteIcon = new ImageIcon(new URL(url.toString()
					+ "icons/delete.jpg"));
			selectIcon = new ImageIcon(new URL(url.toString()
					+ "icons/select.jpg"));
			drawIcon = new ImageIcon(new URL(url.toString() + "icons/draw.jpg"));
			groupgIcon = new ImageIcon(new URL(url.toString()
					+ "icons/groupg.jpg"));
			ungrogupIcon = new ImageIcon(new URL(url.toString()
					+ "icons/ungroupg.jpg"));
			deletgeIcon = new ImageIcon(new URL(url.toString()
					+ "icons/deleteg.jpg"));
			selecgtIcon = new ImageIcon(new URL(url.toString()
					+ "icons/selectg.jpg"));
			drawgIcon = new ImageIcon(new URL(url.toString()
					+ "icons/drawg.jpg"));
			deletelastIcon = new ImageIcon(new URL(url.toString()
					+ "icons/deletelast.jpg"));
			deletelastgIcon = new ImageIcon(new URL(url.toString()
					+ "icons/deletelastg.jpg"));
			deleteallIcon = new ImageIcon(new URL(url.toString()
					+ "icons/deleteall.jpg"));
			deleteallgIcon = new ImageIcon(new URL(url.toString()
					+ "icons/deleteallg.jpg"));
			openIcon = new ImageIcon(new URL(url.toString() + "icons/open.jpg"));
			saveIcon = new ImageIcon(new URL(url.toString() + "icons/save.jpg"));
			backIcon = new ImageIcon(new URL(url.toString()
					+ "icons/Back24.gif"));
			forwardIcon = new ImageIcon(new URL(url.toString()
					+ "icons/Forward24.gif"));
			newIcon = new ImageIcon(new URL(url.toString() + "icons/new.jpg"));
			formulaIcon = new ImageIcon(new URL(url.toString()
					+ "icons/tex.jpg"));
			deletegroupIcon = new ImageIcon(new URL(url.toString()
					+ "icons/Delete24.gif"));
			graphicsIcon = new ImageIcon(new URL(url.toString()
					+ "icons/graphics.jpg"));
			calculusIcon = new ImageIcon(new URL(url.toString()
					+ "icons/calculus.jpg"));
		}
	}

	public void refreshUndoRedo() {
		UndoJMenuItem.setText(undoManager_.getUndoPresentationName());
		UndoJMenuItem.setEnabled(undoManager_.canUndo());
		UndoJButton.setToolTipText(undoManager_.getUndoPresentationName());
		UndoJButton.setEnabled(undoManager_.canUndo());
		RedoJMenuItem.setText(undoManager_.getRedoPresentationName());
		RedoJMenuItem.setEnabled(undoManager_.canRedo());
		RedoJButton.setToolTipText(undoManager_.getRedoPresentationName());
		RedoJButton.setEnabled(undoManager_.canRedo());
		PasteJButton.setEnabled(!copyPasteMemory.isEmpty());
		PasteJMenuItem.setEnabled(!copyPasteMemory.isEmpty());
	}

	void refreshjMenuItem_actionPerformed(final ActionEvent e) {
		RefreshDrawAreaJButton_actionPerformed(e);
	}

	public void removeTmpFiles() {
		if (url == null) {
			final Runtime r = Runtime.getRuntime();
			try {
				final Process p = r.exec(
						"rm " + path + "svm/classes/data/tmp*", null, new File(
								path + "data/"));
				if (p.waitFor() != 0) {
					System.err.print("Error in removing tmp* files\n");
				}
			} catch (Exception ioex) {
				try {
					final Process p = r.exec("del " + path + "tmp/tmp*", null,
							new File(tmp));
					if (p.waitFor() != 0) {
						System.err.print("Error in removing tmp* files\n");
					}
				} catch (Exception ioex2) {
					System.err.print("Error in removing tmp* files\n");
				}
				System.err.print("Error in removing tmp* files:\n"
						+ ioex.toString());
			}
		}
		formulaThread = null;
	}

	void removejMenuItem_actionPerformed(final ActionEvent e) {
		deletegroupjButton_actionPerformed(e);
	}

	@Override
	public void run() {
		try {
			final SymbolList sl = new SymbolList();
			for (int i = 0; i < symbol.size(); ++i) {
				final Symbol s = symbol.get(i);
				sl.add(new SymbolNode((int) s.getMinX(), (int) s.getMinY(),
						(int) s.getMaxX(), (int) s.getMaxY(), s.name));
			}
			sl.sort();
			if (dominancejCheckBoxMenuItem.getState()) {
				startSymbolNode(sl);
			}
			img = null;
			if (url == null) {
				if (texSelected) {
					img = latex2Image();
					texSelected = false;
				} else if (calculusSelected) {
					img = math2Image();
					calculusSelected = false;
				} else if (plotSelected) {
					img = plot2DImage();
					plotSelected = false;
				} else if (plot3DSelected) {
					img = plot3D2Image();
					plot3DSelected = false;
				} else if (plotParametric2DSelected) {
					img = plotParametric2DImage();
					plotParametric2DSelected = false;
				} else if (plotParametric3DSelected) {
					img = plotParametric3D2Image();
					plotParametric3DSelected = false;
				}
			} else if (texSelected) {
				img = latex2ImageRemote();
				texSelected = false;
			} else if (calculusSelected) {
				img = math2ImageRemote();
				calculusSelected = false;
			} else if (plotSelected) {
				img = plot2DImageRemote();
				plotSelected = false;
			} else if (plot3DSelected) {
				img = plot3D2ImageRemote();
				plot3DSelected = false;
			}
			actualizeExample();
		} catch (NullPointerException npe) {
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		formulaThread = null;
	}

	void saveasjMenuItem_actionPerformed(final ActionEvent e) {
	}

	void savejMenuItem_actionPerformed(final ActionEvent e) {
	}

	public void selectStrokes(final int deltaX, final int deltaY) {
		final boolean[][] indexes = selectIndex;
		for (int i = indexes.length - 1; i > -1; --i) {
			final Symbol sym = symbol.get(i);
			boolean selected = false;
			for (int j = indexes[i].length - 1; j > -1; --j) {
				selected = (selected || indexes[i][j]);
				if (indexes[i][j]) {
					sym.strokeAt(j).translate(deltaX, deltaY);
				}
			}
			if (selected) {
				sym.actualizeMaxMin();
			}
		}
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		for (int k = indexes.length - 1; k > -1; --k) {
			final Symbol sym = symbol.get(k);
			for (int l = indexes[k].length - 1; l > -1; --l) {
				if (indexes[k][l]) {
					sym.strokeAt(l).draw(drawJPanel.getGraphics2D(),
							Color.green);
				}
			}
		}
	}

	public boolean[][] selectedIndexes() {
		final boolean[][] indexes = new boolean[symbol.size()][];
		final DStroke ds = drawJPanel.getInputStroke();
		for (int i = 0; i < symbol.size(); ++i) {
			final Symbol s = symbol.get(i);
			indexes[i] = new boolean[s.size()];
			boolean selected = false;
			for (int j = 0; j < s.size(); ++j) {
				final DStroke dStroke = ds;
				final DStroke stroke = s.strokeAt(j);
				final double n = 1.75;
				s.strokeAt(j);
				if (dStroke.boundigBoxIntersection(stroke, n * DStroke.r)) {
					final boolean[] array = indexes[i];
					final int n2 = j;
					final DStroke proyectionPolygonal = ds
							.proyectionPolygonal(16);
					final DStroke proyectionPolygonal2 = s.strokeAt(j)
							.proyectionPolygonal(16);
					final double n3 = 1.75;
					s.strokeAt(j);
					final boolean distance = proyectionPolygonal.distance(
							proyectionPolygonal2, n3 * DStroke.r);
					array[n2] = distance;
					selected = distance;
				}
			}
			if (selected) {
				s.classifierType = -2;
			}
		}
		return indexes;
	}

	void selectjToggleButton_actionPerformed(final ActionEvent e) {
		final JToggleButton button = (JToggleButton) e.getSource();
		if (button.isSelected()) {
			drawJPanel.setEditColor(Color.green);
			drawJPanel.setEditMode(true);
		} else {
			drawJPanel.setEditMode(false);
		}
	}

	public void showPopup(final MouseEvent e) {
		Symbol s = null;
		boolean clickOnSymbol = false;
		drawJPanel.setSymbolSelectedIndexes(null, false);
		drawJPanel.setStrokeSelectedIndexes(null, false);
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		final DStroke ds = new DStroke();
		ds.add(new DPoint(e.getX(), e.getY()));
		final boolean[] indexes = new boolean[symbol.size()];
		for (int i = 0; i < symbol.size(); ++i) {
			s = symbol.get(i);
			if (s.distance(ds, 5.25)) {
				symbolSelected = s;
				labelJTextField.setText(s.name);
				if (s.classifierType >= 0) {
					classifierTypeRadioButtonMenuItem[s.classifierType]
							.setSelected(true);
				}
				clickOnSymbol = true;
				indexes[i] = true;
				drawJPanel.setSymbolSelectedIndexes(indexes, true);
				drawJPanel.drawSelectedSymbols();
				drawJPanel.repaint();
				symboljPopupMenu.show(e.getComponent(), e.getX(), e.getY());
				return;
			}
		}
		if (!clickOnSymbol) {
			groupjPopupMenu.show(e.getComponent(), e.getX(), e.getY());
		}
	}

	public void showWindowMessage(final String text, final String title) {
		final Object[] options = { "Close" };
		JOptionPane.showOptionDialog(this, text, title, -1, 1, null, options,
				options[0]);
	}

	public int showWindowYesNo(final String text, final String title,
			final Object[] options) {
		final int n = JOptionPane.showOptionDialog(this, text, title, 1, 3,
				null, options, options[1]);
		return n;
	}

	public int showWindowYesNo(final String text, final String title) {
		final Object[] options = { "Yes", "No" };
		final int n = JOptionPane.showOptionDialog(this, text, title, 1, 3,
				null, options, options[1]);
		return n;
	}

	public int showWindowYesNoCancel(final String text, final String title,
			final Object[] options) {
		final int n = JOptionPane.showOptionDialog(this, text, title, 1, 3,
				null, options, options[0]);
		return n;
	}

	public int showWindowYesNoCancel(final String text, final String title) {
		final Object[] options = { "Yes", "No", "Cancel" };
		final int n = JOptionPane.showOptionDialog(this, text, title, 1, 3,
				null, options, options[0]);
		return n;
	}

	void showjMenuItem_actionPerformed(final ActionEvent e) {
		graphicsjButton_actionPerformed(e);
	}

	void smalljRadioButtonMenuItem_actionPerformed(final ActionEvent e) {
		classifierType = 1;
	}

	void smoothingjMenuItem_actionPerformed(final ActionEvent e) {
		Symbol s = null;
		int c = 0;
		for (int i = 0; i < symbol.size(); ++i) {
			s = symbol.get(i);
			c = s.classifierType;
			s = new Symbol(s.smooth());
			classify(s, c);
			symbol.set(i, s);
		}
		isChanged = true;
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
	}

	void spatialareasjMenuItem_actionPerformed(final ActionEvent e) {
		if (symbol.isEmpty()) {
			return;
		}
		final Image img = createImage(drawJPanel.getWidth(),
				drawJPanel.getHeight());
		final Graphics g = img.getGraphics();
		final SymbolList sl = new SymbolList();
		final int wr = 2;
		final int hr = 2;
		int i = 0;
		// final int h = 0;
		// final int w = 0;
		while (i < symbol.size() - 1) {
			final Symbol s = symbol.get(i);
			sl.add(new SymbolNode((int) s.getMinX(), (int) s.getMinY(), (int) s
					.getMaxX(), (int) s.getMaxY(), s.name));
			++i;
		}
		sl.sort();
		// final BaselineStructureTree bst =
		new BaselineStructureTree(sl);
		final SymbolList hor = sl;
		final Symbol s = symbol.get(symbol.size() - 1);
		SymbolNode sn = new SymbolNode((int) s.getMinX(), (int) s.getMinY(),
				(int) s.getMaxX(), (int) s.getMaxY(), s.name);
		final int border = 2 * Math.max(sn.width, sn.height);
		g.setColor(Color.white);
		g.fillRect(0, 0, img.getWidth(this), img.getHeight(this));
		System.out.println(sl.toString() + " " + s.toString());
		for (int x = sl.getMinX() - border; x < sl.getMaxX() + border; x += wr) {
			for (int y = sl.getMinY() - border; y < sl.getMaxY() + border; y += hr) {
				int imin = -1;
				double dmin = 2.147483647E9;
				for (i = 0; i < hor.size(); ++i) {
					sn = new SymbolNode(x - (int) (s.getWidth() / 2.0), y
							- (int) (s.getHeight() / 2.0), x
							+ (int) (s.getHeight() / 2.0), y
							+ (int) (s.getHeight() / 2.0), s.name);
					if (dmin > SymbolEdge.getDistance(hor.symbolNodeAt(i), sn)) {
						dmin = SymbolEdge.getDistance(hor.symbolNodeAt(i), sn);
						imin = i;
					}
				}
				g.setColor(new Color(156 + imin * 100 / hor.size(), 156 + imin
						* 100 / hor.size(), 156 + imin * 100 / hor.size()));
				g.fillRect(x, y, wr, hr);
			}
		}
		drawJPanel.setBackgroundImge(img);
		drawJPanel.drawStrokeMemory();
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
	}

	void spatialrelationjMenuItem_actionPerformed(final ActionEvent e) {
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
		final SymbolList sl = new SymbolList();
		for (int i = 0; i < symbol.size(); ++i) {
			final Symbol s = symbol.get(i);
			sl.add(new SymbolNode((int) s.getMinX(), (int) s.getMinY(), (int) s
					.getMaxX(), (int) s.getMaxY(), s.name));
		}
		sl.sort();
		final BaselineStructureTree bst = new BaselineStructureTree(sl);
		bst.buildTree();
		bst.symbolList.draw(drawJPanel.getGraphics2D());
		bst.symbolList.drawSomeUpDown(drawJPanel.getGraphics2D());
	}

	public void startSymbolNode(final SymbolList sl) {
		if (sl.size() == 1) {
			sl.symbolNodeAt(0).drawBoundingBox(drawJPanel.getGraphics2D(),
					Color.green);
			return;
		}
		final SymbolList remaining = new SymbolList();
		final int n = sl.size() - 1;
		remaining.add(sl);
		if (sl.symbolNodeAt(n).dominates(sl.symbolNodeAt(n - 1))) {
			remaining.remove(n - 1);
			sl.symbolNodeAt(n).drawBoundingBox(drawJPanel.getGraphics2D(),
					Color.green);
		} else {
			remaining.remove(n);
			if (sl.symbolNodeAt(n - 1).dominates(sl.symbolNodeAt(n))) {
				sl.symbolNodeAt(n - 1).drawBoundingBox(
						drawJPanel.getGraphics2D(), Color.green);
			}
		}
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
		// final SymbolDrawJPanel drawJPanel = drawJPanel;
		DrawJPanel.delay(0.45f);
		startSymbolNode(remaining);
	}

	ArrayList<Symbol> symbolArrayListCopy(final ArrayList<Symbol> v) {
		final ArrayList<Symbol> u = new ArrayList<Symbol>();
		for (int i = 0; i < v.size(); ++i) {
			u.add(new Symbol(v.get(i)));
		}
		return u;
	}

	void symboljComboBox_actionPerformed(final ActionEvent e) {
		if (newGenerated || symboljComboBox.getItemCount() == 0) {
			return;
		}
		final int selected = symboljComboBox.getSelectedIndex();
		if (selected != -1) {
			index = selected;
			symbol = symbolData.get(index);
			drawJPanel
					.setStrokeMemory(symbol, backgroundImage[index % ngroups]);
		}
		newGenerated = false;
	}

	void symboljComboBox_itemStateChanged(final ItemEvent e) {
	}

	void symbolmstjMenuItem_actionPerformed(final ActionEvent e) {
		final SymbolList simpleList = new SymbolList();
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
		for (int i = 0; i < symbol.size(); ++i) {
			final Symbol ds = symbol.get(i);
			simpleList.add(new SymbolNode((int) ds.getMinX(), (int) ds
					.getMinY(), (int) ds.getMaxX(), (int) ds.getMaxY(),
					new String(ds.name)));
		}
		simpleList.sort();
		final SymbolList tree = MSTPrim.construct(simpleList, new SymbolList());
		tree.drawDad(drawJPanel.getGraphics2D());
	}

	void tangentAnimation() {
		Symbol s = null;
		final int size = symbol.size();
		int x = 1;
		int y = 1;
		int times = 10;
		System.out.println(processingSequenceProcessing);
		if (!processingSequenceProcessing.equals("")) {
			final StringTokenizer st = new StringTokenizer(
					processingSequenceProcessing, " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			times = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < size; ++i) {
			s = new Symbol(symbol.get(i));
			symbol.add(s);
			for (double t = -tangentTransformationProcessing; t <= tangentTransformationProcessing; t += tangentTransformationProcessing
					/ times) {
				final Symbol ns = s.slopeTansformation(t, x, y);
				symbol.set(i, ns);
				DrawJPanel.delay(0.5f);
				drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
				drawJPanel.drawStrokeMemorySelectedStrokes();
				drawJPanel.drawStrokeMemorySelectedSymbols();
				drawJPanel.repaint();
				System.out.println("Tangent: " + t);
			}
		}
		isChanged = true;
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
		tt = null;
	}

	void tangenttransformationjMenuItem_actionPerformed(final ActionEvent e) {
		Symbol s = null;
		for (int size = symbol.size(), i = 0; i < size; ++i) {
			s = new Symbol(symbol.get(i));
			Symbol ns = s.getProcessedSingleSymbol(
					tangentTransformationProcessing,
					pointsPolygonalApproximationProcessing);
			ns.setTopLeft(s.getMinX() + s.getWidth() + 10.0, s.getMinY());
			ns.classifierType = s.classifierType;
			classify(ns, s.classifierType);
			symbol.add(size + i, new Symbol(ns));
			ns = s.getProcessedSingleSymbol(tangentTransformationProcessing,
					pointsPolygonalApproximationProcessing);
			ns.setTopLeft(s.getMinX() - ns.getWidth() - 10.0, s.getMinY());
			ns.classifierType = s.classifierType;
			classify(ns, s.classifierType);
			symbol.add(size + i, new Symbol(ns));
		}
		isChanged = true;
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
	}

	void texjMenuItem_actionPerformed(final ActionEvent e) {
		construcformulajButton_actionPerformed(e);
	}

	void this_ancestorMoved(final HierarchyEvent e) {
	}

	void this_windowClosing(final WindowEvent e) {
		if (url != null) {
			return;
		}
		final Object[] options = { "Yes", "No" };
		final int n = JOptionPane.showOptionDialog(this,
				"Do you wanto to leave the application?", "Question", 1, 3,
				null, options, options[1]);
		if (n == 0) {
			setVisible(false);
			if (url == null) {
				removeTmpFiles();
				dispose();
				System.exit(0);
			}
		}
	}

	void usedominanceattractorsdistancefactorjCheckBoxMenuItem_actionPerformed(
			final ActionEvent e) {
		SymbolEdge.setUsingAtractors(usedominancejCheckBoxMenuItem2.getState());
	}

	void usehorizontalfactorjCheckBoxMenuItem_actionPerformed(
			final ActionEvent e) {
		SymbolEdge.setHorizontalFactors(usehorizontalfactorjCheckBoxMenuItem
				.getState());
	}

	void verifyCommand(final Symbol s) {
		if (!s.name.equals("\\end")) {
			return;
		}
		if (!commandinterpreterjCheckBoxMenuItem.isSelected()) {
			return;
		}
		final SymbolList sl = new SymbolList();
		String command = "";
		System.out.print("Out: ");
		final SymbolNode sn = new SymbolNode(s.minX, s.minY, s.maxX, s.maxY,
				s.name);
		final boolean[] indexes = new boolean[symbol.size()];
		for (int i = 0; i < symbol.size(); ++i) {
			final Symbol smem = symbol.get(i);
			final SymbolNode snaux = new SymbolNode(smem.minX, smem.minY,
					smem.maxX, smem.maxY, smem.name);
			if (sn.subexpression(snaux)) {
				sl.add(snaux);
				indexes[i] = true;
			} else if (!smem.name.equals("\\end")) {
				indexes[i] = false;
				System.out.print(smem.name + " ");
			}
		}
		System.out.println();
		sl.sort();
		for (int i = 0; i < sl.size(); ++i) {
			command += sl.symbolNodeAt(i).name;
		}
		drawJPanel.setSymbolSelectedIndexes(indexes, true);
		final Edit edit = new CutSymbolEdit(this, index, "Interpret Command");
		edit.execute();
		undoSupport_.postEdit(edit);
		drawJPanel.setSymbolSelectedIndexes(null, false);
		drawJPanel.setStrokeSelectedIndexes(null, false);
		System.out.println("command: " + command);
		if (command.equals("c") || command.equals("\\int")) {
			calculusSelected = true;
			calculusjButton_actionPerformed(new ActionEvent(this, 0, "Calculus"));
		}
		if (command.equals("5") || command.equals("s")) {
			solveSelected = true;
			calculusSelected = false;
			calculusjButton_actionPerformed(new ActionEvent(this, 0, "Solve"));
		} else if (command.equals("p") || command.equals("1d")
				|| command.equals("d")) {
			plotSelected = true;
			graphicsjButton_actionPerformed(new ActionEvent(this, 0, "Plot"));
		} else if (command.equals("2p") || command.equals("pp")
				|| command.equals("3d")) {
			plot3DSelected = true;
			plot3DjButton_actionPerformed(new ActionEvent(this, 0, "Plot3D"));
		} else if (command.equals("b")) {
			TinyBasicjButton_actionPerformed(new ActionEvent(this, 0, "Basic"));
		} else {
			construcformulajButton_actionPerformed(new ActionEvent(this, 0,
					"Formula"));
		}
	}

	void verticalhistogramjMenuItem_actionPerformed(final ActionEvent e) {
		drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		drawJPanel.drawStrokeMemorySelectedStrokes();
		drawJPanel.drawStrokeMemorySelectedSymbols();
		drawJPanel.repaint();
		final SymbolList sl = new SymbolList();
		// final SymbolList inTree = new SymbolList();
		for (int i = 0; i < symbol.size(); ++i) {
			final Symbol s = symbol.get(i);
			sl.add(new SymbolNode((int) s.getMinX(), (int) s.getMinY(), (int) s
					.getMaxX(), (int) s.getMaxY(), s.name));
		}
		sl.drawVerticalProyection(drawJPanel.getGraphics2D(), Color.red, 0.05);
		drawJPanel.repaint();
	}

	public void write(final String filenameout) {
		DataOutputStream fileout = null;
		try {
			fileout = new DataOutputStream(new FileOutputStream(filenameout));
			for (int j = 0; j < symbolData.size(); ++j) {
				final ArrayList<Symbol> group = symbolData.get(j);
				fileout.writeBytes(symboljComboBox.getItemAt(j) + " ");
				fileout.writeBytes(group.size() + "\n");
				for (int i = 0; i < group.size(); ++i) {
					group.get(i).write(fileout);
				}
			}
		} catch (FileNotFoundException fnfe) {
			showWindowMessage("File " + filenameout + " not found.", "Error");
		} catch (IOException ioe) {
			showWindowMessage("Error reading " + filenameout + ".", "Error");
		}
	}

	private class GroupUngroupSymbolEdit extends Edit {
		/**
		 * 
		 */
		private static final long serialVersionUID = 8411121793949663565L;
		int i;
		private int index;
		// int j;
		String presentationName;
		private ArrayList<Symbol> strokeMemory;
		private boolean symbolSelected;
		private boolean[] symbolSelectedIndexes;

		public GroupUngroupSymbolEdit(final HcrData hcrData_, final int index_) {
			super();
			presentationName = "Group/Ungroup Strokes";
			strokeMemory = symbolArrayListCopy(hcrData_.symbol);
			final boolean[] ar = hcrData_.drawJPanel.getSymbolSelectedIndexes();
			System.arraycopy(ar, 0,
					symbolSelectedIndexes = new boolean[ar.length], 0,
					ar.length);
			symbolSelected = hcrData_.drawJPanel.isSymbolSelected();
			index = index_;
		}

		@Override
		public boolean canRedo() {
			return true;
		}

		@Override
		public boolean canUndo() {
			return true;
		}

		@Override
		public void execute() {
			Symbol s = new Symbol();
			int firstIndex = Integer.MAX_VALUE;
			final int[] numSelected = new int[symbolSelectedIndexes.length];
			final boolean[][] strokeSelectedIndexes = new boolean[symbolSelectedIndexes.length][];
			for (int i = 0; i < symbolSelectedIndexes.length; ++i) {
				final Symbol saux = symbol.get(i);
				numSelected[i] = 0;
				strokeSelectedIndexes[i] = new boolean[saux.size()];
				if (symbolSelectedIndexes[i]) {
					for (int j = saux.size() - 1; j > -1; --j) {
						strokeSelectedIndexes[i][j] = true;
						s.add(new DStroke(saux.strokeAt(j)));
						firstIndex = Math.min(firstIndex, i);
						saux.remove(j);
						saux.classifierType = -2;
						final int[] array = numSelected;
						final int n = i;
						++array[n];
					}
				}
			}
			int oneSelected = 0;
			for (int k = 0; k < numSelected.length; ++k) {
				oneSelected += ((numSelected[k] > 0) ? 1 : 0);
			}
			if (!s.isEmpty()
					&& oneSelected == 1
					&& numSelected[firstIndex] == strokeSelectedIndexes[firstIndex].length) {
				for (int l = 0; l < strokeSelectedIndexes[firstIndex].length; ++l) {
					final Symbol sym = new Symbol();
					sym.add(s.strokeAt(l));
					symbol.add(firstIndex + l, sym);
				}
			} else if (!s.isEmpty()) {
				symbol.add(firstIndex, s);
			}
			final int len = symbol.size();
			i = len - 1;
			while (i > -1) {
				s = symbol.get(i);
				classify(s);
				if (s.isEmpty()) {
					symbol.remove(i);
				}
				--i;
			}
			drawJPanel
					.setStrokeMemory(symbol, backgroundImage[index % ngroups]);
			drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
			drawJPanel.setStrokeSelectedIndexes(null, false);
			drawJPanel.setSymbolSelectedIndexes(null, false);
		}

		@Override
		public String getPresentationName() {
			return presentationName;
		}

		@Override
		public void redo() throws CannotRedoException {
			symboljComboBox.setSelectedIndex(index);
			symbolData.set(index, new ArrayList<Symbol>(
					symbolArrayListCopy(strokeMemory)));
			symbol = symbolData.get(index);
			execute();
		}

		@Override
		public void undo() throws CannotUndoException {
			symboljComboBox.setSelectedIndex(index);
			symbolData.set(index, symbolArrayListCopy(strokeMemory));
			symbol = symbolData.get(index);
			drawJPanel.setStrokeMemory(symbol);
			drawJPanel.setSymbolSelectedIndexes(symbolSelectedIndexes,
					symbolSelected);
			drawJPanel
					.setStrokeMemory(symbol, backgroundImage[index % ngroups]);
			drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
			drawJPanel.drawStrokeMemorySelectedStrokes();
		}
	}

	private class GroupUngroupStrokeEdit extends Edit {
		/**
		 * 
		 */
		private static final long serialVersionUID = 7926222004350043659L;
		int i;
		private int index;
		// int j;
		String presentationName;
		private ArrayList<Symbol> strokeMemory;
		private boolean strokeSelected;
		private boolean[][] strokeSelectedIndexes;

		public GroupUngroupStrokeEdit(final HcrData hcrData_, final int index_) {
			super();
			presentationName = "Group/Ungroup Strokes";
			strokeMemory = symbolArrayListCopy(hcrData_.symbol);
			final boolean[][] ar = hcrData_.drawJPanel
					.getStrokeSelectedIndexes();
			strokeSelectedIndexes = new boolean[ar.length][];
			i = 0;
			while (i < strokeSelectedIndexes.length) {
				strokeSelectedIndexes[i] = new boolean[ar[i].length];
				System.arraycopy(ar[i], 0, strokeSelectedIndexes[i], 0,
						ar[i].length);
				++i;
			}
			strokeSelected = hcrData_.drawJPanel.isStrokeSelected();
			index = index_;
		}

		@Override
		public boolean canRedo() {
			return true;
		}

		@Override
		public boolean canUndo() {
			return true;
		}

		@Override
		public void execute() {
			Symbol s = new Symbol();
			int firstIndex = Integer.MAX_VALUE;
			final int[] numSelected = new int[strokeSelectedIndexes.length];
			for (int i = 0; i < strokeSelectedIndexes.length; ++i) {
				numSelected[i] = 0;
				final Symbol saux = symbol.get(i);
				for (int j = strokeSelectedIndexes[i].length - 1; j > -1; --j) {
					if (strokeSelectedIndexes[i][j]) {
						s.add(new DStroke(saux.strokeAt(j)));
						firstIndex = Math.min(firstIndex, i);
						saux.remove(j);
						saux.classifierType = -2;
						final int[] array = numSelected;
						final int n = i;
						++array[n];
					}
				}
			}
			int oneSelected = 0;
			for (int k = 0; k < numSelected.length; ++k) {
				oneSelected += ((numSelected[k] > 0) ? 1 : 0);
			}
			if (!s.isEmpty()
					&& oneSelected == 1
					&& numSelected[firstIndex] == strokeSelectedIndexes[firstIndex].length) {
				for (int l = 0; l < strokeSelectedIndexes[firstIndex].length; ++l) {
					final Symbol sym = new Symbol();
					sym.add(s.strokeAt(l));
					symbol.add(firstIndex + l, sym);
				}
			} else if (!s.isEmpty()) {
				symbol.add(firstIndex, s);
			}
			final int len = symbol.size();
			i = len - 1;
			while (i > -1) {
				s = symbol.get(i);
				classify(s);
				if (s.isEmpty()) {
					symbol.remove(i);
				}
				--i;
			}
			drawJPanel
					.setStrokeMemory(symbol, backgroundImage[index % ngroups]);
			drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
			drawJPanel.setStrokeSelectedIndexes(null, false);
			drawJPanel.setSymbolSelectedIndexes(null, false);
		}

		@Override
		public String getPresentationName() {
			return presentationName;
		}

		@Override
		public void redo() throws CannotRedoException {
			symboljComboBox.setSelectedIndex(index);
			symbolData.set(index, new ArrayList<Symbol>(
					symbolArrayListCopy(strokeMemory)));
			symbol = symbolData.get(index);
			execute();
		}

		@Override
		public void undo() throws CannotUndoException {
			symboljComboBox.setSelectedIndex(index);
			symbolData.set(index, symbolArrayListCopy(strokeMemory));
			symbol = symbolData.get(index);
			drawJPanel.setStrokeMemory(symbol);
			drawJPanel.setStrokeSelectedIndexes(strokeSelectedIndexes,
					strokeSelected);
			drawJPanel
					.setStrokeMemory(symbol, backgroundImage[index % ngroups]);
			drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
			drawJPanel.drawStrokeMemorySelectedStrokes();
		}
	}

	private class CutPasteSymbolEdit extends Edit {
		/**
		 * 
		 */
		private static final long serialVersionUID = 2929234088066089400L;
		private ArrayList<Symbol> copyPasteMemory;
		int i;
		private int index;
		private ArrayList<Symbol> strokeMemory;

		public CutPasteSymbolEdit(final HcrData hcrData_, final int index_) {
			super();
			strokeMemory = symbolArrayListCopy(hcrData_.symbol);
			copyPasteMemory = HcrData.this
					.symbolArrayListCopy(hcrData_.copyPasteMemory);
			index = index_;
		}

		@Override
		public boolean canRedo() {
			return true;
		}

		@Override
		public boolean canUndo() {
			return true;
		}

		@Override
		public void execute() {
			final int len = symbol.size();
			final boolean[] indexes = new boolean[len + copyPasteMemory.size()];
			i = 0;
			while (i < copyPasteMemory.size()) {
				final Symbol s = new Symbol(copyPasteMemory.get(i));
				final int dx = (s.maxX + 10.0 < drawJPanel.getWidth()) ? 10
						: -10;
				final int dy = (s.maxY + 10.0 < drawJPanel.getHeight()) ? 10
						: -10;
				s.translate(dx, dy);
				classify(s);
				symbol.add(s);
				indexes[len + i] = true;
				++i;
			}
			drawJPanel.setSymbolSelectedIndexes(indexes, true);
			drawJPanel.setStrokeMemory(symbol);
			drawJPanel.drawStrokeMemorySelectedSymbols();
		}

		@Override
		public String getPresentationName() {
			return "Paste";
		}

		@Override
		public void redo() throws CannotRedoException {
			symboljComboBox.setSelectedIndex(index);
			final ArrayList<Symbol> v = symbolArrayListCopy(strokeMemory);
			symbolData.set(index, v);
			symbol = symbolData.get(index);
			copyPasteMemory.clear();
			i = 0;
			while (i < copyPasteMemory.size()) {
				copyPasteMemory.add(new Symbol(copyPasteMemory.get(i)));
				++i;
			}
			execute();
		}

		@Override
		public void undo() throws CannotUndoException {
			symboljComboBox.setSelectedIndex(index);
			final ArrayList<Symbol> v = symbolArrayListCopy(strokeMemory);
			symbolData.set(index, v);
			symbol = symbolData.get(index);
			drawJPanel.setSymbolSelectedIndexes(null, false);
			drawJPanel.setStrokeMemory(symbol);
		}
	}

	private class PasteStrokeEdit extends Edit {
		/**
		 * 
		 */
		private static final long serialVersionUID = -536975300350733804L;
		private ArrayList<Symbol> copyPasteMemory;
		int i;
		private int index;
		// int j;
		private ArrayList<Symbol> strokeMemory;
		private boolean strokeSelected;
		private boolean[][] strokeSelectedIndexes;

		public PasteStrokeEdit(final HcrData hcrData_, final int index_) {
			super();
			strokeMemory = symbolArrayListCopy(hcrData_.symbol);
			copyPasteMemory = HcrData.this
					.symbolArrayListCopy(hcrData_.copyPasteMemory);
			strokeSelected = hcrData_.drawJPanel.isStrokeSelected();
			final boolean[][] ar = hcrData_.drawJPanel
					.getStrokeSelectedIndexes();
			strokeSelectedIndexes = new boolean[ar.length][];
			i = 0;
			while (i < strokeSelectedIndexes.length) {
				strokeSelectedIndexes[i] = new boolean[ar[i].length];
				System.arraycopy(ar[i], 0, strokeSelectedIndexes[i], 0,
						ar[i].length);
				++i;
			}
			index = index_;
		}

		@Override
		public boolean canRedo() {
			return true;
		}

		@Override
		public boolean canUndo() {
			return true;
		}

		@Override
		public void execute() {
			final int len = symbol.size();
			final boolean[] indexes = new boolean[len + copyPasteMemory.size()];
			i = 0;
			while (i < copyPasteMemory.size()) {
				final Symbol s = new Symbol(copyPasteMemory.get(i));
				final int dx = (s.maxX + 10.0 < drawJPanel.getWidth()) ? 10
						: -10;
				final int dy = (s.maxY + 10.0 < drawJPanel.getHeight()) ? 10
						: -10;
				s.translate(dx, dy);
				classify(s);
				symbol.add(s);
				indexes[len + i] = true;
				++i;
			}
			drawJPanel.setSymbolSelectedIndexes(indexes, true);
			drawJPanel
					.setStrokeMemory(symbol, backgroundImage[index % ngroups]);
			drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
			drawJPanel.drawStrokeMemorySelectedSymbols();
		}

		@Override
		public String getPresentationName() {
			return "Paste";
		}

		@Override
		public void redo() throws CannotRedoException {
			symboljComboBox.setSelectedIndex(index);
			final ArrayList<Symbol> v = symbolArrayListCopy(strokeMemory);
			symbolData.set(index, v);
			symbol = symbolData.get(index);
			copyPasteMemory.clear();
			i = 0;
			while (i < copyPasteMemory.size()) {
				copyPasteMemory.add(new Symbol(copyPasteMemory.get(i)));
				++i;
			}
			execute();
		}

		@Override
		public void undo() throws CannotUndoException {
			symboljComboBox.setSelectedIndex(index);
			final ArrayList<Symbol> v = symbolArrayListCopy(strokeMemory);
			symbolData.set(index, v);
			symbol = symbolData.get(index);
			drawJPanel.setStrokeSelectedIndexes(strokeSelectedIndexes,
					strokeSelected);
			drawJPanel.setStrokeMemory(symbol);
			drawJPanel.drawStrokeMemorySelectedStrokes();
		}
	}

	private class PasteSymbolEdit extends Edit {
		/**
		 * 
		 */
		private static final long serialVersionUID = 7697013085266324335L;
		private ArrayList<Symbol> copyPasteMemory;
		int i;
		private int index;
		private ArrayList<Symbol> strokeMemory;
		// private boolean strokeSelected;
		// private boolean[][] strokeSelectedIndexes;
		private boolean symbolSelected;
		private boolean[] symbolSelectedIndexes;

		public PasteSymbolEdit(final HcrData hcrData_, final int index_) {
			super();
			strokeMemory = symbolArrayListCopy(hcrData_.symbol);
			copyPasteMemory = HcrData.this
					.symbolArrayListCopy(hcrData_.copyPasteMemory);
			symbolSelectedIndexes = new boolean[hcrData_.drawJPanel
					.getSymbolSelectedIndexes().length];
			symbolSelected = hcrData_.drawJPanel.isSymbolSelected();
			if (symbolSelected) {
				System.arraycopy(
						hcrData_.drawJPanel.getSymbolSelectedIndexes(), 0,
						symbolSelectedIndexes, 0,
						hcrData_.drawJPanel.getSymbolSelectedIndexes().length);
			}
			index = index_;
		}

		@Override
		public boolean canRedo() {
			return true;
		}

		@Override
		public boolean canUndo() {
			return true;
		}

		@Override
		public void execute() {
			final int len = symbol.size();
			final boolean[] indexes = new boolean[len + copyPasteMemory.size()];
			i = 0;
			while (i < copyPasteMemory.size()) {
				final Symbol s = new Symbol(copyPasteMemory.get(i));
				final int dx = (s.maxX + 10.0 < drawJPanel.getWidth()) ? 10
						: -10;
				final int dy = (s.maxY + 10.0 < drawJPanel.getHeight()) ? 10
						: -10;
				s.translate(dx, dy);
				classify(s);
				symbol.add(s);
				indexes[len + i] = true;
				++i;
			}
			drawJPanel.setSymbolSelectedIndexes(indexes, true);
			drawJPanel.setStrokeMemory(symbol);
			drawJPanel.drawStrokeMemorySelectedSymbols();
		}

		@Override
		public String getPresentationName() {
			return "Paste";
		}

		@Override
		public void redo() throws CannotRedoException {
			symboljComboBox.setSelectedIndex(index);
			final ArrayList<Symbol> v = symbolArrayListCopy(strokeMemory);
			symbolData.set(index, v);
			symbol = symbolData.get(index);
			copyPasteMemory.clear();
			i = 0;
			while (i < copyPasteMemory.size()) {
				copyPasteMemory.add(new Symbol(copyPasteMemory.get(i)));
				++i;
			}
			execute();
		}

		@Override
		public void undo() throws CannotUndoException {
			symboljComboBox.setSelectedIndex(index);
			final ArrayList<Symbol> v = symbolArrayListCopy(strokeMemory);
			symbolData.set(index, v);
			symbol = symbolData.get(index);
			drawJPanel.setSymbolSelectedIndexes(symbolSelectedIndexes,
					symbolSelected);
			drawJPanel.setStrokeMemory(symbol);
			drawJPanel.drawStrokeMemorySelectedSymbols();
		}
	}

	private class CutSymbolEdit extends Edit {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5314105942740403770L;
		// int i;
		private int index;
		// int j;
		private String presentationName;
		private ArrayList<Symbol> strokeMemory;
		private boolean symbolSelected;
		private boolean[] symbolSelectedIndexes;

		public CutSymbolEdit(final HcrData hcrData_, final int index_) {
			this(hcrData_, index_, "Cut Symbol");
		}

		public CutSymbolEdit(final HcrData hcrData_, final int index_,
				final String presentationName_) {
			super();
			strokeMemory = symbolArrayListCopy(hcrData_.symbol);
			symbolSelectedIndexes = new boolean[hcrData_.symbol.size()];
			symbolSelected = hcrData_.drawJPanel.isSymbolSelected();
			System.arraycopy(hcrData_.drawJPanel.getSymbolSelectedIndexes(), 0,
					symbolSelectedIndexes, 0, hcrData_.symbol.size());
			index = index_;
			presentationName = presentationName_;
		}

		@Override
		public boolean canRedo() {
			return true;
		}

		@Override
		public boolean canUndo() {
			return true;
		}

		@Override
		public void execute() {
			copyPasteMemory.clear();
			for (int i = symbolSelectedIndexes.length - 1; i > -1; --i) {
				if (symbolSelectedIndexes[i]) {
					copyPasteMemory.add(new Symbol(symbol.get(i)));
					symbol.remove(i);
				}
			}
			drawJPanel
					.setStrokeMemory(symbol, backgroundImage[index % ngroups]);
			drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
			drawJPanel.setStrokeSelectedIndexes(null, false);
			drawJPanel.setSymbolSelectedIndexes(null, false);
		}

		@Override
		public String getPresentationName() {
			return presentationName;
		}

		@Override
		public void redo() throws CannotRedoException {
			symboljComboBox.setSelectedIndex(index);
			final ArrayList<Symbol> v = symbolArrayListCopy(strokeMemory);
			symbolData.set(index, v);
			symbol = symbolData.get(index);
			drawJPanel.setSymbolSelectedIndexes(symbolSelectedIndexes,
					symbolSelected);
			execute();
		}

		@Override
		public void undo() throws CannotUndoException {
			symboljComboBox.setSelectedIndex(index);
			final ArrayList<Symbol> v = symbolArrayListCopy(strokeMemory);
			symbolData.set(index, v);
			symbol = symbolData.get(index);
			drawJPanel.setSymbolSelectedIndexes(symbolSelectedIndexes,
					symbolSelected);
			drawJPanel.setStrokeMemory(symbol);
			drawJPanel.drawStrokeMemorySelectedSymbols();
			drawJPanel.drawStrokeMemorySelectedSymbols();
		}
	}

	private class CutStrokeEdit extends Edit {
		/**
		 * 
		 */
		private static final long serialVersionUID = 671154052431357221L;
		int i;
		private int index;
		int j;
		private ArrayList<Symbol> strokeMemory;
		private boolean strokeSelected;
		private boolean[][] strokeSelectedIndexes;

		public CutStrokeEdit(final HcrData hcrData_, final int index_) {
			super();
			strokeMemory = symbolArrayListCopy(hcrData_.symbol);
			final boolean[][] ar = hcrData_.drawJPanel
					.getStrokeSelectedIndexes();
			strokeSelectedIndexes = new boolean[ar.length][];
			i = 0;
			while (i < strokeSelectedIndexes.length) {
				strokeSelectedIndexes[i] = new boolean[ar[i].length];
				System.arraycopy(ar[i], 0, strokeSelectedIndexes[i], 0,
						ar[i].length);
				++i;
			}
			strokeSelected = hcrData_.drawJPanel.isStrokeSelected();
			index = index_;
		}

		@Override
		public boolean canRedo() {
			return true;
		}

		@Override
		public boolean canUndo() {
			return true;
		}

		@Override
		public void execute() {
			final Symbol snew = new Symbol();
			copyPasteMemory.clear();
			i = strokeSelectedIndexes.length - 1;
			while (i > -1) {
				final Symbol s = symbol.get(i);
				snew.clear();
				j = strokeSelectedIndexes[i].length - 1;
				while (j > -1) {
					if (strokeSelectedIndexes[i][j]) {
						snew.add(new DStroke(s.strokeAt(j)));
						snew.classifierType = -2;
						s.remove(j);
					}
					--j;
				}
				if (!snew.isEmpty()) {
					copyPasteMemory.add(new Symbol(snew));
				}
				--i;
			}
			i = strokeSelectedIndexes.length - 1;
			while (i > -1) {
				final Symbol s = symbol.get(i);
				classify(s);
				if (s.isEmpty()) {
					symbol.remove(i);
				}
				--i;
			}
			drawJPanel
					.setStrokeMemory(symbol, backgroundImage[index % ngroups]);
			drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
			drawJPanel.setStrokeSelectedIndexes(null, false);
			drawJPanel.setSymbolSelectedIndexes(null, false);
		}

		@Override
		public String getPresentationName() {
			return "Cut Stroke";
		}

		@Override
		public void redo() throws CannotRedoException {
			symboljComboBox.setSelectedIndex(index);
			final ArrayList<Symbol> v = symbolArrayListCopy(strokeMemory);
			symbolData.set(index, v);
			symbol = symbolData.get(index);
			drawJPanel.setStrokeSelectedIndexes(strokeSelectedIndexes,
					strokeSelected);
			execute();
		}

		@Override
		public void undo() throws CannotUndoException {
			symboljComboBox.setSelectedIndex(index);
			final ArrayList<Symbol> v = symbolArrayListCopy(strokeMemory);
			symbolData.set(index, v);
			symbol = symbolData.get(index);
			drawJPanel.setStrokeMemory(symbol);
			drawJPanel.setStrokeSelectedIndexes(strokeSelectedIndexes,
					strokeSelected);
			drawJPanel
					.setStrokeMemory(symbol, backgroundImage[index % ngroups]);
			drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
			drawJPanel.drawStrokeMemorySelectedStrokes();
		}
	}

	private class MoveStrokeEdit extends AbstractUndoableEdit {
		/**
		 * 
		 */
		private static final long serialVersionUID = 3694745259109385011L;
		private int deltaX;
		private int deltaY;
		int i;
		private int index;
		// int j;
		private ArrayList<Symbol> strokeMemory;
		private boolean[][] strokeSelectedIndexes;

		public MoveStrokeEdit(final HcrData hcrData_, final int index_) {
			super();
			strokeMemory = symbolArrayListCopy(hcrData_.symbol);
			final boolean[][] ar = hcrData_.drawJPanel
					.getStrokeSelectedIndexes();
			strokeSelectedIndexes = new boolean[ar.length][];
			i = 0;
			while (i < strokeSelectedIndexes.length) {
				strokeSelectedIndexes[i] = new boolean[ar[i].length];
				System.arraycopy(ar[i], 0, strokeSelectedIndexes[i], 0,
						ar[i].length);
				++i;
			}
			deltaX = hcrData_.drawJPanel.getDeltaX();
			deltaY = hcrData_.drawJPanel.getDeltaY();
			index = index_;
		}

		@Override
		public boolean canRedo() {
			return true;
		}

		@Override
		public boolean canUndo() {
			return true;
		}

		@Override
		public String getPresentationName() {
			return "Move Stroke";
		}

		@Override
		public void redo() throws CannotRedoException {
			symboljComboBox.setSelectedIndex(index);
			final ArrayList<Symbol> v = symbolArrayListCopy(strokeMemory);

			symbolData.set(index, v);
			symbol = symbolData.get(index);
			drawJPanel.setStrokeSelectedIndexes(strokeSelectedIndexes, true);
			drawJPanel
					.setStrokeMemory(symbol, backgroundImage[index % ngroups]);
			drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
			drawJPanel.drawStrokeMemorySelectedStrokes();
		}

		@Override
		public void undo() throws CannotUndoException {
			symboljComboBox.setSelectedIndex(index);
			final ArrayList<Symbol> v = symbolArrayListCopy(strokeMemory);
			symbolData.set(index, v);
			symbol = symbolData.get(index);
			for (int i = 0; i < strokeSelectedIndexes.length; ++i) {
				final Symbol s = symbol.get(i);
				for (int j = 0; j < strokeSelectedIndexes[i].length; ++j) {
					if (strokeSelectedIndexes[i][j]) {
						s.strokeAt(j).translate(-deltaX, -deltaY);
					}
				}
				s.actualizeMaxMin();
			}
			drawJPanel.setStrokeSelectedIndexes(strokeSelectedIndexes, true);
			drawJPanel
					.setStrokeMemory(symbol, backgroundImage[index % ngroups]);
			drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
			drawJPanel.drawStrokeMemorySelectedStrokes();
		}
	}

	private class MoveSymbolEdit extends AbstractUndoableEdit {
		/**
		 * 
		 */
		private static final long serialVersionUID = 8990642849280576968L;
		private int deltaX;
		private int deltaY;
		private int index;
		private ArrayList<Symbol> strokeMemory;
		private boolean[] symbolSelectedIndexes;

		public MoveSymbolEdit(final HcrData hcrData_, final int index_) {
			super();
			strokeMemory = symbolArrayListCopy(hcrData_.symbol);
			symbolSelectedIndexes = new boolean[hcrData_.symbol.size()];
			System.arraycopy(hcrData_.drawJPanel.getSymbolSelectedIndexes(), 0,
					symbolSelectedIndexes, 0, symbolSelectedIndexes.length);
			deltaX = hcrData_.drawJPanel.getDeltaX();
			deltaY = hcrData_.drawJPanel.getDeltaY();
			index = index_;
		}

		@Override
		public boolean canRedo() {
			return true;
		}

		@Override
		public boolean canUndo() {
			return true;
		}

		@Override
		public String getPresentationName() {
			return "Move Symbol";
		}

		@Override
		public void redo() throws CannotRedoException {
			symboljComboBox.setSelectedIndex(index);
			final ArrayList<Symbol> v = symbolArrayListCopy(strokeMemory);
			symbolData.set(index, v);
			symbol = symbolData.get(index);
			drawJPanel.setSymbolSelectedIndexes(symbolSelectedIndexes, true);
			drawJPanel
					.setStrokeMemory(symbol, backgroundImage[index % ngroups]);
			drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
			drawJPanel.drawStrokeMemorySelectedSymbols();
		}

		@Override
		public void undo() throws CannotUndoException {
			symboljComboBox.setSelectedIndex(index);
			final ArrayList<Symbol> v = symbolArrayListCopy(strokeMemory);

			symbolData.set(index, v);
			symbol = symbolData.get(index);
			for (int i = 0; i < symbolSelectedIndexes.length; ++i) {
				if (symbolSelectedIndexes[i]) {
					symbol.get(i).translate(-deltaX, -deltaY);
				}
			}
			drawJPanel.setSymbolSelectedIndexes(symbolSelectedIndexes, true);
			drawJPanel
					.setStrokeMemory(symbol, backgroundImage[index % ngroups]);
			drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
			drawJPanel.drawStrokeMemorySelectedSymbols();
		}
	}

	private abstract class Edit extends AbstractUndoableEdit {
		/**
		 * 
		 */
		private static final long serialVersionUID = -3002378183741680092L;

		public abstract void execute();
	}

	private class AddEdit extends Edit {
		/**
		 * 
		 */
		private static final long serialVersionUID = -3308232841922144277L;
		private int index;
		private DStroke inputStroke;
		private ArrayList<Symbol> strokeMemory;

		public AddEdit(final HcrData hcrData_, final int index_) {
			super();
			strokeMemory = symbolArrayListCopy(hcrData_.symbol);
			inputStroke = new DStroke(hcrData_.drawJPanel.getInputStroke());
			index = index_;
		}

		@Override
		public boolean canRedo() {
			return true;
		}

		@Override
		public boolean canUndo() {
			return true;
		}

		@Override
		public void execute() {
			addToStrokeMemory();
			drawJPanel
					.setStrokeMemory(symbol, backgroundImage[index % ngroups]);
			drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		}

		@Override
		public String getPresentationName() {
			return "Add Stroke";
		}

		@Override
		public void redo() throws CannotRedoException {
			symboljComboBox.setSelectedIndex(index);
			final ArrayList<Symbol> v = symbolArrayListCopy(strokeMemory);
			symbolData.set(index, v);
			symbol = symbolData.get(index);
			drawJPanel.setInputStroke(new DStroke(inputStroke));
			execute();
		}

		@Override
		public void undo() throws CannotUndoException {
			symboljComboBox.setSelectedIndex(index);
			final ArrayList<Symbol> v = symbolArrayListCopy(strokeMemory);
			symbolData.set(index, v);
			symbol = symbolData.get(index);
			drawJPanel
					.setStrokeMemory(symbol, backgroundImage[index % ngroups]);
			drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);
		}
	}

	private class UndoAdapter implements UndoableEditListener {
		@Override
		public void undoableEditHappened(final UndoableEditEvent evt) {
			final UndoableEdit edit = evt.getEdit();
			undoManager_.addEdit(edit);
			refreshUndoRedo();
		}
	}

	class ClassifySymbolThread extends Thread {
		Symbol s;

		public ClassifySymbolThread(final Symbol s) {
			super();
			this.s = s;
		}

		@Override
		public void run() {
			if (s.classifierType < -1) {
				s.classifierType = classifierType;
			}
			if (s.getWidth() <= 4.0 && s.getHeight() <= 4.0) {
				s.name = "dot";
			} else {
				try {
					s.name = svmModel[s.classifierType][s.size() - 1]
							.classify(s.getAsSparseVectorSingle(np));
				} catch (NullPointerException npe) {
					try {
						s.name = svmModel[s.classifierType][maxNumStrokes[s.classifierType] - 1]
								.classify(s.getAsSparseVectorSingle(np));
					} catch (ArrayIndexOutOfBoundsException aioobe) {
					}
				}
			}
		}
	}

	class PlotParametric3DThread extends Thread {
		@Override
		public void run() {
			try {
				img = null;
				if (url == null) {
					if (plotParametric3DSelected) {
						img = HcrData.this.plotParametric3D2Image();
						plotParametric3DSelected = false;
					}
				} else if (plotParametric3DSelected) {
					img = plot3D2ImageRemote();
					plotParametric3DSelected = false;
				}
				actualizeExample();
			} catch (NullPointerException npe) {
				npe.printStackTrace();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	class Plot3DThread extends Thread {
		@Override
		public void run() {
			try {
				img = null;
				if (url == null) {
					if (plot3DSelected) {
						img = plot3D2Image();
						plot3DSelected = false;
					}
				} else if (plot3DSelected) {
					img = plot3D2ImageRemote();
					plot3DSelected = false;
				}
				actualizeExample();
			} catch (NullPointerException npe) {
				npe.printStackTrace();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	class PlotParametric2DThread extends Thread {
		@Override
		public void run() {
			try {
				img = null;
				if (url == null) {
					if (plotParametric2DSelected) {
						img = plotParametric2DImage();
						plotParametric2DSelected = false;
					}
				} else if (plotParametric2DSelected) {
					img = plot2DImageRemote();
					plotParametric2DSelected = false;
				}
				actualizeExample();
			} catch (NullPointerException npe) {
				npe.printStackTrace();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	class Plot2DThread extends Thread {
		@Override
		public void run() {
			try {
				img = null;
				if (url == null) {
					if (plotSelected) {
						img = plot2DImage();
						plotSelected = false;
					}
				} else if (plotSelected) {
					img = plot2DImageRemote();
					plotSelected = false;
				}
				actualizeExample();
			} catch (NullPointerException npe) {
				npe.printStackTrace();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	class CalculusThread extends Thread {
		@Override
		public void run() {
			try {
				img = null;
				if (url == null) {
					if (calculusSelected) {
						img = math2Image();
						calculusSelected = false;
					}
				} else if (calculusSelected) {
					img = math2ImageRemote();
					calculusSelected = false;
				}
				actualizeExample();
			} catch (NullPointerException npe) {
				npe.printStackTrace();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	class ConvertToLaTeXThread extends Thread {
		@Override
		public void run() {
			try {
				img = null;
				if (url == null) {
					if (texSelected) {
						img = latex2Image();
						texSelected = false;
					}
				} else if (texSelected) {
					img = latex2ImageRemote();
					texSelected = false;
				}
				actualizeExample();
			} catch (NullPointerException npe) {
				npe.printStackTrace();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	class TangentThread extends Thread {
		@Override
		public void run() {
			tangentAnimation();
		}
	}

	class DownloadModelThread extends Thread {
		@Override
		public void run() {
			readClassificationModel();
		}
	}
}
