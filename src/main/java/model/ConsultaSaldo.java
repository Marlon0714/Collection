package model;

import java.io.Serializable;

public class ConsultaSaldo extends Transaccion implements Serializable {
    public ConsultaSaldo() {
    }

    public ConsultaSaldo(String fecha, String hora, double valor) {
        super(fecha, hora, valor);
    }
}
