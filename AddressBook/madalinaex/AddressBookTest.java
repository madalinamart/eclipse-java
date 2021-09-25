package madalinaex;

public class AddressBookTest {

	public static void main(String[] args) {
		AddressBook R = new AddressBook(3);
		
		R.add("a","a@yahoo.com");
		R.add("b","b@yahoo.com");
		R.add("c","c@yahoo.com");
		R.output();
		
		System.out.println("c's email is:" + R.findEmail("c"));
		
		System.out.println();
		System.out.println("remove a:");
		R.remove("a");
		R.output();
		
	}

}
