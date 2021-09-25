// class to represent a binary tree

public class Branch extends Tree {
    private int elem;
    private Tree left;
    private Tree right;

    public Branch(int elem, Tree left, Tree right) {
	this.elem = elem;
	this.left = left;
	this.right = right;
    }

    public boolean empty() {
	return false;
    }

    public int max() {
	return right.empty() ? elem : right.max();
    }

    public boolean contains(int x) {
	if (x == elem)
	    // we've already found the element!
	    return true;
	else if (x < elem)
	    // since x < elem we only search in the left sub tree
	    
	    return left.contains(x);
	else
	    // since x > elem we only search in the right sub tree
	    return right.contains(x);
    }

    public Tree insert(int x) {
	if (x < elem)
	    left = left.insert(x);
	else if (x > elem)
	    right = right.insert(x);
	// if x == elem x already exists in the tree and we don't insert it
	return this;
    }

    public Tree remove(int x) {
	if (x == elem)
	    if (left.empty())
		// if left is empty we only have the right tree left
	    	return right;
	    else if (right.empty())
		// if right is empty we only have the left tree left
		return left;
	    else {		
		elem = left.max();		
		left = left.remove(elem);
		return this;
	    }
	else if (x < elem) {	    
	    left = left.remove(x);
	    return this;
	} else {	   
	    right = right.remove(x);
	    return this;
	}
    }

    public String toString() {
	return "Branch(" + elem + "," + left + "," + right + ")";
    }

    public int depth() {
	return 1 + Math.max(left.depth(), right.depth());
    }

    public int size() {
	return 1 + left.size() + right.size();
    }

    public int sum() {
	return elem + left.sum() + right.sum();
    }

    public boolean contains(int x, int n) {
	assert n >= 0;
	if (x == elem) return true;
	else if (x < elem && n > 0) return left.contains(x, n - 1);
	else if (x > elem && n > 0) return right.contains(x, n - 1);
	else return false;
    }

    public boolean balanced() {
	return Math.abs(left.depth() - right.depth()) <= 1
	    && left.balanced()
	    && right.balanced();
    }

    public Tree filter_le(int x) {
	if (x == elem) return new Branch(elem, left, new Leaf());
	else if (x < elem) return left.filter_le(x);
	else return new Branch(elem, left, right.filter_le(x));
    }

    public int get(int i) {
	int l = left.size();
	if (i < l) return left.get(i);
	else if (i == l) return elem;
	else return right.get(i - l - 1);
    }
}
