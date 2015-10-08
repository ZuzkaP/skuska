package com.game.dsl1.builder;

import com.game.builder.GameObjectFactory;
import com.game.builder.IDSLBuilder;

/**
 * Created by Tomáš on 5.10.2015.
 */
public class RoomItemBuilder extends Builder implements IDSLBuilder {
    static final RoomItemBuilder roomItemBuilder = new RoomItemBuilder();
    private RoomItemBuilder() {
    }

    public RoomItemBuilder name(String name) {
        Builder.instance.lastRoomItem = GameObjectFactory.getItemImplementation(GameObjectFactory.ObjectType.ITEM, name);
        Builder.instance.lastRoom.addItem(Builder.instance.lastRoomItem);
        return this;
    }

    public RoomItemBuilder description(String description) {
        Builder.instance.lastRoomItem.setDescription(description);
        return this;
    }
}
