package ar.edu.unahur.obj2.command.tareas;

import ar.edu.unahur.obj2.command.RobotDomestico;

public class CARGE extends Tarea{
    
    private final Integer minutos;
    
    public CARGE(Integer minutos) {
        this.minutos = minutos;
    }

    @Override
    public Double consumoBateria() {
        return 0.00;
    }

    @Override
    public Integer duracion(RobotDomestico robot) {
        return robot.segundosParaCargarCompleta();
    }

    @Override
    protected void doEjecutar(RobotDomestico robot) {
        Integer segundos = minutos * 60;
        robot.cargarBateria(segundos);
    }

    

}
