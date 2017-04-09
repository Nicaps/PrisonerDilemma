package uqac.sma.project.strategies;

import uqac.sma.project.core.Decision;
import uqac.sma.project.core.Strategy;

public class Random implements Strategy {
	
	public Random(){}
	
	public Decision play(int round, Decision lastOpponentDecision){
		return ((int)(Math.random()*2) == 0 ? Decision.COOPERATE : Decision.DEFECT);
	}
	
	public void finalize(){}
}
