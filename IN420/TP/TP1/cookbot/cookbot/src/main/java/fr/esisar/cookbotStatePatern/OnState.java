package fr.esisar.cookbotStatePatern;

public class OnState implements CookBotState{
	@Override
	public void switchOn(CookBot cookbot) {
		cookbot.setState(this);
	}

	@Override
	public void regularCook(CookBot cookbot) {
		cookbot.setState(new CookState());
	}
	
	@Override
	public void slowCook(CookBot cookbot) {
		cookbot.setState(new SlowCookState());
	}

	@Override
	public void switchOff(CookBot cookbot) {
		cookbot.setState(new OffState());
	}
}
