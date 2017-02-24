package ccs.aco.editor;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ccs.aco.editor.V2.*;



public class MiniEditorTextInterface {

	/**
	 * @param args
	 */
	static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) {	
		// TODO Auto-generated method stub
		MiniEditor miniEditor = new TestEditorV2() ;
		String inputLine;
		char commandLetter;
		
		System.out.println("Welcome to MiniEditor 9.99 (c) 2015 EIT Digital Rennes") ;
		System.out.println("-----------------------------------------------------------") ;
				
		System.out.println("Enter command (I/S/C/X/V/D/R/E/P/Z/Y/Q) > ") ;
		try
		{
			inputLine = keyboard.readLine();
		} catch (IOException e)
		{
			System.out.println("Unable to read standard input");
			inputLine = "W";
		} 
		commandLetter = Character.toUpperCase(inputLine.charAt(0)) ;
		while (commandLetter != 'Q') /* Quit */
		{
			switch (commandLetter)
			{
				case 'I': /* Insert */
					if(inputLine.length()==1){miniEditor.editorInsert(inputLine.substring(1));}
					else{miniEditor.editorInsert(inputLine.substring(2));}
					break;
				case 'S': /* Select */
					String numberString="";
					try
					{
						String[] arguments = inputLine.substring(2).split("\\s+");
						numberString = arguments[0];
						int start  = Integer.parseInt(numberString);
						numberString = arguments[1];
						int stop  = Integer.parseInt(numberString);
						miniEditor.editorSelect(start, stop);
					}
					catch (Exception e)
					{
						System.out.println("Invalid number: " + numberString);
					}
					break;
				case 'C': /* Copy */
					miniEditor.editorCopy();
					break;
				case 'X': /* cut */
					miniEditor.editorCut();
					break;
				case 'V': /* paste */
					miniEditor.editorPaste();
					break;
				case 'D': /* Delete, i.e. insert empty string */
					miniEditor.editorInsert("");
					break;
				case 'R': /* start Recording */
						miniEditor.editorStartRecording();
					break;
				case 'E': /* End recording */
					miniEditor.editorEndRecording();
					break;
				case 'P': /* Play recording */
					miniEditor.editorPlayRecording();
					break;
				case 'Z': /* undo */
					miniEditor.editorUndo();
					break;
				case 'Y': /* redo */
					miniEditor.editorRedo();
					break;
				default: System.out.println("Unrecognized command, please try again:") ;
					break;
			}
			System.out.println("-----------------------------------------------------");
			System.out.println("[" + miniEditor.getBuffer() + "]");
			System.out.println("-----------------------------------------------------");
			System.out.println("[" + miniEditor.getSelection() + "]");
			System.out.println("-----------------------------------------------------");
			System.out.println("[" + miniEditor.getClipboard() + "]");
			System.out.println("-----------------------------------------------------");

			System.out.println("Enter command (I/S/C/X/V/D/R/E/P/Z/Y/Q) > ") ;	
			try
			{
				inputLine = keyboard.readLine();
			} catch (IOException e)
			{
				System.out.println("Unable to read standard input");
				inputLine = "W";
			} 
			commandLetter = Character.toUpperCase(inputLine.charAt(0)) ;
		}
		System.out.println ("Goodbye") ;
	}

}
