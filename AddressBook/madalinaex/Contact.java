package madalinaex;

public class Contact {
//every contact is defined by a name and an email 
	
	private String name;
	private String email;

	public Contact() {
		//empty by default
	}
	
	public Contact(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	//get and set methods for private variables
	public String getName() {return name;}
	public String getEmail() {return email;}
	public void setName(String n) {name = n;}
	public void setEmail(String e) {email = e;}
	
	public void output() {
		System.out.println(" - " + name + " : " + email);
	}
}
