package ccs.aco.editor.GUI;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;


import java.io.*;

import javax.swing.*;

import ccs.aco.editor.MiniEditor;
//import ccs.aco.editor.V1.engine.EngineV1;
import ccs.aco.editor.V3.TextEditorV3;

/**
 * This is a Version 3 text editor
 * class(with graphical user interface)
 * implementing the MiniEditor interface
 * @author royd1990
 *
 */

public class MiniEditorTextInterface extends JFrame{

	/**
	 * @param args
	 */
	static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) {	
		new MiniEditorTextInterface();
	}
	
	private JButton insert,select,cut,copy,paste,startRecord,endRecord,playRecord,undo,redo,load, save;
	private JTextArea theBuffer = new JTextArea(40,60);
	private MiniEditor miniEditor = new TextEditorV3() ;
	private JFileChooser fc = new JFileChooser();
	
	public MiniEditorTextInterface(){
		this.setSize(750,780);
		this.setTitle("Welcome to MiniEditor 9.99 (c) 2015 EIT Digital Rennes");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel1 = new JPanel();
		
		panel1.add(new JLabel("Write text"));
		panel1.add(theBuffer);
		
	//	ButtonListener insertButton = new ButtonListener();
	//	insert = new JButton("Insert");
	//	insert.addActionListener(insertButton);
	//	panel1.add(insert);
		
		ButtonListener selectButton = new ButtonListener();
		select = new JButton("Select");
		select.addActionListener(selectButton);
		panel1.add(select);
		
		ButtonListener cutButton = new ButtonListener();
		cut = new JButton("Cut");
		cut.addActionListener(cutButton);			
		panel1.add(cut);
		
		ButtonListener copyButton = new ButtonListener();
		copy = new JButton("Copy");
		copy.addActionListener(copyButton);
		panel1.add(copy);
		
		ButtonListener pasteButton = new ButtonListener();
		paste = new JButton("Paste");
		paste.addActionListener(pasteButton);
		panel1.add(paste);
		
		ButtonListener startRecordButton = new ButtonListener();
		startRecord = new JButton("Start Recording");
		startRecord.addActionListener(startRecordButton);
		panel1.add(startRecord);
		
		ButtonListener endRecordButton = new ButtonListener();
		endRecord = new JButton("End Recording");
		endRecord.addActionListener(endRecordButton);
		panel1.add(endRecord);
		
		ButtonListener playRecordButton = new ButtonListener();
		playRecord = new JButton("Play Recording");
		playRecord.addActionListener(playRecordButton);
		panel1.add(playRecord);
		
		ButtonListener undoButton = new ButtonListener();
		undo = new JButton("Undo");
		undo.addActionListener(undoButton);
		panel1.add(undo);
		
		ButtonListener redoButton = new ButtonListener();
		redo = new JButton("Redo");
		redo.addActionListener(redoButton);
		panel1.add(redo);
		
		ButtonListener loadButton = new ButtonListener();
		load = new JButton("Load");
		load.addActionListener(loadButton);
		panel1.add(load);
		
		ButtonListener saveButton = new ButtonListener();
		save = new JButton("Save");
		save.addActionListener(saveButton);
		panel1.add(save);
		
		this.add(panel1);
		this.setVisible(true);
	}
	
	class ButtonListener extends JFrame implements ActionListener {

		private JTextArea insertArea = new JTextArea(30,50);
		public void actionPerformed(ActionEvent e) {
			
					
			if(e.getSource()==insert){
			//	KeyListener l = null;
			//this.add(panel2);
				//this.setVisible(true);
			//	String textInTextArea = theBuffer.getText();								
			//	miniEditor.editorInsert(textInTextArea);
			//	theBuffer.setText(null);
				//System.out.println(miniEditor.getBuffer());
			
			}
			if(e.getSource()==select){
				String textInTextArea = theBuffer.getText();
				if(miniEditor.getBuffer()==null){miniEditor.editorInsert(textInTextArea);}
				else{
					int length =(miniEditor.getBuffer()).length();
					textInTextArea = theBuffer.getText();
					miniEditor.editorInsert(textInTextArea.substring(length));
					
				}
				//System.out.println(miniEditor.getBuffer());
				miniEditor.editorSelect(theBuffer.getSelectionStart(), theBuffer.getSelectionEnd());

			}
			if(e.getSource()==copy){
				//String textInTextArea = theBuffer.getText();								
			//	miniEditor.editorInsert(textInTextArea);
				if(theBuffer.getSelectionStart()!=0 || theBuffer.getSelectionEnd()!=0){
					miniEditor.editorCopy();
				}
			}
			
			if(e.getSource()==cut){
			//	String textInTextArea = theBuffer.getText();								
			//	miniEditor.editorInsert(textInTextArea);
				if(theBuffer.getSelectionStart()!=0 || theBuffer.getSelectionEnd()!=0){
					miniEditor.editorCut();
					theBuffer.setText(null);
					theBuffer.setText(miniEditor.getBuffer());}
				//theBuffer.insert(miniEditor.getBuffer(),0);

			}
			
			if(e.getSource()==paste){
				//String textInTextArea = theBuffer.getText();								
			//	miniEditor.editorInsert(textInTextArea);
				int flag=1;
				if(miniEditor.getClipboard()==null){ flag=0;} 
				System.out.println(miniEditor.getClipboard());
				if(flag!=0){
					System.out.println(flag);
					String textInTextArea = theBuffer.getText(); 
					//if(miniEditor.getBuffer()==null){miniEditor.editorInsert(textInTextArea);}
					//else{
						int length =(miniEditor.getBuffer()).length();
						textInTextArea = theBuffer.getText();
						miniEditor.editorInsert(textInTextArea.substring(length));
					
					//}
					miniEditor.editorPaste();
					theBuffer.setText(null);
					theBuffer.insert(miniEditor.getBuffer(),0);
				}
			}
			
			if(e.getSource()==startRecord){				
				miniEditor.editorStartRecording();

			}
			
			if(e.getSource()==endRecord){
				miniEditor.editorEndRecording();

			}
			
			if(e.getSource()==playRecord){
				miniEditor.editorPlayRecording();
				theBuffer.setText(null);
				theBuffer.insert(miniEditor.getBuffer(),0);

			}
			
			if(e.getSource()==undo){
				miniEditor.editorUndo();
				theBuffer.setText(null);
				theBuffer.insert(miniEditor.getBuffer(),0);
			}
			
			if(e.getSource()==redo){
				miniEditor.editorRedo();
				theBuffer.setText(null);
				theBuffer.insert(miniEditor.getBuffer(),0);
			}
			
			if(e.getSource()==save){
				String text = theBuffer.getText(); 
				fc.setCurrentDirectory( new File("./"));
				int actionDialog = fc.showSaveDialog(this);
				if (actionDialog == JFileChooser.APPROVE_OPTION){
					File fileName = new File(fc.getSelectedFile( ) + "" );
					if(fileName==null){return;}
					if(fileName.exists()){
						actionDialog = JOptionPane.showConfirmDialog(this,
                                "Replace existing file?");
						if (actionDialog == JOptionPane.NO_OPTION)
							return;
					}
					try
			        {
			                BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
			                out.write(text);
			                out.close();
			        }
					catch(Exception x)
			        {
			                 System.err.println("Error: " + x.getMessage());
			        }
				}
				
			}
			
			if(e.getSource()==load){
				int returnVal = fc.showOpenDialog(null);
				File file = null;
				String line = null;
				if(returnVal == JFileChooser.APPROVE_OPTION){     
					  file = fc.getSelectedFile();    
					}
				//try {
				BufferedReader in = null;
				try {
					in = new BufferedReader(new FileReader(file));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					line = in.readLine();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				while(line!=null){
					theBuffer.append(line + "\n");
					try {
						line=in.readLine();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
			
			System.out.println(miniEditor.getBuffer());
			
			
		}

		
	}

}
