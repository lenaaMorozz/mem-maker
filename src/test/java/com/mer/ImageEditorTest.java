package com.mer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ImageEditorTest {
    private final ImageEditor imageEditor = new ImageEditor();;

    @Test
    public void testAddTextToImage() {
        BufferedImage testImage = new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = testImage.createGraphics();
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, 200, 100);
        g2d.dispose();

        String testImagePath = "test-image.png";
        try {
            ImageIO.write(testImage, "png", new File(testImagePath));
        } catch (IOException e) {
            fail("Failed to create the test image.");
        }

        String[] args = new String[]{"mem", testImagePath, "Hello", "bottom", "24"};
        imageEditor.addTextToImage(args);

        assertTrue(new File("test-image-mem.png").exists());

        new File("test-image.png").deleteOnExit();
        new File("test-image-mem.png").deleteOnExit();
    }

    @Test
    public void testGetHeightText() {
        assertEquals(0.1, imageEditor.getHeightText("top"));
        assertEquals(0.5, imageEditor.getHeightText("center"));
        assertEquals(0.9, imageEditor.getHeightText("bottom"));
        assertThrows(IllegalArgumentException.class, () -> imageEditor.getHeightText("invalid"));
    }


    @Test
    public void testGetPathWithoutExtension() {
        String pathWithExtension = "test-image.png";
        String pathWithoutExtension = imageEditor.getPathWithoutExtension(pathWithExtension);

        assertEquals("test-image", pathWithoutExtension);
    }

    @Test
    public void testGetImageExtension() {
        String pathWithExtension = "test-image.png";
        String imageExtension = imageEditor.getImageExtension(pathWithExtension);

        assertEquals("png", imageExtension);
    }
}
