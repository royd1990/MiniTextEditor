package ccs.aco.memento;

import ccs.aco.engine.*;

/**
 * This method stores the state of a buffer
 * and fetches a value of the state of the buffer
 * @author royd1990
 * @version 1.0
 */

public class Originator {
	private String bufferString;
	private int caret;
	/**
	 * 
	 * @param bufferString This a string type parameter which essentially is the string we want to insert
	 * @param caret		   This integer parameter determines the postion of the caret in the buffer.
	 */
	public void set(String bufferString, int caret){
		this.bufferString = bufferString;
		this.caret = caret;
	}
	/**
	 * 
	 * @return Returns the state of buffer
	 */
	public buffer storeInMemento(){

		return new buffer(bufferString,caret);
		
	}
	/**
	 * 
	 * @param b Pass the buffer
	 * @return  Return the state of the buffer
	 */
	public buffer returnFromMemento(buffer b){
		bufferString = b.getB();
		caret = b.getCaret();
		
		return new buffer(bufferString,caret);
	}

}
