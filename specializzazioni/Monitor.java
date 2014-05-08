package specializzazioni;

import nodi.Node;

public class Monitor extends Node {

	public Monitor(String nodeName, boolean W) {
		super(nodeName, W);
		this.nodeComm = new RxNode(this);
	}

	/*
	 * Mostra i dati ricevuti attraverso l'oggetto nodeComm
	 */
	public void display() {		
		System.out.println( this.name + " \t: " + this.nodeComm.read() );
	}

	// Metodi non usati
	@Override
	public boolean createChannelTo(Node node) {
		return false;
	}

	@Override
	public boolean removeChannelTo(Node node) {
		return false;
	}

	@Override
	public void stopTimer() {}

	@Override
	public void update() {
		display();		
	}

}
