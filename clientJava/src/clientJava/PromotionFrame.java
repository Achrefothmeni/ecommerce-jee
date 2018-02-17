package clientJava;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;

import metier.entities.Promotion;
import metier.sessions.IRemote;

import javax.swing.JLabel;
import java.awt.Font;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class PromotionFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PromotionFrame frame = new PromotionFrame();
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
	public PromotionFrame() {
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(124, 107, 144, 20);
		contentPane.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setDateFormatString("yyyy-MM-dd");
		dateChooser_1.setBounds(124, 144, 144, 20);
		contentPane.add(dateChooser_1);
		
		JLabel lblDateDebut = new JLabel("Date debut");
		lblDateDebut.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDateDebut.setBounds(40, 107, 80, 20);
		contentPane.add(lblDateDebut);
		
		JLabel label = new JLabel("Date debut");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(40, 144, 80, 20);
		contentPane.add(label);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				java.util.Date d = dateChooser.getDate();
				java.util.Date d2 = dateChooser.getDate();
				proxy.addPromotion(new Promotion(d,d2));
				
			}
		});
		btnAjouter.setBackground(SystemColor.activeCaption);
		btnAjouter.setBounds(40, 196, 89, 23);
		contentPane.add(btnAjouter);
		
		JLabel lblAjoutDunePromotions = new JLabel("Ajout d'une Promotions");
		lblAjoutDunePromotions.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAjoutDunePromotions.setBounds(40, 37, 191, 23);
		contentPane.add(lblAjoutDunePromotions);
		
		JButton btnSupprimer = new JButton("supprimer");
		btnSupprimer.setBackground(SystemColor.activeCaption);
		btnSupprimer.setBounds(300, 196, 89, 23);
		contentPane.add(btnSupprimer);
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
}
