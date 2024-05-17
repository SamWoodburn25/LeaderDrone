/*
 * sam woodburn
 * 12/10/23
 * SER120- extra credit
 * 
 * color rectangle class- ectends color shape
 * 		makes a java.awt.geom.rectangle2d
 */

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ColorRectangle extends ColorShape{
	//variables
	private Drone drone;
	private DrawingPanel drwpnl;
		
	//constructor
	    public ColorRectangle(java.awt.Color aBorderColor, java.awt.Color aFillColor, Drone drone, DrawingPanel drwpnl){
			super(new java.awt.geom.Rectangle2D.Double(), drone, drwpnl);
			super.setBorderColor(aBorderColor);
			super.setFillColor(aFillColor);
			this.drone = drone;
			this.drwpnl = drwpnl;	
	    }  
	    
}



