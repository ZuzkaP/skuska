package com.game.dsl1.model;

import com.game.builder.IModelBuilder;
import static com.game.dsl1.builder.Builder2.*;
import com.game.dsl1.builder.Builder2;
import com.game.meta.Game;

/**
 * Created by Tomáš on 5.10.2015.
 */
public class NestedFunctionsModelCreator implements IModelBuilder {
    private Builder2 builder2;
    public NestedFunctionsModelCreator() {
        this.builder2 = Builder2.instance;
    }

    @Override
    public void define() {
        game(
                player(
                        "Tomas",
                        backpack(10,
                                item (
                                        "LockPick",
                                        "Small lockpick")
                        )
                ),
                room(
                        "Velka miestnost",
                        "Si sam vo velkej miestnosti",
                        exit("south", "Mala miestnost")
                ),
                room(
                        "Mala miestnost",
                        "Si sam v malej miestnosti",
                        exit("north", "Velka miestnost"),
                        exit("east", "Mala miestnost2"),
                        item(
                                "Axe",
                                "Little axe."
                        )
                ),
                room(
                        "Mala miestnost2",
                        "Si sam v malej miestnosti",
                        exit("west", "Mala miestnost"),
                        item(
                                "Axe",
                                "Little axe."
                        )
                )
        );
    }




    @Override
    public Game getGame() {
        return builder2.build();
    }
}
