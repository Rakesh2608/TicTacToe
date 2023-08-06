package org.example.models;

public class Bot extends Player {
	

	private BotDifficultyLevel botDifficultyLevel;
	 public Bot(char symbol, String name ,BotDifficultyLevel botDifficultyLevel) {
			super(name,symbol, PlayerType.BOT);
			this.botDifficultyLevel=botDifficultyLevel;

		}

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
