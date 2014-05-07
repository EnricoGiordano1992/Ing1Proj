package specializzazioni;

import nodi.Node;

public class Processor extends Node {

	public Processor(String nodeName, boolean W) {
		super(nodeName, W);
		this.nodeComm = new TxRxNode(this);
	}

	public void display() {
		System.out.println("Nuova macchina con valore : " + nodeComm.read());
		nodeComm.set( nodeComm.read() / 2 );
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
