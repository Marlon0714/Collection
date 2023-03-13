package model;

import java.io.Serializable;

public class Deposito extends Transaccion implements Serializable {
    public Deposito() {
    }

    public Deposito(String fecha, String hora, double valor) {
        super(fecha, hora, valor);
    }
}
