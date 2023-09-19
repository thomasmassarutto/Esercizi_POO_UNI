import enums.*;
import enums.StatoBarca;

/*
 * Rappresenta una barca mette a disposizione mari metodi per conoscere informazioni sulla barca
 * 
 */

class Barca{

    private DimensioneBarca dimensioneBarca;
    private int numeroAlberi;
    private String marcaBarca;
    private StatoBarca statoBarca;
    private CaratteristicheBarca caratteristicheBarca;
    private double tariffaGiornaliera;
    /**
     * Costruttore
     * @param dimensioneBarca: DimensioneBarca, deve essere fra le predefinite
     * @param caratteristicheBarca: CaratteristicheBarca, elenco di optional della barca
     * @param statoBarca: StatoBarca, indica lo stato della barca es noleggiata
     * @param marcaBarca: String, marca della barca
     * @param numeroAlberi: int numero alberi della barca
     * 
     */
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