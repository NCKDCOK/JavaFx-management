package org.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.entity.Student;
import org.example.service.impl.StudentServiceImpl;

public class UpdateController {
    private Stage stage;

    @FXML
    private TextField uname;

    @FXML
    private TextField ustuId;

    @FXML
    private TextField ucla;

    @FXML
    private TextField usex;

    @FXML
    private TextField ubirth;

    @FXML
    private TextField uprofession;

    @FXML
    private TextField id;


    @FXML
    private void initialize() {
        ustuId.setEditable(false);
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

    public void update(){
        // 更新学生信息
        // 添加学生信息
        Student student = new Student();
        student.setName(uname.getText());
        student.setStuId(ustuId.getText());
        student.setCla(ucla.getText());
        student.setSex(usex.getText());
        student.setBirth(ubirth.getText());
        student.setProfession(uprofession.getText());

        StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
        int result = studentServiceImpl.update(student);
        String message = " ";
        if(result == -1) {
            message = "请填写完整信息";
        }else if(result == 0) {
            message = "修改失败";
        }else {
            message = "修改成功";
        }

        // 显示警告框
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("信息");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

        if (result > 0) {
            // 添加成功，重置表格字段
            uname.clear();
            ustuId.clear();
            ucla.clear();
            usex.clear();
            ubirth.clear();
            uprofession.clear();
            id.clear();
        }
    }


    public void select(){
        // 查询学生信息
        String selectId = id.getText();
        StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
        Student student = studentServiceImpl.select(selectId);
        if(student != null) {
            uname.setText(student.getName());
            ustuId.setText(student.getStuId());
            ucla.setText(student.getCla());
            usex.setText(student.getSex());
            ubirth.setText(student.getBirth());
            uprofession.setText(student.getProfession());
        }
    }
}
