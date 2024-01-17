package pl.tg.controller.figures;

import java.awt.*;

public class Rook extends Figure{

    public Rook(FigureColors figureColor){
        super(figureColor, 'I');

    }
    public boolean checkMove(FigureColors color, Point startPostition, Point finalPosition, Figure[][] patchwork){
        return startPostition.x == finalPosition.x || startPostition.y == finalPosition.y;
    }


}
