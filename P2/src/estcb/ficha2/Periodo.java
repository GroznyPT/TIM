package estcb.ficha2;

public class Periodo {

    Hora horainit;
    Hora horafinal;

    public Periodo(Hora horainit, Hora horafinal) {
        this.horainit = horainit;
        this.horafinal = horafinal;
    }

    public Periodo(Hora horainit) {
        this.horainit = horainit;
        horainit.toSegundos();
    }


    @Override
    public String toString() {
        return "Periodo{" +
                "horainit=" + horainit +
                ", horafinal=" + horafinal +
                '}';
    }

    public boolean estaContidoo(Periodo p){
        return horainit.compareTo(p.horainit) >= 0 && horafinal.compareTo(p.horafinal) <=0;
    }

    public void junta (Periodo p){
        if(!interseta(p))
            return;

        if (p.horafinal.compareTo(horainit) < 0)
            horainit = p.horainit.clone();

        if (p.horafinal.compareTo(horafinal) > 0)
            horafinal = p.horafinal.clone();
    }

    public Periodo getUniao(Periodo p){

        if (!interseta(p))return null;

        Hora i = horainit.compareTo(p.horafinal) < 0? horainit:p.horainit;
        Hora f = horafinal.compareTo(p.horafinal) < 0? horafinal:p.horafinal;

        Periodo novop = new Periodo(i.clone(),f.clone());

        return  novop;
    }

    public Periodo getIntersecao (Periodo p){

        if(!contem(p)) return null;

        Hora i = horainit.compareTo(p.horainit) > 0? horainit:p.horainit;
        Hora f = horafinal.compareTo(p.horafinal) < 0? horafinal:p.horafinal;

        Periodo p4 = new Periodo(i.clone(), f.clone());
        return  p4;

    }

    public boolean contem(Periodo p){
        return p.estaContidoo(this);
    }

    public Hora getHorainit() {
        return horainit;
    }

    public void setHorainit(Hora horainit) {
        this.horainit = horainit;
    }

    public Hora getHorafinal() {
        return horafinal;
    }

    public void setHorafinal(Hora horafinal) {
        this.horafinal = horafinal;
    }
}
