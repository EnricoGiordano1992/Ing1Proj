package specializzazioni;

import java.util.ArrayList;

import nodi.Node;
import nodi.NodeComunication;


//si associa solo a Processor
public class TxRxNode implements NodeComunication {

	private float nodeData;
	private ArrayList<NodeComunication> observers;
	
	public TxNode(){
		observers = new ArrayList<NodeComunication>();
	}
	/*
	 * Aggiunge un NodeComunication all'arraylist dei nodi osservatori
	 */
	public void addRxNode( NodeComunication node )
	{
		observers.add( node );
	}
	public void removeRxNode( NodeComunication node )
	{
		observers.remove( node );
	}
	
	// Crea un canale con il modulo RxNode di un nodo
	public boolean createChannelTo( Node node )
	{
		addRxNode( node.getNodeComm() );
		return true;
	}
	
	// Crea un canale con il modulo RxNode di un nodo
	public boolean removeChannelTo( Node node )
	{
		removeRxNode( node.getNodeComm() );
		return true;
	}
	// Comunico a tutti i nodi collegati i dati da inviare
	public float send() 
	{
		for ( NodeComunication node : observers )
		{
			node.receive( this.nodeData );
		}
		return 0;
	}
	// Salvo il valore da inviare sul canale
	public void set(float nodeData) 
	{
		this.nodeData = nodeData;		
	}
	public void receive(float nodeData) {
		this.nodeData = nodeData;	
	}

	public float read() {
		return this.nodeData;
	}
}
