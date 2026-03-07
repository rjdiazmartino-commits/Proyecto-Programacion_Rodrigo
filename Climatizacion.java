/**
 * Fuente de emisión por uso de sistemas de climatización.
 */
public class Climatizacion extends FuenteEmision {

    private double horasUso;

    /** @param horasUso horas de funcionamiento del sistema */
    public Climatizacion(String descripcion, double factorEmision, double costeUnitario, double horasUso) {
        super(descripcion, factorEmision, costeUnitario);
        this.horasUso = horasUso;
    }

    @Override
    public double calcularEmisiones() {
        return horasUso * factorEmision;
    }

    @Override
    public double calcularCoste() {
        return horasUso * costeUnitario;
    }
}
