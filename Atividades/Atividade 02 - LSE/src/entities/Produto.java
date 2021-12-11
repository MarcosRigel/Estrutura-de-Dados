package entities;

public class Produto implements Comparable <Produto>{
	
	private String codigo;
	private String descricao;
	private double preco;
	private int estoque;
	
	public Produto (String codigo, String descricao, double preco, int estoque) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.estoque = estoque;
		this.preco = preco;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}
	
	public void alterarPreco(double preco) {
		if (preco < 0) {
			System.out.println("Digite um novo preço: ");
		}
		else {
			this.preco = preco;
			System.out.println("Preço Alterado!");
		}
	}
	
	public void alterarEstoque(int estoque) {
		if (estoque < 0) {
			System.out.println("Digite um novo estoque: ");
		}
		else {
			this.estoque = estoque;
			System.out.println("Estoque Alterado!");
		}
	}
	
	@Override
	public String toString() {
		return "Código do Produto: " + codigo + "\n"
				+ "Descricao: " + descricao + "\n"
				+ "Estoque: " + estoque + "\n"
				+ "Preço: " + preco;
				
	}
	
	@Override
	public int compareTo(Produto produto) {
		return this.codigo.compareTo(produto.codigo);
	}
}