package com.game.dsl1.model;

import com.game.meta.Game;
import com.game.builder.IModelBuilder;
import com.game.dsl1.builder.Builder;

import static com.game.dsl1.builder.Builder.game;

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
                .name("Velka retazova miestnost")
                .description("Si sam vo velkej retazovej miestnosti")
                .exit("south", "Mala miestnost")
            .room()
                .name("Mala retazova miestnost")
                .description("Si sam v malej retazovej miestnosti")
                .exit("north", "Velka miestnost")
                .exit("east", "name")
                .roomItem()
                .name("Axe")
                .description("Little axe.")
                .player()
                .name("Tomas")
                .backpack(10)
                .backpackItem()
                .name("LockPick")
                .description("Small lockpick")
            .room()
                .description("desc")
                .name("name")
                .exit("west", "Mala miestnost")
        ;

    }

    @Override
    public Game getGame() {

        return builder.build();
    }
}
