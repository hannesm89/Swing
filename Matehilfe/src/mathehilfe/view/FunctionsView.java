/**
 * 
 */
package mathehilfe.view;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import mathehilfe.model.FunctionsModel;
import mathehilfe.view.panel.DisplayFunctionsView;
import mathehilfe.view.panel.InputFunctionView;
import mathehilfe.view.panel.MyFunctionsView;

/**
 * @author HannesNB
 *
 */
public class FunctionsView extends JFrame {
	private MenuBarView menubar;
	private InputFunctionView functionInputPanel;
	private MyFunctionsView myFunctionsPanel;
	private DisplayFunctionsView visualPanel;

	private FunctionsModel functionsModel;

	public FunctionsView(FunctionsModel functionsModel) {
		super(functionsModel.getProperty("mathehilfe.appname"));
		this.functionsModel = functionsModel;
		init(this.functionsModel.getPropertyInt("mathehilfe.framewidth"),
				this.functionsModel.getPropertyInt("mathehilfe.frameheight"));
		updateLAF();
	}

	private void updateLAF() {
		int lAF = 3;
		try {
			String plaf = "";
			if (lAF == 1) {
				plaf = "javax.swing.plaf.metal.MetalLookAndFeel";
			} else if (lAF == 2) {
				plaf = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
			} else if (lAF == 3) {
				plaf = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
			} else if (lAF == 4) {
				plaf = "com.sun.java.swing.plaf.gtk.GTKLookAndFeel";
			} else if (lAF == 5) {
				plaf = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
			} else if (lAF == 6) {
				plaf = UIManager.getSystemLookAndFeelClassName();
			}

			UIManager.setLookAndFeel(plaf);
			SwingUtilities.updateComponentTreeUI(this);

		} catch (UnsupportedLookAndFeelException ue) {
			try {
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException ce) {
			System.err.println(ce.toString());
		} catch (InstantiationException ie) {
			System.err.println(ie.toString());
		} catch (IllegalAccessException iae) {
			System.err.println(iae.toString());
		}
	}

	private void init(int width, int height) {
		setLayout(width, height);
		setVisible(true);
	}

	private void setLayout(int width, int height) {
		setSize(width, height);

		menubar = new MenuBarView();
		setJMenuBar(menubar);

		GridBagLayout gbl = new GridBagLayout();
		Container contentPane = getContentPane();
		contentPane.setLayout(gbl);

		functionInputPanel = new InputFunctionView(functionsModel);
		myFunctionsPanel = new MyFunctionsView(functionsModel);
		visualPanel = new DisplayFunctionsView(functionsModel);
		addComponent(contentPane, gbl, functionInputPanel, GridBagConstraints.NONE, 0, 0, 1, 1, 0, 0);
		addComponent(contentPane, gbl, new JLabel("Meine Funktionen"), GridBagConstraints.NONE, 0, 2, 1, 1, 0, 0);
		addComponent(contentPane, gbl, new JSeparator(), GridBagConstraints.NONE, 0, 2, 1, 1, 0, 0);
		addComponent(contentPane, gbl, myFunctionsPanel, GridBagConstraints.BOTH, 0, 3, 1, 1, 0, 1.0);
		addComponent(contentPane, gbl, visualPanel, GridBagConstraints.BOTH, 1, 0, 1, 4, 1.0, 0);

		contentPane.setSize(width, height);
	}

	private static void addComponent(Container cont, GridBagLayout gbl, Component c, int fill, int x, int y, int width,
			int height, double weightx, double weighty) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = fill;
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = width;
		gbc.gridheight = height;
		gbc.weightx = weightx;
		gbc.weighty = weighty;
		gbl.setConstraints(c, gbc);
		cont.add(c);
	}

	public void addWindowListener(WindowListener wl) {
		super.addWindowListener(wl);
	}

	public InputFunctionView getFunctionInputPanel() {
		return functionInputPanel;
	}

	public MyFunctionsView getMyFunctionsPanel() {
		return myFunctionsPanel;
	}

}
