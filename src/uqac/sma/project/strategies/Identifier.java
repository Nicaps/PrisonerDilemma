package uqac.sma.project.strategies;

import uqac.sma.project.core.*;

public class Identifier implements Strategy{
	
	public Identifier(){}

	@Override
	public Decision play(int round, Decision lastOpponentDecision) {
		if(round == 1){
			return Decision.COOPERATE;
		} else {
			return Decision.DEFECT;
		}
	}
	
	public void finalize(){}
	
}
