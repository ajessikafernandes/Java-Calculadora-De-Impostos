package Aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entidades.Contribuintes;
import Entidades.PessoaFisica;
import Entidades.PessoaJuridica;

public class Programa {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner ler = new Scanner(System.in);

		List<Contribuintes> lista = new ArrayList<>();

		System.out.print("Informe a quantidade de Contribuintes: ");
		int qtd = ler.nextInt();

		for (int cont = 1; cont <= qtd; cont++) {

			System.out.println("Informe os dados do contribuinte #" + cont + " : ");
			System.out.print("Individuo ou Companhia (i/c)? ");
			char tipo = ler.next().charAt(0);
			ler.nextLine();
			System.out.print("Nome: ");
			String nome = ler.nextLine();
			System.out.print("Renda Anual: $ ");
			double rendaAnual = ler.nextDouble();

			if (tipo == 'i') {
				System.out.print("Total gasto com a Saúde? $ ");
				double gastosSaude = ler.nextDouble();
				lista.add(new PessoaFisica(nome, rendaAnual, gastosSaude));
			} else {
				System.out.print("Quantidade de funcionários da companhia? ");
				int quantidadeFuncionarios = ler.nextInt();
				lista.add(new PessoaJuridica(nome, rendaAnual, quantidadeFuncionarios));
			}

		}

		System.out.println("");
		
		double soma = 0;
		
		for (Contribuintes list : lista) {
			System.out.println(list.getNome() + ", $ " + String.format("%.2f", list.taxaImposto()));
			soma += list.taxaImposto();
		}

		System.out.println("Total: $ " + String.format("%.2f", soma));

	}

}
