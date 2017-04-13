package uqac.sma.project.strategies;

import uqac.sma.project.core.*;

public class Identifier implements Strategy{
	
	public Identifier(){}

	@Override
	public Decision play(int round, Decision lastOpponentDecision) {
		switch(round){
		case 0:
			return Decision.DEFECT;
		case 1:
			return Decision.COOPERATE;
		default:
			return Decision.DEFECT;
		}
	}
	
	public void finalize(){}
	
}
