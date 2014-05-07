package start;

import nodi.*;
import specializzazioni.*;

public class Simulator {

	public static void main(String[] args) {

		Node detector = new Detector("Detector", false);	
		Node monitor = new Monitor("Display", false);
		Node monitor_ch = new Monitor("Display car/hour", false);
		Node processor = new Processor("Processor", false);
		
		detector.createChannelTo( processor );
		processor.createChannelTo( monitor );
		processor.createChannelTo( monitor_ch );
		
		// simulo il passaggio di un Gooby
		detector.set( 1 );
		detector.send();
		
	}

}
