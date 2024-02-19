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
       return true;
   }
    default boolean isOnDiagonal(MovePositions movePositions) {
        return Math.abs(movePositions.getFinishX() - movePositions.getStartX()) - Math.abs(movePositions.getFinishY() - movePositions.getStartY()) == 0;
    }
    default boolean isOnLine(MovePositions movePositions){
       return movePositions.getFinishX()== movePositions.getStartX() || movePositions.getFinishY() == movePositions.getStartY();
    }
    default boolean isAnythingBeetwenInLine(MovePositions movePositions, Figure[][] patchwork) {
        int start;
        int finish;
        if (movePositions.getStartX() == movePositions.getFinishX()) {
            if (movePositions.getStartY() < movePositions.getFinishY()) {
                start = movePositions.getStartY();
                finish = movePositions.getFinishY();
            } else {
                start = movePositions.getFinishY();
                finish = movePositions.getStartY();
            }
            for (int i = start + 1; i < finish; i++) {
                if (patchwork[movePositions.getStartX()][i] != null) {
                    System.out.println("przeszkoda");
                    return false;
                }
            }
            return true;
        } else if (movePositions.getStartY() == movePositions.getFinishY()) {
            if (movePositions.getStartX() < movePositions.getFinishX()) {
                start = movePositions.getStartX();
                finish = movePositions.getFinishX();
            } else {
                start = movePositions.getFinishX();
                finish = movePositions.getStartX();
            }
            for (int i = start + 1; i < finish; i++) {
                if (patchwork[i][movePositions.getStartY()] != null) {
                    System.out.println("przeszkoda");
                    return false;
                }
            }
            return true;
        } else return false;

    }

    default boolean isAnythingBeetweenDiagonal(MovePositions movePositions, Figure[][] patchwork) {
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
