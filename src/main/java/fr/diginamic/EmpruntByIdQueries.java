package fr.diginamic;

import java.util.Set;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmpruntByIdQueries {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotheque");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        int idEmprunt = 1;
        Emprunt emprunt = em.find(Emprunt.class, idEmprunt);
        
        if (emprunt != null) {
            Set<Livre> livres = emprunt.getLivres();
            System.out.println("Emprunt " + idEmprunt + " trouvé ");
            System.out.println("Livres empruntés : ");
            for (Livre livre : livres) {
                System.out.println(livre); 
            }
        } else {
            System.out.println("Aucun emprunt trouvé avec l'ID : " + idEmprunt);
        }

        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
}

