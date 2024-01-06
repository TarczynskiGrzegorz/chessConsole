package pl.tg.controller.figures;

public class Figure {

    private FigureColors colorFigure;
    private char symbol;

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
}
