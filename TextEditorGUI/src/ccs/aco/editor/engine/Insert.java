package ccs.aco.editor.engine;
/**
 * This class represents the insert command in a
 * text editor
 * @author royd1990
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
