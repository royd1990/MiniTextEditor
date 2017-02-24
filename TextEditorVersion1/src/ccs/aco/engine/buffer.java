package ccs.aco.engine;

/**
 * This the buffer class where
 * all the functional logic is 
 * written
 * @author royd1990
 * @version 1.0
 */

public class buffer {
	//private String read;
	private String b;
	private int caret = 0;
	private String selection;
	private Clipboard c = new Clipboard();
	private int selStart = 0;
	private int selStop = 0;
	
	/**
	 * This method constructs the buffer with string
	 * and a integer variable for caret
	 * @param a String parameter defining the string in the buffer
	 * @param x Integer parameter defining the caret position in the buffer
	 */
	public buffer(String a, int x)
	{
		b = a;
		caret = x;
		
	}
	/**
	 * This method returns the buffer object
	 * @return A buffer object type which is returned
	 */
	public buffer returnBuffer(){
		return this;
	}
	/**
	 * This method returns the string stored 
	 * in the buffer
	 * @return A string variable which returns the buffer string
	 */
	public String getB() {
		return b;
	}
	/**
	 * This method stores a string in the buffer string
	 * @param b A string variable which sets the buffer string
	 */

	public void setB(String b) {
		this.b = b;
	}
	/**
	 * This method returns the caret/position
	 * of the buffer
	 * @return intefer variable denoting position
	 */
	public int getCaret() {
		return caret;
	}

	public void setCaret(int caret) {
		this.caret = caret;
	}
	/**
	 * This method inserts a string in the buffer
	 * which is entered in the editor
	 * @param substring 
	 * 
	 */
	public void bufferInsert(String substring){
		if(substring.length()!=0){
			if(caret==0)
			{
				b = substring;
				caret = b.length()+1;
			}
			else{
				if(caret==b.length()+1){
					b=b.concat(substring);
					caret=b.length()+1;
				}
				else{
					if(selStop!=0){
						this.cutSpecial();
						this.bufferInsert(substring);
		    		 
					}
					else{
						String s1 = b.substring(0, caret);
						String s2 = b.substring(caret);
						s1 = s1.concat(substring);
						s1 = s1.concat(s2);
						b=s1;
						caret = caret + substring.length(); 
					}
				} 
			}
	   }
	   else{
		   this.delete();
	   }
	   selStart = 0;
	   selStop = 0;
	   selection=null;

	}
	/**
	 * This returns the value
	 * of the selected string
	 * @return selection returns the selection text
	 */
	
	public String getSelection() {
		return selection;
	}
	/**
	 * This method selects the string
	 * selected by the user
	 * @param start An integer variable indicating the start position
	 * @param stop	An integer variable indicating the end position
	 */
	public void setSelection(int start,int stop) {					//No need of selection texts for the buffer
		if(stop!=0){
			this.selStart = start;
			this.selStop = stop;
			this.selection = b.substring(selStart, selStop);
			caret = selStart;
		}
	}
	
	/**
	 * This method returns the clipboard string
	 * @return A Clipboard string is returned
	 */
	public String getC() {
		return c.getBoard();
	}
	/**
	 * This method helps us to set the clipboard 
	 * @param c A clipboard object used to set the clipboard object
	 * 
	 */
	public void setC(Clipboard c) {
		this.c = c;
	}
	/**
	 * This method is used for copy operation
	 * done by the user in the editor
	 */
	
	public void copy(){
		if(selection!=null){
			c.setBoard(selection);
		}
		selection=null;
		
	}
	/**
	 * This method is used for cut operation
	 * done by the user in the editor
	 */
	public void cut(){
		if(selection!=null){
			c.setBoard(selection);
			String s1 = b.substring(0,selStart);
			String s2 = b.substring(selStop, b.length());
			b = s1.concat(s2);
			caret = selStart;		
			selStart = 0;
			selStop = 0;
			selection=null;
		}
	}
	/**
	 * This method is used for the paste operation
	 * done by the user in the editor
	 */
	public void paste(){
		if(c.getBoard()!=null){
			this.bufferInsert(c.getBoard());
			selStart = 0;
			selStop = 0;
			selection=null;
		}
	}
	
	/**
	 * This method is used internally by the 
	 * buffer class to handle the delete operation.
	 */
	private void delete(){
		if(selStop!=0){
			this.cutSpecial();
		}
		else{
			if(caret==(b.length()+1)){
				b=b.substring(0, caret-2);
				caret = caret -1;
			}
			else{
				String s1 = b.substring(0,caret);
				String s2 = b.substring(caret+1, b.length());
				b = s1.concat(s2);
				caret = caret -1;
			}
			
		}
	}
	/**
	 * This method is used internally by the buffer class
	 */
	private void cutSpecial(){
		String s1 = b.substring(0,selStart);
		String s2 = b.substring(selStop, b.length());
		b = s1.concat(s2);
		caret = selStart;
		selStart = 0;
		selStop = 0;
	}

}
