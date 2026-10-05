package fr.esisar.cookbot;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CookBot {
	
	static final int ON = 0;
	static final int OFF = 1;
	static final int COOK = 2;
	static final int SLOW_COOK = 3;
	
	private int state;
	private static final Logger LOGGER = LogManager.getLogger(CookBot.class);
	
	
	
	public CookBot() {
		super();
		state = ON;
	}
	
	public void switchOn() {
		if (state == ON) {
			LOGGER.info("CookBot is already switched on");
		} else if (state == COOK) {
			state = ON;
			LOGGER.info("CookBot is switched on...");
		} else if (state == OFF) {
			state = ON;
			LOGGER.info("CookBot is switched on...");
		}
		else if (state == SLOW_COOK) {
			state = ON;
			LOGGER.info("CookBot is switched on...");
		}
		
	}
	
	public void regularCook() {
		if (state == ON) {
			state = COOK;
			LOGGER.info("CookBot is cooking...");
		} else if (state == COOK) {
			LOGGER.info("CookBot is already cooking...");
		} else if (state == OFF) {
			LOGGER.info("CookBot cannot cook when it is switched off");
		}
		else if (state == SLOW_COOK) {
			state = COOK ;
			LOGGER.info("CookBot is cooking ...");
		}
	}
	
	public void slowCook() {
		if (state == ON) {
			state = SLOW_COOK;
			LOGGER.info("CookBot is cooking at a lower temperature...");
		} else if (state == COOK) {
			state = SLOW_COOK;
			LOGGER.info("CookBot is cooking at a lower temperature...");
		} else if (state == SLOW_COOK) {
			LOGGER.info("CookBot is already cooking at a lower temperature...");
		} else if (state == OFF) {
			LOGGER.info("CookBot cannot when it is switch off ..");
		}
		
	}
	
	public void switchOff() {
		if (state == ON) {
			state = OFF;
			LOGGER.info("CookBot is switched off");
		} else if (state == COOK) {
			LOGGER.info("CookBot cannot be switched off while cooking");
		} else if (state == OFF) {
			LOGGER.info("CookBot is already switched off");
		} else if (state == SLOW_COOK) {
			LOGGER.info("CookBot cannot be switched off while slowly cooking ");
		}
	}
	
	public int getState() {
		return state;
	}
}
