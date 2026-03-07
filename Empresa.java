import java.util.ArrayList;
import java.util.List;

/**
 * Empresa con fuentes de emisión y medidas correctoras.
 * Permite calcular totales y simular el ahorro al aplicar las medidas.
 */
public class Empresa {

    private String nombre;
    private List<FuenteEmision> fuentes = new ArrayList<>();
    private List<MedidaCorrectora> medidas = new ArrayList<>();

    /** Constructor de Empresa */
    public Empresa(String nombre) {
        this.nombre = nombre;
    }

    /** Agrega una fuente de emisión */
    public void agregarFuente(FuenteEmision fuente) {
        fuentes.add(fuente);
    }

    /** Agrega una medida correctora */
    public void agregarMedida(MedidaCorrectora medida) {
        medidas.add(medida);
    }

    /** @return total de emisiones de CO2 en kg */
    public double calcularEmisionesTotales() {
        double total = 0;
        for (FuenteEmision f : fuentes) total += f.calcularEmisiones();
        return total;
    }

    /** @return coste total en euros */
    public double calcularCosteTotal() {
        double total = 0;
        for (FuenteEmision f : fuentes) total += f.calcularCoste();
        return total;
    }

    /** @return reducción total de emisiones si se aplican todas las medidas */
    public double simularReduccionEmisiones() {
        double total = 0;
        for (MedidaCorrectora m : medidas) total += m.reducirEmisiones(fuentes);
        return total;
    }

    /** @return reducción total de costes si se aplican todas las medidas */
    public double simularReduccionCoste() {
        double total = 0;
        for (MedidaCorrectora m : medidas) total += m.reducirCoste(fuentes);
        return total;
    }

    public List<FuenteEmision> getFuentes() { return fuentes; }
    public List<MedidaCorrectora> getMedidas() { return medidas; }
    public String getNombre() { return nombre; }
}
