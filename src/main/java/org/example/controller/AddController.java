package org.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.entity.Student;
import org.example.service.impl.StudentServiceImpl;

public class AddController {
    private Stage stage;

    @FXML
    private TextField aname;

    @FXML
    private TextField astuId;

    @FXML
    private TextField acla;

    @FXML
    private TextField asex;

    @FXML
    private TextField abirth;

    @FXML
    private TextField aprofession;




    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void close() {
        if (stage != null) {
            stage.close();
        }
    }

    public void add() {
        // 添加学生信息
        Student student = new Student();
        student.setName(aname.getText());
        student.setStuId(astuId.getText());
        student.setCla(acla.getText());
        student.setSex(asex.getText());
        student.setBirth(abirth.getText());
        student.setProfession(aprofession.getText());

        StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
        int result = studentServiceImpl.add(student);
        String message = " ";
        if(result == -1) {
            message = "请填写完整信息";
        }else if(result == 0) {
            message = "添加失败";
        }else {
            message = "添加成功";
        }

        // 显示警告框
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("信息");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

        if (result > 0) {
            // 添加成功，重置表格字段
            aname.clear();
            astuId.clear();
            acla.clear();
            asex.clear();
            abirth.clear();
            aprofession.clear();
        }
    }
}
