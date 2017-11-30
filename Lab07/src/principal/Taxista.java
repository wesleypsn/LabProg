package principal;

public class Taxista extends Rodoviario{
	
	private int numeroDePassageiros;

	public Taxista(String nome, String numeroDeContribuinte, boolean temCasaPropria, boolean temCarro,double valorDosBens, double distanciaPercorrida, int numeroDePassageiros) throws Exception {
		super(nome, numeroDeContribuinte, temCasaPropria, temCarro, valorDosBens, distanciaPercorrida);
		setNumeroDePassageiros(numeroDePassageiros);
	}

	private void setNumeroDePassageiros(int numeroDePassageiros) throws Exception{
		if(numeroDePassageiros >= 0){
			this.numeroDePassageiros = numeroDePassageiros;
		}else{
			throw new Exception("O numero de passageiros deve ser maior ou igual a zero.");
		}
	}

	@Override
	public double calculaTributo() {
		double imposto = (numeroDePassageiros * 0.5);
		
		if(imposto < calculaDesconto()){
			return 0;
		}else{
			return imposto - calculaDesconto();
		}
	}
}
