package model;

import java.io.Serializable;

public class Retiro extends Transaccion implements Serializable {
    public Retiro() {
    }

    public Retiro(String fecha, String hora, double valor) {
        super(fecha, hora, valor);
    }
}
