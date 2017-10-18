/*
 * Aluno 01: Adenor Dantas de Farias Júnior
 * Aluno 02: Joyce Mikaela das Mercês Aciole
 * Aluno 03: Wesley Porto Santos
 */

/**
 * Classe que monta uma progressão aritmética.
 * @author Adenor - Joyce - Wesley
 */
public class ProgressaoAritmetica {

	private int primeiroTermo;
	private int razaoPa;
	private int termoAtual;
	
	/**
	 * Construtor da classe.
	 * @param primeiro primeiro termo da progressão aritmética.
	 * @param razao razão da progressão aritmética.
	 */
	public ProgressaoAritmetica(int primeiroTermo, int razaoPa) {
		this.primeiroTermo = primeiroTermo;
		this.razaoPa = razaoPa;
		this.termoAtual = 1;
	}
	
	/**
	 * Gera os n primeiros termos da progressão aritmética. Valor de n >= 1, caso for passado um número inválido, será exibido
	 * o primeiro termo da PA e este mesmo termo será o termo atual da PA.
	 * @param n números de termos que serão gerados da PA.
	 * @return uma representação String dos n termos gerados da PA. (formato: [termo1, termo2, ...])
	 */
	public String geraTermos(int n) {
		if (n > 0) {
			termoAtual = n;
		}else {
			termoAtual = 1;
		}
		StringBuilder pa = new StringBuilder();
			pa.append("[");
		for(int i = 1; i <= termoAtual; i++) {
			pa.append(calculaProgressao(i));
			if(i != termoAtual) pa.append(", ");
		}
		pa.append("]");
		return pa.toString();
	}
	
	/**
	 * Retorna a razão da progressão aritmética.
	 * @return a razão da PA.
	 */
	public int getRazaoPa() {
		return this.razaoPa;
	}
	
	/**
	 * Reinicia a progressão aritmética para seu primeiro termo. O primeiro termo passa a ser o termo atual da progressao.
	 * @return o primeiro termo da PA.
	 */
	public int primeiroTermo() {
		termoAtual = 1;
		return this.primeiroTermo;
	}
	
	/**
	 * Calcula o próximo termo da progressão aritmética. O termo gerado passa a ser o termo atual da progressão.
	 * @return próximo termo da PA.
	 */
	public int proximoTermo() {
		return calculaProgressao(++termoAtual);
	}
	
	/**
	 * Calcula o n-ésimo termo da progressão aritmética. Valor de n >= 1, caso for passado um número inválido, será exibido
	 * o primeiro termo da PA e este mesmo termo será o termo atual da PA.
	 * @param n n-ésimo termo da PA a ser calculado.
	 * @return o n-ésimo termo da PA.
	 */
	public int termo(int n) {
		if (n > 0) {
			termoAtual = n;
		}else {
			termoAtual = 1;
		}
		
		return calculaProgressao(termoAtual);
	}
	
	/*
	 * Faz o cálculo da progressão aritmética e retorna o n-ésimo termo.
	 */
	private int calculaProgressao(int n) {
		return primeiroTermo+(n-1)*razaoPa;
	}
}