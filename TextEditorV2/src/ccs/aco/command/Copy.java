package ccs.aco.command;

import ccs.aco.engine.buffer;


/**
 * This class represents a copy command in a text editor
 * @author Debaditya
 * 
 */
public class Copy implements  Command {

	private buffer b;
	/**
	 * This constructs the Copy command with the buffer
	 * @param b the buffer on which the operation is to be performed
	 */
	public Copy(buffer b){
		this.b = b;
	}
	@Override
	/**
	 * This method calls the implements the execute command
	 * of the command interface. (Refer to Command Design Pattern)
	 */
	public void execute() {
		// TODO Auto-generated method stub
		b.copy();

	}



}
