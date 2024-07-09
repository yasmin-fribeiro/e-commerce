package produto.controller;

import java.util.ArrayList;

import produto.model.Produto;
import produto.repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {

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
	}

	@Override
	public void atualizar(Produto produto) {
		var buscaProduto = buscarNaCollection(produto.getNumero());
		
		if (buscaProduto != null) {
			
			
			listaProdutos.set(listaProdutos.indexOf(buscaProduto), produto);
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

	public ArrayList<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(ArrayList<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Produto buscarNaCollection(int numero) {
		for (var produto : listaProdutos) {
			if (produto.getNumero() == numero) {
				return produto;
			}
		}
		return null;
	}

}
