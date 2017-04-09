package uqac.sma.project.core;

public interface Strategy {
	
	Decision play(int round, Decision lastOpponentDecision);
	
	public void finalize();
}
