package nodi;

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
	public String operation ( float nodeData , float threshold )
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
	public abstract boolean createChannelTo( Node node );
	public abstract boolean removeChannelTo( Node node );
	public abstract void stopTimer();
}
