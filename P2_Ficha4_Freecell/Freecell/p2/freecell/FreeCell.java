package p2.freecell;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import p2.carta.Baralho;
import p2.carta.Carta;


public class FreeCell extends JFrame {

	private ZonaJogo mesaJogo = new ZonaJogo();
	
	// idendificar os vários tipos possíveis de origem
	private static final int ORIGEM_CASA = 0;
	private static final int ORIGEM_COLUNA = 1;
	private static final int ORIGEM_CELULA = 2;

	// estamos no primeiro ou 2º click?
	private int click = 1;

	//escolher qual dos baralhos utilizar
	//private Baralho baralho = new Baralho( 73, 97, "cartas.gif", 1 );	
	private Baralho baralho = new Baralho( 73, 97, "cartaswin.gif", 1 );

	private Coluna asColunas[] = new Coluna[ 8 ];
	private Celula asCelulas[] = new Celula[ 4 ];
	private Casa   asCasas[]   = new Casa[ 4 ];
	private int origemIdx;

	public FreeCell( ){
		setTitle( "Freecell" );
		setSize( 680, 600 );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		mesaJogo.setBackground( new Color( 0, 127, 0 ) );
		getContentPane().add( mesaJogo );		
		
		// colocar colunas no sitio
		for( int i = 0; i< asColunas.length; i++ ){ 
			asColunas[ i ] = new Coluna( new Point( 8 + (baralho.getComprimentoCarta()+8)*i, 150 ),
										baralho.getComprimentoCarta(), baralho.getAlturaCarta());
		}

		// colocar celulas no sitio
		for( int i = 0; i< asCelulas.length; i++ ){
			asCelulas[ i ] = new Celula( new Point( 2 + (baralho.getComprimentoCarta()+2+1)*i, 0 ) ,
					                     baralho.getComprimentoCarta()+2, baralho.getAlturaCarta()+2 );
		}
		
		// colocar casas no sitio
		for( int i = 0; i< asCasas.length; i++ ) {
			asCasas[ i ] = new Casa( new Point( 360 + (baralho.getComprimentoCarta()+2+1)*i, 0 ) ,
					                     baralho.getComprimentoCarta()+2, baralho.getAlturaCarta()+2 );			
		}
		
		// dispor os componentes na janela
		colocarComponentes();
		// distribuir cartas
		distribuirCartas();
		
		mesaJogo.addMouseListener( new MouseAdapter() {
			public void mousePressed( MouseEvent e ){
				if( e.getButton() != MouseEvent.BUTTON1 )
					return;
				
				// deixado aqui porque neste momento ainda não falamos 
				// dos listener e eventos
				if( click == 1 )
					escolherOrigem( e.getPoint() );
				else{
					escolherDestino( e.getPoint() );
					testarFim();
				}
			}			
		});
		
		mesaJogo.addComponentListener( new ComponentAdapter() {			
			public void componentResized(ComponentEvent e) {
				colocarComponentes();
				repaint();
			}
		});
	}
	
	private void colocarComponentes() {
		int minComp = (asCasas[0].getComprimento()) * asColunas.length;
		Rectangle mesa = mesaJogo.getBounds();
		
		int comp = mesa.width < minComp? minComp: mesa.width;
		int cx = (comp - asColunas[0].getComprimento() * asColunas.length) / (asColunas.length + 1); 
		int distCol = cx + asColunas[0].getComprimento();
				
		// colocar colunas no sitio
		for( int i = 0; i< asColunas.length; i++ ){ 
			asColunas[ i ].setposicao( new Point( cx + distCol*i, asCelulas[0].getAltura() + 10 ));
		}

		// colocar celulas no sitio
		for( int i = 0; i< asCelulas.length; i++ ){
			asCelulas[ i ].setposicao( new Point( asCelulas[i].getComprimento()*i, 0 ) );
		}
		
		// colocar casas no sitio
		int px = comp - asCasas[0].getComprimento()*asCasas.length;
		for( int i = 0; i< asCasas.length; i++ ) {
			asCasas[ i ].setposicao( new Point( px+asCasas[i].getComprimento()*i,0) );			
		}
	}
	
	/**
	 * método que distribui as cartas pelas várias colunas
	 */
	private void distribuirCartas() {
		baralho.baralhar();
		for( int i=0; i < 52; i++ ) {
			Carta c = baralho.dar( i );
			c.virar();
			asColunas[ i % 8 ].colocar( c );
		}
	}

		
	/**
	 * Método que processa a escolha da carta a jogar
	 * @param pt coordenada onde se clicou com o rato
	 */
	private void escolherOrigem( Point pt ) {

		for (int i = 0; i<asColunas.length; i++){
			if (asColunas[i].estaDentro(pt)){
				asColunas[i].setSeleccionado(true);
				origemIdx = i;
				mesaJogo.repaint();
				click=2;
				return;
			}

		}

	}

	
	/**
	 * Método que processa a escolha do destino da carta
	 * @param pt coordenada onde se clicou com o rato
	 */
	private void escolherDestino( Point pt ) {
		click = 1;
		asColunas[origemIdx].setSeleccionado(false);
		Carta c = asColunas[origemIdx].getCarta();
		for (int i = 0; i < asColunas.length; i++){
			if (asColunas[i].estaDentro(pt)){
				if (asColunas[i].podeReceber(c)){
					asColunas[origemIdx].retirar();
					asColunas[i].receber(c);
				}
				mesaJogo.repaint();
				return;
			}
		}

		for (int i = 0; i < asCelulas.length; i++){
			if (asCelulas[i].estaDentro(pt)){
				if (asCelulas[i].podeReceber(c)){
					asColunas[origemIdx].retirar();
					asCelulas[i].receber(c);
				}
				mesaJogo.repaint();
				return;
			}
		}
		mesaJogo.repaint();
	}
	
	private void testarFim() {
		if( ganhou() )
			JOptionPane.showMessageDialog( this, "Parabéns! Ganhou!",
                                           "Freecell", JOptionPane.INFORMATION_MESSAGE);
		else if( perdeu() )
			JOptionPane.showMessageDialog( this, "Já não tem mais jogadas válidas!!! Perdeu!",
	                                       "Freecell", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * método que vai indicar se o jogador ganhou
	 * @return true se ganhou
	 */
	private boolean ganhou(){		
		return false;
	}
	
	/**
	 * método que vai indicar se o jogador perdeu
	 * @return true se perdeu
	 */
	private boolean perdeu() {
		return false;
	}

	class ZonaJogo extends JPanel {
		
		/**
		 * método onde se vai desenhar os elementos do jogo
		 */
		public void paint( Graphics g ){
			super.paint( g );
			
			// desenhar os vários elementos do jogo
			for( Coluna c : asColunas )
			      c.desenhar( g );

			for( Casa c : asCasas )
			      c.desenhar( g );
			
			for( Celula c : asCelulas )
			      c.desenhar( g );
		}
		
	}

	public static void main(String[] args) {
		FreeCell jogo = new FreeCell( );
		jogo.setVisible( true );
	}	
}
