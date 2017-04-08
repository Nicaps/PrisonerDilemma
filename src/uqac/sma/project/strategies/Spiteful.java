package uqac.sma.project.strategies;

import uqac.sma.project.core.Decision;
import uqac.sma.project.core.Strategy;

public class Spiteful implements Strategy {

	private boolean _spiteful = false;

	public Spiteful() {
	}

	@Override
	public Decision play(int round, Decision lastOpponentDecision) {
		if (!_spiteful && lastOpponentDecision == Decision.DEFECT) {
			_spiteful = true;
		}
		return (_spiteful ? Decision.DEFECT : Decision.COOPERATE);
	}

}