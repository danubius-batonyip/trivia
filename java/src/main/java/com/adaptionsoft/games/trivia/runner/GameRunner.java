
package com.adaptionsoft.games.trivia.runner;
import java.util.Random;

import com.adaptionsoft.games.uglytrivia.Game;
import com.adaptionsoft.games.uglytrivia.GameOutputImpl;
import com.adaptionsoft.games.uglytrivia.Output;
import com.adaptionsoft.games.uglytrivia.TimeProvider;

public class GameRunner {

	private static boolean notAWinner;

	public static void main(String[] args) {
		Random rand = new Random();
		Output output = new GameOutputImpl();
		TimeProvider timeProvider = new SystemTimeProvider();
		run(rand, output, timeProvider);
	}

	public static void run(Random rand, Output output, TimeProvider timeProvider) {
		Game aGame = new Game(output);

		aGame.add("Chet");
		aGame.add("Pat");
		aGame.add("Sue");

		Long startTime = timeProvider.getTimeMilis();

		do {

			aGame.roll(rand.nextInt(5) + 1);

			if (rand.nextInt(9) == 7) {
				notAWinner = aGame.wrongAnswer();
			} else {
				notAWinner = aGame.wasCorrectlyAnswered();
			}

			Long currentTime = timeProvider.getTimeMilis();
			if (currentTime - startTime >= 25*60*60*1000) {
				notAWinner = false;
			}

		} while (notAWinner);

		output.println("Winner: " + aGame.getWinner());
	}
}
