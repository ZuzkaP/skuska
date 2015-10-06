/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game.ui;

import com.game.impl.GameImpl;
import com.game.impl.RoomImpl;
import com.game.meta.Game;
import com.game.meta.GameState;
import com.game.meta.UserInterface;

import java.util.Scanner;


/**
 * Táto trieda je konkrétnou implementáciou rozhrania UserInterface, pričom táto
 * trieda slúži na čitanie vstupného reťazca a vypisovanie výstpuných správ na
 * obrazovku pomocou štandardného výstupu.
 *
 * @author Bingo Player
 */
public class TextUI implements UserInterface {
    private final String prefix;
    private Game game;

    /**
     * Prázdny konštruktor vytvorí novú inštanciu tejto triedy, pričom je
     * inicializovaná členská premenná prefix.
     */
    public TextUI() {
        prefix = "-> ";
    }

    /**
     * Táto metóda slúži na vypisovanie sráv na obrazovku, pričom vstupným
     * parametrom je reťazec, ktorý predstavuje výstupnú správu.
     *
     * @param string Výstupný reťazec
     */
    @Override
    public void print(String string) {
        System.out.print(string);
    }

    /**
     * Táto metóda slúži na vypisovanie sráv na obrazovku, pričom vstupným
     * parametrom je reťazec, ktorý predstavuje výstupnú správu.
     *
     * @param string Výstupný reťazec
     */
    @Override
    public void println(String string) {
        System.out.println(string);
    }

    /**
     * Táto metóda zabezpečuje chod hry. Ak sa hra nachádza v stave PLAYING číta
     * sa vstupný reťazec znakov, ktorý je následne poslaný na kontrolu, či je
     * relevantný. Ak sa hra nachádza v stave QUIT, vykresľuje sa menu. Ak sa
     * hra nachádza v stave GAMEOVER, resp. SOLVED vypíše sa hráčovi hláška
     * o aktuálnom stave hry a inicializuje sa nová hra.
     *
     * @param arg0 Aktuálna hra
     */
    @Override
    public void loop(Game arg0) {
        GameImpl game = (GameImpl) arg0;
        this.game = game;

        ((RoomImpl)game.getCurrentRoom()).show(this);
        while (game.getGameState() == GameState.PLAYING) {
            Scanner reader = new Scanner(System.in);
            print(prefix);
            String line = reader.nextLine();
            processCommand(line);
        }
        if (game.getGameState() == GameState.GAMEOVER) {
            println("\n\n\n###########Prehral si !###########\n\n\n");
        } else if (game.getGameState() == GameState.SOLVED) {
            println("\n\n\n######Uspesne si dokoncil hru!!######\n\n\n");
        }
    }

    public void processCommand(String line) {
        if (game.getParser().getCommand(line) == null)
            println("Taky prikaz nepoznam.");
        else {
            game.getParser().getCommand(line).execute(game, line);
        }
    }
}
