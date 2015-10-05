package com.game.meta;

public interface Game {
    public void setGameState(GameState state);

    public GameState getGameState();

    public Room getCurrentRoom();

    public void setCurrentRoom(Room room);

    public Player getPlayer();

    void setPlayer(Player player);

    void setUI(UserInterface userInterface);

    UserInterface getUI();

    Parser getParser();
}
