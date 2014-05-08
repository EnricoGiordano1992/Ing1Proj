package specializzazioni;

import nodi.NodeComputation;

public class Sub implements NodeComputation {

	@Override
	public float operation(float nodeData, float threshold) {
		return nodeData - threshold;
	}

}
