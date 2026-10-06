package fr.esisar.cookbotStatePatern;

public class OffState implements CookBotState {

	@Override
	public void switchOn(CookBot cookbot) {
		cookbot.setState(new OnState());
	}

	@Override
	public void regularCook(CookBot cookbot) {
		CookBotState transition_state = new OnState();
		transition_state.regularCook(cookbot);
	}

	@Override
	public void switchOff(CookBot cookbot) {
		cookbot.setState(this);
	}

}
