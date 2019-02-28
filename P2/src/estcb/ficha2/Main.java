package estcb.ficha2;

public class Main {

    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa("Luis", "RTMS Pinto", "6000", "Castelo Branco",
                "926420455", 4, 6, 1988,'s');

        System.out.println("Nome:\t" + pessoa.getNome());
        System.out.println("Morada:\t" + pessoa.getMorada());
        System.out.println("Código POstas:\t" + pessoa.getCodPostal());
        System.out.println("Localidade:\t" + pessoa.getLocalidade());
        System.out.println("Telefone:\t" + pessoa.getTelf());
        System.out.println("Data NAscimento:\t" + pessoa.getDiaNasc() + "/" + pessoa.getMesNasc() + "/" + pessoa.getAnoNasc());
        System.out.println("Estado Civil:\t" + pessoa.getEstadociv());


    }
}
