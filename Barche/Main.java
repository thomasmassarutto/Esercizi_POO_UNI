import java.util.Stack;

import cliente.*;
import enums.DimensioneBarca;
import enums.StatoBarca;
import enums.TierCliente;
import extra.ExtraCuoco;
import extra.ExtraLavaggio;
import extra.ServiziExtra;
import modificaprezzi.modificaPrezzo;
import modificaprezzi.penali.PenaleAffondata;
import modificaprezzi.penali.PenalePorto;
import modificaprezzi.sconti.ScontoBassaStagione;
import modificaprezzi.sconti.ScontoClienteFedele;

public class Main {
    public static void main (String[] args) {

        // le barche disponibili
        Barca barca1= new Barca(DimensioneBarca.m10, null, StatoBarca.DISPONIBILE, "GalleggiaBene", 1);
        Barca barca2= new Barca(DimensioneBarca.m20, null, StatoBarca.DISPONIBILE, "GalleggiaBene", 2);
        Barca barca3= new Barca(DimensioneBarca.m20, null, StatoBarca.DISPONIBILE, "NonAffondaSpa", 1);

        RimessaBarche rimessaMareESole = new RimessaBarche(barca1);
        rimessaMareESole.aggiungiBarca(barca2);
        rimessaMareESole.aggiungiBarca(barca3);

        //gli extra disponibili
        ExtraCuoco cuocoDiBordo= new ExtraCuoco();
        ExtraLavaggio lavaggioFinale= new ExtraLavaggio();

        ServiziExtraCliente serviziExtra= new ServiziExtraCliente(cuocoDiBordo);
        serviziExtra.aggiungiServizioExtra(lavaggioFinale);

        // gli sconti disonibili
        ScontoBassaStagione bassaStagione= new ScontoBassaStagione();
        ScontoClienteFedele clienteFedele= new ScontoClienteFedele();

        Stack<modificaPrezzo> stackSconti= new Stack<>();
        stackSconti.push(clienteFedele);
        stackSconti.push(bassaStagione);

        //le penali disponibili
        PenaleAffondata barcaAffondata= new PenaleAffondata(1000);
        PenalePorto portoSbagliato= new PenalePorto(100);

        Stack<modificaPrezzo> stackPenali= new Stack<>();
        stackPenali.push(barcaAffondata);
        stackPenali.push(portoSbagliato);

        // il cliente
        Cliente MarioBros= new Cliente("SuperMario", TierCliente.FEDELE);

        // la barca ricrcata dal cliente
        Barca barca100= new Barca(DimensioneBarca.m20, null, StatoBarca.DISPONIBILE, "NonAffondaSpa", 1);

       

        // cercare barca
        rimessaMareESole.findBarca(barca100);

        // noleggiare barca
        Noleggio noleggioMarioBros= new Noleggio(MarioBros, barca100, "01/01/01", "02/02/02", "Regno dei funghi", "Regno dei funghi", serviziExtra, stackSconti);

        // fornire preventivo al cliente
        double preventivo= noleggioMarioBros.preventivo();
        System.out.println(preventivo);
        // prenotare barca selezionata in fase di noleggio
        noleggioMarioBros.prenotaBarca();

        // restituire barca
        double penali= noleggioMarioBros.restituisciBarca(stackPenali);
        System.out.println(penali);
        }
}
