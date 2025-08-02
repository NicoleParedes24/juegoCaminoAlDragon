import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Personaje_World2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HechiceraWorld_2 extends Actor
{
    /**
     * Act - do whatever the Personaje_World2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean shootPresionado=false;
    private int numDisparos=0;
    private int contador=0;
    
    private int velocidadPersonajeX=3; // EJE X
    private int gravedad=3; // es para la gravedad
    int Y_ref=300; //ahi esta el suelo
    //saltar
    /*
    private int gravedad=2;
    private boolean jumping;
    private int fuerzaSalto=20; //jumpStrenght*/
    
    //IMAGENES DERECHA IZQ
    GreenfootImage img_izquierda;
    GreenfootImage img_derecha;
    
    //camino
    boolean camino=false;
    int num=0;
    int vidas=0,nivel=0;
    //constructor
    public HechiceraWorld_2(){
        this.img_derecha= new GreenfootImage("hechicera_derech.png");
        this.img_izquierda= new GreenfootImage("hechicera_izqui.png");
    }
    public HechiceraWorld_2(int n, int vidas, int nivel){
        this.img_derecha= new GreenfootImage("hechicera_derech.png");
        this.img_izquierda= new GreenfootImage("hechicera_izqui.png");
        this.num=n;
        }
    
    public void act()
    {
        if(num==1){
            caminarPuerta();
           collPuerta();
        }else{
            controlesTeclado();
            gravedad();
            colisionPerderVidas();
            contador++;
            if(contador%50==0){
                numDisparos++;
            }
        }
        
        
    }
    
    public void collPuerta(){
        Actor p=getOneIntersectingObject(Puerta.class);
        if(p!=null){
         
         
            
            Greenfoot.setWorld(new MyWorld_2((MyWorld_Camino)getWorld()) );
        }
    }
    public void caminarPuerta(){
        Actor p=getOneIntersectingObject(Personaje.class);
        
        if(p!=null || camino==true){
            setLocation(getX()+3, getY());
            camino=true;
        }
    }
    
    
    //DISPARAR
    public void shootLlama(){
        int ejeX=getX();
        int ejeY=getY();
        if(!shootPresionado && numDisparos>0){
            getWorld().addObject(new Llama_morada(0), ejeX, ejeY);
             shootPresionado=true;
            // System.out.println("disparos: "+numDisparos);
             numDisparos--;
        }
           
        
        
        
    
    }
    
    
     public void colisionPerderVidas(){
        Actor actor=getOneIntersectingObject(Llama_Dragon.class);
        // esto para los bordes
        
        //colision con hehcicera y fuego
        if(actor!=null){
            getWorld().removeObject(actor); // se elimina el fuego si choca con la hehcicera
             ((MyWorld_2)getWorld()).VidasPorCrear();
            ((MyWorld_2)getWorld()).restarVidas();
        }
        
        
        
    }
  
   
    
    public void gravedad(){
        if(getY()<Y_ref){ //si es menor al y de referencia
            setLocation(getX(), getY()+gravedad); //aumenta el y para q pueda vajar
        }
    }
    
    public void controlesTeclado(){
        
        if(Greenfoot.isKeyDown("space")){
            shootLlama();
        }else{
                shootPresionado=false;
        
        }  
        if(Greenfoot.isKeyDown("left")){
            setImage(img_izquierda);
            setLocation(getX()-velocidadPersonajeX, getY());
        }else if(Greenfoot.isKeyDown("right")){
            setImage(img_derecha);
            setLocation(getX()+velocidadPersonajeX, getY());
        }else if(Greenfoot.isKeyDown("up")){ // salto de 12 pixeles
            setLocation(getX(),getY()-8); // VELOCIDAD CON LA Q SUBE
        
        }
    }
    public int getNumDisparos(){
        return this.numDisparos;
    }
    
    
} 