package com.game.impl;

import com.game.meta.Exit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Juraj on 8.10.2015.
 */
public class ExitImpl implements Exit {
    private String name;
    private String location;

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
