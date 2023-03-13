package model;

import java.io.Serializable;

public class AsesorVentas extends Empleado implements Serializable {
    public AsesorVentas() {
    }

    public AsesorVentas(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento, String codigo, double salario) {
        super(nombre, apellido, cedula, direccion, telefono, correo, fechaNacimiento, codigo, salario);
    }
}
