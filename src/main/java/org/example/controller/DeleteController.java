package org.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.service.impl.StudentServiceImpl;

public class DeleteController {

    private Stage stage;
    @FXML
    private TextField ddeleteId;


    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void close() {
        if (stage != null) {
            stage.close();
        }
    }

    public void delete(){
        // 删除学生信息
        String deleteId = ddeleteId.getText();
        StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
        int result = studentServiceImpl.delete(deleteId);
        String message = " ";
        if(result == -1) {
            message = "请填写完整信息";
        }else if(result == 0) {
            message = "删除失败,查无此人";
        }
        else {
            message = "删除成功";
        }

        // 显示警告框
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("信息");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

        if (result > 0) {
            // 删除成功，重置表格字段
            ddeleteId.clear();

        }
    }
}
