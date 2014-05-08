package specializzazioni;

import java.util.ArrayList;

import nodi.Node;
import nodi.NodeComunication;


//si associa solo a Processor
public class TxRxNode implements NodeComunication {

	private float nodeData;
	private ArrayList<NodeComunication> observers;
	private Node dadNode;
	private int selectedChannel = 0;
	
	public TxRxNode(Node dadNode ){
		observers = new ArrayList<NodeComunication>();
		this.dadNode = dadNode;
	}
	
	// Aggiunge un NodeComunication all'arraylist dei nodi osservatori
	public void addRxNode( NodeComunication node )
	{
		observers.add( node );
	}
	
	// Rimuove un nodo dall'arraylist
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
	
	// Decido a quale componente inviare i dati
	public void setChannel( String name )
	{
		for ( int i = 0; i < observers.size() ; i++ )
		{
			if ( observers.get(i).getDadNode().name.compareTo(name) == 0)
				selectedChannel = i;
		}
	}
	
	
	// Comunico a tutti i nodi collegati i dati da inviare
	public float send() 
	{
		observers.get(selectedChannel).receive( this.nodeData );
		return nodeData;
	}
	
	// Salvo il valore da inviare sul canale
	public void set(float nodeData) 
	{
		this.nodeData = nodeData;		
	}
	
	public void receive(float nodeData) {
		this.nodeData = nodeData;
		this.dadNode.update();
	}

	public float read() {
		return this.nodeData;
	}
	public Node getDadNode()
	{
		return dadNode;
	}
}
