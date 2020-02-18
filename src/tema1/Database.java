package tema1;
import java.util.ArrayList;

/**
 * clasa in care sunt memorate toate grupurile
 */

public class Database {
	ArrayList<GroupType> database;

	/**
	 * initializeaza arraylist-ul
	 */
	
	public Database() {
		database = new ArrayList<GroupType>();
	}
	
	/**
	 * adauga un grup in database
	 * @param element elementul de adaugat
	 */
	
	public void add(GroupType element) {
		database.add(element);
	}
	
	/**
	 * metoda care verifica daca exista un grup
	 * @param id id-ul de cautat
	 */
	
	public boolean exists(String id) {
		if (get(id) != null) {
			return true;
		}
		return false;
	}
	
	/**
	 * cauta un grup dupa nume
	 */
	
	public GroupType get(String id) {
		for (int i = 0; i < database.size(); i++) {
			if (database.get(i).getId().equals(id)) {
				return database.get(i);
			}
		}
		return null;
	}
	
	/**
	 * cauta o persoana cu nume dat intr-un grup cu id dat
	 */
	
	public Pasager getPerson(String id, String name) {
		GroupType p = get(id);
		return p.get(name);
	}
}
