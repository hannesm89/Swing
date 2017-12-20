package main;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Swing1 {

	public static void main(String[] args) {
		// Erzeugung eines neuen Frames mit dem Titel "Beispiel JFrame "
		JFrame meinFrame = new JFrame("Beispiel JFrame");
		// Wir setzen die Breite und die H�he unseres Fensters
		meinFrame.setSize(1300, 800);
		meinFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		Container contentPane = meinFrame.getContentPane();
		createMenu(meinFrame);
		showPopup(contentPane);
		{
			/*
			 * Dialoge
			 * 
			 *****************************************
			 * // Color-Chooser-Dialog createColorChooserDialog(); // Bsp. 1: Eingabe-Dialog
			 * String eingabestr = JOptionPane.showInputDialog("Dies ist ein Input Dialog");
			 * 
			 * // Bsp. 2: Dialog zur Best�tigung int confirm =
			 * JOptionPane.showConfirmDialog(null, "Dies ist ein Confirm Dialog");
			 * 
			 * // Bsp. 3: Nachrichten-Dialog JOptionPane.showMessageDialog(null,
			 * "Dies ist ein Message Dialog");
			 * 
			 * // Bsp. 4: Optionsdialog mit Warnhinweis int option =
			 * JOptionPane.showOptionDialog(null,
			 * "Dies ist ein Optionsdialog","Optionsdialog",
			 * JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, new
			 * String[]{"A", "B", "C"}, "B"); /
			 *****/
		}

		meinFrame.setVisible(true);

	}

	private static void showPopup(Container meinFrame) {
		JPopupMenu pop = new JPopupMenu();
		// Wir setzen die Position unseres Kontextmen�s
		// auf die Koordinaten X = 100 und Y =100
		pop.setLocation(100, 100);

		// Erzeugung eines Objektes der Klasse JMenuItem
		JMenuItem item = new JMenuItem("JMenuItem innerhalb eines JPopups");
		// Erzeugung eines Objektes der Klasse JSeparator
		JSeparator sep = new JSeparator();
		// Erzeugung eines Objektes der Klasse JCheckBoxMenuItem
		JCheckBoxMenuItem checkBoxItem = new JCheckBoxMenuItem("JCheckBoxMenuItem innerhalb eines JPopups");
		// Erzeugung eines Objektes der Klasse JRadioButtonMenuItem
		JRadioButtonMenuItem radioButtonItem = new JRadioButtonMenuItem("JRadionButtonMenuItem innerhalb eines JPopups",
				true);
		// Wir f�gen unsere Men�eintr�ge unserem Kontextmen� hinzu
		pop.add(item);
		pop.add(sep);
		pop.add(checkBoxItem);
		pop.add(radioButtonItem);
		// Wir lassen unser JPopupMenu anzeigen
		meinFrame.add(pop);
		pop.setVisible(true);
	}

	private static void createMenu(JFrame meinFrame) {
		// Zur Veranschaulichung erstellen wir hier eine Border
		Border bo = new LineBorder(Color.yellow);
		// Erstellung einer Men�leiste
		JMenuBar bar = new JMenuBar();
		// Wir setzen unsere Umrandung f�r unsere JMenuBar
		bar.setBorder(bo);
		// Erzeugung eines Objektes der Klasse JMenu
		JMenu menu = new JMenu("Ich bin ein JMenu");
		// Erzeugung eines Objektes der Klasse JMenuItem
		JMenuItem item = new JMenuItem("Ich bin das JMenuItem");
		// Wir f�gen das JMenuItem unserem JMenu hinzu
		menu.add(item);
		// Erzeugung eines Objektes der Klasse JCheckBoxMenuItem
		JCheckBoxMenuItem checkBoxItem = new JCheckBoxMenuItem("Ich bin das JCheckBoxMenuItem");
		// JCheckBoxMenuItem wird unserem JMenu hinzugef�gt
		menu.add(checkBoxItem);
		// Men� wird der Men�leiste hinzugef�gt
		bar.add(menu);
		// Men�leiste wird f�r den Dialog gesetzt
		meinFrame.setJMenuBar(bar);
	}

	@SuppressWarnings("unused")
	private static void createColorChooserDialog() {
		// Erzeugung eines neuen Frames mit
		// dem Titel Beispiel JDialog
		JDialog meinJDialog = new JDialog();
		// Titel wird gesetzt
		meinJDialog.setTitle("Mein JDialog Beispiel");
		// Breite und H�he des Fensters werden
		// auf 200 Pixel gesetzt
		meinJDialog.setSize(450, 300);
		// Erzeugung eines Objektes der Klasse JColorChooser
		JColorChooser colorChooser = new JColorChooser();
		// Holt ContentPane von unserem Frame
		// und f�gt diesem unseren JColorChooser hinzu
		meinJDialog.getContentPane().add(colorChooser);
		// Wir lassen unseren Frame anzeigen
		// Dialog wird auf modal gesetzt
		meinJDialog.setModal(true);
		// Wir lassen unseren Dialog anzeigen
		meinJDialog.setVisible(true);
	}
}
