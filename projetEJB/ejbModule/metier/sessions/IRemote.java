package metier.sessions;

import java.util.List;

import javax.ejb.Remote;

import metier.entities.Categorie;
import metier.entities.Produit;
import metier.entities.Promotion;
import metier.entities.User;

@Remote 
public interface IRemote {
	public void addProduit(Produit prd);
	public void addPromotion(Promotion prm);
	public void addCategorie(Categorie cat);
	public void addUser(User user);
	public void updateProduit(Produit prd);
	public void updatePromotion(Promotion prm);
	public void updateCategorie(Categorie cat);
	public void deleteProduit(Long idProduit);
	public void deletePromotion(Long idProm);
	public void deleteCategorie(Long idCat);
	public void deleteUser(Long idUser);
	public User getUser(String login, String password);
	public Categorie getCategorie(String cat);
	public Categorie getCatID(Long id);
	public List<Categorie> listeCategorie();
	public List<Produit> listeProduit();
	public Produit consulterProduit(Long idProduit);
	
		
}
