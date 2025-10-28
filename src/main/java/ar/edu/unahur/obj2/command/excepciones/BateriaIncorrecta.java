package ar.edu.unahur.obj2.command.excepciones;

public class BateriaIncorrecta extends RuntimeException{

    public BateriaIncorrecta() {
        super("La bateria tiene un valor del 1 al 100");
    }


}
