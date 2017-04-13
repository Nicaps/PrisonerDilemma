package uqac.sma.project.utils;

import uqac.sma.project.strategies.*;
import java.util.HashMap;

public class Constants {

	public static int MAX_ROUND = 100;
	
	/*
	 * Constantes dédiées uniquement à l'agent adaptatif
	 */
	public static Class<?> DEFAULT_STRATEGY = Identifier.class;
	
	@SuppressWarnings({ "serial", "rawtypes" })
	public static HashMap<Class,Class> EFFICIENCY = new HashMap<Class,Class>(){{
		put(AllC.class,AllD.class);
		put(AllD.class,AllD.class);
		put(TFT.class,TFT.class);
		put(Mistrust.class,AllC.class);
		put(Pavlov.class,TFT.class);
		put(Spiteful.class,TFT.class);
		put(Random.class,AllD.class);
	}};
	
	@SuppressWarnings({ "serial", "rawtypes" })
	public static HashMap<Class, Boolean> POSSIBILITY = new HashMap<Class,Boolean>(){{
		put(AllC.class,true);
		put(AllD.class,true);
		put(TFT.class,true);
		put(Mistrust.class,true);
		put(Pavlov.class,true);
		put(Spiteful.class,true);
		put(Random.class,false);
	}};
	
}
