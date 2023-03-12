package model;

public interface ICuenta {
    void retirarDinero(double valor);

    void depositarDinero(double valor);

    double consultarSaldo();
}
