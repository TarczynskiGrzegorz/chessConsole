package pl.tg;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.startPosition();
        game.displayPatchWork();
        System.out.println( game.getFigure(1,1).getColorFigure());
    }
}