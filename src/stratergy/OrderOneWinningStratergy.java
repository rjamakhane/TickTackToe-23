package stratergy;

import models.Board;
import models.Move;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneWinningStratergy implements WinningStratergy{
    List<HashMap<Character, Integer>> rowSymbolsCount = new ArrayList<>();
    List<HashMap<Character, Integer>> columnSybmolCount = new ArrayList<>();
    HashMap<Character, Integer> topLeftDiagonalSymbolCount = new HashMap<>();
    HashMap<Character, Integer> topRightDiagonalSymbolCount = new HashMap<>();

    public OrderOneWinningStratergy(int dimension){
        for(int i=0; i<dimension; i++){
            rowSymbolsCount.add(new HashMap<>());
            columnSybmolCount.add(new HashMap<>());
        }
    }

    public boolean isCellOnTopLeftDiagonal(int row, int col){
        return row == col;
    }

    public boolean isCellOnTopRightDiagonal(int row, int col, int dimension){
        return row + col == dimension-1;
    }

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Character symbol = move.getCell().getPlayer().getSymbol();
        int dimension = board.getBoard().size();

        //update the hashmap values
        if(!rowSymbolsCount.get(row).containsKey(symbol)){
            rowSymbolsCount.get(row).put(symbol, 0);
        }

        rowSymbolsCount.get(row).put(symbol, rowSymbolsCount.get(row).get(symbol) + 1);

        if(!columnSybmolCount.get(col).containsKey(symbol)){
            columnSybmolCount.get(col).put(symbol, 0);
        }
        columnSybmolCount.get(col).put(symbol, columnSybmolCount.get(col).get(symbol)+  1);

        if(isCellOnTopLeftDiagonal(row,col)){
            if(!topLeftDiagonalSymbolCount.containsKey(symbol)){
                topLeftDiagonalSymbolCount.put(symbol, 0);
            }
            topLeftDiagonalSymbolCount.put(symbol, topLeftDiagonalSymbolCount.get(symbol) + 1);
        }

        if(isCellOnTopRightDiagonal(row, col, dimension)){
            if(!topRightDiagonalSymbolCount.containsKey(symbol)){
                topRightDiagonalSymbolCount.put(symbol, 0);
            }
            topRightDiagonalSymbolCount.put(symbol, topRightDiagonalSymbolCount.get(symbol) + 1);
        }

        //check the winner now
        if(rowSymbolsCount.get(row).get(symbol) == dimension || columnSybmolCount.get(col).get(symbol) == dimension){
            return  true;
        }

        if(isCellOnTopLeftDiagonal(row, col) && topLeftDiagonalSymbolCount.get(symbol) == dimension){
            return true;
        }

        if(isCellOnTopRightDiagonal(row, col, dimension) && topRightDiagonalSymbolCount.get(symbol) == dimension){
            return  true;
        }

        return false;
    }
}
