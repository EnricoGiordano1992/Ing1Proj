package nodeComputation;


public class Multi implements NodeComputation {

	@Override
	public float operation(float nodeData, float threshold) {
		return nodeData * threshold;
	}

}
