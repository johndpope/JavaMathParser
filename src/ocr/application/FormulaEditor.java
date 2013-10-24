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

import java.io.*;
import java.util.*;

import java.awt.event.*;
import javax.swing.*;
import hfr.graph.*;

public class FormulaEditor extends HcrData {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3806286636299884526L;
	JFileChooser fc = new JFileChooser();

	public FormulaEditor() {
		super();
		// fc.setAcceptAllFileFilterUsed(true);
		fc.addChoosableFileFilter(new JMathNotesDataFilter());
		fc.setCurrentDirectory(new File(path + "examples"));
		saved = false;
	}

	@Override
	void exitjMenuItem_actionPerformed(ActionEvent e) {
		int val = 0;
		if (isChanged) {
			Object[] options = { "Save", "Exit", "Cancel" };
			val = this
					.showWindowYesNoCancel(
							"The file was modified. Do you want to save it before leave the program?",
							"Question", options);
			if (val == 0) {
				// this.saveasjMenuItem_actionPerformed(e);
				if (!isChanged) {
					this.setVisible(false);
					this.dispose();
					// this.removeTmpFiles();
					System.exit(0);
				}
			} else if (val == 1) {
				this.setVisible(false);
				this.dispose();
				// this.removeTmpFiles();
				System.exit(0);
			} else {
				return;
			}
		} else {
			Object[] options = { "Exit", "Cancel" };
			val = this.showWindowYesNo(
					"Do you wanto to leave the application?", "Question",
					options);
			if (val == 0) {
				this.setVisible(false);
				// this.dispose();
				// this.removeTmpFiles();
				System.exit(0);
			}
		}
	}

	@Override
	void openjMenuItem_actionPerformed(ActionEvent e) {
		// JFileChooser fc = new JFileChooser();
		int val = 0;
		if (isChanged) {
			val = this.showWindowYesNo(
					"This file was modified. Do you want to save it?",
					"Question");
			if (val == 0) {
				this.savejMenuItem_actionPerformed(e);
				if (isChanged) {
					return;
				}
			}
		}

		int returnVal = fc.showOpenDialog(this);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			// this is where a real application would open the file.
			this.read(file.getPath());
			saved = true;
			isChanged = false;
			filename = file.getPath();
			this.setTitle("JMathNotes - " + filename);
			this.drawJPanel.deselectStrokesAndSymbols();
			// System.out.println("Opening: " + file.getPath() + ".");
		} else {
			// System.out.println("Open command cancelled by user.");
		}

	}

	@Override
	void newjMenuItem_actionPerformed(ActionEvent e) {
		this.NewJButton_actionPerformed(e);
	}

	void savejButton_actionPerformed(ActionEvent e) {
		if (saved) {
			this.write(filename);
			this.isChanged = false;
			System.out.println("Saved.");
		} else {
			this.saveasjMenuItem_actionPerformed(e);
		}
	}

	@Override
	void savejMenuItem_actionPerformed(ActionEvent e) {
		if (saved) {
			this.write(filename);
			this.isChanged = false;
			System.out.println("Saved.");
		} else {
			this.saveasjMenuItem_actionPerformed(e);
		}
	}

	@Override
	void saveasjMenuItem_actionPerformed(ActionEvent e) {
		saveAs();
		/*
		 * int val = fc.showSaveDialog(this); if(val ==
		 * JFileChooser.APPROVE_OPTION) { File file = null; do { file =
		 * fc.getSelectedFile(); //this is where a real application would open
		 * the file. if(file.exists()) { val = this.showWindowYesNo("The file" +
		 * file.getPath() + " already exists.\n" +
		 * "Do you want to overwrite it?", "Question"); } else { break; } }
		 * while(val != 0); this.write(file.getPath()); filename =
		 * file.getPath(); this.setTitle("JMathNotes - " + filename); saved =
		 * true; isChanged = false; //System.out.println("Saving: " +
		 * file.getPath() + "."); } else { }
		 */
	}

	void saveAs() {
		int val = fc.showSaveDialog(this);
		if (val == JFileChooser.APPROVE_OPTION) {
			File file = null;
			do {
				file = fc.getSelectedFile();
				// this is where a real application would open the file.
				if (file.exists()) {
					val = this.showWindowYesNo("The file" + file.getPath()
							+ " already exists.\n"
							+ "Do you want to overwrite it?", "Question");
					if (val == 1) {
						val = fc.showSaveDialog(this);
					}
				} else {
					break;
				}
			} while (val != 0);
			filename = file.getPath();
			if (getExtension(file) == null) {
				filename = filename + ".jmn";
			}
			this.write(filename);
			this.setTitle("JMathNotes - " + filename);
			saved = true;
			isChanged = false;
			// System.out.println("Saving: " + file.getPath() + ".");
		}
	}

	@Override
	void NewJButton_actionPerformed(ActionEvent e) {
		if (this.isChanged) {
			Object[] options = { "Save", "Cancel" };
			int modified, save, overwrite;

			modified = this.showWindowYesNoCancel(
					"The file was modified. Do you want to save it?",
					"Question", options);
			if (modified == 0) {

				if (saved) {
					this.write(filename);
					isChanged = false;
					saved = false;
				} else {
					File file = null;
					do {
						save = fc.showSaveDialog(this);
						if (save == JFileChooser.APPROVE_OPTION) {
							file = fc.getSelectedFile();
							// this is where a real application would open the
							// file.
							if (file.exists()) {
								overwrite = this.showWindowYesNo("The file"
										+ file.getPath() + "already exists.\n"
										+ "Do you want to overwrite it?",
										"Question");
							} else {
								overwrite = 0;
							}
						} else {
							return;
						}
					} while (overwrite != 0);

					this.write(file.getPath());
					filename = "";
					this.setTitle("JMathNotes");
					saved = false;
					isChanged = false;
				}
			}
		}

		this.symbolData.clear();

		this.symbol.clear();

		this.symbolData.add(this.symbol);

		this.drawJPanel.setStrokeMemory(this.symbol);

		index = 0;
		this.drawJPanel.drawStrokeMemory(backgroundImage[index % ngroups]);

		actualizeSymboljComboBox(false);
	}

	@Override
	void this_windowClosing(WindowEvent e) {
		int val = 0;
		if (isChanged) {
			Object[] options = { "Save", "Exit", "Cancel" };
			val = this
					.showWindowYesNoCancel(
							"The file was modified. Do you want to save it before leave the program?",
							"Question", options);
			if (val == 0) {
				this.saveAs();
				if (!isChanged) {
					this.setVisible(false);
					this.dispose();
					// //this.removeTmpFiles();
					System.exit(0);
				}
			} else if (val == 1) {
				this.setVisible(false);
				this.dispose();
				// this.removeTmpFiles();
				System.exit(0);
			} else {
				return;
			}
		} else {
			Object[] options = { "Exit", "Cancel" };
			val = this.showWindowYesNo(
					"Do you wanto to leave the application?", "Question",
					options);
			if (val == 0) {
				this.setVisible(false);
				// this.dispose();
				// this.removeTmpFiles();
				System.exit(0);
			}
		}
	}

	public static void main(String argv[]) throws Exception {
		FormulaEditor formulaEditor = new FormulaEditor();
		try {
			if (argv.length > 0) {
				File file = new File(argv[0]);
				// this is where a real application would open the file.
				formulaEditor.read(file.getPath());
				formulaEditor.saved = true;
				formulaEditor.isChanged = false;
				formulaEditor.filename = file.getPath();
				formulaEditor
						.setTitle("JMathNotes - " + formulaEditor.filename);
				formulaEditor.drawJPanel.deselectStrokesAndSymbols();
				formulaEditor.drawJPanel.repaint();
			}
			formulaEditor.doublesidedjCheckBoxMenuItem
					.setSelected(MSTPrim.checkHorizontalBar);
		} catch (Exception ex) {
			String filenameout = formulaEditor.path + "JMathNotes"
					+ Long.toString((new Date()).getTime()) + ".log";
			formulaEditor
					.showWindowMessage(
							"<html>"
									+ "<b>An unexpected Exception has occured</b>.<br>"
									+ "A log-file was generated and will be saved in "
									+ filenameout
									+ "<br>"
									+ "If possible, end the current sesion and save your data.<p>"
									+ "</html>", "Unexpected Exception");
			// new DataOutputStream(
			// new FileOutputStream(filenameout));
		}
	}

	public static String getExtension(File f) {
		String ext = null;
		String s = f.getName();
		int i = s.lastIndexOf('.');

		if (i > 0 && i < s.length() - 1) {
			ext = s.substring(i + 1).toLowerCase();
		}
		return ext;
	}

	class JMathNotesDataFilter extends javax.swing.filechooser.FileFilter {
		// Accept all directories and all gif, jpg, tiff, or png files.
		@Override
		public boolean accept(File f) {
			if (f.isDirectory()) {
				return true;
			}

			String extension = getExtension(f);
			if (extension != null) {
				if (extension.equals("col") || extension.equals("jmn")
						|| extension.equals("hwr")) {
					return true;
				} else {
					return false;
				}
			}

			return false;
		}

		// The description of this filter
		@Override
		public String getDescription() {
			return "JMathNotes Files (*.jmn, *.hwr, *.col)";
		}
	}

	class ImageFilter extends javax.swing.filechooser.FileFilter {
		// Accept all directories and all gif, jpg, tiff, or png files.
		@Override
		public boolean accept(File f) {
			if (f.isDirectory()) {
				return true;
			}

			String extension = getExtension(f);
			if (extension != null) {
				if (extension.equals("gif") || extension.equals("jpg")
						|| extension.equals("tiff") || extension.equals("png")) {
					return true;
				} else {
					return false;
				}
			}

			return false;
		}

		// The description of this filter
		@Override
		public String getDescription() {
			return "Images (*.gif, *.jpg, *.tiff, *.png)";
		}
	}

}
