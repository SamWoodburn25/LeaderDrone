/*
 * sam woodburn
 * 12/10/23
 * SER120- extra credit
 * 
 * action holder class
 * 		takes an action as a string and holds it, with getter setters
 */


public class ActionHolder {
	//action variable
	private String action;
	
	//constructor
	public ActionHolder(String action) {
		this.action = action;
	}

	//getter and setter
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
}





