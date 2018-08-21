package Entidades;

public class PessoaJuridica extends Contribuintes {

	public int quantidadeFuncionarios;

	public PessoaJuridica() {

	}

	public PessoaJuridica(String nome, double rendaAnual, int quantidadeFuncionarios) {
		super(nome, rendaAnual);
		this.quantidadeFuncionarios = quantidadeFuncionarios;
	}

	public int getQuantidadeFuncionarios() {
		return quantidadeFuncionarios;
	}

	public void setQuantidadeFuncionarios(int quantidadeFuncionarios) {
		this.quantidadeFuncionarios = quantidadeFuncionarios;
	}

	@Override
	public double taxaImposto() {
		double sum = 0;

		if (quantidadeFuncionarios >= 10) {
			sum = getRendaAnual() * 0.14;
		} else {
			sum = getRendaAnual() * 0.16;
		}
		
		return sum;
	}

}
