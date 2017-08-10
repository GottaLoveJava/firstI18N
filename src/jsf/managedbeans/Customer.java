package jsf.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@ManagedBean
@SessionScoped
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	private String forname;
	private double soldeCC;
	private double soldeCE;
	private String address;
	@ManyToOne
	private Advisor advisor;

	public Customer(String name, String forname, String address) {
		this.name = name;
		this.forname = forname;
		this.address = address;
	}

	
	public Customer(String name, String forname, String address, Advisor advisor) {
		this.name = name;
		this.forname = forname;
		this.address = address;
		this.advisor = advisor;
	}


	public Customer() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public double getSoldeCC() {
		return soldeCC;
	}

	public void setSoldeCC(double soldeCC) {
		this.soldeCC = soldeCC;
	}

	public double getSoldeCE() {
		return soldeCE;
	}

	public void setSoldeCE(double soldeCE) {
		this.soldeCE = soldeCE;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Advisor getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Advisor advisor) {
		this.advisor = advisor;
	}

}
