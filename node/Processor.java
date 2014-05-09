package node;

import nodeComputation.Add;
import nodeComputation.Sub;
import nodeComunication.TxRxNode;
import timer.*;

public class Processor extends Node {
	
	private float postiLiberi = 500;
	private float carhour = 0;

	Timer timer;
	Thread t;
	Sub sub;
	Add add;

	public Processor(String nodeName, boolean W) {
		super(nodeName, W);
		this.nodeComm = new TxRxNode(this);
		this.timer = new Timer(1);
		this.sub = new Sub();
		this.add = new Add();
		
		
		t = new Thread ( this.timer );
		t.start();
	}

	public void display() {
		//exit car
		if( nodeComm.read() < 0 )
		{
			if ( postiLiberi < 500 )
				postiLiberi = add.operation(postiLiberi, 1);
		}
		else if ( nodeComm.read() > 0 )
		{
			//new car
			carhour = add.operation(carhour, 1);
			
			if ( sub.operation(postiLiberi, 1) <= 0 )
				System.out.println("Parcheggio pieno...attendere prego");
			else
				postiLiberi = sub.operation(postiLiberi, 1);
		}
		
		nodeComm.set( postiLiberi );
		nodeComm.setChannel("Display free Park");
		nodeComm.send();
		
		nodeComm.set( carhour / timer.getCounter() );
		nodeComm.setChannel("Display car/hour");
		nodeComm.send();
		
		nodeComm.set( carhour );
		nodeComm.setChannel("Display counter");
		nodeComm.send();
	}
	public void stopTimer()
	{
		t.interrupt();
	}

	@Override
	public void update() {
		display();		
	}
}
