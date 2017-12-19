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

import mathehilfe.model.FunctionsModel;
import mathehilfe.view.components.FunctionInputPanel;
import mathehilfe.view.components.FunctionsMenuBar;
import mathehilfe.view.components.MyFunctionsPanel;
import mathehilfe.view.components.VisualPanel;

/**
 * @author HannesNB
 *
 */
public class FunctionsView extends JFrame {
	private FunctionsMenuBar menubar;
	private FunctionInputPanel functionInputPanel;
	private MyFunctionsPanel myFunctionsPanel;
	private VisualPanel visualPanel;

	private FunctionsModel functionsModel;

	public FunctionsView(FunctionsModel functionsModel) {
		super(functionsModel.getProperty("mathehilfe.appname"));
		this.functionsModel = functionsModel;
		init(this.functionsModel.getPropertyInt("mathehilfe.framewidth"),
				this.functionsModel.getPropertyInt("mathehilfe.frameheight"));
	}

	private void init(int width, int height) {
		setLayout(width, height);
		setVisible(true);
	}

	private void setLayout(int width, int height) {
		setSize(width, height);
		
		menubar = new FunctionsMenuBar();
		setJMenuBar(menubar);
		
		GridBagLayout gbl = new GridBagLayout();
		Container contentPane = getContentPane();
		contentPane.setLayout(gbl);

		functionInputPanel = new FunctionInputPanel(functionsModel);
		myFunctionsPanel = new MyFunctionsPanel(functionsModel);
		visualPanel=  new VisualPanel(functionsModel);
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

	public FunctionInputPanel getFunctionInputPanel() {
		return functionInputPanel;
	}

	public MyFunctionsPanel getMyFunctionsPanel() {
		return myFunctionsPanel;
	}

}
