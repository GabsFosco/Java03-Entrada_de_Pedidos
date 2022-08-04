package entities;

public class ItemPedido {

	private int quantidade;
	private double preco;
	private Produto produto;
	
	public ItemPedido(int quantidade, Produto produto) {
		this.quantidade = quantidade;
		this.preco = produto.getPreco();
		this.produto = produto;
	}
	
	public double subtotal() {
		return preco * quantidade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(produto.getNome());
		sb.append(", R$ ");
		sb.append(String.format("%.2f", produto.getPreco()));
		sb.append(", Quantidade: ");
		sb.append(quantidade);
		sb.append(", Subtotal: R$ ");
		sb.append(String.format("%.2f", subtotal()));
		sb.append("\n");
		
		return sb.toString();
	}
	
}
