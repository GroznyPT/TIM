package securest.app;


import consola.SConsola;
import p2.tempo.Hora;
import p2.tempo.Periodo;
import securest.recurso.CentralControlo;
import securest.recurso.Funcionario;
import securest.recurso.Instalacao;

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
	 * menu principal da aplica��o
	 */
	public void menuPrincipal(){
		String menu = "Central de controlo - controlo de acessos\n" + 
				"1- Info sobre instala��o\n"+
				"2- Info sobre funcion�rio\n" + 
				"3- Entrada de funcion�rio\n"+
				"4- Sa�da de funcion�rio\n"+
				"5- Listar presen�as em todas as instala��es\n"+
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
				consola.println( "op��o inv�lida");
				consola.readLine();
			}
		} while( opcao != '0' );

		consola.close();					// desligar o menu da central		
	}

	/**
	 * imprime a informa��o de uma instala��o 
	 */
	private void printInstalacao( ) {
		Instalacao inst = getInstalacao( "C�digo da instala��o? ");
		consola.clear();
		consola.println( inst.getDescricao() );
		consola.println("id:" + inst.getId() );
		consola.println("nivel acesso: " + inst.getNivel() );
		consola.print("Autorizados: " );
		// para todos os autorizados apresentar
		for (Funcionario f : inst.getAutorizados())
			consola.print( f.getNomes() +  "," );
		consola.println();
		consola.print("Presentes: " );
		// para todos os presentes apresentar
		for (Funcionario f : inst.getPresentes())
			consola.print( f.getNomes() +  "," );
		consola.println();
		consola.println("Hor�rio funcionamento");
		// para todos os periodos do hor�rio apresent�-los
		for (Periodo p: inst.getHorario().getPeriodos())
			String s = String.format("%02d:%02d - %02d:%02d"", p.getIni().getHoras(),p.getIni().getMinutos(),
							" )

		consola.readLine();
	}

	/**
	 * imprime a informa��o de um funcion�rio 
	 */
	private void printFuncionario( ) {
		Funcionario f = getFuncionario( "Codigo do funcionario? ");
		consola.clear();
		consola.println( f.getName() );
		consola.println("id: " + f.getId() );
		consola.println("nivel acesso: " + f.getAcesso() );
		if( f.estaPresente() /* se est� presente numa instala��o */ )
			consola.print("Presente em " + f.getInstalacao().getDescricao() );
		else
			consola.print("Nao esta presente neste momento em lado nenhum" );
		consola.readLine();
	}

	
	/**
	 * processa a entrada de um funcionario
	 */
	private void entradaFuncionario() {
		Funcionario f = getFuncionario( "C�digo do funcion�rio a entrar? ") ;
		Instalacao i = getInstalacao( "C�digo da instala��o onde vai entrar? ");
		
		consola.println( i.entrar(f)? /*pode entrar?*/ "Pode entrar" : "Impedido de entrar!");
		consola.readLine();
	}

	/**
	 * processa a sa�da de um funcion�rio
	 */
	private void saidaFuncionario() {
		Funcionario f = getFuncionario( "Codigo do funcionario a sair? ") ;
		if( f.estaPresente() /* est� oresente num a instala��o */ ){
			// processar sa�da da instala��o onde est�
			Instalacao instalacao = f.getInstalacao();
			instalacao.sair(f);
			consola.println("O funcionario " + f.getName() + " saiu de " + instalacao.getDescrição() );
		}
		else {
			consola.println("O funcionario" + f.getName() + " nao esta em nenhuma instalacao!");
		}
		consola.readLine();
	}


	/**
	 * pergunta ao utilizador qual o id do funcion�rio que vai ser processado
	 * e retorna o funcion�rio correspondente
	 * @param msg a mensagem a pedir o funcion�rio
	 * @return o funcion�rio pedido
	 */
	private Funcionario getFuncionario( String msg ){
		Funcionario f = null;
		do {
			consola.print( msg );
			int id = consola.readInt();
			f = central.getFuncionario( id );
			if( f == null ){
				consola.println("Esse funcion�rio n�o existe!");
				consola.readLine();
			}
		}while( f == null );
		return f;
	}

	/**
	 * pergunta ao utilizador qual o id da instala��o que vai ser processada
	 * e retorna a instala��o correspondente
	 * @param msg a mensagem a pedir a instala��o
	 * @return a instala��o pedida
	 */
	private Instalacao getInstalacao( String msg ){
		Object i = null;
		do {
			consola.print( msg );
			int id = consola.readInt();
			i = central.getInstalacao( id );
			if( i == null ){
				consola.println("Essa instala��o n�o existe!");
				consola.readLine();
			}
		}while( i == null );
		return i;
	}
	
	/**
	 * lista todas as presen�as em todas as instala��es 
	 */
	private void listarPresencas() {
		consola.clear();
		for (Instalacao i : central.getInstalacoes()){
			consola.println("presentes em " + i.getDescricao() + "(" + i.getNivel() + ")");
		}
			/* para todos os funcionarios */
		for (Funcionario f : i.getPresentes())
				consola.println( f.getNome() + "(" + f.getNivel() + ")");
			consola.println( "-----------------" );
		}		
	}

