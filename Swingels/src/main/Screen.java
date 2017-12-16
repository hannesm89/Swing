package main;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
public class Screen extends Frame {
 
    private static final int SIZE = 300;
   
    private static final double xMin = -4.0;
    private static final double xMax = 4.0;
    private static final double yMin = -16;
    private static final double yMax = 16;
   
    public Screen() {
 
        this.setSize(SIZE,SIZE);
        addWindowListener(new WindowAdapter(){  public void windowClosing(WindowEvent e) {  dispose();}});
    }
 
    public void paint(Graphics g) {
        zeicheKoordinatenSystem(g);
        for(double x = xMin; x < xMax; x += 0.01 ){
            g.drawLine(berechneXPixel(x), berechneYPixel(f(x)), berechneXPixel(x),  berechneYPixel(f(x)));
        }
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
    public static void main(String[] args) {
        new Screen().setVisible(true);
    }
}
