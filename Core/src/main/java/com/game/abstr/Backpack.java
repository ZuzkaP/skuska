package com.game.abstr;

import java.util.List;

public interface Backpack {

    boolean add(Item item);

    Item remove(String name);

    Item getItem(String name);

    int getCapacity();

    List<Item> getItems();
}
