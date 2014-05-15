package node;

import nodeComunication.TxNode;

public class Detector extends Node {

	public
	Detector(String nodeName, boolean W) {
		super(nodeName, W);
		this.nodeComm = new TxNode(this);
	}
	public void 
	newCar()
	{
		set( 1 );
		this.nodeComm.setChannel("Processor");
		send();
	}
	public void 
	exitCar()
	{
		set ( -1 );
		send();
	}
	public void
	car( float n )
	{
		set ( n );
		this.nodeComm.setChannel("Processor");
		send();
		
	}
	public void 
	display() 
	{
		System.out.println("Componente: " + this.name + " = " + this.data );
	}
	@Override
	public void stopTimer() {}
	@Override
	public void update() {
		display();		
	}
}