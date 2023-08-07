package org.example.strategies.gameWinningStrategy.botPlayingStrategy;

import org.example.models.Board;
import org.example.models.Move;
import org.example.models.Player;

public interface BotPlayingStrategy {

    public Move makeMove(Player player, Board board);
}
