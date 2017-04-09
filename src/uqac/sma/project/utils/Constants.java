package uqac.sma.project.utils;

import uqac.sma.project.strategies.*;
import java.util.HashMap;

public class Constants {

	public static int MAX_ROUND = 100;
	
	@SuppressWarnings({ "serial", "rawtypes" })
	public static HashMap<Class,Class> EFFICIENCY = new HashMap<Class,Class>(){{
		put(AllC.class,AllD.class);
		put(AllD.class,AllD.class);
		put(TFT.class,TFT.class);
		put(Mistrust.class,AllC.class);
		put(Pavlov.class,Spiteful.class);
		put(Spiteful.class,TFT.class);
		put(Random.class,AllD.class);
	}};
	
}
