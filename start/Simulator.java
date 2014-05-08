package start;

import specializzazioni.*;
import Grafica.Grafica;

public class Simulator {

	public static Grafica g;
	
	public static void main(String[] args) {

		g = new Grafica();
		
		Detector detector = new Detector("Detector", false);	
		Monitor monitor = new Monitor("Display free Park", false);
		Monitor monitor_ch = new Monitor("Display car/hour", false);
		Processor processor = new Processor("Processor", false);

		detector.createChannelTo( processor );
		detector.createChannelTo( monitor_ch );
		detector.createChannelTo( monitor );
		
		processor.createChannelTo( monitor );
		processor.createChannelTo( monitor_ch );
		
		//monitor.setGG(g);
		
		for ( int i = 0; i < 800; i++ )
		{
			try{
				int randomNum = (int)(Math.random()*500);
				Thread.currentThread().sleep(randomNum);
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
