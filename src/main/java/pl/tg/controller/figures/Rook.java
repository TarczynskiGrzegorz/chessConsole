package pl.tg.controller.figures;

import pl.tg.controller.MovePositions;

import java.awt.*;

public class Rook extends Figure{

    public Rook(FigureColors figureColor){
        super(figureColor, 'I');

    }
    public boolean checkMove(FigureColors color, MovePositions movePositions, Figure[][] patchwork){
        return movePositions.getStartX() == movePositions.getFinishX() || movePositions.getStartY() == movePositions.getFinishY();
    }


}
