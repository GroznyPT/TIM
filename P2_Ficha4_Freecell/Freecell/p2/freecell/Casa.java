package p2.freecell;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;

import p2.carta.Carta;

/**
 * Representa uma casa, local onde se podem armazenar as cartas de um naipe por 
 * ordem crescente 
 * 
 * @author F. S�rgio Barbosa
 */
public class Casa {

	private Vector<Carta> asCartas = new Vector<Carta>();
	private Point topo;
	private int comprimento;
	private int altura;	
	private boolean selecionado = false;
	
	
	/**
	 * Cria a casa numa determinada posi��o do �cran, definindo o seu comprimento e largura  
	 * @param t coordenada do topo da casa
	 * @param comp comprimento da casa
	 * @param alt altura da casa
	 */
	public Casa(Point t, int comp, int alt) {
		topo = t;
		comprimento = comp;
		altura = alt;		
	}
	
	
	/**
	 * indica se pode receber a carta.
	 * @param c a carta a verificr
	 * @return true se pode receber, false caso contr�rio
	 */
	public boolean podeReceber(Carta c) {
		if( estaVazio() ) 
			return c.getFace() == Carta.AS;
		else {				
			Carta ultima = getCarta();
			return ultima.getNaipe() == c.getNaipe() && ultima.getFace() + 1 == c.getFace();  
		}
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
	 * retira a carta do topo da casa e devolve-a
	 * @return a carta retirada
	 */
	public Carta retirar( ){		
		return (Carta) asCartas.remove( asCartas.size()-1 );
	}

	
	/**
	 * devolve a carta no topo da casa, sem a retirar
	 * @return a carta ou null se vazia
	 */
	public Carta getCarta( ){
		return (Carta) asCartas.get( asCartas.size()-1 );
	}	

	/**
	 * coloca a carta mesmo que n�o obede�a �s regras
	 * @param c carta a colocar
	 */
	public void colocar( Carta c ){
		c.setPosicao( new Point( getPosicao().x+1, getPosicao().y+1 ) );
		asCartas.add( c );
	}
	
	/**
	 * devolve a posi��o da casa no �cran
	 * @return a posi��o no �cran (em pixeis) onde est� colocada a carta
	 */
	public Point getPosicao() {
		return topo;
	}	

	/**
	 * indica se est� vazia
	 * @return se est� vazia
	 */
	public boolean estaVazio() {
		return asCartas.isEmpty();
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
	 * @param p a nova posi��o (em pixeis) onde colocar a casa no �can
	 */
	public void setposicao( Point p ){
		// reposicionar o topo
		topo = p;
		
		// reposicionar as cartas
		for( int i = 0; i < asCartas.size(); i++ )
			asCartas.get( i ).setPosicao( new Point( topo.x+1, topo.y + 1 ) );
	}

	
	/**
	 * remove todas as cartas
	 */
	public void limpar() {
		asCartas.clear();
	}
	
	
	/**
	 * indica se uma dada coordenada est� dentro do espa�o da casa 
	 * @param pt a coordenada a verificar
	 * @return true se a coordenada est� dentro, false caso contr�rio 
	 */
	public boolean estaDentro( Point pt ) {
		// ver se clicou em alguma das cartas do componente
		for( int i = 0; i < asCartas.size(); i++ )
			if( ((Carta)asCartas.get( i )).estaDentro( pt ) )
				return true;
		
		// se n�o ver se clicou na �rea do componente
		return topo.x <= pt.x && topo.y <= pt.y && topo.x + comprimento >= pt.x && topo.y + altura >= pt.y;
	}

	
	/**
	 * (des)selecciona a casa
	 * @param sel true para seleccionar, false para desseleccionar 
	 */
	public void setSeleccionado( boolean sel ) {
		selecionado = sel; 
		if( !estaVazio() )
			getCarta().setSelecionada( sel );
	}

	
	/**
	 * desenha a casa no �cran
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
		
		for( int i=0; i < asCartas.size(); i++ ){
			Carta card = (Carta) asCartas.get( i );
			card.desenhar( g );
		}					
	}
	
}
