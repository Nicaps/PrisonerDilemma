package uqac.sma.project.agent;

import uqac.sma.project.strategies.*;

import java.util.ArrayList;

import uqac.sma.project.core.Decision;
import uqac.sma.project.core.Strategy;
import uqac.sma.project.utils.Constants;

public class InferenceEngine {	
	
	public InferenceEngine(){}
	
	@SuppressWarnings("unchecked")
	public Strategy adaptation(Strategy opponentStrategy){
		if (opponentStrategy == null) return new AllD();
		Class<Strategy> c = Constants.EFFICIENCY.get(opponentStrategy.getClass());
		try {
			return c.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			return new AllD();
		}	
	}
	
	public Strategy discovery(ArrayList<Decision> decisions, ArrayList<Decision> opponentDecisions){
		return null;
	}
}
