package principal;

/*
 * Aluno 01: Jeffiti Múcio Andrade Morais
 * Aluno 02: Wesley Porto Santos
 */


/**
 * Classe que define as caracterasticas de um professor.
 */
public class Professor extends Contribuinte {

	private final double SALARIO_MINIMO = 937.00;
	private double salario;
	private double gastosComMateriais;
	
	/**
	 * Construtor da classe.
	 * @param nome Nome do professor.
	 * @param numeroDoContribuinte Numero de cadastro do contribuinte.
	 * @param temCasaPropria Sera passado true se o professor tiver casa propria, false se nao tiver.
	 * @param temCarro Sera passado true se o professor tiver carro, false se nao tiver.
	 * @param valorDosBens Valor somado de todos os bens do professor.
	 * @param salario Valor do salario recebido pelo professor.
	 * @param gastosComMateriais Total de gastos que o professor teve com seus materiais.
	 * @throws Exception Sera lancada caso alguma informacao passada ao construtor seja invalida.
	 */
	public Professor(String nome, int numeroDoContribuinte, boolean temCasaPropria, boolean temCarro, double valorDosBens, double salario, double gastosComMateriais) throws Exception {
		super(nome, numeroDoContribuinte, temCasaPropria, temCarro, valorDosBens);
		validaDados(salario, gastosComMateriais);
	}

	/**
	 * Valida as informacoes do professor.
	 * @param salario Sera validado o valor do salario do professor que sera passado como argumento.
	 * @param gastosComMateriais Sera validado o valor total de gastos com materiais que o professor teve e que sera passado como argumento.
	 * @throws Exception Sera lancada caso alguma informacao passada seja invalida.
	 */
	private void validaDados(double salario, double gastosComMateriais) throws Exception{
		if(salario > 0) {
			this.salario = salario;
		}else {
			throw new Exception("Valor do salario do professor invalido.");
		}
		if(gastosComMateriais >= 0) {
			this.gastosComMateriais = gastosComMateriais;
		}else {
			throw new Exception("Os gastos com materiais nao pode ser um valor negativo.");
		}		
	}
	
	/**
	 * Retorna o salario do professor.
	 * @return O salario do professor.
	 */
	public double getSalario() {
		return salario;
	}

	/**
	 * Retorna o valor total que o professor teve com materiais.
	 * @return O valor gasto em materiais.
	 */
	public double getGastosComMateriais() {
		return gastosComMateriais;
	}

	/**
	 * Calcula o devido valor do imposto que dever� ser pago pelo professor.
	 */
	@Override
	public double calculaTributos() {
		double imposto;
		if(salario <= SALARIO_MINIMO) {
			imposto = (salario * 0.05);
		}else if(salario <= 5*SALARIO_MINIMO) {
			imposto = (salario * 0.1);
		}else {
			imposto = (salario * 0.2);
		}
		return imposto;
	}

	/**
	 * Calcula os descontos que serao aplicados ao professor.
	 */
	@Override
	public double calculaDesconto() {
		return (gastosComMateriais * 0.5);
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append(super.toString());
		string.append(String.format("\nSalario: R$ %,.2f", salario));
		string.append(String.format("\nGastos com materiais: R$ %,.2f\n", gastosComMateriais));
		return string.toString();
	}
}
