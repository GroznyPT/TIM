package Test;

import p2.tempo.Hora;
import p2.tempo.Horario;
import securest.recurso.Funcionario;
import securest.recurso.Instalacao;

public class TestFuncionario {


    public static void main(String[] args) {
        Funcionario f1 = new Funcionario(1, "Asdrubal", 5 );

        System.out.println(f1);


        Instalacao instalacao = new Instalacao(3, "Sala P2", 4, new Horario());
        System.out.println(instalacao);

       // instalacao.addAutorizado(f1);

        System.out.println(instalacao.podeEntrar(f1,new Hora()));

    }

}
