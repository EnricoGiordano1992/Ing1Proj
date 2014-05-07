package specializzazioni;

import nodi.Node;

public class Detector extends Node {

	public Detector(String nodeName, boolean W) {
		super(nodeName, W);
		this.nodeComm = new TxNode();
	}
	public void display() {
		System.out.println("Componente: " + this.name + " = " + this.data );
	}
}
