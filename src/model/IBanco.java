package model;

public interface IBanco {
    void consultarSaldoCuenta();
    void crearEmpleado();
    void actualizarEmpleado();
    void eliminarEmpleado();
    void obtenerEmpleado();
    void crearCliente();
    void actualizarCliente();
    void eliminarCliente();
    void obtenerCliente();
    void realizarTransacion();
    void retirarDineroCuenta();
    void depositarDineroCuenta();
}
