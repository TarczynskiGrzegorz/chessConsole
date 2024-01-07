package pl.tg.controller.figures;

import java.awt.*;

public class King extends Figure{
    public King(FigureColors figureColor){
        super(figureColor, 'K');
    }

    public Point[] possibleMovesArray(Figure[][] patchwork, int x, int y){
        Point[] points = {new Point(6,2)};
        return points;
    }
}
