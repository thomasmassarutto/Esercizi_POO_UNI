package extra;
public class ExtraLavaggio implements ServiziExtra{

    private final double costo= 100;
    private final boolean isGiornaliero= false;

    @Override
    public double getCosto() {
        return this.costo;
    }

    @Override
    public boolean isGiornaliero() {
        return this.isGiornaliero;
    }
    
}
