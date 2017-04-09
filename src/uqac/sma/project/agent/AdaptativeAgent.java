package uqac.sma.project.agent;

import java.util.ArrayList;
import uqac.sma.project.core.Strategy;
import uqac.sma.project.core.Decision;
import uqac.sma.project.strategies.*;

public class AdaptativeAgent extends Agent {
	private ArrayList<Decision> opponentListDecisions;
	private ArrayList<Decision> listDecisions;
	private Strategy opponentStrategy;
	private InferenceEngine engine;
	
	public AdaptativeAgent(){
		super();
		this.opponentListDecisions = new ArrayList<Decision>();
		this.listDecisions = new ArrayList<Decision>();
		this.engine = new InferenceEngine();
		this.opponentStrategy = null;
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
		this.discoverOpponentStrategy();
		this.adapt();
		Decision d = this.strategy.play(round, this.lastOpponentDecision);
		this.listDecisions.add(d);
		return d;
	}
	
	public void discoverOpponentStrategy(){
		if(this.opponentStrategy != null) this.opponentStrategy.finalize();
		this.opponentStrategy = this.engine.discovery(this.listDecisions,this.opponentListDecisions);
	}
	
	public void adapt(){
		this.strategy.finalize();
		this.strategy = engine.adaptation(this.opponentStrategy);
	}
}
