package metier.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PRODUITS")
public class Produit implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProduit;
	
	@ManyToOne
	@JoinColumn(name="idCat")
	Categorie cat;
	
	@OneToMany(mappedBy="l_produit")
	private Collection <Ligne_Commande> ligne_cmd;
	
	@ManyToMany
	@JoinTable(name="Promotion_Produit",joinColumns= {@JoinColumn(name="idProduit")},inverseJoinColumns= {@JoinColumn(name="idProm")})
	private Collection<Promotion> promotion;
	
	
	private String designation;
	@Column(name="description", nullable=true)
	private String desc;
	private double prix;
	@Column(name="quantite")
	private int qte;
	private boolean selection;
	private String photo;
	
	
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public boolean isSelection() {
		return selection;
	}
	public void setSelection(boolean selection) {
		this.selection = selection;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public Categorie getCat() {
		return cat;
	}
	public void setCat(Categorie cat) {
		this.cat = cat;
	}
	public Collection<Ligne_Commande> getLigne_cmd() {
		return ligne_cmd;
	}
	public void setLigne_cmd(Collection<Ligne_Commande> ligne_cmd) {
		this.ligne_cmd = ligne_cmd;
	}
	public Collection<Promotion> getPromotion() {
		return promotion;
	}
	public void setPromotion(Collection<Promotion> promotion) {
		this.promotion = promotion;
	}
	public Produit(String designation, String desc, double prix, int qte, boolean selection, String photo) {
		super();
		this.designation = designation;
		this.desc = desc;
		this.prix = prix;
		this.qte = qte;
		this.selection = selection;
		this.photo = photo;
	}
	
	public Produit()
	{
		
	}
	
	
}
