package model;

public class ConsultaSaldo extends Transaccion{
    public ConsultaSaldo() {
    }

    public ConsultaSaldo(String fecha, String hora, double valor) {
        super(fecha, hora, valor);
    }
}
