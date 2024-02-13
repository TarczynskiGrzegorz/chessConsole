package pl.tg.controller.figures;

import pl.tg.controller.MovePositions;

public class Bishop extends Figure implements CheckMoves{

    public Bishop(FigureColors figureColor){
        super(figureColor, 'B','♗');

    }

    public boolean checkMove(FigureColors color, MovePositions movePositions, Figure[][] patchwork) {
        boolean isInPatchwork = isInPatchwork(movePositions);
        boolean docelowePolePuste = !isFinalPositionReservedByAliance(color, movePositions, patchwork);
        boolean naPrzekatnej = isOnDiagonal(movePositions);
        boolean wolnePoiedzyCelami = !isAnythingBeetween(movePositions, patchwork);
        return !isFinalPositionReservedByAliance(color, movePositions, patchwork) && isOnDiagonal(movePositions) && !isAnythingBeetween(movePositions, patchwork) && isInPatchwork(movePositions);
    }

    private boolean isOnDiagonal(MovePositions movePositions){
        System.out.println("wartosc do przekatnej : " + Math.abs(movePositions.getFinishX()- movePositions.getStartX()) + "- "+ Math.abs(movePositions.getFinishY()- movePositions.getStartY()));
        return Math.abs(movePositions.getFinishX()- movePositions.getStartX())-Math.abs(movePositions.getFinishY()- movePositions.getStartY()) == 0;
    }
    private boolean isAnythingBeetween( MovePositions movePositions, Figure[][] patchwork){
//        int startX = movePositions.getStartX();
//        int finishX = movePositions.getFinishX();
//        int startY = movePositions.getStartY();
//        int finishY = movePositions.getFinishY();
//        int direction = countDirectionMove(movePositions);
//        switch (direction){
//            case 1:
//                for(int i =startX+1; i<finishX; i++){
//                    for(int j = startY+1; j<finishY;j++){
//                        if(patchwork[i][j]!=null){
//                            System.out.println("cos pomiedzy");
//                            return true;
//                        }
//                    }
//                }
//                break;
//            case 2:
//                for(int i =startX+1; i<finishX; i++){
//                    for(int j = startY-1; j>finishY;j--){
//                        if(patchwork[i][j]!=null){
//                            System.out.println("cos pomiedzy");
//                            return true;
//                        }
//                    }
//                }
//                break;
//            case 3:
//                for(int i =startX-1; i>finishX; i--){
//                    for(int j = startY-1; j>finishY;j--){
//                        if(patchwork[i][j]!=null){
//                            System.out.println("cos pomiedzy");
//                            return true;
//                        }
//                    }
//                }
//                break;
//            case 4:
//                for(int i =startX-1; i>finishX; i--){
//                    for(int j = startY+1; j<finishY;j++){
//                        if(patchwork[i][j]!=null){
//                            System.out.println("cos pomiedzy");
//                            return true;
//                        }
//                    }
//                }
//                break;
//        }
//
        return false;
    }
    private int countDirectionMove(MovePositions movePositions){
        if((movePositions.getStartX()> movePositions.getFinishX() )&&(movePositions.getStartY() > movePositions.getFinishY())){
            return 3;
        }
        if((movePositions.getStartX()< movePositions.getFinishX() )&&(movePositions.getStartY() < movePositions.getFinishY())){
            return 1;
        }
        if((movePositions.getStartX()> movePositions.getFinishX() )&&(movePositions.getStartY() < movePositions.getFinishY())){
            return 4;
        }
        if((movePositions.getStartX()< movePositions.getFinishX() )&&(movePositions.getStartY() > movePositions.getFinishY())){
            return 2;
        }
        return -1;
    }

}
