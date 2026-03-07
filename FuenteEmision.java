/**
 * Clase abstracta base para todas las fuentes de emisión de CO2.
 */
public abstract class FuenteEmision {

    protected String descripcion;
    protected double factorEmision;  // kg CO2 por unidad consumida
    protected double costeUnitario;  // euros por unidad consumida


