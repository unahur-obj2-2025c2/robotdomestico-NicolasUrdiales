package ar.edu.unahur.obj2.command.tareas;

import ar.edu.unahur.obj2.command.RobotDomestico;
import ar.edu.unahur.obj2.command.habitaciones.Habitacion;

public class CLEAN extends Tarea{
    private final Habitacion habitacion;

    public CLEAN(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    @Override
    public Double consumoBateria() {
        return habitacion.getMetrosCuadrados() * 5.00;
    }

    @Override
    public Integer duracion(RobotDomestico robot) {
        return habitacion.getMetrosCuadrados() * 180;
    }

    @Override
    protected void doEjecutar(RobotDomestico robot) {
        habitacion.limpiar();
    }

    

}
