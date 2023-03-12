package model;

public class Transaccion {
    private String fecha;
    private String hora;
    private double valor;

    public Transaccion() {
    }

    public Transaccion(String fecha, String hora, double valor) {
        this.fecha = fecha;
        this.hora = hora;
        this.valor = valor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
