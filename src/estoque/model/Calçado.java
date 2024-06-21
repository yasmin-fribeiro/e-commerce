package estoque.model;

public class Calçado extends Produto {
	
	// atributo de calçado
		private String cadarço;
		

	public Calçado(int numero, int tipo, String empresa, int quantidade, int estoque, String string) {
		super(numero, tipo, empresa, quantidade, estoque);
		// TODO Auto-generated constructor stub
		
		// atributo calçado
		this.cadarço = string;
	}


	public String getCadarço() {
		return cadarço;
	}


	public void setCadarço(String cadarço) {
		this.cadarço = cadarço;
	}


	public void cadastrar(Calçado cal1) {
		// TODO Auto-generated method stub
		
	}

}
