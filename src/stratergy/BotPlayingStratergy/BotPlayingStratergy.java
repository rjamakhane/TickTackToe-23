package stratergy.BotPlayingStratergy;

import models.Board;
import models.Move;
import models.Player;

public interface BotPlayingStratergy {
    public Move decideMove(Player player, Board board);
}
