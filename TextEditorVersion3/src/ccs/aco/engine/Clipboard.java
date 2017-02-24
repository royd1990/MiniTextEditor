package ccs.aco.engine;
/**
 * This a clipboard class which
 * holds the value of a string 
 * board
 * @author royd1990
 *
 */
public class Clipboard {

	private String board;
	
	/**
	 * This method returns the current value of
	 * the board
	 * @return Return a clipboard object
	 */
	public String getBoard() {
		return board;
	}
	/**
	 * This method sets the clipboard with
	 * a string
	 * @param board String variable passed in a clipboard
	 */
	public void setBoard(String board) {
		this.board = board;
		System.out.println(board);
	}
	
}
