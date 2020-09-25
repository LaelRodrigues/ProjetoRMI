package supermercado;

import java.util.ArrayList;
import java.util.Arrays;

public class Compras{
	
	protected Compras() {
		super();
	}
	
	public Compras(ArrayList<Supermercado> supermercados) {
		super();
		this.supermercados = supermercados;
	}
	
	private ArrayList<Supermercado> supermercados = new ArrayList<Supermercado>();
	
	public ArrayList<Supermercado> menorValorProduto(ArrayList<String> produtos) {
		
		ArrayList<Supermercado> sups = new ArrayList<Supermercado>();
		int quantSups = supermercados.size();
		int contador = 0;
		for(int i = 0; i < produtos.size(); i++) {
			int j;
			float menorPreco = (float) -1.0;
			for (j = 0; j < quantSups; j++) {
				int quantProdutos = supermercados.get(j).getProdutos().size();
				for(int k = 0; k < quantProdutos; k++) {
					if(produtos.get(i).equals(supermercados.get(j).getProdutos().get(k).getNome())) {
						if(menorPreco == -1.0) {
							menorPreco = supermercados.get(j).getProdutos().get(k).getPreco();
							String nomeSuper = supermercados.get(j).getNome();
							Produto p = new Produto(supermercados.get(j).getProdutos().get(k).getNome(), 
										supermercados.get(j).getProdutos().get(k).getPreco());
							Supermercado s = new Supermercado( nomeSuper, new ArrayList<Produto>(Arrays.asList(p)));
							sups.add(s);							
						} else if((float) supermercados.get(j).getProdutos().get(k).getPreco() < (float) menorPreco) {
							menorPreco = supermercados.get(j).getProdutos().get(k).getPreco();
							String nomeSuper = supermercados.get(j).getNome();
							sups.get(i).setNome(nomeSuper);
							sups.get(i).getProdutos().get(0).setNome(supermercados.get(j).getProdutos().get(k).getNome());
							sups.get(i).getProdutos().get(0).setPreco(supermercados.get(j).getProdutos().get(k).getPreco());
						}
					} 
				}
			}
			contador++;
		}
		return sups;
	} 

	public ArrayList<Supermercado> getSupermercados() {
		return supermercados;
	}

	public void setSupermercados(ArrayList<Supermercado> supermercados) {
		this.supermercados = supermercados;
	} 
}
