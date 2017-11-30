package principal;

public abstract class Rodoviario extends Contribuinte{
	
	private double distanciaPercorrida;
	
	public Rodoviario(String nome, String numeroDeContribuinte, boolean temCasaPropria, boolean temCarro, double valorDosBens, double distanciaPercorrida) throws Exception {
		super(nome, numeroDeContribuinte, temCasaPropria, temCarro, valorDosBens);
		validaDistancia(distanciaPercorrida);
	}
	
	

	private void validaDistancia(double distanciaPercorrida) throws Exception {
		if(distanciaPercorrida >= 0){
			this.distanciaPercorrida = distanciaPercorrida;
		}else{
			throw new Exception("A distancia percorrida tem que ser maior que zero.");
		}
	}

	@Override
	public double calculaDesconto() {
		return (distanciaPercorrida * 0.01);
	}

}
