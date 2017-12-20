package mathehilfe.view.panel;

import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mathehilfe.model.FunctionsModel;

public class InputFunctionView extends JPanel {
	private JLabel fxLabel;
	private JTextField fxInputField;
	private JButton fxAddButton;

	private FunctionsModel functionsModel;

	public InputFunctionView(FunctionsModel functionsModel) {
		super();
		this.functionsModel = functionsModel;
		init();
	}

	private void init() {
		setLayout(new BoxLayout(this, javax.swing.BoxLayout.X_AXIS));

		fxLabel = new JLabel(functionsModel.getProperty("mathehilfe.view.panels.FunctionInputPanel.fxLabel"));
		fxInputField = new JTextField(
				functionsModel.getProperty("mathehilfe.view.panels.FunctionInputPanel.fxInputField.default"), 12);
		fxAddButton = new JButton(functionsModel.getProperty("mathehilfe.button.add"));

		add(fxLabel);
		add(fxInputField);
		add(fxAddButton);
	}

	public void addActionListener(ActionListener al) {
		String actionCommand = functionsModel
				.getProperty("mathehilfe.view.panels.FunctionInputPanel.actioncommand.addfunction");
		fxAddButton.setActionCommand(actionCommand);
		fxAddButton.addActionListener(al);
		fxInputField.setActionCommand(actionCommand);
		fxInputField.addActionListener(al);
	}

	public String getFxInputField() {
		return fxInputField.getText();
	}
}
