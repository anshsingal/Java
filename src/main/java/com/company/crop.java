package com.company;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class crop {

    int ix, iy, fx, fy;
    Stage window = new Stage();
    WritableImage newimg;

    WritableImage cropper(Image img2) {
        //scene2
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("cropped");
        VBox layout2 = new VBox();
        Scene scene2 = new Scene(layout2);
        ImageView img = new ImageView(img2);
        //img.fitWidthProperty().bind(window.heightProperty());
        layout2.getChildren().add(img);

        scene2.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                ix = (int) mouseEvent.getX();
                iy = (int) mouseEvent.getY();
                System.out.println("button pressed, at (" + ix + ", " + iy + ")");
            }
        });
        scene2.addEventFilter(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                fx = (int) mouseEvent.getX();
                fy = (int) mouseEvent.getY();
                System.out.println("button released, at (" + fx + ", " + fy + ")");
                PixelReader read = img2.getPixelReader();
                newimg = new WritableImage(read, ix, iy, fx - ix, fy - iy);
                window.close();
            }
        });
        window.setScene(scene2);
        window.showAndWait();
        return newimg;
    }
}
