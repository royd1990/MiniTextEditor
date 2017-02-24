package ccs.aco.editor.engine;
/**
 * This is command interface which is implemented
 * by individual commands Select, Insert, Cut, Copy, Paste
 * @author royd1990
 *
 */
public interface Command {
	/**
	 * This method is implemented by all the methods
	 */
	public void execute();


}
