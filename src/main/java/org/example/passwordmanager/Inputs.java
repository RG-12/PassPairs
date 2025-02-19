package org.example.passwordmanager;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Inputs {
    private NotingList lists;

    public Inputs(NotingList lists) {
        this.lists = lists;
    }

    public Parent getView() {
        GridPane layout = new GridPane();

        Label idLabel = new Label("Used ID");
        TextField idField = new TextField();
        Label passLabel = new Label("Password");
        TextField passField = new TextField();

        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        Button addButton = new Button("Add the credentials.");

        layout.add(idLabel, 0, 0);
        layout.add(idField, 0, 1);
        layout.add(passLabel, 0, 2);
        layout.add(passField, 0, 3);
        layout.add(addButton, 0, 4);

        addButton.setOnMouseClicked((event) -> {
            String id = idField.getText();
            String pass = passField.getText();

            lists.add(id, pass);

            idField.clear();
            passField.clear();
        });

        return layout;
    }

}
