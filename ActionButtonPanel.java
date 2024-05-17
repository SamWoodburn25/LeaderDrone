/*
 * sam woodburn
 * 12/10/23
 * SER120- extra credit
 * 
 * action button panel class - extends JPanel
 * 		creates 3 JRadioButtons and adds it to the panel
 */

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ActionButtonPanel extends JPanel {
	//variables
	private JRadioButton follow, random, nothing;
	private ButtonGroup bttngrp;
	private ActionHolder actionHolder;
	
	//constructor
	public ActionButtonPanel(DrawingPanel drwpnl, ActionHolder actionHolder) {
		//initialize panel
		super(new GridLayout(1,3));
		this.setPreferredSize(new Dimension(500, 50));
		this.actionHolder = actionHolder;
		//initialize button group
		bttngrp = new ButtonGroup();
		
		//make buttons and add action listener
		nothing = new JRadioButton("Do Nothing");
		nothing.setSelected(true);
		nothing.addActionListener(new ButtonListener(nothing.getText()));
		
		random = new JRadioButton("Move Randomly");
		random.addActionListener(new ButtonListener(random.getText()));
		
		follow = new JRadioButton("Follow Leader");
		follow.addActionListener(new ButtonListener(follow.getText()));
		
		//add to button group
		bttngrp.add(nothing);
		bttngrp.add(random);
		bttngrp.add(follow);

		//add buttons to panel
		this.add(nothing);
		this.add(random);
		this.add(follow);
	}// end constructor
	
	
	
	/*
	 * button listener class- extends action listener
	 * 		sets the action holder to the current buttons text
	 */
	public class ButtonListener implements ActionListener{
		private String action;
		public ButtonListener(String action) {
			this.action = action;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			actionHolder.setAction(action);
		}
		
	}// end button listener
}// end action button panel
