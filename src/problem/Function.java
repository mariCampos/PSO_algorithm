package problem;

public abstract class Function {
	
	public abstract double getLowerBound();
	
	public abstract double getUpperBound();
	
	public abstract double calculateFitness(double[] positions);
}
