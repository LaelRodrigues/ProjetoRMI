package supermercado;

import java.rmi.RemoteException;

public class Produto extends RemoteException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private float preco;
	
	public Produto() {}

	public Produto(String nome, float preco) {
		super();
		this.nome = nome;
		this.preco = preco;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	
}
