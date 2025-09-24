//import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class MyWorld extends World
{

    public int tiempo=0;
    private int intervalo=100;
    private Personaje p;
    private int numeroMon=1;
    
    //contador
    private int segundos=0;
    private int minutos=0;
    //NIVEL
    private int nivel=1;
    
    //VIDAS
    private int numVidas=3; //se puede cambiar 
    private int vidasPorCrear=0;
    private boolean crearVida=false;
    private int contadorVida=0;
    ArrayList<Vidas> listaVidas= new ArrayList();
    
    //llaves
    private int numLlaves=0;
    private boolean hayLLave=false;
    
    private boolean world_1=false;

    private int numWorld=1;
 
    public MyWorld()
    {
        super(600, 400, 1);
    
        //lave img al inicio 
        Llave llave=new Llave();
        addObject(llave, 450, 16);
        
        //cada que inicie se ponga el personaje
        p= new Personaje();
        addObject(p, getWidth()/2, getHeight()/2);
        vidas();

    }

    public void act(){
        
        inciarMonstruos();
        
        showText("Nivel: "+nivel,getWidth()/2,10);
        showText(""+numLlaves, 470,15);
        showText(String.format("%02d", minutos)+":"+String.format("%02d",segundos),536,16);
 
        if(getNumVidas()==0){

            juegoTerminado();
        }
    
       if(tiempo%55==0){
            segundos++;
        }
       
        if(segundos>=59){
            minutos++;
            segundos=0;
        }
        
        
        if(tiempo==1000){
            this.numeroMon++;
            nivel++;
            tiempo=0;
        }
        
        crearVidas();
        generarLlave();
        verPuerta();
    }
    public void setWorld(boolean w){
        this.world_1=w;
    }
    public boolean getWorld(){
        return this.world_1;
    }
    
    public void verPuerta(){
        if(hayLLave){
            addObject(new Puerta(this), getWidth()-100, 100);
        }
    }
    
    public void generarLlave(){
        if(nivel ==2 && tiempo==200 ){
            addObject(new Llave(), Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()-60)+60);
            
        }
    
    }
    // se generan las vidas
    public void vidas(){
        for(int i=0;i<this.numVidas;i++){
            Vidas v= new Vidas();
            addObject(v,15+i*30,15);
            listaVidas.add(v);
        }
    }
    
    //añadir vidas arriba IMAGEN
    public void addImgVidas(){
        if(numVidas<3){
            Vidas v= new Vidas();
            addObject(v, 15+numVidas*30, 15);
            listaVidas.add(v);
            numVidas++;
            crearVida=false;

        }
    }
     // SE GENERA UNA VIDA CUANDO SE PIERDE VIDAS
    public void crearVidas(){
        
        if(getNumVidas()<3 && !crearVida && vidasPorCrear>0){
            contadorVida++;
            if(contadorVida>70){
                addObject(new Vidas(), Greenfoot.getRandomNumber(getWidth()-100), Greenfoot.getRandomNumber(getHeight()-50)+50);
                crearVida=true;
                contadorVida=0;
                vidasPorCrear--;
            }
            
        }
        
    }

    
     public void restarVidas(){
        if(!this.listaVidas.isEmpty()){
            Vidas u=listaVidas.remove(listaVidas.size()-1);
            removeObject(u);
            numVidas--;
        }
    }
    public void inciarMonstruos(){
        tiempo++; 
        if(tiempo%intervalo==0){
            for(int i=0;i<numeroMon;i++) {

                Mon mon=new Mon();
                int x=Greenfoot.getRandomNumber(getWidth());
                int y=Greenfoot.getRandomNumber(getHeight());

                //si esta justo en la posicion del perosnjae no se crea +-30
                int margen=50;

                if(x>=p.getX()-margen && x<=p.getX()+margen && y>=p.getY()-margen && y<=p.getY()+margen){
                    
                }else{
                    addObject(mon, x, y);
                }

            }
        }

    }
    

    public int getNivel(){
        return this.nivel;
    }

    public void juegoTerminado(){
        showText("Juego terminado",getWidth()/2,getHeight()/2);
        Greenfoot.stop();
        Greenfoot.playSound("gameover.mp3");
    }

    public void VidasPorCrear(){
       vidasPorCrear++;
    }
    
    public int getNumVidas(){
        return this.numVidas;
    }
    
    public boolean getCrearVida(){
        return this.crearVida;
    }
    public void setCrearVida(boolean _crearVida){
        this.crearVida=_crearVida;
    }
    public void setNumLlaves(int _numLlaves){
        this.numLlaves=_numLlaves;
    }
    public void addNumLLaves(){
        numLlaves++;
        hayLLave=true;
    }
    
    
    public void setSegundos(int s){
        this.segundos=s;
    }
    public void setMinutos(int m){
        this.minutos=m;
    }
    public void setNumWorld(int m){
        this.numWorld=m;
    }
    public int getSegundos(){
        return this.segundos;
    }
    public int getMinutos(){
        return this.minutos;
    }
    public int getNumWorld(){
        return this.numWorld;
    }
}
