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
		Monitor monitor_time = new Monitor("Time", true);
		Processor processor = new Processor("Processor", false);
		
		wl.addNode(monitor);
		wl.addNode(monitor_ch);
		wl.addNode(detector);
		wl.addNode(processor);

		wl.addNode(monitor_count);
		
		g.newDisplay(monitor);
		g.newDisplay(monitor_count);
		g.newDisplay(monitor_ch);
		g.newDisplay(monitor_time);
							
		for ( int i = 0;; i++ )
		{
			if(start_flag)
			{
				try{
						int randomNum = (int)(Math.random()*500);
						Thread.currentThread().sleep(randomNum);
						g.setLabel(""+Timer.getCounter(), 3);
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
			else
			{
				
			}
			
		}		
	}
	
	
	public static void setFlag(boolean flag, String name)
	{
		if(name.equals("start"))
		{
			start_flag = flag;
		}
		else if (name.equals("restart"))
		{
			restart_flag = flag;
			processor.setPostiLiberi(500);
			processor.setCarhour(0);
		}
	}
	
	public static boolean getFlag(String name)
	{
		if(name.equals("start"))
			return start_flag;
		else
			return restart_flag;
	}
}
