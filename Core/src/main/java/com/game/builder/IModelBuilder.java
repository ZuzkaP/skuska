package com.game.builder;

import com.game.meta.Game;

/**
 * Created by Tomáš on 5.10.2015.
 */
public interface IModelBuilder {
    Game getGame();
    void define();
}
