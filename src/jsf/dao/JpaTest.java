package jsf.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jsf.managedbeans.Advisor;
import jsf.managedbeans.Customer;

public class JpaTest {

	public static void main(String[] args) {
		createCustomer();

	}


	public static void createCustomer() {
		Advisor yann = new Advisor("Yann", "Creac'h","yann","jee");
		Advisor amel = new Advisor("Amel", " Kerai", "system", "BOURNE");
		Customer francois = new Customer( "Destremau", "Francois", "49 avenue du Roule", yann);
		Customer cyril = new Customer("Rabineau","Cyril", "15 avenue de Montmartre", yann);
			yann.addCustomer(francois);
			yann.addCustomer(cyril);
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-pu");
			EntityManager em = emf.createEntityManager();
			EntityTransaction tnx = em.getTransaction();
			tnx.begin();
			em.persist(yann);
			em.persist(amel);
			tnx.commit();
			em.close();
	}

		

}