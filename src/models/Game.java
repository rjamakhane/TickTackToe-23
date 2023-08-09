package models;

import exception.InvalidDimension;
import exception.InvalidNumberOfPlayers;
import stratergy.OrderOneWinningStratergy;
import stratergy.WinningStratergy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameStatus gameStatus;
    private int nextPlayerIndex;
    private Player winner;

    public WinningStratergy getWinningStratergy() {
        return winningStratergy;
    }

    public void setWinningStratergy(WinningStratergy winningStratergy) {
        this.winningStratergy = winningStratergy;
    }

    private WinningStratergy winningStratergy;

    private void Board(){};

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

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public static class Builder {
        int dimensions;
        private List<Player> players;

        public int getDimensions() {
            return dimensions;
        }

        public Builder setDimensions(int dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        private void isValid() throws InvalidDimension, InvalidNumberOfPlayers {
            if(this.players.size() < this.dimensions - 1){
                throw new InvalidNumberOfPlayers("Number of Players should be n-1");
            } else if(this.dimensions < 3){
                throw new InvalidDimension("Invalid dimesntion specified");
            }
        }

        public Game build(){

            try{
                isValid();
            } catch (InvalidNumberOfPlayers e){
                System.out.println(e.getMessage());
                return null;
            } catch (InvalidDimension e){
                System.out.println(e.getMessage());
                return null;
            }

            Game game = new Game();
            game.setPlayers(players);
            game.setGameStatus(GameStatus.IN_PROGRESS);
            game.setNextPlayerIndex(0);
            game.setMoves(new ArrayList<>());
            game.setBoard(new Board(dimensions));
            game.setWinningStratergy(new OrderOneWinningStratergy(dimensions));

            return game;

        };
    }

    public void makeNextMove(){
        Player playerToMove = players.get(nextPlayerIndex);
        System.out.println("It is " + playerToMove.getName() + "'s turn");
        Move move = playerToMove.decideMove();

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if(board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY)){
            //move is valid
            board.applyMove(move);
            moves.add(move);

            //check if he is winner
            if(winningStratergy.checkWinner(board, move)){
                gameStatus = GameStatus.WON;
                winner = playerToMove;
            }


            nextPlayerIndex += 1;
            nextPlayerIndex %= players.size();
        } else {
            //throw some exception
        }
    }
}
