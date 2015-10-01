/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.game.commands;


import com.game.abstr.AbstractCommand;
import com.game.abstr.Game;
import com.game.core.GameImpl;
import com.game.core.History;

/**
 * Tento príkaz slúži na reštartovanie aktuálnej hry, pričom sa hra spustí odznova.
 *
 * @author Bingo Player
 */
public class Restart extends AbstractCommand {
    /**
     * Tento konštruktor vytvorí novú inštanciu tejto triedy, pričom vstupnými
     * parametrami sú názov a opis príkazu.
     *
     * @param nazov       Názov príkazu
     * @param description Opis príkazu
     */
    public Restart(String nazov, String description) {
        super(nazov, description);
    }

    @Override
    public void execute(Game game, String params) {
        // params na male pismenka
        params = params.toLowerCase();
        params.trim();

        // skontroluj output
        if (!params.equals(getName().toLowerCase())) {
            game.getUI().print("Nespravne pouzitie prikazu RESTART\n\n");
            return;
        }

        GameImpl hra = (GameImpl) game;
        hra.initLevels();
        hra.getMenu().setVisible(false);
        History.getHistory().clear();
    }
}

