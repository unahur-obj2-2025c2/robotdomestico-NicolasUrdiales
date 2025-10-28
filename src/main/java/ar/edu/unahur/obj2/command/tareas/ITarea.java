package ar.edu.unahur.obj2.command.tareas;

import ar.edu.unahur.obj2.command.RobotDomestico;


public interface ITarea {
    void ejecutar(RobotDomestico robot);
    Double consumoBateria();
    Integer duracion(RobotDomestico robot);
}
