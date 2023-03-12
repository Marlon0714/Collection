package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class transaccionController {

    @FXML
    private Button btnConsultar;

    @FXML
    private Button btnDepositar;

    @FXML
    private Button btnRetirar;

    @FXML
    private TextField txtCodigoTransaccion;
    @FXML
    private TextField txtFechaTransaccion;

    @FXML
    private TextField txtHoraTransaccion;

    @FXML
    private TextField txtValorTransaccion;

    @FXML
    void consultarAction(ActionEvent event) {
        BancoController.banco.consultarSaldoCuenta(txtCodigoTransaccion.getText(),txtFechaTransaccion.getText(), txtHoraTransaccion.getText());
    }

    @FXML
    void depositarAction(ActionEvent event) {

    }

    @FXML
    void retirarAction(ActionEvent event) {

    }

    private void validarFields() throws Exception {
        if(txtValorTransaccion.getText().equals("") && txtCodigoTransaccion.getText().equals("")){
            throw new Exception("Algun campo esta vacio");
        }
    }

}
