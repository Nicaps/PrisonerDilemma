package uqac.sma.project.core;

import uqac.sma.project.utils.Constants;
import uqac.sma.project.agent.*;

public class Match {

	private Agent agentA;
	private Agent agentB;
	
	public Match(Agent agentA, Agent agentB) {
		this.agentA = agentA;
		this.agentB = agentB;
		this.agentA.setScore(0);
		this.agentB.setScore(0);
	}
	
	public Strategy getStrategyA() {
		return agentA.getStrategy();
	}

	public Strategy getStrategyB() {
		return agentB.getStrategy();
	}
	
	public int getScoreA() {
		return agentA.getScore();
	}

	public int getScoreB() {
		return agentB.getScore();
	}

	public void fight() {
		for (int i = 0; i < Constants.MAX_ROUND; i++) {
			Decision decisionA = agentA.playStrategy(i);
			Decision decisionB = agentB.playStrategy(i);
			agentA.setLastOpponentDecision(decisionB);
			agentB.setLastOpponentDecision(decisionA);
			score(decisionA, decisionB);
		}
	}
	
	private void score(Decision decisionA, Decision decisionB) {
		if (decisionA == Decision.COOPERATE && decisionB == Decision.COOPERATE) {
			agentA.setScore(getScoreA() + 3);
			agentB.setScore(getScoreB() + 3);
		}
		if (decisionA == Decision.DEFECT && decisionB == Decision.COOPERATE) {
			agentA.setScore(getScoreA() + 5);
		}
		if (decisionB == Decision.DEFECT && decisionA == Decision.COOPERATE) {
			agentB.setScore(getScoreB() + 5);
		}
		if (decisionA == Decision.DEFECT && decisionB == Decision.DEFECT) {
			agentA.setScore(getScoreA() + 1);
			agentB.setScore(getScoreB() + 1);
		}
	}
	
}
