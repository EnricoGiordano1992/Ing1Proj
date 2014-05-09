package node;

import grafica.Grafica;
import nodeComunication.RxNode;

public class Monitor extends Node {

	Grafica gg;
	private int pos;
	
	public Monitor(String nodeName, boolean W) {
		super(nodeName, W);
		this.nodeComm = new RxNode(this);
	}

	
	public void setGG(Grafica g)
	{
		this.gg = g;
	}
	public void setPos( int pos ){
		this.pos = pos;
	}
	
	/*
	 * Mostra i dati ricevuti attraverso l'oggetto nodeComm
	 */
	public void display() {
		gg.setLabel(""+ getValue(), pos);
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
