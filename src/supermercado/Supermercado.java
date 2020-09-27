package supermercado;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class Supermercado extends RemoteException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
