/*
 * sam woodburn
 * 12/10/23
 * SER120- extra credit
 * 
 * color shape class
 * 		draws a rectangular shape using java.awt.geom
 */

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public abstract class ColorShape{
	//variables
    private java.awt.Color _borderColor, _fillColor; // attributes
    private double _rotation;    
    private final int STROKE_WIDTH = 2; 
    private java.awt.geom.RectangularShape _shape; // component
    private Drone drone;
    private DrawingPanel drwpnl;

    //constructor
    public ColorShape (java.awt.geom.RectangularShape s, Drone drone, DrawingPanel drwpnl) {
    	_borderColor = java.awt.Color.white;
	    _fillColor = java.awt.Color.white;
	    _rotation = 0;
	    _shape = s;
	    this.drone = drone;
	    this.drwpnl = drwpnl;
    }
    
    //color setters
    public void setColor (java.awt.Color aColor) {
	    _borderColor = aColor;
	    _fillColor = aColor;
    } 
    public void setBorderColor (java.awt.Color aColor) {
    	_borderColor = aColor;
    }
    public void setFillColor (java.awt.Color aColor) {
    	_fillColor = aColor;
    } 

    //getters maxX, maxY, x, and y
    public double getMaxX () {
    	return _shape.getMaxX();
    }
    public double getMaxY () {
    	return _shape.getMaxY();
    }
    public int getX() {
    	return (int)_shape.getX();
    }
    public int getY() {
    	return (int)_shape.getY();
    }

    // set location of the shape
    public void setLocation (int x, int y) {
    	_shape.setFrame (x, y, _shape.getWidth(), _shape.getHeight());
    }

    // size methods
    public void setSize (int width, int height) {
    	_shape.setFrame(_shape.getX(), _shape.getY(), width, height);
    }
    public boolean contains(java.awt.Point p){
    	return _shape.contains(p);
    }
    
    //draw and fill methods
    public void draw (java.awt.Graphics2D aBrush) {
	    java.awt.Color savedColor = aBrush.getColor();
	    aBrush.setColor(_borderColor);
	    
	    java.awt.Stroke savedStroke = aBrush.getStroke();
	    aBrush.setStroke(new java.awt.BasicStroke(STROKE_WIDTH));
	    
	    aBrush.rotate(_rotation, _shape.getCenterX(),_shape.getCenterY());
	    aBrush.draw(_shape);
	    aBrush.rotate(-_rotation,  _shape.getCenterX(),_shape.getCenterY());
	    aBrush.setStroke(savedStroke);
	    aBrush.setColor(savedColor);
    }
    public void fill (java.awt.Graphics2D aBrush){
	    java.awt.Color savedColor = aBrush.getColor();
	    aBrush.setColor(_fillColor);
	    aBrush.rotate(_rotation, _shape.getCenterX(),_shape.getCenterY());
	    aBrush.fill(_shape);
	    aBrush.rotate(-_rotation,_shape.getCenterX(),_shape.getCenterY());
	    aBrush.setColor(savedColor);
    }
    
}// ends color shape class
