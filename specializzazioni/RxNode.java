package specializzazioni;


import nodi.NodeComunication;

//riguarda i Monitor
public class RxNode  implements NodeComunication {

	private float nodeData;
	
	public void receive(float nodeData) {
		this.nodeData = nodeData;	
	}

	public float read() {
		return this.nodeData;
	}

	// Metodo non usato
	public float send() {
		return 0;
	}
	// Metodo non usato
	public void set(float nodeData) {}

}
