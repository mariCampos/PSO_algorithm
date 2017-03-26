package Topologies;

import algorithm.PSO;
import algorithm.Particle;

public class Focal extends Topology{

	int indiceFocal = 0;
	
	@Override
	public Particle buscaVizinhanca(PSO pso, int indice) {
		
		Particle focal = pso.getSwarm()[indice];
		double bestParticle = pso.getFunction().calculateFitness(pso.getSwarm()[indiceFocal].getBestPosition());
		double currentParticleFitness;
		
		for(int i = 1;i < pso.getSwarm().length; i++){
			currentParticleFitness = pso.getSwarm()[i].getBestFitness();
			if(currentParticleFitness > bestParticle){
				pso.getSwarm()[indiceFocal].setBestFitness(currentParticleFitness);
				pso.setGlobalBestFitness(currentParticleFitness);
			}
		}
		return null;
	}


}
