package application;

import java.util.Scanner;

import entities.Cliente;
import entities.ItemPedido;
import entities.Pedido;
import entities.Produto;
import entities.enums.StatusPedido;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com os dados do cliente:");
		System.out.print("Nome: ");
		String nomeCliente = sc.nextLine();
		System.out.print("E-mail: ");
		String emailCliente = sc.next();
		System.out.print("Data de Nascimento (DD/MM/AAAA): ");
		String nascimentoCliente = sc.next();
		
		Cliente cliente = new Cliente(nomeCliente, emailCliente, nascimentoCliente);
		
		System.out.println();

		System.out.println("Entre com os dados do pedido:");
		System.out.print("Status: ");
		String status = sc.next();
		System.out.print("Quantidade de itens: ");
		int quantidadeItens = sc.nextInt();
		
		System.out.println();
		Pedido pedido = new Pedido(StatusPedido.valueOf(status), cliente);
		
		for (int x = 0; x < quantidadeItens; x++) {
			System.out.println("Entre com os dados do produto #" + (x+1) + ":");
			System.out.print("Nome: ");
			sc.nextLine();
			String nomeProduto = sc.nextLine();
			System.out.print("Preço: ");
			Double precoProduto = sc.nextDouble();
			System.out.print("Quantidade: ");
			int quantidadeProduto = sc.nextInt();
			
			Produto produto = new Produto(nomeProduto, precoProduto);
			ItemPedido item = new ItemPedido(quantidadeProduto, produto);
			pedido.incluirItem(item);
			
			System.out.println();
		}
		
		System.out.print("SUMÁRIO DO PEDIDO:\n" + pedido);
		
		
		sc.close();
	}

}
