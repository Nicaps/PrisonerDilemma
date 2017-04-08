package uqac.sma.project.agent;

import java.util.ArrayList;
import uqac.sma.project.core.Strategy;
import uqac.sma.project.core.Decision;

public class AdaptativeAgent extends Agent {
	private ArrayList<Decision> opponentListDecisions;
	private ArrayList<Decision> listDecisions;
	private Strategy opponentStrategy;
	
	public AdaptativeAgent(){
		super();
		opponentListDecisions = new ArrayList<Decision>();
		listDecisions = new ArrayList<Decision>();
	}
	
	public AdaptativeAgent(Strategy s){
		this();
		this.strategy = s;
	}
	
	@Override
	public void setLastOpponentDecision(Decision lastOpponentDecision) {
		this.lastOpponentDecision = lastOpponentDecision;
		this.opponentListDecisions.add(lastOpponentDecision);
	}
	
	@Override
	public Decision playStrategy(int round){
		Decision d = this.strategy.play(round, this.lastOpponentDecision);
		this.listDecisions.add(d);
		return d;
	}
	
	public void discoverOpponentStrategy(){
		
	}
	
	public void adapt(){
		
	}
}
