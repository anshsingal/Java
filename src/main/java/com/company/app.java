package com.company;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class app extends Application {
    public void run(){
        launch();
    }

    WritableImage newimg;
    String addr="C:\\Users\\Ansh Singal\\Desktop\\study\\java\\java_project\\test.jpeg";
    FileInputStream file;
    Image img2;

    @Override
    public void start(Stage stage) throws Exception {
        Stage window = new Stage();
        window.setTitle("OCR Application");
        //scene 1
        GridPane layout = new GridPane();
//        layout.setVgap(10);
//        layout.setHgap(10);
//        layout.setPadding(new Insets(10,10,10,10));
        Scene scene = new Scene(layout);

        Label label = new Label("Enter image path:");
        GridPane.setConstraints(label, 0, 0);

        TextField path = new TextField(addr);
        path.setPrefWidth(400);
        GridPane.setConstraints(path, 1, 0);

        Button submit = new Button("submit");
        submit.setOnAction(lambda -> {
            addr=path.getText();
            try {
                file = new FileInputStream(addr);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            img2 = new Image(file);
            System.out.println(addr);
        });

        GridPane.setConstraints(submit, 1, 1);

        FileInputStream file = new FileInputStream(addr);
        img2 = new Image(file);
        System.out.println(addr);

        PixelReader read = img2.getPixelReader();
        newimg = new WritableImage(read, (int)img2.getWidth(), (int)img2.getHeight());

        Button button = new Button("Select portion for OCR");
        button.setOnAction(lambda -> {
            crop c = new crop();
            newimg = c.cropper(img2);
        });

        GridPane.setConstraints(button, 0, 2);

        Button button2 = new Button("Perform OCR");
        button2.setOnAction(lambda -> new show().img(newimg));
        GridPane.setConstraints(button2, 0, 3);

        layout.getChildren().addAll(button, button2, submit, label, path);

        window.setScene(scene);
        window.show();
    }
}
