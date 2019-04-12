package securest.recurso;

import p2.tempo.Hora;

public class Funcionario {

    private int id;
    private  String name;
    private  int acesso;

    private Instalacao instalacao;
    Hora hora;

    public Funcionario(int id, String name, int acesso) {
        this.id = id;
        this.name = name;
        setAcesso(acesso);
    }

    public boolean equals( Funcionario f ) {

        if (this.getId() != f.getId()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Funcionario)) return false;
        Funcionario that = (Funcionario) o;
        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public boolean estaPresente( ){
       return true; // apagar
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

        if (acesso <= SecurityLevel.MAX && acesso >= SecurityLevel.MIN){
            this.acesso = acesso;
        }
       else this.acesso = 1;
    }

    public Instalacao getInstalacao() {
        return instalacao;
    }

    void setInstalacao(Instalacao instalacao) {
        this.instalacao = instalacao;
    }

    void sair() {
        setInstalacao(null);
    }

    @Override
    public String toString() {
        return  "id: " + id +
                ", name: '" + name + '\'' +
                ", acesso: " + acesso +
                '}';
    }
}
