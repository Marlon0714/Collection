package model;

import java.io.Serializable;

public class Gerente extends Empleado implements Serializable {
    public Gerente() {
    }

    public Gerente(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento, String codigo, double salario) {
        super(nombre, apellido, cedula, direccion, telefono, correo, fechaNacimiento, codigo, salario);
    }
}
