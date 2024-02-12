package pl.tg.controller.figures;

import pl.tg.controller.MovePositions;

public interface CheckMoves {

   default boolean isFinalPositionReservedByAliance(FigureColors color, MovePositions movePositions, Figure[][] patchwork){
       return patchwork[movePositions.getFinishX()][movePositions.getFinishY()]!=null && patchwork[movePositions.getFinishX()][movePositions.getFinishY()].getColorFigure().equals(color);
   }
}
