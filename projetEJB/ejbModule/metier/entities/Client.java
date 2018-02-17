package metier.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTS")
public class Client implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idClt;
	
	@OneToMany(mappedBy="client", cascade=CascadeType.ALL)
	private Collection<Compte> compte;
	
	@OneToMany(mappedBy="clt", cascade=CascadeType.ALL)
	private Collection<Commande> commande;
	
	private String nomClt;
	private String adrClt;
	private String emailClt;
	private String telClt;
	
	
	
	
	public Collection<Commande> getCommande() {
		return commande;
	}
	public void setCommande(Collection<Commande> commande) {
		this.commande = commande;
	}
	public Collection<Compte> getCompte() {
		return compte;
	}
	public void setCompte(Collection<Compte> compte) {
		this.compte = compte;
	}
	
	public Long getIdClt() {
		return idClt;
	}
	public void setIdClt(Long idClt) {
		this.idClt = idClt;
	}
	
	public String getNomClt() {
		return nomClt;
	}
	public void setNomClt(String nomClt) {
		this.nomClt = nomClt;
	}
	public String getAdrClt() {
		return adrClt;
	}
	public void setAdrClt(String adrClt) {
		this.adrClt = adrClt;
	}
	public String getEmailClt() {
		return emailClt;
	}
	public void setEmailClt(String emailClt) {
		this.emailClt = emailClt;
	}
	public String getTelClt() {
		return telClt;
	}
	public void setTelClt(String telClt) {
		this.telClt = telClt;
	}
	public Client(String nomClt, String adrClt, String emailClt, String telClt) {
		super();
		this.nomClt = nomClt;
		this.adrClt = adrClt;
		this.emailClt = emailClt;
		this.telClt = telClt;
	}
	public Client()
	{
		
	}
	
	
}
