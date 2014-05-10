package timer;
import grafica.Grafica;
import node.Monitor;
import start.Simulator;

public class Timer implements Runnable {

	private static int counter;
	
	public Timer(int val) {
	counter = val;
	}

	public static int getCounter() {
		
		return counter;
	}



	public void setCounter(int val) {
		counter = val;
	}


	
	public void updateTime() {

		counter++;
	}
	
	public static void resetTime(){
		
		counter = 1;
	}
	
	//simula il tempo per il sistema
	@Override
	public void run() {

		try{

			while(true)
			{
				Thread.currentThread().sleep(1000);
				if(Simulator.getFlag("start"))
					updateTime();
				if(Simulator.getFlag("restart"))
					resetTime();
			}
			
		}
		catch (Exception e) {
		}
	}
}
