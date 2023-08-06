package org.example.strategies.gameWinningStrategy;

import org.example.models.Board;
import org.example.models.Cell;
import org.example.models.Player;

public interface GameWinningStrategy {
    boolean checkWinner(Board board, Player playerToMove, Cell cell);

}
