package Entity;

public class SudPaquete extends Paquete {
    @Override
    public Double calcularValor() {
        return getDhl() ? 5000.0 * getPeso() * 0.25 * getCantidad() : 5000.0 * getPeso() * getCantidad();
    }
}
