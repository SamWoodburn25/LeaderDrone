/*
 * sam woodburn
 * 12/10/23
 * SER120- extra credit
 * 
 * Drone class- implements mouse listener
 * 		uses color ellipse and color rectangle to draw a drone and set size & location
 * 		adds a mouse listener to check if the drone has been clicked
 */


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Drone implements MouseListener{
	//variables
	protected ColorEllipse fwing, rwing;
	protected ColorRectangle body;
	private int x, y, bodySize, wingSize;
	private DrawingPanel drwpnl;
	private ActionHolder actionHolder;
	private Drone current;
	
	//parameterized constructor
	public Drone(int x, int y, int bodySize, int wingSize, DrawingPanel drwpnl, ActionHolder actionHolder){
		this.x = x;
		this.y = y;
		this.bodySize = bodySize;
		this.wingSize = wingSize;
		this.drwpnl = drwpnl;
		this.actionHolder = actionHolder;
		
		//make body and wings
		body = new ColorRectangle(Color.pink, Color.pink, this, drwpnl);
		fwing = new ColorEllipse(Color.pink, Color.pink, this, drwpnl);		
		rwing = new ColorEllipse(Color.pink, Color.pink, this, drwpnl);
		
		//set location and size
		this.setLocation(x, y);
		this.setSize(bodySize, wingSize);
		
		//add this mouse listener to the drawing panel
		drwpnl.addMouseListener(this);
	}// end constructor 
	
	//getter and setter bodySize
	public int getBodySize() {
		return this.bodySize;
	}
	public void setBodySize(int size) {
		this.bodySize = size;
	}
	
	//set color methods
	public void setColor(Color color) {
		body.setColor(color);
		fwing.setColor(color);
		rwing.setColor(color);
	}
	public void setBodyColor(Color color) {
		body.setColor(color);
	}
	public void setWingColor(Color color) {
		fwing.setColor(color);
		rwing.setColor(color);
	}
	
	//set location and size relative to its other parts
	public void setLocation(int x, int y) {
		this.x = x;
		this.y = y;
		body.setLocation(x, y);
		fwing.setLocation(x+(this.bodySize - (this.wingSize / 2)),y+5);
		rwing.setLocation(x-(this.wingSize/2),y+5);
	}
	public void setSize(int bodySize, int wingSize) {
		this.bodySize = bodySize;
		this.wingSize = wingSize;
		body.setSize(bodySize, bodySize+(bodySize/2));
		fwing.setSize(wingSize,wingSize);
		rwing.setSize(wingSize,wingSize);

	}
	
	//draw and fill it on the screen
	public void draw(Graphics2D brush) {
		fwing.draw(brush);
		rwing.draw(brush);
		body.draw(brush);
	}
	public void fill(Graphics2D brush) {
		body.fill(brush);
		fwing.fill(brush);
		rwing.fill(brush);
	}
	//getters x and y
	public int getx() {
		return x;
	}
	public int gety() {
		return y;
	}
	//setter x and y
	public void setx(int x) {
		this.x = x;
	}
	public void sety(int y) {
		this.y = y;
	}
	
	//moving the drone
	public void move(int dx, int dy) {
		int newx = 0, newy = 0;
		//if x value and y value is on the screen move the drone
		if((body.getMaxX() - bodySize - (wingSize/2)) < 500 && (body.getMaxY() - bodySize) < 500) {
			this.setLocation(x+dx, y+dy);
		}
		//if it moves off the screen change the x or y coordinate so it wraps around
		else {
			if((body.getMaxX() - bodySize - (wingSize/2)) >= 500){
				if(x == 0) {
					newx = x;
					newy = 0;
				}
				else {
					newx = 0;
					newy = y;
				}
			}
			else if((body.getMaxY() - bodySize ) >= 500) {
				if(y == 0) {
					newy = y;
					newx = 0;
				}
				else {
					newy = 0;
					newx = x;
				}
			}
			//set the changed location
			this.setLocation(newx, newy);
		}
	}// end move method
	
	//performs the action which the action holder currents is holding
	  public void performAction(ActionHolder actionHolder) {
	        String action = actionHolder.getAction();
	        //switch statement, each action option
	        switch (action) {
	            case "Follow Leader":
	            	//implement follow logic
	            	current = drwpnl.getSelected();
	            	//the last follow is equal to the last drone in the following array unless it is empty then it is equal to leader drone
	                Drone lastFollower = drwpnl.followingDrones.isEmpty() ? drwpnl.leaderDrone : drwpnl.followingDrones.get(drwpnl.followingDrones.size() - 1);
	    			//set currents position
	                current.sety(lastFollower.gety());
	    			current.setx(lastFollower.getx()- current.getBodySize()-20);
	    			//default move values
	    			drwpnl.getSelectedTimer().setMovex(drwpnl.getLeaderTimer().getMovex());
	    			drwpnl.getSelectedTimer().setMovey(drwpnl.getLeaderTimer().getMovey());
	    			//start timer
	    			drwpnl.getSelectedTimer().start();
	    			//add to following drones
	    			drwpnl.followingDrones.add(this);
	    			display();
	                break;
	                
	            case "Move Randomly":
	                // Implement random move logic
	            	//get random values
	            	int randx = (int)(Math.random()*10+1);
	            	int randy = (int)(Math.random()*10+1);
	            	int randxlocation = (int)(Math.random()*500);
	            	int randylocation = (int)(Math.random()*500);
	            	current = drwpnl.getSelected();
	            	//change location
	            	current.setx(randxlocation);
	            	current.sety(randylocation);
	            	//change move amount
	            	drwpnl.getSelectedTimer().setMovex(randx);
	            	drwpnl.getSelectedTimer().setMovey(randy);
	            	//start timer
	            	drwpnl.getSelectedTimer().start();
	            	display();
	                break;
	            
	            default:
	            case "Do Nothing":
	            	//stop the selected drones timer
	                drwpnl.getSelectedTimer().stop();
	                display();
	                break;
	        }
	    }
	  
	  //display message
	  public void display() {
		  System.out.println(actionHolder.getAction() + " clicked.");
		  System.out.println("Moving at rate: x- " + drwpnl.getMovex() + "  y- " + drwpnl.getMovey());
		  System.out.println("Set to Location: (" + getx() + ", " + gety()+ ")\n");
	  }
	
	  /*
	   * handling the mouse click and other mouse listener methods
	   */
	   @Override
	    public void mouseClicked(MouseEvent e) {
	        if (body.contains(e.getPoint()) || fwing.contains(e.getPoint()) || rwing.contains(e.getPoint())) {
	            System.out.println("Drone clicked");
	            drwpnl.setSelected(this);
	            Drone clicked = drwpnl.getSelected();
	            clicked.performAction(actionHolder);
	        }
	    }

	    @Override
	    public void mousePressed(MouseEvent e) {}

	    @Override
	    public void mouseReleased(MouseEvent e) {}

	    @Override
	    public void mouseEntered(MouseEvent e) {}

	    @Override
	    public void mouseExited(MouseEvent e) {}
	    
}//end drone class




