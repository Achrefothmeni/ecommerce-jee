package metier.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="COMMANDES")
public class Commande implements Serializable {
	
	private String modePaiement;
	
	
	@Id	
	@GeneratedValue
	(strategy=GenerationType.IDENTITY)
	private Long idCmd;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCmd;
	
	@ManyToOne
	@JoinColumn(name="idClt")
	Client clt;
	
	@OneToMany(mappedBy="commande")
	private Collection<Ligne_Commande> ligne_commande;
	
	
	
	public Client getClt() {
		return clt;
	}
	public void setClt(Client clt) {
		this.clt = clt;
	}
	public Collection<Ligne_Commande> getLigne_commande() {
		return ligne_commande;
	}
	public void setLigne_commande(Collection<Ligne_Commande> ligne_commande) {
		this.ligne_commande = ligne_commande;
	}
	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}
	public Long getIdCmd() {
		return idCmd;
	}
	public void setIdCmd(Long idCmd) {
		this.idCmd = idCmd;
	}
	public Date getDateCmd() {
		return dateCmd;
	}
	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
	}
	
	//@Enumerated(EnumType.STRING)
	public String getModePaiement()
	{
		return modePaiement;
	}
	public Commande(String modePaiement, Date dateCmd) {
		super();
		this.modePaiement = modePaiement;
		this.dateCmd = dateCmd;
	}
	
	public Commande()
	{
		
	}
	
	
	
	

}
