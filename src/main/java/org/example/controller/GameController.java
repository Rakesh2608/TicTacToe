package org.example.controller;

import org.example.models.Game;
import org.example.models.GameStatus;
import org.example.models.Player;

import java.util.List;

public class GameController {
    public Game createGame(int dimension, List<Player> players){
        try {
            return Game.getBuilder().setDimension(dimension).setPlayers(players).build();
        }
        catch (Exception ex){
            return null;
        }
    }
    public void undo(Game game){

    }
    public void displayBoard(Game game){
        game.displayBoard();
    }
    public Player getWinner(Game game){
        return game.getWinner();
    }
    public void executeNextMove(Game game){

    }
    public GameStatus getGameStatus(Game game){
        return game.getGameStatus();
    }
}
