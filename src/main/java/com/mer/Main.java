package com.mer;

import com.mer.command.Command;
import com.mer.factory.CommandFactory;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("You need to enter parameters\nSee 'help'");
            return;
        }
        try {
            Command command = new CommandFactory().createCommand(args);
            command.execute(args);
        } catch (IllegalArgumentException e) {
            System.out.println("You need to enter parameters\nSee 'help'");
        }
    }
}