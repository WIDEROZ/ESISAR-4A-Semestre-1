package fr.esisar.cookbotStatePatern;

public interface CookBotState {
	public void switchOn(CookBot cookbot);
	public void regularCook(CookBot cookbot);
	public void switchOff(CookBot cookbot);
	public void slowCook(CookBot cookbot);
}
