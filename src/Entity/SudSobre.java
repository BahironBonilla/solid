package Entity;

public class SudSobre extends Paquete {
    @Override
    public Double calcularValor() {
        return getDhl() ? 15000.0 * 0.25 * getCantidad() : 15000.0 * getCantidad();
    }
}
