package pl.tg.processor;

import pl.tg.controller.GameController;
import pl.tg.controller.MovePositions;
import pl.tg.controller.figures.Figure;
import pl.tg.controller.figures.FigureColors;
import pl.tg.controller.figures.Pawn;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        switch ( typeOfMovement(move)) {
            case "movePawn":
                movePositions.setFinishX(translateRowName(moveCharArray[moveCharArray.length - 1]));
                movePositions.setFinishY(translateColumnName(moveCharArray[moveCharArray.length - 2]));
                movePositions.setStartX(getRowForPawn(translateRowName(moveCharArray[moveCharArray.length - 1]), translateColumnName(moveCharArray[moveCharArray.length - 2])));
                movePositions.setStartY(movePositions.getFinishY());
                break;
            case "moveFigure":
                movePositions.setFinishX(translateRowName(moveCharArray[moveCharArray.length - 1]));
                movePositions.setFinishY(translateColumnName(moveCharArray[moveCharArray.length - 2]));
                findStartPosition(moveCharArray[0]);
                break;
            case "castlingKingside":
                if(movePositions.getColor().equals(FigureColors.WHITE)){
                    if(patchwork[0][4].isFirstMove() && patchwork[0][5]==null &&patchwork[0][6] ==null && patchwork[0][7].isFirstMove()){
                        movePositions.setCastlingKingsideWhite(true);
                        movePositions.setCastling(true);
                    }
                }else{
                    if(patchwork[7][4].isFirstMove() && patchwork[7][5]==null &&patchwork[7][6] ==null && patchwork[7][7].isFirstMove()){
                        movePositions.setCastlingKingsideBlack(true);
                        movePositions.setCastling(true);
                    }
                }
                break;
            case "castlingQueenside":
                if(movePositions.getColor().equals(FigureColors.WHITE)){
                    if(patchwork[0][0].isFirstMove() && patchwork[0][1]==null &&patchwork[0][2] ==null&&patchwork[0][3] ==null && patchwork[0][4].isFirstMove()){
                        movePositions.setCastlingQueenSideWhite(true);
                        movePositions.setCastling(true);
                    }
                }else{
                    if(patchwork[7][0].isFirstMove() && patchwork[7][1]==null &&patchwork[7][2] ==null&&patchwork[7][3] ==null && patchwork[7][4].isFirstMove()){
                        movePositions.setCastlingQueenSideBlack(true);
                        movePositions.setCastling(true);
                    }
                }
                break;
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
        System.out.println(movePositions.toString());
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
        System.out.println(movePositions.toString());


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
        Iterator<Point> it = result.iterator();
        while (it.hasNext()){
            Point pt = it.next();
            System.out.println(pt.getX() + " : " +  pt.getY());
        }
        return result;
    }

    private static String typeOfMovement(String str){
        String figuresName ="[KQRBPN]";
        String columnsName ="[a-h]";
        String rowsName = "[1-8]";
        Map<String,String> typeMoves = new HashMap<>();
        typeMoves.put("movePawn" , columnsName+rowsName);
        typeMoves.put("moveFigure",figuresName+columnsName+rowsName);
        typeMoves.put("moveFigureAmbiguous",figuresName+"[a-h|1-8]"+columnsName+rowsName);
        typeMoves.put("capture",figuresName+":"+columnsName+rowsName);
        typeMoves.put("captureAmbigyous", figuresName+"[a-h|1-8]:"+columnsName+rowsName);
        typeMoves.put("capturePassing",columnsName+":"+columnsName+rowsName);
        typeMoves.put("promotion",columnsName+rowsName+figuresName);
        typeMoves.put("castlingKingside","O-O");
        typeMoves.put("castlingQueenside","O-O-O");

        for(Map.Entry<String,String> entry: typeMoves.entrySet()){
            Pattern pattern = Pattern.compile(entry.getValue());
            Matcher matcher = pattern.matcher(str);
            if(matcher.matches()){
                return entry.getKey();
            }
        }
        return "default";

    }
}
