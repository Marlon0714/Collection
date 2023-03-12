package model;

public interface IBanco {

    String consultarSaldoCuenta(String numeroCuenta, String fecha, String hora);

    void crearEmpleado(String tipo, String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento, String codigo, double salario);

    void actualizarEmpleado(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento, String codigo, double salario);

    void eliminarEmpleado(String codigo);

    Empleado obtenerEmpleado(String codigo);

    void crearCliente(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento);

    void actualizarCliente(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento);

    void eliminarCliente(String cedula);

    Cliente obtenerCliente(String cedula);

    void realizarTransacion(String tipo, String fecha, String hora, double valor);

    void retirarDineroCuenta(String numeroCuenta, String fecha, String hora, double valor);

    void depositarDineroCuenta(String numeroCuenta, String fecha, String hora, double valor);

    void crearCuenta(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento);

    void actualizarCuenta(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento);

    void eliminarCuenta(String cedula);
}
