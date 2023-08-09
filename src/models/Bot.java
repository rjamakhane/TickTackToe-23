package models;

import factories.BotPlayingStratergyFactory;
import stratergy.BotPlayingStratergy.BotPlayingStratergy;

public class Bot extends Player{

    private BotDifficultyLevel botDifficultyLevel;

    public BotPlayingStratergy getBotPlayingStratergy() {
        return botPlayingStratergy;
    }

    public void setBotPlayingStratergy(BotPlayingStratergy botPlayingStratergy) {
        this.botPlayingStratergy = botPlayingStratergy;
    }

    private BotPlayingStratergy botPlayingStratergy;
    public Bot(String name, char symbol, BotDifficultyLevel botDifficultyLevel) {
        super(name, symbol, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStratergy = BotPlayingStratergyFactory.getBotPlayingStrategyForDifficultyLevel(botDifficultyLevel);

    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }


    @Override
    public Move decideMove(Board board) {
        return botPlayingStratergy.decideMove(this, board);
    }
}
