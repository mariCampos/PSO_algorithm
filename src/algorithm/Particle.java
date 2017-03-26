package algorithm;

public class Particle {
	private double currentPosition[];
	//private double previousPosition[];
	private double velocity[];
	private double bestPosition[];
	private double bestFitness;
	
	
	public double getBestFitness() {
		return bestFitness;
	}

	public void setBestFitness(double bestFitness) {
		this.bestFitness = bestFitness;
	}

	public Particle(double position[], double velocity[]){
		this.setCurrentPosition(position);
		bestPosition = position.clone();
		this.velocity = velocity;
	}

	public double[] getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(double[] currentPosition) {
		this.currentPosition = currentPosition;
	}

	//public double[] getPreviousPosition() {
	//	return previousPosition;
	//}

	//public void setPreviousPosition(double[] previousPosition) {
	//	this.previousPosition = previousPosition;
	//}

	public double[] getVelocity() {
		return velocity;
	}

	public void setVelocity(double[] velocity) {
		this.velocity = velocity;
	}

	public double[] getBestPosition() {
		return bestPosition;
	}

	public void setBestPosition(double[] bestPosition) {
		this.bestPosition = bestPosition;
	}
}
