package ar.edu.unahur.obj2.command.excepciones;

public class NoTieneSuficienteBateria extends RuntimeException{

    public NoTieneSuficienteBateria() {
        super("No tiene la bateria suficiente para realizar estas tareas");
    }



}
