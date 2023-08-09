package controllers;

import models.Game;
import models.GameStatus;
import models.Player;

import java.util.List;

public class GameController {

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    private Game game;
    public GameController(int dimensions, List<Player> players){
        this.game = new Game.Builder().setDimensions(dimensions).setPlayers(players).build();
    }

    public GameStatus getGameStatus(){
        return game.getGameStatus();
    }

    public void displayBoard(){
        game.getBoard().displayBoard();
    }

    public void executeNextMove(){
        game.makeNextMove();
    }

    public String getWinner(){
        return game.getWinner().getName();
    }
}
