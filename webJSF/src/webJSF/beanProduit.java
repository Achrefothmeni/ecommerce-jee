package webJSF;

import java.util.List;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import metier.entities.Produit;
import metier.sessions.ILocal;

@ManagedBean
@SessionScoped
public class beanProduit {

	@EJB
	private ILocal metier;
	public List<Produit> listeProduit()
	{
		return metier.listeProduit();
	}
}
