/*
 * VDSJ ZS 2015/2016
 * PO 7:30_2
 */
package com.game.builder;

import com.game.abstr.*;
import com.game.impl.GameImpl;
import com.game.impl.RoomImpl;
import com.game.item.*;
import com.game.entity.*;
import com.game.impl.ExitImpl;
import com.game.meta.Entity;
import com.game.meta.Exit;
import com.game.meta.GameState;
import com.game.meta.Item;
import com.game.meta.Player;
import com.game.meta.Room;

/**
 *
 * @author jakub
 */
public class NestedFunctionBuilder implements IDSLBuilder {

    private static NestedFunctionBuilder instance = null;
    private static GameImpl game = new GameImpl();
    private static Player player;
    private static RoomImpl room = new RoomImpl();
    private static Item item;
    private static Entity entity;

    public static NestedFunctionBuilder getInstance() {
        if (instance != null) {
            return instance;
        }
        return instance = new NestedFunctionBuilder();
    }
    
    /**kedze pri vytvarani novych RoomImpl nepoznam miestnosti, ktore budu nasledne vytvorene, musia sa exity vytvarat az potom,
    * co budu vytvorene vsetky RoomImpl.
    * Tato metoda bude mat prvy argument prvykrat metodu NestedFunctionBuilder game(String welcomeText, Player player, Room... rooms)
    * a potom stale seba. Druhym argumentom budu postupne vsetky vytvorene miestnosti a tretim argumentom bude
    * niekolko volani metody Exit exit(String name, String location), co vytvori zoznam exitov, ktore sa nasledne pridaju
    * k miestnosti. 
    */
    public NestedFunctionBuilder game(NestedFunctionBuilder builder, Room r, Exit... exits) {
        builder.game.getCurrentRoom().getMapOfRooms().get(r.getName()).setExits(exits);
        return this;
    }

    /*
    Tu sa vytvori nova instancia hry, argumentami su welcomeText, novy hrac/niektora z Player metod a niekolko miestnost/Room metody
    */
    public NestedFunctionBuilder game(String welcomeText, Player player, Room... rooms) {
        game.setGameState(GameState.PLAYING);
        game.getCurrentRoom().setName("First room");
        game.getCurrentRoom().setDescription(welcomeText);
        for (Room r : rooms) {
            game.getCurrentRoom().addRoom(r);
        }
        return this;
    }

    public Player player() {
        return new Player("Player", 20);
    }

    public Player player(String name) {
        return new Player(name, 20);
    }

    public Player player(String name, int count) {
        return new Player(name, count);
    }

    public Player player(String name, int count, AbstractItem... items) {
        Player p = new Player(name, count);
        for (AbstractItem i : items) {
            p.getBackpack().add(i);
        }
        return p;
    }

    // asi nepouzivat
//    public Room room(Room r, Exit... exits) {
//        r.setExits(exits);
//        return r;
//    }

    public Room newRoom(String name, String description) {
        return new RoomImpl(name, description);
    }

    public Room roomWithItems(String name, String description, AbstractItem... items) {
        Room r = new RoomImpl(name, description);
        for (AbstractItem i : items) {
            r.addItem(i);
        }
        return r;
    }

    public Room roomWithEntities(String name, String description, AbstractEntity... entities) {
        Room r = new RoomImpl(name, description);
        for (AbstractEntity e : entities) {
            r.addEntity(e);
        }
        return r;
    }

    public Room roomWithBoth(Room roomWithItems, AbstractEntity... entities) {
        for (AbstractEntity e : entities) {
            roomWithItems.addEntity(e);
        }
        return roomWithItems;
    }

    public AbstractItem item(String name) {
        switch (name.toLowerCase()) {
            case ("axe"):
                return new Axe();
            case ("chalice"):
                return new Chalice();
            case ("chest"):
                return new Chest();
            case ("copperkey"):
                return new CopperKey();
            case ("detector"):
                return new Detector();
            case ("detonator"):
                return new Detonator();
            case ("diamondchest"):
                return new DiamondChest();
            case ("diamondkey"):
                return new DiamondKey();
            case ("flashlights"):
                return new Flashlight();
            case ("generator"):
                return new Generator();
            case ("goldkey"):
                return new GoldKey();
            case ("ironhole"):
                return new IronHole();
            case ("key"):
                return new Key();
            case ("lever"):
                return new Lever();
            case ("lockpick"):
                return new LockPick();
            case ("mace"):
                return new Mace();
            case ("mine"):
                return new Mine();
            case ("nanosword"):
                return new NanoSword();
            case ("puta"):
                return new Puta();
            case ("shells"):
                return new Shells();
            case ("shotgun"):
                return new Shotgun();
            case ("silverkey"):
                return new SilverKey();
            case ("steelkey"):
                return new SteelKey();
            case ("sword"):
                return new Sword();
            case ("tnt"):
                return new TNT();
            case ("teleport"):
                return new Teleport();
            case ("ultrakey"):
                return new UltraKey();
            case ("woodkey"):
                return new WoodKey();
            case ("wrench"):
                return new Wrench();
            default:
                return null;
        }
    }

    public AbstractEntity entity(String name) {
        switch (name.toLowerCase()) {
            case ("boss"):
                return new Boss();
            case ("finalboss"):
                return new FinalBoss();
            case ("princess"):
                return new Princess();
            case ("skeleton"):
                return new Skeleton();
            case ("zombie"):
                return new Zombie();
            default:
                return null;
        }
    }

    //TO DO
    public ExitImpl exit(String name, String location) {
        return new ExitImpl(name, location);
    }

}
