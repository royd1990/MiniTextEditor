package ccs.aco.editor.V1;

import ccs.aco.editor.MiniEditor;
import ccs.aco.engine.buffer;



public class EngineV1 implements MiniEditor {
	buffer b = new buffer(null, 0);
	@Override
	public String getBuffer()
	{	
		return b.getB();
	}

	@Override
	public String getSelection()
	{
		return b.getSelection();
	}

	@Override
	public String getClipboard()
	{
		return b.getC();
	}

	@Override
	public void editorInsert(String substring)
	{
		System.out.println("DEBUG: inserting text [" + substring + "]");
		b.bufferInsert(substring);
	}

	@Override
	public void editorSelect(int start, int stop)
	{
		System.out.println("DEBUG: selecting interval [" + start + "," + stop + "]");
		b.setSelection(start, stop);
	}

	@Override
	public void editorCopy()
	{
		System.out.println("DEBUG: performing Copy") ;
		b.copy();
	}

	@Override
	public void editorCut() 
	{
		System.out.println("DEBUG: performing Cut") ;
		b.cut();
	}

	@Override
	public void editorPaste()
	{
		System.out.println("DEBUG: performing Paste") ;
		b.paste();
	}

	@Override
	public void editorStartRecording()
	{
		System.out.println("DEBUG: performing Record start") ;
	}

	@Override
	public void editorEndRecording()
	{
		System.out.println("DEBUG: performing Record end") ;
	}

	@Override
	public void editorPlayRecording()
	{
		System.out.println("DEBUG: performing Play") ;
	}

	@Override
	public void editorUndo()
	{
		System.out.println("DEBUG: performing Undo") ;
	}

	@Override
	public void editorRedo()
	{
		System.out.println("DEBUG: performing Redo") ;
	}

}
