package entities;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import entities.enums.StatusPedido;

public class Pedido {

	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	
	private LocalDateTime data;
	private StatusPedido status;
	private Cliente cliente;
	private List<ItemPedido> itens = new ArrayList<>();
	
	
	public Pedido(StatusPedido status, Cliente cliente) {
		data = LocalDateTime.now();
		this.status = status;
		this.cliente = cliente;
	}

	public void incluirItem(ItemPedido item) {
		itens.add(item);
	}
	
	public void excluirItem(ItemPedido item) {
		itens.remove(item);
	}
	
	public String getData() {
		return fmt.format(data);
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public List<ItemPedido> getItens() {
		return itens;
	}
	
	public double total() {
		double total = 0;
		for (ItemPedido x : itens) {
			total += x.subtotal();
		}
		return total;
	}

	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Momento do pedido: ");
		sb.append(getData() + "\n");
		sb.append("Status do pedido: ");
		sb.append(getStatus() + "\n");
		sb.append("Cliente: ");
		sb.append(getCliente() + "\n");
		sb.append("Itens do pedido:\n");
		for (ItemPedido i : itens) {
			sb.append(i);
		}
		sb.append("Valor total: ");
		sb.append(String.format("%.2f", total()));
		
		return sb.toString();
	}
	
}
