package supermercado;

import java.util.ArrayList;

public class Supermercado {
	
	private String nome;
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	
	public Supermercado() {}
	
	public Supermercado(String nome, ArrayList<Produto> produtos) {
		super();
		this.nome = nome;
		this.produtos = produtos;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	public void addProduto(Produto produto) {
		produtos.add(produto);
	}
	
	
}
