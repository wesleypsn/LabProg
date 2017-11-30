package principal;

public class Medico extends Contribuinte{
	
	private int numeroDePacientes;
	private double despesasDeCongressos;

	public Medico(String nome, String numeroDeContribuinte, boolean temCasaPropria, boolean temCarro, double valorDosBens, int numeroDePacientes, double despesasDeCongressos) throws Exception {
		super(nome, numeroDeContribuinte, temCasaPropria, temCarro, valorDosBens);
		validaDados(numeroDePacientes, despesasDeCongressos);
	}

	private void validaDados(int numeroDePacientes, double despesasDeCongressos) throws Exception{
		if(numeroDePacientes >= 0){
			this.numeroDePacientes = numeroDePacientes;
		}else{
			throw new Exception("O número de pacientes atendidos não pode ser negativo.");
		}
		if(despesasDeCongressos >= 0){
			this.despesasDeCongressos = despesasDeCongressos;
		}else{
			throw new Exception("O valor gasto em congressos não pode ser negativo.");
		}
	}

	@Override
	public double calculaDesconto() {
		return despesasDeCongressos;
	}

	@Override
	public double calculaTributo() {
		double imposto = (numeroDePacientes * 10);
		
		if(imposto < calculaDesconto()){
			return 0;
		}else{
			return imposto - calculaDesconto();
		}
	}
}
