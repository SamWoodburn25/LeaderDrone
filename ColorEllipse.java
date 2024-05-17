/*
 * sam woodburn
 * 12/10/23
 * SER120- extra credit
 * 
 * color ellipse class- ectends color shape
 * 		makes a java.awt.geom.ellipse2d
 */

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ColorEllipse extends ColorShape{
	//variables
	private Drone drone;
	private DrawingPanel drwpnl;
	
	//constructor
    public ColorEllipse(Color aBorderColor, Color aFillColor, Drone drone, DrawingPanel drwpnl){ 	
		super(new java.awt.geom.Ellipse2D.Double(), drone, drwpnl);
		super.setBorderColor(aBorderColor);
		super.setFillColor(aFillColor);
		this.drone = drone;
		this.drwpnl = drwpnl;
    }

}



