import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import metier.entities.Produit;
import metier.sessions.ILocal;

@Stateless
@Path("/produit")
public class ServiceRest {
	
	@EJB
	private ILocal metier;

	@GET
	@Path(value="/produits")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produit> listeProduit()
	{
		return metier.listeProduit();
	}
	
	@GET
	@Path(value="/produitParID/{Identifiant}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produit> getProduit(@PathParam(value="Identifiant")Long idProduit)
	{
		return metier.consulterProduit(idProduit);
	}
}
