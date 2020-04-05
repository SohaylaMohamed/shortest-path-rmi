import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface extends Remote{
	String executeQuery(String query) throws RemoteException;
	boolean isReady() throws RemoteException;
}