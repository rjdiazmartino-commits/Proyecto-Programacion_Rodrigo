import java.util.List;

/**
 * Medida correctora: instalación de bomba de calor en lugar de climatización convencional.
 * Reduce emisiones y costes de las fuentes de tipo Climatizacion.
 * La reducción se calcula con el COP (coeficiente de rendimiento): ahorro = 1 - 1/COP
 */
public class ClimatizacionBombaCalor extends MedidaCorrectoaBase {

    private double eficienciaNueva;  // COP de la bomba de calor (ej: 3.0 = 3x más eficiente)

    /** @param eficienciaNueva COP de la bomba de calor instalada */
    public ClimatizacionBombaCalor(String descripcion, double eficienciaNueva) {
        super(descripcion);
        this.eficienciaNueva = eficienciaNueva;
    }

    @Override
    public double reducirEmisiones(List<FuenteEmision> fuentes) {
        double reduccion = 0;
        for (FuenteEmision f : fuentes) {
            if (f instanceof Climatizacion) {
                reduccion += f.calcularEmisiones() * (1 - 1 / eficienciaNueva);
            }
        }
        return reduccion;
    }

    @Override
    public double reducirCoste(List<FuenteEmision> fuentes) {
        double reduccion = 0;
        for (FuenteEmision f : fuentes) {
            if (f instanceof Climatizacion) {
                reduccion += f.calcularCoste() * (1 - 1 / eficienciaNueva);
            }
        }
        return reduccion;
    }
}
