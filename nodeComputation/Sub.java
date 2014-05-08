package nodeComputation;


public class Sub implements NodeComputation {

	@Override
	public float operation(float nodeData, float threshold) {
		return nodeData - threshold;
	}

}
