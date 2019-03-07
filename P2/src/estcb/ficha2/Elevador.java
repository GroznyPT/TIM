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
                "Andar Atual:" + andarAtual + "\n"+
                ", Andar Inferior:" + andarInferior + "\n"+
                ", Andar Superior:" + andarSuperior + "\n"+
                ']';
    }

    public int getAndarAtual() {
        return andarAtual;
    }

    public void setAndarAtual(int andarAtual) {
        this.andarAtual = andarAtual;
    }

    public int getAndarInferior() {
        return andarInferior;
    }

    public void setAndarInferior(int andarInferior) {
        this.andarInferior = andarInferior;
    }

    public int getAndarSuperior() {
        return andarSuperior;
    }

    public void setAndarSuperior(int andarSuperior) {
        this.andarSuperior = andarSuperior;
    }
}
