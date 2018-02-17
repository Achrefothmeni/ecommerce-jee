package clientJava;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Accueil extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accueil frame = new Accueil();
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
	public Accueil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(0, 0, 187, 308);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblApplicationDadministration = new JLabel("Application d'administration");
		lblApplicationDadministration.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApplicationDadministration.setBounds(0, 98, 187, 42);
		panel.add(lblApplicationDadministration);
		
		JButton btnGestionDesProduits = new JButton("gestion des produits");
		btnGestionDesProduits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProduitFrame f = new ProduitFrame();
				f.setVisible(true);
						
			}
		});
		btnGestionDesProduits.setBackground(SystemColor.activeCaption);
		btnGestionDesProduits.setBounds(258, 84, 152, 23);
		contentPane.add(btnGestionDesProduits);
		
		JButton btnGestionDesCategorie = new JButton("gestion des categories");
		btnGestionDesCategorie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				categorieFrame f = new categorieFrame();
				f.setVisible(true);
			}
		});
		btnGestionDesCategorie.setBackground(SystemColor.activeCaption);
		btnGestionDesCategorie.setBounds(258, 118, 152, 23);
		contentPane.add(btnGestionDesCategorie);
		
		JButton btnGestionDesPromotions = new JButton("gestion des promotions");
		btnGestionDesPromotions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PromotionFrame f = new PromotionFrame();
				f.setVisible(true);
			}
		});
		btnGestionDesPromotions.setBackground(SystemColor.activeCaption);
		btnGestionDesPromotions.setBounds(258, 152, 152, 23);
		contentPane.add(btnGestionDesPromotions);
	}
}
