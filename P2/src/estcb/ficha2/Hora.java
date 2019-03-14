package estcb.ficha2;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Hora {

    private int hora;
    private int minuto;
    private int segundo;

    GregorianCalendar calendar = new GregorianCalendar();
    SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");

    public Hora(int hora, int minuto, int segundo) {
       // this.hora = hora;
        //this.minuto = minuto;
       // this.segundo = segundo;

        //start constructor with validations
        setHora(hora);
        setMinito(minuto);
        setSegundo(segundo);
    }

    /*public int valida(int valor){

        int valido;

       valido = valor < 0? 0:  valor;

        if (valido> 59){
            valido = 59;
        }
        return valido;
    }*/

    @Override
    public String toString() {
        return "Hora{" +
                "hora=" + hora +
                ", minito=" + minuto +
                ", segundo=" + segundo +
                '}';
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
      this.hora = hora < 0? 0: hora;
        if(this.hora > 23){
            this.hora = 23;
        }
    }

    public int getMinito() {
        return minuto;
    }

    public void setMinito(int minito) {
        this.minuto = minito < 0? 0: minito;
        if (this.minuto > 59 ){
            this.minuto = 59;
        }
    }

    public int getSegundo(){

        return segundo;
    }

    public void setSegundo(int segundo) {
        this.segundo = segundo < 0? 0: segundo;
        if(this.segundo > 59 ){
            this.segundo = 59;
        }
    }
}
