package uqac.sma.project.strategies;

import uqac.sma.project.core.Decision;
import uqac.sma.project.core.Strategy;


public class TFT implements Strategy {

	public TFT(){}
	
	@Override
	public Decision play(int round, Decision lastOpponentDecision) {
		return (round == 0 ? Decision.COOPERATE : lastOpponentDecision);
	}
	
	public void finalize(){}
}