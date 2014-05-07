package specializzazioni;

import nodi.Node;
import nodi.NodeComunication;

public class Detector extends Node {

	public Detector(String nodeName, boolean W) {
		super(nodeName, W);
		// TODO: da modificare assolutamente
		this.nodeComm = new TxNode( null );
	}
	public void setCommNode( NodeComunication node ){
		
	}

	public void display() {
		System.out.println("Componente: " + this.name + " = " + this.data );
	}
	/*
	 * Devo inviare al processor la rilevazione di una nuova macchina
	 */
	public void newCar()
	{
		this.set( 1 );
	}
	/*
	 * Invio al processor l'uscita di una macchina
	 */
	public void exitCar()
	{
		this.set( -1 );
	}
	
}
