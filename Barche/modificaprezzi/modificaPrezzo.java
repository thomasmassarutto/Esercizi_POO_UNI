package modificaPrezzi;

/**
 * Gestire le modifiche dei prezzi: sconti e penali
 * Ogni costo ha un valore in percentuale oppure un costo fisso
 * Tutti i  modificaPrezzo SONO double maggiori di zero
 */
public interface modificaPrezzo {

    /**
     * Ritorna il valore dello sconto in percentuale
     * @return double: valore percentuale della modifica prezzo: nel caso
     *                  sconti: percentuale 0<=x<=1
     *                  penali: valore calcolato in base alla "percentuale di danno all'azienda"
     */
    double getValorePercentuale();

    /**
     * Ritorna il valore dello sconto fisso
     * @return double: valore fisso in euro
     */
    double getValoreFisso();
}
