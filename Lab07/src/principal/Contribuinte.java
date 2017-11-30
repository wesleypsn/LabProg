package principal;

public abstract class Contribuinte {

	private static int NUMERO_DE_CONTRIBUINTES_CADASTRADOS = 0;
	private String nome;
	private String numeroDeContribuinte;
	private boolean temCasaPropria = false;
	private boolean temCarro = false;
	private double valorDosBens;
	
	public Contribuinte(String nome, String numeroDeContribuinte, boolean temCasaPropria, boolean temCarro, double valorDosBens) throws Exception{
		NUMERO_DE_CONTRIBUINTES_CADASTRADOS++;
		validaDados(nome, numeroDeContribuinte, valorDosBens);
		this.temCasaPropria = temCasaPropria;
		this.temCarro = temCarro;
		
	}
	
	private void validaDados(String nome, String numeroDeContribuinte, double valorDosBens) throws Exception{
		if(nome != null && !nome.trim().isEmpty()){
			this.nome = nome;
		}else{
			throw new Exception("Contribuinte deve ter um nome.");
		}
		if(numeroDeContribuinte != null && !numeroDeContribuinte.trim().isEmpty()){
			this.numeroDeContribuinte = numeroDeContribuinte;
		}else{
			throw new Exception("Contribuinte deve ter um numero de cadastro.");
		}
		if(valorDosBens >= 0){
			this.valorDosBens = valorDosBens;
		}else{
			throw new Exception("O valor dos bens nao pode ser negativo.");
		}
		
	}

	public abstract double calculaDesconto();
	
	public abstract double calculaTributo();
	
}
