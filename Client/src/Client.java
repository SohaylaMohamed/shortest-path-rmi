import java.rmi.Naming;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		try {
			ClientInterface h = (ClientInterface) Naming.lookup("rmi://192.168.43.102/4116/hello");
			while (true) {
				Scanner input = new java.util.Scanner(System.in);
				String command;
				System.out.println("Enter command");
				command = input.nextLine();
				System.out.println(h.executeQuery(command));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
