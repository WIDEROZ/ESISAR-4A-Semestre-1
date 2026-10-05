package fr.esisar.cookbot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CookStateTest {
	private CookBot cookBot;

	@BeforeEach
	void initializeCookBot() {
		cookBot = new CookBot();
		cookBot.regularCook();
		assertEquals(CookBot.COOK, cookBot.getState());
	}

	@Test
	void switchOn() {
		cookBot.switchOn();
		assertEquals(CookBot.ON, cookBot.getState());
	}

	@Test
	void regularCook() {
		cookBot.regularCook();
		assertEquals(CookBot.COOK, cookBot.getState());
	}

	@Test
	void slowCook() {
		cookBot.slowCook();
		assertEquals(CookBot.SLOW_COOK, cookBot.getState());
	}

	@Test
	void switchOff() {
		cookBot.switchOn();
		cookBot.switchOff();
		assertEquals(CookBot.OFF, cookBot.getState());
	}
}
