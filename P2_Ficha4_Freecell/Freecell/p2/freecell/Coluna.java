package p2.freecell;

import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;

import p2.carta.Carta;

/**
 * Representa uma coluna, local onde se podem armazenar v�rias cartas desde que seja por 
 * ordem decrescente e de cor alternada
 * 
 * @author F. S�rgio Barbosa
 *
 */
public class Coluna extends ContentorCartasDefault {

	/**
	 * Cria a coluna numa determinada posi��o do �cran, definindo o seu comprimento e largura
	 *
	 * @param t    coordenada do topo da coluna
	 * @param comp comprimento da coluna
	 * @param alt  altura da coluna
	 */
	public Coluna(Point t, int comp, int alt) {
		super(t, comp, alt);
	}

	/**
	 * indica se pode receber a carta.
	 * @param c a carta a verificr
	 * @return true se pode receber, false em caso contr�rio
	 */


	public boolean podeReceber(Carta c) {
		// se est� vazio pode receber qualquer carta
		if( estaVazio() )
			return true;
		
		// se n�o est� vazio tem de receber de cor diferente e consecutiva
		Carta ultima = getCarta( );
		return ( ultima.getCor() != c.getCor() ) &&
		       ( ultima.getFace() - 1 == c.getFace() ); 
	}

	/**
	 * coloca a carta mesmo que n�o obede�a �s regras
	 * @param c carta a colocar
	 */
	public void colocar( Carta c ){
		if( estaVazio() ){
			c.setPosicao( getPosicao() );			
		}
		else {			
			Carta ultima = getCarta( );
		
			Point nova = new Point( ultima.getPosicao().x, ultima.getPosicao().y + ultima.getAltura() / 3 );
			c.setPosicao( nova );
		}
		super.colocar(c);
	}

	
}
