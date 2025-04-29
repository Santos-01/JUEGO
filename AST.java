package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;


public class AST {
    public static int x = 10,y = 10;
    //metodo para pintar spider, hole
    public void paint(Graphics g){
        ImageIcon hole=new ImageIcon(getClass().getResource("../Imagenes/Satelite.png")); //Necesito las imagenes
        g.drawImage(hole.getImage(), 500, 500, 150, 150,null);
        ImageIcon spider=new ImageIcon(getClass().getResource("../Imagenes/Astro.png")); //Necesito las imagenes
        g.drawImage(spider.getImage(), x, y, 100, 100,null);
        
    }
    //Metodo para manipular el teclado, movimiento de spider
    public void keyPressed(KeyEvent e)
    {
        //Si la tecla es a la izquierda
        if(e.getKeyCode()==37)
        {
            if(x>0)
            {
                x-=20; //x=x-20;
            }    
        }
        //Si la tecla es a la derecha
        if(e.getKeyCode()==39)
        {
            if(x<580)
            {
                x+=20; //x=x+20;
            }    
        }
        //Si la tecla es arriba
        if(e.getKeyCode()==38)
        {
            if(y>0)
            {
                y-=20; //y=y-20;
            }    
        }
        //Si la tecla es abajo
        if(e.getKeyCode()==40)
        {
            if(y<580)
            {
                y+=20; //y=y+20;
            }    
        }
    }
    
    public Ellipse2D getBoundsBug(){
        return new Ellipse2D.Double(x+10, y+30, 80, 50);
    }
    
    public boolean finished(){
        Rectangle rectangle = new Rectangle(520,520,110,110);
        Area rectangleArea = new Area(rectangle);
        return rectangleArea.contains(getBoundsBug().getBounds());
    }
}
