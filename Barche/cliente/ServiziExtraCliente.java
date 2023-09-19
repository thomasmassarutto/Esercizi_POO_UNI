package cliente;

import java.util.*;
import extra.ServiziExtra;

public class ServiziExtraCliente {

    private Stack<ServiziExtra> elencoServiziExtraCliente;

    public ServiziExtraCliente(ServiziExtra servizioExtra) {
        this.elencoServiziExtraCliente = new Stack<>();
        aggiungiServizioExtra(servizioExtra);
    }

    private ServiziExtraCliente(Stack<ServiziExtra> elencoServiziExtraCliente){
        this.elencoServiziExtraCliente= elencoServiziExtraCliente;

    }

    public void aggiungiServizioExtra(ServiziExtra servizioExtra){
        this.elencoServiziExtraCliente.push(servizioExtra);
    }

    public ServiziExtra pop(){
        ServiziExtra servizioExtra= this.elencoServiziExtraCliente.pop();
    
        return servizioExtra;
    }

    public boolean isEmpty(){
        return this.elencoServiziExtraCliente.isEmpty();
    }
}
