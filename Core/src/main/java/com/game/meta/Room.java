package com.game.meta;

import com.game.impl.RoomImpl;
import java.util.HashMap;

public interface Room extends Named {

    void setExits(Exit... exits);

    Room getNorth();

    Room getSouth();

    Room getEast();

    Room getWest();

    Room getRoomByLocation(String location);
    
    Room getRoomByName(String name);

    void addItem(Item item);

    Item getItem(String name);

    void removeItem(Item item);
    
    void addEntity(Entity entity);

    Entity getEntity(String name);

    void removeEntity(Entity entity);

    void setName(String name);

    void setDescription(String description);

    public void addRoom(Room r);
    
    public HashMap<String, Room> getMapOfRooms();
    
    public void setMapOfRooms(HashMap<String, Room> mapOfRooms);
}
