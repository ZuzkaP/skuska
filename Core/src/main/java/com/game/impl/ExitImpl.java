package com.game.impl;

import com.game.meta.Exit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zuzka on 8.10.2015.
 */
public class ExitImpl implements Exit {
    private String name;    //kam smeruje
    private String location; //location in room

    public ExitImpl(String name, String location) {
        this.name = name;
        this.location = location;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLocation() {
        return location;
    }
}
