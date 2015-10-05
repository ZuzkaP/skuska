package com.game.meta;

public interface Room extends Named {

    void setExits(Room north, Room south, Room east, Room west);

    Room getNorth();

    Room getSouth();

    Room getEast();

    Room getWest();

    void addItem(Item item);

    Item getItem(String name);

    void removeItem(Item item);
    
    void addEntity(Entity entity);

    Entity getEntity(String name);

    void removeEntity(Entity entity);

    void setName(String name);

    void setDescription(String description);
}
