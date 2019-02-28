package estcb.ficha2;

public class Pessoa {

    private String nome, morada, codPostal, localidade, telf;
    private int diaNasc, mesNasc, anoNasc;
    private static char estadoCiv;

    public Pessoa(String nome, String morada, String codPostal, String localidade, String telf, int diaNasc, int mesNasc, int ano, char estado) {
        this.nome = nome;
        this.morada = morada;
        this.codPostal = codPostal;
        this.localidade = localidade;
        this.telf = telf;
        this.diaNasc = diaNasc;
        this.mesNasc = mesNasc;
        this.anoNasc = ano;
        this.estadoCiv = estado;
    }

    public static String getEstadociv() {
        String estExtenso;
        switch (estadoCiv) {
            case 's':
                estExtenso = "Solteiro";
                break;
            case 'c':
                estExtenso = "Casado";
                break;
            case 'd':
                estExtenso = "Divorciado";
                break;
            case 'v':
                estExtenso = "Viuvo";
                break;
            default:
                estExtenso = "???";
        }
        return estExtenso;
    }

    public String getNome() {
        return nome;
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

    public int getDiaNasc() {
        return diaNasc;
    }

    public void setDiaNasc(int diaNasc) {
        this.diaNasc = diaNasc;
    }

    public int getMesNasc() {
        return mesNasc;
    }

    public void setMesNasc(int mesNasc) {
        this.mesNasc = mesNasc;
    }

    public int getAnoNasc() {
        return anoNasc;
    }

    public void setAnoNasc(int anoNasc) {
        this.anoNasc = anoNasc;
    }

    public char getEstado() {

        return estadoCiv;
    }

    public void setEstado(char estado) {
        this.estadoCiv = estado;
    }

}

