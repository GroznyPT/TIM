package p2.freecell;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import p2.carta.Carta;


/**
 * Representa uma c�lula, local onde se pode armazenar uma e uma s� carta
 * 
 * @author F. S�rgio Barbosa
 */
public class Celula extends ContentorCartasDefault{
	/**
	 * Cria a c�lula numa determinada posi��o do �cran, definindo o seu comprimento e largura  
	 * @param t coordenada do topo da c�lula
	 * @param comp comprimento da c�lula 
	 * @param alt altura da c�lula
	 */
	public Celula( Point t, int comp, int alt) {
		super(t,comp,alt);
	}

	/**
	 * indica se pode receber a carta
	 * @param c a carta a verificr
	 * @return true se pode receber, false em caso contr�rio
	 */
	public boolean podeReceber(Carta c) {		
		return estaVazio();
	}


	/**
	 * coloca a carta mesmo que n�o obede�a �s regras
	 * @param c carta a colocar
	 */
	public void colocar( Carta c ){
		c.setPosicao( new Point( getPosicao().x+1, getPosicao().y+1 ) );
		super.colocar(c);
	}
	

	/**
	 * desenha a c�lula no �cran
	 * @param g sistema gr�fico onde se vai desenhar
	 */
	public void desenhar( Graphics g ){
		int x1 = getPosicao().x;
		int y1 = getPosicao().y;
		int x2 = getPosicao().x + getComprimento();
		int y2 = getPosicao().y + getAltura();
		
		g.setColor( Color.black );
		g.drawLine( x1, y1, x2, y1 );
		g.drawLine( x1, y1, x1, y2 );
		g.setColor( Color.green );	
		g.drawLine( x2, y1+1, x2, y2 );
		g.drawLine( x1+1, y2, x2, y2 );			
		
		super.desenhar(g);
	}		
}
