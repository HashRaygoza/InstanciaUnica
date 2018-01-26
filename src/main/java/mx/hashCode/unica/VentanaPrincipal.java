package mx.hashCode.unica;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.BindException;
import java.net.ServerSocket;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends JFrame implements WindowListener {

 private static final long serialVersionUID = -5385101636093904528L;
 private ServerSocket sello;
 private JLabel etiqueta;

 public VentanaPrincipal() {
  try {
   // Creamos el socket en el puerto 6660
   sello = new ServerSocket(6660);
   etiqueta = new JLabel("Esta aplicación usa ServerSocket para prevenir que se abran multiples instancias");

   this.getContentPane().add(etiqueta, BorderLayout.CENTER);
   this.setTitle("Highlander Sys.");
   this.addWindowListener(this);

   etiqueta.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

   this.pack();

  } catch (BindException e) {
   // Esto se ejecuta si el Socket no se puede crear, usualmente esto sera por que el puerto ya esta en uso
   JOptionPane.showMessageDialog(this, "THERE CAN BE ONLY ONE!!");
   System.exit(0);

  } catch (IOException s) {
   System.err.println("Errr");
  }

 }

 // Metodos necesitados por WindowListener
 @Override
 public void windowActivated(WindowEvent e) {

 }

 @Override
 public void windowClosed(WindowEvent e) {

 }

 @Override
 public void windowClosing(WindowEvent e) {
  try {
   sello.close();
   System.exit(0);

  } catch (IOException e1) {
   System.err.println("Error al cerrar el socket");
   e1.printStackTrace();
  }

 }

 @Override
 public void windowDeactivated(WindowEvent e) {

 }

 @Override
 public void windowDeiconified(WindowEvent e) {

 }

 @Override
 public void windowIconified(WindowEvent e) {

 }

 @Override
 public void windowOpened(WindowEvent e) {

 }

}