package View;
import java.util.Scanner;

import DAO.Banco;
import Entities.Cliente;
import Entities.ContaCorrente;
import Entities.ContaPoupanca;
import Entities.Loteria;

public class Main {

	static Scanner sc = new Scanner(System.in);

	static Banco banco = new Banco();
	static Loteria loteria = new Loteria();

	static double taxaOperacoes = 5;
	static double pctRendimento = 0.01;

	public static void main(String[] args) {
		menuPrevio();
	}

	public static void menuPrevio() {
		System.out.println("---------------------------");
		System.out.println(" " + "Bem Vindo ao Intelli Bank");
		System.out.println("---------------------------");
		System.out.println("");
		System.out.print("\tLogin \n1- Login \n2- Criar uma conta \n> ");
		int opcao = sc.nextInt();

		switch (opcao) {
		case 1:
			dadosLogin();
			break;
		case 2:
			efetuarCadastro();
			break;
		}
	}

	public static void menuCorrente(int numConta) {
		ContaCorrente conta = (ContaCorrente) banco.procurarContas(numConta);
		System.out.print(
				"\tMenu Corrente \n1- Sacar \n2- Depositar \n3- Transferir \n4- Mostrar Dados \n5- Loteria \n6- Sair \n> ");
		int opcao = sc.nextInt();

		switch (opcao) {
		case 1:
			conta.sacar(valorSaque());
			break;
		case 2:
			conta.depositar(valorDeposito());
			break;
		case 3:
			double valor = valorTransf();
			System.out.print("Qual o número da conta para transferir: \n> ");
			int num = sc.nextInt();
			conta.transferir(banco.procurarContas(num), valor);
			break;
		case 4:
			System.out.println(conta.mostrarDados());
			break;
		case 5:
			loteria(conta, numConta);
			break;
		case 6:
			menuPrevio();
			break;
		default:
			System.out.println("Opção inválida!");
			break;
		}
		menuCorrente(numConta);
	}

	public static void menuPoupanca(int numConta) {
		ContaPoupanca conta = (ContaPoupanca) banco.procurarContas(numConta);
		System.out.print(
				"\tMenu Poupança \n1- Sacar \n2- Depositar \n3- Mostrar Dados \n4- Visualizar Rendimento \n5- Sair \n> ");
		int opcao = sc.nextInt();

		switch (opcao) {
		case 1:
			conta.sacar(valorSaque());
			conta.render();
			break;
		case 2:
			conta.depositar(valorDeposito());
			conta.render();
			break;
		case 3:
			System.out.println(conta.mostrarDados());
			break;
		case 4:
			rendimento(conta);
			break;
		case 5:
			menuPrevio();
			break;
		default:
			System.out.println("Opção inválida!");
			break;
		}
		menuPoupanca(numConta);
	}

	public static void dadosLogin() {
		
		System.out.print("\nInforme o tipo da conta: \n1- Corrente \n2- Poupança \n> ");
		int tipoConta = sc.nextInt();
		
		while (tipoConta > 2 || tipoConta < 1) {
			System.out.println("Opção de conta incorreta!");
			System.out.print("\nInforme o tipo da conta: \n1- Corrente \n2- Poupança \n> ");
			tipoConta = sc.nextInt();
		}

		System.out.print("\nInforme o cpf: ");
		String cpf = sc.next();
		System.out.print("Informe a senha: ");
		String senha = sc.next();

		verificarLogin(tipoConta, cpf, senha);
	}

	public static void verificarLogin(int tipoConta, String cpf, String senha) {
		for (int i = 0; i < banco.clientes.size(); i++) {
			if (banco.clientes.get(i).getCpf().equals(cpf)) {
				Cliente cliente = banco.clientes.get(i);
				if (cliente.getSenha().equals(senha)) {
					if (tipoConta == 1) {
						menuCorrente(i + 1);
						break;
					} else {
						menuPoupanca(i + 1);
						break;
					}
				}
			}
		}
		System.out.println("Cpf ou senha incorretos!");
		menuPrevio();
	}
	
	public static void efetuarCadastro() {
		Cliente cliente = new Cliente();

		System.out.print("Informe o nome: ");
		cliente.setNome(sc.next());
		sc.nextLine();
		System.out.print("Informe o endereço: ");
		cliente.setEndereco(sc.nextLine());
		System.out.print("Informe o CPF: ");
		cliente.setCpf(sc.next());
		System.out.print("Informe a senha: ");
		cliente.setSenha(sc.next());
		System.out.print("Informe a profissão: ");
		cliente.setProfissao(sc.next());
		System.out.print("Informe a renda: ");
		cliente.setRenda(sc.nextDouble());

		banco.criarCliente(cliente);

		criarConta();
	}

	public static void criarConta() {
		System.out.print("Você gostaria de criar uma conta corrente ou poupança? \n1- Corrente \n2- Poupança \n> ");
		int opcao = sc.nextInt();

		switch (opcao) {
		case 1:
			System.out.print("Informe a agência: ");
			criarContaC(sc.next());
			break;
		case 2:
			System.out.print("Informe a agência: ");
			criarContaP(sc.next());
			break;
		default:
			System.out.println("Operação inválida!");
			criarConta();
		}
		menuPrevio();
	}

	public static void criarContaC(String agencia) {
		ContaCorrente contaC = new ContaCorrente(taxaOperacoes, 0);

		contaC.setNumero(banco.getContas().size() + 1);
		contaC.setAgencia(agencia);

		banco.criarConta(contaC);
	}

	public static void criarContaP(String agencia) {
		ContaPoupanca contaP = new ContaPoupanca(pctRendimento);

		contaP.setNumero(banco.getContas().size() + 1);
		contaP.setAgencia(agencia);

		banco.criarConta(contaP);
	}

	public static void loteria(ContaCorrente conta, int numConta) {
		System.out.print(
				"--- Loteria Intelli Bank --- \nO valor para o jogo é de 5 R$. Deseja jogar? \n1- Sim \n2- Não \n> ");
		int opcao = sc.nextInt();

		switch (opcao) {
		case 1:
			conta.sacar(5);
			loteria.sortearNumeros();
			for (int i = 0; i < 6; i++) {
				System.out.print("Escolha um número de 0 a 60: ");
				loteria.numerosP.add(sc.nextInt());
			}
			loteria.compararNumeros();
			System.out.println("Seu prêmio: \n" + loteria.premio);
			conta.depositar(loteria.premio);
			break;
		case 2:
			menuCorrente(numConta);
			break;
		}
	}

	public static double valorSaque() {
		System.out.print("\nQual o valor a sacar? \n> ");
		return sc.nextDouble();
	}

	public static double valorDeposito() {
		System.out.print("\nQual o valor a depositar? \n> ");
		return sc.nextDouble();
	}

	public static double valorTransf() {
		System.out.print("\nQual o valor a transferir? \n> ");
		return sc.nextDouble();
	}

	public static void rendimento(ContaPoupanca conta) {
		System.out.println("Sua possui um rendimento de: " + (conta.pctRendimento) * 100 + "% por operação");
	}
}