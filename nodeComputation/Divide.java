package nodeComputation;


public class Divide implements NodeComputation {

	@Override
	public float operation(float nodeData, float threshold) {
		return nodeData / threshold ;
	}

}
