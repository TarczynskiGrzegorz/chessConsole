package pl.tg.controller.figures;

import java.awt.*;

public class Pawn extends Figure{
    public Pawn(FigureColors figureColor){
        super(figureColor, '*');
    }
    public Point[] possibleMovesArray(Figure[][] patchwork, int x, int y){
        Point[] points = {new Point(6,7)};
        return points;
    }
}
