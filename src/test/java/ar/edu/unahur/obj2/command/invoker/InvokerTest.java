package ar.edu.unahur.obj2.command.invoker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.command.tareas.*;
import ar.edu.unahur.obj2.command.RobotDomestico;
import ar.edu.unahur.obj2.command.habitaciones.Habitacion;

public class InvokerTest {
    Habitacion hb1 = new Habitacion(14);

    RobotDomestico robot1 = new RobotDomestico(100.00);

    List<ITarea> tareas = List.of(new CLEAN(hb1), new LIGON(hb1), new LIGOFF(hb1), new LIGOFF(hb1), new CARGE(20)  ,new INFO());

    Invoker invoker = new Invoker(robot1, tareas);

    @BeforeEach
    void setUp(){
        robot1.reiniciar();
    }





    @Test
    void despuesDeEjecutarLasTareasLaBateriaQuedaEn35(){
        invoker.ejecutarTareas();

        assertEquals(35.00, robot1.getBateria());
    }

    @Test
    void despuesDeEjecutarLasMismasTareasLaHabitacionQuedaConLaLuzApagada(){
        invoker.ejecutarTareas();

        assertFalse(hb1.tieneLuzPrendida());
    }

    @Test
    void despuesDeEjecutarLasMismasTareasElTiempoTotalDeLasTareasEs7535Segundos(){
        invoker.ejecutarTareas();

        assertEquals(7535, robot1.duracionTareasRealizadas());
    }

    @Test
    void cargarUnRobotNuevoCon0DeBateriaPor125MinutosYQueCargueA100(){
        RobotDomestico robot = new RobotDomestico(0.00);
        RobotDomestico robot3 = new RobotDomestico(0.00);
        Invoker inv = new Invoker(robot3);
        inv.agregarTarea(new CARGE(125));
        inv.ejecutarTareas();
        invoker.limpiarTareas();
        invoker.cambiarRobot(robot);
        invoker.agregarTarea(new CARGE(125));
        invoker.ejecutarTareas();
        assertEquals(100.00, robot.getBateria());
        assertEquals(100.00, robot3.getBateria());
    }
    
}
