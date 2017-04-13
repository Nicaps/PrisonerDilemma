package uqac.sma.project.agent;

import uqac.sma.project.core.Strategy;
import uqac.sma.project.core.Decision;

public class Agent {
	protected Strategy strategy;
	protected Decision lastOpponentDecision;
	protected Decision decision;
	protected Decision lastDecision;
	protected int score;
	
	public Agent(){
		this.score = 0;
		this.lastOpponentDecision = null;
		this.strategy = null;
		this.decision = null;
		this.lastDecision = null;
	}
	
	public Agent(Strategy s){
		this();
		this.strategy = s;
	}

	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public Decision getLastOpponentDecision() {
		return lastOpponentDecision;
	}

	public void setLastOpponentDecision(Decision lastOpponentDecision) {
		this.lastOpponentDecision = lastOpponentDecision;
	}

	public Decision getDecision() {
		return decision;
	}

	public void setDecision(Decision decision) {
		this.decision = decision;
	}

	public Decision getLastDecision() {
		return lastDecision;
	}

	public void setLastDecision(Decision lastDecision) {
		this.lastDecision = lastDecision;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public Decision playStrategy(int round){
		return this.strategy.play(round, this.lastOpponentDecision);
	}
}
