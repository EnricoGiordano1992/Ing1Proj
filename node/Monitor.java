package node;

import grafica.Grafica;
import nodeComunication.RxNode;

public class Monitor extends Node {

	Grafica gg;
<<<<<<< HEAD
	private int pos;
=======
	int myGID;
>>>>>>> fce21cb68c8b30607c0b0dfdbb504836765df8d7
	
	public Monitor(String nodeName, boolean W) {
		super(nodeName, W);
		this.nodeComm = new RxNode(this);
		this.myGID = 0;
	}

	
	public void newDisplay(Grafica g)
=======
	public void setMyGID(int GID) {
		
		this.myGID = GID;
	}
	
	public void setGG(Grafica g)
>>>>>>> fce21cb68c8b30607c0b0dfdbb504836765df8d7
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
<<<<<<< HEAD
		gg.setLabel(""+ getValue(), pos);
=======
		
			Simulator.g.writeText(myGID-1, getName());
			Simulator.g.writeText(myGID, "" + (int) getValue());
>>>>>>> fce21cb68c8b30607c0b0dfdbb504836765df8d7
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
