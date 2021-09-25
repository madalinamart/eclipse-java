

	// Leaf used for empty trees

	public class Leaf extends Tree {
	    public Leaf() { }

	    public boolean empty() {
		return true;
	    }

	    public int max() {
		// cannot invoke max on empty tree
		assert false;
		// i have to return something because method returns 0
		return 0;
	    }

	    public boolean contains(int x) {
		return false;
	    }

	    public Tree insert(int x) {
		return new Branch(x, this, this);
	    }

	    public Tree remove(int x) {
		return this;
	    }

	    
	    public String toString() {
		return "Leaf";
	    }

	    public int depth() {
		return 0;
	    }

	    public int size() {
		return 0;
	    }

	    public int sum() {
		return 0;
	    }

	    public boolean contains(int x, int n) {
		return false;
	    }

	    public boolean balanced() {
		return true;
	    }

	    public Tree filter_le(int x) {
		return this;
	    }

	    public int get(int i) {
		assert false;
		return 0;
	    }
	}


