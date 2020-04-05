import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.Naming;
import java.util.Scanner;

public class Client {

	public static File writeStringToFile(String content, String id) throws IOException {
		File file = new File("output" + id + ".txt");
		FileWriter fr = new FileWriter(file, false);
		BufferedWriter br = new BufferedWriter(fr);
		PrintWriter pr = new PrintWriter(br);
		pr.println(content);
		pr.close();
		br.close();
		fr.close();
		return file;
	}

	public static String getCommand(File inputFile) throws FileNotFoundException {
		String s = "";
		Scanner sc = new Scanner(inputFile);
		if (sc.hasNext()) {
			s = sc.nextLine();
		}
		return s;
	}

	public static void main(String[] args) {
		try {
			System.out.println("Write command");
			ClientInterface h = (ClientInterface) Naming.lookup("rmi://localhost/31715/hello");
			Scanner input = new Scanner(System.in);
			String command = input.nextLine();
			long start = System.currentTimeMillis();
			String response = h.executeQuery(command);
			long end = System.currentTimeMillis();
			long elapsedTime = end - start;
			System.out.println(response);
			writeStringToFile(elapsedTime + "", "0");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}