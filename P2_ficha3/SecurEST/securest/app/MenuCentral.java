package securest.app;


import consola.SConsola;
import p2.tempo.Hora;
import securest.recurso.CentralControlo;

/**
 * Classe que trata dos menus da central de comandos
 */
public class MenuCentral {
	
	private SConsola consola = new SConsola();
	private CentralControlo central;
	
	public MenuCentral( CentralControlo central ){
		this.central = central;
	}

	/**
	 * menu principal da aplicação
	 */
	public void menuPrincipal(){
		String menu = "Central de controlo - controlo de acessos\n" + 
				"1- Info sobre instalação\n"+
				"2- Info sobre funcionário\n" + 
				"3- Entrada de funcionário\n"+
				"4- Saída de funcionário\n"+
				"5- Listar presenças em todas as instalações\n"+
				"\n0- Sair";

		char opcao = 0;
		do {
			consola.clear();
			consola.println( menu );
			opcao = consola.readChar();
			switch( opcao ){
			case '1':
				printInstalacao();
				break;
			case '2':
				printFuncionario();
				break;
			case '3':
				entradaFuncionario();
				break;
			case '4':
				saidaFuncionario();
				break;
			case '5':
				listarPresencas();
				consola.readLine();
				break;
			case '0': break;
			default:
				consola.println( "opção inválida");
				consola.readLine();
			}
		} while( opcao != '0' );

		consola.close();					// desligar o menu da central		
	}

	/**
	 * imprime a informação de uma instalação 
	 */
	private void printInstalacao( ) {
		Object inst = getInstalacao( "Código da instalação? ");
		consola.clear();
		consola.println( "<NOME da istalação>" );		
		consola.println("id: <ID inst>" );
		consola.println("nivel acesso: <NIVEL inst>" );
		consola.print("Autorizados: " );
		// para todos os autorizados apresentar
			consola.print( "<NOME FUNC>, " );
		consola.println();
		consola.print("Presentes: " );
		// para todos os presentes apresentar
			consola.print( "<NOME FUNC>, " );
		consola.println();
		consola.println("Horário funcionamento");
		// para todos os periodos do horário apresentá-los

		consola.readLine();
	}

	/**
	 * imprime a informação de um funcionário 
	 */
	private void printFuncionario( ) {
		Object f = getFuncionario( "Código do funcionário? ");
		consola.clear();
		consola.println( "<NOME FUNC>" );		
		consola.println("id: <ID FUNC>" );
		consola.println("nivel acesso: <NIVEL FUNC>" );
		if( true /* se está presente numa instalação */ )
			consola.print("Presente em <NOME INST>" );
		else
			consola.print("Não está presente neste momento em lado nenhum" );
		consola.readLine();
	}

	
	/**
	 * processa a entrada de um funcionário
	 */
	private void entradaFuncionario() {
		Object f = getFuncionario( "Código do funcionário a entrar? ") ;
		Object i = getInstalacao( "Código da instalação onde vai entrar? ");
		
		consola.println( /*pode entrar?*/ true? "Pode entrar" : "Impedido de entrar!");
		consola.readLine();
	}

	/**
	 * processa a saída de um funcionário
	 */
	private void saidaFuncionario() {
		Object f = getFuncionario( "Código do funcionário a sair? ") ;
		if( true /* está oresente num a instalação */ ){
			// processar saída da instalação onde está
			consola.println("O funcionário <NOME FUNC> saiu de <NOME INST>" );
		}
		else {
			consola.println("O funcionário <NOME FUNC> não está em nenhuma instalação!");
		}
		consola.readLine();
	}


	/**
	 * pergunta ao utilizador qual o id do funcionário que vai ser processado
	 * e retorna o funcionário correspondente
	 * @param msg a mensagem a pedir o funcionário
	 * @return o funcionário pedido
	 */
	private Object getFuncionario( String msg ){
		Object f = null;
		do {
			consola.print( msg );
			int id = consola.readInt();
			f = central.getFuncionario( id );
			if( f == null ){
				consola.println("Esse funcionário não existe!");
				consola.readLine();
			}
		}while( f == null );
		return f;
	}

	/**
	 * pergunta ao utilizador qual o id da instalação que vai ser processada
	 * e retorna a instalação correspondente
	 * @param msg a mensagem a pedir a instalação
	 * @return a instalação pedida
	 */
	private Object getInstalacao( String msg ){
		Object i = null;
		do {
			consola.print( msg );
			int id = consola.readInt();
			i = central.getInstalacao( id );
			if( i == null ){
				consola.println("Essa instalação não existe!");
				consola.readLine();
			}
		}while( i == null );
		return i;
	}
	
	/**
	 * lista todas as presenças em todas as instalações 
	 */
	private void listarPresencas() {
		consola.clear();
		/* para todas as instalações */ {
			consola.println( "presentes em <NOME INST>  (NIVEL INST>" );
			/* para todos os funcionários */
				consola.println( "<NOME FUNC>   (NIVEL FUNC)" );
			consola.println( "-----------------" );
		}		
	}
	
}
