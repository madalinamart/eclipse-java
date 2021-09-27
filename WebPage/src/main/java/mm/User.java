package mm;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


//database MAPPING --> let's me put user info into database
@Entity
@Table( name = "USERS")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id", nullable=false, unique=true)
	private int id;

	/*User class that will be connected to the database
	 * user described by name, country and id
	 */
	
	@Column(name="firstname", length=40, nullable=false)
	private String firstName;
	
	@Column(name="lastname", length=40, nullable=false)
	private String lastName;
	
	@Column(name="country", length=40, nullable=true)
	private String country;
	
	public User(String fn, String ln, String country) {
		this.firstName = fn;
		this.lastName = ln;
		this.country = country;
	}
	
	//get and set methods for private variables
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastname) {
		this.lastName = lastname;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
}
