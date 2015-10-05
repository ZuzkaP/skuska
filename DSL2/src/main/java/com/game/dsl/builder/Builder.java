package com.game.dsl.builder;

import com.game.meta.Game;
import com.game.builder.BuilderFactory;
import com.game.builder.IDSLBuilder;

/**
 * Created by Tomáš on 5.10.2015.
 */
public class Builder implements BuilderFactory<Game>, IDSLBuilder {

    @Override
    public Game build() {
        return null;
    }
}
