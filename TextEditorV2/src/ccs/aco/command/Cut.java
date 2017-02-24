package ccs.aco.command;

import ccs.aco.engine.buffer;

/**
 * This class represents the cut command in a
 * text editor
 * @author royd1990
 * 
 */


public class Cut implements Command {

	private buffer b;
	/**
	 * This constructs the Cut command with the buffer
	 * @param b  the buffer on which the operation is to be performed
	 */
	public Cut(buffer b){
		this.b = b;
	}
	@Override
	/**
	 * This method calls the implements the execute command
	 * of the command interface. (Refer to Command Design Pattern)
	 */
	public void execute() {
		// TODO Auto-generated method stub
		b.cut();

	}



}
