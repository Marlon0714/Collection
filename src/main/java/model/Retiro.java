package model;

public class Retiro extends Transaccion{
    public Retiro() {
    }

    public Retiro(String fecha, String hora, double valor) {
        super(fecha, hora, valor);
    }
}
