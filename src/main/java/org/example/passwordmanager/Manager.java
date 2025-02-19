package org.example.passwordmanager;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Manager {
    private NotingList lists;

    public Manager(NotingList lists) {
        this.lists = lists;
    }

    public Parent getView() {
        GridPane layout = new GridPane();

        Label idLabel = new Label("Enter the UserID");
        TextField passField = new TextField();

        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        Button addButton = new Button("Find");

        Label feedback = new Label("");

        layout.add(idLabel, 0, 0);
        layout.add(passField, 0, 1);
        layout.add(addButton, 0, 2);
        layout.add(feedback, 0, 3);

        addButton.setOnMouseClicked((event) -> {
            String translation = passField.getText();
            if (lists.get(translation) != null) {
                feedback.setTextFill(Color.GREEN);
                feedback.setText("Found! The password is: " + lists.get(translation));
            } else {
                feedback.setTextFill(Color.RED);
                feedback.setText("Not Found.");
                return;
            }

            passField.clear();
        });

        return layout;
    }
}
