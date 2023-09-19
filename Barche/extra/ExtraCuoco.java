package extra;
public class ExtraCuoco implements ServiziExtra{
    private final double costo= 50;
    private final boolean isGiornaliero= true;
    
    @Override
    public double getCosto() {
        return this.costo;
    }

    @Override
    public boolean isGiornaliero() {
        return this.isGiornaliero;
    }
}
