package start;

import grafica.Grafica;

import java.awt.Color;

import node.Detector;
import node.Monitor;
import node.Processor;
import channel.WirelessChannel;

public class Simulator {

	public static Grafica g;
	
	public static void main(String[] args) {

		g = new Grafica();
		
		WirelessChannel wl = new WirelessChannel("Rete Wireless");
		
		Detector detector = new Detector("Detector", false);	
		Monitor monitor = new Monitor("Display free Park", false);
		Monitor monitor_ch = new Monitor("Display car/hour", false);
		Monitor monitor_count = new Monitor("Display counter", true);
		Processor processor = new Processor("Processor", false);
		
		wl.addNode(monitor);
		wl.addNode(monitor_ch);
		wl.addNode(detector);
		wl.addNode(processor);

		wl.addNode(monitor_count);
		
		g.newDisplay(monitor);
		g.newDisplay(monitor_count);
		g.newDisplay(monitor_ch);
							
		for ( int i = 0;; i++ )
		{
			try{
					int randomNum = (int)(Math.random()*500);
					Thread.currentThread().sleep(randomNum);
				}
				catch(InterruptedException ie){}
			
			if(i == 0){
				detector.newCar();
			}
			if(i % 5 != 0)
			{
				//simulo il passaggio di un Gooby
				detector.exitCar();
			}
			
			else
			{
				
				detector.car( -1 + (int)(Math.random() * 5) );
			}
		}		
	}
}
