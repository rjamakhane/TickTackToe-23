package stratergy.WinningStratergy;

import models.Board;
import models.Move;

public interface WinningStratergy {
    public boolean checkWinner(Board board, Move move);
}
