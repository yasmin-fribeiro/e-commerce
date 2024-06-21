package estoque.model;

public class Uniforme extends Produto {
	
	// atributo de uniforme
	private String estampa;

	public Uniforme(int numero, int tipo, String empresa, int quantidade, int estoque, String estampa) {
		super(numero, tipo, empresa, quantidade, estoque);
		// atributo uniforme
		this.estampa = estampa;
	}

	public String getEstampa() {
		return estampa;
	}

	public void setEstampa(String estampa) {
		this.estampa = estampa;
	}

	public void cadastrar(Uniforme uni1) {
		// TODO Auto-generated method stub
		
	}

	
	
	

}
