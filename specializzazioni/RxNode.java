package specializzazioni;


import nodi.Node;
import nodi.NodeComunication;

//riguarda i Monitor
public class RxNode  implements NodeComunication {

	private float nodeData;
	private Node dadNode;
	
	public RxNode( Node dadNode )
	{
		this.dadNode = dadNode;
	}
	
	public void receive(float nodeData) {
		this.nodeData = nodeData;
		// si può aggiungere un metodo update nella classe node che poi richiama in metodo display
		this.dadNode.display();
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
