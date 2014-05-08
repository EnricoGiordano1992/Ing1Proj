package specializzazioni;

import nodi.Node;
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
		
		nodeComm.set( (float) carhour / timer.getCounter() );
		nodeComm.setChannel("Display car/hour");
		nodeComm.send();		
	}
	
	/*
	 * Crea un canale con un altro nodo
	 * Ritorna true se � stato creato altrimenti ritorna false
	 */
	public boolean createChannelTo( Node node )
	{
		if ( this.nodeComm instanceof TxRxNode && node != null )
		{
			return ((TxRxNode) nodeComm).createChannelTo(node);
		}
		else
			return false;
	}
	/*
	 * Rimuove un canale con un altro nodo
	 * Ritorna true se � stato eliminato altrimenti ritorna false
	 */
	public boolean removeChannelTo( Node node )
	{
		if ( this.nodeComm instanceof TxRxNode && node != null )
		{
			return ((TxRxNode)nodeComm).removeChannelTo(node);
		}
		else
			return false;	
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
