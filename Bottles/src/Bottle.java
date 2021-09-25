
public class Bottle implements Comparable<Bottle> {
	private int capacity;
	private int wlevel;   //water level
	
	public Bottle(int capacity) {
		this.capacity = capacity;
		wlevel = 0;
		
		assert (0 <= wlevel) && (wlevel <= capacity );
	}
	
	//add a quantity of water, method returns how much water we added actually
	public int add(int quantity) {
		assert quantity >= 0: "quantity must be >=";
		
		int added = Math.min(quantity, this.capacity - this.wlevel);
		wlevel = wlevel + added;
		assert (0 <= wlevel) && (wlevel <= capacity );
		return added;
	}
	
	//remove a quantity of water, method returns removed quantity
	public int remove(int quantity) {
		assert quantity >= 0: "quantity must be >=";
		int removed = Math.min(quantity,wlevel);
		wlevel = wlevel - removed;
		assert (0 <= wlevel) && (wlevel <= capacity );
		return removed;
	}
	
	public int getCapacity() {return this.capacity;}
	public int getWLevel() {return this.wlevel;}
	
	//not allowed to change capacity --> no set method
	
	public void setWLevel(int wlevel) {
		assert (0 <= wlevel) && (wlevel <= capacity );
		this.wlevel=wlevel;
	}
	
	public String toString() {
		return wlevel + "/" + capacity;
	}
	
	/* method returns:
	 * 0 if bottles have the same level
	 * >0 if this.bottle has bigger level than b bottle
	 * else <0
	 */
	public int compareTo(Bottle b) {
		return this.wlevel - b.wlevel;
	}

}
