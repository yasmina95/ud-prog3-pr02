package ud.prog3.pr02;

import javax.swing.ImageIcon;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.JLabel;

public class JLabelEstrella {
	public static final int TAMANYO_ESTRELLA = 40;  // píxels (igual ancho que algo)
	public static final int RADIO_ESTRELLA = 17;  // Radio en píxels del bounding circle 

	
	

	public JLabelEstrella() {
		try {
		   setIcon( new ImageIcon( JLabelEstrella.class.getResource( "img/estrella.png" ).toURI().toURL() ) );
		} catch (Exception e) {
			System.err.println( "Error en carga de recurso: estrella.png no encontrado" );
			e.printStackTrace();
		}
		   setBounds( 0, 0, TAMANYO_ESTRELLA, TAMANYO_ESTRELLA );
		// TODO Auto-generated constructor stub
	}

	public static int getTamanyoEstrella() {
		return TAMANYO_ESTRELLA;
	}



	public static int getRadioEstrella() {
		return RADIO_ESTRELLA;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
