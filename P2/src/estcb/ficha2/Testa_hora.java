package estcb.ficha2;

public class Testa_hora {

    public static void main(String[] args) {

        Hora h = new Hora(12,12,12);
        Hora h1 = new Hora(23,15,10);
        Hora h2 = new Hora(23,15,10);

        System.out.println(h);
        System.out.println(h1);

        int ndias = h.somaHoras(37);
        int nminutos = h1.somaminutos(60);
        int nsegundos = h2.somasegundos(40);

        System.out.println("***********COMPARAR***********");
        System.out.println(h.compareTo(h1));
        System.out.println(h1.compareTo(h2));
        System.out.println("***********SOMAR***********");
      //  System.out.println("Passaram " + ndias + " dias e " + h.getHora() + " horas");
       // System.out.println("Total " + nminutos + " minutos e " + h.getMinito() + " minutos");
        System.out.println("Toral de segundos: " + h2.getSegundo());


    }
}
