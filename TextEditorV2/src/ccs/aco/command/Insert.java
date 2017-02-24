package ccs.aco.command;

import ccs.aco.engine.buffer;

/**
 * This class represents the insert command in a
 * text editor
 * 
 *
 */

public class Insert implements Command {

	private buffer b;
	private String substring;
	/**
	 * This constructs the Insert command with the buffer
	 * @param b the buffer in which the string is to be inserted
	 * @param substring the string which is to be inserted in the buffer
	 */
	public Insert(buffer b, String substring){
		this.b = b;
		this.substring = substring;
	}
	/**
	 * This method calls the implements the execute command
	 * of the command interface. (Refer to Command Design Pattern)
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		b.bufferInsert(substring);

	}


}
