package problem;
import algorithm.*;
import java.util.*;
public class Sphere extends Function{
	
	@Override
	public double getLowerBound() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getUpperBound() {
		// TODO Auto-generated method stub
		return 100;
	}

	@Override
	public double calculateFitness(double[] positions) {
		// TODO Auto-generated method stub
		double sum =0;
		for(int i = 0; i < Parameters.DIMENSION; i++){
			sum = sum + Math.pow(positions[i], 2);
		}
		return sum;
	}
	
}
