package Topologies;
import algorithm.*;
public class Global extends Topology{

	@Override
	public Particle buscaVizinhanca(PSO pso, int indice) {
		// TODO Auto-generated method stu
		
		double bestParticle = pso.getFunction().calculateFitness(pso.getSwarm()[indice].getBestPosition());
		double currentFitness;
		int indiceBestParticle;
		
		for(int i = 0; i < pso.getSwarm().length; i++){
			currentFitness = pso.getGlobalBestFitness();
			if(bestParticle < currentFitness){
				indiceBestParticle = i;
				bestParticle = currentFitness;
			}
		}
		
		return pso.getSwarm()[indice];
	}

}
