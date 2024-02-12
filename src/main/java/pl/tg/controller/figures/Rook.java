package pl.tg.controller.figures;

import pl.tg.controller.MovePositions;

import java.awt.*;

public class Rook extends Figure implements CheckMoves {

    public Rook(FigureColors figureColor) {
        super(figureColor, 'R', '♜');

    }

    public boolean checkMove(FigureColors color, MovePositions movePositions, Figure[][] patchwork) {

        return !isFinalPositionReservedByAliance(color, movePositions, patchwork) && (movePositions.getStartX() == movePositions.getFinishX() || movePositions.getStartY() == movePositions.getFinishY()) && isAnythingBeetwen(movePositions,patchwork);
    }

    private boolean isAnythingBeetwen(MovePositions movePositions, Figure[][] patchwork) {
        int start;
        int finish;
        if (movePositions.getStartX() == movePositions.getFinishX()) {
            if (movePositions.getStartY() < movePositions.getFinishY()) {
                start = movePositions.getStartY();
                finish = movePositions.getFinishY();
            } else {
                start = movePositions.getFinishY();
                finish = movePositions.getStartY();
            }
            for (int i = start + 1; i < finish; i++) {
                if (patchwork[movePositions.getStartX()][i] != null) {
                    System.out.println("przeszkoda");
                    return false;
                }
            }
            return true;
        } else if (movePositions.getStartY() == movePositions.getFinishY()) {
            if (movePositions.getStartX() < movePositions.getFinishX()) {
                start = movePositions.getStartX();
                finish = movePositions.getFinishX();
            } else {
                start = movePositions.getFinishX();
                finish = movePositions.getStartX();
            }
            for (int i = start + 1; i < finish; i++) {
                if (patchwork[i][movePositions.getStartY()] != null) {
                    System.out.println("przeszkoda");
                    return false;
                }
            }
            return true;
        } else return false;

    }



}
