package produto.model;

public class Calcado extends Produto {
	
	// atributo de calçado
		private int tamanhoCalcado;
		

	public Calcado(int numero, int tipo, String empresa, int estoque, int tamanhoCalcado) {
		super(numero, tipo, empresa, estoque);
		// TODO Auto-generated constructor stub
		
		// atributo calçado
		this.tamanhoCalcado = tamanhoCalcado;
	}


	public int gettamanhoCalcado() {
		return tamanhoCalcado;
	}


	public void settamanhoCalcado(int tamanhoCalcado) {
		this.tamanhoCalcado = tamanhoCalcado;
	}
	
	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Tamanho do calçado " + this.tamanhoCalcado);

	}

}
