package model;

public class Empleado extends Persona implements Comparable{

    private String codigo;
    private double salario;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento, String codigo, double salario) {
        super(nombre, apellido, cedula, direccion, telefono, correo, fechaNacimiento);
        this.codigo = codigo;
        this.salario = salario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
