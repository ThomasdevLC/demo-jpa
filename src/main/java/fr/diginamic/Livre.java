package fr.diginamic;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "LIVRE")
public class Livre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "titre")
	private String titre;

	@Column(name = "auteur")
	private String auteur;

	@ManyToMany
	@JoinTable(name = "compo", joinColumns = @JoinColumn(name = "id_livre", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "id_emprunt", referencedColumnName = "id"))
	private Set<Emprunt> emprunts;
	
	//constructeur sans parametre : utilisé par Hibernate
	public Livre() {

	};
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @return the auteur
	 */
	public String getAuteur() {
		return auteur;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @param auteur the auteur to set
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + "]";
	}

}
