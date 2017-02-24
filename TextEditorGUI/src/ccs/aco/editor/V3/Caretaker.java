package ccs.aco.editor.V3;
import java.util.ArrayList;

import ccs.aco.editor.engine.buffer;
/**
 * 
 * @author royd1990
 *
 */
public class Caretaker {
	ArrayList<buffer> savedBuffer = new ArrayList<buffer>();	
	/**
	 * 
	 * @param b
	 */
	public void addMemento(buffer b) { savedBuffer.add(b); }	
	/**
	 * 
	 * @param index
	 * @return buffer returns the buffer object
	 */
	public buffer getMemento(int index) { return savedBuffer.get(index); }

}
