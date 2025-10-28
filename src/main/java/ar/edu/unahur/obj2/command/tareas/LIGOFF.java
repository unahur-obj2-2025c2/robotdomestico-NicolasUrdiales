package ar.edu.unahur.obj2.command.tareas;

import ar.edu.unahur.obj2.command.RobotDomestico;
import ar.edu.unahur.obj2.command.habitaciones.Habitacion;

public class LIGOFF extends Tarea{

    private final Habitacion habitacion;

    

    public LIGOFF(Habitacion habitacion) {
        
        this.habitacion = habitacion;
    }

    @Override
    public Double consumoBateria() {
        return !habitacion.tieneLuzPrendida() ? 1.00 : 5.00;
    }

    @Override
    public Integer duracion(RobotDomestico robot) {
        return !habitacion.tieneLuzPrendida() ? 25 : 90;
    }

    @Override
    protected void doEjecutar(RobotDomestico robot) {
        habitacion.apagarLuz();
    }

}
