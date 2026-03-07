/**
 * Fuente de emisión por consumo eléctrico.
 */
public class Electricidad extends FuenteEmision {

    private double consumoKWh;

    /** @param consumoKWh kWh consumidos */
    public Electricidad(String descripcion, double factorEmision, double costeUnitario, double consumoKWh) {
        super(descripcion, factorEmision, costeUnitario);
        this.consumoKWh = consumoKWh;
    }

    @Override
    public double calcularEmisiones() {
        return consumoKWh * factorEmision;
    }

    @Override
    public double calcularCoste() {
        return consumoKWh * costeUnitario;
    }
}
