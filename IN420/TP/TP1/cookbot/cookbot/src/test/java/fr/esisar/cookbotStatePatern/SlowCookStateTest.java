package fr.esisar.cookbotStatePatern;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class SlowCookStateTest {
	private CookBot cookBot;

	@BeforeEach
	void initializeCookBot() {
		cookBot = new CookBot();
		cookBot.slowCook();
		assertInstanceOf(SlowCookState.class, cookBot.getState());
	}

	@Test
	void switchOn() {
		cookBot.switchOn();
		assertInstanceOf(OnState.class, cookBot.getState());
	}

	@Test
	void regularCook() {
		cookBot.regularCook();
		assertInstanceOf(CookState.class, cookBot.getState());
	}

	@Test
	void slowCook() {
		cookBot.slowCook();
		assertInstanceOf(SlowCookState.class, cookBot.getState());
	}

	@Test
	void switchOff() {
		cookBot.switchOff();
		assertInstanceOf(SlowCookState.class, cookBot.getState());
	}
}
