package com.game.meta;

/**
 * Created by Tomáš on 5.10.2015.
 */
public class Player {
    private String name;
    private Backpack backpack;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }
}
