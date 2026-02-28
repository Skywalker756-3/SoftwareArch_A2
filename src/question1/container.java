package question1;

import java.util.ArrayList;

public class container implements CompositionInterface{
	ArrayList<CompositionInterface> contents = new ArrayList<>();
	@Override
	public double getValue() {
		int sum = 0;
		for(CompositionInterface i: contents) {
			sum += i.getValue();
		}
		return sum;
	}
}
