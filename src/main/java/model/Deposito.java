package model;

public class Deposito extends Transaccion{
    public Deposito() {
    }

    public Deposito(String fecha, String hora, double valor) {
        super(fecha, hora, valor);
    }
}
