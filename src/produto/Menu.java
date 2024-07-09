package produto;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import produto.controller.ProdutoController;
import produto.model.Calcado;
import produto.model.Uniforme;
import produto.util.CoresProduto;

public class Menu {
	public static void main(String[] args) {

		ProdutoController produtos = new ProdutoController();

		// Teste Classe Produto
		//	public Uniforme(int numero, int tipo, String empresa, int estoque, String cor, String tamanhoUniforme) {

		Uniforme uni1 = new Uniforme(produtos.gerarNumero(), 1, "Yas Automotive", 50,  "Preto", "P");
		produtos.cadastrar(uni1);

		Uniforme uni2 = new Uniforme(produtos.gerarNumero(), 2, "Yas Automotive", 60, "Preto", "M");
		produtos.cadastrar(uni2);

		Calcado cal1 = new Calcado(produtos.gerarNumero(), 1, "Yas Automotive", 70, 40);
		produtos.cadastrar(cal1);

		Calcado cal2 = new Calcado(produtos.gerarNumero(), 1, "Yas Automotive", 78, 42);
		produtos.cadastrar(cal2);

		Scanner leia = new Scanner(System.in);

		int opcao, numero, tipo, estoque, tamanhoCalcado = 0;
		String empresa;
		String cor = null;
		String tamanhoUniforme;
		


		while (true) {

			System.out.println(CoresProduto.TEXT_WHITE + CoresProduto.ANSI_BLUE_BACKGROUND
					+ "*****************************************************");
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
			System.out.println("                                                     " + CoresProduto.TEXT_RESET);
			System.out.println("Entre com a opção desejada:                          \n");
		

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
				System.out.println("\nCriar produto\n");

	
				System.out.println("\nDigite o nome da empresa:\n");
				leia.skip("\\R?");
				empresa = leia.nextLine();

				do {
					System.out.println("\nDigite o tipo do produto (1-Uniforme ou 2-Calçado)\n");
					tipo = leia.nextInt();
				} while (tipo < 1 && tipo > 3);

				System.out.println("\nDigite a quantidade de produtos:\n");
				estoque = leia.nextInt();

				switch (tipo) {
				case 1 -> {
					leia.nextLine();
					System.out.println("\nDigite a cor do uniforme:\n");
					cor = leia.nextLine();
					
					System.out.println("\nDigite o tamanho do uniforme:\n");
					tamanhoUniforme = leia.nextLine();
					
					produtos.cadastrar(
							
							new Uniforme(produtos.gerarNumero(), tipo, empresa, estoque, cor, tamanhoUniforme));
					
					System.out.println("\nO produto número: " + produtos.getNumero() + " foi criada com sucesso!");

				}
				case 2 -> {
					System.out.println("\nDigite o tamanho do calçado:\n");
					tamanhoCalcado = leia.nextInt();
					
					produtos.cadastrar(
							new Calcado(produtos.gerarNumero(), tipo, empresa, estoque, tamanhoCalcado));
				}

				}

				keyPress();
				break;
			case 2:
				System.out.println("\nListar todos os produtos\n");
				produtos.listarTodos();

				keyPress();
				break;
			case 3:
				System.out.println("\nConsultar dados do produto - por número\n");

				System.out.println("\nDigite o número do Produto:\n");
				numero = leia.nextInt();

				produtos.procurarPorNumero(numero);

				keyPress();
				break;
			case 4:
				System.out.println("\nAtualizar dados do produto\n");

				System.out.println("\nDigite o número do produto\n");
				numero = leia.nextInt();

				System.out.println("\nDigite o nome da empresa:\n");
				leia.skip("\\R?");
				empresa = leia.nextLine();

				System.out.println("\nDigite a quantidade de peças do produto no estoque\n");
				estoque = leia.nextInt();

				var buscaProduto = produtos.buscarNaCollection(numero);

				if (buscaProduto != null) {
					tipo = buscaProduto.getTipo();
					
				switch  (tipo) {
				
				case 1:
					leia.nextLine();
					System.out.println("\nDigite a cor do uniforme:\n");
					cor = leia.nextLine();
					
					System.out.println("\nDigite o tamanho do uniforme:\n");
					tamanhoUniforme = leia.nextLine();
					
					produtos.atualizar(new Uniforme(numero, tipo, empresa, estoque, cor, tamanhoUniforme));
					break;
					
				case 2:
					
					System.out.println("\nDigite o tamanho do calçado:\n");
					tamanhoCalcado = leia.nextInt();
					

					produtos.atualizar(new Calcado(numero, tipo, empresa, estoque, tamanhoCalcado));
					break;
				}
						
					
				} else

					System.out.println("\nO produto não foi encontrado!\n");

				keyPress();
				break;
			case 5:
				System.out.println("\nApagar o produto\n");

				System.out.println("\nDigite o número do produto:\n");
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
