package estcb.ficha2;

public class TestaElevador {

    public static void main(String[] args) {

        Elevador e1 = new Elevador(-3,10,5);
        Elevador e2 = new Elevador(-1,12);
        Elevador e3 = new Elevador(4);

        e1.setAndarInferior(1);
        e2.setAndarAtual(12);
        e3.setAndarInferior(1);
        e3.setAndarAtual(0);

        e2.estaTopo();
        e1.estaTopo();
        e3.estaFundo();
        System.out.println(e1);

        e2.sobe();
        System.out.println(e2);

        e3.irPara(1);
        System.out.println(e3);

      //  e1.acede(1);
      //  e2.acede(14);


    }
}
