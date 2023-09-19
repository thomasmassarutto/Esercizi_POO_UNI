import enums.*;
import enums.StatoBarca;

/*
 * MISSION:
 * Rappresenta una barca
 */

class Barca{

    private DimensioneBarca dimensioneBarca;
    private int numeroAlberi;
    private String marcaBarca;
    private StatoBarca statoBarca;
    private CaratteristicheBarca caratteristicheBarca;
    private double tariffaGiornaliera;

    public Barca(   DimensioneBarca dimensioneBarca, CaratteristicheBarca caratteristicheBarca,
                    StatoBarca statoBarca, String marcaBarca, int numeroAlberi){
                        
        this.dimensioneBarca= dimensioneBarca;
        this.caratteristicheBarca= caratteristicheBarca;
        this.statoBarca= statoBarca;
        this.marcaBarca= marcaBarca;
        this.numeroAlberi= numeroAlberi;
    }

    public DimensioneBarca getDimensioni(){

        return this.dimensioneBarca;
    }

    public int getNumeroAlberi(){

        return this.numeroAlberi;
    }

    public String getMarcaBarca(){

        return this.marcaBarca;
    }

    public boolean isDisponibileStatoBarca(){
        if (this.statoBarca == StatoBarca.DISPONIBILE){
            return true;
        }else{
            return false;
        }
        
    }

    public CaratteristicheBarca getCaratteristiche(){
        return this.caratteristicheBarca;
    }

    public double getTariffaGiornaliera(){
        return this.tariffaGiornaliera;
    }

    public void setDisponibilita(StatoBarca statoBarca) {
        this.statoBarca= statoBarca;
    }

    @Override
    public boolean equals(Object barca){

        Barca otherBarca = (Barca) barca;

        if (this.dimensioneBarca == otherBarca.dimensioneBarca &&
            this.marcaBarca == otherBarca.marcaBarca &&
            this.numeroAlberi == numeroAlberi){
                return true;
            }else{
                return false;
            }

    }

}