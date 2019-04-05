package securest.recurso;

import p2.tempo.Horario;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Intalacao {

    private int id;
    private String local;
    private int acesso;
    private Horario horario;

    private LinkedList<Funcionario> funAutoriza = new LinkedList<Funcionario>();
    private LinkedList<Funcionario> funIn = new LinkedList<Funcionario>();


    public Intalacao(int id, String local, int acesso, Horario horario) {
        this.id = id;
        this.local = local;
        this.acesso = acesso;
        this.horario = horario;
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
        if (acesso <= 5 && acesso >= 1){
            this.acesso = acesso;
        }
        else this.acesso = 1;
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
}
