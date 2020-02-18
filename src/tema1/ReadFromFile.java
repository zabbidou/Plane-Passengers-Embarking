package tema1;
import java.io.*;
import java.util.Scanner;

/**
 * Clasa ajutatoare pentru a facilita citirea din fisier
 *
 */

public class ReadFromFile {
	Scanner in;
	
	/**
	 * initializeaza stream-ul
	 */
	
	public ReadFromFile() {
		try {
			this.in = new Scanner(new File("queue.in"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found!!!!!");
		}
	}
	
	/**
	 * citeste un int
	 */
	
	public int number() {
		if (in.hasNextInt()) {
			int temp = in.nextInt();
			in.nextLine();
			return temp;
		}
		return -1;
	}
	
	/**
	 * citeste o linie
	 */
	
	public String line() {
		if (in.hasNextLine()) {
			return in.nextLine();
		}
		return null;
	}
}

/**
 * clasa ajutatoare pentru a facilita scrierea in fisier
 */

final class WriteToFile {
	static FileWriter out;
	static File file = new File("queue.out");
	static String buffer = "";
	
	/**
	 * initializeaza file writer-ul
	 */
	
	public static void init() throws IOException {
		out = new FileWriter(file, true);
	}
	
	/**
	 * adauga la buffer-ul de scriere
	 */
	
	public static void buildBuffer(String data) {
		buffer = buffer.concat(data);
	}
	
	/**
	 * scrie buffer-ul
	 */
	
	public static void write() throws IOException {
		out.write(buffer.trim());
	}
}