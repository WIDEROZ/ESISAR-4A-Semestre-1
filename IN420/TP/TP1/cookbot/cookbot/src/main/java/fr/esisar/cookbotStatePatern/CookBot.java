package fr.esisar.cookbotStatePatern;

public class CookBot {
	private CookBotState state;
	
	
	
	
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
		state.regularCook(this);
	}
	
	public void switchOn() {
		state.switchOn(this);
	}

	public void switchOff() {
		state.switchOff(this);
	}
	
}
