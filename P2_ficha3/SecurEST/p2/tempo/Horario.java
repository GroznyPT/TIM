package p2.tempo;

import java.util.ArrayList;

public class Horario {

    private ArrayList<Periodo> periodos = new ArrayList<Periodo>();


    public Horario() {
    }

    public void addPeriodo(Periodo p) {
        for (int i=periodos.size()-1; i>=0; i--){
            if (periodos.get(i).interseta(p)){
                p.junta(periodos.get(i));
                periodos.remove(i);
            }
        }
        periodos.add(p);
    }

    public void removePeriodo(int idx) {
        periodos.remove(idx);
    }

    public boolean estaDentro(Hora h) {
        for (Periodo p : periodos) {
            if (p.estaDentro(h))
                return true;
        }
        return false;
    }


}
