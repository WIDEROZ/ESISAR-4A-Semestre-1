package fr.esisar.cookbotStatePatern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CookBot {
	private CookBotState state;
	private static final Logger LOGGER = LogManager.getLogger(CookBot.class);
	
	public CookBot() {
		super();
		this.state = new OnState();
	}
	
	
	
	public CookBotState getState() {
		return state;
	}
	
	/**
	* Set the current state. Normally only called by classes implementing
	* the CookBotState interface.
	*
	* @param state the new state of this context (CookBot)
	*/
	public void setState(CookBotState state) {
		this.state = state;
	}
	
	
	
	public void regularCook() {
		LOGGER.info("CookBot is cooking...");
		state.regularCook(this);
	}
	
	public void slowCook() {
		LOGGER.info("CookBot is cooking at a lower temperature...");
		state.slowCook(this);
	}
	
	public void switchOn() {
		LOGGER.info("CookBot is switched on...");
		state.switchOn(this);
	}

	public void switchOff() {
		LOGGER.info("CookBot is switched off...");
		state.switchOff(this);
	}
	
}
