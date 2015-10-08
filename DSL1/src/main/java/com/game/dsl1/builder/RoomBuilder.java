package com.game.dsl1.builder;

import com.game.builder.IDSLBuilder;

/**
 * Created by Tomáš on 5.10.2015.
 */
public class RoomBuilder extends Builder implements IDSLBuilder {
    static final RoomBuilder roomBuilder = new RoomBuilder();
    private RoomBuilder() {
    }

    public RoomBuilder name(String name) {
        Builder.instance.lastRoom.setName(name);
        return this;
    }

    public RoomBuilder description(String description) {
        Builder.instance.lastRoom.setDescription(description);
        return this;
    }

    public RoomBuilder exit(String exit, String roomName) {
        Builder.instance.exits.put(exit, roomName);
        return this;
    }

    public EntityBuilder entity() {
        return EntityBuilder.entityBuilder;
    }

    public RoomItemBuilder roomItem() {
        return RoomItemBuilder.roomItemBuilder;
    }
}
