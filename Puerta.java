import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Puerta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Puerta extends Actor
{
    /**
     * Act - do whatever the Puerta wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     private MyWorld world;
     
     private MyWorld_Camino mundo;
    private int numWorld=2; 
   
    
    public Puerta(MyWorld_Camino w){
        this.mundo=w;
        this.numWorld=w.getNumWorld();
    }
    public Puerta(MyWorld w){
        this.world=w;
        this.numWorld=w.getNumWorld();
    }
    public void act()
    {
        // Add your action code here.
        if(numWorld==1){
            collPuerta();
           
        }else if(numWorld==2){
            collPuertaCamino();
           
        }
        
    }
    
    public void collPuerta(){
        Actor personaje =getOneIntersectingObject(Personaje.class);
        if(personaje !=null){
            Greenfoot.playSound("puerta.mp3");
            int vidas=((MyWorld)getWorld()).getNumVidas();
            int nivel=((MyWorld)getWorld()).getNivel();
            ((MyWorld)getWorld()).setWorld(true);
            
            Greenfoot.setWorld(new MyWorld_Camino((MyWorld)getWorld()));
           // Greenfoot.setWorld(new MyWorld_2(this.world));
        }
        
    }
    
     public void collPuertaCamino(){
        Actor personaje =getOneIntersectingObject(HechiceraWorld_2.class);
        if(personaje !=null){
            Greenfoot.playSound("puerta.mp3");
        }
        
    }
}
