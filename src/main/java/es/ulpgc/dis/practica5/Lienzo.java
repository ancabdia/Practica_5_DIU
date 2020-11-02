/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.ulpgc.dis.pruebaclasep5;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
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
            imagen = ImageIO.read(new URL("https://dam.vanidades.com/wp-content/uploads/2020/04/%C2%A1Como-si-necesit%C3%A1ramos-m%C3%A1s-razones-para-amar-a-los-perritos-Seg%C3%BAn-investigadores-el-mejor-amigo-del-hombre-podr%C3%ADa-ayudar-a-detectar-el-coronavirus.-770x513.jpg"));
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
        g.drawImage(NewClass.seleccionarComponentes(imagen, red, green, blue), 0, 0, null);
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

    public void changeCoordinates(int x2, int y2) {
        x = x2;
        y = y2;
    }
    
    
    public void setUrlImage(String name){
        try {
            imagen = ImageIO.read(new URL(
                    name));
            this.setPreferredSize(new Dimension(imagen.getWidth(), imagen.getHeight()));
        } catch (MalformedURLException ex) {
            Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
