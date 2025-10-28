package ar.edu.unahur.obj2.command;


import java.util.ArrayList;
import java.util.List;


import ar.edu.unahur.obj2.command.excepciones.BateriaIncorrecta;
import ar.edu.unahur.obj2.command.tareas.ITarea;

public class RobotDomestico {
    private final List<ITarea> tareasRealizadas = new ArrayList<>();
    private Double bateria;
    public RobotDomestico(Double bateria) {
        if(bateria < 0 && bateria > 100){
            throw new BateriaIncorrecta();
        }
        this.bateria = bateria;
    }

    
    public void gastarBateria(Double porcentaje){
        bateria -= porcentaje;
    }

    public void cargarBateria(Integer segundos){
        Integer minutos = (int)(segundos / 60);

        bateria = Math.min(100.00, bateria + (minutos * 0.8));
    }

    public Double getBateria(){
        return bateria;
    }

    public Integer segundosParaCargarCompleta(){
        Double bateriaFaltante = 100.0 - bateria;
        Double minutosDeCargaCompleta = bateriaFaltante / 0.8;
        return (int) Math.ceil(minutosDeCargaCompleta * 60);
    }
    
    public void agregarTareaCompletada(ITarea tarea){
        tareasRealizadas.add(tarea);
    }

    public List<ITarea> getTareasRealizadas(){
        return this.tareasRealizadas;
    }

    public Integer duracionTareasRealizadas(){
        return tareasRealizadas.stream().mapToInt(t -> t.duracion(this)).sum();
    }

    public Integer cantidadTareasRealizadas(){
        return tareasRealizadas.size();
    }

    public Boolean leAlcanzaLaBateriaPara(List<ITarea> tareas){
        Double gastoTotalBateria = tareas.stream().mapToDouble(ITarea :: consumoBateria).sum();
        Double diferenciaBateria = this.bateria - gastoTotalBateria;

        return diferenciaBateria >= 0;
    }

    public void realizar(List<ITarea> tareas){
        tareas.forEach(t -> t.ejecutar(this));
    }

    public void reiniciar(){
        tareasRealizadas.clear();
    }
}
