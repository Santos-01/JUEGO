package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game extends JPanel {
    public static boolean collisioned=false;
    Stone stone = new Stone(this);
    public AST bug = new AST();
    
   public Game()
{
addKeyListener(new KeyListener()
{
@Override
public void keyTyped(KeyEvent e)
{

}
@Override
public void keyPressed(KeyEvent e)
{
bug.keyPressed(e);
}
@Override
public void keyReleased(KeyEvent e)
{

}
});
setFocusable(true);
}

    
    @Override
   public void paint(Graphics g)
   {
       super.paint(g);
       ImageIcon spiderWeb = new ImageIcon(getClass().getResource("../Imagenes/Space.png"));
       g.drawImage(spiderWeb.getImage(),0,0,getWidth(),getHeight(),this);
       
       Font score =new Font("Arial",Font.BOLD,25);
       g.setFont(score);
       g.setColor(Color.white);
       g.drawString("Puntos" +stone.getPoints(), 520,50);
       
       bug.paint(g);
       stone.paint(g);
       stone.move();
       
       g.dispose();
   } 
    public static void main(String[] args) {
        JFrame window=new JFrame ("Run Space");
        Game game=new Game();
        window.add(game);
        window.setSize(700,700);
        window.setVisible(true);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while(true)
        {
            if(collisioned | Stone.level ==5)
            {
                if(Stone.level ==5)
                {
                    JOptionPane.showMessageDialog(null,"Ganaste !!!");
                }
                int resetGame = JOptionPane.showConfirmDialog(
                        null, "¿Quieres reiniciar el juego?","Perdiste",JOptionPane.YES_NO_OPTION);
                if(resetGame==0)
                {
                    resetValues();
                }
                else if(resetGame==1)
                     {
                         System.exit(0);
                     }
            }
            try
            {
                Thread.sleep(10);
            }catch(InterruptedException ex)
            {
                System.out.println(ex.toString());
            }
            game.repaint();
        }
    }
    public static void resetValues()
{
        Stone.xStone1=600;
        Stone.yStone1=700;
        Stone.xStone2=700;
        Stone.yStone2=100;
        Stone.xStone3= -20;
        Stone.yStone3= 600;
        Stone.xStone4= 300;
        Stone.yStone4= -20;
        Stone.level=1;
        Stone.point =0;
        AST.x =10;
        AST.y =10;
        collisioned = false;
    }
}

