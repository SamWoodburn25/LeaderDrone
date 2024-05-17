/*
 * sam woodburn
 * 12/10/23
 * SER120- extra credit
 * 
 * app class- extends JFrame
 * 		extend JFrame, adds the drawing panel and action button panel, initializes the holder
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class App extends JFrame{
	//variables
	private DrawingPanel drwpnl;
	private ActionButtonPanel actionpnl;
	private ActionHolder actionHolder;
	
	//constructor
	public App() {
		//initialize frame
		super("Flying Christmas Drones");
		this.setPreferredSize(new Dimension(500,500));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//initialize action holder
		actionHolder = new ActionHolder("nothing");  //default
		
		//make drawing panel and add it
		drwpnl = new DrawingPanel(actionHolder);
		this.add(drwpnl, BorderLayout.CENTER);
		
		//make action button panel and add it
		actionpnl = new ActionButtonPanel(drwpnl, actionHolder);
		this.add(actionpnl, BorderLayout.SOUTH);
		
		this.pack();
		this.setVisible(true);
	}// end constructor
	
	//main method
	public static void main(String[] args) {
		//introduction box
		int input = JOptionPane.showConfirmDialog(null, "Select an action then a drone to perform it! \nReady to start?", "Welcome To Christmas Drones!", JOptionPane.YES_NO_OPTION);
		//if yes selected start program, if no exit
		if (input == JOptionPane.YES_OPTION) {
			new App();
		}
		else {
			System.exit(0);
		}
	}//end main

}// end app class
