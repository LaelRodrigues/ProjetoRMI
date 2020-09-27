package cliente;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Scanner;

import supermercado.ComprasInterface;
import supermercado.Supermercado;


public class Cliente {
	public static void main(String[] args) {
		String ip = "192.168.2.112";
		String port = "1099";
		try {
			ComprasInterface c = (ComprasInterface) Naming.lookup("rmi://"+ip+":"+port+"/ComprasService");
			System.out.println("O que deseja comprar?");
			Scanner in = new Scanner(System.in);
			String produto = "";
			ArrayList<String> listaCompras = new ArrayList<String>();
			while(!produto.equals("ok")) {
				produto = in.nextLine();
				if (!produto.equals("ok")) {
					listaCompras.add(produto);
				}
			}
			in.close();
			System.out.println("Consultando...");
			
			//Espera o resultado do servidor
			ArrayList<Supermercado> s = c.menorValorProduto(listaCompras);
			
			//Imprime na tela
			System.out.println("Lista dos produtos com o menor preco");
			System.out.println();
			for(int i = 0; i < s.size(); i++) {
				if(s.get(i).getNome().equals("produto nao encontrado")) {
					System.out.println("O produto '"+ s.get(i).getProdutos().get(0).getNome()+"' nao foi encontrado");
					System.out.println();
				} else {
					System.out.println("----------- "+ s.get(i).getProdutos().get(0).getNome()+" -----------");
					System.out.println();
					System.out.println("nome do supermercado: "+ s.get(i).getNome());
					System.out.println("preco do produto: "+ s.get(i).getProdutos().get(0).getPreco());
					System.out.println();
					System.out.print("Supermercados consultados: ");
					ArrayList<Supermercado> supsConsultados = c.mercadosConsultado(listaCompras.get(i));
					for(int j = 0; j < supsConsultados.size(); j++) {
						System.out.print("'"+supsConsultados.get(j).getNome()+ "' ");
					}
					System.out.println();
				}
			
			}
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
