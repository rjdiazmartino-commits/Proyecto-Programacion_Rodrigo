import java.util.List;

/**
 * Medida correctora: sustitución de parte de la flota por vehículos eléctricos.
 * Reduce las emisiones y costes de las fuentes de tipo Transporte.
 */
public class MovilidadElectrica extends MedidaCorrectoaBase {

    private double porcentajeFlota;  // % de la flota sustituida por eléctricos

    /** @param porcentajeFlota porcentaje de vehículos de combustión sustituidos */
    public MovilidadElectrica(String descripcion, double porcentajeFlota) {
        super(descripcion);
        this.porcentajeFlota = porcentajeFlota;
    }

    @Override
    public double reducirEmisiones(List<FuenteEmision> fuentes) {
        double reduccion = 0;
        for (FuenteEmision f : fuentes) {
            if (f instanceof Transporte) {
                reduccion += f.calcularEmisiones() * porcentajeFlota / 100;
            }
        }
        return reduccion;
    }

    @Override
    public double reducirCoste(List<FuenteEmision> fuentes) {
        double reduccion = 0;
        for (FuenteEmision f : fuentes) {
            if (f instanceof Transporte) {
                reduccion += f.calcularCoste() * porcentajeFlota / 100;
            }
        }
        return reduccion;
    }
}
