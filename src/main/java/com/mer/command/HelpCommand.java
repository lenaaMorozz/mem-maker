package com.mer.command;

import java.util.ArrayList;
import java.util.List;

public class HelpCommand implements Command {
    private final List<String> helpList = new ArrayList<>();
    @Override
    public void execute(String[] args) {
        helpList.add("Commands:");
        helpList.add("""
                1. mem <image path> <text> - creates a new image from the specified path and adds text to the image.
                The image must be in the current directory, example: ./cat.jpg
                Possible additional parameters:
                \t<location> (top, center, bottom) - places text on the image at the top, center or bottom. Default - bottom
                \t<font size> - default 50.
                """);

        helpList.forEach(System.out::println);
    }
}
