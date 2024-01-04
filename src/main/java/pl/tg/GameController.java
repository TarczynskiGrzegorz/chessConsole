package pl.tg;

import pl.tg.figures.*;

public class GameController {

    private Figure[][] patchWork = new Figure[8][8];


    public void startPosition(){
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

    public Figure getFigure(int x , int y){
        return patchWork[x][y];
    }

    public void displayPatchWork(){
        System.out.println("  \\  a  b  c  d  e  f  g  h");
        int index = patchWork.length;
        int backgroundIndex = 0;
        for(int i=patchWork.length-1 ; i>=0 ; i--){
            System.out.printf( "%3.1s",String.valueOf(index) );
            index--;
            for(int j = 0 ; j<patchWork[i].length ; j++){
                if(patchWork[i][j]==null){
                    if(backgroundIndex%2==0){
                        System.out.print(PatchWorkColors.WHITE_BACKGROUND_BRIGHT);
                        backgroundIndex++;
                    }else{
                        System.out.print(PatchWorkColors.BLACK_BACKGROUND_BRIGHT);
                        backgroundIndex++;
                    }
                    System.out.printf("%3.1s"," ");
                    System.out.print(PatchWorkColors.RESET);
                }else {
                    if(patchWork[i][j].getColorFigure().equals(FigureColors.BLACK)){
                        System.out.print(PatchWorkColors.BLACK_BOLD);
                    }else{
                        System.out.print(PatchWorkColors.WHITE_BOLD);
                    }
                    if(backgroundIndex%2==0){
                        System.out.print(PatchWorkColors.WHITE_BACKGROUND_BRIGHT);
                        backgroundIndex++;
                    }else{
                        System.out.print(PatchWorkColors.BLACK_BACKGROUND_BRIGHT);
                        backgroundIndex++;
                    }
                    System.out.print(patchWork[i][j].getColorFigure().equals(FigureColors.BLACK) ? PatchWorkColors.BLACK_BOLD: PatchWorkColors.WHITE_BOLD );
                    System.out.printf("%3.1s",  patchWork[i][j].getSymbol());
                    System.out.print(PatchWorkColors.RESET);
                }
            }
            System.out.println();
            backgroundIndex++;
        }
// wrong order
//        for(Figure[] rows : patchWork){
//            System.out.printf( "%3.1s",String.valueOf(index) );
//            index--;
//            for(Figure figure : rows){
//                if(figure==null){
//                    System.out.printf("%3.1s","*");
//                }else {
//                    System.out.printf("%3.1s",figure.getSymbol());
//                }
//            }
//            System.out.println();
//        }
    }
}
