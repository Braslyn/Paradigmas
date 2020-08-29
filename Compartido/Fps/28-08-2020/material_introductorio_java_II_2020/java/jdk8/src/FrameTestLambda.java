/**
<p> Pequeño ejemplo usando JFrame de swing/awt con Eventos usando lambda (jdk8)
@author loriacarlos@gmail.com
@since 2015 updated 2020
*/

package eif400fp.demo.swing;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.*;


public class FrameTestLambda{
	public static void main(String[] args) {
		JFrame f = new JFrame("Frame using lambda");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(400, 400);
		f.setLayout(new FlowLayout());

		// Botón anónimo. Equivalente usando una lambda como listener
		f.getContentPane().add(new JButton() {
			public int counter;
			{ // Init block code	
                this.counter = 1;
				this.setBackground(Color.GREEN);
				this.setText(this.counter + "");
				// Un Listener para el Boton (maneja cualquier evento e)
				this.addActionListener(e -> {
                        this.counter ++;
						setText(counter + "");
				});
				
		    };
		});
		f.setVisible(true);
	}
}
				
				/*
				new Thread(() -> {
                     for (int i=0; i< 9; i++) 
                         System.out.println(i+" Hola Mundo!"));
                }).start();
				*/
