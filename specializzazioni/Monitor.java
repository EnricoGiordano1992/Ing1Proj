package specializzazioni;

import start.Simulator;
import nodi.Node;
import Grafica.Grafica;

public class Monitor extends Node {

	Grafica gg;
	
	public Monitor(String nodeName, boolean W) {
		super(nodeName, W);
		this.nodeComm = new RxNode(this);
	}

	
	public void setGG(Grafica g)
	{
		this.gg = g;
	}
	
	/*
	 * Mostra i dati ricevuti attraverso l'oggetto nodeComm
	 */
	public void display() {
		
		if(this.name.compareTo("Display free Park") == 0)
		{
			Simulator.g.setLabel1(getName());
			Simulator.g.setLabel3("" + (int) getValue());
		}
		
		else if(this.name.compareTo("Display car/hour") == 0)
		{
			Simulator.g.setLabel2(getName());
			Simulator.g.setLabel4("" + getValue());

		}
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
