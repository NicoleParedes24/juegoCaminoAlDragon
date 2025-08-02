//import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Mon extends Actor
{
   
    /**
     * Act - do whatever the Mon wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    int mx=0;
    int my=0;
    int velocidad=2;
    //tamaño pantalla
    int ancho_x=0; //600
    int alto_y=0; //400
    
    //monstruo rojo
    int frecuenciaRojo=0;
    boolean rojo=false;
    
    int cont=0;
    private boolean estadoRojo=false;

    public Mon(){
        //modificar el tamaño de la imagen
        GreenfootImage image= getImage();
        image.scale(40,40);
        setImage(image);
        
        //NUMERO 0 1 2 3
        int direccion=Greenfoot.getRandomNumber(4); 

        if(direccion==0){ //->
            mx=1;
            my=0;
        }else if(direccion==1){//<-
            mx=-1;
            my=0;
        }else if(direccion==2){ //arriba
            mx=0;
            my=1;
        }else {//abajo
            mx=0;
            my=-1;
        
        }    
    }
    
    public void act(){
        //frecuencia para monstruo rojo
        frecuenciaRojo++;
        
        this.ancho_x=getWorld().getWidth();
        this.alto_y=getWorld().getHeight();
       
       //los que van a estar 
       int mx2=getX()+mx; //direccion
       int my2=getY()+my;
       
    
       if(mx2>=this.ancho_x){ //si se va a la derecha
           mx2=0;
       }else if(mx2<=0){ // si se va a la izq
            mx2=this.ancho_x;
        }else if(my2>=this.alto_y){ // arriba
            my2=0;
        }else if(my2<=0){ //abajo
            my2=this.alto_y;
        }
        setLocation(mx2,my2); //set
       
        //eliminar si le toca el fuego
          
       //remove();
       
        cont++;
        monstruoRojoVerde();    
       
      seguirPersonaje();
       
       
      
    }
    
    
    public void monstruoRojoVerde(){ //60 1 seg 120 2 segu
        //CAMBIAR POR EN MON ROJO 
        
        if(this.frecuenciaRojo>=200 && this.frecuenciaRojo<=400){
            
            if(cont>=10 ){
               
                if(estadoRojo){
                  //  setImage("mRojo.png");
                   setImage("R1.png");
                }else {
                   // setImage("MonstruoVer.png");
                   setImage("V1.png");
               
                }
                // getImage().scale(40, 40);
                estadoRojo=!estadoRojo;
                cont=0;
            }
            
            
        }

        
        
       if(this.frecuenciaRojo>400 && rojo==false){  //diferente true
           // setImage("mRojo.png");
           setImage("R1.png");
            rojo=true;
       }
    
    }
    public void seguirPersonaje() {
        
        
       if(rojo){
           //obtiene al Mon
           int  xR=getX();
           int yR=getY();
           
           //obtiene al perosnaje
           Personaje p= (Personaje)getWorld().getObjects(Personaje.class).get(0);
           //cordenadad de Personaje
           int xP=p.getX();
           int yP=p.getY();
           
           //200 2
           //xp ES PERSONAJE
           //XR ES POS DEL MONSTRUO 
         if(xP>xR){
            xR++;
            setLocation(xR, yR);
        }
        if(xP<xR) {
            xR--;
            setLocation(xR, yR);
        }
        if(yP>yR){
            yR++;
            setLocation(xR, yR);
        }
        if(yP<yR) {
            yR--;
            setLocation(xR, yR);
        }
       // System.out.println("PERSONAJE X Y: "+xP+" "+yP);
       // System.out.println("MONSTRUO: "+xR+" "+yR);

        //actualizar de nuevo
        setLocation(xR, yR);
            
           
       
           
       }
    }
    public void remove(){
       Actor fuego =getOneIntersectingObject(Fuego.class);
       if(fuego!= null){
            getWorld().removeObject(fuego);
            getWorld().removeObject(this);
        }
       
    }
    
}
