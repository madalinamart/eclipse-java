package madalinaex;

public class AddressBook {
	/* It cannot contain the same name
	 * number of contacts must be less than address book's length
	 */

	private int numOfContacts;
	private Contact[] contacts;
	
	public AddressBook() {
		//empty on default
	}
	
	public AddressBook(int maxNumOfContacts) {
		//In the beginning my address book is empty
		numOfContacts = 0;
		
		//my address book is full when I reach maxNumOfContacts
		contacts = new Contact[maxNumOfContacts];
	}
	
	public int getNumOfContacts() {
		return numOfContacts;
	}
	
	public void output() {
		int i = 0;
		
		System.out.println("Num. contacts = " + numOfContacts);
		while (i < numOfContacts) {
			contacts[i].output();
			i++;
		}
	}
	
	/* findIndex searches for index of contact name
	 * if the name is not there it returns numOfContacts
	 */
	private int findIndex(String n) {
		for (int i = 0; i < numOfContacts; i++) 
			if (contacts[i].getName().equalsIgnoreCase(n) ) 
				return i;
		 return numOfContacts;	
		
	}
	
	//using findIndex(String n) check if a contact exists
	public boolean present(String n) {
		return (findIndex(n) < numOfContacts);
	}
	
	//using findIndex(String n) check if the email corresponds
	public String findEmail(String n) {
		int i = findIndex(n);
		
		if(i < numOfContacts) {
			return contacts[i].getEmail();
		} else {
			return "";
		}
	}
	
	public boolean full() {
		return (numOfContacts == contacts.length);
	}
	
	public boolean add(String n, String e) {
		if (present(n))
			return false;
		if (full())
			return false;
		
		contacts[numOfContacts] = new Contact(n,e);
		numOfContacts++;
		return true;
	}
	
	public boolean remove(String n) {
		int i = findIndex(n);
		
		if(i == numOfContacts)  //the contact doesn't exist
			return false;
		
		//if it exists 
		numOfContacts--;
		contacts[i] = contacts[numOfContacts];
		return true;
	}
	
	
	//If i find contact name n i change it to n2
	public boolean changeName(String n, String n2) {
		int i = findIndex(n);
		int j = findIndex(n2);
		
		if ((i == numOfContacts) || (j < findIndex(n2)) ) //the contact n doesn't exist or contact n2 already exists
				return false;
		
		contacts[i].setName(n2);
		return true;
	}
	
	//If i find contact n i change its email to e2
	public boolean changeEmail(String n, String e2) {
		int i = findIndex(n);
		if (i == numOfContacts)
			return false;
	
		contacts[i].setEmail(e2);
		return true;
	}
}
