package nodeComunication;


import node.Node;

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
		this.dadNode.update();
	}

	public float read() {
		return this.nodeData;
	}
	public Node getParentNode()
	{
		return dadNode;
	}

	// Metodo non usato
	public float send() {
		return 0;
	}
	// Metodo non usato
	public void set(float nodeData) {}

	@Override
	public void setChannel(String string) {
		// TODO Auto-generated method stub
		
	}
	public boolean createChannelTo( Node node )
	{
		if ( node.getNodeComm() instanceof RxNode )
			return false;
		else
			node.createChannelTo(dadNode);
		return true;
	}

	@Override
	public boolean removeChannelTo(Node node) {
		if ( node.getNodeComm() instanceof RxNode)
			return false;
		else
			node.removeChannelTo(dadNode);
		return true;
	}

}
