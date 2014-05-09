package start;

import java.awt.Color;

import grafica.Grafica;
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
<<<<<<< HEAD
		wl.addNode(monitor_count);
		
		g.newDisplay(monitor);
		g.newDisplay(monitor_count);
		g.newDisplay(monitor_ch);
							
		for ( int i = 0;; i++ )
=======
		
		
		monitor.setMyGID(g.newDisplay(Color.blue, Color.white));
		monitor_ch.setMyGID(g.newDisplay(Color.red, Color.white));
		
		
		for ( int i = 0; i < 800; i++ )
>>>>>>> fce21cb68c8b30607c0b0dfdbb504836765df8d7
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
