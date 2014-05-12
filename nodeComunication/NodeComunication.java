package nodeComunication;

import node.Node;

public interface NodeComunication {

	void receive(float nodeData);

	//read message
	float read();

	//send message
	float send();

	//set message
	void set(float nodeData);
	
	// Metodi aggiunti da Giovanni
	Node getParentNode();
	
	void setChannel(String string);
	boolean createChannelTo( Node node );
	boolean removeChannelTo( Node node );

}
