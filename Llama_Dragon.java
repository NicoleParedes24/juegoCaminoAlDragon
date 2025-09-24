import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Llama_Dragon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Llama_Dragon extends Actor
{
    /**
     * Act - do whatever the Llama_Dragon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Llama_Dragon(){
        
    }
    public void act()
    {
        movimiento();
        eliminar();
    }
    
    public void movimiento(){
        //se tiene q mover hacia adelante
        
        setLocation(getX()-2,getY());
    }
    
    public void eliminar(){
        Actor personaje=getOneIntersectingObject(HechiceraWorld_2.class);
        // esto para los bordes
        if(getX()<=0){
            getWorld().removeObject(this);
           
        }
   
        
    }
    
}
