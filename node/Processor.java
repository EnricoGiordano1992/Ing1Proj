package node;

import nodeComputation.*;
import nodeComunication.TxRxNode;
import timer.*;


public class Processor extends Node {
	
	private float postiLiberi = 500;
	private float carhour = 0;

	Timer timer;
	Thread t;
	Sub sub;
	Add add;
	Comparator cmp;
	Average avg;
	
	public Processor(String nodeName, boolean W) {
		super(nodeName, W);
		this.nodeComm = new TxRxNode(this);
		this.timer = new Timer(1);
		this.sub = new Sub();
		this.add = new Add();
		this.cmp = new Comparator();
		this.avg = new Average();
		
		
		t = new Thread ( this.timer );
		t.start();
	}

	public void display() {
		//exit car
//		if( nodeComm.read() < 0 )
		
		switch ((int) cmp.operation(nodeComm.read(), 0))
		{
		case -1:
			if(cmp.operation(getPostiLiberi(), 500) == -1)
//			if ( getPostiLiberi() < 500 )
				setPostiLiberi(add.operation(getPostiLiberi(), 1));
			break;
			
		case 1:
			//new car
			setCarhour(add.operation(getCarhour(), 1));
			
			if ( sub.operation(getPostiLiberi(), 1) <= 0 )
				System.out.println("Parcheggio pieno...attendere prego");
			else
				setPostiLiberi(sub.operation(getPostiLiberi(), 1));
			
			
		}
//		{
//			if ( getPostiLiberi() < 500 )
//				setPostiLiberi(add.operation(getPostiLiberi(), 1));
//		}
//		else if ( nodeComm.read() > 0 )
//		{
//			//new car
//			setCarhour(add.operation(getCarhour(), 1));
//			
//			if ( sub.operation(getPostiLiberi(), 1) <= 0 )
//				System.out.println("Parcheggio pieno...attendere prego");
//			else
//				setPostiLiberi(sub.operation(getPostiLiberi(), 1));
//		}
		
		nodeComm.set( getPostiLiberi() );
		nodeComm.setChannel("Display free Park");
		nodeComm.send();
		
		nodeComm.set(avg.operation(getCarhour(), timer.getCounter()));
//		nodeComm.set( getCarhour() / timer.getCounter() );
		nodeComm.setChannel("Display car/hour");
		nodeComm.send();
		
		nodeComm.set( getCarhour() );
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

	public float getPostiLiberi() {
		return postiLiberi;
	}

	public void setPostiLiberi(float postiLiberi) {
		this.postiLiberi = postiLiberi;
	}

	public float getCarhour() {
		return carhour;
	}

	public void setCarhour(float carhour) {
		this.carhour = carhour;
	}
}
