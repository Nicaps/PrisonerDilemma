package uqac.sma.project.strategies;

import uqac.sma.project.core.Decision;
import uqac.sma.project.core.Strategy;

public class AllC implements Strategy {
	
	public AllC(){}

	@Override
	public Decision play(int round, Decision lastOpponentDecision, int myScore, int opponentScore) {
		return Decision.COOPERATE;
	}

}
