import java.util.Scanner;

/*
 * Aluno 01: Adenor Dantas de Farias Júnior
 * Aluno 02: Joyce Mikaela das Mercês Aciole
 * Aluno 03: Wesley Porto Santos
 */

/**
 * Classe para manipular séries matemáticas (Usando as classes ProgressaoAritmetica e Fibonacci).
 *	@author Adenor - Joyce - Wesley
 */
public class ExplorandoOMundoDasSeries {

	private static Scanner sc = new Scanner(System.in);
	private static ProgressaoAritmetica pa = null;
	private static Fibonacci fibo = null;
	
	/**
	 * Metódo main, inicializador do programa.
	 * @param args argumentos da linha de comando.
	 */
	public static void main(String[] args) {
		menuPrincipal();
	}
	
	/*
	 * Menu principal.
	 */
	private static void menuPrincipal() {
		int opcao = -1;
		do {
			imprimeSeparador();
			System.out.print("#           SELECIONE UMA OPÇÃO A SEGUIR             #");
			imprimeSeparador();
			System.out.println("# 1 - Criar uma Progressão Aritmética                #");
			System.out.println("# 2 - Criar uma Sequência de Fibonacci               #");
			System.out.println("# 3 - Ver n-ésimo termo da PA                        #");
			System.out.println("# 4 - Ver n-ésimo termo de Fibonacci                 #");
			System.out.println("# 5 - Ver os n primeiros termos da PA e de Fibonacci #");
			System.out.print("# 0 - Sair                                           #");
			imprimeSeparador();
			do {
				System.out.print("Opção: ");
				if(sc.hasNextInt()) {
					opcao = sc.nextInt();
				}
				sc.nextLine();
			}while(opcao < 0 || opcao > 5);
			
			switch(opcao) {
			case 1:	criaPA();
				break;
			case 2: criaSFibonacci();
				break;
			case 3:	verTermoPA();
				break;
			case 4: verTermoFibonacci();
				break;
			case 5: verTermosGerais();
				break;
			case 0:
				imprimeSeparador();
				System.out.print("Programa finalizado!");
			}
			imprimeSeparador();
		}while(opcao != 0);
	}
	/*
	 * Imprime separador para os menus.
	 */
	private static void imprimeSeparador() {
		System.out.println();
		for(int i = 0; i <= 53; i++) {
			System.out.print("#");
		}
		System.out.println();
	}

	/*
	 * Cria ou reinicializa uma PA.
	 */
	private static void criaPA() {
		imprimeSeparador();
		if(pa == null) {
			System.out.print("Informe o primeiro termo da PA: ");
			int primeiro = sc.nextInt();
			System.out.print("Informa a razão da PA: ");
			int razao = sc.nextInt();
			pa = new ProgressaoAritmetica(primeiro, razao);
			System.out.print("\nProgressão Aritmética criada!");
		}else {
			System.out.println("Já existe uma PA criada!");
			System.out.println("Primeiro termo definido: "+pa.primeiroTermo());
			System.out.print("Razão da PA: "+pa.getRazaoPa());
		}
	}

	/*
	 * Cria ou reinicializa uma sequência de Fibonacci.
	 */
	private static void criaSFibonacci() {
		imprimeSeparador();
		if(fibo == null) {
			fibo = new Fibonacci();
			System.out.print("Sequência de Fibonacci criada!");
		}else {
			System.out.println("Sequência de Fibonacci já criada!");
			System.out.print("Primeiro termo da sequência: "+fibo.primeiroTermo());
		}
	}
	
	/*
	 * Solicita e exibe o n-ésimo termo da PA.
	 */
	private static void verTermoPA() {
		imprimeSeparador();
		if(pa == null) {
			System.out.print("Nenhuma PA criada!");
		}else {
			System.out.print("Termo da PA: ");
			int termo = sc.nextInt();
			System.out.printf("Valor do termo %d da PA: %d", termo, pa.termo(termo));
		}
	}
	
	/*
	 * Solicita e exibe o n-ésimo termo da sequência de Fibonacci. 
	 */
	private static void verTermoFibonacci() {
		imprimeSeparador();
		if(fibo == null) {
			System.out.print("Nenhuma Sequência de Fibonacci criada!");
		}else {
			System.out.print("Termo da sequência: ");
			int termo = sc.nextInt();
			System.out.printf("Valor do termo %d da Sequência: %d", termo, fibo.termo(termo));
		}
	}
	
	/*
	 * Mostra os n primeiros termos das duas séries.
	 */
	private static void verTermosGerais() {
		imprimeSeparador();
		if(pa == null || fibo == null) {
			System.out.print("Para exibir os termos é necessário que tenha\nsido criada uma PA e uma Sequência de Fibonacci!");
		}else {
			System.out.print("Deseja ver quantos termos de cada série? ");
			int n = sc.nextInt();
			System.out.println("\nProgressão Aritmética");
			System.out.println(pa.geraTermos(n));
			System.out.printf("Razão: %d\nPróximo termo da PA: %d\n\n", pa.getRazaoPa(), pa.proximoTermo());
			System.out.println("Sequência de Fibonacci");
			System.out.println(fibo.gerarTermos(n));
			System.out.print("Próximo termo da Sequência: "+fibo.proximoTermo());
		}
	}
}