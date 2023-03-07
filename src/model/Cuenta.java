package model;

import java.util.HashMap;

public class Cuenta implements ICuenta {
    private String numeroCuenta;
    private double saldo;
    HashMap<Integer,Transaccion> listaTransacciones= new HashMap<>();
    void crearTransaccion(){

    };

    @Override
    public void retirarDinero() {

    }

    @Override
    public void depositarDinero() {

    }

    @Override
    public void consultarSaldo() {

    }
}
