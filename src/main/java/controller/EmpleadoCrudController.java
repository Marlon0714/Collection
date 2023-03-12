
package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import model.Empleado;

import java.awt.event.ActionEvent;

public class EmpleadoCrudController {

    ObservableList<Empleado> oListaEmpleados = FXCollections.observableArrayList();
    @FXML // fx:id="btnActualizarEmpleado"
    private Button btnActualizarEmpleado; // Value injected by FXMLLoader

    @FXML // fx:id="btnAniadirEmpleado"
    private Button btnAniadirEmpleado; // Value injected by FXMLLoader

    @FXML // fx:id="btnBuscarEmpleado"
    private Button btnBuscarEmpleado; // Value injected by FXMLLoader

    @FXML // fx:id="btnEliminarEmpleado"
    private Button btnEliminarEmpleado; // Value injected by FXMLLoader

    @FXML // fx:id="columnApellidoEmpleado"
    private TableColumn<Empleado, String> columnApellidoEmpleado; // Value injected by FXMLLoader

    @FXML // fx:id="columnCedulaEmpleado"
    private TableColumn<Empleado, String> columnCedulaEmpleado; // Value injected by FXMLLoader

    @FXML // fx:id="columnCodigo"
    private TableColumn<Empleado, String> columnCodigo; // Value injected by FXMLLoader

    @FXML // fx:id="columnNombreEmpleado"
    private TableColumn<Empleado, String> columnNombreEmpleado; // Value injected by FXMLLoader

    @FXML // fx:id="columnSalario"
    private TableColumn<Empleado, String> columnSalario; // Value injected by FXMLLoader

    @FXML // fx:id="columnTelefonoEmpleado"
    private TableColumn<Empleado, String> columnTelefonoEmpleado; // Value injected by FXMLLoader

    @FXML
    private TableView<Empleado> tableViewEmpleados;

    @FXML // fx:id="comboEmpleado"
    private ComboBox<Empleado> comboEmpleado; // Value injected by FXMLLoader

    @FXML // fx:id="txtApellidoEmpleado"
    private TextField txtApellidoEmpleado; // Value injected by FXMLLoader

    @FXML // fx:id="txtBuscarEmpleado"
    private TextField txtBuscarEmpleado; // Value injected by FXMLLoader

    @FXML // fx:id="txtCedulaEmpleado"
    private TextField txtCedulaEmpleado; // Value injected by FXMLLoader

    @FXML // fx:id="txtCodigo"
    private TextField txtCodigo; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorreoEmpleado"
    private TextField txtCorreoEmpleado; // Value injected by FXMLLoader

    @FXML // fx:id="txtDireccionEmpleado"
    private TextField txtDireccionEmpleado; // Value injected by FXMLLoader

    @FXML // fx:id="txtFechaEmpleado"
    private TextField txtFechaEmpleado; // Value injected by FXMLLoader

    @FXML // fx:id="txtNombreEmpleado"
    private TextField txtNombreEmpleado; // Value injected by FXMLLoader

    @FXML // fx:id="txtSalario"
    private TextField txtSalario; // Value injected by FXMLLoader

    @FXML // fx:id="txtTelefonoEmpleado"
    private TextField txtTelefonoEmpleado; // Value injected by FXMLLoader
    @FXML
    private MenuButton mBtnTipoEmpleado;

    @FXML
    private MenuItem miAsesor;

    @FXML
    private MenuItem miCajero;

    @FXML
    private MenuItem miGerente;

    @FXML
    void actionCrear(ActionEvent event){
        String nombre = txtNombreEmpleado.getText();
        String apellido = txtApellidoEmpleado.getText();
        String telefono =txtTelefonoEmpleado.getText();
        String cedula = txtCedulaEmpleado.getText();
        String direccion = txtDireccionEmpleado.getText();
        String codigo = txtCodigo.getText();
        double salario =Double.parseDouble(txtSalario.getText());
        String email = txtCorreoEmpleado.getText();
        String fechaNacimiento =txtFechaEmpleado.getText();
        String tipo = mBtnTipoEmpleado.getText();

        if(datosValidos(nombre,apellido,cedula,direccion,telefono,email,fechaNacimiento,codigo,salario)){
            BancoController.banco.crearEmpleado(tipo,nombre,apellido,cedula,direccion,telefono,email,fechaNacimiento,codigo,salario);
            mostrarMensaje("Notificaión","El Empleado se ha añadido","El Empleado se añadió correctamente");
        }else {
            mostrarMensaje("Error","Error", "No se pudo");
        }

    }

    private void mostrarMensaje(String titulo,String header,String contenido)  {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
    private boolean datosValidos(String nombre, String apellidos, String idCliente, String direccion, String telefono,String correo,String fecha,String codigo,double salario) {
        String notificacion = "";
        if (nombre == null || nombre.equals("")) {
            notificacion += "Nombre no puede estar vacío\n";
            mostrarMensaje("Notificación","Error", "Informacion inválida");
            return false;
        }
        if (apellidos == null || apellidos.equals("")) {
            notificacion += "Apellido no puede estar vacío\n";
            mostrarMensaje("Notificación","Error", "Informacion inválida");
            return false;
        }
        if (idCliente == null || idCliente.equals("")) {
            notificacion += "Cédula no puede estar vacía\n";
            mostrarMensaje("Notificación","Error", "Informacion inválida");
            return false;
        }
        if (direccion == null || direccion.equals("")) {
            notificacion += "La dirección no puede estar vacía\n";
            mostrarMensaje("Notificación","Error", "Informacion inválida");
            return false;
        }
        if (telefono == null || telefono.equals("")) {
            notificacion += "Teléfono no puede estar vacío\n";
            mostrarMensaje("Notificación","Error", "Informacion inválida");
            return false;
        }
        if (correo == null || correo.equals("")) {
            notificacion += "Correo no puede estar vacío\n";
            mostrarMensaje("Notificación","Error", "Informacion inválida");
            return false;
        }
        if (fecha == null || fecha.equals("")) {
            notificacion += "La fecha no puede estar vacía\n";
            mostrarMensaje("Notificación","Error", "Informacion inválida");
            return false;
        }
        if (codigo == null || codigo.equals("")) {
            notificacion += "El codigo no puede estar vacío\n";
            mostrarMensaje("Notificación","Error", "Informacion inválida");
            return false;
        }
        if (salario == 0.0) {
            notificacion += "El salario no puede ser 0\n";
            mostrarMensaje("Notificación","Error", "Informacion inválida");
            return false;
        }
        if(notificacion.equals("")){

            return true;
        }


        return false;
    }



    @FXML
    void initialize() {
        assert btnActualizarEmpleado != null : "fx:id=\"btnActualizarEmpleado\" was not injected: check your FXML file 'EmpleadoCrud.fxml'.";
        assert btnAniadirEmpleado != null : "fx:id=\"btnAniadirEmpleado\" was not injected: check your FXML file 'EmpleadoCrud.fxml'.";
        assert btnBuscarEmpleado != null : "fx:id=\"btnBuscarEmpleado\" was not injected: check your FXML file 'EmpleadoCrud.fxml'.";
        assert btnEliminarEmpleado != null : "fx:id=\"btnEliminarEmpleado\" was not injected: check your FXML file 'EmpleadoCrud.fxml'.";
        assert columnApellidoEmpleado != null : "fx:id=\"columnApellidoEmpleado\" was not injected: check your FXML file 'EmpleadoCrud.fxml'.";
        assert columnCedulaEmpleado != null : "fx:id=\"columnCedulaEmpleado\" was not injected: check your FXML file 'EmpleadoCrud.fxml'.";
        assert columnCodigo != null : "fx:id=\"columnCodigo\" was not injected: check your FXML file 'EmpleadoCrud.fxml'.";
        assert columnNombreEmpleado != null : "fx:id=\"columnNombreEmpleado\" was not injected: check your FXML file 'EmpleadoCrud.fxml'.";
        assert columnSalario != null : "fx:id=\"columnSalario\" was not injected: check your FXML file 'EmpleadoCrud.fxml'.";
        assert columnTelefonoEmpleado != null : "fx:id=\"columnTelefonoEmpleado\" was not injected: check your FXML file 'EmpleadoCrud.fxml'.";
        assert comboEmpleado != null : "fx:id=\"comboEmpleado\" was not injected: check your FXML file 'EmpleadoCrud.fxml'.";
        assert txtApellidoEmpleado != null : "fx:id=\"txtApellidoEmpleado\" was not injected: check your FXML file 'EmpleadoCrud.fxml'.";
        assert txtBuscarEmpleado != null : "fx:id=\"txtBuscarEmpleado\" was not injected: check your FXML file 'EmpleadoCrud.fxml'.";
        assert txtCedulaEmpleado != null : "fx:id=\"txtCedulaEmpleado\" was not injected: check your FXML file 'EmpleadoCrud.fxml'.";
        assert txtCodigo != null : "fx:id=\"txtCodigo\" was not injected: check your FXML file 'EmpleadoCrud.fxml'.";
        assert txtCorreoEmpleado != null : "fx:id=\"txtCorreoEmpleado\" was not injected: check your FXML file 'EmpleadoCrud.fxml'.";
        assert txtDireccionEmpleado != null : "fx:id=\"txtDireccionEmpleado\" was not injected: check your FXML file 'EmpleadoCrud.fxml'.";
        assert txtFechaEmpleado != null : "fx:id=\"txtFechaEmpleado\" was not injected: check your FXML file 'EmpleadoCrud.fxml'.";
        assert txtNombreEmpleado != null : "fx:id=\"txtNombreEmpleado\" was not injected: check your FXML file 'EmpleadoCrud.fxml'.";
        assert txtSalario != null : "fx:id=\"txtSalario\" was not injected: check your FXML file 'EmpleadoCrud.fxml'.";
        assert txtTelefonoEmpleado != null : "fx:id=\"txtTelefonoEmpleado\" was not injected: check your FXML file 'EmpleadoCrud.fxml'.";


        this.tableViewEmpleados.setItems(oListaEmpleados);


        loadTable();

    }
    private void loadTable(){
        columnNombreEmpleado.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnApellidoEmpleado.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        columnCedulaEmpleado.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        columnCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        columnSalario.setCellValueFactory(new PropertyValueFactory<>("salario"));
        columnTelefonoEmpleado.setCellValueFactory(new PropertyValueFactory<>("telefono"));

        oListaEmpleados.clear();
        oListaEmpleados.addAll(BancoController.banco.getListaEmpleados());
        tableViewEmpleados.setItems(oListaEmpleados);
    }


    @FXML
    public void actionCrear(javafx.event.ActionEvent event) {
        String nombre = txtNombreEmpleado.getText();
        String apellido = txtApellidoEmpleado.getText();
        String telefono =txtTelefonoEmpleado.getText();
        String cedula = txtCedulaEmpleado.getText();
        String direccion = txtDireccionEmpleado.getText();
        String codigo = txtCodigo.getText();
        double salario =Double.parseDouble(txtSalario.getText());
        String email = txtCorreoEmpleado.getText();
        String fechaNacimiento =txtFechaEmpleado.getText();
        String tipo = mBtnTipoEmpleado.getText();



        BancoController.banco.crearEmpleado(tipo,nombre,apellido,cedula,direccion,telefono,email,fechaNacimiento,codigo,salario);
    }


}
