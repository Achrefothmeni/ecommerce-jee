package metier.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Categories")
public class Categorie implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCat;
	@Column(name="nomCategorie")
	private String nomCat;
	@Column(nullable = true)
	private String photo;
	@Column(name="description")
	private String desc;
	
	@OneToMany(mappedBy="cat", cascade=CascadeType.ALL)
	private Collection<Produit> produit;
	
	
	
	public Collection<Produit> getProduit() {
		return produit;
	}
	public void setProduit(Collection<Produit> produit) {
		this.produit = produit;
	}
	
	public Long getIdCat() {
		return idCat;
	}
	public void setIdCat(Long idCat) {
		this.idCat = idCat;
	}
	public String getNomCat() {
		return nomCat;
	}
	public void setNomCat(String nomCat) {
		this.nomCat = nomCat;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Categorie(String nomCat, String photo, String desc) {
		super();
		this.nomCat = nomCat;
		this.photo = photo;
		this.desc = desc;
	}
	public Categorie()
	{
		
	}

}
