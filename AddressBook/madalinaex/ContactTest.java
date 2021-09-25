package madalinaex;

public class ContactTest {

	public static void main(String[] args) {
		Contact a = new Contact("Madalina", "madalina@gmail.com");
		
		System.out.println("Contact:");
		a.output();
		
		System.out.println("Changed name:");
		a.setName("Laura");
		a.output();
		
		System.out.println("Changed email:");
		a.setEmail("laura@gmail.com");
		a.output();
	}

}
