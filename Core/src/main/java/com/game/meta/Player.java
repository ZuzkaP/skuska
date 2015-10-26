package com.game.meta;

import com.game.impl.BackpackImpl;

/**
 * Created by Zuzka on 5.10.2015.
 */
public class Player {
    private String name;
    private Backpack backpack;
    
    //JD - pridany konstruktor
    public Player(String name, int count){
        this.name = name;
        this.backpack = new BackpackImpl(count);
    }
    //povodny kod

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
