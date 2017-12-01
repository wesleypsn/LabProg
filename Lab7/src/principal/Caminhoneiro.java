package principal;

/*
 * Aluno 01: Jeffiti Múcio Andrade Morais
 * Aluno 02: Wesley Porto Santos
 */

/**
 * Classe que define todas as caracteristicas de um Caminhoneiro.
 */
public class Caminhoneiro extends Rodoviario{

	private double toneladasTransportadas;
	
	/**
	 * Construtor da classe.
	 * @param nome Nome do caminhoneiro.
	 * @param numeroDoContribuinte Numero de cadastro do contribuinte.
	 * @param temCasaPropria Sera passado true se o caminhoneiro tiver casa propria, false se nao tiver.
	 * @param temCarro Sera passado true se o caminhoneiro tiver carro, false se nao tiver.
	 * @param valorDosBens Valor somado de todos os bens do caminhoneiro.
	 * @param quilometragemPercorrida Total de quilometros percorridos pelo caminhoneiro.
	 * @param toneladasTransportadas Total de toneladas transportadas pelo Caminhoneiro.
	 * @throws Exception Sera lancada caso alguma informacao passada ao construtor seja invalida.
	 */
	public Caminhoneiro(String nome, int numeroDoContribuinte, boolean temCasaPropria, boolean temCarro, double valorDosBens, double quilometragemPercorrida, double toneladasTransportadas) throws Exception {
		super(nome, numeroDoContribuinte, temCasaPropria, temCarro, valorDosBens, quilometragemPercorrida);
		setToneladasTransportadas(toneladasTransportadas);
	}

	/**
	 * Valida a quantidade de toneladas passada por argumento para o construtor.
	 * @param toneladasTransportadas O valor que sera verificado.
	 * @throws Exception Sera lancada caso o valor passado seja invalido.
	 */
	private void setToneladasTransportadas(double toneladasTransportadas) throws Exception{
		if(toneladasTransportadas >= 0) {
			this.toneladasTransportadas = toneladasTransportadas;
		}else {
			throw new Exception("O namero de toneladas transportadas nao pode ser negativo.");
		}
	}
	
	/**
	 * Retorna a quantidade total de toneladas transportadas por um caminhoneiro.
	 * @return A quantidade de toneladas transportadas.
	 */
	public double getToneladasTransportadas() {
		return toneladasTransportadas;
	}

	/**
	 * Calcula o devido valor do imposto que devera ser pago pelo caminhoneiro.
	 */
	@Override
	public double calculaTributos() {
		final int TAXA_FIXA = 500;
		if(toneladasTransportadas <= 10) {
			return TAXA_FIXA;
		}else {
			double toneladasExtras = toneladasTransportadas - 10;
			return TAXA_FIXA + (toneladasExtras * 10);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(super.toString());
		string.append(String.format("\nTotal de toneladas transportadas: %,.1f T\n", toneladasTransportadas));
		return string.toString();
	}
}
