package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/page/login.fxml"));
        primaryStage.setTitle("学生管理系统");
        primaryStage.setScene(new Scene(root));

        primaryStage.show();
        primaryStage.setResizable(false); // 设置窗口为不可调整大小


    }


    public static void main(String[] args) {
        launch(args);
    }
}