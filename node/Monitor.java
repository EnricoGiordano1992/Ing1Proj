package node;

import grafica.Grafica;
import start.Simulator;
import nodeComunication.RxNode;

public class Monitor extends Node {

	Grafica gg;
	int myGID;
	
	public Monitor(String nodeName, boolean W) {
		super(nodeName, W);
		this.nodeComm = new RxNode(this);
		this.myGID = 0;
	}

	
	public void setMyGID(int GID) {
		
		this.myGID = GID;
	}
	
	public void setGG(Grafica g)
	{
		this.gg = g;
	}
	
	/*
	 * Mostra i dati ricevuti attraverso l'oggetto nodeComm
	 */
	public void display() {
		
			Simulator.g.writeText(myGID-1, getName());
			Simulator.g.writeText(myGID, "" + (int) getValue());
	}

	// Metodi non usati
	
	
	public String getName()
	{
		return (this.name + " \t: "); 
	}
	
	public float getValue()
	{
		 return this.nodeComm.read();
	}

	@Override
	public void stopTimer() {}

	@Override
	public void update() {
		display();		
	}

}
