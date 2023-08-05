package org.example.models;


import org.example.exception.InvalidGameBuilderException;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameStatus gameStatus;
    private int nextPlayerIndex;

    private Player winner;

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
            if(this.players.size()<this.dimension){
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
            game.setMoves(new ArrayList<>());
            game.setPlayers(players);
            game.setNextPlayerIndex(0);


            return game;

        }
    }
}
