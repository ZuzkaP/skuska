package com.game.dsl1.builder;

import com.game.builder.GameObjectFactory;
import com.game.builder.IDSLBuilder;

/**
 * Created by Tomáš on 5.10.2015.
 */
public class EntityBuilder extends Builder implements IDSLBuilder {
    static final EntityBuilder entityBuilder = new EntityBuilder();
    private EntityBuilder() {
    }

    public EntityBuilder name(String name) {
        Builder.instance.lastEntity = GameObjectFactory.getItemImplementation(GameObjectFactory.ObjectType.ENTITY, name);
        Builder.instance.lastRoom.addEntity(Builder.instance.lastEntity);
        return this;
    }

    public EntityBuilder description(String description) {
        Builder.instance.lastEntity.setDescription(description);
        return this;
    }
}
