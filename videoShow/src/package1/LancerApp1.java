package package1;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
public class LancerApp1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//BufferedImage imgVador= ImageIO.read(new File("images/person2.png"));
		//BufferedImage imgLeila= ImageIO.read(new File("images/person1.png"));
		
		// cr�ation de la fen�tre de l'application
		JFrame laFenetre= new JFrame("Animation Train, etc.");
		laFenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		laFenetre.setSize(512, 512);
		
		// cr�ation de la z�ne de dessin dans la fen�tre
		Dessin d = new Dessin();
		laFenetre.getContentPane().add(d);
		
		// affiche la fen�tre
		laFenetre.setVisible(true);
		
		// les trains de cercles avec image et en couleur
		TrainCercle[] lesTrains= new TrainCercle[10];
		Visage[] lesVisages= new Visage[10];
		
		lesVisages[0]=new Visage(d,100,101,100,100);
		d.ajouterObjet2(lesVisages[0]);
		PolygoneRegulier[] lesPolygones = new PolygoneRegulier[10];
		lesPolygones[0]=new PolygoneRegulier(5,250, 200,50, 10, Color.BLACK, Color.BLACK);
		d.ajouterObjet3(lesPolygones[0]);
		Etoile[] lesEtoiles = new Etoile[10];
		lesEtoiles[0]=new Etoile(100,200,50,5,Color.GREEN, Color.GREEN);
		d.ajouterObjet4(lesEtoiles[0]);
		lesEtoiles[1]=new Etoile(50,50,20,5,Color.YELLOW,Color.YELLOW);
		d.ajouterObjet4(lesEtoiles[1]);
		lesPolygones[1]=new PolygoneRegulier(5,100,100,20, 10, Color.GRAY, Color.GRAY);
		d.ajouterObjet3(lesPolygones[1]);
		MvtCirculaire mvC= new MvtCirculaire(250,200,50,50,50);
		lesEtoiles[1]=new Etoile(50,50,20,5,Color.YELLOW,Color.YELLOW);
		/*AnimationForme Etoile=new AnimationForme(lesEtoiles[1],new MvtCirculaire(100,100,20,100,10));
		Etoile.deplacer();
		AnimationForme Polygone=new AnimationForme(lesPolygones[1],new MvtCirculaire(200,100,20,100,10));
		Polygone.deplacer();*/
		AnimationForme an= new AnimationForme(lesPolygones[1],mvC);
	    AnimationForme an2=new AnimationForme(lesEtoiles[1],mvC);
		
		
		///animation :
		//d.animer();
		//lesTrains[0] = new TrainCercleImage(d, 10, imgVador); d.ajouterObjet(lesTrains[0]);
		//lesTrains[1] = new TrainCercleImage(d, 10, imgLeila); d.ajouterObjet(lesTrains[1]);
		
		
		/*MvtCirculaire mvC= new MvtCirculaire(500,200,30,50,50);
		mvC.deplacer(lesEtoiles[1]);
		
		   
	   /* for (;;) {
	      try {
	        Thread.sleep(1000L);
	      }
	      catch (InterruptedException localInterruptedException) {
	        localInterruptedException.printStackTrace();
	      }
	      
	    }
	   
	    */
		
		//mvC.animer(lesEtoiles[1]);
		
		
		
		
		
	    //mvC.animer(lesEtoiles[1]);
		//AnimationForme an= new AnimationForme(lesEtoiles[1],mvC);
		//an.animer();
		
		
		
		
		
		for (int i = 2; i < 10; i++) {
			lesTrains[i] = new TrainCercleCouleur(new Color((float) Math.random(), (float) Math.random(),
		(float) Math.random()), d, 10, 10);
		d.ajouterObjet(lesTrains[i]);
		}
		while(true) {
		// la zone de dessin se r�affiche
		d.repaint();
		// un temps de pause pour avoir le temps de voir le nouveau dessin
		d.pause(50);
		//r�aliser � tous les trains un d�placement �l�mentaire
		d.animer();
		
		an.deplacer();
		an2.deplacer();
		}

	}

}