/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrerarelevos;

import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author Eduardo
 */
public class CarreraRelevos implements Runnable {
    private Equipo equipo;
    private Carril carril;
    private long initialTime;
  
    
    
    public CarreraRelevos(Equipo eq, Carril carr, long initial) {
        this.equipo = eq;
        this.carril = carr;
        this.initialTime = initial;
        
        
    } 

    public static void main(String[] args) {
        long init = System.currentTimeMillis();
        //##Para utilizar sin importar el numero de participantes por carril
        //ArrayList<Integer>atletas1 = new ArrayList<Integer>();
        //ArrayList<Integer>atletas2 = new ArrayList<Integer>(); 
        //##
        //Equipo equipo2 = new Equipo("Equipo 2", agregar(suma2,atletas2));
        //##
        //int suma1 = sumar(atletas1);
        //int suma2 = sumar(atletas2);
        
        int[] atletas1 = new int[3];
        int[] atletas2 = new int[3];
        int[] atletas3 = new int[3];
        int[] atletas4 = new int[3];
        
        agregarAtletas(atletas1);
        agregarAtletas(atletas2);
        agregarAtletas(atletas3);
        agregarAtletas(atletas4);
        
        int var1 = sumar(atletas1);
        int var2 = sumar(atletas2);
        int var3 = sumar(atletas3);
        int var4 = sumar(atletas4);
                
        Equipo equipo1 = new Equipo("Equipo 1", atletas1);
        Equipo equipo2 = new Equipo("Equipo 2", atletas2);
        Equipo equipo3 = new Equipo("Equipo 3", atletas3);
        Equipo equipo4 = new Equipo("Equipo 4", atletas4);
        
        //Con ejecucion simultanea
        /*
        Progress frame = new Progress();
        frame.pack();
        frame.setLocation(200, 200);
        frame.setVisible(true);
        //frame.getBarra().setValue(50);
        /*
        Progress frame2 = new Progress();
        frame2.pack();
        frame2.setLocation(200, 200);
        frame2.setVisible(true);
        */
        CarrilThread carril01 = new CarrilThread(" 01 ", equipo1, init);
        CarrilThread carril02 = new CarrilThread(" 02 ", equipo2, init);
        CarrilThread carril03 = new CarrilThread(" 03 ", equipo3, init);
        CarrilThread carril04 = new CarrilThread(" 04 ", equipo4, init);
        
        
        carril01.start();
        carril02.start();
        carril03.start();
        carril04.start();
        
        //frame.iterate(var1*100,(var1/100));
        //frame2.iterate(var2*100, (var2/100));
        
        
     
        
        //Con Runnable
        /*
        Carril carr1 = new Carril("01");
        Carril carr2 = new Carril("02");
        
        Runnable proceso1 = new CarreraRelevos(equipo1, carr1, init);
        Runnable proceso2 = new CarreraRelevos(equipo2, carr2, init);
        
        Thread p1 = new Thread(proceso1);
        Thread p2 = new Thread(proceso2);
        
        p1.start();
        p2.start();
        */
         
        //Con ejecucion individual
        /*
        Carril carr1 = new Carril("01");
        Carril carr2 = new Carril("02");        
        
        carr1.beginRace(equipo1, init);
        carr2.beginRace(equipo1, init);
        */
                
        
        
        
        /*
        
        Progress frame2 = new Progress();
        
        frame2.iterate(var2*100);
        
        Progress frame3 = new Progress();
        frame3.pack();
        frame3.setLocation(300, 300);
        frame3.setVisible(true);
        frame3.iterate(var3*100);
        
        Progress frame4 = new Progress();
        frame4.pack();
        frame4.setLocation(400, 400);
        frame4.setVisible(true);
        frame4.iterate(var4*100);
        */
             
                
    }
    //Runnable method
    @Override
    public void run() {
        this.carril.beginRace(this.equipo, this.initialTime);
    }
    
    public static int sumar(ArrayList<Integer> arr) {
        int suma=0;
        
        for (int i = 0; i<arr.size(); i++) {
            suma += arr.get(i);
        }
        return suma;
    }
    
    public static int sumar(int[] arr) {
        int suma=0;
        
        for (int i = 0; i<arr.length; i++) {
            suma += arr[i];
        }
        return suma;
    }
    
    private static int randomInt(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
    }
    
    private static ArrayList<Integer> agregar(int suma, ArrayList<Integer> atletas){
        int random = 0;
        while(suma<=45) {
            atletas.add(random);
            suma = sumar(atletas);
            System.out.println(suma);
            random = randomInt(15,25);
        }
        return atletas;
    }
    
    private static int[] agregarAtletas(int[] equipo) {
        for(int i = 0; i<equipo.length; i++) {
            equipo[i] = randomInt(15,20);
            System.out.println(equipo[i]);
        }    
        return equipo;
    }
    
}
