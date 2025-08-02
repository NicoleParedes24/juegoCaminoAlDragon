import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vidas_W2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vidas_W2 extends Actor
{
    /**
     * Act - do whatever the Vidas_W2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
     public Vidas_W2(){
        GreenfootImage imag= getImage();
        imag.scale(25, 25);
        setImage(imag);
    }
    public void act()
    {
        colisionVidas_2(HechiceraWorld_2.class);
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
    
}
