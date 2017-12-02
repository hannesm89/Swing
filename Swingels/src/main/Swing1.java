package main;

import java.awt.Color;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Swing1 {
	public static void main(String[] args) {
		// Erzeugung eines neuen Frames mit dem Titel "Beispiel JFrame "
		JFrame meinFrame = new JFrame("Beispiel JFrame");
		// Wir setzen die Breite und die Höhe unseres Fensters
		meinFrame.setSize(1300, 800);
		createMenu(meinFrame);
		meinFrame.setVisible(true);

	}
	
	public static void createMenu(JFrame meinFrame) {
        // Zur Veranschaulichung erstellen wir hier eine Border
        Border bo = new LineBorder(Color.yellow);
        // Erstellung einer Menüleiste
        JMenuBar bar = new JMenuBar();
        // Wir setzen unsere Umrandung für unsere JMenuBar
        bar.setBorder(bo);
        // Erzeugung eines Objektes der Klasse JMenu
        JMenu menu = new JMenu("Ich bin ein JMenu");
        // Erzeugung eines Objektes der Klasse JMenuItem
        JMenuItem item = new JMenuItem("Ich bin das JMenuItem");
        // Wir fügen das JMenuItem unserem JMenu hinzu
        menu.add(item);
        // Erzeugung eines Objektes der Klasse JCheckBoxMenuItem
        JCheckBoxMenuItem checkBoxItem = new JCheckBoxMenuItem
            ("Ich bin das JCheckBoxMenuItem");
        // JCheckBoxMenuItem wird unserem JMenu hinzugefügt 
        menu.add(checkBoxItem);
        // Menü wird der Menüleiste hinzugefügt
        bar.add(menu);
        // Menüleiste wird für den Dialog gesetzt
        meinFrame.setJMenuBar(bar);
	}

	public static void createColorChooserDialog() {
		// Erzeugung eines neuen Frames mit
		// dem Titel Beispiel JDialog
		JDialog meinJDialog = new JDialog();
		// Titel wird gesetzt
		meinJDialog.setTitle("Mein JDialog Beispiel");
		// Breite und Höhe des Fensters werden
		// auf 200 Pixel gesetzt
		meinJDialog.setSize(450, 300);
		// Erzeugung eines Objektes der Klasse JColorChooser
		JColorChooser colorChooser = new JColorChooser();
		// Holt ContentPane von unserem Frame
		// und fügt diesem unseren JColorChooser hinzu
		meinJDialog.getContentPane().add(colorChooser);
		// Wir lassen unseren Frame anzeigen
		// Dialog wird auf modal gesetzt
		meinJDialog.setModal(true);
		// Wir lassen unseren Dialog anzeigen
		meinJDialog.setVisible(true);
	}
}
