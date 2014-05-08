package specializzazioni;

import nodi.Node;

public class Detector extends Node {

	public
	Detector(String nodeName, boolean W) {
		super(nodeName, W);
		this.nodeComm = new TxNode();
	}
	public void 
	newCar()
	{
		set( 1 );
		send();
	}
	public void 
	exitCar()
	{
		set ( -1 );
		send();
	}
	public void 
	display() 
	{
		System.out.println("Componente: " + this.name + " = " + this.data );
	}
	
	/*
	 * Crea un canale con un altro nodo
	 * Ritorna true se è stato creato altrimenti ritorna false
	 */
	public boolean createChannelTo( Node node )
	{
		if ( this.nodeComm instanceof TxNode && node != null )
		{
			return ((TxNode) nodeComm).createChannelTo(node);
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
		if ( this.nodeComm instanceof TxNode && node != null )
		{
			return ((TxNode)nodeComm).removeChannelTo(node);
		}
		else
			return false;	
	}
	@Override
	public void stopTimer() {}
}
