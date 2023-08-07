package org.example.strategies.gameWinningStrategy.botPlayingStrategy;


import org.example.models.*;

public class RandomBotPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Move makeMove(Player player, Board board) {
        for(int i=0;i<board.getBoard().size();i++){
            for(int j=0;j<board.getBoard().size();j++){
                if(board.getBoard().get(i).get(j).getCellState().equals(CellState.EMPTY)){
                    //bot can make move in i,j cell
                    return new Move(player,new Cell(player,i,j,CellState.FILLED));
                }
            }
        }
        return  null;
    }
}
