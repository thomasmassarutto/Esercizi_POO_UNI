package cliente;

import java.util.*;
import extra.ServiziExtra;

/** Questa classe rappresenta l'elenco dei servizi che un cliente può scegliere
 *  -elencoServiziExtraCliente: stack di ServiziExtra, elenco dei servizi scelti dal cliente
 */

public class ServiziExtraCliente {

    private Stack<ServiziExtra> elencoServiziExtraCliente;

    /**
     * Costruttore pubblico
     * @param servizioExtra: ServiziExtra: uno dei servizi disponibili
     * 
     */
    public ServiziExtraCliente(ServiziExtra servizioExtra) {
        this.elencoServiziExtraCliente = new Stack<>();
        aggiungiServizioExtra(servizioExtra);
    }

    /**
     * Aggiungere un servizio richiesto dal cliente
     * @param servizioExtra: ServiziExtra: uno dei servizi disponibili
     */
    public void aggiungiServizioExtra(ServiziExtra servizioExtra){
        this.elencoServiziExtraCliente.push(servizioExtra);
    }


    /**
     * Ritorna il servizio in testa allo stack 
     * @return ServiziExtra: il servizio in testa allo stack 
     * @throws EmptyStackException: lo stack che contiene gli elementi è vuoto
     * 
     */
    public ServiziExtra pop() throws EmptyStackException {
        ServiziExtra servizioExtra;
        if (! isEmpty() ){
        servizioExtra= this.elencoServiziExtraCliente.pop();
        }else {
            throw new EmptyStackException();
        }
    
        return servizioExtra;
    }

    /**
     * Afferma se non ci sono più servizi nello stack
     * @return boolean: TRUE: non ci sono servizi
     * 
     */
    public boolean isEmpty(){
        return this.elencoServiziExtraCliente.isEmpty();
    }
}
