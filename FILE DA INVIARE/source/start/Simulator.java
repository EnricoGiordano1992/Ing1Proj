package start;

import grafica.Grafica;

import java.awt.Color;
import java.io.IOException;

import timer.Timer;

import node.Detector;
import node.Monitor;
import node.Processor;
import channel.WirelessChannel;

public class Simulator {

	public static Grafica g;

	static boolean start_flag = false;
	static boolean restart_flag = false;
	
	static Processor processor; 
	
	public static void main(String[] args) {

		
		g = new Grafica();
		
		WirelessChannel wl = new WirelessChannel("Rete Wireless");
		
		Detector detector = new Detector("Detector", false);	
		Monitor monitor = new Monitor("Display free Park", false);
		Monitor monitor_ch = new Monitor("Display car/hour", false);
		Monitor monitor_count = new Monitor("Display counter", true);
		Processor processor = new Processor("Processor", false);
		
		//wireless creation (plugin node into grid)
		wl.addNode(monitor);
		wl.addNode(monitor_ch);
		wl.addNode(detector);
		wl.addNode(processor);
		wl.addNode(monitor_count);

		//monitor creation (display of devices)
		g.newDisplay(monitor);
		g.newDisplay(monitor_count);
		g.newDisplay(monitor_ch);
							
		//infinite cycle
		for ( int i = 0;; i++ )
		{
			
			if(restart_flag)
			{
				//restart environment
				processor.reset();
				restart_flag = false;
				g.repaint();
			}	

			if(start_flag)
			{
				//you've pressed start button
				try{
						//random delay of thread (simuling entered/exited cars' delay
						int randomNum = (int)(Math.random()*500);
						Thread.currentThread().sleep(randomNum);
					}
					catch(InterruptedException ie){}
				
				//entered a new car
				detector.newCar();
				detector.car( -3 + (int)(Math.random() * 6) );

				//entered a new car
				detector.newCar();
				detector.car( -3 + (int)(Math.random() * 6) );

				//exited a car
				detector.exitCar();
				detector.car( -3 + (int)(Math.random() * 6) );


			}
			
		}		
	}
	
	//setFlag is used by graphical interface to set start and stop flag after a button push
	public static void setFlag(boolean flag, String name)
	{
		if(name.compareTo("start") == 0)
		{
			start_flag = flag;
		}
		else if (name.compareTo("restart") == 0)
		{
			restart_flag = true;
		}
	}
	
	//setFlag is used by graphical interface to get start and stop flag
	public static boolean getFlag(String name)
	{
		if(name.compareTo("start") == 0)
			return start_flag;
		else
			return restart_flag;
	}
}
