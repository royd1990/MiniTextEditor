package ccs.aco.editor.engine;


public class Select implements Command {

	private buffer b;
	private int start;
	private int stop;
	/**
	 * This constructs the Select command with the buffer
	 * @param b
	 * @param start
	 * @param stop
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
