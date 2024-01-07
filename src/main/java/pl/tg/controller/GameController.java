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
    private FigureColors moveColor = FigureColors.WHITE;

    public GameController(Processor processor, GUI GUI) {
        this.processor = processor;
        this.GUI = GUI;
    }


    public void startPosition() {
        patchWork[0][0] = new Rook(FigureColors.WHITE);
        patchWork[0][1] = new Knight(FigureColors.WHITE);
        patchWork[0][2] = new Bishop(FigureColors.WHITE);
        patchWork[0][3] = new Queen(FigureColors.WHITE);
        patchWork[0][4] = new King(FigureColors.WHITE);
        patchWork[0][5] = new Bishop(FigureColors.WHITE);
        patchWork[0][6] = new Knight(FigureColors.WHITE);
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
        patchWork[7][1] = new Knight(FigureColors.BLACK);
        patchWork[7][2] = new Bishop(FigureColors.BLACK);
        patchWork[7][3] = new Queen(FigureColors.BLACK);
        patchWork[7][4] = new King(FigureColors.BLACK);
        patchWork[7][5] = new Bishop(FigureColors.BLACK);
        patchWork[7][6] = new Knight(FigureColors.BLACK);
        patchWork[7][7] = new Rook(FigureColors.BLACK);
        patchWork[6][0] = new Pawn(FigureColors.BLACK);
        patchWork[6][1] = new Pawn(FigureColors.BLACK);
        patchWork[6][2] = new Pawn(FigureColors.BLACK);
        patchWork[6][3] = new Pawn(FigureColors.BLACK);
        patchWork[6][4] = new Pawn(FigureColors.BLACK);
        patchWork[6][5] = new Pawn(FigureColors.BLACK);
        patchWork[6][6] = new Pawn(FigureColors.BLACK);
        patchWork[6][7] = new Pawn(FigureColors.BLACK);
    }

    public Figure getFigure(int x, int y) {
        return patchWork[x][y];
    }

    public void play() {
        startPosition();
        GUI.displayPatchWork(patchWork);
        makeMove();
        System.out.println(patchWork[7][4].possibleMovesArray(patchWork,7,4)[0].x);
        while (!move.equals("q")){
            GUI.displayPatchWork(patchWork);
            makeMove();
        }


    }

    private void makeMove(){
        move = GUI.sendInfo();
        Point[] moves = processor.translateNotation(move,patchWork,moveColor);
        System.out.println(moves[0].x + moves[0].y + moves[1].x + moves[1].y + patchWork[moves[0].x][moves[0].y].getSymbol());
        moveColor = moveColor.equals(FigureColors.WHITE) ? FigureColors.BLACK: FigureColors.WHITE;
    }



}
