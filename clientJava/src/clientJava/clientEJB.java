package clientJava;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import metier.entities.Categorie;
import metier.sessions.IRemote;

public class clientEJB
{
	
public static void main(String[] args) {
	
	
	LoginFrame f = new LoginFrame();
	f.setVisible(true);
	
	/*try {
		Context ctx = null;
		String appName="";
		String moduleName="projetEJB";
		//String distinctName="";
		String beanName="Ejb_Imp";
		String remoteInterface=IRemote.class.getName();
		String name="ejb:"+appName+"/"+moduleName+"/"+beanName+"!"+remoteInterface;
		Properties p = new Properties();
		final String PKG_INTERFACES = "org.jboss.ejb.client.naming";
		p.put(Context.URL_PKG_PREFIXES, PKG_INTERFACES);
		ctx = new InitialContext(p);
		IRemote proxy = (IRemote) ctx.lookup(name);
		
		proxy.addCategorie(new Categorie());
		} 
		catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/

}
}


