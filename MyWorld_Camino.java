import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld_Camino here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld_Camino extends World
{

    /**
     * Constructor for objects of class MyWorld_Camino.
     * 
     */
    private MyWorld world;
    //contador
    private int segundos=0;
    private int minutos=0;
    //NIVEL
    private int nivel=1;
    
    //VIDAS
    private int numVidas=1; 
    int numWorld=2;
    int tiempo=0;
    
     
    
    public MyWorld_Camino(MyWorld w)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        
        super(600, 400, 1);
        this.world=w;
        this.nivel=w.getNivel();
        this.segundos=w.getSegundos();
        this.minutos=w.getMinutos();
        this.numVidas=w.getNumVidas();
        addObject(new Puerta(w), 560, 262);
        
        addObject(new HechiceraWorld_2(1,1,1), 300, 270);
        
        addObject(new Personaje(), 50, 272);
        this.world.setNumWorld(2);
    }
    public int getNumWorld(){
        return this.numWorld;
    }
    public void act(){
        textoNivel();
        tiempo++;
        if(tiempo%55==0){
            segundos++;
        }
       
        if(segundos>=59){
            minutos++;
            segundos=0;
        }
    
    }
    public MyWorld getMyWorld(){
        return this.world;
    }
    
     public void textoNivel(){
        showText("Nivel: "+nivel,getWidth()/2,10);
        showText(String.format("%02d", minutos)+":"+String.format("%02d",segundos),56,16);
    }
     
    public int getSegundos(){
        return this.segundos;
    }
    public int getMinutos(){
        return this.minutos;
    }
      public int getNumVidas(){
        return this.numVidas;
    }
     public int getNivel(){
        return this.nivel;
    }
    
    
    
}
