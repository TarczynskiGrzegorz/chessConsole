package pl.tg.processor;

import pl.tg.controller.GameController;
import pl.tg.controller.figures.Figure;
import pl.tg.controller.figures.FigureColors;
import pl.tg.controller.figures.Pawn;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Processor {
    private GameController gameController;
    private Figure[][] patchwork;

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
        patchwork = gameController.getPatchWork();
    }

    public Point[] translateNotation(String move, Figure[][] patchwork, FigureColors color) {
        char[] moveCharArray = move.toCharArray();

        Point start = new Point(-1,-1);
        Point end = new Point(-1,-1);
        int x;


//        Point startPosition = new Point() ;
//        Point finalPosition = new Point(translateColumnName(moveCharArray[0]), translateRowName(moveCharArray[1]));
//
        switch (moveCharArray.length) {
            case 2:
                 end = new Point(translateRowName(moveCharArray[moveCharArray.length - 1]), translateColumnName(moveCharArray[moveCharArray.length - 2]));
                 start = new Point(getRowForPawn(color, end.x, end.y),end.y);
                Point[] result2 = {start,end};
                return result2;
            case 3:
                 end = new Point(translateRowName(moveCharArray[moveCharArray.length - 1]), translateColumnName(moveCharArray[moveCharArray.length - 2]));
                 Point[] result3 = {findStartPosition(patchwork, color, end, moveCharArray[0]),end};
                return result3;
            default:
                System.out.println("default");
        }

        return null;
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

    private Point findStartPosition(Figure[][] patchwork, FigureColors color,Point end, char figureSymbol) {
        List <Point> possibleStartFigure = possibleFiguresForWhiteArray(patchwork, color, figureSymbol);

        switch (figureSymbol) {
            case 'I':
                for (int i =0; i<possibleStartFigure.size() ; i++){
                    int x =(int) possibleStartFigure.get(i).getX() ;
                    int y =(int) possibleStartFigure.get(i).getY() ;
                    if(patchwork[x][y].checkMove(color, possibleStartFigure.get(i), end, patchwork)){
                        Point result  = new Point((int)possibleStartFigure.get(i).getX(),(int)possibleStartFigure.get(i).getY());
                        return result;
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
        return null;
    }

    private List possibleFiguresForWhiteArray(Figure[][] patchwork, FigureColors color, char symbol) {
        List<Point> result = new ArrayList();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(patchwork[i][j]!= null && patchwork[i][j].getColorFigure().equals(color) && patchwork[i][j].getSymbol()==symbol  ){
                    result.add(new Point(i,j));
                }
            }
        }
        for (int i =0 ;i <result.size(); i++){
            System.out.println(result.get(i).x + "' " +result.get(i).y);
        }
        return result;
    }


}
