package org.example.models;


import java.util.Scanner;

public class Player {
    private char symbol;
    private String name;
    private PlayerType type;

    Scanner sc=new Scanner(System.in);
    public Player(String name,char symbol,PlayerType type) {
    	this.name=name;
    	this.symbol=symbol;
    	this.type=type;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getType() {
        return type;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }
    public Move decideMove(Board board) {
        System.out.println("Please enter the row for your move:");
        int row=sc.nextInt();
        System.out.println("Please enter the col for your move:");
        int col=sc.nextInt();

        return new Move(this,new Cell(this,row,col,CellState.FILLED));

    }
}
