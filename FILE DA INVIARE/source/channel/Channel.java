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
		// create a link in a grid
		for ( Node nd : nodeList ){
			nd.createChannelTo(n);
		}
		// add node to the list
		nodeList.add(n);
	}
	public void removeNode(Node n) {
		// remove a link between node in the grid
		nodeList.remove(n);
		for ( Node nd : nodeList ){
			nd.removeChannelTo(n);
		}		
	}

}
