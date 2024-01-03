package pl.tg;

import pl.tg.figures.Bishop;
import pl.tg.figures.Figure;

public class Game {

    private Figure[][] patchWork = new Figure[8][8];


    public void startPosition(){
        Bishop b1 = new Bishop(1,1, "W");
        patchWork[1][1] = b1;
    }

    public Figure getFigure(int x , int y){
        return patchWork[x][y];
    }

    public void displayPatchWork(){
        System.out.println("  \\  a  b  c  d  e  f  g  h");
        int index = patchWork.length;
        for(int i=patchWork.length-1 ; i>=0 ; i--){
            System.out.printf( "%3.1s",String.valueOf(index) );
            index--;
            for(int j = 0 ; j<patchWork[i].length ; j++){
                if(patchWork[i][j]==null){
                    System.out.printf("%3.1s","*");
                }else {
                    System.out.printf("%3.1s",patchWork[i][j].getSymbol());
                }
            }
            System.out.println();
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
