package com.game.dsl1.builder;

import com.game.builder.GameObjectFactory;
import com.game.impl.BackpackImpl;
import com.game.impl.ExitImpl;
import com.game.impl.GameImpl;
import com.game.impl.RoomImpl;
import com.game.meta.*;
import com.game.builder.BuilderFactory;
import com.game.builder.IDSLBuilder;

/**
 * Created by Tomáš on 5.10.2015.
 */
public class Builder2 implements BuilderFactory<Game>, IDSLBuilder {
    public static final Builder2 instance = new Builder2();
    private Game game;


    public static void game(Player player, Room... rooms) {
        instance.game = new GameImpl();
        instance.game.setPlayer(player);
        instance.game.setCurrentRoom(rooms[0]);
        for(Room room : rooms) {
            RoomImpl.addRoom(room);
        }
    }

    public static Player player(String playerName, Backpack backpack){
        Player player = new Player();
        player.setName(playerName);
        player.setBackpack(backpack);
        return player;
    }

    public static Backpack backpack(int count, Item... items){
        Backpack back = new BackpackImpl(count);
        if(items != null && items.length > 0)
        for(Item item : items){
            back.add(item);
        }
        return back;
    }


    public static Room room(String name, String description, Object... objects) {
        Room room = new RoomImpl();
        room.setName(name);
        room.setDescription(description);

        for(Object object: objects){
            if(object instanceof Exit){
                Exit exit = (Exit)object;
                room.setExits(exit);
            } else if(object instanceof Item){
                Item item = (Item)object;
                room.addItem(item);
            } else
                throw new RuntimeException(object.toString()+" - this object is not supported for rooms");
        }
        return room;
    }

    public static Exit exit(String location, String name){
        Exit exit = new ExitImpl(name, location);
        return exit;
    }

    public static Item item(String name, String description){
        Item item = GameObjectFactory.getItemImplementation(GameObjectFactory.ObjectType.ITEM, name);
        item.setDescription(description);
        return item;
    }

    public static Entity entity(String name, String description){
        Entity entity = GameObjectFactory.getItemImplementation(GameObjectFactory.ObjectType.ENTITY, name);
        entity.setDescription(description);
        return entity;
    }

    @Override
    public Game build() {
        return instance.game;
    }
}
