package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
//		Pessoa p1 = new Pessoa(null, "foo bar", "foo@gmail.com");
//		Pessoa p2 = new Pessoa(null, "foo2 bar", "foo2@gmail.com");
//		Pessoa p3 = new Pessoa(null, "foo3 bar", "foo3@gmail.com");
//		
		//Instanciate EntityManager and Entity Manager Factory
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
//		
		// save records
//		em.getTransaction().begin();
//		em.persist(p1);
//		em.persist(p2);
//		em.persist(p3);
//		em.getTransaction().commit();
		
		// get records
		Pessoa p = em.find(Pessoa.class, 2);
		System.out.println(p);
		
		// delete, precisa achar primeiro o record para deletar (monitorado)
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		// close connection
		em.close();
		emf.close();
		System.out.println("done!");
	}

}
