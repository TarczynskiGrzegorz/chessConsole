package pl.tg.controller.figures;

import pl.tg.controller.MovePositions;

public interface CheckMoves {

   default boolean isFinalPositionReservedByAliance(FigureColors color, MovePositions movePositions, Figure[][] patchwork){
       return patchwork[movePositions.getFinishX()][movePositions.getFinishY()]!=null && patchwork[movePositions.getFinishX()][movePositions.getFinishY()].getColorFigure().equals(color);
   }
   default boolean isInPatchwork(MovePositions movePositions){
       int[] positions = {movePositions.getStartX(),movePositions.getStartY(),movePositions.getFinishX(),movePositions.getFinishX()};
       for(int position: positions){
           if(position<0 || position>7){
               return false;
           }
       }
       System.out.println("w tablicy");
       return true;
   }
}
