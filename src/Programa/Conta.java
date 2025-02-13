package Programa;

import Utilitarios.Utils;

public class Conta {
	
	private static int contadorDeContas = 1;
	
	private int numeroConta;
	private Pessoa pessoa;
	private Double saldo = 0.0;
	
	public Conta( Pessoa pessoa) {
		this.numeroConta = contadorDeContas;
		this.pessoa = pessoa;
		contadorDeContas += 1;
	}
	
	public int getNumeroConta() {
		return numeroConta;
	}
	
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public Double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
	public String toString() {
		
		return "\nN�mero da conta: " + this.getNumeroConta() +
		       "\nNome: " + this.pessoa.getNome()+
		       "\nCPF: " + this.pessoa.getCPF() +
		       "\nEmail: " + this.pessoa.getEmail() +
		       "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
		       "\n";
	}
	
	public void depositar(Double valor) {
		if(valor > 0) {
			setSaldo(getSaldo() + valor);
			System.out.println("Seu dep�sito foi realizado com sucesso!");
		} else {
			System.out.println("N�o foi possivel realizar o dep�sito!");
		}
	}
	
	public void sacar(Double valor) {
		if(valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			System.out.println("saque realizado com sucesso!");
		} else {
			System.out.println("N�o foi possivel realizado com sucesso!");
		}
    }
	
	public void transferir(Conta contaParaDeposito, Double valor) {
		if(valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			
			contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
			System.out.println("Transfer�ncia realizado com sucesso");
	} else {
		System.out.println("n�o foi possivel realizar a transfer�ncia");
	}
	
	}

}
