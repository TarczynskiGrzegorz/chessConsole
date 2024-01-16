package pl.tg.processor;

import pl.tg.controller.GameController;
import pl.tg.controller.figures.Figure;
import pl.tg.controller.figures.FigureColors;
import pl.tg.controller.figures.Pawn;

import java.awt.*;

public class Processor {
    private GameController gameController;
    private Figure[][] patchwork;

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
        patchwork = gameController.getPatchWork();
    }

    public Point[] translateNotation(String move, Figure[][] patchwork, FigureColors color) {
        char[] moveCharArray = move.toCharArray();

        Point start = new Point(translateRowName(moveCharArray[1]), translateColumnName(moveCharArray[0]));
        Point end = new Point(translateRowName(moveCharArray[1]), translateColumnName(moveCharArray[0]));
        Point[] result = {start, end};


//        Point startPosition = new Point() ;
//        Point finalPosition = new Point(translateColumnName(moveCharArray[0]), translateRowName(moveCharArray[1]));
//
        switch (moveCharArray.length) {
            case 2:
                start.x = getRowForPawn(color, end.x, end.y);
                start.y = end.y;
                break;
            case 3:
                System.out.println("3");
                break;
            default:
                System.out.println("default");
        }
        return result;
//        Point[] points = {startPosition, finalPosition};
//        return points;
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

    private int translateRowName(char rowName) {
        System.out.println(rowName);
        return Integer.parseInt(String.valueOf(rowName)) - 1;
    }

    private int getRowForPawn(FigureColors color, int row, int column) {
        if (color.equals(FigureColors.WHITE)) {
            for (int i = row; i >= 0; i--) {
                if (patchwork[i][column] != null && patchwork[i][column].getSymbol() == Pawn.symbol && patchwork[i][column].getColorFigure().equals(color)) {
                    return i;
                }
            }
        } else {
            for (int i = row; i < patchwork.length; i++) {
                if (patchwork[i][column] != null && patchwork[i][column].getSymbol() == Pawn.symbol && patchwork[i][column].getColorFigure().equals(color)) {
                    return i;
                }
            }
        }
        return -1;
    }

}
