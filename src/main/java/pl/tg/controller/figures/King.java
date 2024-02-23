package pl.tg.controller.figures;

import pl.tg.controller.MovePositions;

import java.awt.*;

public class King extends Figure {
    public King(FigureColors figureColor) {
        super(figureColor, 'K', '♚');
    }

    public Point[] possibleMovesArray(Figure[][] patchwork, int x, int y) {
        Point[] points = {new Point(6, 2)};
        return points;
    }

    @Override
    public boolean checkMove(FigureColors color, MovePositions movePositions, Figure[][] patchwork) {
        int startX = movePositions.getStartX();
        int finishX = movePositions.getFinishX();
        int startY = movePositions.getStartY();
        int finishY = movePositions.getFinishY();
        boolean isFree = patchwork[finishX][finishY] == null;
        boolean isFinalPositionReservedByAliance = patchwork[finishX][finishY].getColorFigure().equals(color);
        boolean isInRangeofMove = (Math.abs(startX - finishX) == 1 || Math.abs(startX - finishX) == 0) && (Math.abs(startY - finishY) == 1 || Math.abs(startY - finishY) == 0);
        return (isFree || !isFinalPositionReservedByAliance) && isInRangeofMove;
    }
}
