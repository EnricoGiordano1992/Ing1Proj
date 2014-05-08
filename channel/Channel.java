package channel;

import java.util.ArrayList;

import node.Node;

public abstract class Channel {
	public String name;
	public ArrayList<Node> nodeList = new ArrayList<Node>();
	
	public Channel( String name )
	{
		this.name = name;
	}
	public abstract void display();

	public void addNode(Node n) {
		// creo i collegamenti con i nodi connessi alla rete
		for ( Node nd : nodeList ){
			nd.createChannelTo(n);
		}
		// aggiungo il nodo alla lista
		nodeList.add(n);
	}
	public void removeNode(Node n) {
		// rimuovo i collegamenti con i nodi connessi alla rete
		nodeList.remove(n);
		for ( Node nd : nodeList ){
			nd.removeChannelTo(n);
		}		
	}

}
