package supermercado;

import java.util.ArrayList;
import java.util.Arrays;

public class teste {

	public static void main(String args[]) {
		
		Produto p1 = new Produto("Açúcar", (float) 2.90);
		Produto p2 = new Produto("Fubá", (float) 2.65);
		Produto p3 = new Produto("Feijão", (float) 8.05);
		Produto p4 = new Produto("Arroz", (float) 4.75);
		
		Produto p5 = new Produto("Macarrão", (float) 3.20);
		Produto p6 = new Produto("Café", (float) 4.50);
		Produto p7 = new Produto("Açucar", (float) 2.95);
		Produto p8 = new Produto("Feijão", (float) 7.90);
		
		Produto p9 = new Produto("Café", (float) 4.39);
		Produto p10 = new Produto("Arroz", (float) 4.70);
		Produto p11 = new Produto("Fubá", (float) 2.80);
		Produto p12 = new Produto("Macarrão", (float) 3.50);
		
		Produto p13 = new Produto("Feijão", (float) 7.95);
		Produto p14 = new Produto("Arroz", (float) 4.69);
		Produto p15 = new Produto("Café", (float) 4.40);
		Produto p16 = new Produto("Macarrão", (float) 2.99);
		
		Supermercado s1 = new Supermercado("mercado 1", new ArrayList<Produto>(Arrays.asList(p1, p2, p3, p4)));
		Supermercado s2 = new Supermercado("mercado 2", new ArrayList<Produto>(Arrays.asList(p5, p6, p7, p8)));
		Supermercado s3 = new Supermercado("mercado 3", new ArrayList<Produto>(Arrays.asList(p9, p10, p11, p12)));
		Supermercado s4 = new Supermercado("mercado 4", new ArrayList<Produto>(Arrays.asList(p13, p14, p15, p16)));
		
		Compras c = new Compras(new ArrayList<Supermercado>(Arrays.asList(s1, s2, s3, s4)));
		String v[] = {"cafee", "Arroz"};
		ArrayList<Supermercado> s = c.menorValorProduto(new ArrayList<String> (Arrays.asList(v)));
		
		System.out.println("     Lista dos produtos com o menor preço");
		System.out.println();
		for(int i = 0; i < s.size(); i++) {
			if(s.get(i).getNome().equals("produto nao encontrado")) {
				System.out.println("O produto '"+ s.get(i).getProdutos().get(0).getNome()+"' não foi encontrado");
				System.out.println();
			} else {
				System.out.println("----------- "+ s.get(i).getProdutos().get(0).getNome()+" -----------");
				System.out.println();
				System.out.println("nome do supermercado: "+ s.get(i).getNome());
				System.out.println("preço do produto: "+ s.get(i).getProdutos().get(0).getPreco());
				System.out.println();
				System.out.print("Supermercados consultados: ");
				ArrayList<Supermercado> supsConsultados = c.mercadosConsultados(v[i]);
				for(int j = 0; j < supsConsultados.size(); j++) {
					System.out.print("'"+supsConsultados.get(j).getNome()+ "' ");
				}
			}
		
		}
	}
}