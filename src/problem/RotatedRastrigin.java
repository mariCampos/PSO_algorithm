package problem;
import java.util.*;

import algorithm.Parameters;
public class RotatedRastrigin extends Function{

	@Override
	public double getLowerBound() {
		// TODO Auto-generated method stub
		return -5.12;
	}

	@Override
	public double getUpperBound() {
		// TODO Auto-generated method stub
		return 5.12;
	}

	@Override
	public double calculateFitness(double[] positions) {
		// TODO Auto-generated method stub
		double sum = 0.0;
		
		for(int i = 0; i < Parameters.DIMENSION; i++){
			sum = sum + (Math.pow(positions[i], 2) - 10*(Math.cos(2*Math.PI*positions[i])) + 10);
		}
		return sum;
	}

}
