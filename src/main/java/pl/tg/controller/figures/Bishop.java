package pl.tg.controller.figures;

import pl.tg.controller.MovePositions;

public class Bishop extends Figure implements CheckMoves {

    public Bishop(FigureColors figureColor) {
        super(figureColor, 'B', '♗');

    }

    public boolean checkMove(FigureColors color, MovePositions movePositions, Figure[][] patchwork) {
//        boolean isInPatchwork = isInPatchwork(movePositions);
//        boolean docelowePolePuste = !isFinalPositionReservedByAliance(color, movePositions, patchwork);
//        boolean naPrzekatnej = isOnDiagonal(movePositions);
//        boolean wolnePoiedzyCelami = !isAnythingBeetween(movePositions, patchwork);
        return !isFinalPositionReservedByAliance(color, movePositions, patchwork) && isOnDiagonal(movePositions) && !isAnythingBeetween(movePositions, patchwork) && isInPatchwork(movePositions);
    }

    private boolean isOnDiagonal(MovePositions movePositions) {
        return Math.abs(movePositions.getFinishX() - movePositions.getStartX()) - Math.abs(movePositions.getFinishY() - movePositions.getStartY()) == 0;
    }

    private boolean isAnythingBeetween(MovePositions movePositions, Figure[][] patchwork) {
        int direction = countDirectionMove(movePositions);
        int startX = movePositions.getStartX();
        int finishX = movePositions.getFinishX();
        int startY = movePositions.getStartY();
        int finishY = movePositions.getFinishY();

        if (direction == 1 ) {
            int j=1;
            for(int i = startX+1; i<finishX-1; i++){
                if(patchwork[i][startY + j]!=null){
                    j++;
                    return true;
                }

            }
            return false;
        }else if(direction ==2){
            int j=-1;
            for(int i = startX+1; i<finishX-1; i++){
                if(patchwork[i][startY + j]!=null){
                    j--;
                    return true;
                }

            }
            return false;
        }else if(direction==3){
            int j=1;
            for(int i = finishX+1; i<startX-1; i++){
                if(patchwork[i][finishY + j]!=null){
                    j++;
                    return true;
                }

            }
            return false;
        }else if(direction==4){
            int j=-1;
            for(int i = finishX+1; i<startX-1; i++){
                if(patchwork[i][finishY + j]!=null){
                    j--;
                    return true;
                }

            }
            return false;
        }else{
            return true;
        }

    }

    private int countDirectionMove(MovePositions movePositions) {
        if ((movePositions.getStartX() > movePositions.getFinishX()) && (movePositions.getStartY() > movePositions.getFinishY())) {
            return 3;
        }
        if ((movePositions.getStartX() < movePositions.getFinishX()) && (movePositions.getStartY() < movePositions.getFinishY())) {
            return 1;
        }
        if ((movePositions.getStartX() > movePositions.getFinishX()) && (movePositions.getStartY() < movePositions.getFinishY())) {
            return 4;
        }
        if ((movePositions.getStartX() < movePositions.getFinishX()) && (movePositions.getStartY() > movePositions.getFinishY())) {
            return 2;
        }
        return -1;
    }

}
