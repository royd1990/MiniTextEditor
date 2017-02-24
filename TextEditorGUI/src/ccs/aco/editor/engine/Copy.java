package ccs.aco.editor.engine;


/**
 * This class represents a copy command in a text editor
 * @author Debaditya
 * @version 1.0
 */
public class Copy implements  Command {

	private buffer b;
	/**
	 * This constucts the Copy command with the buffer
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
