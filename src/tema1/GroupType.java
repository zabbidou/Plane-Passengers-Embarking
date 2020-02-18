package tema1;

import java.util.ArrayList;

/**
 * Clasa care cuprinde toate tipurile de grupuri
 */

public abstract class GroupType extends Pasager implements Comparable<GroupType> {
	/** tipul de imbarcare */
	private boolean priority_boarding;
	/** tipul de bilet */
	private char ticket;
	/** cate persoane au handicap */
	private int nr_of_special_needs = 0;
	/** prioritatea adunata a tuturor membrilor in functie de varsta */
	private int age_priority;
	/** nr de persoane din grup */
	private int nr_of_people = 0;
	/** vectorul unde sunt stocate */
	private ArrayList<Pasager> people;

	/**
	 * Initializeaza arraylist-ul
	 */	
	
	public GroupType() {
		this.people = new ArrayList<Pasager>(5);
	}
	
	/**
	 * Initializeaza arraylist-ul si adauga o persoana
	 */

	public GroupType(Pasager p) {
		this.people = new ArrayList<Pasager>();
		this.ticket = p.getTicket();
		this.priority_boarding = p.isPriorityBoarding();
		this.add(p);
	}

	/**
	 * adauga o persoana
	 */
	
	public void add(Pasager p) {
		if (p.isSpecialNeeds()) {
			this.nr_of_special_needs++;
		}
		
		this.ticket = p.getTicket();
		this.priority_boarding = p.isPriorityBoarding();
		this.people.add(p);
		this.nr_of_people++;
		this.age_priority = this.age_priority + getAgePriority(p.getAge());
	}
	
	/**
	 * sterge o persoana
	 */
	
	public void remove(String name) {
		if (get(name).isSpecialNeeds()) {
			nr_of_special_needs--;
		}
		
		people.remove(get(name));
		nr_of_people--;
	}
	
	/**
	 * cauta o persoana dupa nume
	 * @return persoana
	 */
	
	public Pasager get(String name) {
		for (int i = 0; i < people.size() - 1; i++) {
			if (people.get(i).getName().equals(name)) {
				return people.get(i);
			}
		}
		return null;
	}
	
	public abstract int getGroupPriority();
	
	public abstract String getId();

	/**
	 * calculeaza prioritatea
	 */
	
	public int calculatePriority() {
		int priority_boarding;
		int ticket;

		if (this.priority_boarding) {
			priority_boarding = 30 * nr_of_people;
		} else {
			priority_boarding = 0;
		}

		if (this.ticket == 'b') {
			ticket = 35 * nr_of_people;
		} else if (this.ticket == 'p') {
			ticket = 20 * nr_of_people;
		} else {
			ticket = 0;
		}
		
		return this.getGroupPriority() + priority_boarding + ticket + (this.nr_of_special_needs * 100) + age_priority;
	}
	
	/**
	 * compara in functie de prioritate
	 */
	
	public int compareTo(GroupType g) {
		return g.calculatePriority() - this.calculatePriority();
	}
	
	/**
	 * calculeaza prioritatea pentru varsta
	 */
	
	private int getAgePriority(int age) {
		if (age < 2) {
			return 20;
		}
		
		if (age < 5) {
			return 10;
		}
		
		if (age < 10) {
			return 5;
		}
		
		if (age < 60) {
			return 0;
		}
		
		return 15; // age >= 60
	}
}

/**
 * clasa pentru familie
 */

class Family extends GroupType {
	private String id;
	protected int group_priority = 10;
	
	/**
	 * apeleaza super si seteaza id-ul
	 */
	
	public Family(String id) {
		super();
		this.id = id;
	}
	
	/**
	 * apeleaza super, seteaza id-ul si adauga prima persoana
	 */
	
	public Family(Pasager p, String id) {
		super(p);
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
	
	public int getGroupPriority() {
		return group_priority;
	}
}

/**
 * clasa pentru grup
 */

class Group extends GroupType {
	private String id;
	protected int group_priority = 5;
	
	/**
	 * apeleaza super si seteaza id-ul
	 */
	
	public Group(String id) {
		super();
		this.id = id;
	}
	
	/**
	 * apeleaza super, seteaza id-ul si adauga prima persoana
	 */
	
	public Group(Pasager p, String id) {
		super(p);
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
	
	public int getGroupPriority() {
		return group_priority;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", toString()=" + super.toString() + "]";
	}
}

/**
 * clasa pentru singur
 */

class Single extends GroupType {
	private String id;
	protected int group_priority = 0;
	
	/**
	 * apeleaza super si seteaza id-ul
	 */
	
	public Single(String id) {
		super();
		this.id = id;
	}
	
	/**
	 * apeleaza super, seteaza id-ul si adauga prima persoana
	 */
	
	public Single(Pasager p, String id) {
		super(p);
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
	
	public int getGroupPriority() {
		return group_priority;
	}
}