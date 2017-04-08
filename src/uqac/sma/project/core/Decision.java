package uqac.sma.project.core;

public enum Decision {

	COOPERATE("C"),
	DEFECT("D"),
	NOTHING("X");
	
	private String action;
	
	Decision(String action) {
		this.action = action;
	}
	
	public String toString() {
		return action;
	}
}
