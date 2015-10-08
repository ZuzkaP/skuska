package com.game.dsl1.builder;

import com.game.builder.GameObjectFactory;
import com.game.builder.IDSLBuilder;

/**
 * Created by Tomáš on 5.10.2015.
 */
public class BackpackItemBuilder extends Builder implements IDSLBuilder {
    static final BackpackItemBuilder backpackItemBuilder = new BackpackItemBuilder();

    private BackpackItemBuilder() {
    }

    public BackpackItemBuilder name(String name) {
        Builder.instance.lastBackpackItem = GameObjectFactory.getItemImplementation(GameObjectFactory.ObjectType.ITEM, name);
        Builder.instance.backpack.add(Builder.instance.lastBackpackItem);
        return this;
    }

    public BackpackItemBuilder description(String description) {
        Builder.instance.lastBackpackItem.setDescription(description);
        return this;
    }
}
