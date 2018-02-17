package metier.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Promotions")
public class Promotion implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idPromotion")
	private Long idProm;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_debut_promotion")
	private Date dateDprom;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_fin_promotion")
	private Date dateFprom;
	
	@ManyToMany
	@JoinTable(name="Promotion_Produit",joinColumns= {@JoinColumn(name="idProm")},inverseJoinColumns= {@JoinColumn(name="idProduit")})
	private Collection<Produit> produit;
	
	public Long getIdProm() {
		return idProm;
	}
	public void setIdProm(Long idProm) {
		this.idProm = idProm;
	}
	public Date getDateDprom() {
		return dateDprom;
	}
	public void setDateDprom(Date dateDprom) {
		this.dateDprom = dateDprom;
	}
	public Date getDateFprom() {
		return dateFprom;
	}
	public void setDateFprom(Date dateFprom) {
		this.dateFprom = dateFprom;
	}
	public Promotion(Date dateDprom, Date dateFprom) {
		super();
		this.dateDprom = dateDprom;
		this.dateFprom = dateFprom;
	}
	public Promotion()
	{
		
	}
	
	

}
