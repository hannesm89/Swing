package mathehilfe.view.panel;

import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import mathehilfe.CheckboxListItem;
import mathehilfe.CheckboxListRenderer;
import mathehilfe.model.FunctionsModel;

public class MyFunctionsView extends JPanel {
	private JList<CheckboxListItem> myFunctionsList;
	private JScrollPane sp;
	private FunctionsModel functionsModel;

	public MyFunctionsView(FunctionsModel functionsModel) {
		super();
		this.functionsModel = functionsModel;
		init();
	}

	private void init() {
		BoxLayout gbl = new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS);
		setLayout(gbl);

		// Create a list containing CheckboxListItem's
		myFunctionsList  = new JList<CheckboxListItem>(functionsModel.getMyFunctionsListModel());
		myFunctionsList.setCellRenderer(new CheckboxListRenderer());
		myFunctionsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		sp = new JScrollPane(myFunctionsList);

		add(sp);
	}

	public void addMouseListener(MouseListener al) {
		myFunctionsList.addMouseListener(al);
	}

}
