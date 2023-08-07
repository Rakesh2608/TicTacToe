package org.example.strategies.gameWinningStrategy;

import org.example.models.Board;
import org.example.models.Cell;
import org.example.models.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneGameWinningStrategy implements GameWinningStrategy{
    List<HashMap<Character,Integer>> rowCount=new ArrayList<>();
    List<HashMap<Character,Integer>> colCount=new ArrayList<>();

    HashMap<Character,Integer> topLeftDiagonal=new HashMap<>();
    HashMap<Character,Integer> topRightDiagonal=new HashMap<>();

    public OrderOneGameWinningStrategy(int dimension){
        for(int i=0;i<dimension;i++){
            rowCount.add(new HashMap<>());
            colCount.add(new HashMap<>());
        }
    }
    private boolean isCellTopRightDiagonal(int row,int col,int dimension){
        return row+col==dimension-1;
    }
    private boolean isCellTopLeftDiagonal(int row,int col){
        return row==col;
    }

    @Override
    public boolean checkWinner(Board board, Player playerToMove, Cell cell) {

    char symbol=cell.getPlayer().getSymbol();
    int row=cell.getRow();
    int col=cell.getCol();
    int dimension=board.getBoard().size();

    //rowCountHashMap
    if(!rowCount.get(row).containsKey(symbol)){
        rowCount.get(row).put(symbol,0);
    }
    rowCount.get(row).put(symbol,rowCount.get(row).get(symbol)+1);

    //colCountHashMap
        if(!colCount.get(col).containsKey(symbol)){
            colCount.get(col).put(symbol,0);
        }
        colCount.get(col).put(symbol,colCount.get(col).get(symbol)+1);

        //topRightDiagonal
    if(isCellTopRightDiagonal(row,col,dimension)){
        if(!topRightDiagonal.containsKey(symbol)){
            topRightDiagonal.put(symbol,0);
        }
        topRightDiagonal.put(symbol,topRightDiagonal.get(symbol)+1);
    }

    //topLeftDiagonal
    if(isCellTopLeftDiagonal(row,col)){
            if(!topLeftDiagonal.containsKey(symbol)){
                topLeftDiagonal.put(symbol,0);
            }
            topLeftDiagonal.put(symbol,topLeftDiagonal.get(symbol)+1);
    }

    if(rowCount.get(row).get(symbol)==dimension||colCount.get(col).get(symbol)==dimension){
        return true;
    }

    if(isCellTopRightDiagonal(row,col,dimension)&&topRightDiagonal.get(symbol)==dimension){
        return true;
    }
    if(isCellTopLeftDiagonal(row,col)&&topLeftDiagonal.get(symbol)==dimension){
        return true;
    }
        return false;
    }
}
