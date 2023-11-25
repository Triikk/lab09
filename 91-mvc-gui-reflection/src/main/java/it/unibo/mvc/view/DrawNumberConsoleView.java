package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

public class DrawNumberConsoleView implements DrawNumberView {

    @Override
    public void setController(DrawNumberController observer) {
    }

    @Override
    public void start() {
    }

    @Override
    public void result(DrawResult res) {
        switch (res) {
            case YOURS_HIGH, YOURS_LOW, YOU_WON, YOU_LOST -> {
                System.out.println(res.getDescription());
                return;
            }
            default -> throw new IllegalStateException("Unknown game state");
        }
    }
    
}
