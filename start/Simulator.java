package start;

<<<<<<< HEAD
import java.awt.Color;
import java.awt.GridLayout;
import java.io.PrintStream;
import java.text.AttributedCharacterIterator.Attribute;

import Text.AttributedTextArea;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.io.*;

import nodi.*;
import specializzazioni.*;
import Grafica.Grafica;
=======
import nodi.*;
import specializzazioni.*;
>>>>>>> Color

public class Simulator {

	public static Grafica g;
	
	public static void main(String[] args) {

		g = new Grafica();
		
		Node detector = new Detector("Detector", false);	
		Monitor monitor = new Monitor("Display free Park", false);
		Monitor monitor_ch = new Monitor("Display car/hour", false);
		Node processor = new Processor("Processor", false);

		detector.createChannelTo( processor );
		processor.createChannelTo( monitor );
		processor.createChannelTo( monitor_ch );
		
		//monitor.setGG(g);
		
		for ( int i = 0; i < 800; i++ )
		{
			try{
<<<<<<< HEAD
				int randomNum = (int)(Math.random()*500);
				Thread.currentThread().sleep(randomNum);
				
=======
				int randomNum = (int)(Math.random()*200);
					Thread.currentThread().sleep(randomNum);
>>>>>>> Color
				}
				catch(InterruptedException ie){
				}
			
			if(i == 0){
				detector.set(1);
				detector.send();
			}
			if(i % 5 != 0)
			{
				//simulo il passaggio di un Gooby
				detector.set( -1 + (int)(Math.random() * 5) );
				detector.send();
			}
			
			else
			{
				detector.set( -1 );
				detector.send();
			}
			
			
		}
		processor.stopTimer();
		
	}

}
