package specializzazioni;

import java.util.ArrayList;

import nodi.NodeComunication;

//riguarda solo Detector
public class TxNode implements NodeComunication  {
	
	private float nodeData;
	private ArrayList<NodeComunication> observers;
	
	public TxNode()
	{
		observers = new ArrayList<NodeComunication>();
	}
	
	public void addRxNode( NodeComunication node )
	{
		observers.add( node );
	}
	public void receive(float nodeData) {
		// TODO Auto-generated method stub	
	}

	public float read() {
		// TODO Auto-generated method stub
		return 0;
	}

	public float send() {
		return 0;
	}
	/*
	 * Setto il valore del canale
	 * @see nodi.NodeComunication#set(float)
	 */
	public void set(float nodeData) {
		this.nodeData = nodeData;		
	}
}
