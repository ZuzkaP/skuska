package com.game.abstr;

public interface UserInterface {

    public void print(String text);

    public void println(String arg0);

    public void setCursorPosition(int arg0, int arg1);

    public void setBackgroundColor(int arg0);

    public void setForegroundColor(int arg0);

    public void loop(Game arg0);
}

