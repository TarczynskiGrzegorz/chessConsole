package pl.tg.figures;

public class Figure {
    private int posX;
    private int posY;
    private FigureColors colorFigure;
    private char symbol;

    public Figure(int posX, int posY, String colorFigure, char symbol){
        this.posX = posX;
        this.posY = posY;
        this.colorFigure = colorFigure.equals("B")  ? FigureColors.BLACK : FigureColors.WHITE;
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
