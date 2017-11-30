package principal;

public class Caminhoneiro extends Rodoviario{
	
	private double toneladasTransportadas;

	public Caminhoneiro(String nome, String numeroDeContribuinte, boolean temCasaPropria, boolean temCarro, double valorDosBens, double distanciaPercorrida, double toneladasTransportadas) throws Exception {
		super(nome, numeroDeContribuinte, temCasaPropria, temCarro, valorDosBens, distanciaPercorrida);
		setToneladasTransportadas(toneladasTransportadas);
		
	}

	private void setToneladasTransportadas(double toneladasTransportadas) throws Exception{
		if(toneladasTransportadas >= 0){
			this.toneladasTransportadas = toneladasTransportadas;
		}else{
			throw new Exception("O número de toneladas deve ser maior ou igual a zero.");
		}
	}

	@Override
	public double calculaTributo() {
		double imposto = 0;
		
		if(toneladasTransportadas <= 10){
			imposto = 500;
		}else{
			double toneladasExtras = toneladasTransportadas - 10;
			imposto = (500 + (toneladasExtras * 100));
		}
		if(imposto < calculaDesconto()){
			return 0;
		}else{
			return imposto - calculaDesconto();
		}
	}
}
