/**
 * Fuente de emisión por consumo de combustible en vehículos.
 */
public class Transporte extends FuenteEmision {

    private double litrosCombustible;

    /** @param litrosCombustible litros de combustible consumidos */
    public Transporte(String descripcion, double factorEmision, double costeUnitario, double litrosCombustible) {
        super(descripcion, factorEmision, costeUnitario);
        this.litrosCombustible = litrosCombustible;
    }

    @Override
    public double calcularEmisiones() {
        return litrosCombustible * factorEmision;
    }

    @Override
    public double calcularCoste() {
        return litrosCombustible * costeUnitario;
    }
}
