package servidor;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.Arrays;

import supermercado.ComprasImpl;
import supermercado.ComprasInterface;
import supermercado.Produto;
import supermercado.Supermercado;

public class Servidor {
	public Servidor(String ip, int port) {
		try {
			System.setProperty("java.rmi.server.hostname", ip);
			LocateRegistry.createRegistry(port);//Default rmi
			
			//Inicializando estaticamente
			System.out.println("Estanciando Supermercados");
			Produto p1 = new Produto("Acucar", (float) 2.90);
			Produto p2 = new Produto("Fuba¡", (float) 2.65);
			Produto p3 = new Produto("Feijao", (float) 8.05);
			Produto p4 = new Produto("Arroz", (float) 4.75);
			
			Produto p5 = new Produto("Macarrao", (float) 3.20);
			Produto p6 = new Produto("Cafe", (float) 4.50);
			Produto p7 = new Produto("Acucar", (float) 2.95);
			Produto p8 = new Produto("Feijao", (float) 7.90);
			
			Produto p9 = new Produto("Cafe", (float) 4.39);
			Produto p10 = new Produto("Arroz", (float) 4.70);
			Produto p11 = new Produto("Fuba", (float) 2.80);
			Produto p12 = new Produto("Macarrao", (float) 3.50);
			
			Produto p13 = new Produto("Feijao", (float) 7.95);
			Produto p14 = new Produto("Arroz", (float) 4.69);
			Produto p15 = new Produto("Cafe", (float) 4.40);
			Produto p16 = new Produto("Macarrao", (float) 2.99);
			
			Supermercado s1 = new Supermercado("mercado 1", new ArrayList<Produto>(Arrays.asList(p1, p2, p3, p4)));
			Supermercado s2 = new Supermercado("mercado 2", new ArrayList<Produto>(Arrays.asList(p5, p6, p7, p8)));
			Supermercado s3 = new Supermercado("mercado 3", new ArrayList<Produto>(Arrays.asList(p9, p10, p11, p12)));
			Supermercado s4 = new Supermercado("mercado 4", new ArrayList<Produto>(Arrays.asList(p13, p14, p15, p16)));
			
			
			ComprasInterface compras = new ComprasImpl(
					new ArrayList<Supermercado>(Arrays.asList(s1, s2, s3, s4)));
			System.out.println("Ouvindo...");
			Naming.bind("ComprasService", (Remote) compras);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String ip = "192.168.2.112";
		int port = 1099; //Integer.parseInt(args[1]); 
		new Servidor(ip, port);
	}
}
