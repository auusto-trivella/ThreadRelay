/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package threadrelay;

/**
 *
 * @author delfo
 */
public class ThreadRelay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Atleta a1= new Atleta(0,0);
        Atleta a2= new Atleta(0,0);
        Atleta a3= new Atleta(0,0);
        Atleta a4= new Atleta(0,0);
        
        a1.start();
        a2.start();
        a3.start();
        a4.start();
    }
    
}
