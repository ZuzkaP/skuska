package com.game.meta;

public interface Room extends Named {

    void setExits(Exit... exits);

    Room getNorth();

    Room getSouth();

    Room getEast();

    Room getWest();

    Room getRoomByLocation(String location);

    void addItem(Item item);

    Item getItem(String name);

    void removeItem(Item item);
    
    void addEntity(Entity entity);

    Entity getEntity(String name);

    void removeEntity(Entity entity);

    void setName(String name);

    void setDescription(String description);
}
