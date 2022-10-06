package Entities;

public class Cliente {

	private String nome, endereco, senha, profissao, cpf;
	private int tipoConta;
	private double renda;

	public Cliente() {
		super();
	}

	public Cliente(String nome, String endereco, String senha, String profissao, String cpf, int tipoConta,
			double renda) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.senha = senha;
		this.profissao = profissao;
		this.cpf = cpf;
		this.tipoConta = tipoConta;
		this.renda = renda;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(int tipoConta) {
		this.tipoConta = tipoConta;
	}

	public double getRenda() {
		return renda;
	}

	public void setRenda(double renda) {
		this.renda = renda;
	}

	public String mostrarDados() {
		return "Nome: " + this.nome + "\nEndereço: " + this.endereco + "\nProfissão: " + this.profissao + "\nCPF: "
				+ this.cpf;
	}

}
