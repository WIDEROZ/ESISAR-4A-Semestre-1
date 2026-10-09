package fr.esisar.cookbotStatePatern;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.esisar.cookbot.CookBot;

public class OffStateTest {
	private CookBot cookBot;

	@BeforeEach
	void initializeCookBot() {
		cookBot = new CookBot();
		cookBot.switchOff();
		assertInstanceOf(OffState.class, cookBot.getState());
	}

	@Test
	void switchOn() {
		cookBot.switchOn();
		assertInstanceOf(OnState.class, cookBot.getState());
	}

	@Test
	void regularCook() {
		cookBot.regularCook();
		assertInstanceOf(OffState.class, cookBot.getState());
	}

	@Test
	void slowCook() {
		cookBot.slowCook();
		assertInstanceOf(OffState.class, cookBot.getState());
	}

	@Test
	void switchOff() {
		cookBot.switchOff();
		assertInstanceOf(OffState.class, cookBot.getState());
	}
}
