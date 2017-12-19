package mathehilfe.main;

import javax.swing.SwingUtilities;

import mathehilfe.controller.FunctionsController;

public class SwingMathehilfe {

	private SwingMathehilfe() {
		start();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SwingMathehilfe();
			}
		});
	}

	private void start() {
		new FunctionsController();
	}
}
