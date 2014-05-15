package nodeComunication;

import java.util.ArrayList;

import node.Node;


//si associa solo a Processor
public class TxRxNode implements NodeComunication {

	private float nodeData;
	private ArrayList<NodeComunication> observers;
	private Node parentNode;
	private int selectedChannel = 0;
	
	public TxRxNode(Node dadNode ){
		observers = new ArrayList<NodeComunication>();
		this.parentNode = dadNode;
	}
	
	// Crea un canale con il modulo RxNode di un nodo
	@Override
	public boolean createChannelTo( Node node )
	{
		observers.add( node.getNodeComm() );
		System.out.println("Aggiunto a " + parentNode.name + " il nodo " + node.name );
		return true;
	}
	
	// Crea un canale con il modulo RxNode di un nodo
	@Override
	public boolean removeChannelTo( Node node )
	{
		observers.remove( node.getNodeComm() );
		System.out.println("Rimosso da " + parentNode.name + " il nodo " + node.name );
		return true;
	}
	// Decido a quale componente inviare i dati
	@Override
	public void setChannel( String name )
	{
		for ( int i = 0; i < observers.size() ; i++ )
		{
			if ( observers.get(i).getParentNode().name.compareTo(name) == 0)
				selectedChannel = i;
		}
	}

	// Comunico a tutti i nodi collegati i dati da inviare
	@Override
	public float send() 
	{
		observers.get(selectedChannel).receive( this.nodeData );
		return nodeData;
	}
	
	// Salvo il valore da inviare sul canale
	@Override
	public void set(float nodeData) 
	{
		this.nodeData = nodeData;		
	}
	@Override
	public void receive(float nodeData) {
		this.nodeData = nodeData;
		this.parentNode.update();
	}
	@Override
	public float read() {
		return this.nodeData;
	}
	@Override
	public Node getParentNode()
	{
		return parentNode;
	}
}
