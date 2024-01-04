package pl.tg;

public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.startPosition();
        gameController.displayPatchWork();
        System.out.println( gameController.getFigure(1,1).getColorFigure());
    }
}