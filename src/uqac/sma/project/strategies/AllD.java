package uqac.sma.project.strategies;

import uqac.sma.project.core.Decision;
import uqac.sma.project.core.Strategy;

public class AllD implements Strategy {

	public AllD(){}
	
	@Override
	public Decision play(int round, Decision lastOpponentDecision) {
		return Decision.DEFECT;
	}
	
	public void finalize(){}
}
