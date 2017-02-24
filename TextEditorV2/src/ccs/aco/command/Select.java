package ccs.aco.command;

import ccs.aco.engine.buffer;
/**
 * This is the class select command which is implements 
 * the command interface
 * @author royd1990
 *
 */

public class Select implements Command {

	private buffer b;
	private int start;
	private int stop;
	/**
	 * This constructs the Select command with the buffer
	 * @param b  This is a parameter of type buffer
	 * @param start	This is an integer parameter determining start position
	 * @param stop	This is an integer parameter determining end position
	 */
	public Select(buffer b, int start, int stop){
		this.b = b;
		this.start = start;
		this.stop = stop;
	}
	/**
	 * This method calls the implements the execute command
	 * of the command interface. (Refer to Command Design Pattern)
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		b.setSelection(start, stop);

	}


}
