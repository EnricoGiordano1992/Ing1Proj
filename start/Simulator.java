package start;

import nodi.*;
import specializzazioni.*;

public class Simulator {

	public static void main(String[] args) {

		Node detector = new Detector("Detector", false);	
		Node monitor = new Monitor("Display free Park", false);
		Node monitor_ch = new Monitor("Display car/hour", false);
		Node processor = new Processor("Processor", false);

		detector.createChannelTo( processor );
		processor.createChannelTo( monitor );
		processor.createChannelTo( monitor_ch );
		
		for ( int i = 0; i < 800; i++ )
		{
			try{
				int randomNum = (int)(Math.random()*200);
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
