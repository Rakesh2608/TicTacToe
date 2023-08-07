package org.example.models;


import org.example.exception.InvalidGameBuilderException;
import org.example.strategies.gameWinningStrategy.GameWinningStrategy;
import org.example.strategies.gameWinningStrategy.OrderOneGameWinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameStatus gameStatus;
    private int nextPlayerIndex;
    private Player winner;
    private GameWinningStrategy gameWinningStrategy;
    public GameWinningStrategy getGameWinningStrategy() {
        return gameWinningStrategy;
    }
    public void setGameWinningStrategy(GameWinningStrategy gameWinningStrategy) {
        this.gameWinningStrategy = gameWinningStrategy;
    }
    public Player getWinner() {
        return winner;
    }
    public void setWinner(Player winner) {
        this.winner = winner;
    }
    public Board getBoard() {
        return board;
    }
    public void setBoard(Board board) {
        this.board = board;
    }
    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    public List<Move> getMoves() {
        return moves;
    }
    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }
    public GameStatus getGameStatus() {
        return gameStatus;
    }
    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }
    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }
    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }
    public static Builder getBuilder(){
        return  new Builder();
    }

    public void displayBoard(){
        this.board.display();
    }

    public void makeNextMove(){
        //which player turn is next?
        Player playerToMove=players.get(nextPlayerIndex);
        System.out.println("It is "+playerToMove.getName()+"'s turn");

        System.out.println(playerToMove.getName());
        Move move=playerToMove.decideMove(this.board);
        //validate the move decided by the player.
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();

        System.out.println("Player is making move at ("+row+","+col+")");

        //Assumption: move is valid.
        board.getBoard().get(row).get(col).setCellState(CellState.FILLED);
        board.getBoard().get(row).get(col).setPlayer(playerToMove);
        //Add this move to list of move
        this.moves.add(move);

        //check the winner
        if(gameWinningStrategy.checkWinner(board,playerToMove,move.getCell())){
            this.setGameStatus(GameStatus.ENDED);
            winner=playerToMove;
        }

        //check for undo

        //check for DRAW

        //move to next player
        nextPlayerIndex+=1;
        nextPlayerIndex%=players.size();
    }

    public static class Builder{
        private int dimension;
        private List<Player> players;
        public int getDimension() {
            return dimension;
        }
        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }
        public List<Player> getPlayers() {
            return players;
        }
        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }
        public boolean isValid() throws InvalidGameBuilderException {
            if(this.dimension<3){
                throw new InvalidGameBuilderException("Invalid dimension given");
            }
            if(this.players.size()!=this.dimension-1){
                throw new InvalidGameBuilderException("Invalid Player Inputs given");
            }

            //more validations.
            return true;
        }

        public Game build() throws InvalidGameBuilderException {
            isValid();

            Game game=new Game();
            game.setBoard(new Board(dimension));
            game.setGameStatus(GameStatus.IN_PROGRESS);
            game.setPlayers(players);
            game.setMoves(new ArrayList<>());
            game.setNextPlayerIndex(0);
            game.setGameWinningStrategy(new OrderOneGameWinningStrategy(dimension));
            return game;

        }
    }
}
