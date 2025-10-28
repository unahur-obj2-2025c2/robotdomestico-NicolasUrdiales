package ar.edu.unahur.obj2.command.habitaciones;

public class Habitacion {
    private Boolean tieneLuzPrendida;
    private final Integer metrosCuadrados;
    private Boolean estaLimpia;



    public Habitacion(Integer metrosCuadrados) {
        this.tieneLuzPrendida = Boolean.FALSE;
        this.metrosCuadrados = metrosCuadrados;
        this.estaLimpia = Boolean.FALSE;
    }

    public void encenderLuz(){
        this.tieneLuzPrendida = Boolean.TRUE;
    }
    public void apagarLuz(){
        this.tieneLuzPrendida = Boolean.FALSE;
    }

    public Integer getMetrosCuadrados(){
        return this.metrosCuadrados;
    }

    public Boolean tieneLuzPrendida(){
        return this.tieneLuzPrendida;
    }

    public void limpiar(){
        this.estaLimpia = Boolean.TRUE;
    }

    public Boolean estaLimpia(){
        return this.estaLimpia;
    }

    

    
}
