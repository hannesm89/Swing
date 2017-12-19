package mathehilfe.controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;

import javax.swing.JList;

import mathehilfe.CheckboxListItem;
import mathehilfe.ListenerAdapter;
import mathehilfe.model.FunctionsModel;
import mathehilfe.view.FunctionsView;

public class FunctionsController extends ListenerAdapter {
	private FunctionsView functionsView;
	private FunctionsModel functionsModel;

	public FunctionsController() {
		functionsModel = new FunctionsModel();
		functionsView = new FunctionsView(functionsModel);
		addListener();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == functionsModel
				.getProperty("mathehilfe.view.panels.FunctionInputPanel.actioncommand.addfunction")) {
			functionsModel.setFunctionInputPanel_fxInputText(functionsView.getFunctionInputPanel().getFxInputField());
			functionsModel.addEntry();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void mouseClicked(MouseEvent event) {
		JList<CheckboxListItem> list = (JList<CheckboxListItem>) event.getSource();
		// Get index of item clicked
		int index = list.locationToIndex(event.getPoint());
		CheckboxListItem item = (CheckboxListItem) list.getModel().getElementAt(index);

		// Toggle selected state
		item.setSelected(!item.isSelected());

		// Repaint cell
		list.repaint(list.getCellBounds(index, index));
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	private void addListener() {
		functionsView.addWindowListener(this);
		functionsView.getFunctionInputPanel().addActionListener(this);
		functionsView.getMyFunctionsPanel().addMouseListener(this);
	}
}
