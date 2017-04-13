package uqac.sma.project;

import uqac.sma.project.core.*;
import uqac.sma.project.strategies.*;
import uqac.sma.project.utils.Constants;

import java.util.HashMap;
import java.util.Map;

import uqac.sma.project.agent.*;

public class Main {

	public static void main(String[] args) {
		for(Map.Entry<Class, Boolean> entry : Constants.POSSIBILITY.entrySet()){
			System.out.println(entry.getKey());
		}
	}
}
