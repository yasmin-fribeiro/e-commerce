package produto.model;

public class Uniforme extends Produto {

	// atributo de uniforme
	private String cor;
	private String tamanhoUniforme;

	public Uniforme(int numero, int tipo, String empresa, int estoque, String cor, String tamanhoUniforme) {
		super(numero, tipo, empresa, estoque);
		// atributo uniforme
		this.cor = cor;
		this.tamanhoUniforme = tamanhoUniforme;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Tamanho do Uniforme:" + this.tamanhoUniforme);
		System.out.println("Cor do Uniforme:" + this.cor);


	}

}
