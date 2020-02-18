package tema1;
import java.util.ArrayList;

/**
 * clasa heap.
 */

public class Heap {
	private ArrayList<Pasager> heap;
	
	public Heap() {
		heap = new ArrayList<Pasager>();
	}
	
	/**
	 * schimba 2 noduri intre ele
	 * @param first primul nod de schimbat
	 * @param second al doilea nod de schimbat
	 */
	
	private void swap(int first, int second) {
		Pasager temp;
		temp = heap.get(first);
		heap.set(first, heap.get(second));
		heap.set(second, temp);
	}
	
	/**
	 * adauga un nod si face heapify
	 * @param g grupul de adaugat
	 */
	
	public void add(Pasager g) {
		heap.add(g);
		if (heap.size() > 1) {
			heapifyUp(heap.size() - 1);
		}
	}
	
	/**
	 * sterge un nod sau un pasager dintr-un grup.
	 * @param p chestia de sters
	 */
	
	public void delete(Pasager p) {
		if (p instanceof GroupType) {
			for (int i = 0; i < heap.size() - 1; i++) {
				if (heap.get(i).equals(p)) {
					swap(i, heap.size() - 1);
					heap.remove(heap.size() - 1);
					heapifyDown(i);
				}
			}
		} else {
			for (int i = 0; i < heap.size() - 1; i++) {
				Pasager temp = ((GroupType)heap.get(i)).get(p.getName());
				if (temp != null) {
					((GroupType)heap.get(i)).remove(p.getName());
					heapifyDown(i);
				}
			}
		}
	}
	
	/**
	 * face heapify in sus / sift up
	 * @param pos pozitia de unde incepe
	 */
	
	private void heapifyUp(int pos) {
		int parent = (pos - 1) / 2;
		
		if (((GroupType)heap.get(parent)).compareTo((GroupType)heap.get(pos)) > 0) {
			swap(parent, pos);
			heapifyUp(parent);
		}
	}

	/**
	 * sift down
	 * @param pos pozitia de unde inncepe
	 */
	
	private void heapifyDown(int pos) {
		if (pos >= heap.size() - 1) {
			return;
		}
		
		int l = 2 * pos + 1; // left child
		int r = 2 * pos + 2; // right child
		int s = heap.size(); // size

		if (r < s && 
			((GroupType)heap.get(r)).compareTo(((GroupType)heap.get(pos))) < 0 &&
			((GroupType)heap.get(r)).compareTo(((GroupType)heap.get(l))) < 0) {
			swap(r, pos);
			heapifyDown(r);
		} else if (l < s 
				   && ((GroupType)heap.get(l)).compareTo(((GroupType)heap.get(pos))) < 0) {
			swap(l, pos);
			heapifyDown(l);
		}	   
	}
	
	/**
	 * afisarea
	 */
	
	public void list() {
		recursiveList(0);
	}
	
	/**
	 * metoda ajutatoare pentru afisare
	 * @param index index-ul curent
	 */
	
	public void recursiveList(int index) {
		if (index < 0 || index >= heap.size()) {
			return;
		}
		
		WriteToFile.buildBuffer(((GroupType)heap.get(index)).getId());
		WriteToFile.buildBuffer(" ");
		
		recursiveList((2 * index) + 1);
		recursiveList((2 * index) + 2);
	}
	
	/**
	 * scoate maximul din heap
	 * @return grupul cu prioritatea cea mai mare
	 */
	
	public Pasager embark() {
		if (heap.size() == 0) {
			return null;
		}

		Pasager p = heap.get(0);
		heap.set(0, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		
		heapifyDown(0);
		
		return p;
	}
}