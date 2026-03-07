/**
 * Clase principal con la simulación del sistema de emisiones y costes.
 */
public class Main {

    public static void main(String[] args) {

        // Crear empresa
        Empresa empresa = new Empresa("TechGreen Solutions S.L.");

        // --- Fuentes de emisión ---
        empresa.agregarFuente(new Electricidad("Electricidad oficinas", 0.18, 0.15, 50000));
        empresa.agregarFuente(new Electricidad("Electricidad almacén",  0.18, 0.15, 20000));
        empresa.agregarFuente(new Transporte("Camiones (diésel)",  2.64, 1.50, 8000));
        empresa.agregarFuente(new Transporte("Coches (gasolina)",  2.31, 1.45, 3000));
        empresa.agregarFuente(new Climatizacion("Aire acondicionado", 1.2, 0.80, 2000));
        empresa.agregarFuente(new Climatizacion("Calefacción central", 1.5, 1.00, 1500));

        // --- Medidas correctoras ---
        empresa.agregarMedida(new Autoconsumo("Paneles solares (40%)", 40));
        empresa.agregarMedida(new MovilidadElectrica("Flota eléctrica (60%)", 60));
        empresa.agregarMedida(new ClimatizacionBombaCalor("Bomba de calor COP=3.5", 3.5));

        // --- Mostrar resultados ---
        System.out.println("=== EMPRESA: " + empresa.getNombre() + " ===\n");

        System.out.println("-- Fuentes de emisión --");
        for (FuenteEmision f : empresa.getFuentes()) {
            System.out.println("  " + f);
        }

        System.out.printf("%n-- Totales actuales --%n");
        System.out.printf("  Emisiones: %.2f kg CO2%n", empresa.calcularEmisionesTotales());
        System.out.printf("  Coste:     %.2f €%n", empresa.calcularCosteTotal());

        System.out.printf("%n-- Simulación con medidas correctoras --%n");
        for (MedidaCorrectora m : empresa.getMedidas()) {
            System.out.printf("  [%s] Ahorra %.2f kg CO2 y %.2f €%n",
                m, m.reducirEmisiones(empresa.getFuentes()), m.reducirCoste(empresa.getFuentes()));
        }

        System.out.printf("%nReducción total: %.2f kg CO2 | %.2f €%n",
            empresa.simularReduccionEmisiones(), empresa.simularReduccionCoste());
        System.out.printf("Resultado final: %.2f kg CO2 | %.2f €%n",
            empresa.calcularEmisionesTotales() - empresa.simularReduccionEmisiones(),
            empresa.calcularCosteTotal() - empresa.simularReduccionCoste());
    }
}
