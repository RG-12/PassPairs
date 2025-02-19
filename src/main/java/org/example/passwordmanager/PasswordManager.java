package org.example.passwordmanager;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PasswordManager extends Application {

    private NotingList lists;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        this.lists = new NotingList();
    }

    @Override
    public void start(Stage window) {
        Inputs inputs = new Inputs(lists);
        Manager manager = new Manager(lists);

        BorderPane layout = new BorderPane();

        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 30));
        menu.setSpacing(100);

        Button enterButton = new Button("Enter Usernames and Passwords");
        Button practiceButton = new Button("Find the Passwords");

        menu.getChildren().addAll(enterButton, practiceButton);
        layout.setTop(menu);

        enterButton.setOnAction((event) -> layout.setCenter(inputs.getView()));
        practiceButton.setOnAction((event) -> layout.setCenter(manager.getView()));

        layout.setCenter(inputs.getView());

        Scene view = new Scene(layout, 500, 300);

        window.setTitle("PassPairs - A Password Manager");
        window.setScene(view);
        window.show();
    }



}
