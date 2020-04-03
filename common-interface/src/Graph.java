import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;

public class Graph extends UnicastRemoteObject implements IGraph, Serializable {

	private static final long serialVersionUID = 1L;
	private int v = 100;
	private LinkedList<Integer> adj[];

	public Graph() throws RemoteException {
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList();
		}
	}

	@Override
	public void addEdge(int v, int w) {
		adj[v].add(w);
	}

	LinkedList<Integer> getEdges(int v) {
		return adj[v];
	}

	@Override
	public void removeEdge(int v, int w) {
		adj[v].remove(adj[v].indexOf(w));
	}

	@Override
	public int getShortestPath(int src, int dst) {
		int shortest = ShortestPath.findShortestPath(this, src, dst, 0);
        return shortest;
	}
	
	
}
