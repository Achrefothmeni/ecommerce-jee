package metier.entities;

import java.io.Serializable;

public class Ligne_Commande_ID implements Serializable {

	private Long idProduit;
	private Long idCmd;
	
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public Long getIdCmd() {
		return idCmd;
	}
	public void setIdCmd(Long idCmd) {
		this.idCmd = idCmd;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCmd == null) ? 0 : idCmd.hashCode());
		result = prime * result + ((idProduit == null) ? 0 : idProduit.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ligne_Commande_ID other = (Ligne_Commande_ID) obj;
		if (idCmd == null) {
			if (other.idCmd != null)
				return false;
		} else if (!idCmd.equals(other.idCmd))
			return false;
		if (idProduit == null) {
			if (other.idProduit != null)
				return false;
		} else if (!idProduit.equals(other.idProduit))
			return false;
		return true;
	}
	
	
	
}
