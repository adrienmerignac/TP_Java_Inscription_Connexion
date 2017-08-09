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
	 * var1, var2, var3 correspondent respectivement aux variables Nom, Pr�nom et le Mot de passe que l'utilisateur souhaite cr�er
	 * text1, text2, text3 correspondent respectivement a la zone de saisie de Nom, Pr�nom et Mot de passe que l'utilisateur souhaite cr�er
	 * b1 correspond au boutton d'Inscription lorsque l'utilisateur � bien saisi tous les champs pr�requis
	 * num �tant le compteur initialis� � 0 permettant d'affecter un num�ro d'utilisateur en fonction de l'adresse mail.
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
	 * Cr�ation de la fenetre et mise en place des �l�ments
	 * Affichage des �l�ments
	 * Ajout de Listener sur les diff�rents �l�ments permettant de r�aliser des �v�nements lors du clique sur le boutton Inscription
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
	 * @param event correspond � l'�v�nement r�alis� lorsque l'utilisateur clique sur le boutton Inscription
	 */
	public void actionPerformed(ActionEvent event) {
	
		/**
		 * @param event correspond � l'�v�nement du Boutton d'Inscription de l'utilisateur
		 * Lorsque l'utilisateur clique sur ce boutton, l'email est cr�e avec la r�cup�ration du Nom, Pr�nom et Mot de passe avec text1, text2 puis text3
		 * Ces derniers sont r�utilis�s dans ligne, cette ligne va �tre ajout�e dans le document texte membre.txt pr�alablement cr�er
		 * A chaque inscription les utilisateur s'affichent les uns en dessous des autres et le num�ro s'incr�mente
		 * En m�me temps, l'interface inscription se ferme et l'interface de bienvenue pour l'utilisateur s'affiche
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
	 * Appel� lorsqu'un �l�ment a �t� utilis�.
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
	 * Appel� lorsqu'un �l�ment a �t� mis en place.
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
	 * Appel� lorsqu'un �l�ment a �t� utilis�.
 	 * Cet �v�nement se produit lorsqu'une touche est suivie d'une version de cl�.
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
