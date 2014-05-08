package nodi;

public interface NodeComunication {

	void receive(float nodeData);

	float read();

	float send();

	void set(float nodeData);
	
	// Metodi aggiunti da Giovanni
	Node getDadNode();
	
	void setChannel(String string);

}
