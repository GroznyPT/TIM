package p2.freecell;

import p2.carta.Carta;

import java.awt.*;
import java.util.Vector;

/**
 * Representa uma coluna, local onde se podem armazenar várias cartas desde que seja por 
 * ordem decrescente e de cor alternada
 * 
 * @author F. Sérgio Barbosa
 *
 */
public abstract class ContentorCartasDefault implements ContentorCartas {

	private Vector<Carta> asCartas = new Vector<Carta>();
	private Point topo;
	private int comprimento;
	private int altura;
	private boolean selecionado = false;


	/**
	 * Cria a coluna numa determinada posição do écran, definindo o seu comprimento e largura
	 * @param t coordenada do topo da coluna
	 * @param comp comprimento da coluna
	 * @param alt altura da coluna
	 */
	public ContentorCartasDefault(Point t, int comp, int alt) {
		topo = t;
		comprimento = comp;
		altura = alt;		
	}


	/**
	 * recebe a carta, se obedecer às regras
	 * @param c a carta a receber
	 * @return true se recebeu, false caso contrário
	 */	
	@Override
	public boolean receber(Carta c){
		if( !podeReceber( c ) )
			return false;
		colocar( c );
		return true;
	}	

	
	/**
	 * coloca a carta mesmo que não obedeça às regras
	 * @param c carta a colocar
	 */
	@Override
	public void colocar(Carta c){
		asCartas.add( c );
	}

	/**
	 * retira a carta e devolve-a
	 * @return a carta retirada
	 */
	@Override
	public Carta retirar(){
		return (Carta) asCartas.remove( asCartas.size()-1 );
	}

	
	/**
	 * devolve a carta no topo da coluna, sem a retirar
	 * @return a carta ou null se vazia
	 */
	@Override
	public Carta getCarta(){
		return (Carta) asCartas.get( asCartas.size()-1 );
	}	

	
	/**
	 * devolve a posição no écran
	 * @return
	 */
	@Override
	public Point getPosicao() {
		return topo;
	}	

	/**
	 * indica se está vazia
	 * @return se está vazia
	 */
	@Override
	public boolean estaVazio() {
		return asCartas.isEmpty();
	}

	
	/**
	 * devolve o comprimento
	 * @return o comprimento em pixeis
	 */
	@Override
	public int getComprimento() {
		return comprimento;
	}
	
	/**
	 * devolve a altura em pixeis
	 * @return a altura em pixeis
	 */
	@Override
	public int getAltura(){
		return altura;
	}
	
	
	/**
	 * define uma nova posição no écran
	 * @param p
	 */
	@Override
	public void setposicao(Point p){
		//TODO - ajustar para funcionar em todos os contentores

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
	@Override
	public void limpar() {
		asCartas.clear();
	}
	
	
	/**
	 * indica se uma dada coordenada está dentro do espaço da coluna 
	 * @param pt a coordenada a verificar
	 * @return true se a coordenada está dentro, false caso contrário 
	 */
	@Override
	public boolean estaDentro(Point pt) {
		// ver se clicou em alguma das cartas do componente
		for( int i = 0; i < asCartas.size(); i++ )
			if( ((Carta)asCartas.get( i )).estaDentro( pt ) )
				return true;
		
		// se não ver se clicou na área do componente
		return topo.x <= pt.x && topo.y <= pt.y && topo.x + comprimento >= pt.x && topo.y + altura >= pt.y;
	}

	
	/**
	 * (des)selecciona a coluna
	 * @param sel true para seleccionar, false para desseleccionar 
	 */
	@Override
	public void setSeleccionado(boolean sel) {
		selecionado = sel; 
		if( !estaVazio() )
			getCarta().setSelecionada( sel );
	}

		
	/**
	 * desenha a coluna no écran
	 * @param g sistema gráfico onde se vai desenhar
	 */
	@Override
	public void desenhar(Graphics g){
		for( int i=0; i < asCartas.size(); i++ ){
			Carta card = (Carta) asCartas.get( i );
			card.desenhar( g );
		}					
	}	
	
}
