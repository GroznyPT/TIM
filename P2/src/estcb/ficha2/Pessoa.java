package estcb.ficha2;

public class Pessoa {

    String nome, morada, codPostal, localidade, telf;
    int dia, mes, ano;
    char estado;

    public Pessoa(String nome, String morada, String codPostal, String localidade, String telf, int dia, int mes, int ano, char estado) {
        this.nome = nome;
        this.morada = morada;
        this.codPostal = codPostal;
        this.localidade = localidade;
        this.telf = telf;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.estado = estado;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getTelf() {
        return telf;
    }

    public void setTelf(String telf) {
        this.telf = telf;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
}

