/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.command;


import com.game.abstr.AbstractCommand;
import com.game.meta.Game;
import com.game.meta.GameState;

/**
 * Tento príkaz slúži na ukončenie hrania a vrátenia do menu hry.
 *
 * @author Bingo Player
 */
public class Quit extends AbstractCommand {
    /**
     * Tento konštruktor vytvorí novú inštanciu tejto triedy, pričom vstupnými
     * parametrami sú názov a opis príkazu.
     *
     * @param nazov       Názov príkazu
     * @param description Opis príkazu
     */
    public Quit(String nazov, String description) {
        super(nazov, description);
    }

    @Override
    public void execute(Game game, String params) {
        // params na male pismenka
        params = params.toLowerCase();
        params.trim();

        // skontroluj output
        if (!params.equals(getName().toLowerCase())) {
            System.out.println("Nespravne pouzitie prikazu KONIEC\n\n");
            return;
        }

        System.out.println("Koniec hry.\n\n");
        game.setGameState(GameState.QUIT);
    }
}
