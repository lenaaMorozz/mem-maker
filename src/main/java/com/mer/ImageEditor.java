package com.mer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageEditor {
    private BufferedImage image;

    public void addTextToImage(String[] args) {
        String imagePath = args[1];
        String addingText = args[2];

        String absolutePath = getAbsolutePath(imagePath);
        String pathWithoutExtension = getPathWithoutExtension(absolutePath);
        String imageExtension = getImageExtension(absolutePath);
        try {
            readImage(absolutePath);
        } catch (IOException e) {
            System.out.printf("Image %s not found", imagePath);
            System.exit(0);
        }

        double heightText = 0.9;
        int fontSize = 50;

        if (args.length > 3) {
            try {
                heightText = getHeightText(args[3]);
            } catch (IllegalArgumentException e) {
                System.out.printf("incorrect command %s\nSee 'help'", args[3]);
            }
            if (args.length > 4) {
                try {
                    fontSize = Integer.parseInt(args[4]);
                } catch (RuntimeException e) {
                    System.out.printf("incorrect command %s\nSee 'help'", args[4]);
                }
            }
        }

        Graphics2D g2d = image.createGraphics();
        Font font = new Font("Arial", Font.BOLD, fontSize);
        g2d.setFont(font);
        g2d.setColor(Color.WHITE);

        int wightImage = image.getWidth();
        int height = image.getHeight();

        FontMetrics fm = g2d.getFontMetrics();
        int textWight = fm.stringWidth(addingText);
        int textHeight = (int) (height * heightText);

        g2d.drawString(addingText, (wightImage - textWight) / 2, textHeight);

        g2d.dispose();

        String outputImagePath = pathWithoutExtension + "-new." + imageExtension;
        try {
            ImageIO.write(image, imageExtension, new File(outputImagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private double getHeightText(String height) {
        return switch (height) {
            case "top" -> 0.1;
            case "center" -> 0.5;
            case "bottom" -> 0.9;
            default -> throw new IllegalArgumentException();
        };
    }


    private void readImage(String imagePath) throws IOException {
            image = ImageIO
                    .read(new File(imagePath));
    }

    private String getAbsolutePath(String inputPath) {
        if (!Paths.get(inputPath).isAbsolute()) {
            String path = inputPath.replace("./", "");
            return Paths.get(path)
                    .toAbsolutePath()
                    .toString();
        }
        return inputPath;
    }

    private String getPathWithoutExtension(String path) {
        Pattern pattern = Pattern.compile(".*(?=\\.)");
        Matcher matcher = pattern.matcher(path);
        String pathWithoutExtension = "";

        if (matcher.find()) {
            pathWithoutExtension = matcher.group();
        } else {
            System.out.printf("Image %s not found", path);
            System.exit(0);
        }
        return pathWithoutExtension;
    }

    private String getImageExtension(String path) {
        Pattern pattern = Pattern.compile("[^\\.]+$");
        Matcher matcher = pattern.matcher(path);
        String imageExtension = "";

        if (matcher.find()) {
            imageExtension = matcher.group();
        } else {
            System.out.println("incorrect extension");
            System.exit(0);
        }
        return imageExtension;
    }
}
