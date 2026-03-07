import java.util.List;

/**
 * Medida correctora: instalación de paneles solares para autoconsumo.
 * Reduce las emisiones y costes de las fuentes de tipo Electricidad.
 */
public class Autoconsumo extends MedidaCorrectoaBase {

    private double porcentajeReduccion;  // % de consumo eléctrico cubierto por solar

    /** @param porcentajeReduccion porcentaje de electricidad que cubre la instalación solar */
    public Autoconsumo(String descripcion, double porcentajeReduccion) {
        super(descripcion);
        this.porcentajeReduccion = porcentajeReduccion;
    }
    @Override
    public double reducirEmisiones(List<FuenteEmision> fuentes) {
        double reduccion = 0;
        for (FuenteEmision f : fuentes) {
            if (f instanceof Electricidad) {
                reduccion += f.calcularEmisiones() * porcentajeReduccion / 100;
            }
        }
        return reduccion;
    }

    @Override
    public double reducirCoste(List<FuenteEmision> fuentes) {
        double reduccion = 0;
        for (FuenteEmision f : fuentes) {
            if (f instanceof Electricidad) {
                reduccion += f.calcularCoste() * porcentajeReduccion / 100;
            }
        }
        return reduccion;
    }
}
