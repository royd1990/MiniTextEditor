package ccs.aco.editor.V3;

import ccs.aco.editor.engine.Command;

/**
 * This is an invoker object
 * which is used to abstract the commands
 * from the client to the receiver
 * @author royd1990
 * @version 1.0
 */

public class Invoker {
	Command theCommand;
	/**
	 * This constructs an invoker object with
	 * a command coming from the client
	 * @param newCommand
	 */
	public Invoker(Command newCommand){
		theCommand = newCommand;
	}
	/**
	 * This method calls the execute method 
	 * of the command
	 */
	public void press()
	{
		theCommand.execute();
	}
	

}
