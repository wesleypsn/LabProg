package principal;

/*
 * Aluno 01: Jeffiti Múcio Andrade Morais
 * Aluno 02: Wesley Porto Santos
 */

/**
 * Classe que define as caracteristicas de todos os rodoviarios.
 */
public abstract class Rodoviario extends Contribuinte{

	private double quilometragemPercorrida;
	
	/**
	 * Construtor da classe.
	 * @param nome Nome do rodoviario.
	 * @param numeroDoContribuinte Numero de cadastro do contribuinte.
	 * @param temCasaPropria Sera passado true se o rodoviario tiver casa propria, false se nao tiver.
	 * @param temCarro Sera passado true se o rodoviario tiver carro, false se nao tiver.
	 * @param valorDosBens Valor somado de todos os bens do rodoviario.
	 * @param quilometragemPercorrida Total de quilometros percorridos pelo rodoviario.
	 * @throws Exception Sera lancada caso alguma informacao passada ao construtor seja invalida.
	 */
	public Rodoviario(String nome, int numeroDoContribuinte, boolean temCasaPropria, boolean temCarro, double valorDosBens, double quilometragemPercorrida) throws Exception {
		super(nome, numeroDoContribuinte, temCasaPropria, temCarro, valorDosBens);
		setQuilometragem(quilometragemPercorrida);
	}

	/**
	 * Valida a quilometragem percorrida pelo rodoviario.
	 * @param quilometragemPercorrida O valor (km) que sera verificado.
	 * @throws Exception Sera lancada caso o valor (km) passado seja invalido.
	 */
	private void setQuilometragem(double quilometragemPercorrida) throws Exception{
		if(quilometragemPercorrida >= 0) {
			this.quilometragemPercorrida = quilometragemPercorrida;
		}else {
			throw new Exception("Valor da quilometragem invalido.");
		}
	}
	
	/**
	 * Retorna a quilometragem total percorrida por um rodoviario.
	 * @return A quilometragem percorrida por um rodoviario.
	 */
	public double getQuilometragemPercorrida() {
		return quilometragemPercorrida;
	}

	/**
	 * Calcula os descontos que serao aplicados aos rodoviarios.
	 */
	@Override
	public double calculaDesconto() {
		return (quilometragemPercorrida * 0.01);
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(super.toString());
		string.append(String.format("\nQuilometragem total percorrida: %,.1f km", quilometragemPercorrida));
		return string.toString();
	}
}
