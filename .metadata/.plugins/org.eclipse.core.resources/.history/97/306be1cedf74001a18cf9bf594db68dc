import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IGraph extends Remote{
	void addEdge(int src, int dst) throws RemoteException;
	void removeEdge (int src, int dst)  throws RemoteException;
	int getShortestPath(int src, int dst) throws RemoteException;
}
