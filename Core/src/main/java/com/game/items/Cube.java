/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.game.items;

import com.game.abstr.AbstractItem;
import com.game.abstr.Game;
import com.game.abstr.Item;
import com.game.abstr.Moveable;

/**
 *
 * @author Matt
 */
public class Cube extends AbstractItem implements Moveable{
    private Item hidden;
    private Item key;

    /**
     *
     * @param h
     * @param k
     */
    public Cube(Item h,Item k){
        super("kocka", "kamenna kocka, ale zda sa ze v nej nieco je, treba pouzit kluc z kamena, aby som zistil co v nej je");
        this.hidden=h;
        this.key=k;
    }

    /**
     *
     * @return 
     */
    @Override
    public String toString(){
        return (" "+this.name +"-"+this.description); 
    }

    /**
     *
     * @param g
     * @param it
     */
    public void open(Game g, Item it){
        g.getUI().println("kluc by mal pasovat");
        if(this.key.getName().equalsIgnoreCase(it.getName())){
            g.getBackpack().add(hidden);
            g.getBackpack().remove(it.getName());
            this.description="tato je otvorena a uz neskryva tajomstvo";
        }
        else g.getUI().println(this.name+" sa otvori iba pomocou "+this.key.getName());
    }
}
