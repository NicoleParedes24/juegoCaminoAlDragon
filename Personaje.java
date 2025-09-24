import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Personaje here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Personaje extends Actor
{
    /**
     * Act - do whatever the Personaje wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    int velocidad=3;
    int rotation=0;
    int contFuego=0;
    int numero=40;
    
    int disparosPermitidos=0;
    private boolean presionando=false; // de disparar
    ArrayList<Mon> Mon_eliminados=new ArrayList<>();


    //IMAGENES DERECHA IZQ
    GreenfootImage img_izquierda;
    GreenfootImage img_derecha;
    
    public Personaje(){
       this.img_derecha= new GreenfootImage("personaje_derecha_80.png");
       this.img_izquierda= new GreenfootImage("personaje_izquierda_80.png");
    
    }
    public void act()
    {
        //TECLAS
        moverPersonajeTeclas();
        
        contFuego++; // cada 1000 tiene que salir mas balas
        
        //QUE TAN SEGUIDO LAS BALAS 
        if(contFuego>1000){
            contFuego=0;
            numero-=5;
           
            
        }else{
             if(contFuego%numero==0){
                disparosPermitidos++;
                    
            }
        
        }
  
        shoot();
        collPerderVidas();
        margenesPersonaje();
          
    
    }
  
    
    //disparar
     public void shoot(){
            if(Greenfoot.isKeyDown("j") || Greenfoot.isKeyDown("space")){
                  if(!presionando &&disparosPermitidos>0){
                      
                    Fuego f = new Fuego(rotation);
                    Greenfoot.playSound("disparo.mp3");
                    getWorld().addObject(f,getX(),getY());
                    disparosPermitidos--;
                    presionando=true; // aqui ya esta siendo presionada=true
                  }
            }else{
                    presionando=false; //ya no se presiona FALSE
            }
    }
    
    //moverPeronsjaeTeclas
    public void moverPersonajeTeclas(){
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d") ){
         
            this.setRotation(0);
            rotation=0;
            setImage(img_derecha);
            setLocation(getX()+velocidad, getY());
        }else if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")){
            setImage(img_izquierda);
            this.setRotation(0);
            setLocation(getX()-velocidad,getY());
            rotation=180;
        }else if(Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")){
            setImage(img_derecha);
            this.setRotation(270);
            setLocation(getX(),getY()-velocidad);
            rotation=270;
        }else if(Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")){
            setImage(img_derecha);
            this.setRotation(90);
            setLocation(getX(),getY()+velocidad);
            rotation=90;
        }
    }
      public void margenesPersonaje(){
        int y=getY();
        int x=getX();
       // System.out.println(x);
        if(this.getX()>=getWorld().getWidth()-1){
            x=0;
        }else if(this.getX()<=0){
            x=getWorld().getWidth();
        }else if(this.getY()>=getWorld().getHeight()-1){
            y=70;
        }else if(this.getY()<68){
            y=getWorld().getHeight()-1;
        }
        setLocation(x, y);
    }
    //vidas
    public void collPerderVidas(){
       
        Actor mon=getOneIntersectingObject(Mon.class);
        if(mon!=null){
            getWorld().removeObject(mon);
            ((MyWorld)getWorld()).VidasPorCrear();
            ((MyWorld)getWorld()).restarVidas();
            
        }
   
    
    }
}
