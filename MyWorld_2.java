import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class MyWorld_2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld_2 extends World
{

    /**
     * Constructor for objects of class MyWorld_2.
     * 
     */
    //VIDAS
    private int numVidas=0;
    private boolean crearVida=false;
    private int contadorVida=0;
    ArrayList<Vidas_W2> listaVidas= new ArrayList();
    
    private int nivel=0;
    private int vidasPorCrear=0;
    private int tiempo=0;
    
    private int minutos=0,segundos=0;
    // LSITA SOPORTES
    private ArrayList<Soporte>soportes= new ArrayList<>();
    
    HechiceraWorld_2 h2= new HechiceraWorld_2();
    Dragon dragon= new Dragon();
    
    public MyWorld_2(MyWorld_Camino w){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    
        
        //soportes
        addSoportes();  
        //Personaje 2
        addObject(h2, 22, 310);

        // add dragon
        addObject(dragon, 500,200); //500 200
        addObject(new Llama_morada(1), 400,10);
        this.numVidas=w.getNumVidas();
        this.nivel=w.getNivel();
        this.segundos=w.getSegundos();
        this.minutos=w.getMinutos();
        vidas();
    }
    public void act(){
       
        tiempo++;
        
         if(tiempo%55==0){
            segundos++;
           // System.out.println("segundos: "+segundos);
        }
       
        if(segundos>=59){
            minutos++;
            segundos=0;
        }
        if(tiempo==1000){
            nivel++;
            tiempo=0;
        }
        
        textoNivel();
        if(numVidas==0){

            juegoTerminado();
        }
        crearVidas();
        if(numVidas<=0){
            juegoTerminado();
        }
        if(dragon.getVidaDragon()<=0){
            juegoGanado();
        }
    }
    public void textoNivel(){
        showText(" "+h2.getNumDisparos(),420,13);
        
        showText("Nivel: "+nivel,getWidth()/2,10);
        showText("Vida Dragon: "+dragon.getVidaDragon(),500,380);
        showText(String.format("%02d", minutos)+":"+String.format("%02d",segundos),56,16);
    }
  
     public void vidas(){
        for(int i=0;i<this.numVidas;i++){
            Vidas_W2 v= new Vidas_W2();
            addObject(v,510+i*30,15); // VA A ESTAR A LA IZQ
           // xVidas=i+1;
            listaVidas.add(v);
           

        }
    }
     //añadir vidas arriba IMAGEN
    public void addImgVidas(){
        if(numVidas<3){
            
           // restarVidas();---
           // System.out.println("x: "+(15+numVidas*30)+ "y: "+15);
            Vidas_W2 v= new Vidas_W2();
            addObject(v, 510+numVidas*30, 15);
            listaVidas.add(v);
            numVidas++;
            crearVida=false;
            //xVidas++;
            
             
        }
    }
     // SE GENERA UNA VIDA CUANDO SE PIERDE VIDAS
    public void crearVidas(){
        
        
        
        if(numVidas<3 && !crearVida && vidasPorCrear>0){
            //System.out.println("CREAR VIDA: "+crearVida);
            contadorVida++;
            if(contadorVida>70){
                addObject(new Vidas_W2(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()-20));
                crearVida=true;
                contadorVida=0;
                vidasPorCrear--;
            }
            
        }
        
        
        /*
        if(getNumVidas()>=3 ){
            crearVida=false;
        }*/
        
    }
     //VIDAS
    public void VidasPorCrear(){
       vidasPorCrear++;
    }
     public void restarVidas(){
        //si no esta vacio
       // System.out.println(numVidas+"NUMERO DE VIDAS"+ listaVidas.size());
        
        if(!this.listaVidas.isEmpty()){
            Vidas_W2 u=listaVidas.remove(listaVidas.size()-1);
           // System.out.println(u.getX());
            removeObject(u);
            numVidas--;
           // xVidas--;
        }
    }
    

    
    public void addSoportes(){
        Soporte s1= new Soporte(70,350);
        Soporte s2= new Soporte(210,350);
        
        Soporte s3= new Soporte(340,350);
        Soporte s4= new Soporte(480,350);
        
        Soporte s5= new Soporte(550,350);
        
       // Soporte s2= new Soporte(110,125);
       // Soporte s3= new Soporte(255,210);
      //   Soporte s4= new Soporte(344,375);
      //  Soporte s5= new Soporte(595,275);   
        
        this.soportes.add(s1);
        this.soportes.add(s2); 
        this.soportes.add(s3);
        this.soportes.add(s4);
            
        this.soportes.add(s5);
      //  this.soportes.add(s2);
        //this.soportes.add(s3);
      //  this.soportes.add(s4);
       // this.soportes.add(s5);
        
        for(int i=0;i<this.soportes.size();i++){
            addObject(soportes.get(i), soportes.get(i).getCorX(),soportes.get(i).getCorY());
        }
    }
   
    public ArrayList<Soporte> getListSoportes(){
        return this.soportes;
    }
    public void juegoGanado(){
        
        showText("Ganastee !\n Numero de vidas: "+
        numVidas+"\nTiempo:"+minutos+":"+String.format("%02d", segundos) ,getWidth()/2,getHeight()/2);
        
        Greenfoot.stop(); 
       // Greenfoot.playSound("ganar.mp3");
        
    }
    public void juegoTerminado(){
        showText("Juego terminado",getWidth()/2,getHeight()/2);
        Greenfoot.stop();
        Greenfoot.playSound("gameover.mp3");
    }
}
