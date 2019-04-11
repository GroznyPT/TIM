package securest.recurso;

import p2.tempo.Hora;
import p2.tempo.Horario;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Instalacao {

    private int id;
    private String local;
    private int acesso;
    private Horario horario;

    private LinkedList<Funcionario> funAutoriza = new LinkedList<Funcionario>();
    private LinkedList<Funcionario> funIn = new LinkedList<Funcionario>();


    public Instalacao(int id, String local, int acesso, Horario horario) {
        this.id = id;
        this.local = local;
        setAcesso(acesso);
        this.horario = horario;
    }

    public boolean podeEntrar( Funcionario f, Hora h ){

        if(!horario.estaDentro(h)){
            return false;
        }
        return f.getAcesso() >= acesso || funAutoriza.contains(f);
    }

    public void addAutorizado( Funcionario f ){
        funIn.add(f);
    }

    public void removeAutorizado( Funcionario f ){
        funIn.remove(f);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getAcesso() {
        return acesso;
    }

    public void setAcesso(int acesso) {
        if (acesso <= SecurityLevel.MAX && acesso >= SecurityLevel.MIN){
            this.acesso = acesso;
        }
        else this.acesso = SecurityLevel.MAX;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public List<Funcionario> getFunAutoriza() {
        return Collections.unmodifiableList(funAutoriza);
    }

    public void setFunAutoriza(LinkedList<Funcionario> funAutoriza) {
        this.funAutoriza = funAutoriza;
    }

    public List<Funcionario> getFunIn() {
        return Collections.unmodifiableList(funIn);
    }

    public void setFunIn(LinkedList<Funcionario> funIn) {
        this.funIn = funIn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Instalacao)) return false;
        Instalacao that = (Instalacao) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Instalacao{" +
                "id: " + id +
                ", Local: '" + local + '\'' +
                ", Acesso: " + acesso +
                ", Autorizados: " + funAutoriza +
                ", Func. Presentes: " + funIn +
                '}';
    }


}
