package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.service.impl.LoginServiceImpl;

import java.io.IOException;

public class LoginController {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private void login(ActionEvent event) {
        String name = username.getText();
        String pwd = password.getText();
        LoginServiceImpl loginServiceImpl = new LoginServiceImpl();
        loginServiceImpl.login(name, pwd);
            // 登录成功后跳转到学生界面
            switchToStudentScreen(event);

    }

    private void switchToStudentScreen(ActionEvent event) {
        try {
            // 加载新的FXML文件
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/page/student.fxml"));
            Parent newScreenRoot = loader.load();

            // 获取新界面的控制器
            LoadController loadController = loader.getController();

            // 创建新的场景
            Scene newScene = new Scene(newScreenRoot);

            // 查找 SplitPane
            SplitPane splitPane = (SplitPane) newScene.lookup("#splitPanes"); // 确保 fx:id 是正确的

            if (splitPane != null) {
                // 设置固定的分隔符位置
                double dividerPosition = 0.18480725623582767;
                splitPane.setDividerPositions(dividerPosition);

                // 添加监听器以保持分隔符位置固定
                splitPane.getDividers().get(0).positionProperty().addListener((obs, oldVal, newVal) -> {
                    if (newVal.doubleValue() != dividerPosition) {
                        splitPane.setDividerPositions(dividerPosition);
                    }
                });
            } else {
                System.err.println("SplitPane not found");
            }

            // 获取当前的舞台
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // 将新场景设置为舞台的内容
            currentStage.setScene(newScene);
            currentStage.setResizable(false);
        } catch (IOException e) {
            // 处理加载FXML文件时的异常
            e.printStackTrace();
        }

    }
}
