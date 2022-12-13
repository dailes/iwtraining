package estoque;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Produtos {

	public static void criarArquivo(String endereco) {

		File arquivo = new File(endereco);

		try {
			if (arquivo.createNewFile()) {
				System.out.println("Arquivo criado com sucesso");
			} else {
				System.out.println("o arquivo já existe");
			}
		} catch (IOException e) {
			System.out.println("Deu ruim");
			e.printStackTrace();
		}

	}

	public static void adicionarProduto(String endereco, String produto) {

		File arquivo = new File(endereco);
		String tabela = mostrarProdutos(endereco);

		try {

			FileWriter adicionar = new FileWriter(arquivo);
			adicionar.write(tabela + produto);
			adicionar.close();
			
			System.out.println("Produto cadastrado com sucesso.");

		} catch (IOException e) {
			System.out.println("Deu ruim.");
			e.printStackTrace();
		}
	}

	public static String mostrarProdutos(String endereco) {

		File arquivo = new File(endereco);
		String tabela = "";

		Scanner leitor;
		try {
			leitor = new Scanner(arquivo);
			
			while (leitor.hasNextLine()) {

				String linha = leitor.nextLine();
				tabela += linha + "\n";
			}
		} catch (FileNotFoundException e) {
			System.out.println("Deu erro.");
			e.printStackTrace();
		}
		return tabela;
	}

}
