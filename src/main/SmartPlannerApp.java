package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ui.MainUI;

public class SmartPlannerApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        MainUI mainUI = new MainUI();
        Scene scene = new Scene(mainUI.getRoot(), 600, 400);
        primaryStage.setTitle("Smart Daily Planner");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
