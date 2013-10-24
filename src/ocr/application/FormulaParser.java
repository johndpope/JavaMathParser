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

import hfr.BaselineStructureTree;
import hfr.SymbolList;
import hfr.SymbolNode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

import ocr.Symbol;
import svm.SparseVector;
import svm.SvmModel;

public class FormulaParser {
	// private boolean orderStrokesProcessing = true;
	// private boolean filteringProcessing = true;
	// private double normalizeDirectionProcessing = 0.3;
	// private double tangentTransformationProcessing = 0.15;
	// private double sigmaSmoothingPreprocessing = 5.0;
	// private int windowSmoothingProcessing = 12;
	// private double radiusEquidistantSamplingProcessing = 2.0f;
	// private int pointsPolygonalApproximationProcessing = 32;
	// private String processingSequenceProcessing = "1 1 10";
	//
	// private String symboldata[] = { "data/kbuchstaben0.col",
	// "data/math0.col",
	// "data/ggreek0.col", "data/kgreek0.col", "data/zahlen0.col" };

	private String classifierTypeName[] = { "Basic symbol", "Small letter",
			"Capital letter", "Greek letter", "Punctuation mark" };

	private int maxNumStrokes[];
	private int numClassifiers = classifierTypeName.length;
	private int classifierType = 0;
	private int np = 16;

	private SvmModel[][] svmModel;

	private String modelname = "formula_";

	public FormulaParser() {
		readClassificationModel();
	}

	public void readClassificationModel() {
		maxNumStrokes = new int[numClassifiers];
		svmModel = new SvmModel[numClassifiers][];
		for (int i = 0; i < numClassifiers; ++i) {
			svmModel[i] = new SvmModel[4];
			maxNumStrokes[i] = 0;
			for (int j = 0; j < 4; ++j) {
				try {
					svmModel[i][j] = new SvmModel();
					System.err.println("Loading SvmModel: " + i + ""
							+ modelname + "" + j + ".svm");
					svmModel[i][j].read("/models/" + i + "" + modelname + ""
							+ j + ".svm");
					maxNumStrokes[i] = j + 1;
				} catch (FileNotFoundException fnfe) {
					svmModel[i][j] = null;
					break;
				} catch (IOException ioe) {
				}
			}
		}
	}

	public void classify(final Symbol s, final int type) {
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
		} else {
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
		}
		if (s.getWidth() <= 16.0 && s.getHeight() <= 16.0
				&& !s.name.equals("dot") && s.name.equals("\\end")) {
			s.name = "comma";
		}
	}

	public void classify(final Symbol s) {
		SparseVector v = null;
		if (s.isEmpty()) {
			s.name = "empty_symbol";
			s.classifierType = -1;
			return;
		}
		if (s.classifierType >= -1) {
			return;
		}
		if (s.classifierType < -1) {
			s.classifierType = classifierType;
		}
		if (s.getWidth() <= 4.0 && s.getHeight() <= 4.0) {
			s.name = "dot";
		} else {
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
		}

		if (s.getWidth() <= 16.0 && s.getHeight() <= 16.0
				&& !s.name.equals("dot") && s.name.equals("\\end")) {
			s.name = "comma";
		}
	}

	/*
	 * public void addToStrokeMemory(DStroke ds) { Symbol s;
	 * 
	 * if (this.strokeMemory.isEmpty()) { s = new Symbol(); s.add(ds); //
	 * s.classify(); this.strokeMemory.add(s); return; }
	 * 
	 * int i = this.strokeMemory.size() - 1;
	 * 
	 * s = ((Symbol) this.strokeMemory.get(i));
	 * 
	 * if (s.distance(ds, eps)) { s.add(ds); // s.classify(); } else { s = new
	 * Symbol(); s.add(ds); // s.classify(); this.strokeMemory.add(s); } // } }
	 */

	public BaselineStructureTree constructFormula(final ArrayList<Symbol> sym) {
		if (sym.isEmpty()) {
			return null;
		}

		final SymbolList sl = new SymbolList();
		for (int i = 0; i < sym.size(); i++) {
			final Symbol s = sym.get(i);
			sl.add(new SymbolNode((int) s.getMinX(), (int) s.getMinY(), (int) s
					.getMaxX(), (int) s.getMaxY(), s.name));
		}
		sl.sort();
		final BaselineStructureTree bst = new BaselineStructureTree(sl);
		bst.buildTree();
		return bst;
	}

	public String parse(String fname) {
		System.err.println("Parsing " + fname);
		ArrayList<ArrayList<Symbol>> symbolData = new ArrayList<ArrayList<Symbol>>();

		BufferedReader filein = null;
		StringTokenizer st;
		String line;
		ArrayList<Symbol> group;
		ArrayList<Symbol> symbol;
		int nsim, i, count;

		try {
			filein = new BufferedReader(new FileReader(fname));

			while ((line = filein.readLine()) != null) {
				st = new StringTokenizer(line, " \n\t\r\f");
				count = st.countTokens();

				line = "";

				for (i = 0; i < count - 1; i++) {
					line += st.nextToken() + " ";
				}

				nsim = Integer.parseInt(st.nextToken());
				group = new ArrayList<Symbol>();
				for (i = 0; i < nsim; i++) {
					group.add(Symbol.readSymbol(filein));
				}
				symbolData.add(group);
			}

			if (!symbolData.isEmpty()) {
				symbol = symbolData.get(0);
				BaselineStructureTree bst = constructFormula(symbol);
				if (bst != null) {
					System.out.println("Latex");
					System.out.println(bst.interpretLaTeX());
					System.out.println("Mathematica");
					System.out.println(bst.interpretMathematica());
				}
			}
		} catch (FileNotFoundException fnfe) {
			System.err.println("File " + fname + " not found!");
			System.exit(1);
		} catch (IOException ioe) {
			System.err.println("IO Error " + ioe);
			System.exit(1);
		}

		return null;
	}

	public static void main(String args[]) {
		if (args.length > 0) {
			FormulaParser p = new FormulaParser();
			for (String filename : args) {
				p.parse(filename);
			}

		} else {
			System.err.println("Please call with a parameter");
			System.exit(1);
		}
	}

}
