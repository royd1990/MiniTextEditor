package ccs.aco.test;

import static org.junit.Assert.*;

import org.junit.*;

import ccs.aco.editor.MiniEditor;
import ccs.aco.editor.V3.TextEditorV3;
import ccs.aco.engine.buffer;

public class testBuffer {
	
	private buffer b;
	private MiniEditor engine;

	@Before
	public void initBuffer(){
		b = new buffer(null,0);
		engine = new TextEditorV3();
	}
	
	@Test
	public void testUndo(){
		int length1;
		//int length2;
		String toTest1 = "Test";
		String toTest2 = "Test 2";

		
		engine.editorInsert(toTest1);
		length1 = engine.getBuffer().length();
		engine.editorInsert(toTest2);
		engine.editorUndo();
		assertTrue(length1 == (engine.getBuffer().length()));
	}
	

	@Test
	public void testRedo() {
		int length1;
		String toTest1 = "Test1";
		String toTest2 = "Test2";
		String toTest3 = "Test3";
		
		engine.editorInsert(toTest1);
		engine.editorInsert(toTest2);
		length1 = engine.getBuffer().length();
		engine.editorInsert(toTest3);
		engine.editorUndo();
		engine.editorRedo();
		assertTrue(length1 == (engine.getBuffer().length()));
		
		
				
	}

}
