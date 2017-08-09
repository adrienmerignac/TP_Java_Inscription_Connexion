package project;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import javax.swing.*;
 
/**
 * @author Adrien Merignac
 */
public class Connexion extends JFrame implements KeyListener, ActionListener {

	/**
	 * var1, var2 correspondent respectivement à la variable de l'Email et au Mot de passe de l'utilisateur
	 * text1, text2 correspondent respectivement a la zone de saisie de l'Email et le Mot de Passe de l'utilisateur
	 * b1 correspond au boutton de Connexion lorsque l'utilisateur à bien saisi tous les champs prérequis
	 */
	private JLabel var1 = new JLabel ("E-mail");
	private JLabel var2 = new JLabel ("Mot de passe");
	private JTextField text1 = new JTextField ();
	private JTextField text2 = new JTextField ();
	private JButton b1 = new JButton ("Connexion");

	/**
	 * Constructeur de l'interface de Connexion des utilisateurs
	 * Création de la fenetre et mise en place des éléments
	 * Affichage des éléments
	 * Ajout de Listener sur les différents éléments permettant de réaliser des évènements lors du clique sur le boutton Connexion
	 */	
	Connexion(){

		setVisible(false);		
		setTitle("Connexion");
		setSize(400, 200);
		setLocationRelativeTo(null);

		var1.setBounds(20, 20, 150, 20);
		var2.setBounds(20, 50, 150, 20);
		text1.setBounds(200,20, 150, 20);
		text2.setBounds(200, 50, 150, 20);
		b1.setBounds(200, 100, 150, 20);

		getContentPane().add(var1);
		getContentPane().add(var2);
		getContentPane().add(text1);
		getContentPane().add(text2);
		getContentPane().add(b1);

		b1.setEnabled(false);
		text1.addKeyListener(this);
		text2.addKeyListener(this);
		b1.addActionListener(this); 

		this.setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	static int nbrEssai=0;
	
	/**
	 * @param event correspond à l'évènement réalisé lorsque l'utilisateur clique sur le boutton Connexion
	 */
	public void actionPerformed(ActionEvent event) {
		
		/**
		 * il faut test si l'Email et le Mot de passe saisi par l'utilisateur correspond à l'un des utilisateurs existant dans le document membre.txt
		 * Si le test est correct, il ferme l'interface de Connexion et ouvre l'interface de Bievenue en affichant un Message de Bienvenue avec le prénom de l'utilisateur
		 * Puis Affiche l'adresse Email de ce dernier
		 * Si le test est incorrect, un message d'erreur s'affiche
		 * Si le test est incorrect 3 fois de suite, il renvoi l'utilisateur vers l'interface d'inscription et ferme l'interface de Connexion
		 */
		if(event.getSource()==b1) {

			BufferedReader br = null;
			String ligne1;

			boolean trouver= false;

			try {

				br = new BufferedReader ( new FileReader ("membre.txt"));

				String n= null;
				String n1= null;
				String n2= null;
				String n3= null;

				while (((ligne1=br.readLine()) != null)&& (!trouver)) {

					StringTokenizer st= new StringTokenizer(ligne1);
					n= st.nextToken();
					n1= st.nextToken();
					n2= st.nextToken();
					n3= st.nextToken();

					if(n2.compareTo(text1.getText())==0 && n3.compareTo(text2.getText())==0) {
					trouver = true;
					Bienvenue b= new Bienvenue();
					Bienvenue.var1.setText("Bievenue"+" "+n1);
					Bienvenue.var2.setText(n2);
					b.setVisible(true);
					this.dispose();
					}
				}				

				if (n2.compareTo(text1.getText())!=0 && n3.compareTo(text2.getText())!=0) {
					trouver= false;
					JOptionPane jop= new JOptionPane();
					JOptionPane.showMessageDialog(null, "Email ou mot de passe erroné(s)","Erreur de connexion", JOptionPane.ERROR_MESSAGE);
					text1.setText(null);
					text2.setText(null);

					nbrEssai++;

					if(nbrEssai>=3) {
						Inscription is= new Inscription();
						is.setVisible(true);
						this.dispose();
					}
				}
		}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * @param kp
	 * Appelé lorsqu'un élément a été utilisé.
	 */
	public void keyPressed(KeyEvent kp) {
		if(text1.getText().isEmpty() || (text2.getText().isEmpty())) {
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
		if(text1.getText().isEmpty() || (text2.getText().isEmpty())) {
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
		if(text1.getText().isEmpty() || (text2.getText().isEmpty())) {
			b1.setEnabled(false);
		}
		else {
			b1.setEnabled(true);
		}

	}
}
