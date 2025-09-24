import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vidas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Vidas extends Actor
{
    /**
     * Act - do whatever the Vidas wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean vidas=false;
    private boolean world1=false;
    public Vidas(){
        GreenfootImage imag= getImage();
        imag.scale(25, 25);
        setImage(imag);
    }
    public void act()
    {
        // Add your action code here.
 
        colisionVidas(Personaje.class);
 
    }
    
    public void colisionVidas(Class clasePersonaje){
        Actor personaje=getOneIntersectingObject(clasePersonaje);
        if(personaje != null){
            ((MyWorld)getWorld()).addImgVidas();
            getWorld().removeObject(this);
 
        }
    }
     public void colisionVidas_2(Class clasePersonaje){
        Actor personaje=getOneIntersectingObject(clasePersonaje);
        if(personaje != null){
            ((MyWorld_2)getWorld()).addImgVidas();
            getWorld().removeObject(this);
           
        }
    }
    
    //si es falso va al WORLD 1
    public void setWorld(boolean w){
        this.world1=w;
    }
   


     
}
