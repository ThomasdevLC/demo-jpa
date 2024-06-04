package fr.diginamic;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LivreQuery {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotheque");
		EntityManager em = emf.createEntityManager();

		int idLivre = 1;
		Livre livre = em.find(Livre.class, idLivre);

		if (livre != null) {
			System.out.println("Livre trouvé : ");
			System.out.println(livre.toString());
		} else {
			System.out.println("Aucun livre trouvé avec l'ID : " + idLivre);

//		 em.getTransaction().isActive()
//		em.getTransaction().rollback();
//			

			em.close();
			emf.close();

		}
	}
}