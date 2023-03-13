package model;

import java.io.Serializable;

public class CuentaCorriente extends Cuenta implements Serializable {
    public CuentaCorriente() {
    }

    public CuentaCorriente(String numeroCuenta, double saldo, Cliente clienteAsociado) {
        super(numeroCuenta, saldo, clienteAsociado);
    }
}
