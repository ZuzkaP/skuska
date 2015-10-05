package com.game.meta;

import java.util.List;

public interface Parser {
    Command getCommand(String arg0);
    List<Command> getCommands();
}
