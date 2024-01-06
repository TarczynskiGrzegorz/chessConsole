package pl.tg;

import pl.tg.controller.GameController;
import pl.tg.gui.GUI;
import pl.tg.processor.Processor;

public class Main {
    public static void main(String[] args) {
        GUI guiConsole = new GUI();
        Processor processor = new Processor();
        GameController gameController = new GameController(processor,guiConsole);
        guiConsole.setGameController(gameController);
        processor.setGameController(gameController);

        gameController.play();

    }
}