package fr.diginamic;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table 
(name="CLIENT")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	
	@Column(name = "nom")
	 private String nom;
	
	@Column(name = "prenom")
	 private String prenom;
	

    @OneToMany(mappedBy = "client")
    private List<Emprunt> emprunts;

	public Client() {

	};

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the emprunts
	 */
	public List<Emprunt> getEmprunts() {
		return emprunts;
	}

	/**
	 * @param emprunts the emprunts to set
	 */
	public void setEmprunts(List<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + "]";
	}
	
}
