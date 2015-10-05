package com.game.dsl.builder;

import com.game.builder.IDSLBuilder;
import com.game.impl.BackpackImpl;

/**
 * Created by Tomáš on 5.10.2015.
 */
public class PlayerBuilder extends Builder implements IDSLBuilder {
    static final PlayerBuilder playerBuilder = new PlayerBuilder();
    private PlayerBuilder() {
    }

    public PlayerBuilder name(String name) {
        Builder.instance.player.setName(name);
        return this;
    }

    public BackpackBuilder backpack(int size) {
        Builder.instance.backpack = new BackpackImpl(size);
        Builder.instance.player.setBackpack(Builder.instance.backpack);
        return BackpackBuilder.backpackBuilder;
    }
}
