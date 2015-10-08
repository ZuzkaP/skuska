package com.game.dsl1.builder;

import com.game.builder.GameObjectFactory;
import com.game.builder.IDSLBuilder;

/**
 * Created by Tomáš on 5.10.2015.
 */
public class ItemBuilder extends Builder implements IDSLBuilder {
    static final ItemBuilder itemBuilder = new ItemBuilder();
    private ItemBuilder() {
    }

    public ItemBuilder name(String name) {
        Builder.instance.lastItem = GameObjectFactory.getItemImplementation(GameObjectFactory.ObjectType.ITEM, name);
        return this;
    }

    public ItemBuilder description(String description) {
        Builder.instance.lastItem.setDescription(description);
        return this;
    }
}
