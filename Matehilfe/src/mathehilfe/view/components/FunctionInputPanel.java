package mathehilfe.view.components;

import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mathehilfe.model.FunctionsModel;

public class FunctionInputPanel extends JPanel {
	private JLabel fxLabel;
	private JTextField fxInputField;
	private JButton fxAddButton;

	private FunctionsModel functionsModel;

	private final String Y_EQUALS_FX_LABEL = " y = f(x) =";
	public final String BUTTON_ADD_LABEL = "Hinzufügen";

	public FunctionInputPanel(FunctionsModel functionsModel) {
		super();
		this.functionsModel = functionsModel;
		init();
	}

	private void init() {
		setLayout(new BoxLayout(this, javax.swing.BoxLayout.X_AXIS));

		fxLabel = new JLabel(Y_EQUALS_FX_LABEL);
		fxInputField = new JTextField(functionsModel.getFunctionInputPanel_fxInputText(), 12);
		fxAddButton = new JButton(BUTTON_ADD_LABEL);

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
