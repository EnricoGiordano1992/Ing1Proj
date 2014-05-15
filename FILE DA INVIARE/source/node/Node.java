package node;

import nodeComputation.NodeComputation;
import nodeComunication.NodeComunication;

public abstract class Node {
	protected NodeComunication nodeComm;
	protected NodeComputation nodeComp;
	public boolean w;
	public String name;
	public float data;
	
	public Node( String nodeName, boolean W )
	{
		this.name = nodeName;
		this.w = W;
	}
	public abstract void display();
	
	public void receive( float nodeData )
	{
		nodeComm.receive( nodeData );
	}
	public float send()
	{
		return nodeComm.send();
	}
	public float read()
	{
		return nodeComm.read();
	}
	public void set ( float nodeData )
	{
		nodeComm.set( nodeData );
	}
	public float operation ( float nodeData , float threshold )
	{
		return nodeComp.operation ( nodeData , threshold );
	}
	
	/* ---------------------------
	 * Metodi aggiunti da Giovanni
	 * --------------------------- */
	public NodeComunication getNodeComm()
	{
		return nodeComm;
	}
	public boolean createChannelTo( Node node )
	{
		return nodeComm.createChannelTo(node);
	}
	public boolean removeChannelTo( Node node )
	{
		return nodeComm.removeChannelTo(node);
	}
	public abstract void stopTimer();
	public abstract void update();
}
