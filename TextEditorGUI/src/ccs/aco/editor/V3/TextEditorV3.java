package ccs.aco.editor.V3;


import java.util.LinkedList;
import java.util.ListIterator;


import ccs.aco.editor.MiniEditor;
import ccs.aco.editor.engine.Command;
import ccs.aco.editor.engine.Copy;
import ccs.aco.editor.engine.Cut;
import ccs.aco.editor.engine.Insert;
import ccs.aco.editor.engine.Paste;
import ccs.aco.editor.engine.Select;
import ccs.aco.editor.engine.buffer;
/**
 * This is a Version 3 text editor
 * class implementing
 * the MiniEditor interface
 * @author royd1990
 *
 */
public class TextEditorV3 implements MiniEditor {

	buffer b = new buffer(null,0);
	Invoker onPressed;
	boolean recordFlag = false;
//	Collection<Command> storeCommand;
	
	LinkedList<Command> list = new  LinkedList<Command>();
	Caretaker caretaker = new Caretaker();
	Originator originator = new Originator();
	
	int saveFiles = 0, currentArticle = 0;
	
	@Override
	public String getBuffer() {
		return b.getB();
	}

	@Override
	public String getSelection() {
		// TODO Auto-generated method stub
		return b.getSelection();
	}

	@Override
	public String getClipboard() {
		return b.getC();// TODO Auto-generated method stub
		
	}

	@Override
	public void editorInsert(String substring) {
		Insert bufferinsert = new Insert(b,substring);
		onPressed = new Invoker(bufferinsert);
		onPressed.press();
		
		originator.set(b.getB(),b.getCaret());
		caretaker.addMemento( originator.storeInMemento());
		saveFiles++;
		currentArticle++;
		
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
		
		originator.set(b.getB(),b.getCaret());
		caretaker.addMemento( originator.storeInMemento());
		saveFiles++;
		currentArticle++;

		
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
		
		originator.set(b.getB(),b.getCaret());
		caretaker.addMemento( originator.storeInMemento());
		saveFiles++;
		currentArticle++;

		
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
		//	this.getBuffer();
		}
		
	}

	@Override
	public void editorUndo() {
		if(currentArticle >= 1){			
		// Decrement to the current article 
			currentArticle--;			
		// Get the older article saved and display it 
			buffer newBuffer = originator.returnFromMemento(caretaker.getMemento(currentArticle));
			b = newBuffer;
		}
	}

	@Override
	public void editorRedo() {
		
		if((saveFiles - 1) > currentArticle){
			currentArticle++;
			buffer newBuffer = originator.returnFromMemento( caretaker.getMemento(currentArticle));
			b = newBuffer;
		}

		
	}


}
