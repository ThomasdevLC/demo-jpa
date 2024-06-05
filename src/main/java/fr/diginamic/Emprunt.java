package fr.diginamic;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "EMPRUNT")
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date_debut")
    private Date dateDebut;

    @Column(name = "date_fin")
    private Date dateFin;

    @Column(name = "delai")
    private int delai;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;
    
    @ManyToMany
    @JoinTable(name="compo", 
               joinColumns= @JoinColumn(name="id_emprunt", referencedColumnName="id"),
               inverseJoinColumns= @JoinColumn(name="id_livre", referencedColumnName="id")
    )
    private Set<Livre> livres;
    

    public Emprunt() {
        
    };

    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the dateDebut
     */
    public Date getDateDebut() {
        return dateDebut;
    }

    /**
     * @return the dateFin
     */
    public Date getDateFin() {
        return dateFin;
    }

    /**
     * @return the delai
     */
    public int getDelai() {
        return delai;
    }

    /**
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param dateDebut the dateDebut to set
     */
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * @param dateFin the dateFin to set
     */
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * @param delai the delai to set
     */
    public void setDelai(int delai) {
        this.delai = delai;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Client client) {
        this.client = client;
    }

	/**
	 * @return the livres
	 */
	public Set<Livre> getLivres() {
		return livres;
	}

	/**
	 * @param livres the livres to set
	 */
	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}

	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", delai=" + delai
				+ ", client=" + client + ", livres=" + livres + "]";
	}
	
	
}
