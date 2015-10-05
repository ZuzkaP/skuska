/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.command;

import com.game.abstr.AbstractCommand;
import com.game.meta.Game;
import com.game.meta.GameState;

/**
 * Tento príkaz slúži na prechod z aktuálnej miestnosti do severného východu.
 *
 * @author Bingo Player
 */
public class North extends AbstractCommand {
    /**
     * Tento konštruktor vytvorí novú inštanciu tejto triedy, pričom vstupnými
     * parametrami sú názov a opis príkazu.
     *
     * @param nazov       Názov príkazu
     * @param description Opis príkazu
     */
    public North(String nazov, String description) {
        super(nazov, description);
    }

    @Override
    public void execute(Game game, String params) {
        // params na male pismenka
        params = params.toLowerCase();
        params.trim();

        // skontroluj output
        if (!params.equals(getName().toLowerCase())) {
            System.out.println("Nespravne pouzitie prikazu SEVER\n\n");
            return;
        }

        // da sa ist na vychod ?
        if (game.getCurrentRoom().getNorth() != null)
            if (game.getCurrentRoom().getNorth().getName() == null)
                if (game.getCurrentRoom().getItem("mina") == null && game.getCurrentRoom().getItem("zombie") == null &&
                        game.getCurrentRoom().getItem("kostlivec") == null && game.getCurrentRoom().getItem("boss1") == null &&
                        game.getCurrentRoom().getItem("boss2") == null && game.getCurrentRoom().getItem("boss3") == null &&
                        game.getCurrentRoom().getItem("finalboss") == null) {
                    // presun sa na vychod
                    game.setCurrentRoom(game.getCurrentRoom().getNorth());
                } else
                    game.setGameState(GameState.GAMEOVER);
            else
                System.out.println("Miestnost je zamknuta.\nNa odomknutie potrebujes : " + game.getCurrentRoom().getNorth().getName() + ".\n\n");
        else
            // vypis chybu
            System.out.println("Tadial sa ist neda.\n\n");
    }
}
