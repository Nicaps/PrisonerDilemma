package uqac.sma.project;

import uqac.sma.project.core.*;
import uqac.sma.project.strategies.*;
import uqac.sma.project.agent.*;

public class Test {

	public static void main(String[] args) {
		Agent agentA = new Agent(new AllC());
		Agent agentB = new Agent(new AllD());
		
		int it = 10000;
		
		int sA, sB, tA = 0, tB = 0, vA = 0, vB = 0;
		
		
		for (int i = 0; i< it; i++){
			Match m = new Match(agentA,agentB);
			m.fight();
			sA = agentA.getScore();
			sB = agentB.getScore();
			System.out.println("A = "+sA+" || B = "+sB);
			tA += sA;
			tB += sB;
			if(sA > sB) vA += 1;
			if(sB > sA) vB += 1;
		}
		
		System.out.println("Agent A : score moyen = "+tA/it+"; probabilité de victoire = "+vA*100/it);
		System.out.println("Agent A : score moyen = "+tB/it+"; probabilité de victoire = "+vB*100/it);
	}
}
