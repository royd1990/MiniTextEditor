package ccs.aco.editor;
/**
 * This interface defines all the functions
 * that is done by the text editor independent
 * of the buffer
 * @author royd1990
 * 
 */
public interface MiniEditor {
	/**
	 * This method returns the buffer string
	 * @return String of buffer
	 */
	public String getBuffer();
	/**
	 * This method returns the selection string
	 * @return String of selection
	 */
	public String getSelection();
	/**
	 * This method returns the Clipboard string
	 * @return String of Clipboard
	 */
	public String getClipboard();
	/**
	 * This method inserts the string
	 * inserted by the user
	 * @param substring
	 */
	public void editorInsert(String substring);
	/**
	 * This method selects the string from
	 * start and stop position inserted by the user
	 * @param start Start position of the selection
	 * @param stop  End position of the selection
	 */
	public void editorSelect(int start, int stop);
	/**
	 * This method is used for copy operation
	 * as demanded by the user of the editor
	 */
	public void editorCopy();
	/**
	 * This method is used for cut operation
	 * as demanded by the user of the editor
	 */
	public void editorCut();
	/**
	 * This method is used for paster operation
	 * as demanded by the user of the editor
	 */
	public void editorPaste();
	/**
	 * This method is used in version 2 of 
	 * the text editor to start recording of
	 * all the commands provided by the user
	 */
	public void editorStartRecording();
	/**
	 * This method is used in version 2 of 
	 * the text editor to stop recording of
	 * all the commands provided by the user
	 */
	public void editorEndRecording();
	/**
	 * This method is used in version 2 of 
	 * the text editor to play recording of
	 * all the commands provided by the user
	 */
	public void editorPlayRecording();
	/**
	 * This method is used in Version 3 of the 
	 * text editor for the undo operation
	 */
	public void editorUndo();
	/**
	 * This method is used in Version 3 of the text
	 * editor for the redo operation
	 */
	public void editorRedo();

}
