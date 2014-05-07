package nodi;

public interface NodeComunication {

	void receive(float nodeData);

	float read();

	float send();

	void set(float nodeData);

}
