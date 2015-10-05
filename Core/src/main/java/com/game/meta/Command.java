package com.game.meta;

/**
 * Created by Tom� on 1.10.2015.
 */
public interface Command extends Named {
    /**
     * Metoda sl��i na konkr�tnu realiz�ciu jednotliv�ch pr�kazov, pri�om vstupmi s� :
     * @param game Spusten� hra
     * @param params Vstupn� re�azec na��tan� zo �tandardn�ho vstupu
     */
    void execute(Game game, String params);
}
