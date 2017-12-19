package mathehilfe.view.components;

import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JPanel;

import mathehilfe.model.FunctionsModel;

public class VisualPanel extends JPanel {
	private static final double xMin = -4.0;
    private static final double xMax = 4.0;
    private static final double yMin = -16;
    private static final double yMax = 16;
    
	private FunctionsModel functionsModel;

	public VisualPanel(FunctionsModel functionsModel) {
		super();
		this.functionsModel = functionsModel;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		zeicheKoordinatenSystem(g);
        for(double x = xMin; x < xMax; x += 0.01 ){
            g.drawLine(berechneXPixel(x), berechneYPixel(f(x)), berechneXPixel(x),  berechneYPixel(f(x)));
        }
		
		/*Polygon p = new Polygon();
		for (int i = 0; i < 5; i++)
			p.addPoint((int) (100 + 50 * Math.cos(i * 2 * Math.PI / 5)),
					(int) (100 + 50 * Math.sin(i * 2 * Math.PI / 5)));

		g.drawPolygon(p);*/
	}

   
    private void zeicheKoordinatenSystem(Graphics g) {
        zeichneXAchse(g);
        zeichneYAchse(g);
    }
 
    private void zeichneXAchse(Graphics g) {
       
        int startx = berechneXPixel(xMin);
        int endx = berechneXPixel(xMax);
        int starty = berechneYPixel(0);
        int endy = berechneYPixel(0);
        g.drawLine(startx, starty, endx, endy);
       
    }
    private void zeichneYAchse(Graphics g) {
        int startx = berechneXPixel(0);
        int endx = berechneXPixel(0);
        int starty = berechneYPixel(yMin);
        int endy = berechneYPixel(yMax);
        g.drawLine(startx, starty, endx, endy);
       
    }
 
    private int berechneXPixel(double x) {
       
        double pixelBreite = ((xMax - xMin) / (double)getWidth());
        return (int) ((x - xMin) / pixelBreite );
    }
    private int berechneYPixel(double y) {
       
        double pixelBreite = ((yMax - yMin) / (double)getHeight());
        return getHeight() - ((int) ((y - yMin) / pixelBreite));
    }
   
    private double f(double x) {
        return x * x;
    }
}
