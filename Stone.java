package Main;

import java.awt.Graphics;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;

public class Stone {
    
    public static int xStone1=600,yStone1=700;
    public static int xStone2=700,yStone2=100;
    public static int xStone3=-20,yStone3=600;
    public static int xStone4=300,yStone4=-20;
    public static int point=0;
    public Game game;
    public static int level=1;
    int i=2;
    Area s1,s2,s3,s4,areaStone;
    //Variables aleatorias para las piedras
    int startX=0;
    int startY=0;
    int endX=700;
    int endY=700;
    public Stone(Game game){
        this.game=game;
    }
    public void paint(Graphics g){
        ImageIcon stone=new ImageIcon(getClass().getResource("../Imagenes/Piedra.png"));
        if(this.level>=1){
            g.drawImage(stone.getImage(), xStone1, yStone1, 48,48,null);
        }
        if(this.level>=2){
            g.drawImage(stone.getImage(), xStone2, yStone2, 48,48,null);
        }
        if(this.level>=3){
            g.drawImage(stone.getImage(), xStone3, yStone3, 48,48,null);
        }
        if(this.level>=4){
            g.drawImage(stone.getImage(), xStone4, yStone4, 48,48,null);
        }
    }
    public boolean collision(){
        Area characterArea=new Area(game.bug.getBoundsBug());
        characterArea.intersect(getBoundsStone());
        return !characterArea.isEmpty();
    }
    public void move(){
        if(collision()){
            game.collisioned=true;
        }
        if(game.bug.finished()){
            level++;
            AST.x=10;
            AST.y=10;
        }
        if(level>=1){
            if(yStone1==-20){
                yStone1=700;
                xStone1=(int)(Math.random()*(endX-startX)+startX);
                point++;
            }
            else{
            yStone1 -= i;
        } 
        }
        if(level>=2){
            if(yStone2==-20){
                xStone2=700;
                yStone2=(int)(Math.random()*(endY-startY)+startY);
                point++;
            }
            else{
            xStone2 -= i;
        } 
        }
        if(level>=3){
            if(xStone3==700){
                xStone3=-20;
                yStone3=(int)(Math.random()*(endY-startY)+startY);
                point++;
            }
            else{
            xStone3 += i;
        } 
        }
        if(level>=4){
            if(yStone4==700){
                yStone4=-20;
                xStone4=(int)(Math.random()*(endX-startX)+startX);
                point++;
            }
            else{
            yStone4 += i;
        } 
        }
    }
    public int getPoints()
    {
        return this.point;
    }
    public Area getBoundsStone()
    {
        Ellipse2D stone1, stone2,stone3,stone4;
        stone1 = new Ellipse2D.Double(xStone1,yStone1,48,48);
        s1 = new Area(stone1);
        areaStone = s1;
        
        if(level>=1)
        {
           stone1 = new Ellipse2D.Double(xStone1,yStone1,48,48);
           s1 = new Area(stone1);
           areaStone.add(s1);
        }
        if(level>=2)
        {
           stone2 = new Ellipse2D.Double(xStone2,yStone2,48,48);
           s2 = new Area(stone2);
           areaStone.add(s2);
        }
        if(level>=3)
        {
           stone3 = new Ellipse2D.Double(xStone3,yStone3,48,48);
           s3 = new Area(stone3);
           areaStone.add(s3);
        }
        if(level>=4)
        {
           stone4 = new Ellipse2D.Double(xStone4,yStone4,48,48);
           s4 = new Area(stone4);
           areaStone.add(s4);
        }
        return areaStone;
    }
}