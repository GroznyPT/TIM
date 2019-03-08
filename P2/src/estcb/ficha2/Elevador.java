package estcb.ficha2;

public class Elevador {

    private int andarAtual;
    private int andarInferior;
    private int andarSuperior;

    public Elevador(int andarInferior, int andarSuperior, int andarAtual) {
        if(andarInferior < andarSuperior) {
            this.andarInferior = andarInferior;
            this.andarSuperior = andarSuperior;
        }
        else {
            this.andarInferior = andarSuperior;
            this.andarSuperior = andarInferior;
        }
        if (andarAtual >= andarInferior && andarAtual <= andarSuperior){
            this.andarAtual = andarAtual;
        }
        else {
            this.andarAtual = andarInferior;
        }

    }


    public Elevador(int andarInferior, int andarSuperior) {
        this(andarInferior,andarSuperior,andarInferior);
          }

    public Elevador(int andarSuperior) {
        this(0,andarSuperior,0);
    }

    @Override
    public String toString() {
        return "[" +
                "Andar Atual:" + andarAtual +
                ", Andar Inferior:" + andarInferior +
                ", Andar Superior:" + andarSuperior +
                ']' + "\n";
    }

    public void acede(int andar){
        if(andar <= andarSuperior && andar >= andarInferior){
            System.out.println("O Andar é acessivel \n");
        }else{
            System.out.println("Esse andar não é valido para este Elevador \n");
        }
    }

    public void sobe(){
        setAndarAtual(andarAtual+1);
    }

    public void desce(){
        setAndarAtual(andarAtual-1);
    }

    public void irPara(int andar){

        int subir = andar - andarAtual;

        for(int i = 1; i <= subir; i++){
            sobe();
        }
    }

    public void estaTopo() {

        if (andarAtual == andarSuperior) {
            System.out.println("##Está no Topo## \n");
        } else {
            System.out.println("$$Não está no topo$$ \n");
        }
    }

    public void estaFundo() {

        if (andarAtual == andarInferior) {
            System.out.println("##Está no Último Piso## \n");
        } else {
            System.out.println("$$Não está no Último Piso$$ \n");
        }
    }

    public int getAndarAtual() {
        return andarAtual;
    }

    public void setAndarAtual(int andar) {
        if (andar >= andarInferior && andar <= andarSuperior){
            andarAtual = andar;
        }
    }

    public int getAndarInferior() {
        return andarInferior;
    }

    public void setAndarInferior(int andar) {
        if (andar >= andarInferior && andar <= andarSuperior){
            andarAtual = andar;
        }
    }

    public int getAndarSuperior() {
        return andarSuperior;
    }

    public void setAndarSuperior(int andar) {
        if (andar >= andarInferior && andar <= andarSuperior){
            andarAtual = andar;
        }
    }
}
