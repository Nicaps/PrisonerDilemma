package uqac.sma.project.agent;

import uqac.sma.project.strategies.*;
import java.util.ArrayList;
import java.util.Map;

import uqac.sma.project.core.Decision;
import uqac.sma.project.core.Strategy;
import uqac.sma.project.utils.Constants;

public class InferenceEngine {	
	
	/**
	 * Constructeur
	 */
	public InferenceEngine(){}
	
	/**
	 * Chercher la stratégie la plus efficace contre la stratégie
	 * de l'adversaire
	 * @param opponentStrategy
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Strategy adaptation(Strategy opponentStrategy){
		if (opponentStrategy == null) {
			try {
				return (Strategy) Constants.DEFAULT_STRATEGY.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
				return new TFT();
			}
		}
		Class<Strategy> c = Constants.EFFICIENCY.get(opponentStrategy.getClass());
		try {
			return c.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			return new TFT();
		}	
	}
	
	/**
	 * Découvrir la stratégie de l'adversaire grâce à la succession de ses décisions
	 * @param decisions
	 * @param opponentDecisions
	 * @param round
	 * @param hasC
	 * @param hasD
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Strategy discovery(ArrayList<Decision> decisions, ArrayList<Decision> opponentDecisions, int round, boolean hasC, boolean hasD){
		if(hasC) Constants.POSSIBILITY.put(AllD.class,false);
		if(hasD) Constants.POSSIBILITY.put(AllC.class,false);

		if(round == 1){
			if(opponentDecisions.get(round-1) == Decision.COOPERATE){
				Constants.POSSIBILITY.put(Mistrust.class, false);
			} else {
				Constants.POSSIBILITY.put(TFT.class,false);
				Constants.POSSIBILITY.put(Pavlov.class,false);
				Constants.POSSIBILITY.put(Spiteful.class,false);
			}
		} else if (round > 1){
			if(decisions.get(round-1) == Decision.COOPERATE){
				if(opponentDecisions.get(round-1) == Decision.COOPERATE && opponentDecisions.get(round) == Decision.DEFECT){
					Constants.POSSIBILITY.put(TFT.class,false);
					Constants.POSSIBILITY.put(Mistrust.class,false);
					Constants.POSSIBILITY.put(Pavlov.class,false);
					Constants.POSSIBILITY.put(Spiteful.class,false);
				}
				if(opponentDecisions.get(round-1) == Decision.DEFECT && opponentDecisions.get(round) == Decision.COOPERATE){
					Constants.POSSIBILITY.put(Pavlov.class,false);
					Constants.POSSIBILITY.put(Spiteful.class,false);
				}
				if(opponentDecisions.get(round-1) == Decision.DEFECT && opponentDecisions.get(round) == Decision.DEFECT){
					Constants.POSSIBILITY.put(TFT.class,false);
					Constants.POSSIBILITY.put(Mistrust.class,false);
				}
			} else {
				if(opponentDecisions.get(round-1) == Decision.COOPERATE && opponentDecisions.get(round) == Decision.COOPERATE){
					Constants.POSSIBILITY.put(TFT.class,false);
					Constants.POSSIBILITY.put(Mistrust.class,false);
					Constants.POSSIBILITY.put(Pavlov.class,false);
					Constants.POSSIBILITY.put(Spiteful.class,false);
				}
				if(opponentDecisions.get(round-1) == Decision.DEFECT && opponentDecisions.get(round) == Decision.COOPERATE){
					Constants.POSSIBILITY.put(TFT.class,false);
					Constants.POSSIBILITY.put(Mistrust.class,false);
					Constants.POSSIBILITY.put(Spiteful.class,false);
				}
				if(opponentDecisions.get(round-1) == Decision.DEFECT && opponentDecisions.get(round) == Decision.DEFECT){
					Constants.POSSIBILITY.put(Pavlov.class,false);
				}
			}
		}
		
		if(!Constants.POSSIBILITY.containsValue(true)) Constants.POSSIBILITY.put(Random.class,true);
		
		Class<Strategy> c;
		switch(this.countEligibles()){
		case 1:
			for(Map.Entry<Class, Boolean> entry : Constants.POSSIBILITY.entrySet()){
				if(entry.getValue() == true){
					c = entry.getKey();
					try {
						return c.newInstance();
					} catch (InstantiationException | IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
			break;
		case 2:
			if(Constants.POSSIBILITY.get(Pavlov.class) && Constants.POSSIBILITY.get(Spiteful.class)) return new Pavlov();
			break;
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	private int countEligibles(){
		int n = 0;
		for(Map.Entry<Class, Boolean> entry : Constants.POSSIBILITY.entrySet()){
			if(entry.getValue() == true) n+=1;
		}
		return n;
	}
}