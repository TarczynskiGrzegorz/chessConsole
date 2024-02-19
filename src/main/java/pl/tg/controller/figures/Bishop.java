package pl.tg.controller.figures;

import pl.tg.controller.MovePositions;

public class Bishop extends Figure implements CheckMoves {

    public Bishop(FigureColors figureColor) {
        super(figureColor, 'B', '♗');

    }

    public boolean checkMove(FigureColors color, MovePositions movePositions, Figure[][] patchwork) {
//        boolean isInPatchwork = isInPatchwork(movePositions);
//        boolean docelowePolePuste = !isFinalPositionReservedByAliance(color, movePositions, patchwork);
//        boolean naPrzekatnej = isOnDiagonal(movePositions);
//        boolean wolnePoiedzyCelami = !isAnythingBeetween(movePositions, patchwork);
        return !isFinalPositionReservedByAliance(color, movePositions, patchwork) && isOnDiagonal(movePositions) && !isAnythingBeetweenDiagonal(movePositions, patchwork) && isInPatchwork(movePositions);
    }





}
