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

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
//import com.borland.jbcl.layout.*;
import java.awt.event.*;

/**
 * <p>
 * \uFFFDberschrift:
 * </p>
 * <p>
 * Beschreibung:
 * </p>
 * <p>
 * Copyright: Copyright (c)
 * </p>
 * <p>
 * Organisation:
 * </p>
 * 
 * @author unascribed
 * @version 1.0
 */

public class ProcessPropertiesJDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6704312059603348541L;

	HcrData ownner;

	GridBagLayout gridBagLayout1 = new GridBagLayout();
	JPanel jPanel1 = new JPanel();
	TitledBorder titledBorder1;
	JPanel tangentjPanel = new JPanel();
	TitledBorder titledBorder2;
	TitledBorder titledBorder3;
	GridBagLayout gridBagLayout2 = new GridBagLayout();
	GridBagLayout gridBagLayout3 = new GridBagLayout();
	JCheckBox filteringjCheckBox = new JCheckBox();
	JCheckBox normalizejCheckBox = new JCheckBox();
	JPanel orderjPanel = new JPanel();
	JPanel smoothingjPanel = new JPanel();
	JPanel jPanel5 = new JPanel();
	JPanel equidistantjPanel = new JPanel();
	JPanel jPanel7 = new JPanel();
	TitledBorder titledBorder4;
	GridBagLayout gridBagLayout4 = new GridBagLayout();
	JCheckBox orderjCheckBox = new JCheckBox();
	TitledBorder titledBorder5;
	JCheckBox smoothingjCheckBox = new JCheckBox();
	TitledBorder titledBorder6;
	GridBagLayout gridBagLayout5 = new GridBagLayout();
	GridBagLayout gridBagLayout6 = new GridBagLayout();
	JCheckBox tangentjCheckBox = new JCheckBox();
	TitledBorder titledBorder7;
	JCheckBox equidistantjCheckBox = new JCheckBox();
	TitledBorder titledBorder8;
	JCheckBox polygonaljCheckBox = new JCheckBox();
	GridBagLayout gridBagLayout7 = new GridBagLayout();
	GridBagLayout gridBagLayout8 = new GridBagLayout();
	JButton okjButton = new JButton();
	JButton canceljButton = new JButton();
	JLabel jLabel1 = new JLabel();
	JTextField radiusdirectionjTextField = new JTextField();
	JRadioButton simplejRadioButton = new JRadioButton();
	JRadioButton gaussianjRadioButton = new JRadioButton();
	JLabel sigmajLabel = new JLabel();
	JTextField sigmajTextField = new JTextField();
	JLabel jLabel3 = new JLabel();
	JTextField windowjTextField = new JTextField();
	JRadioButton relativetodistancejRadioButton = new JRadioButton();
	JRadioButton relativetowidthheihtjRadioButton = new JRadioButton();
	JLabel jLabel4 = new JLabel();
	JTextField radiusequidistantjTextField = new JTextField();
	JLabel jLabel5 = new JLabel();
	JTextField pointsequidistantjTextField = new JTextField();
	JLabel jLabel6 = new JLabel();
	JTextField alphajTextField = new JTextField();
	JLabel jLabel7 = new JLabel();
	JTextField pointspolygonaljTextField = new JTextField();
	JPanel jPanel2 = new JPanel();
	TitledBorder titledBorder9;
	GridBagLayout gridBagLayout10 = new GridBagLayout();
	JCheckBox processingjCheckBox = new JCheckBox();
	JLabel jLabel8 = new JLabel();
	JTextField sequencejTextField = new JTextField();
	JButton defaultsjButton = new JButton();
	JButton applyjButton = new JButton();

	public ProcessPropertiesJDialog(HcrData owner, String title) {
		super(owner, title, true);
		try {
			this.ownner = owner;
			jbInit();
			ButtonGroup smoothingButtonGroup;
			smoothingButtonGroup = new ButtonGroup();
			smoothingButtonGroup.add(this.simplejRadioButton);
			smoothingButtonGroup.add(this.gaussianjRadioButton);

			ButtonGroup equidistantSamplingButtonGroup;
			equidistantSamplingButtonGroup = new ButtonGroup();
			equidistantSamplingButtonGroup
					.add(this.relativetodistancejRadioButton);
			equidistantSamplingButtonGroup
					.add(this.relativetowidthheihtjRadioButton);

			this.pack();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ProcessPropertiesJDialog() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		titledBorder1 = new TitledBorder(BorderFactory.createLineBorder(
				new Color(153, 153, 153), 2), "FIltering");
		titledBorder2 = new TitledBorder("");
		titledBorder3 = new TitledBorder(BorderFactory.createLineBorder(
				new Color(153, 153, 153), 2), "Normalize Direction");
		titledBorder4 = new TitledBorder(BorderFactory.createLineBorder(
				new Color(153, 153, 153), 2), "Order Strokes");
		titledBorder5 = new TitledBorder(BorderFactory.createLineBorder(
				new Color(153, 153, 153), 2), "Smoothing");
		titledBorder6 = new TitledBorder(BorderFactory.createLineBorder(
				new Color(153, 153, 153), 2), "Tangent Transformation");
		titledBorder7 = new TitledBorder(BorderFactory.createLineBorder(
				new Color(153, 153, 153), 2), "Equidistant Sampling");
		titledBorder8 = new TitledBorder(BorderFactory.createLineBorder(
				new Color(153, 153, 153), 2), "Polygonal Approximation");
		titledBorder9 = new TitledBorder(BorderFactory.createLineBorder(
				new Color(153, 153, 153), 2), "Processing Sequence");
		this.getContentPane().setLayout(gridBagLayout1);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				this_windowClosing(e);
			}
		});
		jPanel1.setBorder(titledBorder1);
		jPanel1.setLayout(gridBagLayout2);
		tangentjPanel.setBorder(titledBorder3);
		tangentjPanel.setLayout(gridBagLayout3);
		filteringjCheckBox
				.setToolTipText("Activate for the userdeined Processing");
		filteringjCheckBox.setSelected(true);
		filteringjCheckBox.setText("Activate");
		normalizejCheckBox.setSelected(true);
		normalizejCheckBox.setText("Activate");
		orderjPanel.setBorder(titledBorder4);
		orderjPanel.setLayout(gridBagLayout4);
		orderjCheckBox.setSelected(true);
		orderjCheckBox.setText("Activate");
		smoothingjPanel.setBorder(titledBorder5);
		smoothingjPanel.setLayout(gridBagLayout5);
		smoothingjCheckBox.setSelected(true);
		smoothingjCheckBox.setText("Activate");
		jPanel5.setBorder(titledBorder6);
		jPanel5.setLayout(gridBagLayout6);
		tangentjCheckBox.setSelected(true);
		tangentjCheckBox.setText("Activate");
		equidistantjPanel.setBorder(titledBorder7);
		equidistantjPanel.setLayout(gridBagLayout8);
		equidistantjCheckBox.setSelected(true);
		equidistantjCheckBox.setText("Activate");
		jPanel7.setBorder(titledBorder8);
		jPanel7.setLayout(gridBagLayout7);
		polygonaljCheckBox.setSelected(true);
		polygonaljCheckBox.setText("Activate");
		okjButton.setPreferredSize(new Dimension(81, 27));
		okjButton.setText("OK");
		okjButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				okjButton_actionPerformed(e);
			}
		});
		canceljButton.setPreferredSize(new Dimension(81, 27));
		canceljButton.setText("Cancel");
		canceljButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				canceljButton_actionPerformed(e);
			}
		});
		jLabel1.setText("Radius: ");
		radiusdirectionjTextField.setText(""
				+ this.ownner.normalizeDirectionProcessing);
		radiusdirectionjTextField.setColumns(8);
		simplejRadioButton.setSelected(true);
		simplejRadioButton.setText("Simple smoothing");
		gaussianjRadioButton.setText("Gaussian smoothing:");
		sigmajLabel.setText("Sigma: ");
		sigmajTextField.setText("" + this.ownner.sigmaSmoothingPreprocessing);
		sigmajTextField.setColumns(8);
		jLabel3.setText("Window: ");
		windowjTextField.setText("" + this.ownner.windowSmoothingProcessing);
		windowjTextField.setColumns(8);
		relativetodistancejRadioButton.setText("Relative to distance:");
		relativetowidthheihtjRadioButton.setSelected(true);
		relativetowidthheihtjRadioButton.setText("Relative to width/height:");
		jLabel4.setText("Radius: ");
		radiusequidistantjTextField.setText(""
				+ this.ownner.radiusEquidistantSamplingProcessing);
		radiusequidistantjTextField.setColumns(8);
		jLabel5.setText("Points: ");
		pointsequidistantjTextField.setText(""
				+ this.ownner.pointsEquidistantSamplingProcessing);
		pointsequidistantjTextField.setColumns(8);
		jLabel6.setText("Alpha: ");
		alphajTextField.setText(""
				+ this.ownner.tangentTransformationProcessing);
		alphajTextField.setColumns(8);
		jLabel7.setText("Points: ");
		pointspolygonaljTextField.setText(""
				+ this.ownner.pointsPolygonalApproximationProcessing);
		pointspolygonaljTextField.setColumns(8);
		jPanel2.setBorder(titledBorder9);
		jPanel2.setLayout(gridBagLayout10);
		processingjCheckBox.setText("Activate");
		jLabel8.setText("Sequence: ");
		sequencejTextField.setColumns(8);
		defaultsjButton.setText("Defaults");
		defaultsjButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				defaultsjButton_actionPerformed(e);
			}
		});
		applyjButton.setPreferredSize(new Dimension(81, 27));
		applyjButton.setText("Apply");
		this.getContentPane().add(
				jPanel1,
				new GridBagConstraints(2, 0, 2, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 0), 0, 0));
		jPanel1.add(filteringjCheckBox, new GridBagConstraints(0, 0, 1, 1, 0.0,
				0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(0, 0, 0, 0), 0, 0));
		tangentjPanel.add(normalizejCheckBox, new GridBagConstraints(0, 0, 2,
				1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		tangentjPanel.add(jLabel1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						0, 0, 0), 0, 0));
		tangentjPanel.add(radiusdirectionjTextField, new GridBagConstraints(1,
				1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		this.getContentPane().add(
				orderjPanel,
				new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 0), 0, 0));
		orderjPanel.add(orderjCheckBox, new GridBagConstraints(0, 0, 1, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0), 0, 0));
		smoothingjPanel.add(smoothingjCheckBox, new GridBagConstraints(0, 0, 2,
				1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 0, 0, 5), 0, 0));
		smoothingjPanel.add(simplejRadioButton, new GridBagConstraints(0, 1, 2,
				1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0), 0, 0));
		smoothingjPanel.add(gaussianjRadioButton, new GridBagConstraints(0, 2,
				2, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		smoothingjPanel.add(sigmajLabel, new GridBagConstraints(0, 3, 1, 1,
				0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0), 0, 0));
		smoothingjPanel.add(sigmajTextField, new GridBagConstraints(1, 3, 1, 1,
				0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0), 0, 0));
		smoothingjPanel.add(jLabel3, new GridBagConstraints(0, 4, 1, 1, 0.0,
				0.0, GridBagConstraints.EAST, GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0), 0, 0));
		smoothingjPanel.add(windowjTextField, new GridBagConstraints(1, 4, 1,
				1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0), 0, 0));
		this.getContentPane().add(
				jPanel5,
				new GridBagConstraints(2, 1, 2, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 0), 0, 0));
		jPanel5.add(tangentjCheckBox, new GridBagConstraints(0, 0, 2, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0), 0, 0));
		jPanel5.add(jLabel6, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0,
						0, 0, 0), 0, 0));
		jPanel5.add(alphajTextField, new GridBagConstraints(1, 1, 1, 1, 0.0,
				0.0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0), 0, 0));
		this.getContentPane().add(
				equidistantjPanel,
				new GridBagConstraints(2, 2, 2, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 0), 0, 0));
		this.getContentPane().add(
				tangentjPanel,
				new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 0), 0, 0));
		equidistantjPanel.add(relativetowidthheihtjRadioButton,
				new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0,
						GridBagConstraints.WEST, GridBagConstraints.NONE,
						new Insets(0, 0, 0, 0), 0, 0));
		equidistantjPanel.add(relativetodistancejRadioButton,
				new GridBagConstraints(0, 3, 2, 1, 0.0, 0.0,
						GridBagConstraints.WEST, GridBagConstraints.NONE,
						new Insets(0, 0, 0, 0), 0, 0));
		equidistantjPanel.add(jLabel4, new GridBagConstraints(0, 4, 1, 1, 0.0,
				0.0, GridBagConstraints.EAST, GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0), 0, 0));
		equidistantjPanel.add(jLabel5, new GridBagConstraints(0, 2, 1, 1, 0.0,
				0.0, GridBagConstraints.EAST, GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0), 0, 0));
		equidistantjPanel.add(radiusequidistantjTextField,
				new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
						GridBagConstraints.WEST, GridBagConstraints.NONE,
						new Insets(0, 0, 0, 0), 0, 0));
		equidistantjPanel.add(pointsequidistantjTextField,
				new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
						GridBagConstraints.WEST, GridBagConstraints.NONE,
						new Insets(0, 0, 0, 0), 0, 0));
		equidistantjPanel.add(equidistantjCheckBox, new GridBagConstraints(0,
				0, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 0, 0), 0, 0));
		this.getContentPane().add(
				smoothingjPanel,
				new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 0), 0, 0));
		this.getContentPane().add(
				jPanel7,
				new GridBagConstraints(0, 3, 2, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 0), 0, 0));
		jPanel7.add(polygonaljCheckBox, new GridBagConstraints(0, 0, 2, 1, 0.0,
				0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 0, 0));
		this.getContentPane().add(
				okjButton,
				new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
						GridBagConstraints.WEST, GridBagConstraints.NONE,
						new Insets(10, 2, 0, 2), 0, 0));
		this.getContentPane().add(
				defaultsjButton,
				new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.NONE,
						new Insets(10, 2, 0, 2), 0, 0));
		this.getContentPane().add(
				canceljButton,
				new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.NONE,
						new Insets(10, 2, 0, 2), 0, 0));
		this.getContentPane().add(
				applyjButton,
				new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.NONE,
						new Insets(10, 2, 0, 2), 0, 0));
		this.getContentPane().add(
				jPanel2,
				new GridBagConstraints(2, 3, 2, 1, 0.0, 0.0,
						GridBagConstraints.CENTER, GridBagConstraints.BOTH,
						new Insets(0, 0, 0, 0), 0, 0));
		jPanel2.add(processingjCheckBox, new GridBagConstraints(0, 0, 2, 1,
				0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0), 0, 0));
		jPanel2.add(jLabel8, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0,
						0, 0, 0), 0, 0));
		jPanel2.add(sequencejTextField, new GridBagConstraints(1, 1, 1, 1, 0.0,
				0.0, GridBagConstraints.EAST, GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0), 0, 0));
		jPanel7.add(jLabel7, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0,
						0, 0, 0), 0, 0));
		jPanel7.add(pointspolygonaljTextField, new GridBagConstraints(1, 1, 1,
				1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0), 0, 0));
	}

	public static void main(String args[]) {
		ProcessPropertiesJDialog d = new ProcessPropertiesJDialog();

		d.pack();
		d.setVisible(true);
	}

	void okjButton_actionPerformed(ActionEvent e) {
		String ps = "";
		try {
			if (this.ownner.orderStrokesProcessing = this.orderjCheckBox
					.isSelected())
				ps += "o";

			if (this.ownner.filteringProcessing = this.filteringjCheckBox
					.isSelected())
				ps += "f";

			if (this.normalizejCheckBox.isSelected()) {
				this.ownner.normalizeDirectionProcessing = Float
						.parseFloat(this.radiusdirectionjTextField.getText());
				ps += "n";
			}

			if (this.tangentjCheckBox.isSelected()) {
				this.ownner.tangentTransformationProcessing = Float
						.parseFloat(this.alphajTextField.getText());
				ps += "t";
			}

			if (this.smoothingjCheckBox.isSelected()) {
				this.ownner.sigmaSmoothingPreprocessing = Float
						.parseFloat(this.sigmajTextField.getText());
				this.ownner.windowSmoothingProcessing = Integer
						.parseInt(this.windowjTextField.getText());
				ps += "s";
			}

			if (this.equidistantjCheckBox.isSelected()) {
				this.ownner.radiusEquidistantSamplingProcessing = Float
						.parseFloat(this.radiusequidistantjTextField.getText());
				this.ownner.pointsEquidistantSamplingProcessing = Integer
						.parseInt(this.pointsequidistantjTextField.getText());
				ps += "e";
			}

			if (this.polygonaljCheckBox.isSelected()) {
				this.ownner.pointsPolygonalApproximationProcessing = Integer
						.parseInt(this.pointspolygonaljTextField.getText());
				ps += "e";
			}

			if (this.processingjCheckBox.isSelected()) {
				ps = this.sequencejTextField.getText();
			}

			this.ownner.processingSequenceProcessing = new String(ps);
		} catch (NumberFormatException ex) {
			Object[] options = { "Close" };
			JOptionPane
					.showOptionDialog(
							this,
							"NumberFormatException: some parameters have not the correcto format",
							"Message - " + this.getTitle(),
							JOptionPane.CLOSED_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null, options,
							options[0]);
			return;
		}
		this.setVisible(false);
	}

	void canceljButton_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}

	void this_windowClosing(WindowEvent e) {
		this.setVisible(false);
	}

	void setLocation() {
		this.setLocation(this.ownner.getLocation().x + this.ownner.getWidth()
				/ 2 - this.getWidth() / 2, this.ownner.getLocation().y
				+ this.ownner.getHeight() / 2 - this.getHeight() / 2);
	}

	void defaultsjButton_actionPerformed(ActionEvent e) {

	}
}
