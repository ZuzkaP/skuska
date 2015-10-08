package com.game;

import com.game.dsl1.model.MethodChainingModelCreator;
import com.game.dsl1.model.NestedFunctionsModelCreator;
import com.game.interpreter.GameInterpreter;

/**
 * Created by Tomáš on 5.10.2015.
 */
public class Main {
    public static void main(String[] args) {
        new GameInterpreter(new MethodChainingModelCreator()).execute();
//        new GameInterpreter(new NestedFunctionsModelCreator()).execute();
    }
}
