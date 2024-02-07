package pl.tg.controller.figures;

import pl.tg.controller.MovePositions;

import java.awt.*;

public class Figure {

    private FigureColors colorFigure;
    private char symbol;
    private char displaySymbol;

    public char getDisplaySymbol() {
        return displaySymbol;
    }

    public void setDisplaySymbol(char displaySymbol) {
        this.displaySymbol = displaySymbol;
    }

    private boolean firstMove =true;

    public Figure(FigureColors colorFigure, char symbol, char displaySymbol){
        this.colorFigure = colorFigure;
        this.symbol = symbol;
        this.displaySymbol =displaySymbol;
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
