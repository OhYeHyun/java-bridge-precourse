package bridge.controller;

import bridge.service.BridgeGame;
import bridge.service.GameSettings;
import bridge.validator.ContinueValidator;
import bridge.validator.LengthValidator;
import bridge.validator.MoveValidator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final GameSettings settings;
    private final BridgeGame game;
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeController(GameSettings settings, BridgeGame game, InputView inputView, OutputView outputView) {
        this.settings = settings;
        this.game = game;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        OutputView.instructionStart();
        int length = getLength();
        settings.setGame(length);

        boolean playing = true;
        while (playing) {
            while (game.getPassable() && game.remainingBoard()) {
                String move = getMove();
                game.moveBridge(move);
                outputView.displayTurnResult(game.getTurnResult());
            }

            if (game.gameSuccess()) {
                playing = false;
                outputView.displayFinalResult(game.getTurnResult(), game.getSuccessful(), game.getTryCount());
            }
            if (!game.gameSuccess()) {
                String continueInput = getContinue();
                if (game.continueGame(continueInput)) {
                    game.restart();
                }
                if (!game.continueGame(continueInput)) {
                    playing = false;
                    outputView.displayFinalResult(game.getTurnResult(), game.getSuccessful(), game.getTryCount());
                }
            }
        }
    }

    private int getLength() {
        while (true) {
            try {
                OutputView.getLength();
                String length = inputView.getInput();
                LengthValidator.validate(length);
                return Integer.parseInt(length);
            } catch (IllegalArgumentException e) {
                OutputView.printWithLineSpace(e.getMessage());
            }
        }
    }

    private String getMove() {
        while (true) {
            try {
                OutputView.getMove();
                String move = inputView.getInput();
                MoveValidator.validate(move);
                return move;
            } catch (IllegalArgumentException e) {
                OutputView.printWithLineSpace(e.getMessage());
            }
        }
    }

    private String getContinue() {
        while (true) {
            try {
                OutputView.getContinue();
                String continueInput = inputView.getInput();
                ContinueValidator.validate(continueInput);
                return continueInput;
            } catch (IllegalArgumentException e) {
                OutputView.printWithLineSpace(e.getMessage());
            }
        }
    }
}
