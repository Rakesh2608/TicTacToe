package org.example;

import org.example.controller.GameController;
import org.example.exception.InvalidGameBuilderException;
import org.example.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidGameBuilderException {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the dimension of the Board:");
        int dimension=sc.nextInt();

        System.out.println("Will there be any BOT? y/n");
        String isBot=sc.next();

        List<Player> players=new ArrayList<>();

        //int numberOfPlayers=dimension-1;
        int numberOfHumanPlayers=dimension-1;
        if(isBot.equals("y")){
            numberOfHumanPlayers=numberOfHumanPlayers-1;
            System.out.println("What is the name of BOT");
            String botName=sc.next();

            System.out.println("What is the symbol of BOt");
            String botSymbol=sc.next();

            players.add(new Bot(botSymbol.charAt(0),botName, BotDifficultyLevel.EASY));

        }

        for (int i=0;i<numberOfHumanPlayers;i++){
            System.out.println("What is the name of Human Player "+ (i+1));
            String humanName=sc.next();

            System.out.println("Enter the Symbol of Human Player:"+(i+1));
            String humanSymbol=sc.next();;

            players.add(new Player(humanName,humanSymbol.charAt(0), PlayerType.HUMAN));

        }

       // Game game=Game.getBuilder().setDimension(dimension).setPlayers(players).build();

        GameController gameController=new GameController();
        Game game=gameController.createGame(dimension,players);

        while(game.getGameStatus().equals(GameStatus.IN_PROGRESS)){
            System.out.println("This is the current board: ");
            gameController.displayBoard(game);

            System.out.println("Do you want to undo y/n");

            String isUndo=sc.next();
            if(isUndo.equals("y")){
                gameController.undo(game);
            }else{
                gameController.executeNextMove(game);
            }

        }

        //someone has won the game or draw
        System.out.println("Game has ended !!!");
        if(game.getGameStatus().equals(GameStatus.ENDED)){
            System.out.println("Winner is "+gameController.getWinner(game).getName());
        }
    }

}