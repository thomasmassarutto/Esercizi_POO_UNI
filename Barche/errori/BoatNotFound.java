package errori;

public class BoatNotFound extends RuntimeException{

    public BoatNotFound() {
        super("Barca non trovata");
    }
}
