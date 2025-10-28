package ar.edu.unahur.obj2.command.invoker;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unahur.obj2.command.tareas.ITarea;
import ar.edu.unahur.obj2.command.RobotDomestico;
import ar.edu.unahur.obj2.command.excepciones.NoTieneSuficienteBateria;


public class Invoker {
    private RobotDomestico robot;
    private List<ITarea> tareas = new ArrayList<>();

    public Invoker(RobotDomestico robot) {
        this.robot = robot;
    }
    
    public Invoker(RobotDomestico robot, List<ITarea> tareas) {
        this.robot = robot;
        this.tareas = tareas;
    }

   
    public void agregarTarea(ITarea tarea){
        tareas.add(tarea);
    }
    
    public void ejecutarTareas(){
        if(!robot.leAlcanzaLaBateriaPara(tareas)){
            throw new NoTieneSuficienteBateria();
        }
        robot.realizar(tareas);
    }


    public void cambiarRobot(RobotDomestico robot){
        this.robot = robot;
    }

    public void limpiarTareas(){
        this.tareas = new ArrayList<>();
    }

}
