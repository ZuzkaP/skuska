/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**
 * Táto trieda je implementáciou menu hry, pričom je definovaná pomocou visibility,
 * a reťazcov, ktoré sú reprezentované ako položky menu.
 *
 * @author Bingo Player
 */
public class Menu {
    private final List<String> polozky;
    private boolean visible;
    private final String prefix;

    /**
     * Tento konštruktor vytvorí novú referenciu triedy Menu, pričom sa uloží
     * pole reťazcov do zoznamu, pričom jednotlivé reťazce predstavujú danú
     * položku nachádzajúcu sa v menu.
     *
     * @param polozky Pole všetkých reťazcov, ktoré predstavujú položky menu
     */
    public Menu(String polozky[]) {
        // inicializuj prefix
        this.prefix = "-> ";

        // polozky
        this.polozky = new ArrayList<>();
        this.polozky.addAll(Arrays.asList(polozky));

        // nastav visible
        visible = false;
    }

    /**
     * Táto metóda vracia reťazec, ktorý je na základe vstupného čísla vrátený
     * ako zoznam na i-tom prvku v zozname reťazcov, pričom i je vstupné číslo.
     *
     * @return reťazec.
     */
    public Integer menu() {
        if (this.visible) {
            // pridaj reader
            Scanner reader = new Scanner(System.in);

            // prefix
            System.out.print(prefix);

            int Input = 0;

            // precitaj riadok
            try {
                Input = reader.nextInt();
            } catch (Exception e) {
                System.err.print(e.toString());
            }

            return Input - 1;
        }

        // default null
        return null;
    }

    /**
     * Nastaví visibilitu menu, pričom ak je vstupný parameter true, zobrazí sa
     * menu, inak sa nezobrazí nič.
     *
     * @param visible Boolovská hodnota nastavenia visibility
     */
    public void setVisible(boolean visible) {
        if (visible) {
            char escCode = 0x1B;

            // pridaj polozky
            for (int i = 0; i < polozky.size(); i++) {
                // vypis polozky menu
                System.out.print(String.format("%c", escCode));
                System.out.print((i + 1) + ". " + this.polozky.get(i) + "\n");
            }
        }

        // priznak visible
        this.visible = visible;
    }
}
