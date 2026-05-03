/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadrelay;

/**
 *
 * @author augus
 */
public class Testimone {
    private int stato = 1; 


    public synchronized void passaTestimone(int attuale) {
        if (this.stato == attuale) {
            this.stato++; 
            notifyAll();
        }
    }

    public synchronized int getStato() {
        return stato;
    }
}
