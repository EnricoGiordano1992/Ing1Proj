package start;

import nodi.*;
import specializzazioni.*;

public class Simulator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node detector = new Detector("Detector", false);
		Node monitor = new Monitor("Display", false);
		Node processor = new Processor("Processor", false);
		
		/*
		 * Il detector ha rilevato 1 macchina in entrata
		 */
		detector.set( 1 );
		detector.send();
		
		processor.receive( detector.read() );
		
		monitor.display();
	}

}
