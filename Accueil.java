package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * @author Adrien Merignac
 */
public class Accueil extends JFrame implements ActionListener {

	/**
	 * b1 étant le boutton permettant de se connecter à l'interface de Connexion pour l'utilisateur
	 * b2 étant le boutton permettant de se connecter à l'interface d'Inscription d'un utilisateur
	 * b3 permettant de quitter l'application
	 */
	private JButton b1 = new JButton ("Connexion");
	private JButton b2 = new JButton ("Inscritpion");
	private JButton b3 = new JButton ("Quitter");

	/**
	 * Constructeur de l'interface d'Accueil des utilisateurs
	 * Création de la fenetre et mise en place des éléments
	 * Affichage des éléments
	 * Ajout de Listener sur les différents éléments permettant de réaliser des évènements lors du clique sur l'un des bouttons par l'utilisateur
	 */	
	Accueil(){

		setVisible(true);		
		setTitle("Accueil");
		setSize(200, 200);
		setLocationRelativeTo(null);

		b1.setBounds(20, 20, 150, 20);
		b2.setBounds(20, 50, 150, 20);
		b3.setBounds(20, 100, 150, 17);

		getContentPane().add(b1);
		getContentPane().add(b2);
		getContentPane().add(b3);

		b1.addActionListener(this); 
		b2.addActionListener(this); 
		b3.addActionListener(this); 

		this.setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * @param event correspond à l'évènement réalisé lorsque l'utilisateur clique sur l'un des bouttons
	 */
	public void actionPerformed(ActionEvent event) {

		/**
		 * @param event correspond à l'évènement du Boutton Connexion
		 * Lorsque l'utilisateur clique sur ce boutton, l'interface de connexion apparaît et l'interface d'accueil se ferme
		 */
		if(event.getSource()==b1) {
			Connexion c= new Connexion();
			c.setVisible(true);
			this.dispose();
		}
		
		/**
		 * @param event correspond à l'évènement du Boutton Inscription
		 * Lorsque l'utilisateur clique sur ce boutton, l'interface d'inscription apparaît et l'interface d'accueil se ferme
		 */
		if(event.getSource()==b2) {
			Inscription is= new Inscription();
			is.setVisible(true);
			this.dispose();
		}
		
		/**
		 * @param event correspond à l'évènement du Boutton Quitter
		 * Lorsque l'utilisateur clique sur ce boutton, l'interface d'accueil se ferme
		 */
		if(event.getSource()==b3) {
			this.dispose();
		}
	}
}