package estcb.ficha2;

public class TestPessoa {

    public static void main(String[] args) {

        /*Pessoa pessoa = new Pessoa("Luis", "RTMS Pinto", "6000", "Castelo Branco",
                "926420455", 4, 6, 1988,'s');

                */

        Pessoa[] pessoa = new Pessoa[4];

        for (int i=1; i< pessoa.length; i++){
            pessoa[i] = new Pessoa();
        }

        pessoa[0].setNome("Joao");
        pessoa[0].setMorada("Rua das Couves");
        pessoa[0].setCodPostal("6000");
        pessoa[0].setLocalidade("Castelo Branco");
        pessoa[0].setTelf("962420455");
        pessoa[0].setDiaNasc(4);
        pessoa[0].setMesNasc(6);
        pessoa[0].setAnoNasc(1988);
        pessoa[0].setEstado('u');

        pessoa[1].setNome("João");
        pessoa[1].setMorada("Rua das Couves");
        pessoa[1].setCodPostal("6000");
        pessoa[1].setLocalidade("Castelo Branco");
        pessoa[1].setTelf("962420455");
        pessoa[1].setDiaNasc(4);
        pessoa[1].setMesNasc(6);
        pessoa[1].setAnoNasc(1988);
        pessoa[1].setEstado('u');

        pessoa[2].setNome("João");
        pessoa[2].setMorada("Rua das Couves");
        pessoa[2].setCodPostal("6000");
        pessoa[2].setLocalidade("Castelo Branco");
        pessoa[2].setTelf("962420455");
        pessoa[2].setDiaNasc(4);
        pessoa[2].setMesNasc(6);
        pessoa[2].setAnoNasc(1988);
        pessoa[2].setEstado('u');

        pessoa[3].setNome("João");
        pessoa[3].setMorada("Rua das Couves");
        pessoa[3].setCodPostal("6000");
        pessoa[3].setLocalidade("Castelo Branco");
        pessoa[3].setTelf("962420455");
        pessoa[3].setDiaNasc(4);
        pessoa[3].setMesNasc(6);
        pessoa[3].setAnoNasc(1988);
        pessoa[3].setEstado('u');



        System.out.println("Nome:\t" + pessoa[0].getNome());
        /*System.out.println("Morada:\t" + pessoa[0].getMorada());
        System.out.println("Código POstas:\t" + pessoa[0].getCodPostal());
        System.out.println("Localidade:\t" + pessoa[0].getLocalidade());
        System.out.println("Telefone:\t" + pessoa[0].getTelf());
        System.out.println("Data NAscimento:\t" + pessoa[0].getDiaNasc() + "/" + pessoa[0].getMesNasc() + "/" + pessoa[0].getAnoNasc());
        System.out.println("Estado Civil:\t" + pessoa[0].getEstadociv());*/


    }
}
