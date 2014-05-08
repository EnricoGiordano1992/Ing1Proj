package specializzazioni;

import nodi.Node;

public class Processor extends Node {
	
	private int postiLiberi = 500;
	private int carhour = 0;

	public Processor(String nodeName, boolean W) {
		super(nodeName, W);
		this.nodeComm = new TxRxNode(this);
	}

	public void display() {
		// è uscita una macchina
		if( nodeComm.read() < 0)
		{
			if ( postiLiberi < 500 )
				postiLiberi++;
		}
		else if ( nodeComm.read() > 0)
		{
			if ( postiLiberi - 1 <= 0 )
				System.out.println("Parcheggio pieno...attendere prego");
			else
				postiLiberi--;
		}
		
		nodeComm.set( postiLiberi );
		nodeComm.setChannel("Display");
		nodeComm.send();
		
		nodeComm.set( postiLiberi / 2 );
		nodeComm.setChannel("Display car/hour");
		nodeComm.send();
		
	}
	
	/*
	 * Crea un canale con un altro nodo
	 * Ritorna true se è stato creato altrimenti ritorna false
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
	 * Ritorna true se è stato eliminato altrimenti ritorna false
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
}
