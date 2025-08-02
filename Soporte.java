import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Soporte here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Soporte extends Actor
{
    /**
     * Act - do whatever the Soporte wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int x=0;
    private int y=0;
    private boolean detectarSoporte=false;
    
    public Soporte(int _x, int _y){
        this.x=_x;
        this.y=_y;
    }
    
    public void act(){
       collSoporte();
    
    }
    
    public void collSoporte(){
        Actor hechicera= getOneIntersectingObject(HechiceraWorld_2.class);
        if(hechicera != null){
           // System.out.println("COLISION"+hechicera.getX()+" "+hechicera.getY()+"col_ "+getX()+" "+getY());
            
            setDetectarSoporte(true);
        }else{
            setDetectarSoporte(false);
        }
    }
    public void setDetectarSoporte(boolean soporte){
        this.detectarSoporte=soporte;
    }
    public boolean getDetectarSoporte(){
        return this.detectarSoporte;
    }
    
    //get set
    public int getCorX(){
        return this.x;
    }
    public int getCorY(){
        return this.y;
    }
    
}
