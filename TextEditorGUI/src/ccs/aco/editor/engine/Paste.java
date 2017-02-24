package ccs.aco.editor.engine;
/**
 * This class represents a paste 
 * command in the text editor
 * @author royd1990
 * @version 1.0
 */

public class Paste implements Command {

	private buffer b;
	/**
	 * This constructs the Paste command with the buffer
	 * @param b
	 */
	public Paste(buffer b){
		this.b = b;
	}
	/**
	 * This method calls the implements the execute command
	 * of the command interface. (Refer to Command Design Pattern)
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		b.paste();

	}



}
