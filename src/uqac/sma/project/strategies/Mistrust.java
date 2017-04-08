package uqac.sma.project.strategies;

import uqac.sma.project.core.Decision;
import uqac.sma.project.core.Strategy;


public class Mistrust implements Strategy {

	public Mistrust(){}
	
	@Override
	public Decision play(int round, Decision lastOpponentDecision) {
		return (round == 0 ? Decision.DEFECT : lastOpponentDecision);
	}

}