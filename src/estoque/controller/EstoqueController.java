package estoque.controller;

import java.util.ArrayList;

import estoque.model.Produto;
import estoque.repository.EstoqueRepository;

public class EstoqueController implements EstoqueRepository {

	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {

		var produto = buscarNaCollection(numero);

		if (produto != null)
			produto.visualizar();
		else
			System.out.println("\n O produto número: " + numero + " não foi encontrado!");

	}

	@Override
	public void listarTodos() {
		for (var Produto : listaProdutos) {
			Produto.visualizar();

		}

	}

	@Override
	public void cadastrar(Produto produto) {
		listaProdutos.add(produto);
		System.out.println("\nO produto número: " + produto.getNumero() + " foi criada com sucesso!");
	}

	@Override
	public void atualizar(Produto produto) {
		var buscaProduto = buscarNaCollection(produto.getNumero());

		if (buscaProduto != null) {

			listaProdutos.set(listaProdutos.indexOf(buscaProduto), buscaProduto);
			System.out.println("\n O produto número: " + produto.getNumero() + " foi atualizado com sucesso!");
		} else
			System.out.println("\n o produto número: " + produto.getNumero() + " não foi encontrado");
	}

	@Override
	public void deletar(int numero) {

		var produto = buscarNaCollection(numero);

		if (produto != null) {
			if (listaProdutos.remove(produto) == true)
				System.out.println("\nO produto número: " + numero + "foi deletado com sucesso!");
		} else
			System.out.println("\nO produto número: " + numero + " não foi encontrado!");
	}

	public int gerarNumero() {
		return ++numero;
	}

	public Produto buscarNaCollection(int numero) {
		for (var produto : listaProdutos) {
			if (produto.getNumero() == numero) {
				return produto;
			}
		}
		return null;
	}

	public void atualizar(int estoque) {
		// TODO Auto-generated method stub
		
	}

}
