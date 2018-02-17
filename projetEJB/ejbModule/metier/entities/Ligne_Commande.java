package metier.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(Ligne_Commande_ID.class)
public class Ligne_Commande implements Serializable {
	/*@Id
	private Long id;*/
	@Id
	private Long idProduit;
	@Id
	private Long idCmd;
	@Column(name="quantite")
	private int qte;
	private double prix;
	
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
	
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public Produit getL_produit() {
		return l_produit;
	}
	public void setL_produit(Produit l_produit) {
		this.l_produit = l_produit;
	}
	public Ligne_Commande(Long idProduit, Long idCmd, int qte, double prix) {
		super();
		this.idProduit = idProduit;
		this.idCmd = idCmd;
		this.qte = qte;
		this.prix = prix;
	}
	public Ligne_Commande()
	{
		
	}
	
	@ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	@JoinColumn(name="idCmd", insertable = false, updatable = false)
	private Commande commande;
	
	@ManyToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	@JoinColumn(name="idProduit", insertable = false, updatable = false)
	private Produit l_produit ;
	
}
