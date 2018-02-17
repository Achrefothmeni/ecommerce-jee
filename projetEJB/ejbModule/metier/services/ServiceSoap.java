package metier.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import metier.entities.Produit;
import metier.sessions.ILocal;

@Stateless
@WebService
public class ServiceSoap {
	
	@EJB
	private ILocal metier;
	
	@WebMethod
	public List<Produit> listeProduit()
	{
		return metier.listeProduit();
	}
	
	@WebMethod
	public Produit consulterProduit(@WebParam(name="id")Long idProduit)
	{
		return metier.consulterProduit(idProduit);
	}


}
