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
public class Celula {
	
	private Carta aCarta;
	private Point topo;
	private int comprimento;
	private int altura;
	private boolean selecionado = false;

	/**
	 * Cria a c�lula numa determinada posi��o do �cran, definindo o seu comprimento e largura  
	 * @param t coordenada do topo da c�lula
	 * @param comp comprimento da c�lula 
	 * @param alt altura da c�lula
	 */
	public Celula( Point t, int comp, int alt) {
		topo = t;
		comprimento = comp;
		altura = alt;		
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
	 * recebe a carta, se obedecer �s regras
	 * @param c a carta a receber
	 * @return true se recebeu, false caso contr�rio
	 */
	public boolean receber( Carta c ){
		if( !podeReceber( c ) )
			return false;
		colocar( c );
		return true;
	}


	/**
	 * retira a carta e devolve-a
	 * @return a carta retirada
	 */
	public Carta retirar( ){
		Carta old = aCarta;
		aCarta = null;
		return old;
	}

	
	/**
	 * devolve a carta 
	 * @return a carta ou null se vazia
	 */
	public Carta getCarta( ){
		return aCarta;
	}	

	/**
	 * coloca a carta mesmo que n�o obede�a �s regras
	 * @param c carta a colocar
	 */
	public void colocar( Carta c ){
		c.setPosicao( new Point( getPosicao().x+1, getPosicao().y+1 ) );
		aCarta = c;
	}
	
	/**
	 * devolve a posi��o no �cran
	 * @return
	 */
	public Point getPosicao() {
		return topo;
	}	

	/**
	 * indica se est� vazia
	 * @return se est� vazia
	 */
	public boolean estaVazio() {
		return aCarta == null;
	}

	/**
	 * devolve o comprimento
	 * @return o comprimento em pixeis
	 */
	public int getComprimento() {
		return comprimento;
	}
	
	/**
	 * devolve a altura em pixeis
	 * @return a altura em pixeis
	 */
	public int getAltura(){
		return altura;
	}
	
	/**
	 * define uma nova posi��o no �cran
	 * @param p a nova posi��o do �cran oned colcoar a carta
	 */
	public void setposicao( Point p ){
		topo = p;
		if( !estaVazio() )		
			aCarta.setPosicao( new Point( p.x+1, p.y+1 ) );
	}

	/**
	 * remove todas as cartas da c�lula
	 */
	public void limpar() {
		aCarta = null;
	}
	
	
	/**
	 * indica se uma dada coordenada est� dentro do espa�o da c�lula 
	 * @param pt a coordenada a verificar
	 * @return true se a coordenada est� dentro, false caso contr�rio 
	 */
	public boolean estaDentro( Point pt ) {
		// ver se existe carta na celula, se existir ver se clicou nela
		if( !estaVazio() )  
			return aCarta.estaDentro( pt );
		
		// se n�o ver se clicou na �rea do componente
		return topo.x <= pt.x && topo.y <= pt.y && topo.x + comprimento >= pt.x && topo.y + altura >= pt.y;
	}

	/**
	 * (des)selecciona a c�lula
	 * @param sel true para seleccionar, false para desseleccionar 
	 */
	public void setSeleccionado( boolean sel ) {
		selecionado = sel; 
		if( !estaVazio() )
			getCarta().setSelecionada( sel );
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
		
		if( !estaVazio() )
			aCarta.desenhar( g );				
	}		
}
