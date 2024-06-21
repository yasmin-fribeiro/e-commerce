package estoque;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import estoque.controller.EstoqueController;
import estoque.model.Calçado;
import estoque.model.Uniforme;

public class Menu {
	public static void main(String[] args) {

		EstoqueController produtos = new EstoqueController();

		// Teste Classe Produto
		Uniforme uni1 = new Uniforme(1, 1, "Yas Automotive", 50, 0, "Logo Automotive");
		uni1.cadastrar(uni1);

		Uniforme uni2 = new Uniforme(2, 2, "Yas Automotive", 60, 0, "Logo Automotive");
		uni2.cadastrar(uni2);

		Calçado cal1 = new Calçado(3, 3, "Yas Automotive", 70, 0, "Sim");
		cal1.cadastrar(cal1);

		Calçado cal2 = new Calçado(4, 4, "Yas Automotive", 80, 0, "Não");
		cal2.cadastrar(cal2);

		Scanner leia = new Scanner(System.in);

		int opcao, numero, tipo, quantidade = 0, estoque;
		String empresa;
		String cadarço = null;

		System.out.println("\nCriar produtos\n");

		while (true) {

			System.out.println("*****************************************************");
			System.out.println("                Brasil Uniformes                     ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar produto                        ");
			System.out.println("            2 - Listar todos os produtos             ");
			System.out.println("            3 - Buscar produto por numero            ");
			System.out.println("            4 - Atualizar dados do produto           ");
			System.out.println("            5 - Apagar produto                       ");
			System.out.println("            6 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");

			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 6) {
				System.out.println("\nBrasil Uniformes - Vestir bem para vestir sempre!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Criar produto\n\n");

				System.out.println("Digite o número do produto: ");
				numero = leia.nextInt();
				System.out.println("Digite o nome da empresa: ");
				leia.skip("\\R?");
				empresa = leia.nextLine();

				do {
					System.out.println("Digite o tipo do produto (1-Uniforme ou 2-Calçado");
					tipo = leia.nextInt();
				} while (tipo < 1 && tipo > 3);

				System.out.println("Digite a quantidade de produtos: ");
				estoque = leia.nextInt();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite a quantidade de calças: ");
					produtos.cadastrar(
							new Uniforme(produtos.gerarNumero(), tipo, empresa, quantidade, estoque, empresa));

				}
				case 2 -> {
					System.out.println("Digite a quantidade de calçados: ");
					produtos.cadastrar(
							new Calçado(produtos.gerarNumero(), tipo, empresa, quantidade, estoque, cadarço));
				}

				}

				keyPress();
				break;
			case 2:
				System.out.println("Listar todos os produtos\n\n");
				produtos.listarTodos();

				keyPress();
				break;
			case 3:
				System.out.println("Consultar dados do produto - por número\n\n");

				System.out.println("Digite o número do Produto: ");
				numero = leia.nextInt();

				produtos.procurarPorNumero(numero);

				keyPress();
				break;
			case 4:
				System.out.println("Atualizar dados do produto\n\n");

				System.out.println("Digite o número do produto\n\n");
				numero = leia.nextInt();

				System.out.println("Digite o tipo do produto\n\n");
				tipo = leia.nextInt();

				System.out.println("Digite o nome da empresa: ");
				leia.skip("\\R?");
				empresa = leia.nextLine();

				System.out.println("Digite a quantidade de peças do produto no estoque\n\n");
				estoque = leia.nextInt();

				var buscaProduto = produtos.buscarNaCollection(numero);

				if (buscaProduto != null) {
					estoque = buscaProduto.getEstoque();

					produtos.atualizar(uni1);
				} else

					System.out.println("\nO produto não foi encontrado!\n");

				keyPress();
				break;
			case 5:
				System.out.println("Apagar o produto\n\n");

				System.out.println("\nDigite o número do produto: ");
				numero = leia.nextInt();

				produtos.deletar(numero);

				keyPress();
				break;
			default:
				System.out.println("\nOpção Inválida!\n");

				keyPress();
				break;
			}
		}

	}

	private static void keyPress() {
		try {

			System.out.println("\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {
			System.out.println("\n\nVocê pressionou uma tecla diferente de enter!");
		}

	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Yasmin Ribeiro - yasmin.ribeiro@genstudents.br");
		System.out.println("https://github.com/yasmin-fribeiro");
		System.out.println("*********************************************************");
	}
}