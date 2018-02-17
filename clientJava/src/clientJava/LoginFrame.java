package clientJava;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import metier.entities.User;
import metier.sessions.IRemote;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField loginField;
	private JTextField passField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		try {
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
			final IRemote proxy = (IRemote) ctx.lookup(name);
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 344, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		loginField = new JTextField();
		loginField.setBounds(126, 103, 133, 20);
		contentPane.add(loginField);
		loginField.setColumns(10);
		
		passField = new JTextField();
		passField.setColumns(10);
		passField.setBounds(126, 153, 133, 20);
		contentPane.add(passField);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLogin.setBounds(48, 103, 46, 17);
		contentPane.add(lblLogin);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(48, 153, 68, 17);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				
				String login = loginField.getText();
				String pass = passField.getText();
				User c = (User) proxy.getUser(login,pass);
				JOptionPane.showMessageDialog(null, c.getMail());
				if(c!=null)
				{
					Accueil f2 = new Accueil();
					f2.setVisible(true);
				}
				else if(c==null)
					JOptionPane.showMessageDialog(null, "User not found");
				else					
					JOptionPane.showMessageDialog(null, "Login Failed, Try Again");
				
				
				
			}
		});
		btnLogin.setBackground(new Color(0, 128, 128));
		btnLogin.setBounds(170, 199, 89, 23);
		contentPane.add(btnLogin);
	
	} 
catch (Exception e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
}
