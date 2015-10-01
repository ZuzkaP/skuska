/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.game.commands;

import com.game.abstr.AbstractCommand;
import com.game.abstr.Game;
import com.game.core.GameImpl;

/**
 * @author Bingo Player
 */
public class Map extends AbstractCommand {
    /**
     * Tento konštruktor vytvorí novú inštanciu tejto triedy, pričom vstupnými
     * parametrami sú názov a opis príkazu.
     *
     * @param nazov       Názov príkazu
     * @param description Opis príkazu
     */
    public Map(String nazov, String description) {
        super(nazov, description);
    }

    @Override
    public void execute(Game game, String params) {
        // params na male pismenka
        params = params.toLowerCase();
        params.trim();

        if (!params.equals(getName().toLowerCase()))
            game.getUI().print("Nespravne vyuzitie prikazu MAPA!\n\n");
        else {
            GameImpl hra = (GameImpl) game;

            // vypis mapu
            hra.getGameMap().showMap(game.getUI());
        }

    }
}
