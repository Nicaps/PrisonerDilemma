package uqac.sma.project.core;

import uqac.sma.project.utils.Constants;

public class Match {

	private Strategy strategyA;
	private Strategy strategyB;
	private int scoreA;
	private int scoreB;
	
	public Match(Strategy strategyA, Strategy strategyB) {
		this.strategyA = strategyA;
		this.strategyB = strategyB;
		this.scoreA = 0;
		this.scoreB = 0;
	}
	
	public Strategy getStrategyA() {
		return strategyA;
	}

	public Strategy getStrategyB() {
		return strategyB;
	}
	
	public int getScoreA() {
		return scoreA;
	}

	public int getScoreB() {
		return scoreB;
	}

	public void fight() {
		Decision oldA = Decision.NOTHING;
		Decision oldB = Decision.NOTHING;
		for (int i = 0; i < Constants.MAX_ROUND; i++) {
			Decision decisionA = strategyA.play(i, oldB);
			Decision decisionB = strategyB.play(i, oldA);
			oldA = decisionA;
			oldB = decisionB;
			score(decisionA, decisionB);
		}
	}
	
	private void score(Decision decisionA, Decision decisionB) {
		if (decisionA == Decision.COOPERATE && decisionB == Decision.COOPERATE) {
			scoreA += 3;
			scoreB += 3;
		}
		if (decisionA == Decision.DEFECT && decisionB == Decision.COOPERATE) {
			scoreA += 5;
		}
		if (decisionB == Decision.DEFECT && decisionA == Decision.COOPERATE) {
			scoreB += 5;
		}
		if (decisionA == Decision.DEFECT && decisionB == Decision.DEFECT) {
			scoreA += 1;
			scoreB += 1;
		}
	}
	
}
