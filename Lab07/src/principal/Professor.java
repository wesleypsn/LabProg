package principal;

public class Professor extends Contribuinte{
	
	private double gastosComMaterial;
	private final double SALARIO_MINIMO = 937;
	private double salario;

	public Professor(String nome, String numeroDeContribuinte, boolean temCasaPropria, boolean temCarro, double valorDosBens, double gastosComMaterial, double salario) throws Exception {
		super(nome, numeroDeContribuinte, temCasaPropria, temCarro, valorDosBens);
		validaDados(gastosComMaterial, salario);
	}

	private void validaDados(double gastosComMaterial, double salario) throws Exception{
		if(gastosComMaterial >= 0){
			this.gastosComMaterial = gastosComMaterial;
		}else{
			throw new Exception("O gasto com material nao pode ser negativo.");
		}
		if(salario >= SALARIO_MINIMO){
			this.salario = salario;
		}else{
			throw new Exception("O professor deve receber no minimo um salario manimo.");
		}
	}

	@Override
	public double calculaDesconto() {
		return (gastosComMaterial * 0.5);
	}

	@Override
	public double calculaTributo() {
		double imposto = 0;
		if(salario == SALARIO_MINIMO){
			imposto = (0.05 * salario);
		}else if(salario > SALARIO_MINIMO && salario <= 5*SALARIO_MINIMO){
			imposto = (0.1 * salario);
		}else{
			imposto = (0.2 * salario);
		}
		
		if(imposto < calculaDesconto()){
			return 0;
		}else{
			return imposto - calculaDesconto();
		}
	}
}
