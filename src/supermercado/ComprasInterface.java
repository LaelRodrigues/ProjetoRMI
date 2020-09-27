package supermercado;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ComprasInterface extends Remote{
	
	public ArrayList<Supermercado> menorValorProduto(
			ArrayList<String> listaDeCompras) throws RemoteException;

}
