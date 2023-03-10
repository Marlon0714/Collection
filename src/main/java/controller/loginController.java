package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Cliente;
import model.Empleado;
import model.Gerente;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class loginController {

    @FXML
    private Button crearUsuarioBtn;

    @FXML
    private Button loginBtn;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Label titleLabel;

    @FXML
    private TextField usernameTextField;

    @FXML
    void actionLogin(ActionEvent event){
        try {
            validarFields();
            BancoController.iniciarSesion(usernameTextField.getText(), passwordTextField.getText());
            if(BancoController.getUsuarioLogeado() instanceof Gerente){
                URL url = new File("src/main/java/view/AdminView.fxml").toURI().toURL();
                Parent root1 = FXMLLoader.load(url);
                Scene scene1 = new Scene(root1, 804, 570);
                Stage stage1 = new Stage();
                stage1.setTitle(usernameTextField.getText());
                stage1.setScene(scene1);
                stage1.show();
            }else if(BancoController.getUsuarioLogeado() instanceof Empleado){
                URL url = new File("src/main/java/view/crearCliente.fxml").toURI().toURL();
                Parent root1 = FXMLLoader.load(url);
                Scene scene1 = new Scene(root1, 804, 570);
                Stage stage1 = new Stage();
                stage1.setTitle(usernameTextField.getText());
                stage1.setScene(scene1);
                stage1.show();
            }else if(BancoController.getUsuarioLogeado() instanceof Cliente){
                URL url = new File("src/main/java/view/Transaccion.fxml").toURI().toURL();
                Parent root1 = FXMLLoader.load(url);
                Scene scene1 = new Scene(root1, 804, 570);
                Stage stage1 = new Stage();
                stage1.setTitle(usernameTextField.getText());
                stage1.setScene(scene1);
                stage1.show();
            }else {
                JOptionPane.showMessageDialog(null, "Usuario o contrase??a incorrectos");
            }
            Stage stage = (Stage) loginBtn.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void actionCrearUser(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/view/crearCliente.fxml").toURI().toURL();
        Parent root1 = FXMLLoader.load(url);
        Scene scene1 = new Scene(root1, 600, 400);
        Stage stage1 = new Stage();
        stage1.setTitle("Crear usuario");
        stage1.setScene(scene1);
        stage1.show();
    }
    private void validarFields() throws Exception {
        if(usernameTextField.getText().equals("")){
            throw new Exception("Algun campo esta vacio");
        }
    }
}
