package nodeComputation;


public class Average implements NodeComputation {

	@Override
	public float operation(float nodeData, float threshold) {

//		nodedata == somma dei valori, threshold == cardinalità dei valori
		Divide div = new Divide();
		
		return div.operation(nodeData, threshold);
	
	}
}