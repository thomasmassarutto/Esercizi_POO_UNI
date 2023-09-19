package modificaprezzi.sconti;

import modificaprezzi.modificaPrezzo;

public class ScontoBassaStagione implements modificaPrezzo{

    private double scontoPercentuale= 0.20;
    private double scontoFisso= 0;
    

    @Override
    public double getValorePercentuale() {

        return scontoPercentuale;
    }

    @Override
    public double getValoreFisso() {
        
        return scontoFisso;
    }
    
}
