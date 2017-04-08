package uqac.sma.project;

import uqac.sma.project.core.*;
import uqac.sma.project.strategies.*;

public class Main {

	public static void main(String[] args) {
		Match m = new Match(new TFT(),new Mistrust());
		m.fight();
		System.out.println("Score A = "+m.getScoreA()+" || Score B = "+m.getScoreB());
	}
}
