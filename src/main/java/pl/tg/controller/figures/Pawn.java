package pl.tg.controller.figures;

import java.awt.*;
import java.util.Objects;

public class Pawn extends Figure{
    public static final char symbol = '*';
    public Pawn(FigureColors figureColor){
        super(figureColor, '*');
    }
    public Point[] possibleMovesArray(Figure[][] patchwork, int x, int y){
        Point[] points = {new Point(6,7)};
        return points;
    }

    public boolean checkMove(FigureColors color, Point startPostition, Point finalPosition, Figure[][] patchwork){
        return isPossibleMoveForward(color,startPostition,finalPosition, patchwork) || isPossibleMoveDiagonal(color,startPostition,finalPosition, patchwork);
    }
    private boolean isPossibleMoveForward (FigureColors color, Point startPostition, Point finalPosition, Figure[][] patchwork){
        if(color.equals( FigureColors.WHITE)){
            if(Objects.isNull(patchwork[finalPosition.x][finalPosition.y]) && startPostition.x+1== finalPosition.x ||(isFirstMove() && startPostition.x+2== finalPosition.x) ){
                return true;
            }else return false;
        }else{
            if(Objects.isNull(patchwork[finalPosition.x][finalPosition.y]) && startPostition.x-1== finalPosition.x ||(isFirstMove() && startPostition.x-2== finalPosition.x) ){
                return true;
            }else return false;
        }
    }

    private boolean isPossibleMoveDiagonal (FigureColors color, Point startPostition, Point finalPosition, Figure[][] patchwork){
        if(color.equals( FigureColors.WHITE)){
            return  !Objects.isNull(patchwork[finalPosition.x][finalPosition.y]) && patchwork[finalPosition.x][finalPosition.y].getColorFigure().equals(FigureColors.WHITE)  && startPostition.x+1 == finalPosition.x && Math.abs(startPostition.y -finalPosition.y) ==1;
        }else{
            return  !Objects.isNull(patchwork[finalPosition.x][finalPosition.y]) && patchwork[finalPosition.x][finalPosition.y].getColorFigure().equals(FigureColors.WHITE) && startPostition.x-1 == finalPosition.x && Math.abs(startPostition.y -finalPosition.y) ==1;
        }

    }
}
