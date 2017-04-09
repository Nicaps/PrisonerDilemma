package uqac.sma.project;

import uqac.sma.project.core.*;
import uqac.sma.project.strategies.*;
import uqac.sma.project.agent.*;

public class Main {

	public static void main(String[] args) {
		InferenceEngine e = new InferenceEngine();
		Strategy s = e.adaptation(new TFT());
		System.out.println(s);
	}
}
