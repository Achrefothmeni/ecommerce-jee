package metier.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="COMPTES")
public class Compte implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCpt;
	
	@ManyToOne
	@JoinColumn(name="idClt")
	Client client;
	
	
	public 	Long getId() {
		return idCpt;
	}


	public void setId(Long idCpt) {
		this.idCpt = idCpt;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public Compte()
	{
		
	}

	public Compte(Long idCpt, Client client) {
		super();
		this.idCpt = idCpt;
		this.client = client;
	}
	
	
	
}
