package com.game.abstr;

public interface Game {

    public void setUI(UserInterface ui);

    public UserInterface getUI();

    public void setGameState(GameState state);

    public GameState getGameState();

    public void init();

    public void start();

    public void processCommand(String command);

    public Room getCurrentRoom();

    public void setCurrentRoom(Room room);

    public Backpack getBackpack();
}
