package com.game.abstr;

public interface Room extends Named {

    public void setExits(Room north, Room south, Room east, Room west);

    public Room getNorth();

    public Room getSouth();

    public Room getEast();

    public Room getWest();

    public void show(UserInterface arg0);

    public void addItem(Item item);

    public Item getItem(String name);

    public void removeItem(Item item);

    public void setDescription(String description);
}
