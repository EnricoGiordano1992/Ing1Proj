package nodeComputation;


public class Comparator implements NodeComputation {

	public float operation(float nodeData, float threshold) {

		if(nodeData > threshold)
			return 1;
		else if(nodeData < threshold)
			return -1;
		else
			return 0;
	}
}
