import p2.tempo.Hora;

import java.util.LinkedList;

public class Funcionario {

    private int id;
    private  String name = "";
    private  int acesso;
    Hora hora;

    LinkedList<Funcionario> funAutoriza = new LinkedList<Funcionario>();
    LinkedList<Funcionario> funIn = new LinkedList<Funcionario>();

    public Funcionario(int id, String name, int acesso) {
        this.id = id;
        this.name = name;
        this.acesso = acesso;
    }

    public boolean podeEntrar( Funcionario f, Hora h ){
        return false; // apagar
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAcesso() {
        return acesso;
    }

    public void setAcesso(int acesso) {
        this.acesso = acesso;
    }
}
