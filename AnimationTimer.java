/*
 * sam woodburn
 * 12/10/23
 * SER120- extra credit
 * 
 * animation timer class- extends timer
 * 		adds an action listener to the timer in order to move the drone
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class AnimationTimer extends Timer {
	//variables
	private DrawingPanel drwpnl;
	private Drone drone;
	private int movex, movey;
	
	//constructor with move parameters
	public AnimationTimer(DrawingPanel drwpnl, Drone drone, int movex, int movey) {
		//initialize panel
		super(80,null);
		this.drwpnl = drwpnl;
		this.drone = drone;
		this.movex = movex;
		this.movey = movey;
		
		//add action listener
		this.addActionListener(new MoveListener());
	}
	//constructor with default move values
	public AnimationTimer(DrawingPanel drwpnl, Drone drone) {
		//initialize panel
		super(100,null);
		this.drwpnl = drwpnl;
		this.drone = drone;
		this.movex = 0;
		this.movey = 0;
		
		//add action listener
		this.addActionListener(new MoveListener());
	}
	
	
	/*
	 * move listener implements action listener
	 * 		moves the drone and repaints the drawing panel
	 */
	private class MoveListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			drwpnl.move();
			drone.move(movex, movey);
		}
	}


	//getter setter move x
	public int getMovex() {
		return movex;
	}
	public void setMovex(int movex) {
		this.movex = movex;
	}

	//getter setter move y
	public int getMovey() {
		return movey;
	}
	public void setMovey(int movey) {
		this.movey = movey;
	}
	
}// end animation timer class



