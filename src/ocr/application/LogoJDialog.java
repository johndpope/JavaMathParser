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

import awt.*;
import javax.swing.*;
import javax.swing.border.*;
import svm.*;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

public class LogoJDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4688214668393125487L;
	Border border1;
	boolean close;
	DrawJPanel dp;
	JLabel l;
	Image logo;
	HcrData owner;
	JPanel p;

	public LogoJDialog() throws HeadlessException {
		super();
		this.close = false;
		this.l = new JLabel();
		this.p = new JPanel();
		try {
			this.jbInit();
			this.setLogo("icons/Logo.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public LogoJDialog(final HcrData owner, final boolean modal,
			final boolean close) throws HeadlessException {
		super(owner, modal);
		this.close = false;
		this.l = new JLabel();
		this.p = new JPanel();
		this.owner = owner;
		this.close = close;
		try {
			this.jbInit();
			this.setLogo("icons/Logo.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void dp_mouseClicked(final MouseEvent e) {
		if (this.close) {
			this.setVisible(false);
		}
	}

	void dp_mouseReleased(final MouseEvent e) {
		if (this.close) {
			this.setVisible(false);
		}
	}

	private void jbInit() throws Exception {
		final MediaTracker tracker = new MediaTracker(this);
		if (this.close) {
			this.logo = Toolkit.getDefaultToolkit().getImage(
					"icons/LogoName.png");
		} else {
			this.logo = Toolkit.getDefaultToolkit().getImage("icons/Logo.png");
		}
		this.border1 = new EtchedBorder(0, Color.black, Color.white);
		tracker.addImage(this.logo, 0);
		try {
			tracker.waitForAll();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		this.dp = new DrawJPanel(this.logo.getWidth(this),
				this.logo.getHeight(this));
		this.addComponentListener(new LogoJDialog_this_componentAdapter(this));
		this.addWindowListener(new LogoJDialog_this_windowAdapter(this));
		this.addMouseListener(new LogoJDialog_this_mouseAdapter(this));
		this.dp.addMouseListener(new LogoJDialog_dp_mouseAdapter(this));
		this.l.setBackground(new Color(211, 209, 196));
		this.l.setFont(new Font("Serif", 0, 11));
		this.p.setBorder(this.border1);
		this.getContentPane().add(this.dp, "North");
	}

	public static void main(final String[] args) throws HeadlessException {
		final LogoJDialog logoJDialog1 = new LogoJDialog();
		logoJDialog1.setClose(true);
		logoJDialog1.setVisible(true);
		logoJDialog1.setLogo("/home/tapia/svm/classes/icons/Logo.gif");
	}

	@Override
	public void paint(final Graphics g) {
		super.paint(g);
		try {
			g.drawImage(this.logo, this.dp.getLocation().x,
					this.dp.getLocation().y, this);
			g.setColor(Color.white);
			g.drawRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);
			g.drawRect(1, 1, this.getWidth() - 1, this.getHeight() - 1);
			g.setColor(Color.black);
			g.drawRect(0, 0, this.getWidth() - 2, this.getHeight() - 2);
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
	}

	public void readClassificationModel() {
		this.owner.maxNumStrokes = new int[this.owner.numClassifiers];
		this.owner.svmModel = new SvmModel[this.owner.numClassifiers][];
		if (this.owner.url == null) {
			for (int i = 0; i < this.owner.numClassifiers; ++i) {
				this.owner.svmModel[i] = new SvmModel[4];
				this.owner.maxNumStrokes[i] = 0;
				for (int j = 0; j < 4; ++j) {
					try {
						this.owner.svmModel[i][j] = new SvmModel();
						System.out.println("Loading SvmModel: " + i + ""
								+ this.owner.modelname + "" + j + ".svm");
						this.owner.svmModel[i][j].read("/models/" + i + ""
								+ this.owner.modelname + "" + j + ".svm");
						this.owner.maxNumStrokes[i] = j + 1;
					} catch (FileNotFoundException fnfe) {
						this.owner.svmModel[i][j] = null;
						break;
					} catch (IOException ioe) {
					}
				}
				if (i == 0) {
					this.setVisible(false);
				}
			}
		} else {
			for (int i = 0; i < this.owner.numClassifiers; ++i) {
				this.owner.svmModel[i] = new SvmModel[4];
				this.owner.maxNumStrokes[i] = 0;
				for (int j = 0; j < 4; ++j) {
					try {
						(this.owner.svmModel[i][j] = new SvmModel())
								.read(new URL(this.owner.url.toString()
										+ "/models/" + i + ""
										+ this.owner.modelname + "" + j
										+ ".svm"));
						this.owner.maxNumStrokes[i] = j + 1;
					} catch (FileNotFoundException fnfe) {
						this.owner.svmModel[i][j] = null;
						break;
					} catch (IOException ioe) {
					}
				}
			}
		}
	}

	public void setClose(final boolean b) {
		this.close = b;
	}

	public void setLogo(final String filename) {
		this.setUndecorated(true);
		if (this.close) {
			final Dimension d = new Dimension(this.logo.getWidth(this),
					(int) (2.5 * this.logo.getHeight(this)));
			this.l.setText("<html><center><b>JMathNotes Version 0.3</b><br> Copyright (c) 2003-2004 Ernesto Tapia. All rights reserved.</center><br><br>This program is free software; you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation; either version 2 of the License, or (at your option) any later version.<br><br>This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.<br><br>You should have received a copy of the GNU General Public License along with this program; if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.<br><small><ul><li>May include the <i>Java(TM) Runtime Environment</i> and the <i>Java(TM) Look and Feel Repository</i> by (c) Sun Microsystems, Inc. distributed under proprietary licenses that come along with their software and must not be altered or removed.</li></ul></small></html>");
			this.l.setPreferredSize(new Dimension((int) d.getWidth() - 25,
					(int) d.getHeight()));
			this.l.setMinimumSize(new Dimension((int) d.getWidth() - 25,
					(int) d.getHeight()));
			this.l.setSize(new Dimension((int) d.getWidth() - 25, (int) d
					.getHeight()));
			this.p.add(this.l);
			this.p.setPreferredSize(d);
			this.p.setMinimumSize(d);
			this.p.setSize(d);
			this.p.setBackground(new Color(211, 209, 196));
			this.setBackground(new Color(211, 209, 196));
			this.getContentPane().add(this.p, "Center");
		}
		this.pack();
		final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(
				(int) (dimension.getWidth() / 2.0 - this.getWidth() / 2),
				(int) (dimension.getHeight() / 2.0 - this.getHeight() / 2));
		if (!this.close) {
			final DownloadModelThread thread = new DownloadModelThread(this);
			thread.start();
		}
		this.setVisible(true);
		this.repaint();
	}

	void this_componentResized(final ComponentEvent e) {
	}

	void this_mouseClicked(final MouseEvent e) {
		if (this.close) {
			this.setVisible(false);
		}
	}

	void this_windowClosing(final WindowEvent e) {
		if (this.close) {
			this.setVisible(false);
		}
	}

	@Override
	public void update(final Graphics g) {
		super.update(g);
		this.paint(g);
	}

	class DownloadModelThread extends Thread {
		LogoJDialog ld;

		public DownloadModelThread(final LogoJDialog ld) {
			super();
			this.ld = ld;
		}

		@Override
		public void run() {
			LogoJDialog.this.readClassificationModel();
			try {
				Thread.sleep(500L);
			} catch (Exception ex) {
			}
			this.ld.setVisible(false);
		}
	}
}

class LogoJDialog_this_mouseAdapter extends java.awt.event.MouseAdapter {
	LogoJDialog adaptee;

	LogoJDialog_this_mouseAdapter(LogoJDialog adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		adaptee.this_mouseClicked(e);
	}
}

class LogoJDialog_this_windowAdapter extends java.awt.event.WindowAdapter {
	LogoJDialog adaptee;

	LogoJDialog_this_windowAdapter(LogoJDialog adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public void windowClosing(WindowEvent e) {
		adaptee.this_windowClosing(e);
	}
}

class LogoJDialog_this_componentAdapter extends java.awt.event.ComponentAdapter {
	LogoJDialog adaptee;

	LogoJDialog_this_componentAdapter(LogoJDialog adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public void componentResized(ComponentEvent e) {
		adaptee.this_componentResized(e);
	}
}

class LogoJDialog_dp_mouseAdapter extends java.awt.event.MouseAdapter {
	LogoJDialog adaptee;

	LogoJDialog_dp_mouseAdapter(LogoJDialog adaptee) {
		this.adaptee = adaptee;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		adaptee.dp_mouseClicked(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		adaptee.dp_mouseReleased(e);
	}
}
