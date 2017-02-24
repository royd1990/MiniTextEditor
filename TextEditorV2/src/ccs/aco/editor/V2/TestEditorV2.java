package ccs.aco.editor.V2;

import java.util.Collection;
import java.util.LinkedList;
import java.util.ListIterator;

import ccs.aco.command.*;
import ccs.aco.editor.MiniEditor;
import ccs.aco.engine.buffer;

/**
 * This is a Version 2 text editor
 * class implementing
 * the MiniEditor interface
 * @author royd1990
 *
 */
public class TestEditorV2 implements MiniEditor{
	
	buffer b = new buffer(null,0);
	Invoker onPressed;
	boolean recordFlag = false;
	Collection<Command> storeCommand;
	
	LinkedList<Command> list = new  LinkedList<Command>();
	
	@Override
	public String getBuffer() {
		return b.getB();
	}

	@Override
	public String getSelection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getClipboard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editorInsert(String substring) {
		Command bufferinsert = new Insert(b,substring);
		onPressed = new Invoker(bufferinsert);
		onPressed.press();
		
		if(recordFlag == true)
		{
			list.add(bufferinsert);
		}
	}

	@Override
	public void editorSelect(int start, int stop) {
		Select bufferselect = new Select(b,start,stop);
		onPressed = new Invoker(bufferselect);
		onPressed.press();
		
		if(recordFlag == true)
		{
			list.add(bufferselect);
		}
		
	}

	@Override
	public void editorCopy() {
		Copy buffercopy = new Copy(b);
		onPressed = new Invoker(buffercopy);
		onPressed.press();
		
		if(recordFlag == true)
		{
			list.add(buffercopy);
		}
	}

	@Override
	public void editorCut() {
		Cut buffercut = new Cut(b);
		onPressed = new Invoker(buffercut);
		onPressed.press();
		
		if(recordFlag==true)
		{
			list.add(buffercut);
		}
	}

	@Override
	public void editorPaste() {
		Paste bufferpaste = new Paste(b);
		onPressed = new Invoker(bufferpaste);
		onPressed.press();
		
		if(recordFlag==true)
		{
			list.add(bufferpaste);
		}
	}

	@Override
	public void editorStartRecording() {
		recordFlag = true;
		
	}

	@Override
	public void editorEndRecording() {
		recordFlag = false;
		
	}

	@Override
	public void editorPlayRecording() {
		ListIterator<Command> listIterator = list.listIterator();
		while(listIterator.hasNext())
		{
			onPressed = new Invoker(listIterator.next());
			onPressed.press();
		}
		
	}

	@Override
	public void editorUndo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editorRedo() {
		// TODO Auto-generated method stub
		
	}

}
