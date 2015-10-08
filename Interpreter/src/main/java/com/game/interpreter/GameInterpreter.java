package com.game.interpreter;

import com.game.builder.IModelBuilder;
import com.game.runner.GameRunner;

/**
 * Created by Tomáš on 5.10.2015.
 */
public class GameInterpreter {
    private IModelBuilder builder;
    public GameInterpreter(IModelBuilder builder) {
        this.builder = builder;
        try {
            init();
        }
        catch(Throwable e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    private void init() {
        builder.define();
    }

    public void execute() {
        GameRunner.run(builder.getGame());
    }
}
