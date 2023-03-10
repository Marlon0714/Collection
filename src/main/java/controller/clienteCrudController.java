package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Cliente;

import javax.swing.*;

public class clienteCrudController {

    ObservableList<Cliente> oListaClientes = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAniadir;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnEliminar;

    @FXML
    private TableColumn<Cliente, String> columnApellido;

    @FXML
    private TableColumn<Cliente, String> columnCedula;

    @FXML
    private TableColumn<Cliente, String> columnCorreo;

    @FXML
    private TableColumn<Cliente, String> columnDireccion;

    @FXML
    private TableColumn<Cliente, String> columnFecha;

    @FXML
    private TableColumn<Cliente, String> columnNombre;

    @FXML
    private TableColumn<Cliente, String> columnTelefono;

    @FXML
    private AnchorPane tabCliente;

    @FXML
    private TableView<Cliente> tablaCliente;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtBuscar;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtFecha;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    private Cliente clienteSeleccion;

    @FXML
    void crearCliente(ActionEvent event) {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String telefono = txtTelefono.getText();
        String cedula = txtCedula.getText();
        String direccion = txtDireccion.getText();
        String correo = txtCorreo.getText();
        String fecha = txtFecha.getText();
        if(datosValidos(nombre,apellido,cedula,direccion,telefono,correo,fecha)){
            BancoController.banco.crearCliente(nombre,apellido,cedula,direccion,telefono,correo,fecha);
            mostrarMensaje("Notificai??n","El cliente se ha a??adido","El cliente se a??adi?? correctamente");
        }else {
            mostrarMensaje("Error","Error", "No se pudo");
        }
        BancoController.guardarResourceXML();
        BancoController.cargarResourceXML();
    }
    private void loadTable(){
        columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        columnCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        columnTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        columnDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        columnCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        columnFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));

        oListaClientes.clear();
        oListaClientes.addAll(BancoController.banco.getListaClientes());
        tablaCliente.setItems(oListaClientes);

        tablaCliente.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if(newSelection != null){
                clienteSeleccion = newSelection;

            }
        });
    }

    @FXML
    void actionEliminar(ActionEvent event) {
        try {
            Cliente cliente = tablaCliente.getSelectionModel().getSelectedItem();
            BancoController.banco.eliminarCliente(cliente.getCedula());
            JOptionPane.showMessageDialog(null, "Cliente eliminado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error en el sistema");

        }
        BancoController.guardarResourceXML();
        BancoController.cargarResourceXML();
    }


    @FXML
    void initialize() {
        assert btnActualizar != null : "fx:id=\"btnActualizar\" was not injected: check your FXML file 'ClienteCrud.fxml'.";
        assert btnAniadir != null : "fx:id=\"btnAniadir\" was not injected: check your FXML file 'ClienteCrud.fxml'.";
        assert btnBuscar != null : "fx:id=\"btnBuscar\" was not injected: check your FXML file 'ClienteCrud.fxml'.";
        assert btnEliminar != null : "fx:id=\"btnEliminar\" was not injected: check your FXML file 'ClienteCrud.fxml'.";
        assert columnApellido != null : "fx:id=\"columnApellido\" was not injected: check your FXML file 'ClienteCrud.fxml'.";
        assert columnCedula != null : "fx:id=\"columnCedula\" was not injected: check your FXML file 'ClienteCrud.fxml'.";
        assert columnCorreo != null : "fx:id=\"columnCorreo\" was not injected: check your FXML file 'ClienteCrud.fxml'.";
        assert columnDireccion != null : "fx:id=\"columnDireccion\" was not injected: check your FXML file 'ClienteCrud.fxml'.";
        assert columnFecha != null : "fx:id=\"columnFecha\" was not injected: check your FXML file 'ClienteCrud.fxml'.";
        assert columnNombre != null : "fx:id=\"columnNombre\" was not injected: check your FXML file 'ClienteCrud.fxml'.";
        assert columnTelefono != null : "fx:id=\"columnTelefono\" was not injected: check your FXML file 'ClienteCrud.fxml'.";
        assert tabCliente != null : "fx:id=\"tabCliente\" was not injected: check your FXML file 'ClienteCrud.fxml'.";
        assert tablaCliente != null : "fx:id=\"tablaCliente\" was not injected: check your FXML file 'ClienteCrud.fxml'.";
        assert txtApellido != null : "fx:id=\"txtApellido\" was not injected: check your FXML file 'ClienteCrud.fxml'.";
        assert txtBuscar != null : "fx:id=\"txtBuscar\" was not injected: check your FXML file 'ClienteCrud.fxml'.";
        assert txtCedula != null : "fx:id=\"txtCedula\" was not injected: check your FXML file 'ClienteCrud.fxml'.";
        assert txtCorreo != null : "fx:id=\"txtCorreo\" was not injected: check your FXML file 'ClienteCrud.fxml'.";
        assert txtDireccion != null : "fx:id=\"txtDireccion\" was not injected: check your FXML file 'ClienteCrud.fxml'.";
        assert txtFecha != null : "fx:id=\"txtFecha\" was not injected: check your FXML file 'ClienteCrud.fxml'.";
        assert txtNombre != null : "fx:id=\"txtNombre\" was not injected: check your FXML file 'ClienteCrud.fxml'.";
        assert txtTelefono != null : "fx:id=\"txtTelefono\" was not injected: check your FXML file 'ClienteCrud.fxml'.";

        loadTable();
    }
    private void mostrarMensaje(String titulo,String header,String contenido)  {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    private boolean datosValidos(String nombre, String apellidos, String idCliente, String direccion, String telefono,String correo,String fecha) {
        String notificacion = "";
        if (nombre == null || nombre.equals("")) {
            notificacion += "Nombre no puede estar vac??o\n";
            mostrarMensaje("Notificaci??n","Error", "Informacion inv??lida");
            return false;
        }
        if (apellidos == null || apellidos.equals("")) {
            notificacion += "Apellido no puede estar vac??o\n";
            mostrarMensaje("Notificaci??n","Error", "Informacion inv??lida");
            return false;
        }
        if (idCliente == null || idCliente.equals("")) {
            notificacion += "C??dula no puede estar vac??a\n";
            mostrarMensaje("Notificaci??n","Error", "Informacion inv??lida");
            return false;
        }
        if (direccion == null || direccion.equals("")) {
            notificacion += "La direcci??n no puede estar vac??a\n";
            mostrarMensaje("Notificaci??n","Error", "Informacion inv??lida");
            return false;
        }
        if (telefono == null || telefono.equals("")) {
            notificacion += "Tel??fono no puede estar vac??o\n";
            mostrarMensaje("Notificaci??n","Error", "Informacion inv??lida");
            return false;
        }
        if (correo == null || correo.equals("")) {
            notificacion += "Correo no puede estar vac??o\n";
            mostrarMensaje("Notificaci??n","Error", "Informacion inv??lida");
            return false;
        }
        if (fecha == null || fecha.equals("")) {
            notificacion += "La fecha no puede estar vac??a\n";
            mostrarMensaje("Notificaci??n","Error", "Informacion inv??lida");
            return false;
        }
        if(notificacion.equals("")){

            return true;
        }


        return false;
    }
    @FXML
    void actionRecargar(ActionEvent event) {
        oListaClientes.clear();
        oListaClientes.addAll(BancoController.banco.getListaClientes());
        tablaCliente.setItems(oListaClientes);
    }

}
