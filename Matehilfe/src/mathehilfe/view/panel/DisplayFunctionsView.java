package mathehilfe.view.panel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

import mathehilfe.model.FunctionsModel;

public class DisplayFunctionsView extends JPanel {
	private static final double xMin = -10.0;
	private static final double xMax = 10.0;
	private static final double yMin = -10;
	private static final double yMax = 10;

	private FunctionsModel functionsModel;

	public DisplayFunctionsView(FunctionsModel functionsModel) {
		super();
		this.functionsModel = functionsModel;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.translate(getWidth()/2, getHeight()/2);
		zeichneKoordinatenSystem(g2d, 50, 150, 0, 200);
	}

	public void kkordss() {

	}
	private void zeichneKoordinatenSystem(Graphics2D g, int lpad, int tpad, int rpad, int bpad) {
		zeichneXAchse(g, lpad, rpad);
		zeichneYAchse(g, tpad, bpad);
	}

//	private void zeichneKoordinatenSystem(Graphics2D g, int lpad, int tpad, int rpad, int bpad) {
//		zeichneXAchse(g, lpad, rpad);
//		zeichneYAchse(g, tpad, bpad);
//	}

	private void zeichneXAchse(Graphics2D g, int lpad, int rpad) {
		int startx = berechneXPixel(xMin);
		int endx = berechneXPixel(xMax);
		int starty = berechneYPixel(0);
		int endy = berechneYPixel(0);
		g.drawLine(startx + lpad, starty, endx - rpad, endy);
	}

	private void zeichneYAchse(Graphics2D g, int tpad, int bpad) {
		int startx = berechneXPixel(0);
		int endx = berechneXPixel(0);
		int starty = berechneYPixel(yMin);
		int endy = berechneYPixel(yMax);
		g.drawLine(startx, starty + tpad, endx, endy - bpad);
	}

	private int berechneXPixel(double x) {
		double pixelBreite = ((xMax - xMin) / (double) getWidth());
		return (int) ((x - xMin) / pixelBreite);
	}

	private int berechneYPixel(double y) {
		double pixelBreite = ((yMax - yMin) / (double) getHeight());
		return  ((int) ((y - yMin) / pixelBreite));
	}

	// private double f(double x) {
	// return x * x;
	// }
}
