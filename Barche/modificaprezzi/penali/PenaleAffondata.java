package modificaprezzi.penali;

import modificaprezzi.modificaPrezzo;

public class PenaleAffondata implements modificaPrezzo{

    private double penalePercentuale= 1;
    private double penaleFissa= 100;
    private double valoreBarca;


    public PenaleAffondata(double valoreBarca){
        this.valoreBarca= valoreBarca;
    }

    @Override
    public double getValorePercentuale() {

        return penalePercentuale * valoreBarca;
    }

    @Override
    public double getValoreFisso() {

        return penaleFissa;
    }

}
