package ccs.aco.editor.testCase;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ccs.aco.engine.Clipboard;
import ccs.aco.engine.buffer;

public class bufferTest {
	private buffer b;
	
	
	@Before
	public void initBuffer(){
		b = new buffer(null, 0);
	}
	
	@Test
	public void testInit(){
		assertEquals((b.getB()),null);
	}
	@Test
	public void testAddChar() {
		String toAdd = "a";
		b.bufferInsert(toAdd);
		assertEquals(b.getB().length(),1);
	}
	
	@Test
	public void testCopy(){
		String toCopy = "XYZ";
		b.bufferInsert(toCopy);
		b.setSelection(0, toCopy.length());
		b.copy();
		assertEquals(b.getB(),b.getC());
	}
	
	@Test
	public void testNoSelCopy(){
		String toCopy = "To Copy";
		b.bufferInsert(toCopy);
		b.copy();
		assertEquals(b.getC(),null);
	}
	
	@Test
	public void testCut(){
		int length1;
		String toCut = "To Cut";
		b.bufferInsert(toCut);
		length1 = b.getB().length();
		b.setSelection(0, 3);
		b.cut();
		assertTrue(length1>(b.getB().length()));
	}
}
