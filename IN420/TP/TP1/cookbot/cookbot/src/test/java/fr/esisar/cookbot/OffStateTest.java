package fr.esisar.cookbot;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OffStateTest {
	private CookBot cookBot;

	@BeforeEach
	void initializeCookBot() {
		cookBot = new CookBot();
		cookBot.switchOff();
		assertEquals(CookBot.OFF, cookBot.getState());
	}

	@Test
	void switchOn() {
		cookBot.switchOn();
		assertEquals(CookBot.ON, cookBot.getState());
	}

	@Test
	void regularCook() {
		cookBot.switchOn();
		cookBot.regularCook();
		assertEquals(CookBot.COOK, cookBot.getState());
	}

	@Test
	void slowCook() {
		cookBot.switchOn();
		cookBot.slowCook();
		assertEquals(CookBot.SLOW_COOK, cookBot.getState());
	}

	@Test
	void switchOff() {
		cookBot.switchOff();
		assertEquals(CookBot.OFF, cookBot.getState());
	}

}
