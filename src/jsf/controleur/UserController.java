package jsf.controleur;

import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import jsf.managedbeans.Advisor;

@ManagedBean
public class UserController {

	private String login, password;
	private Advisor advisor = new Advisor();
	private static Map<String, Advisor> advisors;

	static {
		advisors = new HashMap<String, Advisor>();
		advisors.put("admin", new Advisor("Creac'h", "Yann", "admin", "admin"));
	}

	public UserController() {	}

	public String checkPassword() {
		Advisor a = advisors.get(login); 
		if (a != null && a.getPassword().equals(password)) {

			return "topics";
		}
		return "";
	}

	public String doInscription() {
		if (advisor.getLogin().equals(""))
			return "";
		advisors.put(advisor.getLogin(), advisor);

		return "topics";
	}

	public String logout() {

		return "accueil";
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

	public Advisor getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Advisor advisor) {
		this.advisor = advisor;
	}

	public static Map<String, Advisor> getAdvisors() {
		return advisors;
	}

	public static void setAdvisors(Map<String, Advisor> advisors) {
		UserController.advisors = advisors;
	}


}
