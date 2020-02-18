// Gherman Maria Irina @ 324 CB

package tema1;
import java.io.IOException;

public class Main {

	public static void main (String[] args) throws Exception {
		// declarari de variabile ajutatoare
		String id = null;
		String name = null;
		Heap heap = new Heap();
		Pasager p = null;
		GroupType g = null;
		int age;
		char ticket;
		boolean priority_boarding;
		boolean special_needs;
		Database database = new Database();
		String buffer;
		String[ ] tokens = new String[20];
		ReadFromFile in = new ReadFromFile();
		// citim nr de pasageri
		int number_of_passangers = in.number();
		
		try {
			WriteToFile.init();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		// citim si stocam pasagerii
		for (int i = 0; i < number_of_passangers; i++) {
			buffer = in.line();
			tokens = buffer.split(" ");
			
			id = tokens[0];
			name = tokens[1];
			age = Integer.parseInt(tokens[2]);
			ticket = tokens[3].charAt(0);
			priority_boarding = Boolean.parseBoolean(tokens[4]);
			special_needs = Boolean.parseBoolean(tokens[5]);			
			p = new Pasager(name, age, ticket, priority_boarding, special_needs);
			
			switch(tokens[0].charAt(0)) {
			case 'f':
				if (database.exists(id) == false) {
					Family family = new Family(p, id);
					database.add(family);
				} else {
					database.get(id).add(p);
				}
				break;
				
			case 'g':
				if (database.exists(id) == false) {
					Group group = new Group(p, id);
					database.add(group);
				} else {
					database.get(id).add(p);
				}
				break;
				
			case 's':
				if (database.exists(id) == false) {
					Single single = new Single(p, id);
					database.add(single);
				} else {
					database.get(id).add(p);;
				}
				break;
			}
		}
		// citim comenzile
		while (in.in.hasNext()) {
			buffer = in.line();
			
			if (buffer.contains("insert")) {
				tokens = null; // ne asiguram ca nu raman date
				tokens = buffer.split(" ");
				id = tokens[1];
				heap.add(database.get(id));
			}

			if (buffer.equals("embark")) {
				//Pasager p = 
				heap.embark();
			}

			if (buffer.equals("list")) {
				heap.list();
				WriteToFile.buildBuffer(System.lineSeparator());
			}
			
			if (buffer.contains("delete")) {
				tokens = null; // ne asiguram ca nu raman date
				tokens = buffer.split(" ");
				
				if (tokens.length > 2) {
					g = database.get(id);
					p = database.getPerson(tokens[1], tokens[2]);
					heap.delete(p);
				} else {
					g = database.get(tokens[1]);
					heap.delete(g);
					database.database.remove(g);
				}
			}
		}
		// scriem in fisier tot ce am stocat in bufferul de scris
		try {
			WriteToFile.write();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		WriteToFile.out.close();
	}
}
