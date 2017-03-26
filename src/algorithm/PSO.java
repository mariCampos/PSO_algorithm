package algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import problem.*;
import Topologies.*;
public class PSO {
	private Random random;
	private Particle[] swarm;
	private double globalBestPositions[];
	private double globalBestFitness;
	private Function function;
	private Topology topologia;
	
	public PSO(Function f, Topology t){
		this.random = new Random();
		this.function = f;
		this.topologia = t;
	}
	
	public void initialize(){
		this.swarm = new Particle[Parameters.TAMANNHO];
		double position[]; 
		double velocity[];
		
		for(int i = 0; i < swarm.length; i++){
			position = createRandomPositions();
			velocity = createRandomVelocity();
			this.swarm[i] = new Particle(position,velocity);
		}
		
	}
	public void search(){
		initialize();
		this.globalBestPositions = this.swarm[0].getBestPosition().clone();
		
		for(int i = 0; i <= Parameters.ITERAOES; i++){
			updateVelocity();
			updatePosition();
			updateGlobalBest();
			updateParameters();

			System.out.println("best fitness = "+function.calculateFitness(globalBestPositions));
		}
		System.out.println("best fitness = "+function.calculateFitness(globalBestPositions));
	}
	
	public double[] createRandomPositions(){
		double[] aux = new double[Parameters.DIMENSION];
		
		for(int i = 0; i < aux.length; i++){
			aux[i] = (this.function.getLowerBound() + this.random.nextDouble()) * (this.function.getUpperBound() - this.function.getLowerBound());
			System.out.println(aux[i]);
		}
		return aux;
		
	}
	public double[] createRandomVelocity(){
		double[] aux = new double[Parameters.DIMENSION];
		for(int i = 0; i < aux.length; i++){
			//definindo as velocidades iniciais de -1 a 1
			aux[i] = -1 + (2 * this.random.nextDouble());
		}
		return aux;
	}
	public void updateVelocity(){
		double[] velocity = new double[Parameters.DIMENSION];
		
		double personal[][] = new double[swarm.length]
				[Parameters.DIMENSION];
		double global[][] = new double[swarm.length]
				[Parameters.DIMENSION];
		double r1;
		double r2;
		double maxVel = (this.function.getUpperBound() - this.function.getLowerBound());
		for(int i = 0; i < swarm.length; i++){
			Particle aux = this.topologia.buscaVizinhanca(this, i);
			
			for(int j = 0; j < Parameters.DIMENSION; j++){
				r1 = this.random.nextDouble();
				r2 = this.random.nextDouble();
				
				personal[i][j] = Parameters.C1*r1*(this.swarm[i].getBestPosition()[j] - this.swarm[i].getCurrentPosition()[j]);
				
				global[i][j] = Parameters.C2*r2*(this.swarm[i].getBestPosition()[j] - this.swarm[i].getCurrentPosition()[j]);
				
				velocity[j] = Parameters.w*swarm[i].getVelocity()[j] + personal[i][j] + global[i][j];
				
				if(velocity[j] > maxVel){
					velocity[j] = maxVel;
				}
				if(velocity[j] < -maxVel){
					velocity[j] = -maxVel;
				}
			}
			this.swarm[i].setVelocity(velocity);
		}
	}
	
	public void updatePosition(){
		double[] newPosition = new double[Parameters.DIMENSION];
		double boundPosition = 0.5;
		for(int i = 0; i < this.swarm.length; i++){
			for(int j = 0; j < Parameters.DIMENSION; j++){
				newPosition[j] = swarm[i].getCurrentPosition()[j] + swarm[i].getVelocity()[j];
				if(newPosition[j] >= function.getUpperBound()){
					newPosition[j] = (function.getUpperBound() - swarm[i].getVelocity()[j]*this.random.nextDouble()*boundPosition); 
				}else if(newPosition[j] < function.getLowerBound()){
					newPosition[j] = (function.getLowerBound() - swarm[i].getVelocity()[j]*this.random.nextDouble()*boundPosition); 
				}
			}
			swarm[i].setCurrentPosition(newPosition);
		}
	}
	
	public void updateGlobalBest(){
		double[] inicial =  (double[]) swarm[0].getBestPosition().clone();
		
		for (int i = 1; i < swarm.length; i++) {
	
			if(function.calculateFitness(swarm[i].getBestPosition()) < function.calculateFitness(inicial)){
				
				inicial =  swarm[i].getBestPosition();

			}
	}
		if(function.calculateFitness(inicial) < function.calculateFitness(globalBestPositions));
	}
		
	public void updatePBest(Particle p){
		if(function.calculateFitness(p.getCurrentPosition()) < function.calculateFitness(p.getBestPosition())){
			p.setBestPosition(p.getCurrentPosition());
		}
	}
	
	public void updateParameters(){
		
	}

	public Particle[] getSwarm() {
		return swarm;
	}

	public void setSwarm(Particle[] swarm) {
		this.swarm = swarm;
	}

	public double getGlobalBestFitness() {
		return globalBestFitness;
	}

	public void setGlobalBestFitness(double globalBestFitness) {
		this.globalBestFitness = globalBestFitness;
	}

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

}
