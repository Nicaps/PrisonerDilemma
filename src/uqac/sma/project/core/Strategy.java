package uqac.sma.project.core;

public interface Strategy {
	
	Decision play(int round, Decision lastOpponentDecision, int myScore, int opponentScore);

}
