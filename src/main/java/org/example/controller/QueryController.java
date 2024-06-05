package org.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import org.example.entity.Student;
import org.example.service.impl.StudentServiceImpl;

import java.util.*;

public class QueryController {

    private final HashMap<String, String> options = new HashMap<String, String>();
    private Stage stage;

    private String option;

    @FXML
    private ChoiceBox<String> myChoiceBox;

    @FXML
    private TextField queryValue;

    private LoadController loadController;

    public void setLoadController(LoadController loadController) {
        this.loadController = loadController;
    }

    // 初始化方法
    @FXML
    public void initialize() {
        // 设置默认选项
        myChoiceBox.getSelectionModel().selectFirst();

        // 添加监听器以响应选项变化
        myChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            option=newValue;
        });

        options.put("学号", "stuId");
        options.put("姓名", "name");
        options.put("班级", "cla");
        options.put("性别", "sex");
        options.put("出生日期", "birth");
        options.put("专业", "profession");

    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void close() {
        if (stage != null) {
            stage.close();
        }
    }

    public void query(){
        // 查询学生信息
        String value = queryValue.getText();
        System.out.println(options.get(option));
        StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
        List<Student> students = studentServiceImpl.queryBy(options.get(option), value);

        String message = " ";
        if(students.isEmpty()) {
            message = "查询失败，未找到符合条件的学生";
        }else {
            message = "查询成功";
            close();
        }

        // 显示警告框
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("信息");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

        queryValue.clear();


        loadController.load(students);

    }
}
