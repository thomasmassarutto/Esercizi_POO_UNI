package modificaPrezzi.sconti;

import modificaPrezzi.modificaPrezzo;

public class ScontoClienteFedele implements modificaPrezzo{

    private double scontoPercentuale= 0.10;
    private double scontoFisso= 10;
    

    @Override
    public double getValorePercentuale() {

        return scontoPercentuale;
    }

    @Override
    public double getValoreFisso() {
        
        return scontoFisso;
    }
    
}
