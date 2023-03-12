package model;

import java.util.HashMap;

public class Cliente extends Persona{
    HashMap<Integer,Cuenta> listaCuentasCliente = new HashMap<>();

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento) {
        super(nombre, apellido, cedula, direccion, telefono, correo, fechaNacimiento);
    }
}
