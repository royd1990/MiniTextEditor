package ccs.aco.editor.V3;

import ccs.aco.editor.engine.buffer;

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
	 * @param bufferString
	 * @param caret
	 */
	public void set(String bufferString, int caret){
		this.bufferString = bufferString;
		this.caret = caret;
	}
	/**
	 * 
	 * @return
	 */
	public buffer storeInMemento(){

		return new buffer(bufferString,caret);
		
	}
	/**
	 * 
	 * @param b Pass the buffer
	 * @return
	 */
	public buffer returnFromMemento(buffer b){
		bufferString = b.getB();
		caret = b.getCaret();
		
		return new buffer(bufferString,caret);
	}

}
