package fr.esisar.cookbot;

public class CookBotTestDrive {

	public static void main(String[] args) {
		CookBot cookBot = new CookBot();
		cookBot.switchOn();
		cookBot.regularCook();
		cookBot.switchOn();
		cookBot.switchOff();

		cookBot.switchOn();
		cookBot.switchOff();
		cookBot.regularCook();
	}

}
