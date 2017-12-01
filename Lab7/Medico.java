package principal;

/*
 * Aluno 01: Jeffiti Múcio Andrade Morais
 * Aluno 02: Wesley Porto Santos
 */


/**
 * Classe que define as caracterasticas de um medico.
 */
public class Medico extends Contribuinte{

	private int numeroDePacientes;
	private double gastosEmCongressos;
	
	/**
	 * Construtor da classe.
	 * @param nome Nome do medico.
	 * @param numeroDoContribuinte Numero de cadastro do contribuinte.
	 * @param temCasaPropria Sera passado true se o medico tiver casa propria, false se nao tiver.
	 * @param temCarro Sera passado true se o medico tiver carro, false se nao tiver.
	 * @param valorDosBens Valor somado de todos os bens do medico.
	 * @param numeroDePacientes Numero de pacientes atendidos pelo medico em um ano.
	 * @param gastosEmCongressos Total de gastos que o medico teve em congressos.
	 * @throws Exception Sera lancada caso alguma informacao passada ao construtor seja invalida.
	 */
	public Medico(String nome, int numeroDoContribuinte, boolean temCasaPropria, boolean temCarro, double valorDosBens, int numeroDePacientes, double gastosEmCongressos) throws Exception {
		super(nome, numeroDoContribuinte, temCasaPropria, temCarro, valorDosBens);
		validaDados(numeroDePacientes, gastosEmCongressos);
	}

	/**
	 * Valida as informacoes do medico.
	 * @param numeroDePacientes Sera validado o valor passado referente ao total de pacientes atendidos pelo medico em um ano.
	 * @param gastosEmCongressos Sera validado o valor passado referente ao total de gastos que o medico teve em congresssos.
	 * @throws Exception Sera lancada caso alguma informacao passada seja invalida.
	 */
	private void validaDados(int numeroDePacientes, double gastosEmCongressos) throws Exception{
		if(numeroDePacientes >= 0) {
			this.numeroDePacientes = numeroDePacientes;
		}else {
			throw new Exception("O numero de pacientes atendidos pelo medico nao pode ser negativo.");
		}
		if(gastosEmCongressos >= 0) {
			this.gastosEmCongressos = gastosEmCongressos;
		}else {
			throw new Exception("O total de gastos em congressos do medico nao pode ser negativo.");
		}
	}
	
	/**
	 * Retorna o numero total de pacientes atendidos pelo medico.
	 * @return O numero de pacientes que o medico atendeu.
	 */
	public int getnumeroDePacientes() {
		return numeroDePacientes;
	}

	/**
	 * Retorna o total de gastos que o medico teve em congressos.
	 * @return Os gastos em congressos.
	 */
	public double getGastosEmCongressos() {
		return gastosEmCongressos;
	}

	/**
	 * Calcula o devido valor do imposto que devera ser pago pelo medico.
	 */
	@Override
	public double calculaTributos() {
		return numeroDePacientes * 10;
	}

	/**
	 * Calcula os descontos que serao aplicados ao medico.
	 */
	@Override
	public double calculaDesconto() {
		return this.gastosEmCongressos;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(super.toString());
		string.append("\nNumero de pacientes atendidos: "+numeroDePacientes);
		string.append(String.format("\nTotal de gastos em congressos: R$ %,.2f\n", gastosEmCongressos));
		return string.toString();
	}
}
