package Entities;
import View.Main;

public class ContaPoupanca extends Conta {

	public double pctRendimento;

	public ContaPoupanca(double pctRendimento) {
		super();
		this.pctRendimento = pctRendimento;
	}

	public double getPctRendimento() {
		return pctRendimento;
	}

	public void setPctRendimento(double pctRendimento) {
		this.pctRendimento = pctRendimento;
	}

	public void render() {
		this.setSaldo(this.getSaldo() + (this.getSaldo() * this.pctRendimento));
	}

	public void depositar(double valor) {
		this.setSaldo(this.getSaldo() + valor);
	}

	public void sacar(double valor) {
		if(this.getSaldo() - valor >= 0) {
			this.setSaldo(this.getSaldo() - valor);			
		} else {
			System.out.println("Esse valor deixará sua conta negativa, não permitimos isso");
			Main.menuPoupanca(this.getNumero());
		}
	}

	public String mostrarDados() {
		return "Número: " + this.getNumero() + "\nAgência: " + this.getAgencia() + "\nSaldo: R$ " + this.getSaldo();
	}

}
