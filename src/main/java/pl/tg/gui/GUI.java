package pl.tg.gui;

import pl.tg.controller.GameController;
import pl.tg.controller.figures.Figure;
import pl.tg.controller.figures.FigureColors;
import pl.tg.processor.Processor;

import java.util.Scanner;

public class GUI {
    private GameController gameController;


    public void setGameController(GameController gameController){
        this.gameController = gameController;
    }

    public void displayPatchWork(Figure[][] patchWork){
        System.out.println("  \\ a  b  c  d  e  f  g  h");
        int index = patchWork.length;
        int backgroundIndex = 0;
        for(int i=patchWork.length-1 ; i>=0 ; i--){
            System.out.print( " "+String.valueOf(index)+" " );
            index--;
            for(int j = 0 ; j<patchWork[i].length ; j++){
                if(patchWork[i][j]==null){
                    if(backgroundIndex%2==0){
                        System.out.print(PatchWorkColors.YELLOW_BACKGROUND_BRIGHT);
                    }else{
                        System.out.print(PatchWorkColors.YELLOW_BACKGROUND_DARK);
                    }
                    backgroundIndex++;
                    System.out.print("   ");
                    System.out.print(PatchWorkColors.RESET);
                }else {
                    if(patchWork[i][j].getColorFigure().equals(FigureColors.BLACK)){
                        System.out.print(PatchWorkColors.BLACK_BOLD);
                    }else{
                        System.out.print(PatchWorkColors.WHITE_BOLD);
                    }
                    if(backgroundIndex%2==0){
                        System.out.print(PatchWorkColors.YELLOW_BACKGROUND_BRIGHT);
                        backgroundIndex++;
                    }else{
                        System.out.print(PatchWorkColors.YELLOW_BACKGROUND_DARK);
                        backgroundIndex++;
                    }
                    System.out.print(patchWork[i][j].getColorFigure().equals(FigureColors.BLACK) ? PatchWorkColors.BLACK_BOLD: PatchWorkColors.WHITE_BOLD );
                    System.out.print(" "+ patchWork[i][j].getDisplaySymbol()+ " ");
                    System.out.print(PatchWorkColors.RESET);
                }
            }
            System.out.println();
            backgroundIndex++;
        }

    }

    public String sendInfo(){
        Scanner scanner = new Scanner(System.in);{
            System.out.println("Make a move");
            return scanner.nextLine();
        }
    }


}

