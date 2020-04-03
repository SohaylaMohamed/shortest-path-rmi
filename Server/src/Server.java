import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server{

	protected Server() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try {
			ClientClass g = new ClientClass();
			Naming.rebind("rmi://localhost/4116/hello", g);
			System.out.println("Ok");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
