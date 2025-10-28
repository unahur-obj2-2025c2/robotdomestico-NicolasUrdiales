package ar.edu.unahur.obj2.command.tareas;

import ar.edu.unahur.obj2.command.RobotDomestico;

public abstract class Tarea implements ITarea{

    

    @Override
    public void ejecutar(RobotDomestico robot){
        Double consumoBateria = this.consumoBateria();
        this.doEjecutar(robot);
        robot.gastarBateria(consumoBateria);
        robot.agregarTareaCompletada(this);
    }
    
    protected abstract void doEjecutar(RobotDomestico robot);

}
