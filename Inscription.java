package project;

import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
/**
 * 
 * @author Adrien Merignac
 *
 */
public class Inscription extends JFrame implements KeyListener, ActionListener {

	/**
	 * var1, var2, var3 correspondent respectivement aux variables Nom, Prénom et le Mot de passe que l'utilisateur souhaite créer
	 * text1, text2, text3 correspondent respectivement a la zone de saisie de Nom, Prénom et Mot de passe que l'utilisateur souhaite créer
	 * b1 correspond au boutton d'Inscription lorsque l'utilisateur à bien saisi tous les champs prérequis
	 * num étant le compteur initialisé à 0 permettant d'affecter un numéro d'utilisateur en fonction de l'adresse mail.
	 */
	private JLabel var1 = new JLabel ("Nom");
	private JLabel var2 = new JLabel ("Prenom");
	private JLabel var3 = new JLabel ("Mot de passe");
	private JTextField text1 = new JTextField ();
	private JTextField text2 = new JTextField ();
	private JTextField text3 = new JTextField ();
	private JButton b1 = new JButton ("Inscription");
	static int num = 0;
	

	/**
	 * Constructeur de l'interface d'Inscription des utilisateurs
	 * Création de la fenetre et mise en place des éléments
	 * Affichage des éléments
	 * Ajout de Listener sur les différents éléments permettant de réaliser des évènements lors du clique sur le boutton Inscription
	 */	
	Inscription(){
		
		num++;
		
		setVisible(false);		
		setTitle("Inscription");
		setSize(400, 220);
		setLocationRelativeTo(null);

		var1.setBounds(20, 20, 150, 20);
		var2.setBounds(20, 50, 150, 20);
		var3.setBounds(20, 80, 150, 20);
		text1.setBounds(200,20, 150, 20);
		text2.setBounds(200, 50, 150, 20);
		text3.setBounds(200, 80, 150, 20);
		b1.setBounds(200, 130, 150, 20);

		getContentPane().add(var1);
		getContentPane().add(var2);
		getContentPane().add(var3);
		getContentPane().add(text1);
		getContentPane().add(text2);
		getContentPane().add(text3);
		getContentPane().add(b1);

		b1.setEnabled(false);
		text1.addKeyListener(this);
		text2.addKeyListener(this);
		text3.addKeyListener(this);
		b1.addActionListener(this); 

		this.setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	/**
	 * @param event correspond à l'évènement réalisé lorsque l'utilisateur clique sur le boutton Inscription
	 */
	public void actionPerformed(ActionEvent event) {
	
		/**
		 * @param event correspond à l'évènement du Boutton d'Inscription de l'utilisateur
		 * Lorsque l'utilisateur clique sur ce boutton, l'email est crée avec la récupération du Nom, Prénom et Mot de passe avec text1, text2 puis text3
		 * Ces derniers sont réutilisés dans ligne, cette ligne va être ajoutée dans le document texte membre.txt préalablement créer
		 * A chaque inscription les utilisateur s'affichent les uns en dessous des autres et le numéro s'incrémente
		 * En même temps, l'interface inscription se ferme et l'interface de bienvenue pour l'utilisateur s'affiche
		 */
		if(event.getSource()==b1) {
			String email;
			String ligne;
			BufferedWriter bw = null;
	
			
			email= text1.getText()+"."+text2.getText()+"."+num+"@mii.fr";
			
			ligne= text1.getText()+" "+text2.getText()+" "+email+" "+text3.getText();

			try {

				bw = new BufferedWriter (new FileWriter ("membre.txt", true));
				bw.write(ligne);
				bw.newLine();
				bw.close();
			}

			catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}

			Bienvenue b= new Bienvenue();
			Bienvenue.var1.setText("Bienvenue"+" "+text2.getText());
			Bienvenue.var2.setText(email);
			this.dispose();
			b.setVisible(true);
		}
	}
	
	/**
	 * @param kp
	 * Appelé lorsqu'un élément a été utilisé.
	 */
	public void keyPressed(KeyEvent kp) {
		if(text1.getText().isEmpty() || (text2.getText().isEmpty()) || text3.getText().isEmpty()) {
			b1.setEnabled(false);
		}
		else {
			b1.setEnabled(true);
		}
	}
	
	/**
	 * @param ke
	 * Appelé lorsqu'un élément a été mis en place.
	 */
	public void keyReleased(KeyEvent ke) {
		if(text1.getText().isEmpty() || (text2.getText().isEmpty()) || text3.getText().isEmpty()) {
			b1.setEnabled(false);
		}
		else {
			b1.setEnabled(true);
		}
	}

	/**
	 * Appelé lorsqu'un élément a été utilisé.
 	 * Cet événement se produit lorsqu'une touche est suivie d'une version de clé.
	 */
	public void keyTyped(KeyEvent kt) {
		if(text1.getText().isEmpty() || (text2.getText().isEmpty()) || text3.getText().isEmpty()) {
			b1.setEnabled(false);
		}
		else {
			b1.setEnabled(true);
		}
	}
}
