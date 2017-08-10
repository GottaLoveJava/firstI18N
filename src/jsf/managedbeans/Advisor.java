package jsf.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@ManagedBean(name="advisor")
@SessionScoped
@Entity
public class Advisor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String forname;
	private String login;
	private String password;
	@OneToMany(mappedBy = "prof", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	private List<Customer> customers = new ArrayList<>();

	public Advisor() {
	}

	public Advisor(String name, String forname, String login, String password) {
		this.name = name;
		this.forname = forname;
		this.login=login;
		this.password=password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getForname() {
		return forname;
	}

	public void setForname(String forname) {
		this.forname = forname;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public void addCustomer(Customer customer) {
		customers.add(customer);
		customer.setAdvisor(this);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
