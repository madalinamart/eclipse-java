
public class Ex1 {
	/* 
	 * add a 'modify' that adds in the last place of a 
	 * list the sum of all positive elements.
	 *
	 * Examples:
	 *
	 * before :
	 * after : 0
	 *
	 * before : 5
	 * after  : 5, 5
	 *
	 * before : 5, -3, 1
	 * after  : 5, -3, 1, 6
	 *
	 * before : -1, -1, -6
	 * after  : -1, -1, -6, 0
	 *
	
	 */

	class Node {
	    private int elem;
	    private Node next;

	    public Node(int elem, Node next)
	    {
		this.elem = elem;
		this.next = next;
	    }

	    public int getElem()
	    { return elem; }

	    public void setElem(int elem)
	    { this.elem = elem; }

	    public Node getNext()
	    { return next; }

	    public void setNext(Node next)
	    { this.next = next; }
	}

	class List {
	    private Node first;

	    public List()
	    { first = null; }

	    public void insertFirst(int elem)
	    { first = new Node(elem, first); }

	    public String toString()
	    {
		String s = "";
		for (Node p = first; p != null; p = p.getNext()) {
		    if (p != first) s += ", ";
		    s += p.getElem();
		}
		return s;
	    }

	    public void modify()
	    {
		Node prev = null;
		Node p = first;
		int s = 0;
		while (p != null) {
		    if (p.getElem() > 0) s = s + p.getElem();
		    prev = p;
		    p = p.getNext();
		}
		if (prev == null) first = new Node(s, null);
		else prev.setNext(new Node(s, null));
	    }
	}
}
