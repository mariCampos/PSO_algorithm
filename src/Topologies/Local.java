package Topologies;

import algorithm.PSO;
import algorithm.Particle;

public class Local extends Topology{

	@Override
	public Particle buscaVizinhanca(PSO pso, int indice) {
		// TODO Auto-generated method stub
		
		int indexBestParticle = indice;
		int indexLeft = (indice > 0) ? indice -1 : pso.getSwarm().length -1;
		int indexRight = (indice < pso.getSwarm().length - 1)? indice + 1 : 0;
		double best = 0.0;
		
		double currentPBestFitness = pso.getFunction().calculateFitness(pso.getSwarm()[indice].getBestPosition());
		double leftNeigborPBestFitness = pso.getFunction().calculateFitness(pso.getSwarm()[indexLeft].getBestPosition());
		double rightNeighborPBestFitness = pso.getFunction().calculateFitness(pso.getSwarm()[indexRight].getBestPosition());
		
		best = currentPBestFitness;
		
		if(best > leftNeigborPBestFitness){
			indexBestParticle = indexLeft;
			best = leftNeigborPBestFitness;
		}
		
		if(best > rightNeighborPBestFitness){
			indexBestParticle = indexRight;
		}
		return pso.getSwarm()[indexBestParticle];
	}

	

}
