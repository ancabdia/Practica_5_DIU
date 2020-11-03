/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.dis.practica5;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Andres
 */
public class Lienzo extends JPanel {

    private static boolean red = true;
    private static boolean blue = true;
    private static boolean green = true;
    
    private static int x, y;

    private static BufferedImage imagen = null;
    private static BufferedImage imageLogo = null;

    public Lienzo() {
        try {
            imagen = ImageIO.read(new URL("https://i.pinimg.com/736x/53/44/cf/5344cf95295d7099c60ff682ecffb59e.jpg"));
            this.setPreferredSize(new Dimension(imagen.getWidth(), imagen.getHeight()));
        } catch (MalformedURLException ex) {
            Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            imageLogo = ImageIO.read(new URL("https://www.ulpgc.es/sites/default/files/ArchivosULPGC/identidad-corporativa/Logos%2030%20Aniversario/mesa_de_trabajo_1.png"));
        } catch (MalformedURLException ex) {
            Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(FilterComponent.seleccionarComponentes(imagen, red, green, blue), 0, 0, null);
        g.drawImage(imageLogo, x, y, null);
    }
    
     public static void setRed(boolean value) {
        red = value;
    }

    public static void setBlue(boolean value) {
        blue = value;
    }

    public static void setGreen(boolean value) {
        green = value;
    }
    
     public static int horizontal(){
        return imageLogo.getWidth();
    }
    
    public static int vertical(){
        return imageLogo.getHeight();
    }
    
    public static int verticalImagen(){
        return imagen.getHeight();
    }
    
    public static int horizontalImagen(){
        return imagen.getWidth();
    }

    public void changeCoordinates(int x2, int y2) {
        x = x2;
        y = y2;
    }
    
    
    public void setUrlImage(String name){
        BufferedImage temp = null;
        try {
            temp = ImageIO.read(new URL(
                    name));
        } catch (MalformedURLException ex) {
            Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "not valid URL", "Value not valid",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "not valid URL", "Value not valid",
                    JOptionPane.ERROR_MESSAGE);
        }finally{
            if(temp.getWidth() <= 1024 && temp.getHeight() <= 768){
                imagen = temp;
                this.setPreferredSize(new Dimension(imagen.getWidth(), imagen.getHeight()));
            }else{
                JOptionPane.showMessageDialog(null, "Image has to be 1024x768 maximum", "Not valid image",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
