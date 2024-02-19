package pl.tg.controller;

import pl.tg.controller.figures.FigureColors;

public class MovePositions {

    private int startX=-1;
    private int startY=-1;
    private int finishX=-1;
    private int finishY=-1;

    private FigureColors color = FigureColors.WHITE;

    public MovePositions(int startX, int startY, int finishX, int finishY, FigureColors color) {
        this.startX = startX;
        this.startY = startY;
        this.finishX = finishX;
        this.finishY = finishY;
        this.color = color;
    }

    public FigureColors getColor() {
        return color;
    }

    public void setColor(FigureColors color) {
        this.color = color;
    }

    public MovePositions(){

    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getFinishX() {
        return finishX;
    }

    public void setFinishX(int finishX) {
        this.finishX = finishX;
    }

    public int getFinishY() {
        return finishY;
    }

    public void setFinishY(int finishY) {
        this.finishY = finishY;
    }

    @Override
    public String toString() {
        return "[" + startX + ", " + startY + "]" + "[" + finishX + ", " + finishY + "]";
    }
}
