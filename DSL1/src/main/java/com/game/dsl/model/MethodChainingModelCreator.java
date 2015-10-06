package com.game.dsl.model;

import com.game.meta.Game;
import com.game.builder.IModelBuilder;
import com.game.dsl.builder.Builder;

import static com.game.dsl.builder.Builder.game;

/**
 * Created by Tomáš on 5.10.2015.
 */
public class MethodChainingModelCreator implements IModelBuilder {
    private Builder builder;

    public MethodChainingModelCreator() {
        builder = new Builder();
    }

    @Override
    public void define() {
        game()
            .room()
                .name("Velka miestnost")
                .description("Si sam vo velkej miestnosti")
                .exit("south", "Mala miestnost")
            .room()
                .name("Mala miestnost")
                .description("Si sam v malej miestnosti")
                .exit("north", "Velka miestnost")
                .roomItem()
                    .name("Axe")
                    .description("Little axe.")
            .player()
                .name("Tomas")
                .backpack(10)
                    .backpackItem()
                        .name("LockPick")
                        .description("Small lockpick");

    }

    @Override
    public Game getGame() {
        return builder.build();
    }
}
