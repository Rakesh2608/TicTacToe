package org.example.models;

import org.example.factories.BotPlayingStrategyFactory;
import org.example.strategies.gameWinningStrategy.botPlayingStrategy.BotPlayingStrategy;
import org.example.strategies.gameWinningStrategy.botPlayingStrategy.RandomBotPlayingStrategy;

public class Bot extends Player {
    private BotPlayingStrategy botPlayingStrategy;
	private BotDifficultyLevel botDifficultyLevel;
	 public Bot(char symbol, String name ,BotDifficultyLevel botDifficultyLevel) {
			super(name,symbol, PlayerType.BOT);
			this.botDifficultyLevel=botDifficultyLevel;
            this.botPlayingStrategy= BotPlayingStrategyFactory.getBotPlayingStrategy(botDifficultyLevel);

		}

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public Move decideMove(Board board){
         return botPlayingStrategy.makeMove(this,board);
    }
}
