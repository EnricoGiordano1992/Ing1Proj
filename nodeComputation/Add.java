package nodeComputation;


public class Add implements NodeComputation {

	@Override
	public float operation(float nodeData, float threshold) {
		return nodeData + threshold;
	}

}
