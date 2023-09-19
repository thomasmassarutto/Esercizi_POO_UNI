import java.util.*;

import extra.*;
import modificaprezzi.modificaPrezzo;
import modificaprezzi.sconti.*;
import enums.*;
import enums.StatoBarca;
import errori.ErroreSconto;



/**
 * Gestisce la fase di noleggio di una barca: 
 * - genera un preventivo in base alle specifiche del noleggio
 * - prenota una barca
 * - applica sconti al prezzo
 * - applica penalità al prezzo
 */
public class Noleggio {
    private Cliente cliente;
    private Barca barca;
    private String dataInizio;
    private String dataFine;
    private String luogoInizio;
    private String luogoFine;
    private Stack<ServiziExtra> stackServiziExtra;
    private Stack<modificaPrezzo> stackSconti;
    
    /**
     * Costruttore della classe Noleggio.
     *
     * @param cliente: Cliente: il cliente che effettua il noleggio
     * @param barca: Barca: la barca oggetto del noleggio
     * @param dataInizio: Stringa: la data di inizio del noleggio in formato gg/mm/yyyy
     * @param dataFine: Stringa: la data di fine del noleggio in formato gg/mm/yyyy
     * @param luogoInizio: Stringa: il luogo di inizio del noleggio
     * @param luogoFine: Stringa: il luogo di fine del noleggio
     * @param stackServiziExtra:    Stack<InterfacciaServiziExtra>: stack contenente i servizi extra 
     *                              associati al noleggio, scelti dal cliente
     * @param private Stack<InterfacciaSconti> stackSconti applicati.
     */

    public Noleggio(    Cliente cliente, Barca barca, String dataInizio, String dataFine,
                        String luogoInizio, String luogoFine, 
                        Stack<ServiziExtra> stackServiziExtra,
                        Stack<modificaPrezzo> stackSconti){

        this.barca= barca;
        this.cliente= cliente;
        this.dataFine= dataFine;
        this.dataInizio= dataInizio;
        this.luogoFine= luogoFine;
        this.luogoInizio= luogoInizio;
        this.stackServiziExtra= stackServiziExtra;
        this.stackSconti= stackSconti;
    }
    /**
     * calcola il preventivo
     * @return double: il preventivo del costo del noleggio x>=0
     */
    public double preventivo() throws ErroreSconto{
        double preventivo=0;
        double costoBarca=0;
        double costiServiziExtra=0;
        double scontoPercentuale= 1;
        double scontoFisso= 0;

        int numeroGiorniNoleggio= numeroGiorniNoleggio();

        costoBarca = calcolaCostoNoleggioBarca(numeroGiorniNoleggio);
        costiServiziExtra= calcolaCostiServiziExtra(numeroGiorniNoleggio);

        scontoFisso= calcolaPrezzoFisso(stackSconti);
        scontoPercentuale= calcolaPrezzoPercentuale(stackSconti);

        preventivo= (costoBarca + costiServiziExtra - scontoFisso) * (1 - scontoPercentuale);

        if (preventivo < 0 ){
            throw new ErroreSconto("Hai applicato troppi sconti");
        }

        return preventivo;
    }

    /**
     * Quando invocata modifica lo stato della barca in PRENOTATA
     */
    public void prenotaBarca(){
        this.barca.setDisponibilita(StatoBarca.PRENOTATA);
    }


    /**
     * Quando invocata modifica lo stato della barca in RESTITUITA
     * @return double: valore delle penali in euro
     */
    public double restituisciBarca(Stack<modificaPrezzo> penali){

        double prezzoPenali=0;
        double penaliFisse=0;
        double penaliPercentuali=0;

        penaliFisse= calcolaPrezzoFisso(penali);
        penaliPercentuali= calcolaPrezzoPercentuale(penali);

        prezzoPenali= penaliFisse + penaliPercentuali;
        
        this.barca.setDisponibilita(StatoBarca.RESTITUITA);
        return prezzoPenali;
    }

    /**
     * Ritorna il numero di giorni di durata del noleggio:
     * 
     * @return int: durata noleggio in giorni > 0
     */
    private int numeroGiorniNoleggio(){
        int numeroGiorniNoleggio=0;

        return numeroGiorniNoleggio;
    }

    /**
     * Calcola il costo dei servizi durante il noleggio
     * @param giorni: int numero di giorni > 0
     * @return double: il costo dei servizi calcolati ogni giorno
     */
    private double calcolaCostiServiziExtra(int giorni){
        double costoServiziExtra=0;
    
        while( !this.stackServiziExtra.isEmpty() ){
            ServiziExtra servizio= this.stackServiziExtra.pop();
            if (servizio.isGiornaliero()){
                costoServiziExtra= costoServiziExtra + (servizio.getCosto() * giorni);
            }else{
                costoServiziExtra= costoServiziExtra + servizio.getCosto(); 
            }
        }

        return costoServiziExtra;
    }

    /**
     * Calcola il costo di noleggio della barca
     * @param giorni: int numero di giorni > 0
     * @return double: il costo del noleggio solo barca durante i giorni
     */
    private double calcolaCostoNoleggioBarca(int giorni){
        double costoNoleggioBarca=0;
        double tariffaBarca= barca.getTariffaGiornaliera();

        costoNoleggioBarca= tariffaBarca * giorni;

        return costoNoleggioBarca;
    }

    /**
     * 
     * @param stackSconti: stack contenente oggetti modificaPrezzo
     * @return double: sconto da applicare in euro
     * @throws ErroreSconto
     */
    private double calcolaPrezzoFisso(Stack<modificaPrezzo> stackPrezzi) throws ErroreSconto{
        double prezzoFisso=0;

        Iterator <modificaPrezzo> iterator = stackPrezzi.iterator();

        while(iterator.hasNext()){
            modificaPrezzo nextSconto= iterator.next();
            if (nextSconto.getValoreFisso() >= 0){
                prezzoFisso= prezzoFisso + nextSconto.getValoreFisso();
            }else {
                throw new ErroreSconto("Sconto fisso invalido!");
            }
        }
        
        return prezzoFisso;
    }


    /**
     * 
     * @param stackSconti: stack contenente oggetti modificaPrezzo
     * @return double: sconto da applicare in percentuale 0<=x<=1
     * @throws ErroreSconto
     */
    private double calcolaPrezzoPercentuale(Stack<modificaPrezzo> stackPrezzi){
        double prezzoPercentuale=1;

        Iterator <modificaPrezzo> iterator = stackPrezzi.iterator();

        while(iterator.hasNext()){
            modificaPrezzo nextPrezzo= iterator.next();
            if (nextPrezzo.getValorePercentuale() > 0){
                prezzoPercentuale= prezzoPercentuale * nextPrezzo.getValorePercentuale();
            }else {
                throw new ErroreSconto("Sconto percentuale invalido!");
            }
        }

        return prezzoPercentuale;
    }
}
