package ar.edu.unahur.obj2.command.tareas;

import ar.edu.unahur.obj2.command.RobotDomestico;

public class INFO extends Tarea{

    

    @Override
    public Double consumoBateria() {
        return 0.00;
    }

    @Override
    public Integer duracion(RobotDomestico robot) {
        return 0;
    }

    @Override
    protected void doEjecutar(RobotDomestico robot) {
        Integer promedio = robot.duracionTareasRealizadas() / robot.cantidadTareasRealizadas();
        System.out.println("El promedio de tiempo de las tareas realizadas es: " + promedio);
    }

    

}
