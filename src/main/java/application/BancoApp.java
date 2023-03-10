package application;

import controller.BancoController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Banco;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class BancoApp extends Application {
    public void start(Stage stage) throws IOException {
        try {
            BancoController.getInstance();
            BancoController.iniciarDatos();
            BancoController.guardarResourceXML();
            BancoController.cargarResourceXML();
        }catch (Exception e){}
        URL url = new File("src/main/java/view/loginview.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root, 283, 321);
        stage.setTitle("LogIn");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
