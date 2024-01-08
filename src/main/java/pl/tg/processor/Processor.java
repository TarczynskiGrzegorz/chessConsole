package pl.tg.processor;

import pl.tg.controller.GameController;
import pl.tg.controller.figures.Figure;
import pl.tg.controller.figures.FigureColors;

import java.awt.*;

public class Processor {
    private GameController gameController;

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    public Point[] translateNotation(String move, Figure[][] patchwork, FigureColors color) {
        char[] moveCharArray = move.toCharArray();
        Point startPosition = new Point() ;
        Point finalPosition = new Point();

        switch (moveCharArray.length) {
            case 2:
                startPosition.x = getRowForPawn(color,moveCharArray[1]);
                startPosition.y = translateColumnName(moveCharArray[0]);
                finalPosition.x = Integer.parseInt(String.valueOf(moveCharArray[1]));
                finalPosition.y = startPosition.y;
                break;
            case 3:
                System.out.println("3");
                break;
            default:
                System.out.println("default");
        }
        Point[] points = {startPosition, finalPosition};
        return points;
    }

    private int translateColumnName(char columnName) {
        int columnNumber;
        switch (columnName) {
            case 'a':
                columnNumber = 0;
                break;
            case 'b':
                columnNumber = 1;
                break;
            case 'c':
                columnNumber = 2;
                break;
            case 'd':
                columnNumber = 3;
                break;
            case 'e':
                columnNumber = 4;
                break;
            case 'f':
                columnNumber = 5;
                break;
            case 'g':
                columnNumber = 6;
                break;
            case 'h':
                columnNumber = 7;
                break;
            default:
                columnNumber = 10;
        }
        return columnNumber;
    }

    private int getRowForPawn(FigureColors color, char destinationRow) {
        int result = Integer.parseInt(String.valueOf(destinationRow)) -1;
        if(color.equals(FigureColors.WHITE)){
            result--;
        }else{
            result++;
        }
        return  result;
    }

}
