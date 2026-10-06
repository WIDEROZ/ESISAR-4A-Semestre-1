package fr.esisar.cookbotStatePatern;

public class CookState implements CookBotState {

	@Override
	public void switchOn(CookBot cookbot) {
		cookbot.setState(new OnState());
	}

	@Override
	public void regularCook(CookBot cookbot) {
		cookbot.setState(this);
	}

	@Override
	public void switchOff(CookBot cookbot) {
		CookBotState transition_state = new OnState();
		transition_state.switchOff(cookbot);
	}

}
