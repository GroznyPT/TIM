package securest.app;

import securest.recurso.CentralControlo;

public class AppMain {

	/**
	 * despoleta a aplica��o
	 */
	public static void main( String []args ){
		
		// criar a central de controlo
		CentralControlo central = new CentralControlo( );
		
		/*
		 * Criar aqui as instala��es e funcion�rios indicados no enunciado 
		 */
		
		
		
		// criar a aplica��o propriamente dita
		MenuCentral app = new MenuCentral( central );
		app.menuPrincipal();
	}

}
