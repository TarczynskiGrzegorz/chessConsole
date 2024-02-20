package pl.tg.controller.figures;

import pl.tg.controller.MovePositions;

public class Queen extends Figure implements CheckMoves {
    public Queen(FigureColors figureColor) {
        super(figureColor, 'Q', '♛');

    }


    public boolean checkMove(FigureColors color, MovePositions movePositions, Figure[][] patchwork) {
        boolean isIn  = isInPatchwork(movePositions);
        boolean isNotFinalByAliance =!isFinalPositionReservedByAliance(color, movePositions, patchwork);
        boolean isFreeWay =!isAnythingBetween(movePositions,patchwork);
        return isInPatchwork(movePositions) && !isFinalPositionReservedByAliance(color, movePositions, patchwork) && !isAnythingBetween(movePositions,patchwork);
    }

    private boolean isAnythingBetween(MovePositions movePositions, Figure[][] patchwork) {
        if (isOnLine(movePositions)) {
            return  isAnythingBeetwenInLine(movePositions, patchwork);
        } else if (isOnDiagonal(movePositions)) {
            return isAnythingBeetweenDiagonal(movePositions, patchwork);
        } else {
            return true;
        }

    }
}

