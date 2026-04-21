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
    int runner;

    public Atleta(IntBox box, int runner) {
        this.box = box;
        this.runner = runner;
    }
    public void run(){
        while(true){
            if(box.stato==0){
                box.stato=runner;
                System.out.println("l'atleta "+runner+" ha il testimone");
                try{Thread.sleep(1000);}
                catch(Exception e){}
                System.out.println("l'atleta "+runner+" ha passato testimone");//deve passarlo quando arriva a 90
                runner++;//forse devo far aumentare lo stato e non il runner
            }
            else{
                
            }
        }
    }
}
