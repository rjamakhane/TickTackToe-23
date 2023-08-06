import models.Bot;
import models.BotDifficultyLevel;
import models.Player;
import models.PlayerType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to TickTakToe");
        System.out.println("******************************");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the board dimenstion (n * n) board:");
        int dimensions = scanner.nextInt();

        List<Player> players = new ArrayList<>();

        System.out.println("Is bot allowed? y/ n :");
        Boolean isBot = Objects.equals(scanner.next(), "y");
        int numberOfPlayers = dimensions - 1;
        if(isBot){
            numberOfPlayers = dimensions - 2;
            System.out.println("Enter the name of the bot:");
            String botName = scanner.next();

            System.out.println("Enter the symbol of the bot:");
            String botSymbol = scanner.next();

            players.add(new Bot(botName, botSymbol.charAt(0), BotDifficultyLevel.EASY)); //TODO: bot difficulty level is hardcoded for no
        }

        for(int i=0; i<numberOfPlayers; i++){
            System.out.println("Enter the player "+(i+1)+" name");
            String name = scanner.next();

            System.out.println("Enter the player "+(i+1)+" symbol");
            String symbol = scanner.next();

            players.add(new Player(name,symbol.charAt(0), PlayerType.HUMAN));
        }





    }
}