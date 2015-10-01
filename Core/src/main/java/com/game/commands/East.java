/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.commands;

import com.game.abstr.AbstractCommand;
import com.game.abstr.Game;
import com.game.abstr.GameState;
import com.game.core.GameImpl;

/**
 * Tento príkaz slúži na prechod z aktuálnej miestnosti do východného východu.
 *
 * @author Bingo Player
 */
public class East extends AbstractCommand {
    /**
     * Tento konštruktor vytvorí novú inštanciu tejto triedy, pričom vstupnými
     * parametrami sú názov a opis príkazu.
     *
     * @param nazov       Názov príkazu
     * @param description Opis príkazu
     */
    public East(String nazov, String description) {
        super(nazov, description);
    }

    @Override
    public void execute(Game game, String params) {
        // params na male pismenka
        params = params.toLowerCase();
        params.trim();

        // skontroluj output
        if (!params.equals(getName().toLowerCase())) {
            game.getUI().print("Nespravne pouzitie prikazu VYCHOD\n\n");
            return;
        }

        // da sa ist na vychod ?
        if (game.getCurrentRoom().getEast() != null)
            if (game.getCurrentRoom().getEast().getName() == null)
                if (game.getCurrentRoom().getItem("mina") == null && game.getCurrentRoom().getItem("zombie") == null &&
                        game.getCurrentRoom().getItem("kostlivec") == null && game.getCurrentRoom().getItem("boss1") == null &&
                        game.getCurrentRoom().getItem("boss2") == null && game.getCurrentRoom().getItem("boss3") == null &&
                        game.getCurrentRoom().getItem("finalboss") == null) {
                    // presun sa na vychod
                    game.setCurrentRoom(game.getCurrentRoom().getEast());
                    ((GameImpl) game).getGameMap().registerEastStep();
                } else
                    game.setGameState(GameState.GAMEOVER);
            else {
                game.getUI().print("Miestnost je zamknuta.\nNa odomknutie potrebujes : " + game.getCurrentRoom().getEast().getName() + ".\n\n");
            }
        else
            // vypis chybu
            game.getUI().print("Tadial sa ist neda.\n\n");
    }

}
