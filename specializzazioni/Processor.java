package specializzazioni;

import nodi.Node;
import nodi.NodeComunication;

public class Processor extends Node {

	public Processor(String nodeName, boolean W) {
		super(nodeName, W);
		this.nodeComm = new TxRxNode();
	}

	public void display() {
		// TODO Auto-generated method stub

	}
	public NodeComunication getRxNode(){
		return this.nodeComm;
	}
	

}
