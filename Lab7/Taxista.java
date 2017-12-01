package principal;

/*
 * Aluno 01: Jeffiti Múcio Andrade Morais
 * Aluno 02: Wesley Porto Santos
 */

/**
 * Classe que define todas as caracteristicas de um taxista.
 */
public class Taxista extends Rodoviario{

	private int numeroDePassageiros;
	
	/**
	 * Construtor da classe.
	 * @param nome Nome do taxista.
	 * @param numeroDoContribuinte Numero de cadastro do contribuinte.
	 * @param temCasaPropria Sera passado true se o taxista tiver casa propria, false se nao tiver.
	 * @param temCarro Sera passado true se o taxista tiver carro, false se nao tiver.
	 * @param valorDosBens Valor somado de todos os bens do taxista.
	 * @param quilometragemPercorrida Total de quilometros percorridos pelo taxista.
	 * @param numeroDePassageiros Numero de passageiros transportados pelo taxista.
	 * @throws Exception Sera lanpada caso alguma informacao passada ao construtor seja invalida.
	 */
	public Taxista(String nome, int numeroDoContribuinte, boolean temCasaPropria, boolean temCarro, double valorDosBens, double quilometragemPercorrida, int numeroDePassageiros) throws Exception {
		super(nome, numeroDoContribuinte, temCasaPropria, temCarro, valorDosBens, quilometragemPercorrida);
		setNumeroDePassageiros(numeroDePassageiros);
	}

	/**
	 * Verifica se o numero de passageiros passado como argumento e valido.
	 * @param numeroDePassageiros O numero de passageiros que sera validado.
	 * @throws Exception Sera lancada caso o numero de passageiros passado seja invalido.
	 */
	private void setNumeroDePassageiros(int numeroDePassageiros) throws Exception{
		if(numeroDePassageiros >= 0) {
			this.numeroDePassageiros = numeroDePassageiros;
		}else {
			throw new Exception("O numero de passageiros transportados nao pode ser negativo.");
		}
	}
	
	
	/**
	 * Pega o numero total de passageiros transportados por um taxista.
	 * @return O numero de passageiros tranportados.
	 */
	public int getNumeroDePassageiros() {
		return numeroDePassageiros;
	}

	/**
	 * Calcula o imposto que devera ser pago pelo taxista.
	 */
	@Override
	public double calculaTributos() {
		return (numeroDePassageiros * 0.5);
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(super.toString());
		string.append("\nNumero total de passageiros transportados: "+numeroDePassageiros+"\n");
		return string.toString();
	}
}
