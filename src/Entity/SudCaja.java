package Entity;

public class SudCaja extends Paquete {
    @Override
    public Double calcularValor() {
        return getDhl() ? ((5000.0 * getPeso()) + 25000) * 0.25 * getCantidad()
                : (5000.0 * getPeso()) + 25000 * getCantidad();
    }
}
