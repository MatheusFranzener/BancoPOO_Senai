package DAO;
import java.util.ArrayList;

import Entities.Cliente;
import Entities.Conta;

public class Banco {

	public ArrayList<Conta> contas = new ArrayList<Conta>();
	public ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	public ArrayList<Conta> getContas() {
		return contas;
	}

	public void setContas(ArrayList<Conta> contas) {
		this.contas = contas;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public void criarConta(Conta conta) {
		contas.add(conta);
	}

	public void criarCliente(Cliente cliente) {
		clientes.add(cliente);
	}

	public void removerConta(Conta conta) {
		contas.remove(conta);
	}

	public void removerCliente(Cliente cliente) {
		clientes.remove(cliente);
	}

	public String mostrarContas() {
		String dadosContas = "";
		for (Conta conta : contas) {
			dadosContas += conta.mostrarDados() + "\n";
		}
		return dadosContas;
	}

	public String mostrarClientes() {
		String dadosClientes = "";
		for (Cliente cliente : clientes) {
			dadosClientes += cliente.mostrarDados() + "\n";
		}
		return dadosClientes;
	}

	public Conta procurarContas(int numero) {
		for (Conta conta : contas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}

	public Cliente procurarCliente(String nome) {
		for (Cliente cliente : clientes) {
			if (cliente.getNome() == nome) {
				return cliente;
			}
		}
		return null;
	}
}