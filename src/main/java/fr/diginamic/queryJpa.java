package fr.diginamic;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class queryJpa {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("recensement");
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();

			TypedQuery<Region> query = em.createQuery("SELECT r FROM Region r", Region.class);
			List<Region> regions = query.getResultList();

			Region nouvelleRegion = new Region();
			nouvelleRegion.setNom("Bourgogne");
			em.persist(nouvelleRegion);

			em.getTransaction().commit();

			Region rId = em.find(Region.class, 1);
			if (rId != null) {
				System.out.println("région récupérée par id: " + rId.getNom());
			} else {
				System.out.println("La région n'a pas été retrouvée.");
			}

			regions = query.getResultList();
			for (Region region : regions) {
				System.out.println(region.toString());
			}

		} catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}
}