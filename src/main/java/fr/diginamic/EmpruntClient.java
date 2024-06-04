package fr.diginamic;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmpruntClient {
	
	 public static void main(String[] args) {

	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotheque");
	        EntityManager em = emf.createEntityManager();

	        em.getTransaction().begin();

	        int idClient = 1;
	        Client client = em.find(Client.class, idClient);
	        
	        if (client != null) {
	            List<Emprunt> emprunts = client.getEmprunts();
	            System.out.println("client " + idClient + " trouvé ");
	            System.out.println("emprunts : ");
	            for (Emprunt emprunt : emprunts) {
	                System.out.println(emprunt); 
	            }
	        } else {
	            System.out.println("Aucun client trouvé avec l'ID : " + idClient);
	        }

	        em.getTransaction().commit();
	        
	        em.close();
	        emf.close();
	    }

}
