package extra;
/**
 * I servizi extra sono i servizi che l'azienda mette a disposizione per i suoi clienti
 * I servizi hanno un costo che può essere giornaliero o una tantum.
 */
public interface ServiziExtra {

    /**
     * costo del servizio
     * @return double: costo del servizio giornaliero
     */
    double getCosto();

    /**
     * controlla se il servizio è giornaliero
     * @return boolean: TRUE: il servizio è giornaliero, FALSE: il servizio è una tantum
     */
    boolean isGiornaliero();
}
