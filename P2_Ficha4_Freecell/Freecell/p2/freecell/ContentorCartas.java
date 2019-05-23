package p2.freecell;

import p2.carta.Carta;

import java.awt.*;

public interface ContentorCartas {
    /**
     * indica se pode receber a carta.
     * @param c a carta a verificr
     * @return true se pode receber, false em caso contrário
     */
    boolean podeReceber(Carta c);

    boolean receber(Carta c);

    void colocar(Carta c);

    Carta retirar();

    Carta getCarta();

    Point getPosicao();

    boolean estaVazio();

    int getComprimento();

    int getAltura();

    void setposicao(Point p);

    void limpar();

    boolean estaDentro(Point pt);

    void setSeleccionado(boolean sel);

    void desenhar(Graphics g);
}
