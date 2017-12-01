package principal;

import java.util.List;

/*
 * Aluno 01: Jeffiti Múcio Andrade Morais
 * Aluno 02: Wesley Porto Santos
 */

/**
 * Classe abstrata que define as caracteristicas padrao dos contribuintes.
 */
public abstract class Contribuinte {

	private static int Num_Contribuintes_Cad = 0;
	private String nome;
	private int numeroDoContribuinte;
	private boolean temCasaPropria = false;
	private boolean temCarro = false;
	private double valorDosBens;
	
	/**
	 * Construtor da classe.
	 * @param nome Nome do contribuinte.
	 * @param numeroDoContribuinte Numero de cadastro do contribuinte.
	 * @param temCasaPropria Sera passado true se o contribuinte tiver casa propria, false se nao tiver.
	 * @param temCarro Sera passado true se o contribuinte tiver carro, false se nao tiver.
	 * @param valorDosBens Valor somado de todos os bens do contribuinte.
	 * @throws Exception Sera lancada caso alguma informacao passada ao construtor seja invalida.
	 */
	public Contribuinte(String nome, int numeroDoContribuinte, boolean temCasaPropria, boolean temCarro, double valorDosBens) throws Exception{
		validaDados(nome, numeroDoContribuinte, valorDosBens);
		this.temCasaPropria = temCasaPropria;
		this.temCarro = temCarro;
		Num_Contribuintes_Cad++;
	}

	/**
	 * Validacao dos dados passados pelo usuario.
	 * @param nome Nome do contribuinte.
	 * @param numeroDoContribuinte Numero de cadastro do contribuinte.
	 * @param valorDosBens Valor dos bens do contribuinte.
	 */
	private void validaDados(String nome, int numeroDoContribuinte, double valorDosBens) throws Exception{
		if(nome != null && !nome.trim().isEmpty()) {
			this.nome = nome;
		}else {
			throw new Exception("O nome nao pode ser vazio.");
		}
		if(numeroDoContribuinte >= 0 && numeroDoContribuinte <= Integer.MAX_VALUE) {
			this.numeroDoContribuinte = numeroDoContribuinte;
		}else {
			throw new Exception("Numero de contribuinte invalido.");
		}
		if(valorDosBens >= 0) {
			this.valorDosBens = valorDosBens;
		}else {
			throw new Exception("O valor dos bens nao pode ser negativo.");
		}
	}
	
	/**
	 * Verifica se o sinal exterior de riqueza de um contribuinte e excessivo ou nao, tomando como base a media de todos os outros contribuintes de sua categoria.
	 * @param mediaDosContribuintes Media do valor dos bens dos contribuintes de uma mesma categoria.
	 * @return true caso o sinal de exterior de riqueza de um contribuinte seja excessivo, false se nao for excessivo.
	 */
	public boolean sinaisExterioresDeRiquezaExcessivos(double mediaDosContribuintes) {
		double valorTotal = mediaDosContribuintes + (mediaDosContribuintes * 0.5);
		return valorDosBens > valorTotal;
	}
	
	/**
	 * Metodo estatico que calcula a media dos bens dos contribuintes de uma categoria e acrecenta 50% ao valor medio.
	 * @return A media dos bens dos contribuintes acrescido de 50% desse valor.
	 */
	public static double calculaMediaDosBensDeContribuintes(List<?> lista) {
		int somaDosBens=0;
		for(int i = 0; i < lista.size(); i++) {
			somaDosBens += ((Contribuinte) lista.get(i)).getValorDosBens();
		}
		double mediaDosBens = somaDosBens/lista.size();
		return mediaDosBens *= 1.5;
	}

	/**
	 * Retorna o nome do contribuinte.
	 * @return O nome do contribuinte.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Retorna o numero de cadastro do contribuinte.
	 * @return O numero de cadastro do contribuinte.
	 */
	public int getNumeroDoContribuinte() {
		return numeroDoContribuinte;
	}

	/**
	 * Retorna um booleano que diz se um contribuinte tem ou nao casa propria.
	 * @return true se tiver casa propria, false se nao tiver.
	 */
	public boolean temCasaPropria() {
		return temCasaPropria;
	}

	/**
	 * Retorna um booleano que diz se um contribuinte tem ou nao carro.
	 * @return true se tiver carro, false se nao tiver.
	 */
	public boolean temCarro() {
		return temCarro;
	}

	/**
	 * Retorna o valor somado de todos os bens do contribuintes.
	 * @return O valor total dos bens do contribuinte.
	 */
	public double getValorDosBens() {
		return valorDosBens;
	}
	
	/**
	 * Metodo estatico que retorna o numero de contribuintes ja cadastrados no sistema.
	 * @return O numero de contribuintes ja cadastrados.
	 */
	public static int numeroContribuintesCadastrados() {
		return Num_Contribuintes_Cad;
	}
	
	/**
	 * Faz o calculo devido do imposto a ser pago, sendo esse valor o tributo subtraido do desconto referente a cada contribuinte.
	 * @return O valor de todos tributos subtraido do desconto devido. Se o valor do desconto for maior que seus tributos, o contribuinte nao paga imposto.
	 */
	public double calculaImpostoASerPago() {
		double imposto = calculaTributos();
		double desconto = calculaDesconto();
		return imposto < desconto ? 0 : (imposto-desconto);
	}
	
	/**
	 * Metodo abstrato que sugere o calculo dos tributos de cada contribuinte.
	 * @return O valor devido do imposto a ser pago.
	 */
	public abstract double calculaTributos();
	
	/**
	 * Metodo abstrato que sugere o calculo do desconto aplicado ao tributo de um contribuinte.
	 * @return O valor do desconto a ser aplicado sobre o tributo de um contribuinte.
	 */
	public abstract double calculaDesconto();
	
	/**
	 * Representacao em String dos dados do contribuinte.
	 */
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("Profissao do contribuinte: "+getClass().getSimpleName());
		string.append("\nNome do contribuinte: "+nome);
		string.append("\nNumero do contribuinte: "+numeroDoContribuinte);
		string.append(String.format("\nTem casa propria: %s", temCasaPropria ? "Sim" : "Nao"));
		string.append(String.format("\nTem carro proprio: %s", temCarro ? "Sim" : "Nao"));
		string.append(String.format("\nValor total dos bens = R$ %,.2f", valorDosBens));
		return string.toString();
	}
}