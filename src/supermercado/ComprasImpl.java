package supermercado;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;

public class ComprasImpl extends UnicastRemoteObject implements ComprasInterface{
	
	private static final long serialVersionUID = 1L;

	protected ComprasImpl() throws RemoteException{
		super();
	}
	
	public ComprasImpl(ArrayList<Supermercado> supermercados) throws RemoteException{
		super();
		this.supermercados = supermercados;
	}
	
	private ArrayList<Supermercado> supermercados = new ArrayList<Supermercado>();
	
	public ArrayList<Supermercado> menorValorProduto(ArrayList<String> listaCompras) {
		
		ArrayList<Supermercado> sups = new ArrayList<Supermercado>();
		int quantSups = supermercados.size();
		int verificarProduto[] = new int[listaCompras.size()];
		
		for(int i = 0; i < listaCompras.size(); i++) {
			int j;
			float menorPreco = (float) -1.0;		
			verificarProduto[i] = 0;
			for (j = 0; j < quantSups; j++) {
				int quantProdutos = supermercados.get(j).getProdutos().size();
				for(int k = 0; k < quantProdutos; k++) {
					if(listaCompras.get(i).equals(supermercados.get(j).getProdutos().get(k).getNome())) {
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
						verificarProduto[i]++;
					} 
				}
			}
			if(verificarProduto[i] == 0) {
				Produto p = new Produto(listaCompras.get(i), (float) 2.5);
				Supermercado s = new Supermercado("produto nao encontrado", new ArrayList<Produto>(Arrays.asList(p)));
				sups.add(s);				

			}
		}
		return sups;
	} 

	public ArrayList<Supermercado> getSupermercados() {
		return supermercados;
	}

	public void setSupermercados(ArrayList<Supermercado> supermercados) {
		this.supermercados = supermercados;
	}

	@Override
	public ArrayList<Supermercado> mercadosConsultado(String produto) throws RemoteException {
		
		ArrayList<Supermercado> sups = new ArrayList<Supermercado>();
		int quantSups = supermercados.size();
		
		for(int i = 0; i < quantSups; i++) {
			int quantProdutos = supermercados.get(i).getProdutos().size();
			for(int j = 0; j < quantProdutos; j++) {
				if(produto.equals(supermercados.get(i).getProdutos().get(j).getNome())) {
					String nomeSuper = supermercados.get(i).getNome();
					Produto p = new Produto(supermercados.get(i).getProdutos().get(j).getNome(), 
							supermercados.get(i).getProdutos().get(j).getPreco());
					Supermercado s = new Supermercado( nomeSuper, new ArrayList<Produto>(Arrays.asList(p)));
					sups.add(s);
				}
			}
		}	
		return sups;
	} 
}
