/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.builder;

import com.game.abstr.AbstractEntity;
import com.game.abstr.AbstractItem;
import com.game.entity.*;
import com.game.impl.ExitImpl;
import com.game.impl.GameImpl;
import com.game.impl.RoomImpl;
import com.game.item.*;
import com.game.meta.Entity;
import com.game.meta.Exit;
import com.game.meta.GameState;
import com.game.meta.Item;
import com.game.meta.Player;
import com.game.meta.Room;

/**
 *
 * @author ondre
 */
public class MethodChainingBuilder {

    private static MethodChainingBuilder instance = null;
    private GameImpl game = new GameImpl();
    private static Player player;
    private static Room room = new RoomImpl();
    private static Item item;
    private static Entity entity;
    private static Exit exit;

    //nesom si isty, ci je tato metoda potrebna - J
    public static MethodChainingBuilder getInstance() {
        if (instance != null) {
            return instance;
        }
        return instance = new MethodChainingBuilder();
    }
    //
    
    public MethodChainingBuilder game(String welcomeText) {
        game.setGameState(GameState.PLAYING);
        game.getCurrentRoom().setDescription(welcomeText);
        return this;
    }
    
    ///////////////////////////////////////////////////////////////////////////////
    //skor takto - Jakub
    public MethodChainingBuilder game() {
        this.game = new GameImpl();
        return this;
    }
    
    public MethodChainingBuilder addPlayer(int capacity){
        Player p = new Player("Player", capacity);
        this.game.setPlayer(p);
        return this;
    }
    
    public MethodChainingBuilder setPlayerName(String name){
        this.game.getPlayer().setName(name);
        return this;
    }
    
    public MethodChainingBuilder addPlayersItems(String i){
        this.game.getPlayer().getBackpack().add(newItem(i));
        return this;
    }
    
    public MethodChainingBuilder setCurrentRoom(String roomName){
        Room r = this.game.getCurrentRoom().getRoomByName(roomName);
        this.game.setCurrentRoom(r);
        return this;
    }
    
    public MethodChainingBuilder addRoom(){
        Room r = new RoomImpl();
        this.game.getCurrentRoom().addRoom(r);
        this.game.setCurrentRoom(r);
        return this;
    }
    
    public MethodChainingBuilder setRoomName(String name){
        this.game.getCurrentRoom().setName(name);
        return this;
    }
    
    public MethodChainingBuilder setRoomDesc(String desc){
        this.game.getCurrentRoom().setDescription(desc);
        return this;
    }
    
    public MethodChainingBuilder addItemToRoom(String i){
        this.game.getCurrentRoom().addItem(newItem(i));
        return this;
    }
    
    public MethodChainingBuilder addEntityToRoom(String e){
        this.game.getCurrentRoom().addEntity(newEntity(e));
        return this;
    }
    
    public MethodChainingBuilder addExitToRoom(String name, String location){
        Exit e = new ExitImpl(name, location);
        this.game.getCurrentRoom().setExits(e);
        return this;
    }
    
    public AbstractItem newItem(String name) {
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
    
    public AbstractEntity newEntity(String name) {
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
    //koniec - J
    ///////////////////////////////////////////////////////////////////////////////
    
    public Player player(){
        return new Player("Player", 20);
    }

    public Player player(String name) {
        return new Player(name, 20);
    }

    public Player player(String name, int count) {
        return new Player(name, count);
    }
    
    public Player player(String name, int count, AbstractItem... items){
        Player p = new Player(name, count);
        for(AbstractItem i : items){
            p.getBackpack().add(i);
        }
        return p;
    }
    
    public MethodChainingBuilder room(Exit... exits) {
        room.setExits(exits);
        return this;
    }
    
    public MethodChainingBuilder newRoom(String name, String description){
        room = new RoomImpl(name, description);
        return this;
    }

    public MethodChainingBuilder roomWithItems(String name, String description, AbstractItem... items) {
        room = new RoomImpl(name, description);
        for (AbstractItem i : items) {
            room.addItem(i);
        }
        return this;
    }

    public MethodChainingBuilder roomWithEntities(String name, String description, AbstractEntity... entities) {
        room = new RoomImpl(name, description);
        for (AbstractEntity e : entities) {
            room.addEntity(e);
        }
        return this;
    }
    
    public MethodChainingBuilder roomWithBoth(Room roomWithItems, AbstractEntity... entities){
        for (AbstractEntity e : entities){
            roomWithItems.addEntity(e);
        }
        return this;
    }

    public MethodChainingBuilder item(String name) {
        switch (name.toLowerCase()) {
            case ("axe"):
                item = new Axe();
            case("chalice"):
                item = new Chalice();
            case ("chest"):
                item = new Chest();
            case ("copperkey"):
                item = new CopperKey();
            case ("detector"):
                item = new Detector();
            case ("detonator"):
                item = new Detonator();
            case ("diamondchest"):
                item = new DiamondChest();
            case ("diamondkey"):
                item = new DiamondKey();
            case ("flashlights"):
                item = new Flashlight();
            case ("generator"):
                item = new Generator();
            case ("goldkey"):
                item = new GoldKey();
            case ("ironhole"):
                item = new IronHole();
            case ("key"):
                item = new Key();
            case ("lever"):
                item = new Lever();
            case ("lockpick"):
                item = new LockPick();
            case ("mace"):
                item = new Mace();
            case ("mine"):
                item = new Mine();
            case ("nanosword"):
                item = new NanoSword();
            case ("puta"):
                item = new Puta();
            case ("shells"):
                item = new Shells();
            case ("shotgun"):
                item = new Shotgun();
            case ("silverkey"):
                item = new SilverKey();
            case ("steelkey"):
                item = new SteelKey();
            case ("sword"):
                item = new Sword();
            case ("tnt"):
                item = new TNT();
            case ("teleport"):
                item = new Teleport();
            case ("ultrakey"):
                item = new UltraKey();
            case ("woodkey"):
                item = new WoodKey();
            case ("wrench"):
                item = new Wrench();
            default:
                item = null;
        }
        return this;
    }

    public MethodChainingBuilder entity(String name) {
        switch (name.toLowerCase()) {
            case ("boss"):
                entity = new Boss();
            case ("finalboss"):
                entity = new FinalBoss();
            case ("princess"):
                entity = new Princess();
            case ("skeleton"):
                entity = new Skeleton();
            case ("zombie"):
                entity = new Zombie();
            default:
                entity = null;
        }
        return this;
    }
    
    //TO DO
    public MethodChainingBuilder exit(String name, String location){
         exit = new ExitImpl(name, location);
        return this;
    }
    
    
}


