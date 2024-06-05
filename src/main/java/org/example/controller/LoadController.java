package org.example.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.entity.Student;
import org.example.service.impl.StudentServiceImpl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class LoadController {
    @FXML
    private TableView<Student> tableView;

    @FXML
    private TableColumn<Student, String> name;
    @FXML
    private TableColumn<Student, String> stuId;
    @FXML
    private TableColumn<Student, String> cla;
    @FXML
    private TableColumn<Student, String> sex;
    @FXML
    private TableColumn<Student, Date> birth;
    @FXML
    private TableColumn<Student, String> profession;

    @FXML
    private Scene myScene;

    public void initialize() {
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        stuId.setCellValueFactory(new PropertyValueFactory<>("stuId"));
        cla.setCellValueFactory(new PropertyValueFactory<>("cla"));
        sex.setCellValueFactory(new PropertyValueFactory<>("sex"));
        birth.setCellValueFactory(new PropertyValueFactory<>("birth"));
        profession.setCellValueFactory(new PropertyValueFactory<>("profession"));


        StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
        List<Student> students = studentServiceImpl.query();
        load(students);
    }


    public void load(List<Student> students){
        tableView.getItems().clear();
        tableView.getItems().setAll(students);
    }

    public void loadAdd(){
        try {
            // 加载add.fxml文件
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/page/add.fxml"));
            Parent root = loader.load();

            // 创建一个新的Stage
            Stage addStage = new Stage();
            addStage.initModality(Modality.APPLICATION_MODAL); // 阻止用户与主窗口交互，直到此窗口关闭
            addStage.setTitle("添加学生信息"); // 设置窗口标题
            addStage.setScene(new Scene(root)); // 设置场景

            // 获取控制器实例
            AddController controller = loader.getController();
            // 设置 Stage 对象
            controller.setStage(addStage);

            // 显示窗口并等待用户关闭
            addStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadUpdate(){
        try {
            // 加载add.fxml文件
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/page/update.fxml"));
            Parent root = loader.load();

            // 创建一个新的Stage
            Stage addStage = new Stage();
            addStage.initModality(Modality.APPLICATION_MODAL); // 阻止用户与主窗口交互，直到此窗口关闭
            addStage.setTitle("修改学生信息"); // 设置窗口标题
            addStage.setScene(new Scene(root)); // 设置场景
            // 获取控制器实例
            UpdateController controller = loader.getController();
            // 设置 Stage 对象
            controller.setStage(addStage);


            // 显示窗口并等待用户关闭
            addStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadDelete() {
        try {
            // 加载 delete.fxml 文件
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/page/delete.fxml"));
            Parent root = loader.load();

            // 创建一个新的 Stage
            Stage addStage = new Stage();
            addStage.initModality(Modality.APPLICATION_MODAL); // 阻止用户与主窗口交互，直到此窗口关闭
            addStage.setTitle("删除学生信息"); // 设置窗口标题
            addStage.setScene(new Scene(root)); // 设置场景

            // 获取控制器实例
            DeleteController controller = loader.getController();
            // 设置 Stage 对象
            controller.setStage(addStage);

            // 显示窗口并等待用户关闭
            addStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadQuery(){
        try {
            // 加载add.fxml文件
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/page/query.fxml"));
            Parent root = loader.load();

            // 创建一个新的Stage
            Stage addStage = new Stage();
            addStage.initModality(Modality.APPLICATION_MODAL); // 阻止用户与主窗口交互，直到此窗口关闭
            addStage.setTitle("查询学生信息"); // 设置窗口标题
            addStage.setScene(new Scene(root)); // 设置场景

            // 获取控制器实例
            QueryController controller = loader.getController();
            // 设置 Stage 对象
            controller.setStage(addStage);
            controller.setLoadController(this);

            // 显示窗口并等待用户关闭
            addStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
