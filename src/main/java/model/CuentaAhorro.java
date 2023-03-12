package model;

public class CuentaAhorro extends Cuenta {
    public CuentaAhorro() {
    }
    public CuentaAhorro(String numeroCuenta, double saldo, Cliente clienteAsociado) {
        super(numeroCuenta, saldo, clienteAsociado);
    }
}
