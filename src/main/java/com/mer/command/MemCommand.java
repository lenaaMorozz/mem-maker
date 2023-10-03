package com.mer.command;

import com.mer.ImageEditor;

public class MemCommand implements Command {
    @Override
    public void execute(String[] args) {
        if (args.length < 3) {
            System.out.println("incorrect command\nSee 'help'");
            System.exit(0);
        }

        ImageEditor imageEditor = new ImageEditor();

        imageEditor.addTextToImage(args);
    }
}
