/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.impl;

import com.game.meta.Entity;
import com.game.meta.Item;
import com.game.meta.Room;

import java.util.ArrayList;

/**
 * Táto trieda je konkrétnou implementáciou rozhrania Room a RoomNameSet, pričom
 * táto trieda je definovaná pomocou názvu a opisu miestnosti. Tiež obsiahuje 4
 * referencie na všetky možné východy z miestnosti.
 *
 * @author Bingo Player
 */
public class RoomImpl implements Room {
    // data
    private String description;
    private String nazov;
    private Room south;
    private Room north;
    private Room west;
    private Room east;
    private final ArrayList<Item> items;
    private final ArrayList<Entity> entities;

    public RoomImpl() {
        this(null, null);
    }

    /**
     * Tento konštruktor vytvorí novú inštanciu tejto triedy, pričom vstupným
     * parametrom je iba reťazec predtavujúci opis miestnosti.
     *
     * @param description Opis miestnosti
     */
    public RoomImpl(String description) {
        this(null, description);
    }

    /**
     * Tento konštruktor vytvorí novú inštanciu tejto triedy, pričom vstupným
     * parametrom je reťazec predstavujúci názov miestnosti a reťazec
     * predstavujúci opis miestnosti.
     *
     * @param nazov       Názov miestnosti
     * @param description Opis miestnosti
     */
    public RoomImpl(String nazov, String description) {
        // novy nazov
        this.nazov = nazov;

        // novy description
        this.description = description;

        // inicializuj pointery
        south = north = west = east = null;

        // inicializuj items
        items = new ArrayList<>();
        entities = new ArrayList<>();
    }

    /**
     * Táto metóda slúži na nastavenie referencií jednotlivých miestností, ktoré
     * predstavujú možné východy z miestnosti.
     *
     * @param north Referencia na severnú miestnosť
     * @param south Referencia na južnú miestnosť
     * @param east  Referencia na východnú miestnosť
     * @param west  Referencia na západnú miestnosť
     */
    @Override
    public void setExits(Room north, Room south, Room east, Room west) {
        if (north != null) {
            this.north = north;
        }
        if (south != null) {
            this.south = south;
        }
        if (east != null) {
            this.east = east;
        }
        if (west != null) {
            this.west = west;
        }
    }

    /**
     * Táto metóda vráti referenciu na Room, pričom reprezentuje miestnosť
     * nachádzajúcu sa na severe.
     *
     * @return miestnosť na severe.
     */
    @Override
    public Room getNorth() {
        return north;
    }

    /**
     * Táto metóda vráti referenciu na Room, pričom reprezentuje miestnosť
     * nachádzajúcu sa na juhu.
     *
     * @return miestnosť na juhu.
     */
    @Override
    public Room getSouth() {
        return south;
    }

    /**
     * Táto metóda vráti referenciu na Room, pričom reprezentuje miestnosť
     * nachádzajúcu sa na východe.
     *
     * @return miestnosť na východe.
     */
    @Override
    public Room getEast() {
        return east;
    }

    /**
     * Táto metóda vráti referenciu na Room, pričom reprezentuje miestnosť
     * nachádzajúcu sa na západe.
     *
     * @return miestnosť na západe.
     */
    @Override
    public Room getWest() {
        return west;
    }

    /**
     * Táto metóda slúži na vypísanie opisu miestností spolu s všetkými
     * predmetmi, ktoré sa v miestnosti nachádzajú a taktiež vypísaním všetkých
     * možných východov z tejto miestnosti.
     *
     * @param arg0 Užívateľské rozhranie
     */
//    @Override
//    public void show(UserInterface arg0) {
//        // vypis description
//        if (this.description != null)
//            arg0.print(getDescription());
//
//        arg0.print("\n\nMozne vychody z miestnosti:\n");
//
//        // string
//        String out = new String();
//
//        // pridaj miestnosti
//        if (this.south != null)
//            out += "juh" + ", ";
//        if (this.north != null)
//            out += "sever" + ", ";
//        if (this.east != null)
//            out += "vychod" + ", ";
//        if (this.west != null)
//            out += "zapad" + ", ";
//
//        // konvertuj na pole
//        char[] Vychody = out.toCharArray();
//
//        // zisti dlzku retazca
//        int len = out.length();
//
//        // poslednu ciarku prepis na medzeru
//        if (Vychody.length > 2)
//            Vychody[len - 2] = ' ';
//
//        // zapis vysledok spat do stringu
//        out = new String(Vychody);
//
//        // vypis vychody
//        arg0.print(out + "\n\n");
//
//        // pozbieraj predmety v miestnosti
//        if (items.isEmpty())
//            arg0.print("Nevidis nic zvlastneho.\n");
//        else {
//            arg0.print("Vidis :\n");
//
//            // vypisuj predmety
//            for (int i = 0; i < items.size(); i++)
//                arg0.print(items.get(i).getName() + "\n");
//        }
//
//        arg0.print("\n");
//    }

    /**
     * Táto metóda slúži na vkladanie nových predmetov do miestnosti.
     *
     * @param item Referencia na predmet, ktorý má byť pridaný do zoznamu
     */
    @Override
    public void addItem(Item item) throws NullPointerException {
        items.add(item);
    }

    /**
     * Táto metóda slúži na vrátenie referencie na predmet, ktorý je
     * reprezentovaný vstupným parametrom, ktorý je reťazec. Vrátena je
     * referencia na Item resp. null ak sa predmet nenašiel.
     *
     * @param name Názov predmetu
     * @return predmet z miestnosti.
     */
    @Override
    public Item getItem(String name) {
        if (name != null) {
            for (Item item : items) {
                if (item.getName().equalsIgnoreCase(name)) {
                    return item;
                }
            }
        }
        return null;
    }

    /**
     * Táto metóda slúži na odstránenie daného predmetu z miestnosti, pričom
     * vstupným parametrom je referencia na predmet, ktorý má byť z miestnosti
     * vymazaný.
     *
     * @param item Referencia na predmet, ktorý mý byť vymazaný
     */
    @Override
    public void removeItem(Item item) throws NullPointerException {
        if (item != null) {
            items.remove(item);
        }
    }

    @Override
    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    @Override
    public Entity getEntity(String name) {
        if(name != null) {
            for(Entity entity : entities) {
                if(entity.getName().equals(name)) {
                    return entity;
                }
            }
        }
        return null;
    }

    @Override
    public void removeEntity(Entity entity) {
        if(entity != null) {
            entities.remove(entity);
        }
    }

    /**
     * Táto metóda slúži na nastavenie nového opisu miestnosti, pričom
     *
     * @param description Opis miestnosti
     */
    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Táto metóda slúži na nastavenie nového názvu miestnosti.
     *
     * @param name Názov meistnosti
     */
    @Override
    public void setName(String name) {
        this.nazov = name;
    }

    /**
     * Táto metóda vráti reťazec reprezentujúci názov miestnosti.
     *
     * @return názov miestnosti
     */
    @Override
    public String getName() {
        return nazov;
    }

    /**
     * Táto metóda vráti reťazec reprezentujúci opis miestnosti.
     *
     * @return opis miestnosti
     */
    @Override
    public String getDescription() {
        return description;
    }
}
