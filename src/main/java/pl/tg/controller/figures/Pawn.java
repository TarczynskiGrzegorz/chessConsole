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

    public boolean checkMove(FigureColors color, Point startPostition, Point finalPosition, Figure[][] patchwork){
        if(color.equals( FigureColors.WHITE)){
            if (startPostition.y == finalPosition.y ||startPostition.x +1 == finalPosition.x){
                return true;
            }else return false;
        }else{
            if (startPostition.y == finalPosition.y ||startPostition.x -1 == finalPosition.x){
                return true;
            }else return false;
        }
    }
}
