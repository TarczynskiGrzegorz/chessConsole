package pl.tg.controller.figures;

import pl.tg.controller.MovePositions;

import java.awt.*;

public class Figure {

    private FigureColors colorFigure;
    private char symbol;
    private boolean firstMove =true;

    public Figure(FigureColors colorFigure, char symbol){
        this.colorFigure = colorFigure;
        this.symbol = symbol;
    }
    public void move(){

    }


    public char getSymbol() {
        return symbol;
    }
    public FigureColors getColorFigure(){
        return colorFigure;
    }

    public boolean isFirstMove() {
        return firstMove;
    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }

    public Point[] possibleMovesArray(Figure[][] patchwork, int x, int y){
        return null;
    }
    public boolean checkMove(FigureColors color, MovePositions movePositions, Figure[][] patchwork){
        return true;
    }


}
