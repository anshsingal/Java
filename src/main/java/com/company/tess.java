package com.company;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

public class tess {
    void ocr(WritableImage img) throws TesseractException, IOException {
        String text = performOCR(img);
        new output().show(text);
        System.out.println(text);
    }

    String performOCR(WritableImage img) throws TesseractException, IOException {
        System.out.println("performing ocr");
        Tesseract tess = new Tesseract();
        tess.setDatapath("C:\\Users\\Ansh Singal\\Desktop\\study\\java\\java_project");
        //we convert the image to a png format from writeable image
        File file = new File("test_dest.png");
        RenderedImage renderedImage = SwingFXUtils.fromFXImage(img, null);
        ImageIO.write(renderedImage, "png", file);
        return tess.doOCR(file);
    }
}
