package factories;

import models.BotDifficultyLevel;
import stratergy.BotPlayingStratergy.BotPlayingStratergy;
import stratergy.BotPlayingStratergy.EasyBotPlayingStratergy;

public class BotPlayingStratergyFactory {
    public static BotPlayingStratergy getBotPlayingStrategyForDifficultyLevel(BotDifficultyLevel botDifficultyLevel){
        if(botDifficultyLevel.equals(BotDifficultyLevel.EASY)){
            return new EasyBotPlayingStratergy();
        }

        return null;
    }
}
