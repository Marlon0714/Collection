package model;

import java.util.*;

public class Banco implements IBanco {

    HashSet<Cliente> listaClientes = new HashSet<>();

    TreeSet<Empleado> listaEmpleados = new TreeSet<>();

    HashMap<String,Cuenta> listaCuentas = new HashMap<>();

    HashMap<String,Transaccion> listaTransacciones = new HashMap<>();

    @Override
    public String consultarSaldoCuenta(String numeroCuenta,String fecha, String hora) {
        Iterator<Map.Entry<String,Cuenta>> iterator = listaCuentas.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Cuenta> entry = iterator.next();
            String key = entry.getKey();
            Cuenta cuenta = entry.getValue();
            if(key.equals(numeroCuenta)){
                realizarTransacion("ConsultarSaldo",fecha,hora,cuenta.consultarSaldo());
                return "El saldo de la cuenta " + numeroCuenta + " es " + cuenta.consultarSaldo();
            }
        }
        return "No se encontró la cuenta " + numeroCuenta;
    }

    @Override
    public void crearEmpleado(String tipo, String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento, String codigo, double salario) {
        Persona nuevoEmpleado  = new Empleado();
        if(tipo.equals("AsesorVentas")){
            nuevoEmpleado = new AsesorVentas(nombre, apellido, cedula, direccion, telefono, correo, fechaNacimiento, codigo, salario);
        }else if(tipo.equals("Cajero")){
            nuevoEmpleado = new Cajero(nombre, apellido, cedula, direccion, telefono, correo, fechaNacimiento, codigo, salario);
        }else if(tipo.equals("Gerente")){
            nuevoEmpleado = new Gerente(nombre, apellido, cedula, direccion, telefono, correo, fechaNacimiento, codigo, salario);
        }
        listaEmpleados.add((Empleado) nuevoEmpleado);
    }

    @Override
    public void actualizarEmpleado(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento, String codigo, double salario) {
        Iterator<Empleado> iterator = listaEmpleados.iterator();
        while (iterator.hasNext()) {
            Empleado empleado = iterator.next();
            if (empleado.getCodigo().equals(codigo)) {
                empleado.setSalario(salario);
                empleado.setNombre(nombre);
                empleado.setApellido(apellido);
                empleado.setCedula(cedula);
                empleado.setTelefono(telefono);
                empleado.setCorreo(correo);
                empleado.setFechaNacimiento(fechaNacimiento);
                break;
            }
        }
    }

    @Override
    public void eliminarEmpleado(String codigo) {
        Iterator<Empleado> iterator = listaEmpleados.iterator();
        while (iterator.hasNext()) {
            Empleado empleado = iterator.next();
            if (empleado.getCodigo().equals(codigo)) {
                listaEmpleados.remove(empleado);
                break;
            }
        }
    }

    @Override
    public Empleado obtenerEmpleado(String codigo) {
        Iterator<Empleado> iterator = listaEmpleados.iterator();
        while (iterator.hasNext()) {
            Empleado empleado = iterator.next();
            if (empleado.getCodigo().equals(codigo)) {
                return empleado;
            }
        }
        return null;
    }

    @Override
    public void crearCliente(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento) {
        Persona nuevoCliente  = new Cliente(nombre, apellido, cedula, direccion, telefono, correo, fechaNacimiento);
        listaClientes.add((Cliente) nuevoCliente);
    }

    @Override
    public void actualizarCliente(String nombre, String apellido, String cedula, String direccion, String telefono, String correo, String fechaNacimiento) {
        Iterator<Cliente> iterator = listaClientes.iterator();
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (cliente.getCedula().equals(cedula)) {
                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setCedula(cedula);
                cliente.setTelefono(telefono);
                cliente.setCorreo(correo);
                cliente.setFechaNacimiento(fechaNacimiento);
                break;
            }
        }
    }

    @Override
    public void eliminarCliente(String cedula) {
        Iterator<Cliente> iterator = listaClientes.iterator();
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if(cliente.getCedula().equals(cedula)){
                listaClientes.remove(cliente);
                break;
            }

        }
    }

    @Override
    public Cliente obtenerCliente(String cedula) {
        Iterator<Cliente> iterator = listaClientes.iterator();
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if(cliente.getCedula().equals(cedula)){
                return cliente;
            }
        }
        return null;
    }

    @Override
    public void realizarTransacion(String tipo, String fecha, String hora, double valor) {
        Transaccion transaccion = new Transaccion();
        if(tipo.equals("ConsultarSaldo")){
            transaccion = new ConsultaSaldo(fecha, hora, valor);
        } else if (tipo.equals("Depositar")) {
            transaccion = new Deposito(fecha, hora, valor);
        }else if (tipo.equals("Retirar")) {
            transaccion = new Retiro(fecha, hora,valor);
        }
        listaTransacciones.put(fecha+hora, transaccion);
    }

    @Override
    public void retirarDineroCuenta(String numeroCuenta,String fecha, String hora, double valor) {
        Iterator<Map.Entry<String,Cuenta>> iterator = listaCuentas.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Cuenta> entry = iterator.next();
            String key = entry.getKey();
            Cuenta cuenta = entry.getValue();
            if(key.equals(numeroCuenta)){
                cuenta.retirarDinero(valor);
                realizarTransacion("Retiro",fecha,hora,valor);
            }
        }
    }

    @Override
    public void depositarDineroCuenta(String numeroCuenta,String fecha, String hora, double valor) {
        Iterator<Map.Entry<String,Cuenta>> iterator = listaCuentas.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Cuenta> entry = iterator.next();
            String key = entry.getKey();
            Cuenta cuenta = entry.getValue();
            if(key.equals(numeroCuenta)){
                cuenta.depositarDinero(valor);
                realizarTransacion("Depositar",fecha,hora,valor);
            }
        }
    }
}
