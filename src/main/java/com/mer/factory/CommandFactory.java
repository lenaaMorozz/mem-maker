package com.mer.factory;

import com.mer.command.Command;
import com.mer.command.HelpCommand;
import com.mer.command.MemCommand;

public class CommandFactory {

    public Command createCommand(String[] command) {
        switch (command[0]) {
            case "mem" -> {
                return new MemCommand();
            }
            case "help" -> {
                return new HelpCommand();
            }
            default -> throw new IllegalArgumentException();
        }
    }

}
