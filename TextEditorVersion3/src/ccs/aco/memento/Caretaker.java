package ccs.aco.memento;
import java.util.ArrayList;

import ccs.aco.engine.*;
/**
 * 
 * @author royd1990
 *
 */
public class Caretaker {
	ArrayList<buffer> savedBuffer = new ArrayList<buffer>();	
	/**
	 * 
	 * @param b This is the buffer parameter passed as a parameter to the addMemento function.
	 */
	public void addMemento(buffer b) { savedBuffer.add(b); }	
	/**
	 * 
	 * @param index Integer parameter determining the position from where to get the current buffer
	 * @return buffer returns the buffer object
	 */
	public buffer getMemento(int index) { return savedBuffer.get(index); }

}
