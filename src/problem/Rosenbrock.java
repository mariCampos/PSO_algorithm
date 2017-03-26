package problem;
import java.util.*;
import algorithm.Parameters;

public class Rosenbrock extends Function{

	@Override
	public double getLowerBound() {
		// TODO Auto-generated method stub
		return -30;
	}

	@Override
	public double getUpperBound() {
		// TODO Auto-generated method stub
		return 30;
	}

	@Override
	public double calculateFitness(double[] positions) {
		// TODO Auto-generated method stub
		double sum = 0;
		
		for(int i = 0; i < Parameters.DIMENSION - 1; i++){
			sum = sum + (100*(Math.pow(Math.pow(positions[i], 2) - positions[i + 1], 2)) + (Math.pow(positions[i] - 1, 2)));
		}
		return sum;
	}
	
}
