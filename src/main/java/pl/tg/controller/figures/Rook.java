package pl.tg.controller.figures;

import pl.tg.controller.MovePositions;

import java.awt.*;

public class Rook extends Figure implements CheckMoves {

    public Rook(FigureColors figureColor) {
        super(figureColor, 'R', '♜');

    }

    public boolean checkMove(FigureColors color, MovePositions movePositions, Figure[][] patchwork) {

        return !isFinalPositionReservedByAliance(color, movePositions, patchwork) && (movePositions.getStartX() == movePositions.getFinishX() || movePositions.getStartY() == movePositions.getFinishY()) && !isAnythingBeetwenInLine(movePositions,patchwork);
    }




}
