package Entities;
import View.Main;

public class ContaCorrente extends Conta {

	public double taxaOperacoes;
	public int qtdOperacoes;

	public ContaCorrente(double taxaOperacoes, int qtdOperacoes) {
		super();
		this.taxaOperacoes = taxaOperacoes;
		this.qtdOperacoes = qtdOperacoes;
	}

	public int getQtdOperacoes() {
		return qtdOperacoes;
	}

	public void setQtdOperacoes(int qtdOperacoes) {
		this.qtdOperacoes = qtdOperacoes;
	}

	public double getTaxaOperacoes() {
		return taxaOperacoes;
	}

	public void setTaxaOperacoes(double taxaOperacoes) {
		this.taxaOperacoes = taxaOperacoes;
	}

	public void transferir(Conta conta, double valor) {
		if (this.getSaldo() >= valor) {
			this.setSaldo(this.getSaldo() - (valor + this.taxaOperacoes));
			conta.setSaldo(conta.getSaldo() + valor);
			this.qtdOperacoes++;
		} else {
			System.out.println("O valor a transferir � maior que o saldo da sua conta! ");
			Main.menuCorrente(this.getNumero());
		}
	}

	public void depositar(double valor) {
		this.setSaldo(this.getSaldo() + valor);
	}

	public void sacar(double valor) {
		if (this.getSaldo() - valor >= 0) {
			this.setSaldo(this.getSaldo() - valor);
		} else {
			System.out.println("Esse valor deixar� sua conta negativa, n�o permitimos isso");
			Main.menuCorrente(this.getNumero());
		}
	}

	public String mostrarDados() {
		return "N�mero: " + this.getNumero() + "\nAg�ncia: " + this.getAgencia() + "\nSaldo: R$ " + this.getSaldo()
				+ "\nQuantidade de Opera��es: " + this.qtdOperacoes + "\nTaxa de Opera��o: " + (this.taxaOperacoes)
				+ "%";
	}

}
