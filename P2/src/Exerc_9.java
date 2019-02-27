import java.util.Date;

public class Exerc_9 {

    static void printPessoa(String nomes, String moradas, String codPostais, String telefones, int dias, int meses, int anos, char estadoc) {

        System.out.println("Nome:\t" + nomes);
        System.out.println("Cod Postal:\t" + moradas);
        System.out.println("Local:\t" + codPostais);
        System.out.println("Telf:\t" + telefones);
        System.out.println("Data Nascimento:\t" + dias + "/" + meses + "/" + anos);

        String estExtenso = getString(estadoc[]);

        System.out.println("Estado Civil:\t" + estExtenso);

    }

    private static String getString(char estadoc) {
        String estExtenso;
        switch (estadoc) {
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
            default: estExtenso = "???";

        }
        return estExtenso;
    }

    public static int getIdade(int anoNac, int anoRef){
        int anoAtual = 2019;

        int difAno = (anoAtual - anoNac) + (anoRef - anoAtual);

        return difAno;

    }

    public static void main(String[] args) {

        printPessoa();

        System.out.println("Idade: " + getIdade ( 1988,2020));

        String nomes[] = new String[2];
        String moradas[] = new String[2];
        String codPostais[] = new String[2];
        String telefones[] = new String[2];
        int diasNasc[] = new int[2];
        int mesesNasc[] = new int[2];
        int anosNasc[] = new int[2];
        char estadoCiv[] = new char[2];

        nomes[0] = "Manuel";
        moradas[0] = "CB";
        codPostais[0] = "6000";
        telefones[0] = "926420455";
        diasNasc[0] = 04;
        mesesNasc[0] = 06;
        anosNasc[0] = 1988;
        estadoCiv[0] = 's';

        nomes[1] = "José";
        moradas[1] = "Lx";
        codPostais[1] = "2100";
        telefones[1] = "939008585";
        diasNasc[1] = 01;
        mesesNasc[1] = 05;
        anosNasc[1] = 1965;
        estadoCiv[1] = 'u';



        System.out.println("Idade: " + getIdade ( 1988,2020));


    }
}