package extra;

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
