/*
 * Aluno 01: Adenor Dantas de Farias Júnior
 * Aluno 02: Joyce Mikaela das Mercês Aciole
 * Aluno 03: Wesley Porto Santos
 */

/**
 * A classe atual, gera a sequencia de Fibonacci.
 * @author Adenor - Joyce - Wesley
 */
public class Fibonacci {
		
	private int termoAtual;
	
	/**
	 * Construtor padrão da classe.
	 */
	public Fibonacci() {
		this.termoAtual = 1;
	}
	
	/**
	 * Gera termos da sequencia. Se o Usuario digitar um valor para n < 1 a será exibida o primeiro termo da sequencia que será o termo atual.
	 * @param Número de termos que serão gerados na sequencia. 
	 * @return Representa a sequencia de fibonacci como uma String. (formato: [termo1, termo2, ternoN])
	 */
	public String gerarTermos(int n) {
		if (n > 0) {
			termoAtual = n;
		}else {
			termoAtual = 1;
		}
		StringBuilder fibo = new StringBuilder();
		fibo.append("[");
		int aux = 0, anterior = 1, atual = 1;
		for(int i = 1; i <= termoAtual; i++) {
			if(i <= 2) {
				fibo.append("1");
			}else{
				aux = anterior+atual;
				anterior = atual;
				atual = aux;
				fibo.append(atual);
			}
			if(i != termoAtual)
				fibo.append(", ");
		}
		fibo.append("]");
		return fibo.toString();
	}
	
	/**
	 * Define o primeiro termo como termo atual e o retorna.
	 * @return o primeiro termo da série.
	 */
	public int primeiroTermo() {
		return termoAtual = 1;
	}
	
	/**
	 * Calcula o próximo termo da sequencia. O termo gerado passa a ser o termo atual da sequencia.
	 * @return o próximo termo da sequencia.
	 */
	public int proximoTermo() {
		return fibonacci(++termoAtual);
	}
	
	/**
	 * Calcula o n-ésimo termo da sequencia.  Caso seja passado um valor de n < 1 será exibido do primeiro termo da sequecia que tornado-se assim o termo atual.
	 * @param n-ésimo termo a ser calculado.
	 * @return o n-ésimo termo da sequencia.
	 */
	public int termo(int n) {
		if (n > 0) {
			termoAtual = n;
		}else {
			termoAtual = 1;
		}		
//		termoAtual = n > 0 ? n : 1;
		return fibonacci(termoAtual);
	}
	
	/*
	 * Calcula a sequencia de Fibonacci e retorna o n-ésimo termo.
	 */
	private int fibonacci(int n) {
		if(n < 3) {
			return 1;
		}else {
			return fibonacci(n-1)+fibonacci(n-2);
		}
	}
}