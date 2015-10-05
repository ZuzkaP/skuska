package com.game.meta;

/**
 * Created by Tomáš on 1.10.2015.
 */
public interface Command extends Named {
    /**
     * Metoda slúi na konkrétnu realizáciu jednotlivıch príkazov, prièom vstupmi sú :
     * @param game Spustená hra
     * @param params Vstupnı reazec naèítanı zo štandardného vstupu
     */
    void execute(Game game, String params);
}
