package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Adrien Merignac
 */
public class Bienvenue extends JFrame implements ActionListener {

	/**
	 * var1 correspond à l'affichage du message de bienvenue avec le Prénom de l'utilisateur en venant soit de l'Inscription soit de la Connexion
	 * var2 correspond à l'affiche de l'adresse Email de l'utilisateur en venant soit de l'inscription soit de la Connexion
	 * b1 correspond au boutton Quitter et ferme l'interface.
	 */
	static JLabel var1 = new JLabel ();
	static JLabel var2 = new JLabel ();
	private JButton b1 = new JButton ("Quitter");
	
	/**
	 * Constructeur de l'interface d'Accueil des utilisateurs
	 * Création de la fenetre et mise en place des éléments
	 * Affichage des éléments
	 * Ajout de Listener sur le boutton b1 qui permet de fermer l'interface de bienvenue
	 */	
	Bienvenue (){
		
		setVisible(false);		
		setTitle("Bievenue");
		setSize(200, 200);
		setLocationRelativeTo(null);
		
		var1.setBounds(20, 20, 150, 20);
		var2.setBounds(20, 50, 150, 20);
		b1.setBounds(20, 100, 150, 17);
		
		getContentPane().add(var1);
		getContentPane().add(var2);
		getContentPane().add(b1);
		
		b1.addActionListener(this);
		
		this.setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	/**
	 * @param event correspond à l'évènement réalisé lorsque l'utilisateur clique sur le boutton Quitter
	 */
	public void actionPerformed(ActionEvent event) {
			
		if(event.getSource()==b1) {
			this.dispose();
		}
	}
}
