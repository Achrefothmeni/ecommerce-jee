package metier.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cart {
	
	 private Produit produit;
	    private int qte;
	    HashMap<Integer, Produit> cartItems;
	    List<Produit> items;
	    
	    
	    public Cart(){
	     cartItems = new  HashMap<Integer, Produit>();
	      
	    }
	    
	    public HashMap<Integer, Produit> getCartItems(){
	        return cartItems;
	    }
	    
	    public void addToCart(Produit produit, Integer qte){
	        cartItems.put(qte, produit);
	    }
	     
	    
	    public Cart(Produit produit, int qte) {
	        this.produit = produit;
	        this.qte = qte;
	    }

	    public Produit getProduit() {
	        return produit;
	    }

	    public void setProduit(Produit produit) {
	        this.produit = produit;
	    }

	    public int getQte() {
	        return qte;
	    }

	    public void setQte(int qte) {
	        this.qte = qte;
	    }

}
