package pl.tg.controller.figures;

import pl.tg.controller.MovePositions;

public class Knight extends Figure implements CheckMoves{
    public Knight( FigureColors figureColor){
        super(figureColor, 'N','♘');

    }


    public boolean checkMove(FigureColors color, MovePositions movePositions, Figure[][] patchwork) {
        return isInPatchwork(movePositions)&&!isFinalPositionReservedByAliance(color,movePositions,patchwork)&&isJumpTwoAndOne(movePositions);

    }

    private boolean isJumpTwoAndOne (MovePositions movePositions){
        int startX = movePositions.getStartX();
        int finishX = movePositions.getFinishX();
        int startY = movePositions.getStartY();
        int finishY = movePositions.getFinishY();
        return (Math.abs(movePositions.getStartX()- movePositions.getFinishX())==2 && Math.abs(movePositions.getStartY()- movePositions.getFinishY())==1) || (Math.abs(movePositions.getStartX()- movePositions.getFinishX())==1 && Math.abs(movePositions.getStartY()- movePositions.getFinishY())==2) ;
    }
}
