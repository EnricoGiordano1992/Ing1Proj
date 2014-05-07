package specializzazioni;

import nodi.Node;

public class Detector extends Node {

	public Detector(String nodeName, boolean W) {
		super(nodeName, W);
		this.nodeComm = new TxNode();
	}

	public void display() {
		// TODO Auto-generated method stub

	}

}
