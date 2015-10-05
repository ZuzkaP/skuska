package com.game.dsl.builder;

import com.game.builder.IDSLBuilder;

/**
 * Created by Tomáš on 5.10.2015.
 */
public class BackpackBuilder extends Builder implements IDSLBuilder {
    static final BackpackBuilder backpackBuilder = new BackpackBuilder();
    private BackpackBuilder() {
    }

    public BackpackItemBuilder backpackItem() {
        return BackpackItemBuilder.backpackItemBuilder;
    }
}
