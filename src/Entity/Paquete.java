package Entity;

public abstract class Paquete implements IPaquete {
    private String idPaquete;
    private int cantidad;
    private double peso;
    private int tipoPaquete;
    private Boolean dhl;

    public Paquete() {
    }

    // Getters y setters
    public int getTipoPaquete() {
        return tipoPaquete;
    }

    public void setTipoPaquete(int tipoPaquete) {
        this.tipoPaquete = tipoPaquete;
    }

    public String getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(String idPaquete) {
        this.idPaquete = idPaquete;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Boolean getDhl() {
        return dhl;
    }

    public void setDhl(Boolean dhl) {
        this.dhl = dhl;
    }

    public abstract Double calcularValor();

    @Override
    public String toString() {
        return idPaquete + "," + cantidad + "," + peso + "," + dhl + "," + tipoPaquete;
    }
}
