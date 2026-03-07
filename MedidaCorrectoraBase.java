import java.util.List;

/**
 * Clase abstracta base para todas las medidas correctoras.
 * Implementa la interfaz MedidaCorrectora.
 */
public abstract class MedidaCorrectoaBase implements MedidaCorrectora {

    protected String descripcion;

    /** Constructor de MedidaCorrectoaBase */
    public MedidaCorrectoaBase(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public abstract double reducirEmisiones(List<FuenteEmision> fuentes);

    @Override
    public abstract double reducirCoste(List<FuenteEmision> fuentes);

    @Override
    public String toString() {
        return descripcion;
    }
}
