package algorithm;
import problem.*;
import Topologies.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Function f = new Sphere();
		Function f = new RotatedRastrigin();
		//Function f = new Rosenbrock();
		//Topology t = new Global();
		//Topology t = new Local();
		Topology t = new Focal();
		
		PSO enxame = new PSO(f, t);
		enxame.search();
	}

}
