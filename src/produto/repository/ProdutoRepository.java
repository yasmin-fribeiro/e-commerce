package produto.repository;

import produto.model.Produto;

public interface ProdutoRepository {

	// CRUD da Conta
	public void procurarPorNumero(int numero);

	public void listarTodos();

	public void cadastrar(Produto produto);

	public void atualizar(Produto produto);

	public void deletar(int numero);

}
