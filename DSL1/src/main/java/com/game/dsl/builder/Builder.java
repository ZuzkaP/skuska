package com.game.dsl.builder;

import com.game.builder.BuilderFactory;
import com.game.builder.IDSLBuilder;
import com.game.impl.GameImpl;
import com.game.impl.RoomImpl;
import com.game.meta.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Tomáš on 5.10.2015.
 */
public class Builder implements IDSLBuilder, BuilderFactory<Game>  {
    public static final Builder instance = new Builder();
    private static Game game;
    protected Room lastRoom;
    protected Item lastItem;
    protected Item lastBackpackItem;
    protected Item lastRoomItem;
    protected Backpack backpack;
    protected Entity lastEntity;
    protected Player player;
    protected Map<String, String> exits;
    private Map<Room, Map<String, String>> roomExits = new HashMap<>();

    public static Builder game() {
        if(instance.game == null) {
            instance.game = new GameImpl();
        }
        return instance;
    }

    public RoomBuilder room() {
        if(instance.lastRoom != null) {
            addRoom();
        }

        instance.exits = new HashMap<>();
        instance.lastRoom = new RoomImpl();
        return RoomBuilder.roomBuilder;
    }

    public PlayerBuilder player() {
        instance.player = new Player();
        return PlayerBuilder.playerBuilder;
    }

    @Override
    public Game build() {
        resolveRooms();
        instance.game.setCurrentRoom(getFirstRoom());
        instance.game.setPlayer(instance.player);
        return instance.game;
    }

    private Room getFirstRoom() {
        Set<Room> rooms = instance.roomExits.keySet();
        return rooms.toArray(new Room[rooms.size()])[0];
    }

    private void resolveRooms() {
        if(instance.lastRoom != null) {
            addRoom();
        }
        for(Room room : instance.roomExits.keySet()) {
            if(!instance.roomExits.get(room).isEmpty()) {
                assignExits(room, instance.roomExits.get(room));
            }
        }

        for(Room room : instance.roomExits.keySet()) {
            room.setName(null);
        }
    }

    private void addRoom() {
        instance.roomExits.put(instance.lastRoom, instance.exits);
    }

    private void assignExits(Room room, Map<String, String> dirsAndRooms) {
        for(String exit : dirsAndRooms.keySet()) {
            Room refRoom = getRooomByName(dirsAndRooms.get(exit));
            if(refRoom != null) {
                // N S E W
                switch(exit.toLowerCase()) {
                    case "north":
                        room.setExits(refRoom, null, null, null);
                        break;

                    case "south":
                        room.setExits(null, refRoom, null, null);
                        break;

                    case "east":
                        room.setExits(null, null, refRoom, null);
                        break;

                    case "west":
                        room.setExits(null, null, null, refRoom);
                        break;
                }
            }
        }
    }

    private Room getRooomByName(String name) {
        for(Room room : instance.roomExits.keySet()) {
            if(room.getName().equals(name)) {
                return room;
            }
        }
        return null;
    }

}
