import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dragon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dragon extends Actor
{
    /**
     * Act - do whatever the Dragon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean llegoPosicion=false;
    //pos actual del dragon
    private int posX=500; 
    private int posY=300;
    private int frecuenciaFuegoDragon=0;
    private int velocidad=100; //cada 100 frecunciafuegoDragon lanza un fuego
    private int vidaDragon=100;
    int numero=100;
    int numeroMax=50;
    int valor=0;
    
    public void act()
    {
        movimiento();
        lanzarFuego();
        frecuenciaFuegoDragon++;
        if(frecuenciaFuegoDragon==500){ // cada 500 lanza mas
            if(valor<=50){
                numero-=10;
                valor+=10;
                frecuenciaFuegoDragon=0;
            }
            
        }
        colisionLlama();
    }
    public int getVidaDragon(){
        return this.vidaDragon;
    }
    public void lanzarFuego(){
        if(frecuenciaFuegoDragon%numero==0){
            getWorld().addObject(new Llama_Dragon(), getX()-100,getY()-30);
        }
    }
    public void colisionLlama(){
        Actor llama=getOneIntersectingObject(Llama_morada.class);
        
        if(llama!=null){
            getWorld().removeObject(llama);
            vidaDragon-=5;
        }
    }
    public void movimiento(){
         int minLimiteX=300; //300 a 600
         int maxLimiteX=600; //300 a 600
         
         int minLimiteY=150; //desde 100 hasta
         int maxLimiteY=300; //desde 100 hasta
         
         
         if(!llegoPosicion){
              posX=minLimiteX+Greenfoot.getRandomNumber(maxLimiteX-minLimiteX+1); //300 a 600
              posY=minLimiteY+Greenfoot.getRandomNumber(maxLimiteY-minLimiteY+1);
              llegoPosicion=true;
           //   System.out.println("NEW POSICION: "+posX+" "+posY);
         
         }
        //639-> posX get X=500
        if(posX==getX() && posY==getY()){
            llegoPosicion=false; // se hace uan nuvea pos
        }
        
      //  if(getX()!=posX || getY()!=posY ){// && si son diferentes al mimso tiempo           
             // x=0 y=0  arriba izq
             //x=600 y=0 arriba derecho
             //x=600 y=400 abajo derecha
             //x=0 y y=400 abajo izq
             
             
          //  System.out.println("POSICION: "+getX()+" "+getY());
            if(posX>getX()){
                setLocation(getX()+1, getY());
                
            }else if(posX<getX()){
                setLocation(getX()-1, getY());
            }
            
            if(getY()<posY){
                setLocation(getX(), getY()+1);
                
            }else if(getY()>posY){
                setLocation(getX(), getY()-1);
            }
      //  }else{
        //    llegoPosicion=false;
        //}
    }
}
