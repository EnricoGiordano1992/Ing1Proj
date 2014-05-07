package specializzazioni;

import nodi.Node;

public class Monitor extends Node {

	public Monitor(String nodeName, boolean W) {
		super(nodeName, W);
		this.nodeComm = new RxNode();
	}

	/*
	 * Mostra i dati ricevuti attraverso l'oggetto nodeComm
	 * @see nodi.Node#display()
	 */
	public void display() {		
		System.out.println( this.name + " : " + this.nodeComm.read() );
	}

}
