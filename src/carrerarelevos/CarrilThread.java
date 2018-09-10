/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrerarelevos;

/**
 *
 * @author Eduardo
 */
public class CarrilThread extends Thread{
    private String name;
    private Equipo team;
    private long beginTime;
    private Progress barra;
  

    public CarrilThread(String name, Equipo team, long beginTime, Progress barra) {
        this.name = name;
        this.team = team;
        this.beginTime = beginTime;
        this.barra = barra;
    }
    
    public CarrilThread(String name, Equipo team, long beginTime) {
        this.name = name;
        this.team = team;
        this.beginTime = beginTime;
        
    }
    
    @Override
    public void run() {
        System.out.println("En el carril "+this.name+
                " ha comenzado a correr el equipo "+this.team.getName()+
                " en el tiempo: "+ (System.currentTimeMillis() - beginTime)/1000 +
                " segundos");
        
        for (int i = 0; i < this.team.getAtletas().length; i++) {
            this.esperar(team.getAtletas()[i]);
            System.out.println("Termino de correr el atleta "+(i+1)+
                    " del equipo "+this.team.getName()+" ->tiempo: " +
                    (System.currentTimeMillis() - this.beginTime)/1000 +
                    " segundos");
           
            
            
        }
        
        /*for (int i = 0; i < this.team.getAtletas().length; i++) {
            this.esperar(team.getAtletas()[i]);
            System.out.println("Termina de correr el atleta "+(i+1) +
                    " -> tiempo: "+ (System.currentTimeMillis()-timeStamp)/1000 +
                    "segundos");
        }*/
        
        System.out.println("En el carril "+this.name+" termina el equipo "+
                this.team.getName() + " en el tiempo " + 
                (System.currentTimeMillis()-this.beginTime)/1000 + "segundos");
    }
    
    private void esperar(int segundos) {
        try {
            //this.barra.getBarra().setValue(segundos*100);
            //Jalar aqui la funcion de suma de valores internos del arreglo 
            //this.barra.iterate(200,segundos);
            Thread.sleep(segundos*1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
