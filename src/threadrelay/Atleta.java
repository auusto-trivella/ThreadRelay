/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threadrelay;

/**
 *
 * @author trivella.augusto
 */
public class Atleta extends Thread {
    
    IntBox box;
    int id;

    public Atleta(IntBox box, int id) {
        this.box = box;
        this.id = id;
    }
    public void run(){
        while(true){
            
        }
    }
}
