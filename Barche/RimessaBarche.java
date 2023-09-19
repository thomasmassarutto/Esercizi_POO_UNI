import java.util.*;

import errori.*;

/* 
 * MISSION:
 * Questa classe rappresenta la rimessa delle barche dell'azienda
 * 
*/
public class RimessaBarche{
    private Stack <Barca> barche;

    public RimessaBarche(Barca barca){
        this.barche= new Stack<>();
        this.barche.push(barca);
    }

    public void aggiungiBarca(Barca barca){
        this.barche.push(barca);
    }

/**
 * controlla se una barca con queste specifiche esiste
 * @param barca: Oggetto barca: controlla se questa barca è presente
 * @return barca se trova la barca, altrimenti ECCEZIONE BoatNotFound 
 */
    public Barca findBarca(Barca barca) throws BoatNotFound {

        Iterator <Barca> iterator = barche.iterator();

        while(iterator.hasNext()){
            Barca barchetta= iterator.next();
            if (barchetta.equals(barca)){
                return barca;
            }
        }
        
        throw new BoatNotFound();
    }


}