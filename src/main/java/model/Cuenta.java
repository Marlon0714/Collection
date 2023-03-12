package model;

import javax.swing.*;
import java.util.HashMap;

public class Cuenta implements ICuenta {
    private String numeroCuenta;
    private double saldo;
    public Cliente clienteAsociado;
    HashMap<String,Transaccion> listaTransacciones= new HashMap<>();

    public Cuenta() {
    }

    public Cuenta(String numeroCuenta, double saldo, Cliente clienteAsociado) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.clienteAsociado = clienteAsociado;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getClienteAsociado() {
        return clienteAsociado;
    }

    public void setClienteAsociado(Cliente clienteAsociado) {
        this.clienteAsociado = clienteAsociado;
    }

    public HashMap<String, Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public void setListaTransacciones(HashMap<String, Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }

    void crearTransaccion(String tipo, String fecha, String hora, double valor){
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
    public void retirarDinero(double valor) {
        if (valor < 0 && saldo >= valor) {
            JOptionPane.showMessageDialog(null, "No tienes suficiente dinero");
            return;
        }
        saldo -= valor;
    }

    @Override
    public void depositarDinero(double valor) {
        if (valor < 0) {
            JOptionPane.showMessageDialog(null, "Dinero depositado con exito");
            return;
        }
        saldo += valor;
    }

    @Override
    public double consultarSaldo() {
        return saldo;
    }
}
