package model;

import java.io.Serializable;

public class CuentaAhorro extends Cuenta implements Serializable {
    public CuentaAhorro() {
    }
    public CuentaAhorro(String numeroCuenta, double saldo, Cliente clienteAsociado) {
        super(numeroCuenta, saldo, clienteAsociado);
    }
}
