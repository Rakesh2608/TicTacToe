package org.example.factories;

import org.example.models.BotDifficultyLevel;
import org.example.strategies.gameWinningStrategy.botPlayingStrategy.BotPlayingStrategy;
import org.example.strategies.gameWinningStrategy.botPlayingStrategy.RandomBotPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel difficultyLevel){
            if(difficultyLevel.equals(BotDifficultyLevel.EASY)){
                return new RandomBotPlayingStrategy();
            }
            return null;
    }
}
