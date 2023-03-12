package model;

public class CuentaCorriente extends Cuenta{
    public CuentaCorriente() {
    }

    public CuentaCorriente(String numeroCuenta, double saldo, Cliente clienteAsociado) {
        super(numeroCuenta, saldo, clienteAsociado);
    }
}
