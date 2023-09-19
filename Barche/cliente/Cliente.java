package cliente;

/** 
 * Rappresenta un cliente
 *  -Nome
 *  -Tier: Livello fedeltà del cliente (utile per applicare sconti) 
 */
import enums.TierCliente;

public class Cliente {
    private String name;
    private TierCliente tier;

    public Cliente(String nome, TierCliente tier){
        this.name= nome;
        this.tier= tier;
    }

    public String getName() {
        return name;
    }

    public TierCliente getTier() {
        return tier;
    }

}
