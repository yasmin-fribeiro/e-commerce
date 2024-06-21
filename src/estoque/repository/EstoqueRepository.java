package estoque.repository;

import estoque.model.Produto;

public interface EstoqueRepository {

	// CRUD da Conta
	public void procurarPorNumero(int numero);

	public void listarTodos();

	public void cadastrar(Produto produto);

	public void atualizar(Produto produto);

	public void deletar(int numero);

	void atualizar(int estoque);

}
