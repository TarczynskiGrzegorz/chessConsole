package pl.tg.controller;

import pl.tg.controller.figures.*;
import pl.tg.gui.PatchWorkColors;
import pl.tg.processor.Processor;
import pl.tg.gui.GUI;

import java.awt.*;
import java.util.Scanner;

public class GameController {

    private final Figure[][] patchWork = new Figure[8][8];
    private Processor processor;
    private GUI GUI;
    private String move;
    private MovePositions movePositions = new MovePositions();


    public GameController(Processor processor, GUI GUI) {
        this.processor = processor;
        this.GUI = GUI;
    }

    public MovePositions getMovePositions() {
        return movePositions;
    }

    public void startPosition() {
//        patchWork[0][0] = new Rook(FigureColors.WHITE);
//        patchWork[0][1] = new Knight(FigureColors.WHITE);
//        patchWork[0][2] = new Bishop(FigureColors.WHITE);
//        patchWork[0][3] = new Queen(FigureColors.WHITE);
        patchWork[0][4] = new King(FigureColors.WHITE);
//        patchWork[0][5] = new Bishop(FigureColors.WHITE);
//        patchWork[0][6] = new Knight(FigureColors.WHITE);
        patchWork[0][7] = new Rook(FigureColors.WHITE);
        patchWork[1][0] = new Pawn(FigureColors.WHITE);
        patchWork[1][1] = new Pawn(FigureColors.WHITE);
        patchWork[1][2] = new Pawn(FigureColors.WHITE);
        patchWork[1][3] = new Pawn(FigureColors.WHITE);
        patchWork[1][4] = new Pawn(FigureColors.WHITE);
        patchWork[1][5] = new Pawn(FigureColors.WHITE);
        patchWork[1][6] = new Pawn(FigureColors.WHITE);
        patchWork[1][7] = new Pawn(FigureColors.WHITE);
        patchWork[7][0] = new Rook(FigureColors.BLACK);
//        patchWork[7][1] = new Knight(FigureColors.BLACK);
//        patchWork[7][2] = new Bishop(FigureColors.BLACK);
//        patchWork[7][3] = new Queen(FigureColors.BLACK);
//        patchWork[7][4] = new King(FigureColors.BLACK);
//        patchWork[7][5] = new Bishop(FigureColors.BLACK);
//        patchWork[7][6] = new Knight(FigureColors.BLACK);
//        patchWork[7][7] = new Rook(FigureColors.BLACK);
//        patchWork[6][0] = new Pawn(FigureColors.BLACK);
//        patchWork[6][1] = new Pawn(FigureColors.BLACK);
//        patchWork[6][2] = new Pawn(FigureColors.BLACK);
//        patchWork[6][3] = new Pawn(FigureColors.BLACK);
//        patchWork[6][4] = new Pawn(FigureColors.BLACK);
//        patchWork[6][5] = new Pawn(FigureColors.BLACK);
//        patchWork[6][6] = new Pawn(FigureColors.BLACK);
//        patchWork[6][7] = new Pawn(FigureColors.BLACK);
    }

    public Figure getFigure(int x, int y) {
        return patchWork[x][y];
    }

    public void play() {
        startPosition();
        GUI.displayPatchWork(patchWork);
        makeMove();
//        System.out.println(patchWork[7][4].possibleMovesArray(patchWork,7,4)[0].x);
        while (!move.equals("q")) {
            GUI.displayPatchWork(patchWork);
            makeMove();
        }


    }

    private void makeMove() {
        move = GUI.sendInfo();
        processor.translateNotation(move);
        if (movePositions.isCastling()) {
            if (movePositions.isCastlingKingsideWhite()) {
                patchWork[0][5] = patchWork[0][7];
                patchWork[0][7] = null;
                patchWork[0][6] = patchWork[0][4];
                patchWork[0][4] = null;
                movePositions.setCastlingKingsideWhite(false);
            } else if (movePositions.isCastlingKingsideBlack()) {
                patchWork[7][5] = patchWork[7][7];
                patchWork[7][7] = null;
                patchWork[7][6] = patchWork[7][4];
                patchWork[7][4] = null;
                movePositions.setCastlingKingsideWhite(false);
            } else if (movePositions.isCastlingQueenSideWhite()) {
                patchWork[0][3] = patchWork[0][0];
                patchWork[0][0] = null;
                patchWork[0][2] = patchWork[0][4];
                patchWork[0][4] = null;
                movePositions.setCastlingQueenSideWhite(false);
            }
            movePositions.setCastling(false);
        } else if (patchWork[movePositions.getStartX()][movePositions.getStartY()].checkMove(movePositions.getColor(), getMovePositions(), patchWork)) {
            patchWork[movePositions.getFinishX()][movePositions.getFinishY()] = patchWork[movePositions.getStartX()][movePositions.getStartY()];
            patchWork[movePositions.getStartX()][movePositions.getStartY()] = null;
        }
        movePositions.setColor(movePositions.getColor().equals(FigureColors.WHITE) ? FigureColors.BLACK : FigureColors.WHITE);


    }

    public Figure[][] getPatchWork() {
        return patchWork;
    }


}

