package uqac.sma.project.strategies;

import uqac.sma.project.core.Decision;
import uqac.sma.project.core.Strategy;

public class Pavlov implements Strategy {

	private Decision _decision;
	
	public Pavlov(){}
	
	@Override
	public Decision play(int round, Decision lastOpponentDecision) {
		_decision = (round == 0 ? Decision.COOPERATE : (_decision == lastOpponentDecision ? Decision.COOPERATE : Decision.DEFECT));
		return _decision;
	}

	public void finalize(){}
}