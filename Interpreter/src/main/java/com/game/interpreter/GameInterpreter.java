package com.game.interpreter;

import com.game.builder.IModelBuilder;
import com.game.runner.GameRunner;

/**
 * Created by Tom� on 5.10.2015.
 */
public class GameInterpreter {
    private IModelBuilder builder;
    public GameInterpreter(IModelBuilder builder) {
        this.builder = builder;
        init();
    }

    private void init() {
        builder.define();
    }

    public void execute() {
        GameRunner.run(builder.getGame());
    }
}