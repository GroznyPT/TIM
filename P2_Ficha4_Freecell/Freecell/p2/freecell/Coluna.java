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
public class Coluna {

	private Vector<Carta> asCartas = new Vector<Carta>();
	private Point topo;
	private int comprimento;
	private int altura;
	private boolean selecionado = false;
	

	/**
	 * Cria a coluna numa determinada posi��o do �cran, definindo o seu comprimento e largura  
	 * @param t coordenada do topo da coluna
	 * @param comp comprimento da coluna
	 * @param alt altura da coluna
	 */
	public Coluna(Point t, int comp, int alt) {
		topo = t;
		comprimento = comp;
		altura = alt;		
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
		asCartas.add( c );		
	}

	/**
	 * retira a carta e devolve-a
	 * @return a carta retirada
	 */
	public Carta retirar( ){		
		return (Carta) asCartas.remove( asCartas.size()-1 );
	}

	
	/**
	 * devolve a carta no topo da coluna, sem a retirar
	 * @return a carta ou null se vazia
	 */
	public Carta getCarta( ){
		return (Carta) asCartas.get( asCartas.size()-1 );
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
	 * @param p
	 */
	public void setposicao( Point p ){
		// reposicionar o topo
		topo = p;
		
		// reposicionar as cartas
		int y = topo.y; 
		int altura = estaVazio()? 0: getCarta().getAltura() / 3;
		for( int i = 0; i < asCartas.size(); i++ )
			asCartas.get( i ).setPosicao( new Point( topo.x, topo.y + i*altura ) );
	}

	
	/**
	 * remove todas as cartas
	 */
	public void limpar() {
		asCartas.clear();
	}
	
	
	/**
	 * indica se uma dada coordenada est� dentro do espa�o da coluna 
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
	 * (des)selecciona a coluna
	 * @param sel true para seleccionar, false para desseleccionar 
	 */
	public void setSeleccionado( boolean sel ) {
		selecionado = sel; 
		if( !estaVazio() )
			getCarta().setSelecionada( sel );
	}

		
	/**
	 * desenha a coluna no �cran
	 * @param g sistema gr�fico onde se vai desenhar
	 */
	public void desenhar( Graphics g ){
		for( int i=0; i < asCartas.size(); i++ ){
			Carta card = (Carta) asCartas.get( i );
			card.desenhar( g );
		}					
	}	
	
}
