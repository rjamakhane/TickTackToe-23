package models;

import java.util.Scanner;

public class Player {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayer() {
        return player;
    }

    public void setPlayer(PlayerType player) {
        this.player = player;
    }

    private char symbol;

    private PlayerType player;

    Scanner scanner = new Scanner(System.in);

    public Player(String name, char symbol, PlayerType player){
        this.name = name;
        this.symbol = symbol;
        this.player = player;
    }

    public Move decideMove(){
        System.out.println("Enter the row to move:");
        int row = scanner.nextInt();

        System.out.println("Enter the col to move:");
        int col = scanner.nextInt();

        return new Move(this, new Cell(row, col));
    }
}
