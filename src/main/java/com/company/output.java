package com.company;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class output {
    void show(String msg) {
        Stage window = new Stage();
        window.setTitle("OCR results");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        Text label = new Text(msg);
        GridPane.setConstraints(label, 0, 0);

        Button copy = new Button("copy");
        copy.setOnAction(lambda -> {
            Clipboard clipboard = Clipboard.getSystemClipboard();
            ClipboardContent content = new ClipboardContent();
            content.putString(msg);
            clipboard.setContent(content);
        });
        GridPane.setConstraints(copy, 0, 1);

        grid.getChildren().addAll(label, copy);
        Scene scene = new Scene(grid);
        window.setScene(scene);
        window.show();
    }
}
