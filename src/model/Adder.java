package model;

public class Adder extends Component {

	private Component previousPrime;
	
	public Adder() {
		
	}

	public Adder(Component previous) {
		super(previous);
	}

	public Adder(Component previous, String name) {
		super(previous, name);
	}

	public Adder(Component previous, int delay) {
		super(previous, delay);
	}

	public Adder(Component previous, String name, int delay) {
		super(previous, name, delay);
	}
	
	
	public Byte processData() {
		Byte holdA = previous.processData();
		Byte holdB = previousPrime.processData();
		if(holdA != null && holdB != null) {
			data.offer((byte) (holdA + holdB));
		}
		else if(holdA != null) {
			data.offer(holdA);
		}
		else if(holdB != null) {
			data.offer(holdB);
		}
		if(data.size() > delay)
			return data.poll();
		return null;
	}

}
