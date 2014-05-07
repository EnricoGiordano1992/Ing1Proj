package specializzazioni;

import nodi.NodeComunication;


//si associa solo a Processor
public class TxRxNode implements NodeComunication {

	public void receive(float nodeData) {
		// TODO Auto-generated method stub
		
	}

	public float read() {
		// TODO Auto-generated method stub
		
		//leggo da detector
			
		return 0;
	}

	public float send() {
		// TODO Auto-generated method stub
		
		//in questo faccio il set 2 volte perché invio 2 valori (uno al monitor delle macchine 
		//e uno al numero posti disponibili

		//Invio ai 2 display, ed è simultaneo

		return 0;
	}

	//float è perché gli invio la media
	public void set(float nodeData) {
		// TODO Auto-generated method stub
		
		
		
	}
}
