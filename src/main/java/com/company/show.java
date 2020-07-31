package com.company;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.sourceforge.tess4j.TesseractException;

import java.io.IOException;

public class show {
    Stage window;
    void img(WritableImage image){

        window = new Stage();
        window.setTitle("show");

        VBox vertical = new VBox();
        HBox horizontal = new HBox();
        BorderPane layout3 = new BorderPane();
        layout3.setPadding(new Insets(10,10,10,10));

        ImageView disp = new ImageView(image);
        if(image.getHeight()>1000) {
            disp.setFitHeight(400);
        }
        else {
            disp.setFitHeight(image.getHeight());
        }
        if(image.getWidth()>1900) {
            disp.setFitWidth(1900);
        }
        else {
            disp.setFitWidth(image.getWidth());
        }
        vertical.getChildren().add(disp);
        layout3.setTop(vertical);

        Button button = new Button("OCR");
        button.setOnAction(lambda -> {
            try {
                new tess().ocr(image);
            } catch (TesseractException | IOException e) {
                e.printStackTrace();
            }
        });

        Button back = new Button("BACK");
        back.setOnAction(lambda -> window.close());
        horizontal.getChildren().addAll(button, back);
        layout3.setBottom(horizontal);

        Scene scene3 = new Scene(layout3);
        window.setScene(scene3);
        window.show();
    }
}
