/*
 * sam woodburn
 * 12/10/23
 * SER120- extra credit
 * 
 * Drawing panel class- extends JPanel
 * 		makes a leader drone and 3 follower drones and draws them on the panel
 */


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class DrawingPanel extends JPanel{
	//variables
	protected Drone leaderDrone; 
	protected ArrayList<Drone> followingDrones;
	private Drone folDrone1, folDrone2, folDrone3, selected;
	private AnimationTimer timer, f1Timer, f2Timer, f3Timer;
	private int movex, movey;
	
	//constructor
	public DrawingPanel(ActionHolder actionHolder) {
		//initialize panel
		super();
		this.setPreferredSize(new Dimension(500,500));
		
		//initialize array
		followingDrones = new ArrayList<Drone>();
		
		//initialize Christmas colors
		Color red = new Color(229, 25, 66);
		Color lightGreen = new Color(34, 115, 47);
		Color lighterGreen = new Color(100, 145, 107);
		Color green = new Color(5, 75, 17);
		
		//make drones and set there colors
		leaderDrone = new Drone(200,100,45,35, this, actionHolder);
		leaderDrone.setBodyColor(red);   
		leaderDrone.setWingColor(Color.white);
		leaderDrone.fwing.setBorderColor(red);
		leaderDrone.rwing.setBorderColor(red);
		
		folDrone1 = new Drone(50, 200, 30, 20, this, actionHolder);
		folDrone1.setBodyColor(green);   
		folDrone1.setWingColor(red);
		folDrone1.fwing.setBorderColor(green);
		folDrone1.rwing.setBorderColor(green);
		
		folDrone2 = new Drone(200, 200, 30, 20, this, actionHolder);
		folDrone2.setBodyColor(lightGreen);   
		folDrone2.setWingColor(red);
		folDrone2.fwing.setBorderColor(green);
		folDrone2.rwing.setBorderColor(green);
		
		folDrone3 = new Drone(350, 200, 30, 20, this, actionHolder);
		folDrone3.setBodyColor(lighterGreen);   
		folDrone3.setWingColor(red);
		folDrone3.fwing.setBorderColor(green);
		folDrone3.rwing.setBorderColor(green);

		
		//leader begins moving in a straight line across the screen
		movex = 5;
		movey = 0;
		timer = new AnimationTimer(this, leaderDrone, movex, movey);
		timer.start();
		
		//other drone timers, begin not moving
		f1Timer = new AnimationTimer(this, folDrone1);
		f2Timer = new AnimationTimer(this, folDrone2);
		f3Timer = new AnimationTimer(this, folDrone3);
		
		//set selected drone
		selected = getSelected();
		
	}//end constructor
	
	
	//getter and setter for move x and y
	public void setMovex(int movex) {
		this.movex = movex;
	}
	public int getMovex() {
		return this.movex;
	}
	public void setMovey(int movey) {
		this.movey = movey;
	}
	public int getMovey() {
		return this.movey;
	}
	
	//getter and setter selected drone
	public void setSelected(Drone drone) {
		selected = drone;
	}
	public Drone getSelected() {
		return selected;
	}
	
	//get the selected drones timer
	public AnimationTimer getSelectedTimer() {
		if(selected == leaderDrone) {
			return timer;
		}
		else if(selected == folDrone1) {
			return f1Timer;
		}
		else if(selected == folDrone2) {
			return f2Timer;
		}
		else {
			return f3Timer;
		}
	}
	
	//get the leader timer (for the follow leader action)
	public AnimationTimer getLeaderTimer() {
		return timer;
	}
	
	//move method
	public void move() {
		repaint();
	}
	
	//paint
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D brush = (Graphics2D)g;
		//draw and fill the drones to appear on panel
		leaderDrone.draw(brush);
		leaderDrone.fill(brush);
		
		folDrone1.draw(brush);
		folDrone1.fill(brush);
		
		folDrone2.draw(brush);
		folDrone2.fill(brush);
		
		folDrone3.draw(brush);
		folDrone3.fill(brush);
	}

}//end Drawing Panel



