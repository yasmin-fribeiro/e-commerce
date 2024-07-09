package produto.model;

public abstract class Produto {

	private int numero;
	private int tipo;
	private String empresa;
	private int estoque;

	public Produto(int numero, int tipo, String empresa, int estoque) {
		this.numero = numero;
		this.tipo = tipo;
		this.empresa = empresa;
		this.estoque = estoque;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public boolean retirar(int quantidade) {

		if (quantidade > estoque) {
			System.out.println("\n Saldo Insuficiente!");
			return false;
		}

		this.setEstoque(estoque - quantidade);
		return true;
	}

	public void inserir(int quantidade) {

		this.setEstoque(quantidade + estoque);

	}

	public void visualizar() {

		String tipo = "";

		switch (this.tipo) {
		case 1:
			tipo = "Uniforme (Camisa & Calça)";
			break;
		case 2:
			tipo = "Sapato";
			break;
		}
		System.out.println("\n\n***********************************************************");
		System.out.println("Dados do Produto:");
		System.out.println("***********************************************************");
		System.out.println("Numero do produto: " + this.numero);
		System.out.println("Tipo do produto: " + tipo);
		System.out.println("Empresa: " + this.empresa);
		System.out.println("Quantidade de peças no estoque: " + this.estoque);

	}

}