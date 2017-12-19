package mathehilfe;

import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

//Handles rendering cells in the list using a check box
public class CheckboxListRenderer extends JCheckBox implements ListCellRenderer<CheckboxListItem> {

	@Override
	public Component getListCellRendererComponent(JList<? extends CheckboxListItem> list, CheckboxListItem value,
			int index, boolean isSelected, boolean cellHasFocus) {
		setEnabled(list.isEnabled());
		setSelected(value.isSelected());
		setFont(list.getFont());
		setBackground(list.getBackground());
		setForeground(list.getForeground());
		setText(value.toString());
		return this;
	}
}
