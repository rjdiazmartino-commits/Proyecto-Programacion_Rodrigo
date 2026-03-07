import java.util.List;

/**
 * Interfaz para las medidas correctoras de emisiones y costes.
 */
public interface MedidaCorrectora {

    /** @return kg de CO2 que se reducen aplicando esta medida */
    double reducirEmisiones(List<FuenteEmision> fuentes);

    /** @return euros que se ahorran aplicando esta medida */
    double reducirCoste(List<FuenteEmision> fuentes);
}
