package com.game.runner;

import com.game.meta.Game;
import com.game.meta.GameState;
import com.game.ui.Menu;
import com.game.ui.TextUI;
import com.game.meta.UserInterface;

/**
 * Created by Tomáš on 5.10.2015.
 */
public class GameRunner {
    public static void run(Game game) {
        UserInterface ui = new TextUI();
        Menu menu = new Menu(new String[] {"Nova hra", "Koniec"});
        menu.setVisible(true);
        switch(menu.menu()) {
            case 0:
                menu.setVisible(false);
                game.setUI(ui);
                game.setGameState(GameState.PLAYING);
                ui.loop(game);
                break;

            case 1:
                System.exit(0);
        }
    }
}
