import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fuego here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fuego extends Actor
{
    
    
    public int velocidad=10;
    public Fuego(int rotation){
       GreenfootImage i= getImage();
        i.scale(10,10);
        this.setImage(i);
        
        this.setRotation(rotation);
    }
    public void act()
    {
        
       move(velocidad);
        remove();
    }
    //eliminar
 
    public void remove(){
        
        // busca si el fuego esta colisionando con MON
         Actor mon =getOneIntersectingObject(Mon.class);
        //bordes
        if(getX()>=getWorld().getWidth()-1){
            getWorld().removeObject(this); 
        }else if(getY()>=getWorld().getHeight()-1){
            getWorld().removeObject(this); 
        }else if(getX()<1){
             getWorld().removeObject(this);
        } else if(getY()<1){
             getWorld().removeObject(this);
        // si el objeto SI ESTA != null esta colisionando
        }
       
        if(mon !=null){   
         getWorld().removeObject(mon); //se elimina MOn
         getWorld().removeObject(this);//se elimina fuego
        
        }
        
    
    }
    

}
