package clientJava;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metier.sessions.IRemote;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.util.Properties;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PromoSupp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PromoSupp frame = new PromoSupp();
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
	public PromoSupp() {
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
		setBounds(100, 100, 381, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(159, 94, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblIdPromotion = new JLabel("id promotion");
		lblIdPromotion.setBounds(85, 97, 64, 14);
		contentPane.add(lblIdPromotion);
		
		JButton btnSupprimer = new JButton("supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proxy.deletePromotion(Long.parseLong(textField.getText()));
				 JOptionPane.showMessageDialog(null, "Promotion Supprimée");
			}
		});
		btnSupprimer.setBackground(SystemColor.activeCaption);
		btnSupprimer.setBounds(84, 125, 89, 23);
		contentPane.add(btnSupprimer);
	
	}catch(Exception e)
	{
		e.printStackTrace();
	}
}
}