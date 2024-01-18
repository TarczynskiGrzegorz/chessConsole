package pl.tg.processor;

import pl.tg.controller.GameController;
import pl.tg.controller.MovePositions;
import pl.tg.controller.figures.Figure;
import pl.tg.controller.figures.FigureColors;
import pl.tg.controller.figures.Pawn;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Processor {
    private GameController gameController;
    private Figure[][] patchwork;
    private MovePositions movePositions ;

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
        patchwork = gameController.getPatchWork();
        movePositions = gameController.getMovePositions();
    }

    public void translateNotation(String move) {
        char[] moveCharArray = move.toCharArray();


//        Point startPosition = new Point() ;
//        Point finalPosition = new Point(translateColumnName(moveCharArray[0]), translateRowName(moveCharArray[1]));
//
        switch (moveCharArray.length) {
            case 2:
                movePositions.setFinishX(translateRowName(moveCharArray[moveCharArray.length - 1]));
                movePositions.setFinishY(translateColumnName(moveCharArray[moveCharArray.length - 2]));
                movePositions.setStartX(getRowForPawn(translateRowName(moveCharArray[moveCharArray.length - 1]), translateColumnName(moveCharArray[moveCharArray.length - 2])));
                movePositions.setStartY(movePositions.getFinishY());
                break;
            case 3:
                movePositions.setFinishX(translateRowName(moveCharArray[moveCharArray.length - 1]));
                movePositions.setFinishY(translateColumnName(moveCharArray[moveCharArray.length - 2]));
                findStartPosition(moveCharArray[0]);
            default:
                System.out.println("default");
        }

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

    private int getRowForPawn(int row, int column) {
        if (movePositions.getColor().equals(FigureColors.WHITE)) {
            for (int i = row; i >= 0; i--) {
                if (patchwork[i][column] != null && patchwork[i][column].getSymbol() == Pawn.symbol && patchwork[i][column].getColorFigure().equals(movePositions.getColor())) {
                    return i;
                }
            }
        } else {
            for (int i = row; i < patchwork.length; i++) {
                if (patchwork[i][column] != null && patchwork[i][column].getSymbol() == Pawn.symbol && patchwork[i][column].getColorFigure().equals(movePositions.getColor())) {
                    return i;
                }
            }
        }
        return -1;
    }

    private void findStartPosition(char figureSymbol) {
        List<Point> possibleStartFigure = possibleFiguresForWhiteArray(figureSymbol);

        switch (figureSymbol) {
            case 'I':
                for (int i = 0; i < possibleStartFigure.size(); i++) {
                    int x = (int) possibleStartFigure.get(i).getX();
                    int y = (int) possibleStartFigure.get(i).getY();
                    MovePositions temp = new MovePositions((int) possibleStartFigure.get(i).getX(), (int) possibleStartFigure.get(i).getY(), movePositions.getFinishX(), movePositions.getFinishY(), movePositions.getColor());
                    if (patchwork[x][y].checkMove(movePositions.getColor(), temp, patchwork)) {
                        movePositions.setStartX((int) possibleStartFigure.get(i).getX());
                        movePositions.setStartY((int) possibleStartFigure.get(i).getY());
                        break;
                    }
                }
                break;
            case 'S':
                break;
            case '^':
                break;
            case 'Q':
                break;
            case 'K':
                break;
        }

    }

    private List possibleFiguresForWhiteArray(char symbol) {
        List<Point> result = new ArrayList();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (patchwork[i][j] != null && patchwork[i][j].getColorFigure().equals(movePositions.getColor()) && patchwork[i][j].getSymbol() == symbol) {
                    result.add(new Point(i, j));
                }
            }
        }
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).x + "' " + result.get(i).y);
        }
        return result;
    }


}
