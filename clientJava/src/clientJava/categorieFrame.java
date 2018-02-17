package clientJava;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import metier.entities.Categorie;
import metier.sessions.IRemote;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.imageio.ImageIO;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;
import java.util.Base64.Encoder;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class categorieFrame extends JFrame {
	private JLabel image;
	private JPanel contentPane;
	private JTextField nom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					categorieFrame frame = new categorieFrame();
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
	public categorieFrame() {
		

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
		setBounds(100, 100, 449, 304);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ajouter une categorie");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(22, 22, 213, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomDeCategorie = new JLabel("nom de categorie");
		lblNomDeCategorie.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNomDeCategorie.setBounds(22, 74, 120, 27);
		contentPane.add(lblNomDeCategorie);
		
		JLabel lblDescription = new JLabel("description");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDescription.setBounds(22, 112, 106, 27);
		contentPane.add(lblDescription);
		
		nom = new JTextField();
		nom.setBounds(149, 79, 141, 20);
		contentPane.add(nom);
		nom.setColumns(10);
		
		final JTextArea desc = new JTextArea();
		desc.setBounds(149, 112, 141, 74);
		contentPane.add(desc);
		
		JButton btnAjouter = new JButton("ajouter");
		btnAjouter.setBackground(SystemColor.activeCaption);
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 
				proxy.addCategorie(new Categorie(nom.getText(),"INVALIDE",desc.getText()));
				
			}
		});
		btnAjouter.setBounds(22, 209, 89, 23);
		contentPane.add(btnAjouter);
		
		JButton btnConsulter = new JButton("consulter");
		btnConsulter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consulterCat cat = new consulterCat();
				cat.setVisible(true);
			}
		});
		btnConsulter.setBackground(SystemColor.activeCaption);
		btnConsulter.setBounds(284, 209, 89, 23);
		contentPane.add(btnConsulter);
	
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
