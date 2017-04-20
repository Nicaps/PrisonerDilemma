package uqac.sma.project.agent;

import java.util.ArrayList;
import uqac.sma.project.core.Strategy;
import uqac.sma.project.core.Decision;
import uqac.sma.project.utils.Constants;

public class AdaptativeAgent extends Agent {
	private ArrayList<Decision> opponentListDecisions;
	private ArrayList<Decision> listDecisions;
	private Strategy opponentStrategy;
	private InferenceEngine engine;
	private boolean hasC;
	private boolean hasD;
	private int currentRound;
	
	public AdaptativeAgent(){
		super();
		this.opponentListDecisions = new ArrayList<Decision>();
		this.listDecisions = new ArrayList<Decision>();
		this.engine = new InferenceEngine();
		this.hasC = false;
		this.hasD = false;
		try {
			this.strategy = (Strategy) Constants.DEFAULT_STRATEGY.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	public AdaptativeAgent(Strategy s){
		this();
		this.strategy = s;
	}
	
	@Override
	public void setLastOpponentDecision(Decision lastOpponentDecision) {
		this.lastOpponentDecision = lastOpponentDecision;
		if (lastOpponentDecision == Decision.COOPERATE) this.hasC = true;
		if (lastOpponentDecision == Decision.DEFECT) this.hasD = true;
		this.opponentListDecisions.add(lastOpponentDecision);
		this.discoverOpponentStrategy(this.currentRound);
		if (this.currentRound >=2 ) this.adapt();
	}
	
	@Override
	public Decision playStrategy(int round){
		Decision d = this.strategy.play(round, this.lastOpponentDecision);
		this.listDecisions.add(d);
		this.currentRound = round;
		return d;
	}
	
	public void discoverOpponentStrategy(int round){
		if(this.opponentStrategy != null) this.opponentStrategy.finalize();
		this.opponentStrategy = this.engine.discovery(this.listDecisions,this.opponentListDecisions,round,this.hasC,this.hasD);
	}
	
	public void adapt(){
		if(this.strategy != null) this.strategy.finalize();
		this.strategy = engine.adaptation(this.opponentStrategy);
	}
}
