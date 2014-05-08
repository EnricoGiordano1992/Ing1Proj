package timer;

public class Timer implements Runnable {

	private int counter;

	public Timer(int counter) {

		this.counter = counter;
		
	}

	public int getCounter() {
		
		return this.counter;
	}



	public void setCounter(int counter) {
		this.counter = counter;
	}


	
	public void updateTime() {

		//get time from Calendar Class
		this.counter++;
	}
	
	//simula il tempo per il sistema
	@Override
	public void run() {

		try{

			while(true)
			{
				Thread.currentThread().sleep(1000);
				updateTime();
			}
			
		}
		catch (Exception e) {
		}
	}
}
