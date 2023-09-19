package modificaprezzi.penali;

import modificaprezzi.modificaPrezzo;

public class PenalePorto implements modificaPrezzo{

    private double penalePercentuale= 0.10;

    private double penaleFissa= 100;

    private double distanzaPorto;

    public PenalePorto(double distanzaPorto){
        this.distanzaPorto= distanzaPorto;
    }
    
    @Override
    public double getValorePercentuale() {

        return penalePercentuale * distanzaPorto; 
    }

    @Override
    public double getValoreFisso() {

        return penaleFissa;
    }

}
