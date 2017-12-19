package mathehilfe.view.components;

import java.awt.Color;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class FunctionsMenuBar extends JMenuBar {

	public FunctionsMenuBar() {
		Border bo = new LineBorder(Color.yellow);
		setBorder(bo);
		// Erzeugung eines Objektes der Klasse JMenu
		JMenu menu = new JMenu("Ich bin ein JMenu");
		// Erzeugung eines Objektes der Klasse JMenuItem
		JMenuItem item = new JMenuItem("Ich bin das JMenuItem");
		// Wir fügen das JMenuItem unserem JMenu hinzu
		menu.add(item);
		// Erzeugung eines Objektes der Klasse JCheckBoxMenuItem
		JCheckBoxMenuItem checkBoxItem = new JCheckBoxMenuItem("Ich bin das JCheckBoxMenuItem");
		// JCheckBoxMenuItem wird unserem JMenu hinzugefügt
		menu.add(checkBoxItem);
		// Menü wird der Menüleiste hinzugefügt
		add(menu);
		//setJMenuBar(bar);
		
	}

}
