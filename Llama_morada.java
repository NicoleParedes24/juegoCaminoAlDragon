import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Llama_morada here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Llama_morada extends Actor
{
    /**
     * Act - do whatever the Llama_morada wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int numero=0; //1-> no hace nada
    public Llama_morada(int num){
        this.numero= num;
    
    }
    
    private int dañoLlama=10;
    public void act()
    {
        if(numero==0){
        setLocation(getX()+2, getY());
        colisionLLama();
        }
        
        
    }
    
    public void colisionLLama(){
        Actor llama=getOneIntersectingObject(Llama_Dragon.class);
        if(getX()>=getWorld().getWidth()-1){
           getWorld().removeObject(this);
        
        }
        if(llama!= null){
            getWorld().removeObject(llama);
            getWorld().removeObject(this);
            
       }
       
        
    }
}
