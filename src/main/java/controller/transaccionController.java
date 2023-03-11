package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;

public class transaccionController {

    @FXML
    private Button btnTransaccion;

    @FXML
    private TabPane tabCuenta;

    @FXML
    private Tab tabTransaccion;

    @FXML
    private TextField txtCuentaDestino;

    @FXML
    private TextField txtCuentaOrigen;

    @FXML
    private TextField txtHoraTransaccion;

    @FXML
    private TextField txtValorTransaccion;

    @FXML
    private TextField txtfechaTransaccion;

    @FXML
    void actionTransaccion(ActionEvent event){

    }
}